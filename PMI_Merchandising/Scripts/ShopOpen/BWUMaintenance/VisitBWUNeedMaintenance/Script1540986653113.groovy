import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.ct.qa.constants.ProjectConstants as ProjectConstants
import com.ct.qa.keywords.CommonKeywords as CommonKeywords
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/BWUAvailable/Validate_BWUAvailableScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'BWU MAINTENANCE')

CustomKeywords.'com.ct.qa.keywords.BWUMaintenanceKeywords.visitBWUNeedMaintenance'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/Validate_BWUStatusDetailScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'BWU MAINTENANCE')

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('ShopOpen/BWUMaintenance/Validate_BWUAllocatedScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'BWU Allocated')

Mobile.tap(findTestObject('ShopOpen/BWUMaintenance/TakePicture', [('package') : ProjectConstants.PACKAGENAME]), 0)

CommonKeywords.takPicture()

Mobile.pressBack()

