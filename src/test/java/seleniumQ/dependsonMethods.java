package seleniumQ;

import org.testng.annotations.Test;

public class dependsonMethods {
	public class prioprity {
		@Test
		public void create() {
			System.out.println("execute create");
		}
		
		@Test(dependsOnMethods  ="create")
		public void modifycreate() {
			System.out.println(" execute modcreate");
		}
		@Test(dependsOnMethods  ="modifycreate")
		public void deletecreate() {
			System.out.println("execute deletecreate");
		}
	}


}
