using CSR;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace SeleniumTestDec
{
    public class TestDBContext : DbContext
    {

        public TestDBContext()
        {

        }

         protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Data Source=PIESQL301\QA01;Initial Catalog=CompletedRuns;Integrated Security=True");
        }

        public DbSet<BillCOde> BillCOde { get; set; }

        
    }
}
