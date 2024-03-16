package com.example.rental.application.use_case;

import com.example.rental.framework.web.dto.UserInputDTO;
import com.example.rental.framework.web.dto.RentalCardOutputDTO;

public interface CreateRentalCardUsecase {
    RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO);
}
