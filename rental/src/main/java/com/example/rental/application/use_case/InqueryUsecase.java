package com.example.rental.application.use_case;

import com.example.rental.framework.web.dto.RentItemOutputDTO;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.ReturnItemOutputDTO;
import com.example.rental.framework.web.dto.UserInputDTO;

import java.util.List;
import java.util.Optional;

public interface InqueryUsecase {
    Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO);

    Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO);

    Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO);
}
