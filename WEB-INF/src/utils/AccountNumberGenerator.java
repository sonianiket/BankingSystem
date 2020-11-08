package utils;

import java.util.Random;

public class AccountNumberGenerator{
	public static String getaccountNumber(){
		Random r = new Random();
		StringBuffer sf = new StringBuffer();
		for(int i=0; i<10; i++){
			sf.append(r.nextInt(9)+1);
		}
		System.out.println(sf);
		return sf.toString();
	}
}