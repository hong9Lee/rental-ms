package com.example.rental.application.output_port;

import com.example.rental.domain.model.event.ItemRented;
import com.example.rental.domain.model.event.ItemReturned;
import com.example.rental.domain.model.event.OverdueCleared;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface EventOutputPort {
    void occurRentalEvent(ItemRented rentalItemEvent) throws JsonProcessingException;
    void occurReturnEvent(ItemReturned itemReturnedEvent) throws JsonProcessingException;
    void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException;
}
