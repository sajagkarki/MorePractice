using Microsoft.Win32.SafeHandles;
using NPOI.SS.UserModel;
using NPOI.XSSF.UserModel;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace SeleniumAutomation
{
    public class Readxlxscs
    {
        XSSFWorkbook workbook = null;
        ISheet sheet = null;


        public void OpenExcel(string path)
        {
            FileStream inputstream = null;
            try
            {

                inputstream = new FileStream(path, FileMode.Open, FileAccess.Read);
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated catch block
                Console.WriteLine(e.ToString());
                Console.Write(e.StackTrace);
            }



            try
            {
                workbook = new XSSFWorkbook(inputstream);
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                Console.WriteLine(e.ToString());
                Console.Write(e.StackTrace);
            }
        }
        public void ReadSheet(string sheetname)
        {
            sheet = workbook.GetSheet(sheetname);
        }
        public int GetRowCount()
        {
            return sheet.LastRowNum;
        }
        public TestCases GetTestCase(int rowNumber)
        {
            IRow row = sheet.GetRow(rowNumber);
            if (row==null||row.LastCellNum<5)
            {
                return null; 
            }
            TestCases testcase = new TestCases();
           
            testcase.TestSteps = GetCellValue( row.GetCell(0));
            testcase.LocatorType = GetCellValue(row.GetCell(1));
            testcase.LocatorTypeValue = GetCellValue(row.GetCell(2));
            testcase.Action = GetCellValue( row.GetCell(3));
            testcase.Value = GetCellValue( row.GetCell(4));
            testcase.IsRun = GetCellValue( row.GetCell(5));
            return testcase;
        }


        public string GetCellValue(ICell cell)
        {
            if (cell == null)
            {
                return "";
            }
            switch (cell.CellType)
            {
                case CellType.String:
                   return cell.StringCellValue;
                    break;
                case CellType.Numeric:
                    return cell.NumericCellValue.ToString();
                    break;
                case CellType.Boolean:
                    return cell.BooleanCellValue.ToString();
                    break;
                case CellType.Formula:
                    return cell.CellFormula.ToString();
                default:
                    return "";

            }

        }

        public List<TestCases> GetTestCases()
        {
            List<TestCases> testCases = new List<TestCases>();
            int rowCount = GetRowCount();
            for (int r = 1; r <= rowCount; r = r + 1)
            {

                try
                {
                   var test= GetTestCase(r);
                    if (test==null)
                    {
                        continue; 
                    }
                    testCases.Add(GetTestCase(r));
                }
                catch (Exception)
                {

                   
                }
               
            }

            return testCases;
        }

    }
}

