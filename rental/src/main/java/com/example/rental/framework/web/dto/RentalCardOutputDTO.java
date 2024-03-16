package com.example.rental.framework.web.dto;

import com.example.rental.domain.model.RentalCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalCardOutputDTO {

    private String rentalCardId;
    private String memberId;
    private String memberName;
    private String rentStatus;
    private Long totalLateFee; // 전체 대여 도서건수
    private Long totalRentalCnt; // 반납 도서건수
    private Long totalReturnCnt; // 연체중인 도서건수
    private Long totalOverduedCnt;

    public static RentalCardOutputDTO mapToDTO(RentalCard rentalCard) {
        RentalCardOutputDTO rentDTO = new RentalCardOutputDTO();
        rentDTO.setRentalCardId(rentalCard.getRentalCardNo().toString());
        rentDTO.setMemberId(rentalCard.getMember().getId().toString());
        rentDTO.setMemberName(rentalCard.getMember().getName());
        rentDTO.setRentStatus(rentalCard.getRentStatus().toString());
        rentDTO.setTotalRentalCnt(rentalCard.getRentalItemList().stream().count());
        rentDTO.setTotalReturnCnt(rentalCard.getReturnItemList().stream().count());
        rentDTO.setTotalOverduedCnt(rentalCard.getRentalItemList().stream().filter(i -> i.isOverdued()).count());
        return rentDTO;

    }

}
