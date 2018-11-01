package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.MobileElement

public class ShopVisitingScenariosKeywords {

	def findShopRemark(String remark){
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement shopremark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]/android.widget.TextView[1]")
			String shopremarktext = shopremark.getText()
			if(shopremarktext.equalsIgnoreCase(remark)){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]").click()
				break
			}
		}
	}
	@Keyword
	def visitShopWithDataVerifications(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=6; i<= 7; i++){
			ProjectConstants.BWU_REMARK = ProjectConstants.BWU_REMARK + 1
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]/android.widget.TextView[1]")
			String shoptext = shop.getText()
			ProjectConstants.CURRENTVISITING_SHOPNAME = shoptext
			if(shoptext.contains("TK")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]").click()
				Mobile.verifyElementText(findTestObject("Validate_ShopDetailsInfoScreen", [('package') : ProjectConstants.PACKAGENAME]), "Info")
				Mobile.tap(findTestObject("Object Repository/ShopDetails", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.verifyElementText(findTestObject("Object Repository/Validate_ShopProceedInfoScreen", [('package') : ProjectConstants.PACKAGENAME]), "Info")
				Mobile.tap(findTestObject("Object Repository/ProceedButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.delay(15)
				Mobile.verifyElementExist(findTestObject("Object Repository/Common/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.tap(findTestObject("Object Repository/Common/Map_CheckInButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopLocationCorrectionPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.tap(findTestObject("Object Repository/ShopLocationIsIncorrect", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShopRemark("Shop Open")
				CommonKeywords.takPicture()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopCategories/VisitShopCategoriesWithDataVerification"), null)
			}
			else{}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		//		while(true){
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement itembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+index+"]/android.widget.TextView[1]")
		//			String itemtextbeforeswipe = itembeforeswipe.getText()
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement itemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+index+"]/android.widget.TextView[1]")
		//			String itemtextafterswipe = itemafterswipe.getText()
		//			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
		//				break
		//			}
		//			else{
		//				if(itemtextafterswipe.contains("TK")){
		//					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]").click()
		//					Mobile.verifyElementText(findTestObject("Validate_ShopDetailsInfoScreen", [('package') : ProjectConstants.PACKAGENAME]), "Info")
		//					Mobile.tap(findTestObject("Object Repository/ShopDetails", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					Mobile.verifyElementText(findTestObject("Object Repository/Validate_ShopProceedInfoScreen", [('package') : ProjectConstants.PACKAGENAME]), "Info")
		//					Mobile.tap(findTestObject("Object Repository/ProceedButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					Mobile.delay(15)
		//					Mobile.verifyElementExist(findTestObject("Object Repository/Common/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					Mobile.tap(findTestObject("Object Repository/Common/Map_CheckInButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopLocationCorrectionPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					Mobile.tap(findTestObject("Object Repository/ShopLocationIsIncorrect", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					findShopRemark("Shop Open")
		//					CommonKeywords.takPicture()
		//					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopCategories/VisitShopCategoriesWithDataVerification"), null)
		//				}
		//			}
		//		}
	}
}
