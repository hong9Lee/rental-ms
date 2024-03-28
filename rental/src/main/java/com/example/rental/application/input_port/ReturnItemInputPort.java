package com.example.rental.application.input_port;

import com.example.rental.application.output_port.EventOutputPort;
import com.example.rental.application.output_port.RentalCardOutputPort;
import com.example.rental.application.use_case.ReturnItemUsecase;
import com.example.rental.domain.model.RentalCard;
import com.example.rental.domain.model.event.ItemRented;
import com.example.rental.domain.model.event.ItemReturned;
import com.example.rental.domain.model.vo.Item;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnItemInputPort implements ReturnItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDTO) throws JsonProcessingException {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(returnDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        Item returnItem = new Item(returnDTO.getItemId(), returnDTO.getItemTitle());
        rentalCard.returnItem(returnItem, LocalDate.now());
        ItemReturned itemReturnEvent = RentalCard.createItemReturnEvent(rentalCard.getMember(), returnItem, 10L);
        eventOutputPort.occurReturnEvent(itemReturnEvent);
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
