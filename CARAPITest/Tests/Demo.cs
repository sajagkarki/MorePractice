using Newtonsoft.Json;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CARAPITest
{
    internal class Demo
    {
        public ListData GetData()
        {
            var restClient = new RestClient("HTTPS://slcweb501.tdwilliamson.com:8443/car/rest/private");
            var restRequest = new RestRequest("/ api / rest", Method.Get);
            restRequest.AddHeader("Accept", "application/json"); 
            restRequest.RequestFormat = DataFormat.Json;

            RestResponse response = restClient.Execute(restRequest); 
            var content= response.Content;

            var users= JsonConvert.DeserializeObject<ListData>(content);
            return users;
        }


    }
}
