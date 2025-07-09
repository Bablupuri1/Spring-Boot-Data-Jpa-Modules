package com.ecom.generatepassword;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GeneratePassword {

	String str="QWERTYUIOPASDFGHJKLZXCVB";
	StringBuffer password=new StringBuffer(str.length());
	public String generatePassword() {
		Random random = new Random();
		for(int i=0;i<8;i++) {
			 int randomIndex = random.nextInt(str.length());
			 password.append(str.charAt(randomIndex));

		}
		return password.toString();
	}

}
