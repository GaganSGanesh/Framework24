package com.vtiger.comcast.organizationTest;

import org.testng.annotations.Test;//use particular import 

import com.vtiger.comcast.pomrepositorylib.BaseClassUtility;
import com.vtiger.comcast.pomrepositorylib.CreatenewOrganization;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Organization;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;

public class CreateOrganizationBaseClass extends BaseClassUtility {
	@Test
	public void createOrgTest() throws Throwable {
		
		int randomInt = jlib.getRanDomNumber();
		/*test script Data*/
		String orgName = elib.getData("Sheet1", 1, 2) + randomInt;//.getdata from ExcelUtility
		String IndusType=elib.getData("Sheet1", 1, 3)+randomInt;

/*step 2 : navigate to organization*/
        Home homePage = new Home(driver);
        homePage.getOrganizationsLnk().click();//getOrganizationsLnk from Home.java

/*step 3 : navigate to "create new organization"page by click on "+" image */
        Organization orgPage = new Organization(driver);
orgPage.getCreateOrgImage().click();

/*step 4 : create organization*/
CreatenewOrganization cno = new CreatenewOrganization(driver);
cno.createOrg(orgName);

/*step 5 : verify the successful msg with org name*/
OrganizationInfo orginfoPage = new OrganizationInfo(driver);
String  actSuccesfullMg =  orginfoPage.getsuccessfulMSG().getText();
if(actSuccesfullMg.contains(orgName)) {
	System.out.println(orgName + "==>created successfully");
}else {
	System.out.println(orgName + "==> not created successfully");

        }
	}
	
	
	@Test
	public void createOrgWithIndutriesTest() throws Throwable {
		/*test script Data*/
		int randomInt = jlib.getRanDomNumber();//jlib has to be same as that in the base class
		String orgName = elib.getData("Sheet1", 4, 2) + randomInt;
		String industriesType = elib.getData("Sheet1", 4, 3);
		/*step 2 : navigate to organization*/
        Home homePage = new Home(driver);
homePage.getOrganizationsLnk().click();

/*step 3 : navigate to "create new organization"page by click on "+" image */
        Organization orgPage = new Organization(driver);
orgPage.getCreateOrgImage().click();//--getCreateOrgImage from organization 

/*step 4 : create organization*/
CreatenewOrganization cno = new CreatenewOrganization(driver);
cno.createOrg(orgName);

/*verify orgname& industry */
OrganizationInfo orginfoPage = new OrganizationInfo(driver);
String  actSuccesfullMg =  orginfoPage.getsuccessfulMSG().getText();
System.out.println(actSuccesfullMg);
if(actSuccesfullMg.contains(orgName)) {
	System.out.println(orgName + "==>created successfully");
}else {
	System.out.println(orgName+"==> not created successfully");

        }

        String actIndustryType = orginfoPage.getIndInfo().getText();
if(actIndustryType.equals(industriesType)) {
	System.out.println(industriesType + "==>industry is verified successfully");
}else {
	System.out.println(industriesType + "==>industry is not verified successfully");

        }
	}
	
	@Test
	public void createOrgWithRatingTest() throws Throwable {
		/*test script Data*/
		int randomInt = jlib.getRanDomNumber();
		String orgName = elib.getData("Sheet1", 7, 2) + randomInt;
		String rating = elib.getData("Sheet1", 7, 3);
		/*step 2 : navigate to organization*/
        Home homePage = new Home(driver);
homePage.getOrganizationsLnk().click();

/*step 3 : navigate to "create new organization"page by click on "+" image */
        Organization orgPage = new Organization(driver);
orgPage.getCreateOrgImage().click();

/*step 4 : create organization*/
CreatenewOrganization cno = new CreatenewOrganization(driver);
cno.createOrg(orgName);

/*verify orgname& industry */
OrganizationInfo orginfoPage = new OrganizationInfo(driver);
String  actSuccesfullMg =  orginfoPage.getsuccessfulMSG().getText();
if(actSuccesfullMg.contains(orgName)) {
	System.out.println(orgName + "==>created successfully");
}else {
	System.out.println(orgName + "==> not created successfully");

        }       
        String actRatingType = orginfoPage.getTypeInfo().getText();

if(actRatingType.equals(rating)) {
	System.out.println(rating + "==>industry is verified successfully");
}else {
	System.out.println(rating + "==>industry is not verified successfully");

        }
	}

}


