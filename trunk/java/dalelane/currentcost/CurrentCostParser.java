package dalelane.currentcost;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/*
 * An SAX helper for XML reading of CurrentCost data. 
 * 
 *  It converts a line of XML received from a CurrentCost meter into
 *   a Java object that represents the data. 
 *   
 *   
 *   Dale Lane (http://dalelane.co.uk/blog)
 */

public class CurrentCostParser extends DefaultHandler {

	/* this is the CurrentCost data object we are creating */
	private CurrentCostUpdate cc = new CurrentCostUpdate();;

	/* returns the CurrentCost data object we created from the XML */
	public CurrentCostUpdate getParsedUpdate()
	{
		return cc;
	}		

	
	/* constants which define each element in the CurrentCost XML */
    public enum CurrentCostXMLElement { DSB, TIMESTAMPHR, TIMESTAMPMIN, TIMESTAMPSEC,
									    METERNAME, METERID, METERTYPE, METERSW, TEMP,
										CH1Wout, CH1Win, CH2Wout, CH2Win, CH3Wout, CH3Win,     									
										HR2, HR4, HR6, HR8, HR10, HR12, HR14,
										HR16, HR18, HR20, HR22, HR24, HR26,
										DAY1, DAY2, DAY3, DAY4, DAY5, DAY6, DAY7,
										DAY8, DAY9, DAY10, DAY11, DAY12, DAY13,
										DAY14, DAY15, DAY16, DAY17, DAY18, DAY19,
										DAY20, DAY21, DAY22, DAY23, DAY24, DAY25,
										DAY26, DAY27, DAY28, DAY29, DAY30, DAY31,
										MTH1, MTH2, MTH3, MTH4, MTH5, MTH6, MTH7,
										MTH8, MTH9, MTH10, MTH11, MTH12,
										YR1, YR2, YR3, YR4 };

	/* internal object which identifies which element 
	 * in the XML we are currently looking at */ 
    private CurrentCostXMLElement currentElement = null;
    
    /* the XML stores the time as HR, MIN and SECs. we will return 
     *  a Calendar object, so we keep the hour, min and sec internal
     *  until we are ready to create the Calendar object. */
    private int timestampSubElementHour = 0;
    private int timestampSubElementMins = 0;
    private int timestampSubElementSecs = 0;

    
    public void startElement(String namespaceURI, 
    						 String localName, 
							 String qualifiedName, 
							 Attributes atts) 
	{    	
    	if      (localName.equals("dsb"))  currentElement = CurrentCostXMLElement.DSB;
    	else if (localName.equals("hr"))   currentElement = CurrentCostXMLElement.TIMESTAMPHR;
    	else if (localName.equals("min"))  currentElement = CurrentCostXMLElement.TIMESTAMPMIN;
    	else if (localName.equals("sec"))  currentElement = CurrentCostXMLElement.TIMESTAMPSEC;
    	else if (localName.equals("name")) currentElement = CurrentCostXMLElement.METERNAME;
    	else if (localName.equals("id"))   currentElement = CurrentCostXMLElement.METERID;
    	else if (localName.equals("type")) currentElement = CurrentCostXMLElement.METERTYPE;
    	else if (localName.equals("sver")) currentElement = CurrentCostXMLElement.METERSW;
    	else if (localName.equals("ch1"))  currentElement = CurrentCostXMLElement.CH1Wout;
    	else if (localName.equals("ch2"))  currentElement = CurrentCostXMLElement.CH2Wout;
    	else if (localName.equals("ch3"))  currentElement = CurrentCostXMLElement.CH3Wout;
    	else if (localName.equals("tmpr")) currentElement = CurrentCostXMLElement.TEMP;
    	else if (localName.equals("h02"))  currentElement = CurrentCostXMLElement.HR2;
    	else if (localName.equals("h04"))  currentElement = CurrentCostXMLElement.HR4;
    	else if (localName.equals("h06"))  currentElement = CurrentCostXMLElement.HR6;
    	else if (localName.equals("h08"))  currentElement = CurrentCostXMLElement.HR8;
    	else if (localName.equals("h10"))  currentElement = CurrentCostXMLElement.HR10;
    	else if (localName.equals("h12"))  currentElement = CurrentCostXMLElement.HR12;
    	else if (localName.equals("h14"))  currentElement = CurrentCostXMLElement.HR14;
    	else if (localName.equals("h16"))  currentElement = CurrentCostXMLElement.HR16;
    	else if (localName.equals("h18"))  currentElement = CurrentCostXMLElement.HR18;
    	else if (localName.equals("h20"))  currentElement = CurrentCostXMLElement.HR20;
    	else if (localName.equals("h22"))  currentElement = CurrentCostXMLElement.HR22;
    	else if (localName.equals("h24"))  currentElement = CurrentCostXMLElement.HR24;
    	else if (localName.equals("h26"))  currentElement = CurrentCostXMLElement.HR26;
    	else if (localName.equals("h20"))  currentElement = CurrentCostXMLElement.HR20;
    	else if (localName.equals("d01"))  currentElement = CurrentCostXMLElement.DAY1;
    	else if (localName.equals("d02"))  currentElement = CurrentCostXMLElement.DAY2;
    	else if (localName.equals("d03"))  currentElement = CurrentCostXMLElement.DAY3;
    	else if (localName.equals("d04"))  currentElement = CurrentCostXMLElement.DAY4;
    	else if (localName.equals("d05"))  currentElement = CurrentCostXMLElement.DAY5;
    	else if (localName.equals("d06"))  currentElement = CurrentCostXMLElement.DAY6;
    	else if (localName.equals("d07"))  currentElement = CurrentCostXMLElement.DAY7;
    	else if (localName.equals("d08"))  currentElement = CurrentCostXMLElement.DAY8;
    	else if (localName.equals("d09"))  currentElement = CurrentCostXMLElement.DAY9;
    	else if (localName.equals("d10"))  currentElement = CurrentCostXMLElement.DAY10;
    	else if (localName.equals("d11"))  currentElement = CurrentCostXMLElement.DAY11;
    	else if (localName.equals("d12"))  currentElement = CurrentCostXMLElement.DAY12;
    	else if (localName.equals("d13"))  currentElement = CurrentCostXMLElement.DAY13;
    	else if (localName.equals("d14"))  currentElement = CurrentCostXMLElement.DAY14;
    	else if (localName.equals("d15"))  currentElement = CurrentCostXMLElement.DAY15;
    	else if (localName.equals("d16"))  currentElement = CurrentCostXMLElement.DAY16;
    	else if (localName.equals("d17"))  currentElement = CurrentCostXMLElement.DAY17;
    	else if (localName.equals("d18"))  currentElement = CurrentCostXMLElement.DAY18;
    	else if (localName.equals("d19"))  currentElement = CurrentCostXMLElement.DAY19;
    	else if (localName.equals("d20"))  currentElement = CurrentCostXMLElement.DAY20;
    	else if (localName.equals("d21"))  currentElement = CurrentCostXMLElement.DAY21;
    	else if (localName.equals("d22"))  currentElement = CurrentCostXMLElement.DAY22;
    	else if (localName.equals("d23"))  currentElement = CurrentCostXMLElement.DAY23;
    	else if (localName.equals("d24"))  currentElement = CurrentCostXMLElement.DAY24;
    	else if (localName.equals("d25"))  currentElement = CurrentCostXMLElement.DAY25;
    	else if (localName.equals("d26"))  currentElement = CurrentCostXMLElement.DAY26;
    	else if (localName.equals("d27"))  currentElement = CurrentCostXMLElement.DAY27;
    	else if (localName.equals("d28"))  currentElement = CurrentCostXMLElement.DAY28;
    	else if (localName.equals("d29"))  currentElement = CurrentCostXMLElement.DAY29;
    	else if (localName.equals("d30"))  currentElement = CurrentCostXMLElement.DAY30;
    	else if (localName.equals("d31"))  currentElement = CurrentCostXMLElement.DAY31;
    	else if (localName.equals("m01"))  currentElement = CurrentCostXMLElement.MTH1;
    	else if (localName.equals("m02"))  currentElement = CurrentCostXMLElement.MTH2;
    	else if (localName.equals("m03"))  currentElement = CurrentCostXMLElement.MTH3;
    	else if (localName.equals("m04"))  currentElement = CurrentCostXMLElement.MTH4;
    	else if (localName.equals("m05"))  currentElement = CurrentCostXMLElement.MTH5;
    	else if (localName.equals("m06"))  currentElement = CurrentCostXMLElement.MTH6;
    	else if (localName.equals("m07"))  currentElement = CurrentCostXMLElement.MTH7;
    	else if (localName.equals("m08"))  currentElement = CurrentCostXMLElement.MTH8;
    	else if (localName.equals("m09"))  currentElement = CurrentCostXMLElement.MTH9;
    	else if (localName.equals("m10"))  currentElement = CurrentCostXMLElement.MTH10;
    	else if (localName.equals("m11"))  currentElement = CurrentCostXMLElement.MTH11;
    	else if (localName.equals("m12"))  currentElement = CurrentCostXMLElement.MTH12;
    	else if (localName.equals("y1"))   currentElement = CurrentCostXMLElement.YR1; 
    	else if (localName.equals("y2"))   currentElement = CurrentCostXMLElement.YR2;
    	else if (localName.equals("y3"))   currentElement = CurrentCostXMLElement.YR3;
    	else if (localName.equals("y4"))   currentElement = CurrentCostXMLElement.YR4;
    	else if (localName.equals("watts"))
    	{
    		/* <watts> is inside <CH1>, <CH2> or <CH3> 
    		 *  so we need to check what was the last element we started, to know
    		 *  which <watts> element we're looking at now */
    		switch(currentElement)
    		{
				case CH1Wout: currentElement = CurrentCostXMLElement.CH1Win; break;
				case CH2Wout: currentElement = CurrentCostXMLElement.CH2Win; break;
				case CH3Wout: currentElement = CurrentCostXMLElement.CH3Win; break;		
    		}
    	}
	}
    
    /* last thing we do once we have completed parsing the CurrentCost XML 
     * is to create a timestamp object based on the hour, minute and second
     * values that were in the XML */
	public void endDocument() throws SAXException 
	{
		cc.TimeStamp = new GregorianCalendar();
		cc.TimeStamp.set(Calendar.HOUR_OF_DAY, timestampSubElementHour);
		cc.TimeStamp.set(Calendar.MINUTE, 		timestampSubElementMins);
		cc.TimeStamp.set(Calendar.SECOND, 		timestampSubElementSecs);
		
		/* mark the parsed object as complete */
		cc.ValidUpdate = true;
	}

	/* 
	 * read the data from a CurrentCost XML element
	 */
	public void characters(char[] ch, int start, int length) throws SAXException 
	{
		if (currentElement != null)
		{
			// read the XML data as a string 
			
			StringBuilder currentElementValue = new StringBuilder(length); 
			
			for (int i = start; i < (start + length); i++)
			{
				currentElementValue.append(ch[i]);
			}
			
			// cast to required format
			
			float currentElementFloat = -1;
			int   currentElementInt   = -1;
						
			switch (currentElement)
			{
				// string values
				case METERNAME:
				case METERSW:
					// no conversion necessary
					break;
			
				// float values
				case TEMP:
				case HR2:
				case HR4:
				case HR6:
				case HR8:
				case HR10:
				case HR12:
				case HR14:
				case HR16:
				case HR18:
				case HR20:
				case HR22:
				case HR24:
				case HR26:
					currentElementFloat = Float.parseFloat(currentElementValue.toString());
					break;
					
				// int values
				case DSB:
				case TIMESTAMPHR:
				case TIMESTAMPMIN:
				case TIMESTAMPSEC:
				case METERID:
				case METERTYPE:
				case CH1Win:
				case CH2Win:
				case CH3Win:
				case DAY1:
				case DAY2:
				case DAY3:
				case DAY4:
				case DAY5:
				case DAY6:
				case DAY7:
				case DAY8:
				case DAY9:
				case DAY10:
				case DAY11:
				case DAY12:
				case DAY13:
				case DAY14:
				case DAY15:
				case DAY16:
				case DAY17:
				case DAY18:
				case DAY19:
				case DAY20:
				case DAY21:
				case DAY22:
				case DAY23:
				case DAY24:
				case DAY25:
				case DAY26:
				case DAY27:
				case DAY28:
				case DAY29:
				case DAY30:
				case DAY31:
				case MTH1:
				case MTH2:
				case MTH3:
				case MTH4:
				case MTH5:
				case MTH6:
				case MTH7:
				case MTH8:
				case MTH9:
				case MTH10:
				case MTH11:
				case MTH12:
				case YR1:
				case YR2:
				case YR3:
				case YR4:
					currentElementInt = Integer.parseInt(currentElementValue.toString());
					break;
			}
			
			// store the data in the correct attribute of the object 
			
			switch (currentElement)
			{
				case METERNAME: cc.MeterName = currentElementValue.toString(); break;
				case METERSW:   cc.MeterSoftwareVersion = currentElementValue.toString(); break;
				
				case TEMP:		cc.Temperature  = currentElementFloat; break;          
				case HR2:		cc.kWattsHour02 = currentElementFloat; break;
				case HR4:		cc.kWattsHour04 = currentElementFloat; break;
				case HR6:		cc.kWattsHour06 = currentElementFloat; break;
				case HR8:		cc.kWattsHour08 = currentElementFloat; break;
				case HR10:		cc.kWattsHour10 = currentElementFloat; break;
				case HR12:      cc.kWattsHour12 = currentElementFloat; break;
				case HR14:      cc.kWattsHour14 = currentElementFloat; break;
				case HR16:		cc.kWattsHour16 = currentElementFloat; break;
				case HR18:		cc.kWattsHour18 = currentElementFloat; break;
				case HR20:		cc.kWattsHour20 = currentElementFloat; break;
				case HR22:		cc.kWattsHour22 = currentElementFloat; break;
				case HR24:		cc.kWattsHour24 = currentElementFloat; break;
				case HR26:		cc.kWattsHour26 = currentElementFloat; break;
					
				case TIMESTAMPHR:	timestampSubElementHour = currentElementInt; break;
				case TIMESTAMPMIN:  timestampSubElementMins = currentElementInt; break;
				case TIMESTAMPSEC:  timestampSubElementSecs = currentElementInt; break;
				case DSB:           cc.DaysSinceBirth = currentElementInt; break;
				case METERID:       cc.MeterId = currentElementInt; break;
				case METERTYPE:     cc.MeterType = currentElementInt; break;
				case CH1Win:		cc.Channel1Watts = currentElementInt; break;
				case CH2Win:		cc.Channel2Watts = currentElementInt; break;
				case CH3Win:		cc.Channel3Watts = currentElementInt; break;
				case DAY1:			cc.WattsDay01 = currentElementInt; break;
				case DAY2:			cc.WattsDay02 = currentElementInt; break;
				case DAY3:			cc.WattsDay03 = currentElementInt; break;
				case DAY4:			cc.WattsDay04 = currentElementInt; break;
				case DAY5:			cc.WattsDay05 = currentElementInt; break;
				case DAY6:			cc.WattsDay06 = currentElementInt; break;
				case DAY7:			cc.WattsDay07 = currentElementInt; break;
				case DAY8:			cc.WattsDay08 = currentElementInt; break;
				case DAY9:			cc.WattsDay09 = currentElementInt; break;
				case DAY10:			cc.WattsDay10 = currentElementInt; break;
				case DAY11:			cc.WattsDay11 = currentElementInt; break;
				case DAY12:			cc.WattsDay12 = currentElementInt; break;
				case DAY13:			cc.WattsDay13 = currentElementInt; break;
				case DAY14:			cc.WattsDay14 = currentElementInt; break;
				case DAY15:			cc.WattsDay15 = currentElementInt; break;
				case DAY16:			cc.WattsDay16 = currentElementInt; break;
				case DAY17:			cc.WattsDay17 = currentElementInt; break;			
				case DAY18:			cc.WattsDay18 = currentElementInt; break;
				case DAY19:			cc.WattsDay19 = currentElementInt; break;
				case DAY20:			cc.WattsDay20 = currentElementInt; break;
				case DAY21:			cc.WattsDay21 = currentElementInt; break;
				case DAY22:			cc.WattsDay22 = currentElementInt; break;
				case DAY23:			cc.WattsDay23 = currentElementInt; break;
				case DAY24:			cc.WattsDay24 = currentElementInt; break;
				case DAY25:			cc.WattsDay25 = currentElementInt; break;
				case DAY26:			cc.WattsDay26 = currentElementInt; break;
				case DAY27:			cc.WattsDay27 = currentElementInt; break;
				case DAY28:			cc.WattsDay28 = currentElementInt; break;
				case DAY29:			cc.WattsDay29 = currentElementInt; break;
				case DAY30:			cc.WattsDay30 = currentElementInt; break;
				case DAY31:			cc.WattsDay31 = currentElementInt; break;
				case MTH1:			cc.WattsMonth01 = currentElementInt; break; 
				case MTH2:			cc.WattsMonth02 = currentElementInt; break;
				case MTH3:			cc.WattsMonth03 = currentElementInt; break;
				case MTH4:			cc.WattsMonth04 = currentElementInt; break;
				case MTH5:			cc.WattsMonth05 = currentElementInt; break;
				case MTH6:			cc.WattsMonth06 = currentElementInt; break;
				case MTH7:			cc.WattsMonth07 = currentElementInt; break;
				case MTH8:			cc.WattsMonth08 = currentElementInt; break;
				case MTH9:			cc.WattsMonth09 = currentElementInt; break;
				case MTH10:			cc.WattsMonth10 = currentElementInt; break;
				case MTH11:			cc.WattsMonth11 = currentElementInt; break;
				case MTH12:			cc.WattsMonth12 = currentElementInt; break;
				case YR1:			cc.WattsYear1 = currentElementInt; break;
				case YR2:			cc.WattsYear2 = currentElementInt; break;
				case YR3:			cc.WattsYear3 = currentElementInt; break;
				case YR4:			cc.WattsYear4 = currentElementInt; break;
			}			
		}
	}		
}