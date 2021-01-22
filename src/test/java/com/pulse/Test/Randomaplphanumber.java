package com.pulse.Test;

import java.security.SecureRandom;
import java.util.Random;

import org.testng.annotations.Test;



import org.apache.commons.lang3.RandomStringUtils;

public class Randomaplphanumber{

 
	@Test
	public String Random () 
	
	{

        // Random string only with numbers
 String string= RandomStringUtils.random(6, false, true);




  //System.out.println("Random 0 = " + string);
  
  
  return  string;
  
  

  // Random alphabetic string

 

  //string = RandomStringUtils.randomAlphabetic(64);

  //String s = RandomStringUtils.randomAlphanumeric(4);


//  System.out.println("Random 1 = " + s);

  
//return  s;

  // Random ASCII string


  // Create a random string with indexes from the given array of chars 


    }

}