using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSR
{
    [Table("BILL_CODE")]
    public class BillCOde
    {

        [Key]
        public Guid BILL_CODE_PK { get; set; }

        public string DESCRIPTION { get; set; }



        public string ABBREVIATION { get; set; }


        public string BILL_CODE_TYPE { get; set; }


    }
}
