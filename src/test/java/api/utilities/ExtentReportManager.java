package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String reportName;

	
	
		
    public void onStart(ITestContext testContext) {					
        // TODO Auto-generated method stub				
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());		
		reportName = "Test-Report-" + timeStamp +".html";
		 sparkReporter =  new ExtentSparkReporter(".\\reports\\"+reportName);
		 
		 sparkReporter.config().setTheme(Theme.DARK);
		 sparkReporter.config().setDocumentTitle("Video Game DB Authomation report");
		 sparkReporter.config().setReportName("Video Game DB Authomation");
		 
		 
		 extent = new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 extent.setSystemInfo("TestFramework", "Video Game API");
		 extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		 extent.setSystemInfo("User name ", System.getProperty("name"));
		 extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("User", "Kuseh");
		 		
    }

			
   		

    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub	
    	test = extent.createTest(result.getName());
    	test.createNode(result.getName());
    	test.assignCategory(result.getMethod().getGroups());
    	test.log(Status.PASS, "Test Pass");
        		
    }
  
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub	
    	test = extent.createTest(result.getName());
    	test.createNode(result.getName());
    	test.assignCategory(result.getMethod().getGroups());
    	test.log(Status.FAIL, "Test Failed");
    	test.log(Status.FAIL, result.getThrowable().getMessage());
    	
        		
    }		

    		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub	
    	test = extent.createTest(result.getName());
    	test.createNode(result.getName());
    	test.assignCategory(result.getMethod().getGroups());
    	test.log(Status.SKIP, "Test Skipped");
    	test.log(Status.SKIP, result.getThrowable().getMessage());
        		
    }		

public void onFinish(ITestContext arg0) {		
		
		extent.flush();
}
    
    
//    @Override		
//    public void onTestStart(ITestResult arg0) {					
//        // TODO Auto-generated method stub				
//        		
//    }		

    
//  public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
//  // TODO Auto-generated method stub				
//  		
//}	
    	
   		
}
