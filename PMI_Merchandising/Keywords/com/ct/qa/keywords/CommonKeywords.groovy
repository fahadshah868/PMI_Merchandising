package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.UnmatchItems
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
import org.openqa.selenium.By
import org.openqa.selenium.By.ByTagName

public class CommonKeywords {
	@Keyword
	def selectday(){
		Calendar calendar = Calendar.getInstance()
		int day = calendar.get(Calendar.DAY_OF_WEEK)
		if(day == 2){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]").click()
		}
		else if(day == 3){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[2]").click()
		}
		else if(day == 4){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]").click()
		}
		else if(day == 5){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[4]").click()
		}
		else if(day == 6){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[5]").click()
		}
		else if(day == 7){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[6]").click()
		}
	}
	def static takPicture(){
		try{
			Mobile.verifyElementExist(findTestObject("Object Repository/Common/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.tap(findTestObject("Object Repository/Common/Camera_TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(5)
			Mobile.tap(findTestObject("Object Repository/Common/Camera_DoneButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		catch(Exception ex){
		}
	}
	@Keyword
	def validateRouteOutletsList(){
		ArrayList<String> expectedrouteoutletslist = LoadDataKeywords.loadRouteOutletsList(LoadDataKeywords.loadRouteOutletsSheet(), ProjectConstants.ROUTEOUTLETS)
		UnmatchItems unmatchitems = CompareDataKeywords.compareRouteOuteletsList(expectedrouteoutletslist)
		if(unmatchitems.getStatus() == 2){
			ProjectConstants.missingoutlets.setRouteoutlets(unmatchitems.getItems())
			ProjectConstants.missingoutlets.setErrormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
		}
		else if(unmatchitems.getStatus() == 1){
			ProjectConstants.missingoutlets.setRouteoutlets(unmatchitems.getItems())
			ProjectConstants.missingoutlets.setErrormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
		}
		else if(unmatchitems.getStatus() == -1){
			ProjectConstants.missingoutlets.setRouteoutlets(unmatchitems.getItems())
			ProjectConstants.missingoutlets.setErrormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
		}
		else{
		}
	}
	@Keyword
	def visitRouteOutlets(){
		int totalrouteoutlets = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalrouteoutlets; i++){
			MobileElement routeinfo = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]/android.widget.TextView[1]")
			String routeinfotext = routeinfo.getText()
			if(routeinfotext.contains("TK Value Outlets")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]").click()
				Mobile.verifyElementText(findTestObject("TPOSM/Validate_RouteOutlet_SettingsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Settings")
				int totalrouteoutletsettings = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
				for(int j=1; j<= totalrouteoutletsettings; j++){
					MobileElement routeoutletsettingsubscreen = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]/android.widget.TextView[1]")
					String routeoutletsettingsubscreentext = routeoutletsettingsubscreen.getText()
					String[] routeoutletsettingsubscreenstrings = routeoutletsettingsubscreentext.split(":")
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+j+"]").click()
					Mobile.verifyElementText(findTestObject("TPOSM/Validate_RouteOutlet_Settings_SubScreen", [('package') : ProjectConstants.PACKAGENAME]), routeoutletsettingsubscreenstrings[0])
					Mobile.pressBack()
				}
				Mobile.pressBack()
				Mobile.verifyElementText(findTestObject('TPOSM/Validate_RouteInfoScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Route Info')
				break
			}
			else{}
		}
	}
	@Keyword
	def visitTPOSM(){
		int index = 0
		int totaltposm = ProjectConstants.DRIVER.findElementsByClassName("android.widget.EditText").size()
		for(int i=1; i<= totaltposm; i++){
			MobileElement tposm = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+i+"]")
			ProjectConstants.tposmlist.add(tposm.getText())
			MobileElement tposmeditfield = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.EditText[1]")
			tposmeditfield.setValue("12345678")
			Mobile.hideKeyboard()
		}
		while(true){
			index = ProjectConstants.DRIVER.findElementsByClassName("android.widget.EditText").size()
			MobileElement itembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String itemnamebeforeswipe = itembeforeswipe.getText()
			Mobile.swipe(2, 332, 2, 200)
			index = ProjectConstants.DRIVER.findElementsByClassName("android.widget.EditText").size()
			MobileElement itemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String itemnameafterswipe = itemafterswipe.getText()
			if(itemnamebeforeswipe.equals(itemnameafterswipe)){
				break
			}
			else{
				MobileElement tposm = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
				ProjectConstants.tposmlist.add(tposm.getText())
				MobileElement tposmeditfield = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				tposmeditfield.setValue("12345678")
				Mobile.hideKeyboard()
			}
		}
	}
}
