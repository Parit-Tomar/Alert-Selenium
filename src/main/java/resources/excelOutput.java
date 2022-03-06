package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelOutput {
	


public ArrayList<testSample> getData(String testcaseName) throws IOException {
		
		ArrayList<String> a= new ArrayList<String>();
		ArrayList<testSample> tsArray= new ArrayList<testSample>();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\parit.tomar\\Desktop\\Documents\\demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets= workbook.getNumberOfSheets();
		for(int i =0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("SheetTwo"))
			{
			XSSFSheet sheet=workbook.getSheetAt(i);
			//Identify Test Cases column by scanning entire list row
			Iterator<Row> rows=sheet.iterator(); //Sheet is collection of rows
			Row firstrow=rows.next();
			Iterator<Cell> firstHeader=firstrow.cellIterator(); //row is collection of cell
			ArrayList<String> headerArr = new ArrayList<String>();
			while(firstHeader.hasNext())
			{
				headerArr.add(firstHeader.next().getStringCellValue());
			}
			
			int k=0;
			while(rows.hasNext()) {
				Row nextRow=rows.next();
				Iterator<Cell> nextCell= nextRow.cellIterator();
				testSample ts = new testSample();
				int column=0;
				while(nextCell.hasNext())
				{
					Cell perCellValue = nextCell.next();
					//System.out.println(perCellValue.getStringCellValue());
					
					if(headerArr.get(column).equalsIgnoreCase("Rule Name"))
						ts.setRuleName(perCellValue.getStringCellValue());
					if(headerArr.get(column).equalsIgnoreCase("Metric Group"))
						ts.setMetricGroup(perCellValue.getStringCellValue());
					if(headerArr.get(column).equalsIgnoreCase("Metric Name"))
						ts.setMetricName(perCellValue.getStringCellValue());
					if(headerArr.get(column).equalsIgnoreCase("Condition Type"))
						ts.setConditionType(perCellValue.getStringCellValue());
					if(headerArr.get(column).equalsIgnoreCase("Trigger When"))
						ts.setTriggerWhen(perCellValue.getStringCellValue());
					if(headerArr.get(column).equalsIgnoreCase("Threshold Cri"))
						ts.setCriticalThreshold(NumberToTextConverter.toText(perCellValue.getNumericCellValue()));
					if(headerArr.get(column).equalsIgnoreCase("Threshold Maj"))
						ts.setMajorThreshold(NumberToTextConverter.toText(perCellValue.getNumericCellValue()));
					if(headerArr.get(column).equalsIgnoreCase("Threshold Min"))
						ts.setMinorThreshold(NumberToTextConverter.toText(perCellValue.getNumericCellValue())); 
					column++;
				}
				tsArray.add(ts);
			}
			System.out.println(tsArray);
			/*
			 * while(ce.hasNext()) { Cell value =ce.next();
			 * if(value.getStringCellValue().equalsIgnoreCase("Testcases")) { //desired
			 * column column=k; } k++; //System.out.println("k"+k);
			 * 
			 * }
			 */
			//System.out.println("column" + column);
			//once column is identified then scan test case column to identify 'Purchase' test case
			/*
			 * while(rows.hasNext()) { Row r=rows.next();
			 * if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
			 * //after u grab purchase test case -> pull all the data of that row and feed
			 * into test
			 * 
			 * Iterator<Cell>cv=r.cellIterator(); while(cv.hasNext()) { Cell c= cv.next();
			 * if(c.getCellType()==CellType.STRING) {
			 * 
			 * a.add(c.getStringCellValue()); } else{
			 * 
			 * a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
			 * 
			 * } }
			 * 
			 * }
			 * 
			 * 
			 * 
			 * }
			 */
			
			
			}
		}
		return tsArray;
	}

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		//File Input Stream arguments 
		
		

	}

}
