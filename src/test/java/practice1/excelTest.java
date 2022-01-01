package practice1;

import java.io.FileInputStream;

import org.testng.annotations.Test;

import com.crm.genericutilities.ExcelUtility;
import com.crm.genericutilities.FileUtility;

public class excelTest {
	@Test
public static void main(String[] args) throws Throwable {
	ExcelUtility elib=new ExcelUtility();
	FileUtility flib=new FileUtility();
	String GetNamE=elib.getData("Contact", 1, 1);
	System.out.println(GetNamE);
}
}
