package dalelane.currentcost.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
 * Internal calendar class for CurrentCost daily totals.
 * 
 *  Dale Lane (http://dalelane.co.uk/blog)
 */

public class DayData {

    public int Date;
    public int Month;
    public int Year;
    
	public String toString() 
	{
		return Date + "/" + Month + "/" + Year;
	}
    
    public boolean equals(Object obj) 
    {
        if (obj instanceof DayData)
        {
            if ((Year == ((DayData)obj).Year) &&
                (Month == ((DayData)obj).Month) &&
                (Date == ((DayData)obj).Date))
            {
                return true;
            }
        }
        return false;
	}

    
	/* returns a DayData object that is a specified number of days ago 
	 * from the provided reference date                                   */
    public static DayData GetOldDate(GregorianCalendar refDate, int daysago)
    {
    	GregorianCalendar referenceDate = (GregorianCalendar) refDate.clone();
    	
        DayData oldDay = new DayData();
        int newday = referenceDate.get(Calendar.DAY_OF_MONTH) - daysago;
        int newmonth = referenceDate.get(Calendar.MONTH) + 1;
        int newyear = referenceDate.get(Calendar.YEAR);

        if (newday <= 0)
        {
        	referenceDate.add(Calendar.DAY_OF_MONTH, -daysago);
            newday = referenceDate.get(Calendar.DAY_OF_MONTH);
            newmonth = referenceDate.get(Calendar.MONTH) + 1;
            newyear = referenceDate.get(Calendar.YEAR);
        }

        oldDay.Date = newday;
        oldDay.Month = newmonth;
        oldDay.Year = newyear;

        return oldDay;
    }   
}