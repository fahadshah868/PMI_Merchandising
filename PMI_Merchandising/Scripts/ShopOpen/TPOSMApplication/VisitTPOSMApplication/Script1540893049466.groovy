import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.ct.qa.constants.ProjectConstants as ProjectConstants
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

Mobile.verifyElementText(findTestObject('ShopOpen/TPOSMApplication/Validate_TPOSMApplicationScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'TPOSM Application')

Mobile.tap(findTestObject('ShopOpen/TPOSMApplication/TPOSMDeployment', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/TPOSMApplication/Validate_TPOSMScreen', [('package') : ProjectConstants.PACKAGENAME]), 'TPOSM')

CustomKeywords.'com.ct.qa.keywords.TPOSMApplication.visitTPOSMList'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('ShopOpen/TPOSMApplication/Validate_TPOSMApplicationScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'TPOSM Application')

Mobile.tap(findTestObject('ShopOpen/TPOSMApplication/TakePicture1st', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('Common/Validate_CameraScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('Common/Camera_TakePictureButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Common/Camera_DoneButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/TPOSMApplication/Validate_TPOSMApplicationScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'TPOSM Application')

Mobile.tap(findTestObject('ShopOpen/TPOSMApplication/TakePicture2nd', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('Common/Validate_CameraScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('Common/Camera_TakePictureButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Common/Camera_DoneButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/TPOSMApplication/Validate_TPOSMApplicationScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'TPOSM Application')

Mobile.pressBack()

