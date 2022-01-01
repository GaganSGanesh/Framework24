package seleniumQ;

import org.testng.annotations.Test;

public class prioprity {
	@Test(groups= {"smoketest"})
	public void create() {
		System.out.println("execute create");
	}
	
	@Test(groups= {"regressiontest"})
	public void modifycreate() {
		System.out.println(" execute modcreate");
	}
	@Test(groups= {"regressiontest"})
	public void deletecreate() {
		System.out.println("execute deletecreate");
	}
}
