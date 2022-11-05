import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class ProductCategoriesSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User set method post and endpoint create a category")
	def setMethodPostAndEndpointCreateACategory() {
		println("\n I set method post and endpoint create a category")
		response = WS.sendRequest(findTestObject('Object Repository/Product Categories/Create_A_Category'))
	}
	@And("I set http body")
	def setHttpBody() {
		println("\n I set http body")
	}
	@Then("User receive valid http response code 200")
	def receiveValidHttpResponseCode200() {
		println("\n I receive valid http response code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data.Name', 'gaming')
		WS.verifyElementPropertyValue(response, 'data.Description', 'for gaming purposes')
	}
	@Given("User set method get and endpoint get all categories")
	def setMethodPostAndEndpointGetAllCategories() {
		println("\n I set method post and endpoint get all categories")
		response = WS.sendRequest(findTestObject('Object Repository/Product Categories/Get_All_Categories'))
	}
	@Then("User received valid response code 200")
	def receivedValidResponseCode200() {
		println("\n I received valid response code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data[0].ID', 2)
		WS.verifyElementPropertyValue(response, 'data[0].Name', "gaming")
		WS.verifyElementPropertyValue(response, 'data[0].Description', "for gaming purposes")
	}
}