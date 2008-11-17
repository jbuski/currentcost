package dalelane.currentcost;

import java.util.GregorianCalendar;

/*
 * Represents the data contained in a single update from a CurrentCost meter
 *
 * It's a Java object representation of the XML - as described here:
 * http://cumbers.wordpress.com/2008/05/07/breakdown-of-currentcost-xml-output/
 *
 *  Dale Lane (http://dalelane.co.uk/blog)
 */

public class CurrentCostUpdate  
{
    public boolean ValidUpdate = false;

    public int DaysSinceBirth;
    public GregorianCalendar TimeStamp;
    public String MeterName;
    public int MeterId;
    public int MeterType;
    public String MeterSoftwareVersion;
    public int Channel1Watts;
    public int Channel2Watts;
    public int Channel3Watts;
    public float Temperature;
    public float kWattsHour02;
    public float kWattsHour04;
    public float kWattsHour06;
    public float kWattsHour08;
    public float kWattsHour10;
    public float kWattsHour12;
    public float kWattsHour14;
    public float kWattsHour16;
    public float kWattsHour18;
    public float kWattsHour20;
    public float kWattsHour22;
    public float kWattsHour24;
    public float kWattsHour26;
    public int WattsDay01;
    public int WattsDay02;
    public int WattsDay03;
    public int WattsDay04;
    public int WattsDay05;
    public int WattsDay06;
    public int WattsDay07;
    public int WattsDay08;
    public int WattsDay09;
    public int WattsDay10;
    public int WattsDay11;
    public int WattsDay12;
    public int WattsDay13;
    public int WattsDay14;
    public int WattsDay15;
    public int WattsDay16;
    public int WattsDay17;
    public int WattsDay18;
    public int WattsDay19;
    public int WattsDay20;
    public int WattsDay21;
    public int WattsDay22;
    public int WattsDay23;
    public int WattsDay24;
    public int WattsDay25;
    public int WattsDay26;
    public int WattsDay27;
    public int WattsDay28;
    public int WattsDay29;
    public int WattsDay30;
    public int WattsDay31;
    public int WattsMonth01;
    public int WattsMonth02;
    public int WattsMonth03;
    public int WattsMonth04;
    public int WattsMonth05;
    public int WattsMonth06;
    public int WattsMonth07;
    public int WattsMonth08;
    public int WattsMonth09;
    public int WattsMonth10;
    public int WattsMonth11;
    public int WattsMonth12;
    public int WattsYear1;
    public int WattsYear2;
    public int WattsYear3;
    public int WattsYear4;    
}