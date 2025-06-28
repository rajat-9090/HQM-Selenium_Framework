package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	
	public void onStart(ITestContext testContext) {
		
		//1st Way to mention the Timestamp in the Report
		/*SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt= new Date();
		String currentdatetimestamp= df.format(dt);*/
		
		//2nd Way to mention the Timestamp for the Report
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		//Generating Name of the Report
		repName="Test-Report-" + timeStamp + ".html";
		sparkReporter= new ExtentSparkReporter(".\\Reports\\" + repName);
		
		//Specifing UI/Structure of the Report
		sparkReporter.config().setDocumentTitle("HQM Automation Report");
		sparkReporter.config().setReportName("HQM Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		//Adding Common Imfo to the Report
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "HQM");
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "HC Instance");
		extent.setSystemInfo("Tester Name", "Rajat");
		
		//Adding Common Imfo regarding os, browser name and groups merging running .xml file
		String os= testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser= testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Running Browser", browser);
		
		List<String> includedGroups= testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			
			extent.setSystemInfo("Name of Groups", includedGroups.toString());
		}
		
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		//Displaying Class Name and Group Name to the Report
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		//Adding Success Status to the Report
		test.log(Status.PASS, result.getName() + " got successfully Executed");
	}
	
	
	public void onTestFailure(ITestResult result) {
		
		//Displaying Class Name and Group Name to the Report
	    test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		//Adding Failed Ststus and Imfo to the Report
		test.log(Status.FAIL, result.getName() + " got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		//Adding "captureScreen" method from "BaseClass" to attach the ScreenShots to the Report
		try {
			
			String imgPath= new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		
		}catch (Exception e1) {
			
			e1.printStackTrace();
		}	
	}
	
	
	public void onTestSkipped(ITestResult result) {
		
		//Displaying Class Name and Group Name to the Report
	    test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		//Adding Skipped Ststus and Imfo to the Report
		test.log(Status.SKIP, result.getName() + " got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		
		//This Piece of Code will Open the Report Automatically
		String pathofExtentReport= System.getProperty("user.dir") + "\\Reports\\" + repName;
		File extentReport= new File(pathofExtentReport);
		
		//Adding try and catch block, if the report is no there where it supppose to then it will handle it
		try {
			
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}catch (Exception e) {
			
		    e.printStackTrace();
		}
	}


	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
