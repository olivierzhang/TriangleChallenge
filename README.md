# TriangleChallenge

 This program could determine the type of a triangle. 
 
 It takes the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.
 
 You can always provide input in the `input.txt` file, then run `TriangleChallenge`, finally the result will be recorded in the `output.txt` file.
 
# Scalability and low coupling 

 Considering scalability and low coupling, the program was designed as a big project which may be changed and updated in the future.
 
 - Different DTOs for different types of shape. 
   `Triangle` is an implementation of `Shape` interface, it also has subclasses for different triangle types. 
 
 - Split judge logic to different judger class.
   For example `EquilateralTriangleJudger`, `IsoscelesTriangleJudger`, `ScaleneTriangleJudger`. They all extends `TriangleJudger`.
   We don't need change code if we want to add more type judger in future.

# Error cases
 
 There are some rules when program dealing with the data, exceptions will be thrown when error occurs.
 
 - Input a string contains 3 length values separated by comma, there shouldn't be any other characters except comma, number and decimal point.
   
 - Every value should be bigger than zero.
 
 - An integer shouldn't start with zero.
 
 - A decimal shouldn't start with zero unless it has only one digit before decimal point and the digit is zero.
 
 - Exceptions will be thrown if any error occur. You can get more detail in the `output.txt` file. 
 
# Tests

 The major logic of program has been tested by unit test cases. 