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

           TestDBContext td = new TestDBContext();

         var data=   td.BillCOde.ToList();


            MyDriver myDriver = new MyDriver();
            Readxlxscs rd = new Readxlxscs();

            rd.OpenExcel("C:\\SharpernCSharp\\MorePractice\\CSR\\DataTest.xlsx");
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

            we.Write(lstTestCases, "C:\\Driver\\Report.xlsx");

            var strJson = JsonConvert.SerializeObject(lstTestCases);

            File.WriteAllText("C:\\Driver\\data.js", "var allData=" + strJson);
            Console.ReadKey();
        }
    }
}
