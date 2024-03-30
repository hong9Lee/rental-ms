package com.example.rental.application.use_case;

import com.example.rental.domain.model.RentalCard;
import com.example.rental.domain.model.vo.IDName;
import com.example.rental.domain.model.vo.Item;

public interface CompensationUsecase {
    RentalCard cancelRentItem(IDName idName, Item item);
    RentalCard cancelReturnItem(IDName idName, Item item, long point);
    long cancelMakeAvailableRental(IDName idName, long point);
}
