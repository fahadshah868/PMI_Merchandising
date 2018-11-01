package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
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

public class CompareDataKeywords {

	//compare lists
	def static compareLists(ArrayList<String> expectedlist, ArrayList<String> displayedlist){
		if(expectedlist.size() == displayedlist.size()){
			ArrayList<String> products = new ArrayList<String>()
			UnmatchItems UnmatchItems_status = new UnmatchItems()
			for(int i=0; i<displayedlist.size(); i++){
				boolean match = false
				for(int j=0; j<expectedlist.size(); j++){
					if(displayedlist.get(i).equalsIgnoreCase(expectedlist.get(j))){
						match = true
						break
					}
				}
				if(match == false){
					products.add(displayedlist.get(i))
				}
				else{
				}
			}
			if(!products.isEmpty()){
				UnmatchItems_status.setItems(products)
				UnmatchItems_status.setStatus(2)
				return UnmatchItems_status
			}
			else{
				UnmatchItems_status.setItems(products)
				UnmatchItems_status.setStatus(0)
				return UnmatchItems_status
			}
		}
		else if(expectedlist.size() < displayedlist.size()){
			ArrayList<String> products = new ArrayList<String>()
			UnmatchItems UnmatchItems_status = new UnmatchItems()
			for(int i=0; i<displayedlist.size(); i++){
				boolean match = false
				for(int j=0; j<expectedlist.size(); j++){
					if(displayedlist.get(i).equalsIgnoreCase(expectedlist.get(j))){
						match = true
						break
					}
				}
				if(match == false){
					products.add(displayedlist.get(i))
				}
				else{
				}
			}
			UnmatchItems_status.setItems(products)
			UnmatchItems_status.setStatus(1)
			return UnmatchItems_status
		}
		else if(expectedlist.size() > displayedlist.size()){
			ArrayList<String> products = new ArrayList<String>()
			UnmatchItems UnmatchItems_status = new UnmatchItems()
			for(int i=0; i<expectedlist.size(); i++){
				boolean match = false
				for(int j=0; j<displayedlist.size(); j++){
					if(expectedlist.get(i).equalsIgnoreCase(displayedlist.get(j))){
						match = true
						break
					}
				}
				if(match == false){
					products.add(expectedlist.get(i))
				}
				else{
				}
			}
			UnmatchItems_status.setItems(products)
			UnmatchItems_status.setStatus(-1)
			return UnmatchItems_status
		}
	}
	//compare route info list
	def static compareRouteOuteletsList(ArrayList<String> expectedlist){
		ArrayList<String> displayedrouteoutletslist = new ArrayList<String>()
		int totalrouteoutlets = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i< totalrouteoutlets; i++){
			MobileElement routeoutlet = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout["+i+"]/android.widget.TextView[1]")
			String routeoutlettext = routeoutlet.getText()
			String[] routeoutletstrings = routeoutlettext.split(":")
			displayedrouteoutletslist.add(routeoutletstrings[0])
		}
		UnmatchItems unmatchitems = compareLists(expectedlist, displayedrouteoutletslist)
		return unmatchitems
	}
}
