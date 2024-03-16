package com.example.rental.framework.web.dto;

import com.example.rental.domain.model.RentalCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalResultOutputDTO {

    private String userId;
    private String userNm;
    private Integer rentedCount;
    private long totalLateFee;

    public static RentalResultOutputDTO mapToDTO(RentalCard rentalCard) {
        RentalResultOutputDTO rentDTO = new RentalResultOutputDTO();
        rentDTO.setUserId(rentalCard.getMember().getId());
        rentDTO.setUserNm(rentalCard.getMember().getName());
        rentDTO.setRentedCount(rentalCard.getRentalItemList().size());
        rentDTO.setTotalLateFee(rentalCard.getReturnItemList().size());
        return rentDTO;
    }


}
