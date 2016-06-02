# TriangleChallenge

 This program could determine the type of a triangle. 
 It takes the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.
 
 You can always give the input in the input.txt file, then run the TriangleChallenge, finally the result will be recorded in the output.txt file.
 
 Considering the scalability and low coupling of program, I created dtos for the different type of shape.
 And I also split the judge logic to different judger class, it will be convenient if we want to add more type judger in future.
 
 As for the error cases, here is the rules:
 You need provide a string contains 3 length values separated by comma, there shouldn't be any other characters except comma, number and decimal point.
 Every value should be bigger than zero.
 An integer shouldn't start with zero.
 An decimal shouldn't start with zero unless it has only one digit before decimal point and the digit is zero.
 
 Exceptions will be thrown if any error occur. You can get more detail in the output.txt file. 
 