package util;

import dto.EquilateralTriangle;
import dto.IsoscelesTriangle;
import dto.ScaleneTriangle;

import java.math.BigDecimal;
import java.util.Random;

public class TriangleGenerator {

    public EquilateralTriangle generateEquilateral() {
        //Guarantee more than zero
        double x = new Random().nextDouble() * 100 + 1;
        return new EquilateralTriangle(new BigDecimal(x));
    }

    public IsoscelesTriangle generateIsosceles() {
        double x = new Random().nextDouble() * 100 + 1;
        //Guarantee the leg sides and base side are different
        double y = x / 2;
        return new IsoscelesTriangle(new BigDecimal(x), new BigDecimal(y));
    }

    public ScaleneTriangle generateScalene() {
        double x = new Random().nextDouble() * 100 + 1;
        //Guarantee the 3 sides are different
        double y = x / 2;
        double z = (x / 3) * 2;
        return new ScaleneTriangle(new BigDecimal(x), new BigDecimal(y), new BigDecimal(z));
    }
}
