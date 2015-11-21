using System;
using System.Collections.Generic;
using System.Web;
using System.Web.Services;

namespace WebService1
{
    /// <summary>
    /// Summary description for Service1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)] //free for use use
    [System.ComponentModel.ToolboxItem(false)]
    public class Service1 : System.Web.Services.WebService
    {
		
		
	// automatically generated
        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

	// Web method for converting fahrenheit to centigrade	
        [WebMethod]
        public float Fahrenheit_To_Centigrade(float Fahrenheit)
        {
            return (float)((Fahrenheit-32)*(5.0/9.0));
        }

	// Web method for converting centigrade to fahrenheit
        [WebMethod]
        public float Centigrade_To_Fahrenheit(float Centigrade)
        {
            return (float)((Centigrade * 1.8) + 32);
        }

	// Web method for converting centigrade to kelvin
        [WebMethod]
        public float Centigrade_To_Kelvin(float Centigrade)
        {
            return (float)((Centigrade + 273.15));
        }

	// Web method for converting fahrenheit to kelvin;
	// Uses Fahrenheit_To_Centigrade method to convert fahrenheit to centigrade first, then converts it to Kelvin
        [WebMethod]
        public float Fahrenheit_To_Kelvin(float Fahrenheit)
        {
            return (float)((Fahrenheit_To_Centigrade(Fahrenheit)) + 273.15);
        }

	// Web method for converting kelvin to centigrade
        [WebMethod]
        public float Kelvin_To_Centigrade(float Kelvin)
        {
            return (float)((Kelvin - 273.15));
        }

	// Web method for converting kelvin to fahrenheit;
        [WebMethod]
        public float Kelvin_To_Fahrenheit(float Kelvin)
        {
            return (float)((Kelvin_To_Centigrade(Kelvin)*1.8)+32);
        }


    }
}