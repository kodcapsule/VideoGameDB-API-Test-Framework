//package reports;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//
//import com.aventstack.extentreports.ExtentReports;
//
//public class SetUp implements ITestListener {
//	
//	private static ExtentReports extentReports;
//	
//	public void onStart(ITestContext context) {
//	    //test.log(Status.INFO, "Test Execution Started");
//		
//		String fileName = ExtentReportManager.getReportName();
//		String fullReportName = System.getProperty("user.dir") + "/test-output/ExtentReport/"+fileName;
//		extentReports = ExtentReportManager.createExtentReportInstance(fullReportName, "Video game Automation report"," Video Game test Execution report");
//	  }
//
//	  public void onFinish(ITestContext context) {
//		//test.log(Status.INFO, "Test Execution Started");
//		  if (extentReports != null)
//			  extentReports.flush();
//			  
//	  }
//}
