import dto.EquilateralTriangle;
import dto.IsoscelesTriangle;
import dto.ScaleneTriangle;
import exception.IllegalConditionException;
import org.junit.Before;
import org.junit.Test;
import service.ScaleneTriangleJudger;
import util.TriangleGenerator;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ScaleneTriangleJudgerTest {
    private ScaleneTriangleJudger scaleneTriangleJudger;
    private TriangleGenerator triangleGenerator;

    @Before
    public void setUp() {
        scaleneTriangleJudger = new ScaleneTriangleJudger();
        triangleGenerator = new TriangleGenerator();
    }

    @Test
    public void judge_method_should_return_scalene_triangle_when_input_three_different_sides() {
        ScaleneTriangle scaleneTriangle = triangleGenerator.generateScalene();
        BigDecimal side1 = scaleneTriangle.getSide1();
        BigDecimal side2 = scaleneTriangle.getSide2();
        BigDecimal side3 = scaleneTriangle.getSide3();
        assertEquals(scaleneTriangleJudger.judgeTriangleBySides(side1, side2, side3).getClass(), ScaleneTriangle.class);
    }

    @Test
    public void judge_method_should_return_null_when_input_three_sides_and_two_of_them_are_equal() {
        IsoscelesTriangle isoscelesTriangle = triangleGenerator.generateIsosceles();
        BigDecimal side1 = isoscelesTriangle.getLegSide();
        BigDecimal side2 = isoscelesTriangle.getBaseSide();
        assertNull(scaleneTriangleJudger.judgeTriangleBySides(side1, side1, side2));
    }

    @Test
    public void judge_method_should_return_null_when_input_three_equal_sides() {
        EquilateralTriangle equilateralTriangle = triangleGenerator.generateEquilateral();
        BigDecimal side = equilateralTriangle.getSide();
        assertNull(scaleneTriangleJudger.judgeTriangleBySides(side, side, side));
    }

    @Test(expected = IllegalConditionException.class)
    public void illegal_condition_exception_should_be_thrown_when_the_given_three_sides_can_not_combine_a_triangle() {
        BigDecimal side1 = new BigDecimal(new Random().nextDouble() * 100 + 1);
        BigDecimal side2 = side1.multiply(new BigDecimal(2));
        BigDecimal side3 = side1.multiply(new BigDecimal(4));
        scaleneTriangleJudger.judgeTriangleBySides(side1, side2, side3);
    }
}
