package com.example.rental.application.use_case;

import com.example.rental.framework.web.dto.ClearOverdueInfoDTO;
import com.example.rental.framework.web.dto.RentalResultOutputDTO;

public interface ClearOverdueItemUsecase {
    RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception;
}
