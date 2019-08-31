package org.schools.students.utils;
import java.util.Random;
public class UsefulUtils {


    public static int getRandomNumber(){
        Random rd = new Random();
        return rd.nextInt();
    }

    public static void main(String[]args){
        System.out.println(getRandomNumber());
    }
}
