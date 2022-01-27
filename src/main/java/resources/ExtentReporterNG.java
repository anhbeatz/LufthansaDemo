package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    static ExtentReports extent;
    static ExtentReports reports;


    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("test results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;


    }

    public static ExtentReports getRowsObject() {

        String path = System.getProperty("user.dir") + "\\reports\\indexRows.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Table Rows");
        reporter.config().setDocumentTitle("test results");
        reports = new ExtentReports();
        reports.attachReporter(reporter);

        return reports;


    }
}
