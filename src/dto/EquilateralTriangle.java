package dto;

import java.math.BigDecimal;

public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(BigDecimal side) {
        this.side1 = side;
        this.side2 = side;
        this.side3 = side;
        this.type = TriangleType.EQUILATERAL;
    }

    public void setSide(BigDecimal side) {
        this.side1 = side;
        this.side2 = side;
        this.side3 = side;
    }

    public BigDecimal getSide() {
        return side1;
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
        return "Equilateral Triangle, the length of its 3 sides are : " + side1.toString();
    }

}
