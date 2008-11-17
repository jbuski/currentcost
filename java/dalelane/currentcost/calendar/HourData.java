package dalelane.currentcost.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;


/* 
 * Internal calendar class for CurrentCost two-hourly totals.
 * 
 *  Dale Lane (http://dalelane.co.uk/blog)
 */

public class HourData {

    public int TwoHourBlock;
    public int Date;
    public int Month;
    public int Year;

	public String toString() 
	{
		return Date + "/" + Month + "/" + Year + "  " + TwoHourBlock + ":00";
	}

	public boolean equals(Object compare) 
	{
        if (compare instanceof HourData)
        {
            if ((TwoHourBlock == ((HourData)compare).TwoHourBlock) &&
                (Year == ((HourData)compare).Year) &&
                (Month == ((HourData)compare).Month) &&
                (Date == ((HourData)compare).Date))
            {
                return true;
            }
        }
        return false;
	}
	
	
	/* returns a HourData object that is a specified number of hours ago 
	 * from the provided reference date                                   */	
    public static HourData GetOldDate(GregorianCalendar refDate, int hoursago)
    {
    	GregorianCalendar referenceDate = (GregorianCalendar) refDate.clone();
    	
        int start = referenceDate.get(Calendar.HOUR_OF_DAY);
        
        if ((start % 2) == 0)
        {
        	hoursago += 1;
        }
        
        int newhour = start - hoursago;
        int newday = referenceDate.get(Calendar.DAY_OF_MONTH);
        int newmonth = referenceDate.get(Calendar.MONTH) + 1;
        int newyear = referenceDate.get(Calendar.YEAR);
        
        if (newhour < -24)
        {
            newhour += 48;
            
            referenceDate.add(Calendar.HOUR_OF_DAY, -(hoursago));
            
            newday = referenceDate.get(Calendar.DAY_OF_MONTH);
            newmonth = referenceDate.get(Calendar.MONTH) + 1;
            newyear = referenceDate.get(Calendar.YEAR);
        }
        else if (newhour < 0)
        {
            newhour += 24;
            
            referenceDate.add(Calendar.HOUR_OF_DAY, -(hoursago));
            
            newday = referenceDate.get(Calendar.DAY_OF_MONTH);
            newmonth = referenceDate.get(Calendar.MONTH) + 1;
            newyear = referenceDate.get(Calendar.YEAR);
        }
        

        HourData oldHour = new HourData();
        oldHour.TwoHourBlock = newhour;
        oldHour.Date = newday;
        oldHour.Month = newmonth;
        oldHour.Year = newyear;

        return oldHour;
    }
}