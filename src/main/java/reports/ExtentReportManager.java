//package reports;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReportManager {
//	
//	public static ExtentReports vidoeGameExtentReport;
//	
//	public static ExtentReports createExtentReportInstance (String fileName,String reportName, String documentTitle ) {
//
//		ExtentSparkReporter videoGamesparkReport = new ExtentSparkReporter(fileName);		
//		videoGamesparkReport.config().setDocumentTitle(documentTitle);
//		videoGamesparkReport.config().setReportName(reportName);
//		videoGamesparkReport.config().setTheme(Theme.DARK);
//		videoGamesparkReport.config().setEncoding("utf-8");
//		
//		vidoeGameExtentReport = new ExtentReports();		
//		vidoeGameExtentReport.attachReporter(videoGamesparkReport);
//		
//		return  vidoeGameExtentReport;
//
//	}
//
//	
//	public static String getReportName() {
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
//		LocalDateTime localDateTime = LocalDateTime.now();		
//		String formattedTime = dateTimeFormatter.format(localDateTime);
//		String reportName = "VideoGameReport" + formattedTime + ".html";
//		
//		return reportName;
//	}
//	
//	
//}
