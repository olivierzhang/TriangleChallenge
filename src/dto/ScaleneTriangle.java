package dto;

import java.math.BigDecimal;

public class ScaleneTriangle extends Triangle {

    public ScaleneTriangle(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.type = TriangleType.SCALENE;
    }

    public void setSide1(BigDecimal side1) {
        this.side1 = side1;
    }

    public void setSide2(BigDecimal side2) {
        this.side2 = side2;
    }

    public void setSide3(BigDecimal side3) {
        this.side3 = side3;
    }

    public BigDecimal getSide1() {
        return side1;
    }

    public BigDecimal getSide2() {
        return side2;
    }

    public BigDecimal getSide3() {
        return side3;
    }

    @Override
    public double getArea() {
        return getTriangleArea();
    }

    @Override
    public double getPerimeter() {
        return getTrianglePerimeter();
    }

    @Override
    public String getDescription() {
        return "Scalene Triangle, the length of its leg sides are : " + side1.toString() + ", " + side2.toString() + ", " + side3.toString();
    }

}
