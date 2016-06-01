import dto.Triangle;
import exception.ErrorCode;
import exception.IllegalConditionException;
import service.TriangleJudgeHandler;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class TriangleChallenge {
    private static TriangleJudgeHandler triangleJudgeHandler;
    private static ArrayList<String> outputList = new ArrayList<>();

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
            for (String line : outputList) {
                writer.write(line);
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

    private static void judge(String inputLine) {
        String[] sides = inputLine.split(",");
        BigDecimal side1;
        BigDecimal side2;
        BigDecimal side3;
        try {
            side1 = new BigDecimal(sides[0]);
            side2 = new BigDecimal(sides[1]);
            side3 = new BigDecimal(sides[2]);
        } catch (NumberFormatException e) {
            outputList.add(ErrorCode.ILLEGAL_INPUT.getDescription());
            return;
        }
        try {
            Triangle triangle = triangleJudgeHandler.judgeTriangle(side1, side2, side3);
            outputList.add(triangle.getTriangleType().getName());
        } catch (IllegalConditionException e) {
            outputList.add(ErrorCode.ILLEGAL_TRIANGLE.getDescription());
        }
    }
}
