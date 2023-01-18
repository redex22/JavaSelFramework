package utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import base.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.io.FileUtils;

public class Utils extends Base {

    private Fillo fillo;
    private Connection conn;

    public Utils(){
        fillo = new Fillo();
    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "C:\\Cursos\\JavaSelFramework\\MySeleniumFramework\\src\\reports\\" + testCaseName + "_"
                + ThreadLocalRandom.current().nextInt() + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }

    public HashMap<String, String> getExcelData(String sheetName, String dataPath, String idColumn,
                                                String id) throws FilloException, IOException {

        HashMap<String, String> data = new HashMap<String, String>();
        String testDataFilePath = loadConfig().getProperty(dataPath);

        conn = fillo.getConnection(testDataFilePath);
        //String strQuery = "Select * from formData where TCID='" + id + "'";
        String strQuery = "Select * from " + sheetName;
        if (!idColumn.isEmpty()){
            strQuery = strQuery + " where " + idColumn + " = '" + id + "'";
        }
        Recordset recordset = conn.executeQuery(strQuery);

        excelDataToHashMap(recordset, data);

        recordset.close();
        conn.close();

        return data;
    }


    private void excelDataToHashMap(Recordset rs, HashMap hm) throws FilloException {
        while (rs.next()) {
            ArrayList<String> columnNames = rs.getFieldNames();
            for (String name : columnNames) {
                hm.put(name, rs.getField(name));
            }
        }
    }
}
