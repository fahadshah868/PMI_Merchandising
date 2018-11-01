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

public class BWUMaintenanceKeywords {

	@Keyword
	def visitBWUMaintenanceWithDataVerification(){
		int totalbwus = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i< totalbwus; i++){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]").click()
			Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/Validate_BWUAllocatedScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU Allocated')
			Mobile.tap(findTestObject('ShopOpen/BWUMaintenance/ViewPlanogramButton', [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.pressBack()
			Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/Validate_BWUAllocatedScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU Allocated')
			Mobile.tap(findTestObject('ShopOpen/BWUMaintenance/BWUStatus_Button', [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/Validate_BWUStatusDetailScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU MAINTENANCE')
			int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
			if(ProjectConstants.BWU_REMARK == 1){
				for(int j=1; j<= totalremarks; j++){
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					if(remarktext.equalsIgnoreCase("BWU Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/BWUMaintenance/VisitBWUAvailable"), null)
						break
					}
				}
			}
			else if(ProjectConstants.BWU_REMARK == 2){
				for(int j=1; j<= totalremarks; j++){
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					if(remarktext.equalsIgnoreCase("BWU not Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]").click()
						Mobile.pressBack()
						Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/Validate_BWUAllocatedScreen', [('package') : ProjectConstants.PACKAGENAME]),'BWU Allocated')
						Mobile.tap(findTestObject('ShopOpen/BWUMaintenance/TakePicture'), 0)
						CommonKeywords.takPicture()
						Mobile.pressBack()
						break
					}
				}
			}
			else if(ProjectConstants.BWU_REMARK == 3){
				for(int j=1; j<= totalremarks; j++){
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					if(remarktext.equalsIgnoreCase("BWU needs maintenance")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/BWUMaintenance/VisitBWUNeedMaintenance"), null)
						break
					}
				}
			}
			else if(ProjectConstants.BWU_REMARK == 4){
				for(int j=1; j<= totalremarks; j++){
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					if(remarktext.equalsIgnoreCase("Retailer did not allow")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/BWUMaintenance/VisitRetailerDidNotAllow"), null)
						break
					}
				}
			}
			else{
				for(int j=1; j<= totalremarks; j++){
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					if(remarktext.equalsIgnoreCase("Retailer did not allow")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/BWUMaintenance/VisitRetailerDidNotAllow"), null)
						break
					}
				}
			}
			Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/Validate_BWUMaintenanceScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU MAINTENANCE')
		}
	}
	//bwu available
	@Keyword
	def visitBWUAvailable(){
		MobileElement list = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]")
		int totalitems = list.findElementsByClassName("android.widget.RadioGroup").size()
		for(int i=1; i<= totalitems; i++){
			MobileElement item = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView["+i+"]")
			String itemtext = item.getText()
			if(itemtext.equalsIgnoreCase("Unit Poster deployed as per cycle")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup["+i+"]/android.widget.RadioButton[1]").click()
				Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/BWUMaintenance/BWUAvailable/Validate_PPOSMRemarksScreen", [('package') : ProjectConstants.PACKAGENAME]), "REMARKS")
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]").click()
				Mobile.pressBack()
				Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/BWUAvailable/Validate_BWUAvailableScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU MAINTENANCE')
			}
			else if(itemtext.equalsIgnoreCase("Unit Sheet deployed as per cycle")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup["+i+"]/android.widget.RadioButton[1]").click()
				Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/BWUMaintenance/BWUAvailable/Validate_PPOSMRemarksScreen", [('package') : ProjectConstants.PACKAGENAME]), "REMARKS")
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]").click()
				Mobile.pressBack()
				Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/BWUAvailable/Validate_BWUAvailableScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU MAINTENANCE')
			}
			else if(itemtext.equalsIgnoreCase("BWU Poster deployed as per cycle")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup["+i+"]/android.widget.RadioButton[1]").click()
				Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/BWUMaintenance/BWUAvailable/Validate_PPOSMRemarksScreen", [('package') : ProjectConstants.PACKAGENAME]), "REMARKS")
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]").click()
				Mobile.pressBack()
				Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/BWUAvailable/Validate_BWUAvailableScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU MAINTENANCE')
			}
			else{
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup["+i+"]/android.widget.RadioButton[1]").click()
			}
		}
	}
	//bwu need maintenance
	@Keyword
	def visitBWUNeedMaintenance(){
		MobileElement list = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]")
		int totalitems = list.findElementsByClassName("android.widget.RadioGroup").size()
		for(int i=1; i<= totalitems; i++){
			MobileElement item = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView["+i+"]")
			String itemtext = item.getText()
			if(itemtext.equalsIgnoreCase("Unit Poster deployed as per cycle")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup["+i+"]/android.widget.RadioButton[1]").click()
				Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/BWUMaintenance/BWUAvailable/Validate_PPOSMRemarksScreen", [('package') : ProjectConstants.PACKAGENAME]), "REMARKS")
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]").click()
				Mobile.pressBack()
				Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/BWUAvailable/Validate_BWUAvailableScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU MAINTENANCE')
			}
			else if(itemtext.equalsIgnoreCase("Unit Sheet deployed as per cycle")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup["+i+"]/android.widget.RadioButton[1]").click()
				Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/BWUMaintenance/BWUAvailable/Validate_PPOSMRemarksScreen", [('package') : ProjectConstants.PACKAGENAME]), "REMARKS")
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]").click()
				Mobile.pressBack()
				Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/BWUAvailable/Validate_BWUAvailableScreen', [('package') : ProjectConstants.PACKAGENAME]), 'BWU MAINTENANCE')
			}
			else{
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup["+i+"]/android.widget.RadioButton[1]").click()
			}
		}
	}
}
