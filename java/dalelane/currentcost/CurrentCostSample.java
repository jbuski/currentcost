package dalelane.currentcost;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/*
 * Parses data from a CurrentCost meter
 *  
 *  Note that this is provided to help get you started, but it lacks careful 
 *   error-handling or proper documentation.
 *  
 *  If you have any questions about it, or even just find it useful, please do 
 *   let me know - dale.lane@gmail.com
 *  
 *  
 *   Dale Lane (http://dalelane.co.uk/blog)
 */

public class CurrentCostSample {

	public static String COMPORT  = "COM21";
	public static int    BAUDRATE = 9600;
	
	
	/* 
	 * An example implementation that uses the sample classes. 
	 * 
	 * It connects to 
	 */
	public static void main(String[] args)
	{
		/* represents the COM port we connected the CurrentCost meter to */
		SerialPort serialport = null;
		
		/* the XML parser that will read the CurrentCost data */
		CurrentCostParser handler = new CurrentCostParser();
		
		try 
		{
			/* prepare the XML parser */
	        XMLReader parser = XMLReaderFactory.createXMLReader();
	        parser.setContentHandler(handler);
	        
	        /* specify the parameters to connect to the CurrentCost meter */
			CommPortIdentifier comportid = CommPortIdentifier.getPortIdentifier(COMPORT);
			
			serialport = (SerialPort)comportid.open("CurrentCostJava", 5000);
			
			serialport.setSerialPortParams(BAUDRATE, 
										   SerialPort.DATABITS_8, 
										   SerialPort.STOPBITS_1, 
										   SerialPort.PARITY_NONE);

			/* specify this to handle issues using USB-to-serial connector */
			serialport.notifyOnOutputEmpty(true);
			
			/* read data from CurrentCost meter */
			BufferedReader br = new BufferedReader(new InputStreamReader(serialport.getInputStream()));
			
			String lineOfXML = "";
			
			/* we will probably need a few attempts before we get a valid update
			 * as it is not unusual to get a partial line
			 * 
			 * the quickest sanity-check on an CurrentCost update, is whether it 
			 * is at least as long as it should be                                */
			while (lineOfXML.length() < 1200)
			{
				try 
				{
					lineOfXML = br.readLine();
				}
				catch (IOException exc)
				{
					lineOfXML = "";
				}
			}
			
			/* create an inputsource from the line of XML we have - putting 
			 * it in a format that the XML parser can accept    */
			StringReader sr = new StringReader(lineOfXML);			
			InputSource isrc = new InputSource(sr);

			/* parse the CurrentCost update */
			parser.parse(isrc);			
			
		} 
		catch (NoSuchPortException e) 				
		{
			e.printStackTrace();
		}
		catch (PortInUseException e)  				
		{
			e.printStackTrace();
		}
		catch (UnsupportedCommOperationException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 						
		{
			e.printStackTrace();
		}
		catch (SAXException e) 						
		{
			e.printStackTrace();
		}
		
		
		/* we've finished with the COM port, so we close it now */
		if (serialport != null)
		{
			serialport.close();
		}
		
		/* we get the parsed update - a Java object that represents the 
		 *  data that was in the XML we received from the CurrentCost meter */
		CurrentCostUpdate ccupd = handler.getParsedUpdate();

		/* we now convert the CurrentCostUpdate object - containing data
		 * with relative time descriptions - into a collection of absolute 
		 * time descriptions                                                */
		CurrentCostHistory cchist = new CurrentCostHistory();
		cchist.UpdateData(ccupd);
		
		/* did it work? we print out the data we received as a sanity check */
		System.out.println(cchist);
	}
	
}
