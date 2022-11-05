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



class OrdersSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User set method post and endpoint create a new order")
	def setMethodPostAndEndpointCreateAOrder() {
		println("\n I set method post and endpoint create a new order")
		response = WS.sendRequest(findTestObject('Object Repository/Orders/Create_A_New_Order'))
	}
	@And("User set HTTP body")
	def setHTTPBody() {
		println("\n I set HTTP body")
	}
	@Then("User receive response code 401")
	def receiveResponseCode401() {
		println("\n I receive response code 401")
		WS.verifyResponseStatusCode(response, 401)
	}
	@Then("User receive response valid code 200")
	def receiveResponseValidCode200() {
		println("\n I receive response valid code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data[0].User.ID', 2)
		WS.verifyElementPropertyValue(response, 'data[0].User.Fullname', 'Firstname Lastname')
		WS.verifyElementPropertyValue(response, 'data[0].User.Email', 'someone@mail.com')
		WS.verifyElementPropertyValue(response, 'data[0].User.Password', '123123')
		WS.verifyElementPropertyValue(response, 'data[0].Product', null)
		WS.verifyElementPropertyValue(response, 'data[0].Quantity', 1)
	}
	@Given("User set method post and endpoint get all orders")
	def setMethodPostAndEndpointGetAllOrders() {
		println("\n I set method post and endpoint get all orders")
		response = WS.sendRequest(findTestObject('Object Repository/Orders/Get_All_Orders_With_Token'))
	}
	@Then("User receive respon valid code 200")
	def receiveeResponValidseCode200() {
		println("\n I receive respon valid code 200")
		WS.verifyResponseStatusCode(response, 200)
	}
	@Then("User receive respon valid code 401")
	def receiveeResponValidCode401() {
		println("\n I receive respon valid code 401")
		WS.verifyResponseStatusCode(response, 401)
	}
	@Given("User set method post and endpoint get order by id")
	def setMethodPostAndEndpointGetOrderById() {
		println("\n I set method post and endpoint get order ny id")
		response = WS.sendRequest(findTestObject('Object Repository/Orders/Get_Order_By_ID_With_Token'))
	}
	@Then("User receive response code 200")
	def receiveeeResponseCode200() {
		println("\n I receive response code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data.ID', 1)
		WS.verifyElementPropertyValue(response, 'data.User.ID', 2)
		WS.verifyElementPropertyValue(response, 'data.User.Fullname', 'Firstname Lastname')
		WS.verifyElementPropertyValue(response, 'data.User.Email', 'someone@mail.com')
		WS.verifyElementPropertyValue(response, 'data.User.Password', '123123')
		WS.verifyElementPropertyValue(response, 'data.Product', null)
		WS.verifyElementPropertyValue(response, 'data.Quantity', 1)
	}
	@Then("User receive response valid code 401")
	def receiveeeResponseValidCode401() {
		println("\n I receive response valid code 401")
		WS.verifyResponseStatusCode(response, 401)
	}
}