import dto.Triangle;
import exception.ErrorCode;
import exception.IllegalFormatException;
import exception.OutOfRangeException;
import output.OutputRecord;
import service.TriangleJudgeHandler;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleChallenge {
    private static TriangleJudgeHandler triangleJudgeHandler;
    private static ArrayList<OutputRecord> outputList = new ArrayList<>();

    public static void main(String[] args) {
        triangleJudgeHandler = new TriangleJudgeHandler();
        readInputAndJudge();
        writeOutput();
    }

    private static void readInputAndJudge() {
        File file = new File("input.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                judge(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private static void writeOutput() {
        File file = new File("output.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (OutputRecord record : outputList) {
                writer.write(record.toString());
                writer.write("\n");
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void judge(String inputLine) {
        BigDecimal[] inputLengths;
        try {
            //Check the input's legality
            inputLengths = getLengths(inputLine);
        } catch (IllegalFormatException e1) {
            outputList.add(new OutputRecord(inputLine, e1.getErrorMessage(), true));
            return;
        } catch (OutOfRangeException e2) {
            outputList.add(new OutputRecord(inputLine, e2.getErrorMessage(), true));
            return;
        } catch (NumberFormatException e3) {
            outputList.add(new OutputRecord(inputLine, "Illegal number format for calculating", true));
            return;
        }

        try {
            Triangle triangle = triangleJudgeHandler.judgeTriangle(inputLengths[0], inputLengths[1], inputLengths[2]);
            outputList.add(new OutputRecord(inputLine, triangle.getTriangleType().getName(), false));
        } catch (OutOfRangeException e) {
            outputList.add(new OutputRecord(inputLine, e.getErrorMessage(), true));
        }
    }

    public static BigDecimal[] getLengths(String inputLine) {
        //Input data must contain 3 parts separated by ,
        String[] sides = inputLine.split(",");
        if (null == sides || sides.length != 3) {
            throw new IllegalFormatException(ErrorCode.ILLEGAL_INPUT_FORMAT);
        }
        //Input data only contains number and decimal point, integer shouldn't start with 0, decimal shouldn't start with .
        for (String side : sides) {
            Pattern pattern = Pattern.compile("^[1-9]\\d*|0(\\.\\d+)?|[1-9]\\d*(\\.\\d+)?$");
            Matcher matcher = pattern.matcher(side);
            if (!matcher.matches()) {
                throw new IllegalFormatException(ErrorCode.ILLEGAL_LENGTH_VALUE);
            }
        }
        //Trans input to BigDecimal
        BigDecimal side1 = new BigDecimal(sides[0]);
        BigDecimal side2 = new BigDecimal(sides[1]);
        BigDecimal side3 = new BigDecimal(sides[2]);

        // The length of triangle side shouldn't be less of zero
        BigDecimal zero = new BigDecimal(0);
        if (side1.compareTo(zero) <= 0 || side1.compareTo(zero) <= 0 || side1.compareTo(zero) <= 0) {
            throw new OutOfRangeException(ErrorCode.LENGTH_SHOULD_BIGGER_THAN_ZERO);
        }
        return new BigDecimal[]{side1, side2, side3};
    }

}
