package service;

import dto.EquilateralTriangle;
import dto.Triangle;
import exception.ErrorCode;
import exception.OutOfRangeException;

import java.math.BigDecimal;

public class EquilateralTriangleJudger extends TriangleJudger {

    @Override
    public Triangle judgeTriangleBySides(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
        if (!isTriangle(side1, side2, side3)) {
            throw new OutOfRangeException(ErrorCode.ILLEGAL_TRIANGLE);
        }

        if (side1.compareTo(side2) == 0 && side1.compareTo(side3) == 0) {
            return new EquilateralTriangle(side1);
        } else return null;
    }
}
