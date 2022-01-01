package practice1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositorylib.BaseClassUtility;
@Listeners(com.crm.genericutilities.ListnerImplementation.class)//Path is from listnersImplementation class in gneric utility
public class ListnersPratice extends BaseClassUtility {
	@Test
	public void ListnersPratice() {
		System.out.println("Test Script Fail");
		Assert.fail();
	}

}
