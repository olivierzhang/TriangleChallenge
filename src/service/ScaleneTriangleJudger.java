package service;

import dto.ScaleneTriangle;
import dto.Triangle;
import exception.ErrorCode;
import exception.IllegalConditionException;

import java.math.BigDecimal;

public class ScaleneTriangleJudger extends TriangleJudger {

    @Override
    public Triangle judgeTriangleBySides(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
        if (!isTriangle(side1, side2, side3)) {
            throw new IllegalConditionException(ErrorCode.ILLEGAL_TRIANGLE);
        }

        if (side1.compareTo(side2) != 0 && side1.compareTo(side3) != 0 && side2.compareTo(side3) != 0) {
            return new ScaleneTriangle(side1, side2, side3);
        } else return null;
    }
}
