package dto;

import java.math.BigDecimal;

public class IsoscelesTriangle extends Triangle {

    public IsoscelesTriangle(BigDecimal legSide, BigDecimal baseSide) {
        this.side1 = legSide;
        this.side2 = legSide;
        this.side3 = baseSide;
        this.type = TriangleType.ISOSCELES;
    }

    public void setLegSide(BigDecimal legSide) {
        this.side1 = legSide;
        this.side2 = legSide;
    }

    public void setBaseSide(BigDecimal baseSide) {
        this.side3 = baseSide;
    }

    public BigDecimal getLegSide() {
        return side1;
    }

    public BigDecimal getBaseSide() {
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
        return "Isosceles Triangle, the length of its leg sides are : " + side1.toString() + ", the length of its base side is : " + side3.toString();
    }
}
