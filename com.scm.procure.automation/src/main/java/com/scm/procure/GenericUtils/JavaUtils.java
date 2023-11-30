package com.scm.procure.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	
	
	public int getRandomNo() {
		Random ran = new Random();
		int random=ran.nextInt(500);
		return random;
			
	}
	
	public String systemDate() {
		Date date = new Date();
		String systemDate = date.toString();
		return systemDate;
	}
	
	public String dateFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM- yyyy HH-mm-ss");
		Date date = new Date();
		String systemDateFormat = dateFormat.format(date);
		return systemDateFormat;
		
		
	}
	

}
