using System;
using System.Collections.Generic;
using System.Text;

namespace SeleniumAutomation
{
    public class TestCases
    {
        public string TestSteps { get; set; }
        public string LocatorType { get; set; }
        public string LocatorTypeValue { get; set; }
        public string Action { get; set; }
        public string Value { get; set; }
        public string IsRun { get; set; }
        public bool  IsPassed { get; set; }
        public string ActualValue{ get; set; }
    }
}

