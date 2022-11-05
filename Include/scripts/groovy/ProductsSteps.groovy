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



class ProductsSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User set method get and endpoint get all products")
	def setMethodGetAndEndpointGetAllProducts() {
		println("\n I set method get and endpoint get all products")
		response = WS.sendRequest(findTestObject('Object Repository/Products/Get_All_Product'))
	}
	@Then("User receive valid HTTP response code 200")
	def receiveValidHTTPCode200() {
		println("\n I receive valid HTTP response code 200")
		WS.verifyResponseStatusCode(response, 200)
	}
	@Then("User receive valid HTTP response code 404")
	def receivedValidHTTPCode400() {
		println("\n I receive valid HTTP response code 404")
		WS.verifyResponseStatusCode(response, 404)
	}
	@Given("User set method post and endpoint create new product")
	def setMethodPostAndEndpointCreateNewProduct() {
		println("\n I set method post and endpoint create new product")
		response = WS.sendRequest(findTestObject('Object Repository/Products/Create_A_New_Product'))
	}
	@And("User input HTTP body")
	def inputHTTPBody() {
		println("\n I input HTTP body")
	}
	@Then("User receive HTTP response code 200")
	def receiveHTTPResponseCode200() {
		println("\n I receive HTTP response code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data.Description', "play has no limits")
		WS.verifyElementPropertyValue(response, 'data.Price', 299)
		WS.verifyElementPropertyValue(response, 'data.Ratings', 0)
	}
	@Then("User receive HTTP response code 400")
	def receiveHTTPResponseCode400() {
		println("\n I receive HTTP response code 400")
		WS.verifyResponseStatusCode(response, 400)
	}
	@Given("User set method post and endpoint assign a product rating")
	def setMethodPostAndEndpointAssignAProductRating() {
		println("\n I set method post and endpoint assign a product rating")
		response = WS.sendRequest(findTestObject('Object Repository/Products/Assign_A_Product_Rating_Without_Token'))
	}
	@And("User input valid HTTP body")
	def inputValidHttpBody() {
		println("\n I input valid HTTP body")
	}
	@Then("User receive valid respon code 401")
	def receiveValidResponCode401() {
		println("\n I receive valid respon code 401")
		WS.verifyResponseStatusCode(response, 401)
	}
	@Then("User receive valid respon code 200")
	def receiveValidResponCode200() {
		println("\n I receive valid respon code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data.ID', 13)
		WS.verifyElementPropertyValue(response, 'data.Name', "Sony PS5")
		WS.verifyElementPropertyValue(response, 'data.Description', "play has no limits")
		WS.verifyElementPropertyValue(response, 'data.Price', 299)
		WS.verifyElementPropertyValue(response, 'data.Ratings', 3)
	}
	@Given("User set method post and endpoint see product rating")
	def setMethodPostAndEndpointSeeAProductRating() {
		println("\n I set method post and endpoint see product rating")
		response = WS.sendRequest(findTestObject('Object Repository/Products/Get_Product_Rating'))
	}
	@Then("User receive valid HTTP respon code 200")
	def receiveValidHttpResponCode200() {
		println("\n I receive valid HTTP respon code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data', 4)
	}
	@Then("User receive valid HTTP respon code 404")
	def receiveValidHTTPResponCode404() {
		println("\n I receive valid HTTP respon code 404")
		WS.verifyResponseStatusCode(response, 404)
	}
	@Given("User set method post and endpoint see products comments")
	def setMethodPostAndEndpointSeeProductsComments() {
		println("\n I set method post and endpoint see product comments")
		response = WS.sendRequest(findTestObject('Object Repository/Products/Get_Product_Comments'))
	}
	@Then("User received valid HTTP response code 200")
	def receivedValidHTTPResponseCode200() {
		println("\n I received valid HTTP response code 200")
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data[0].ID', 1)
		WS.verifyElementPropertyValue(response, 'data[0].Content', "the games are great including Gran Turismo 7 but sadly GT4 is much better")
		WS.verifyElementPropertyValue(response, 'data[0].User', null)
		WS.verifyElementPropertyValue(response, 'data[0].Product', null)
		WS.verifyElementPropertyValue(response, 'data[0].Comment', null)
	}
	@Then("User received valid HTTP response code 404")
	def receivedValidHTTPResponseCode404() {
		println("\n I received valid HTTP response code 404")
		WS.verifyResponseStatusCode(response, 404)
	}
}