package com.crm.genericutilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @authorGagan
 *
 */


public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throwsThrowable
	 */
public String getPropertyKeyValue(String key) throws Throwable {
	FileInputStream fis = new FileInputStream("./data/Data2.properties");//here we will get the java representative object using FILEINPUTSTREAM
	Properties pobj = new Properties();//(property class is java class which is used to store the data IN THE FORM OF "KEY AND VALUES")//in this step we will create the object for PROPERTY CLASS
	pobj.load(fis);//Here we will load all the data into property class
	 String value = pobj.getProperty(key);
		return value;
	
    }
}



