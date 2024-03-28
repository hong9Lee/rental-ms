package com.example.rental.application.use_case;

import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RentItemUsecase {
    RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws JsonProcessingException;
}
