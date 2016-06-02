package service;

import dto.IsoscelesTriangle;
import dto.Triangle;
import exception.ErrorCode;
import exception.OutOfRangeException;

import java.math.BigDecimal;

public class IsoscelesTriangleJudger extends TriangleJudger {

    @Override
    public Triangle judgeTriangleBySides(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
        if (!isTriangle(side1, side2, side3)) {
            throw new OutOfRangeException(ErrorCode.ILLEGAL_TRIANGLE);
        }
        
        if (side1.compareTo(side2) == 0 && side2.compareTo(side3) != 0) {
            return new IsoscelesTriangle(side1, side3);
        } else if (side1.compareTo(side3) == 0 && side3.compareTo(side2) != 0) {
            return new IsoscelesTriangle(side1, side2);
        } else if (side2.compareTo(side3) == 0 && side3.compareTo(side1) != 0) {
            return new IsoscelesTriangle(side2, side1);
        } else return null;
    }
}
