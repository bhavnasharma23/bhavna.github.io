/*
Question No. 2) Write a function which will returns the maximum number of words in a sentence.
Given text can be divided into sentences by splitting it at dots, question marks and exclamation 
marks.
For example, 
given S= "We test coders. Give us a try?", the function should return 4.*/

package test.fresher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountMaxSent {

	public static void main(String[] args) {
		 BufferedReader br = null;

	        try {

	            br = new BufferedReader(new InputStreamReader(System.in));

	            String input = br.readLine();
	            String[] splitOne = input.split("[.?!]+");
	    		int max = Integer.MIN_VALUE;
	    		for(String s: splitOne)
	    		{
	    			String[] splitTwo = s.trim().split(" +");
	    			if(max<splitTwo.length)
	    			{
	    				max = splitTwo.length;
	    			}
	    			
	    		}
	    		System.out.println("Lenght is "+max);

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }

	}

/*Input - "We test coders. Give us a try?
Output is -"Lenght is 4"*/


