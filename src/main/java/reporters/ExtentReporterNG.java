package reporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ExtentReporterNG {

    public static ExtentReports extent;
    public static LocalDate localDate = LocalDate.now();
    public static DateTimeFormatter dayFmt = DateTimeFormat.forPattern("dd-MM-yyyy");
    public static String dateStr = localDate.toString(dayFmt);

    public static ExtentReports getReportObject() {
        String path = "C:\\Cursos\\JavaSelFramework\\MySeleniumFramework\\src\\reports\\report_" + dateStr +".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
        try {
            extent.setSystemInfo("Machine", InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            System.out.println("Unable to capture hostname.");
        }

        return extent;
    }
}
