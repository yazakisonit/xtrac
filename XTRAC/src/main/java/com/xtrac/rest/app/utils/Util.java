package com.xtrac.rest.app.utils;

import java.util.Random;

public class Util {
	  private static final String CHAR_LIST =
		        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	  private static final int RANDOM_STRING_LENGTH = 10;
	  private static String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	public static boolean validationEmail(String emailId){

		
		
		System.out.println("emailId in Utils >>" + emailId);
		
		Boolean flag = emailId.matches(EMAIL_REGEX);
		System.out.println("is e-mail: "+emailId+" :Valid = " + flag);
		
		return flag;		
	}
	
	public static int randomNoGeneration() {
		  int randomInt = 0;
		  Random randomGenerator = new Random();
		    for (int idx = 1; idx <= 10; ++idx){
		      randomInt = randomGenerator.nextInt(100);
		      
		    }
		    System.out.println("Generated : " + randomInt);
		    return randomInt;
	}
	
	public static String randomPwdGeneration() {
		StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        System.out.println("randStr : " + randStr.toString());
        return randStr.toString();

	}
	
	 private static int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
	     
	
}
