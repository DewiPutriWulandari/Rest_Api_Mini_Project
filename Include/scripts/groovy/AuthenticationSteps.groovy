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



class AuthenticationSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User set method post and endpoint register")
	def setMethodPostAndEndpointRegister() {
		println("\n I set method post and endpoint register")
		response = WS.sendRequest(findTestObject('Object Repository/Authentication/Register'))
	}
	@When("User input http body")
	def inputHttpBody() {
		println("\n I input http body")
	}
	@Then("User received respon message 400")
	def receivedResponseMessage400() {
		println("\n I received respon message 400")
		WS.verifyResponseStatusCode(response, 400)
	}
	@Given("User set method post and endpoint login")
	def setMethodPostAndEndpointLogin() {
		println("\n I set method post and endpoint login")
		response = WS.sendRequest(findTestObject('Object Repository/Authentication/Login'))
	}
	@Then("User received response code 200")
	def receivedResponseCode200() {
		println("\n I received response code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data', "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.qWDOcd2UDoTGumbak_fRlZZtf-H7va3sH2a339KGiKU")
	}
	@Then("User received response code 400")
	def receiveeeResponseCode400() {
		println("\n I received response code 400")
		WS.verifyResponseStatusCode(response, 400)
		WS.verifyElementPropertyValue(response, 'error', 'email or password is invalid')
	}
	@Given("User set method get and endpoint get user information")
	def setMethodGetAndEndpointGetUserInformation() {
		println("\n I set method get and endpoint get user information")
		response = WS.sendRequest(findTestObject('Object Repository/Authentication/Get_User_Information_With_Token'))
	}
	@When("User input token")
	def inputHttpToken() {
		println("\n I input token")
	}
	@Then("User received respon code 200")
	def receiveResponCode200() {
		println("\n I received respon code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data.ID', 2)
		WS.verifyElementPropertyValue(response, 'data.Fullname', "Firstname Lastname")
		WS.verifyElementPropertyValue(response, 'data.Email', "someone@mail.com")
		WS.verifyElementPropertyValue(response, 'data.Password', "123123")
	}
}