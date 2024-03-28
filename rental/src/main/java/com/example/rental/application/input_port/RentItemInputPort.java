package com.example.rental.application.input_port;

import com.example.rental.application.output_port.EventOutputPort;
import com.example.rental.application.output_port.RentalCardOutputPort;
import com.example.rental.application.use_case.RentItemUsecase;
import com.example.rental.domain.model.RentalCard;
import com.example.rental.domain.model.event.ItemRented;
import com.example.rental.domain.model.vo.IDName;
import com.example.rental.domain.model.vo.Item;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class RentItemInputPort implements RentItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws JsonProcessingException {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.getUserId()).orElseGet(
                () -> RentalCard.createRentalCard(new IDName(rental.getUserId(), rental.getUserNm())));

        Item newItem = new Item(rental.getItemId(), rental.getItemTitle());
        /** 카드 발생과 이벤트 발생은 트랜잭션으로 보장되어야함. */
        rentalCard.rentItem(newItem);
        ItemRented itemRentedEvent = RentalCard.createItemRentedEvent(rentalCard.getMember(), newItem, 10L);
        eventOutputPort.occurRentalEvent(itemRentedEvent);

//        RentalCard save = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
