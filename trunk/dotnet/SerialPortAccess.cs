using System;
using System.ComponentModel;
using System.Collections.Generic;
using System.IO.Ports;
using System.Text;


/* 
 * Creates a serial connection to a CurrentCost meter, and uses it
 *  to get a single update.
 * 
 * Uses the CurrentCostUpdate class to parse the data and represent
 *  it as a .NET object.
 *  
 * Dale Lane (http://dalelane.co.uk/blog)
 *  
 */

namespace CurrentCost
{
    public class SerialPortAccess
    {
        public string ComPort = "COM20";
        public int BaudRate = 9600;
        public int Timeout = 12000;

        private SerialPort serialPortObj;

        public CurrentCostUpdate GetSingleUpdate()
        {
            try
            {
                serialPortObj = new SerialPort();
                serialPortObj.PortName = ComPort;
                serialPortObj.BaudRate = BaudRate;
                serialPortObj.ReadTimeout = Timeout;
                serialPortObj.DtrEnable = true;
                serialPortObj.Open();

                while (true)
                {
                    CurrentCostUpdate update = new CurrentCostUpdate(serialPortObj.ReadLine());

                    if (update.ValidUpdate)
                    {
                        serialPortObj.Close();
                        return update;
                    }
                }
            }
            catch (TimeoutException exc)
            {
                throw new ConnectTimeoutException(exc);
            }
            catch (UnauthorizedAccessException exc)
            {
                throw new ConnectFailException(exc);
            }
            catch (Exception exc)
            {
                throw new ConnectFailException(exc);
            }
        }


        public class ConnectFailException : Exception
        {
            public Exception ImplException = null;

            public ConnectFailException(Exception exc)
            {
                ImplException = exc;
            }
        }
        public class ConnectTimeoutException : Exception
        {
            public Exception ImplException = null;

            public ConnectTimeoutException(Exception exc)
            {
                ImplException = exc;
            }
        }
    }
}