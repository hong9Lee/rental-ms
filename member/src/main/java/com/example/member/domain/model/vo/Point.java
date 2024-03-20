package com.example.member.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {

    private long pointValue;

    public long addPoint(long point) {
        this.setPointValue(this.pointValue + point);
        return this.pointValue;
    }

    public long removePoint(long point) throws Exception {
        if (point > this.pointValue) {
            throw new Exception("포인트가 적습니다.");
        }

        this.setPointValue(this.pointValue - point);
        return this.pointValue;
    }

    public static Point createPoint() {
        return new Point(0L);
    }

}
