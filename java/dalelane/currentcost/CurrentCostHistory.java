package dalelane.currentcost;

import java.util.Enumeration;
import java.util.Hashtable;

import dalelane.currentcost.calendar.DayData;
import dalelane.currentcost.calendar.HourData;
import dalelane.currentcost.calendar.MonthData;
import dalelane.currentcost.calendar.YearData;

/*
 * A CurrentCost update (as described in CurrentCostUpdate) is a relative
 *  description of your electricity usage.
 *
 * E.g. you used this much electricity 2 hours ago
 *
 * This class converts this into an absolute description of your electricity
 *   usage.
 *
 * E.g. you used this much electricity at 1pm
 *
 *
 *  Dale Lane (http://dalelane.co.uk/blog)
 */

public class CurrentCostHistory {
	
	public CurrentCostUpdate update;
	
	public Hashtable<YearData,  Integer>  yearDataCollection  = new Hashtable<YearData, Integer>();
	public Hashtable<MonthData, Integer>  monthDataCollection = new Hashtable<MonthData, Integer>();
	public Hashtable<DayData,   Integer>  dayDataCollection   = new Hashtable<DayData, Integer>();
	public Hashtable<HourData,  Float>    hourDataCollection  = new Hashtable<HourData, Float>();
	
	
    public void UpdateData(CurrentCostUpdate datasource)
    {
        // --- YEARS ----------------------------------
        YearData y1 = YearData.GetOldDate(datasource.TimeStamp, 1);
        yearDataCollection.put(y1, datasource.WattsYear1);

        YearData y2 = YearData.GetOldDate(datasource.TimeStamp, 2);
        yearDataCollection.put(y2, datasource.WattsYear2);

        YearData y3 = YearData.GetOldDate(datasource.TimeStamp, 3);
        yearDataCollection.put(y3, datasource.WattsYear3);

        YearData y4 = YearData.GetOldDate(datasource.TimeStamp, 4);
        yearDataCollection.put(y4, datasource.WattsYear4);

        // --- MONTHS ---------------------------------
        MonthData m1 = MonthData.GetOldDate(datasource.TimeStamp, 1);
        monthDataCollection.put(m1, datasource.WattsMonth01);

        MonthData m2 = MonthData.GetOldDate(datasource.TimeStamp, 2);
        monthDataCollection.put(m2, datasource.WattsMonth02);

        MonthData m3 = MonthData.GetOldDate(datasource.TimeStamp, 3);
        monthDataCollection.put(m3, datasource.WattsMonth03);

        MonthData m4 = MonthData.GetOldDate(datasource.TimeStamp, 4);
        monthDataCollection.put(m4, datasource.WattsMonth04);

        MonthData m5 = MonthData.GetOldDate(datasource.TimeStamp, 5);
        monthDataCollection.put(m5, datasource.WattsMonth05);

        MonthData m6 = MonthData.GetOldDate(datasource.TimeStamp, 6);
        monthDataCollection.put(m6, datasource.WattsMonth06);

        MonthData m7 = MonthData.GetOldDate(datasource.TimeStamp, 7);
        monthDataCollection.put(m7, datasource.WattsMonth07);

        MonthData m8 = MonthData.GetOldDate(datasource.TimeStamp, 8);
        monthDataCollection.put(m8, datasource.WattsMonth08);

        MonthData m9 = MonthData.GetOldDate(datasource.TimeStamp, 9);
        monthDataCollection.put(m9, datasource.WattsMonth09);

        MonthData m10 = MonthData.GetOldDate(datasource.TimeStamp, 10);
        monthDataCollection.put(m10, datasource.WattsMonth10);

        MonthData m11 = MonthData.GetOldDate(datasource.TimeStamp, 11);
        monthDataCollection.put(m11, datasource.WattsMonth11);

        MonthData m12 = MonthData.GetOldDate(datasource.TimeStamp, 12);
        monthDataCollection.put(m12, datasource.WattsMonth12);

        // --- DAYS ------------------------------------
        DayData d1 = DayData.GetOldDate(datasource.TimeStamp, 1);
        dayDataCollection.put(d1, datasource.WattsDay01);

        DayData d2 = DayData.GetOldDate(datasource.TimeStamp, 2);
        dayDataCollection.put(d2, datasource.WattsDay02);

        DayData d3 = DayData.GetOldDate(datasource.TimeStamp, 3);
        dayDataCollection.put(d3, datasource.WattsDay03);

        DayData d4 = DayData.GetOldDate(datasource.TimeStamp, 4);
        dayDataCollection.put(d4, datasource.WattsDay04);

        DayData d5 = DayData.GetOldDate(datasource.TimeStamp, 5);
        dayDataCollection.put(d5, datasource.WattsDay05);

        DayData d6 = DayData.GetOldDate(datasource.TimeStamp, 6);
        dayDataCollection.put(d6, datasource.WattsDay06);

        DayData d7 = DayData.GetOldDate(datasource.TimeStamp, 7);
        dayDataCollection.put(d7, datasource.WattsDay07);

        DayData d8 = DayData.GetOldDate(datasource.TimeStamp, 8);
        dayDataCollection.put(d8, datasource.WattsDay08);

        DayData d9 = DayData.GetOldDate(datasource.TimeStamp, 9);
        dayDataCollection.put(d9, datasource.WattsDay09);

        DayData d10 = DayData.GetOldDate(datasource.TimeStamp, 10);
        dayDataCollection.put(d10, datasource.WattsDay10);

        DayData d11 = DayData.GetOldDate(datasource.TimeStamp, 11);
        dayDataCollection.put(d11, datasource.WattsDay11);

        DayData d12 = DayData.GetOldDate(datasource.TimeStamp, 12);
        dayDataCollection.put(d12, datasource.WattsDay12);

        DayData d13 = DayData.GetOldDate(datasource.TimeStamp, 13);
        dayDataCollection.put(d13, datasource.WattsDay13);

        DayData d14 = DayData.GetOldDate(datasource.TimeStamp, 14);
        dayDataCollection.put(d14, datasource.WattsDay14);

        DayData d15 = DayData.GetOldDate(datasource.TimeStamp, 15);
        dayDataCollection.put(d15, datasource.WattsDay15);

        DayData d16 = DayData.GetOldDate(datasource.TimeStamp, 16);
        dayDataCollection.put(d16, datasource.WattsDay16);

        DayData d17 = DayData.GetOldDate(datasource.TimeStamp, 17);
        dayDataCollection.put(d17, datasource.WattsDay17);

        DayData d18 = DayData.GetOldDate(datasource.TimeStamp, 18);
        dayDataCollection.put(d18, datasource.WattsDay18);

        DayData d19 = DayData.GetOldDate(datasource.TimeStamp, 19);
        dayDataCollection.put(d19, datasource.WattsDay19);

        DayData d20 = DayData.GetOldDate(datasource.TimeStamp, 20);
        dayDataCollection.put(d20, datasource.WattsDay20);

        DayData d21 = DayData.GetOldDate(datasource.TimeStamp, 21);
        dayDataCollection.put(d21, datasource.WattsDay21);

        DayData d22 = DayData.GetOldDate(datasource.TimeStamp, 22);
        dayDataCollection.put(d22, datasource.WattsDay22);

        DayData d23 = DayData.GetOldDate(datasource.TimeStamp, 23);
        dayDataCollection.put(d23, datasource.WattsDay23);

        DayData d24 = DayData.GetOldDate(datasource.TimeStamp, 24);
        dayDataCollection.put(d24, datasource.WattsDay24);

        DayData d25 = DayData.GetOldDate(datasource.TimeStamp, 25);
        dayDataCollection.put(d25, datasource.WattsDay25);

        DayData d26 = DayData.GetOldDate(datasource.TimeStamp, 26);
        dayDataCollection.put(d26, datasource.WattsDay26);

        DayData d27 = DayData.GetOldDate(datasource.TimeStamp, 27);
        dayDataCollection.put(d27, datasource.WattsDay27);

        DayData d28 = DayData.GetOldDate(datasource.TimeStamp, 28);
        dayDataCollection.put(d28, datasource.WattsDay28);

        DayData d29 = DayData.GetOldDate(datasource.TimeStamp, 29);
        dayDataCollection.put(d29, datasource.WattsDay29);

        DayData d30 = DayData.GetOldDate(datasource.TimeStamp, 30);
        dayDataCollection.put(d30, datasource.WattsDay30);

        DayData d31 = DayData.GetOldDate(datasource.TimeStamp, 31);
        dayDataCollection.put(d31, datasource.WattsDay31);

        // --- HOURS ----------------------------------
        HourData h0 = HourData.GetOldDate(datasource.TimeStamp, 0);
        hourDataCollection.put(h0, datasource.kWattsHour02);

        HourData h2 = HourData.GetOldDate(datasource.TimeStamp, 2);
        hourDataCollection.put(h2, datasource.kWattsHour04);

        HourData h4 = HourData.GetOldDate(datasource.TimeStamp, 4);
        hourDataCollection.put(h4, datasource.kWattsHour06);

        HourData h6 = HourData.GetOldDate(datasource.TimeStamp, 6);
        hourDataCollection.put(h6, datasource.kWattsHour08);

        HourData h8 = HourData.GetOldDate(datasource.TimeStamp, 8);
        hourDataCollection.put(h8, datasource.kWattsHour10);

        HourData h10 = HourData.GetOldDate(datasource.TimeStamp, 10);
        hourDataCollection.put(h10, datasource.kWattsHour12);

        HourData h12 = HourData.GetOldDate(datasource.TimeStamp, 12);
        hourDataCollection.put(h12, datasource.kWattsHour14);

        HourData h14 = HourData.GetOldDate(datasource.TimeStamp, 14);
        hourDataCollection.put(h14, datasource.kWattsHour16);

        HourData h16 = HourData.GetOldDate(datasource.TimeStamp, 16);
        hourDataCollection.put(h16, datasource.kWattsHour18);

        HourData h18 = HourData.GetOldDate(datasource.TimeStamp, 18);
        hourDataCollection.put(h18, datasource.kWattsHour20);

        HourData h20 = HourData.GetOldDate(datasource.TimeStamp, 20);
        hourDataCollection.put(h20, datasource.kWattsHour22);

        HourData h22 = HourData.GetOldDate(datasource.TimeStamp, 22);
        hourDataCollection.put(h22, datasource.kWattsHour24);

        HourData h24 = HourData.GetOldDate(datasource.TimeStamp, 24);
        hourDataCollection.put(h24, datasource.kWattsHour26);
    }
    
    
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();

		Enumeration<HourData> enHr = hourDataCollection.keys();		 
	    while(enHr.hasMoreElements())
	    {
	    	HourData tm = enHr.nextElement();	    	
	    	sb.append(tm.toString() + " = " + hourDataCollection.get(tm) + System.getProperty("line.separator"));
	    }

		Enumeration<DayData> enDay = dayDataCollection.keys();		 
	    while(enDay.hasMoreElements())
	    {
	    	DayData tm = enDay.nextElement();	    	
	    	sb.append(tm.toString() + " = " + dayDataCollection.get(tm) + System.getProperty("line.separator"));
	    }

		Enumeration<MonthData> enMth = monthDataCollection.keys();		 
	    while(enMth.hasMoreElements())
	    {
	    	MonthData tm = enMth.nextElement();	    	
	    	sb.append(tm.toString() + " = " + monthDataCollection.get(tm) + System.getProperty("line.separator"));
	    }
	    
		Enumeration<YearData> enYr = yearDataCollection.keys();		 
	    while(enYr.hasMoreElements())
	    {
	    	YearData tm = enYr.nextElement();	    	
	    	sb.append(tm.toString() + " = " + yearDataCollection.get(tm) + System.getProperty("line.separator"));
	    }
	    
		return sb.toString();
	}
}