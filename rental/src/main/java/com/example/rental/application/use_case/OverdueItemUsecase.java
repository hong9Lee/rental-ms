package com.example.rental.application.use_case;

import com.example.rental.framework.web.dto.RentalCardOutputDTO;
import com.example.rental.framework.web.dto.UserItemInputDTO;

public interface OverdueItemUsecase {
    RentalCardOutputDTO overDueItem(UserItemInputDTO rental);
}
