import exception.IllegalFormatException;
import exception.OutOfRangeException;
import org.junit.Before;
import org.junit.Test;

public class TriangleChallengeTest {
    private TriangleChallenge triangleChallenge;

    @Before
    public void setUp() {
        triangleChallenge = new TriangleChallenge();
    }

    @Test(expected = OutOfRangeException.class)
    public void out_of_range_exception_should_be_thrown_when_input_length_is_zero() {
        String input = "0.0,1,2";
        triangleChallenge.getLengths(input);
    }

    @Test(expected = IllegalFormatException.class)
    public void illegal_format_exception_should_be_thrown_when_the_number_of_input_length_is_not_three() {
        String input = "0.0,1,2,5";
        triangleChallenge.getLengths(input);
    }

    @Test(expected = IllegalFormatException.class)
    public void illegal_format_exception_should_be_thrown_when_the_input_length_contains_illegal_character(){
        String input = "4a,2,5";
        triangleChallenge.getLengths(input);
    }
}
