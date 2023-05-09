using CSR;
using Newtonsoft.Json;
using NPOI.SS.UserModel;
using NPOI.XSSF.UserModel;
using SeleniumTestDec;
using System;
using System.IO;


namespace SeleniumAutomation
{
    class Program
    {
        static void Main(string[] args)
        {

            //TestDBContext td = new TestDBContext();

            //var data=   td.BillCOde.ToList();

            
            MyDriver myDriver = new MyDriver();
            Readxlxscs rd = new Readxlxscs();
            ReadProperty rp= new ReadProperty();
            rp.OpenProperty(); 
            string filePath= rp.GetValue("ExcelPath");

            string copyPath = rp.GetValue("CopyPath");
            copyPath= string.Format(copyPath, DateTime.Now.Ticks);
            // System.IO.File.Copy("C:\\Repos\\MorePractice\\CSR\\DataTest.xlsx", "C:\\Repos\\MorePractice\\CSR\\DataTestCopy.xlsx",true); 
            System.IO.File.Copy(filePath, copyPath,true);
            rd.OpenExcel(copyPath);
            //rd.OpenExcel("C:\\Repos\\MorePractice\\CSR\\DataTestCopy.xlsx");
            rd.ReadSheet("Sheet1");
            var lstTestCases = rd.GetTestCases();
            for (int i = 0; i < lstTestCases.Count; i++)
            {
                if ("y".Equals(lstTestCases[i].IsRun, StringComparison.OrdinalIgnoreCase))
                {

                    myDriver.Exceute(lstTestCases[i]);
                    Console.WriteLine("Test Case " + (i + 1) + " " + lstTestCases[i].TestSteps);
                    if (!lstTestCases[i].IsPassed)
                    {
                        Console.WriteLine(lstTestCases[i].TestSteps + $" is Failed :Actual value is {lstTestCases[i].ActualValue } and Expected value is {lstTestCases[i].Value} ");

                    }
                    else
                    {
                        Console.WriteLine(" Test is passed");
                    }
                }


            }
            WriteExcel we = new WriteExcel();
            string ReportPath = rp.GetValue("ReportPath");
            ReportPath = string.Format(ReportPath, DateTime.Now.Ticks);
            string ReportPathjs = rp.GetValue("ReportPathjs");
            ReportPathjs = string.Format(ReportPathjs, DateTime.Now.Ticks);
            we.Write(lstTestCases, ReportPath);

            var strJson = JsonConvert.SerializeObject(lstTestCases);

            File.WriteAllText(ReportPathjs, "var allData=" + strJson);

            rd.closeWorkBook();
            File.Delete(copyPath);
            Console.ReadKey();
        }
    }
}
