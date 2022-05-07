using NPOI.HSSF.UserModel;
using System;
using System.Collections.Generic;
using System.Text;
using SeleniumAutomation;
using System.IO;
using NPOI.XSSF.UserModel;

namespace SeleniumAutomation
{
   public  class WriteExcel
    {
        public void Write(List<TestCases> testCases, string filePath)
        {
            var workbook = new XSSFWorkbook();

            //Create new Excel Sheet
            var sheet = workbook.CreateSheet();

            //(Optional) set the width of the columns
            sheet.SetColumnWidth(0, 20 * 256);//Title
            sheet.SetColumnWidth(1, 20 * 256);//Section
            sheet.SetColumnWidth(2, 20 * 256);//Views
            sheet.SetColumnWidth(3, 20 * 256);//Downloads
            sheet.SetColumnWidth(4, 20 * 256);//Status
            /*
             * 
             * 
             *   public string TestSteps { get; set; }
        public string LocatorType { get; set; }
        public string LocatorTypeValue { get; set; }
        public string Action { get; set; }
        public string Value { get; set; }
             public string IsRun { get; set; }
        public bool  IsPassed{ get; set; }
        public string ActualValue{ get; set; }
            */
            var headerRow = sheet.CreateRow(0);
            headerRow.CreateCell(0).SetCellValue("TestSteps");
            headerRow.CreateCell(1).SetCellValue("LocatorType");
            headerRow.CreateCell(2).SetCellValue("LocatorTypeValue");
            headerRow.CreateCell(3).SetCellValue("Action");
            headerRow.CreateCell(4).SetCellValue("Value");
            headerRow.CreateCell(5).SetCellValue("IsRun");
            headerRow.CreateCell(6).SetCellValue("IsPassed");
            headerRow.CreateCell(7).SetCellValue("ActualValue");


            sheet.CreateFreezePane(0, 1, 0, 1);
            int rowNumber = 1;
            foreach (var testcase in testCases)
            {
                //Create a new Row
                var row = sheet.CreateRow(rowNumber++);

                //Set the Values for Cells
                row.CreateCell(0).SetCellValue(testcase.TestSteps);
                row.CreateCell(1).SetCellValue(testcase.LocatorType);
                row.CreateCell(2).SetCellValue(testcase.LocatorTypeValue);
                row.CreateCell(3).SetCellValue(testcase.Action);
                row.CreateCell(4).SetCellValue(testcase.Value);
                row.CreateCell(5).SetCellValue(testcase.IsRun);
                row.CreateCell(6).SetCellValue(testcase.IsPassed);
                row.CreateCell(7).SetCellValue(testcase.ActualValue);


            }


            if (System.IO.File.Exists(filePath))
            {
                System.IO.File.Delete(filePath);
            }

            var fs= new FileStream(filePath, FileMode.CreateNew, FileAccess.ReadWrite);


            workbook.Write(fs);


            //Write the Workbook to a memory stream



        }
    }
}
