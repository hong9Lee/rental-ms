package com.example.rental.application.input_port;

import com.example.rental.application.output_port.EventOutputPort;
import com.example.rental.application.output_port.RentalCardOutputPort;
import com.example.rental.application.use_case.CompensationUsecase;
import com.example.rental.domain.model.RentalCard;
import com.example.rental.domain.model.event.PointUseCommand;
import com.example.rental.domain.model.vo.IDName;
import com.example.rental.domain.model.vo.Item;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompensationInputPort implements CompensationUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCard cancelRentItem(IDName idName, Item item) {
        return rentalCardOutputPort.loadRentalCard(idName.getId())
                .map(rentalCard -> {
                    try {
                        rentalCard.cancelRentItem(item);
                        eventOutputPort.occurPointUserCommand(new PointUseCommand(idName, 10L));
                        return rentalCard;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new NoSuchElementException("렌탈 카드가 없습니다."));
    }

    @Override
    public RentalCard cancelReturnItem(IDName idName, Item item, long point) {
        return rentalCardOutputPort.loadRentalCard(idName.getId())
                .map(rentalCard -> {
                    try {
                        rentalCard.cancelReturnItem(item, point);
                        eventOutputPort.occurPointUserCommand(new
                                PointUseCommand(idName, point));
                        return rentalCard;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new NoSuchElementException("Rental card not found for ID: " + idName.getId()));
    }

    @Override
    public long cancelMakeAvailableRental(IDName idName, long point) {
        return rentalCardOutputPort.loadRentalCard(idName.getId())
                .map(rentalCard -> {
                    try {
                        return rentalCard.cancelMakeAvailableRental(point); // 별도로 포인트 사용취소를 보상하기위한 이벤트는 발행하지 않음.
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new NoSuchElementException("Rental card not found for ID: " + idName.getId()));
    }
}
