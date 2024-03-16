package com.example.rental.application.input_port;

import com.example.rental.application.output_port.RentalCardOutputPort;
import com.example.rental.application.use_case.ClearOverdueItemUsecase;
import com.example.rental.domain.model.RentalCard;
import com.example.rental.framework.web.dto.ClearOverdueInfoDTO;
import com.example.rental.framework.web.dto.RentalResultOutputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(clearOverdueInfoDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        rentalCard.makeAvailableRental(clearOverdueInfoDTO.getPoint());
        return RentalResultOutputDTO.mapToDTO(rentalCard);
    }
}
