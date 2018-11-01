import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.eclipse.persistence.jpa.metadata.ProjectCache as ProjectCache
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

Mobile.verifyElementText(findTestObject('Dashboard/Validate_DashboardScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'WELCOME')

Mobile.tap(findTestObject('Dashboard/CycleButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('Dashboard/Validate_DashboardScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'WELCOME')

Mobile.tap(findTestObject('Dashboard/SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('Common/Validate_RouteListScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'ROUTE LIST')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.selectday'()

Mobile.verifyElementText(findTestObject('TPOSM/Validate_RouteInfoScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Route Info')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.validateRouteOutletsList'()

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.visitRouteOutlets'()

Mobile.tap(findTestObject('TPOSM/TPOSMLoading_Button', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('TPOSM/Validate_TPOSMLoadingScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'TPOSM LOADING')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.visitTPOSM'()

Mobile.tap(findTestObject('TPOSM/TPOSMLoading_SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('TPOSM/Validate_TPOSMSummaryScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'TPOSM SUMMARY')

Mobile.swipe(0, 750, 0, 200)

Mobile.swipe(0, 750, 0, 200)

Mobile.swipe(0, 750, 0, 200)

Mobile.tap(findTestObject('TPOSM/TPOSMSummary_TakePictureButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('Common/Validate_CameraScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('Common/Camera_TakePictureButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Common/Camera_DoneButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('Validate_ShopListScreen', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.hideKeyboard()

CustomKeywords.'com.ct.qa.keywords.ShopVisitingScenariosKeywords.visitShopWithDataVerifications'()

