package genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * it contains java specific libraries like getRandomdata & getSystemdate
	 * @Manasa
	 */
	public int getrandominteger()
	{
		/**
		 * @Manasa
		 * it is used to generate random number within the range of 1000
		 */
		Random ran=new Random();
		int rannum=ran.nextInt(1000);
		return rannum;
		
	}
	
	/**
	 * it is used to get current system date based on yyyy-mm-dd formate
	 * @Manasa
	 */
	public String getSystemDate(){
		Date date=new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr=currentDate.split("");
		String yyyy=arr[5];
		String dd=arr[2];
		int mm=date.getMonth()+1;
		String formate = yyyy+"-"+mm+"-"+dd;
		return formate;
	}
	
	/**
	 * it is used to get current system date based on dd-mm-yyyy format
	 * @Manasa
	 */
	public String getSystemDateInISTD()
	{
		Date date=new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr=currentDate.split("");
		String yyyy=arr[5];
		String dd=arr[2];
		int mm=date.getMonth()+1;
		String formate = dd+"-"+mm+"-"+yyyy;
		return formate;
		
	}

}
