using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CARAPITest
{
    internal class ListData
    {
        public partial class Welcome
        {
            public string Name { get; set; }
            public string In { get; set; }
            public string Description { get; set; }
            public bool WelcomeRequired { get; set; }
            public string Type { get; set; }
            public long Default { get; set; }
            public string Format { get; set; }
        }
    }
}
