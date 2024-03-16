package com.example.rental.framework.web.dto;


import com.example.rental.domain.model.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentItemOutputDTO {

    private Integer itemNo;
    private String itemTitle;
    private LocalDate rentDate;
    private boolean overdued;
    private LocalDate overdueDate;

    public static RentItemOutputDTO mapToDTO(RentalItem rentalItem) {
        RentItemOutputDTO rentItemOutputDTO = new RentItemOutputDTO();
        rentItemOutputDTO.setItemNo(rentalItem.getItem().getNo());
        rentItemOutputDTO.setItemTitle(rentalItem.getItem().getTitle());
        rentItemOutputDTO.setRentDate(rentalItem.getRentDate());
        rentItemOutputDTO.setOverdued(rentalItem.isOverdued());
        rentItemOutputDTO.setOverdueDate(rentalItem.getOverdueDate());
        return rentItemOutputDTO;
    }

}
