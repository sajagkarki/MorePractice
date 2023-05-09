using NPOI.Util.Collections;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSR
{
    public class ReadProperty
    {
        Properties p = new Properties();

        public void OpenProperty()
        {
            string path = @"data.properties";
            // This example will give you idea about File handling with properties 
            FileStream fs = null;
            try
            {
                fs = new FileStream(path, FileMode.Open, FileAccess.ReadWrite);
            }
            catch (FileNotFoundException e1)
            {
                // TODO Auto-generated catch block
                Console.WriteLine(e1.ToString());
                Console.Write(e1.StackTrace);
            }


            try
            {
                System.Text.Encoding.RegisterProvider(System.Text.CodePagesEncodingProvider.Instance);

                p.Load(fs);
                //Console.WriteLine("ReadProperty");
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                Console.WriteLine(e.ToString());
                Console.Write(e.StackTrace);
            }
        }
    
        public string GetValue(string key)
        {
            return p[key]; 
        }
    }



}
