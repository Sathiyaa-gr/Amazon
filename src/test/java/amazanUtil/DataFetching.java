package amazanUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataFetching {
	@DataProvider(name="logindata")
	public Object[][] getExceldata() throws IOException  {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\anbuj\\eclipse-workspace\\project1\\TestData\\login_fail.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet s1=  wb.getSheet("amazon");
        
        int rowcount=s1.getPhysicalNumberOfRows();
        int colcount=s1.getRow(0).getPhysicalNumberOfCells();
        
        Object[][] data = new Object[rowcount - 1][colcount]; // Skip header
        DataFormatter format = new DataFormatter();
        String user = format.formatCellValue(wb.getSheet("amazon").getRow(1).getCell(0));
        String pwd = format.formatCellValue(wb.getSheet("amazon").getRow(1).getCell(1));

        for (int i = 1; i < rowcount; i++) {
            Row row = s1.getRow(i);
            for (int j = 0; j < colcount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] =format.formatCellValue(cell) ; // convert to string
            }
        }
        wb.close();
        fis.close();
        return data ;
        
	}
	

}
