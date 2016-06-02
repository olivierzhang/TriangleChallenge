package service;

import dto.Triangle;

import java.math.BigDecimal;

public abstract class TriangleJudger {

    //Check if the three sides could combine a triangle
    public boolean isTriangle(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
        return side1.add(side2).compareTo(side3) == 1 &&
                side1.add(side3).compareTo(side2) == 1 &&
                side2.add(side3).compareTo(side1) == 1;
    }

    public abstract Triangle judgeTriangleBySides(BigDecimal side1, BigDecimal side2, BigDecimal side3);
}
