package dto;

import java.math.BigDecimal;

public abstract class Triangle implements Shape {

    BigDecimal side1;
    BigDecimal side2;
    BigDecimal side3;

    TriangleType type;

    public TriangleType getTriangleType() {
        return type;
    }

    public double getTriangleArea() {
        //Heron's Formula
        BigDecimal halfPerimeter = side1.add(side2).add(side3).divide(new BigDecimal(2));
        BigDecimal areaSquare = halfPerimeter
                .multiply(halfPerimeter.subtract(side1))
                .multiply(halfPerimeter.subtract(side2)
                        .multiply(halfPerimeter.subtract(side3)));
        return Math.sqrt(areaSquare.doubleValue());
    }

    public double getTrianglePerimeter() {
        return side1.add(side2).add(side3).doubleValue();
    }
    
    public abstract String getDescription();
}
