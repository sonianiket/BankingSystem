package utils;

import java.util.Random;

public class GenerateOTP{
	public static String otpGeneration(){
		Random r = new Random();
		StringBuffer sf = new StringBuffer();
		for(int i=0; i<6; i++){
			sf.append(r.nextInt(9)+1);
		}
		return sf.toString();
	} 

	public static String captchaOtpGeneration(){
		Random r = new Random();
		StringBuffer sf = new StringBuffer();
		for(int i=0; i<12; i++){
			int num = r.nextInt(123);
			if(num>=97){
				char c = (char)num;	
				sf.append(c);
			}	
		}
		System.out.println(sf.toString().length()+"CAPTCHA LENGth******************************");

		return sf.toString();
	} 
}