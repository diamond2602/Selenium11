package TESTNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("FirstName")//if it is just one

    @Test(priority = 2, invocationCount = 10) //  invocationCount = 10 how many times it will run
    public void test(String name){
        System.out.println(name);
    }

    @Parameters({"City", "State"}) // if it is more than 1

    @Test(priority = 1, invocationTimeOut = 2000) //priority = 1 is which one will run first (order) invocationTimeOut = 2000) it will wait 2 sec and fail
    public void test1(String city, String state){
        System.out.println(city);
        System.out.println(state);
    }

}
