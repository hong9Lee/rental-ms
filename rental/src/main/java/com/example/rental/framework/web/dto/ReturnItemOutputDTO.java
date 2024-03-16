package com.example.rental.framework.web.dto;

import com.example.rental.domain.model.vo.ReturnItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnItemOutputDTO {

    private Integer itemNo;
    private String itemTitle;
    private LocalDate returnDate;

    public static ReturnItemOutputDTO mapToDTO(ReturnItem returnItem) {
        ReturnItemOutputDTO returnItemOutputDTO = new ReturnItemOutputDTO();
        returnItemOutputDTO.setItemNo(returnItem.getRentalItem().getItem().getNo());
        returnItemOutputDTO.setItemTitle(returnItem.getRentalItem().getItem().getTitle());
        returnItemOutputDTO.setReturnDate(returnItem.getReturnDate());
        return returnItemOutputDTO;
    }
}
