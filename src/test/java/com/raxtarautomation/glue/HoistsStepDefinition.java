package com.raxtarautomation.glue;

import java.util.Map;

import org.testng.Assert;

import com.raxtarautomation.common.BaseClass;
import com.raxtarautomation.pageclass.HoistsPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HoistsStepDefinition {

	HoistsPage hoistsPage = new HoistsPage(BaseClass.getDriverInstance());

	@Then("^I see the hoist overview screen$")
	public void verifyHoistOverViewScreen() {

		Assert.assertTrue(hoistsPage.isHositPageDisplayed(), "The Hoists page is not diaplayed");
	}

	@And("^I see the records sorted with Number column$")
	public void verifySortedNumberColumn() {

		Assert.assertTrue(hoistsPage.isSortedWithNumberColumn(), "The column number is not sorted");
	}

	@And("^for first record I click on \"(.*?)\" button$")
	public void clickOnEditOrDeleteButton(String buttonName) {
		hoistsPage.clickOnEditOrDeleteButtonInHositMenu(buttonName);
	}

	@Then("^I see the Edit Hoist popup screen open$")
	public void verifyPopUpScreen() {
		Assert.assertTrue(hoistsPage.isPopUpScreenDisplayed(), "The pop up screen is not displayed");
	}

	@And("^Fill the below details and click on Submit Button$")
	public void fillHoistDetails(DataTable testData) throws InterruptedException {
		Map<String, String> data = testData.asMap(String.class, String.class);
		hoistsPage.fillHoistDetailsforHoistAndSubmit(data);
	}

	@Then("^the pop up should be diaplyed with Sucessfully Submitted message$")
	public void verifyHoistEditDetailsSubmission() {
		Assert.assertTrue(hoistsPage.isHoistDetailsSubmitted("Success!"), "Hoist details are not submitted");
	}

	@When("^the close button is clicked in the pop up$")
	public void closePopUp() throws InterruptedException {
		hoistsPage.closeButtonInPopUp();
	}
	
	@And("^for first record I click on Go to hoist Dashboard button$")
	public void goBackToHoistDashBoardPage()
	{
		hoistsPage.clickOnHositDashBoard();
	}
	
	
	@Then("^Hoist DahBoard page should be seen$")
	public void verifyHoistDashBoard()
	{
		Assert.assertTrue(hoistsPage.isHoistDashBoardDiaplayed(), "Hosit Details are  deleted");
	}
	
	@When("^I click on add hoist button$")
	public void addHoist() throws InterruptedException
	{
		hoistsPage.clickOnAddHoistButton();
	}
	
	
	@When("^I click on the \"(.*?)\" button the pop up$")
	public void verifyPopUp(String buttonName)
	{
		hoistsPage.clickButtonOnPopUp(buttonName);
	}
	
	@Then("^the hositDetails will be deleted$")
	public void verifyHositDetailsDeleted()
	{
		Assert.assertTrue(hoistsPage.isHoistdetailsDeleted(), "Hosit Details are  deleted");
	}
	
	@Then("^the hositDetails should not be deleted$")
	public void verifyHoistDetailsAreNotDeleted()
	{
		Assert.assertTrue(hoistsPage.isHoistdetailsNotDeleted(), "Hosit Details are not deleted");
	}

}
