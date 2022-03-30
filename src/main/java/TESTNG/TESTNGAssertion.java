package TESTNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TESTNGAssertion {
    // create one methgod that takes to parameter and return the
    //multiplication of these numbers



    public double getMulti(double number1,double number2){
        return number1*number2;
    }

    @Test
    public void validateMultiplcation(){
        double ActualResult=getMulti(5,6);
        double ExpectedResult=30;
//        if(ActualResult==ExpectedResult){
//            System.out.println("passed");
//        }
        // it is goin to show uo it fails(message)
        Assert.assertEquals(ActualResult,ExpectedResult,"my numbers are 5 and 6");
    }
    public  double getDivision(double number1, double number2){
        if(number1>number2){
            return number1/number2;
        }else {
            return number2/number1;
        }
    }
    public  int substraction(int number1, int number2){
        if(number1>number2){
            return number1-number2;
        }else {
            return number2-number1;
        }
    }
    @Test
    public void validateDivision(){
        double actualResult=getDivision(8,2);
        double expectedResult=4;
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void validateSubstraction(){
        int actualResult= substraction(65,43);
        int expectedResult=22;

        Assert.assertEquals(actualResult,expectedResult);
        double actualResultOfDivision=getDivision(6,3);
                double expectedResultOfDivision=2;
                Assert.assertEquals(actualResultOfDivision,expectedResultOfDivision);
    }

}
