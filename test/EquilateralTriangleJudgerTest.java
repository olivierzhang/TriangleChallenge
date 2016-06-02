import dto.EquilateralTriangle;
import dto.IsoscelesTriangle;
import dto.ScaleneTriangle;
import exception.OutOfRangeException;
import org.junit.Before;
import org.junit.Test;
import service.EquilateralTriangleJudger;
import util.TriangleGenerator;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EquilateralTriangleJudgerTest {

    private EquilateralTriangleJudger equilateralTriangleJudger;
    private TriangleGenerator triangleGenerator;

    @Before
    public void setUp() {
        equilateralTriangleJudger = new EquilateralTriangleJudger();
        triangleGenerator = new TriangleGenerator();
    }

    @Test
    public void judge_method_should_return_equilateral_triangle_when_input_three_equal_sides() {
        EquilateralTriangle equilateralTriangle = triangleGenerator.generateEquilateral();
        BigDecimal side = equilateralTriangle.getSide();
        assertEquals(equilateralTriangleJudger.judgeTriangleBySides(side, side, side).getClass(), EquilateralTriangle.class);
    }

    @Test
    public void judge_method_should_return_null_when_input_three_sides_and_two_of_them_are_equal() {
        IsoscelesTriangle isoscelesTriangle = triangleGenerator.generateIsosceles();
        BigDecimal legSide = isoscelesTriangle.getLegSide();
        BigDecimal baseSide = isoscelesTriangle.getBaseSide();
        assertNull(equilateralTriangleJudger.judgeTriangleBySides(legSide, legSide, baseSide));
    }

    @Test
    public void judge_method_should_return_null_when_input_three_different_sides() {
        ScaleneTriangle scaleneTriangle = triangleGenerator.generateScalene();
        BigDecimal side1 = scaleneTriangle.getSide1();
        BigDecimal side2 = scaleneTriangle.getSide2();
        BigDecimal side3 = scaleneTriangle.getSide3();
        assertNull(equilateralTriangleJudger.judgeTriangleBySides(side1, side2, side3));
    }

    @Test(expected = OutOfRangeException.class)
    public void illegal_condition_exception_should_be_thrown_when_the_given_three_sides_can_not_combine_a_triangle() {
        BigDecimal side1 = new BigDecimal(new Random().nextDouble() * 100 + 1);
        BigDecimal side2 = side1.multiply(new BigDecimal(2));
        BigDecimal side3 = side1.multiply(new BigDecimal(4));
        equilateralTriangleJudger.judgeTriangleBySides(side1, side2, side3);
    }
}
