package com.example.rental.framework.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClearOverdueInfoDTO {

    private String userId;
    private String userNm;
    private Integer point;


}
