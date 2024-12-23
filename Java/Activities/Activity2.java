package hello;

import java.util.Arrays;

public class Activity2 {
 public static void main (String[] args) {
	 int[] numbers = {10, 77, 10, 54, -11, 10};

     // Find the 10's in the array and add them
     int sum = 0;
     for (int num : numbers) {
         if (num == 10) {
             sum =sum+ num;
         }
     }

     // Check if the sum of all 10's is exactly 30
     if (sum == 30) {
         System.out.println("true");
     } else {
         System.out.println("false");
     }
 }
}