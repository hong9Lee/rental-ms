package com.example.rental.application.input_port;

import com.example.rental.application.output_port.RentalCardOutputPort;
import com.example.rental.application.use_case.CreateRentalCardUsecase;
import com.example.rental.domain.model.RentalCard;
import com.example.rental.domain.model.vo.IDName;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserInputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO) {
        RentalCard rentalCard = RentalCard.createRentalCard(new IDName(userInputDTO.getUserId(), userInputDTO.getUserNm()));
        RentalCard save = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(save);
    }
}
