package com.Facebook.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
 
 public ExtentHtmlReporter htmlReporter;
 public ExtentReports extent;
 public ExtentTest test;
 
 String repName;
  
 public void onStart(ITestContext testContext)
 {
 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 repName = "Test-Report-" +timeStamp+".html";
 
 htmlReporter = new ExtentHtmlReporter(".\\reports\\"+repName);
 
 htmlReporter.config().setDocumentTitle("Facebook Automation Report"); // Tile of report
 htmlReporter.config().setReportName("Facebook Regression Testing"); // name of the report
 htmlReporter.config().setTheme(Theme.STANDARD);
 
  extent=new ExtentReports();
  
  extent.attachReporter(htmlReporter);
  extent.setSystemInfo("Host name","localhost");
  extent.setSystemInfo("Environemnt","QA");
  extent.setSystemInfo("user","Mritunjay");
  
  
 }
 
 public void onTestSuccess(ITestResult tr)
 {
  test=extent.createTest(tr.getName()); // create new entry in the report
  test.log(Status.PASS,"Test Passed"); // send the passed information to the report
  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
  try {
   test.addScreenCaptureFromPath(screenshotPath);
  } catch (IOException e) {
    e.printStackTrace();
  }  
 }
 
 public void onTestFailure(ITestResult tr)
 {
  test=extent.createTest(tr.getName()); // create new entry in th report
  test.log(Status.FAIL,tr.getThrowable().getMessage()); // send the passed information to the report with GREEN color highlighted
  
  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
  try {
   test.addScreenCaptureFromPath(screenshotPath);
  } catch (IOException e) {
    e.printStackTrace();
  } 
 }
 
 public void onTestSkipped(ITestResult tr)
 {
  test=extent.createTest(tr.getName()); // create new entry in th report
  test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
 }
 
 public void onFinish(ITestContext testContext)
 {
  extent.flush();
 }

public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}
 
 }
