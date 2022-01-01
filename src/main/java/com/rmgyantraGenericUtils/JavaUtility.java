package com.rmgyantraGenericUtils;

import java.util.Random;

public class JavaUtility {
/**
 * This will generate random number
 */
	public int randomNumber() {
			Random ran = new Random();
			int randomno=ran.nextInt(5000);
			return randomno;
		}
		}
