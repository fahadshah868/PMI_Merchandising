package com.ct.qa.constants

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.keywords.LoadDataKeywords
import com.ct.qa.struct.MissingRouteOutlets
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet

public class ProjectConstants {

	public static final AppiumDriver<MobileElement> DRIVER = MobileDriverFactory.getDriver()
	public static final String EXCEL_FILEPATH = "F:\\Git Projects\\PMI_Merchandising\\PMI_Merchandising.xlsx"
	public static final ROUTEOUTLET_SHEET = "Route Outlets"
	public static final String PACKAGENAME = "pk.com.tradetracker"
	
	public static String CURRENTVISITING_SHOPNAME = ""
	public static int BWU_REMARK = 0

	public static MissingRouteOutlets missingoutlets = new MissingRouteOutlets()
	public static ArrayList<String> tposmlist = new ArrayList<String>()

	//sheet columns
	//route info sheet columns
	public static final int ROUTEOUTLETS

	static{
		XSSFSheet routeoutletsheet = LoadDataKeywords.loadRouteOutletsSheet()

		Row routeoutletsheetheaderrow = routeoutletsheet.getRow(0)

		int routeoutletsheettotalcolumns = routeoutletsheetheaderrow.getLastCellNum()

		//load channel wise products sheet columns
		for(int cellnumber=0; cellnumber<routeoutletsheettotalcolumns; cellnumber++){
			String columnname = routeoutletsheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Route Outlets")){
				ROUTEOUTLETS = cellnumber
			}
			else{}
		}
	}

	//messages
	public static final String MESSAGEFOR_ITEMSARE_MORE = "above items are more than to expected items"
	public static final String MESSAGEFOR_ITEMSARE_MISSING = "above items are missing on device"
	public static final String MESSAGEFOR_ITEMSARE_NOTMATCH = "above items are not match with expected items"
}
