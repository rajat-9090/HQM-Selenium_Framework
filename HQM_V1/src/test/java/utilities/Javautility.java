package utilities;

import java.util.Random;

public class Javautility {

	public static String generateRandomString() {

		int length = 4;

		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		StringBuilder randomString = new StringBuilder();

		Random random = new Random();

		for (int i = 0; i < length; i++) {

			int index = random.nextInt(characters.length());
			randomString.append(characters.charAt(index));
		}

		return randomString.toString();
	}
	
	
	public static int getRandomNum()
	{
		Random ran = new Random();
		
		int rannum = ran.nextInt(1000);
		return rannum;
		
	}

}
