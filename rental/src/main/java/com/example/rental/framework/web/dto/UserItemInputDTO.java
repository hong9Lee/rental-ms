package com.example.rental.framework.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserItemInputDTO {

    private String userId;
    private String userNm;
    private Integer itemId;
    private String itemTitle;

}
