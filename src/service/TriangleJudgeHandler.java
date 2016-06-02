package service;

import dto.Triangle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TriangleJudgeHandler {
    private List<TriangleJudger> triangleJudgerList = new ArrayList<>();

    public TriangleJudgeHandler() {
        EquilateralTriangleJudger equilateralTriangleJudger = new EquilateralTriangleJudger();
        IsoscelesTriangleJudger isoscelesTriangleJudger = new IsoscelesTriangleJudger();
        ScaleneTriangleJudger scaleneTriangleJudger = new ScaleneTriangleJudger();

        triangleJudgerList.add(equilateralTriangleJudger);
        triangleJudgerList.add(isoscelesTriangleJudger);
        triangleJudgerList.add(scaleneTriangleJudger);
    }

    public Triangle judgeTriangle(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
        Triangle triangle;
        for (TriangleJudger judger : triangleJudgerList) {
            triangle = judger.judgeTriangleBySides(side1, side2, side3);
            if (triangle != null) {
                return triangle;
            }
        }
        return null;
    }
}
