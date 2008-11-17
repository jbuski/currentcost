package dalelane.currentcost.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
 * Internal calendar class for CurrentCost monthly totals.
 * 
 *  Dale Lane (http://dalelane.co.uk/blog)
 */

public class MonthData {

    public int Month;
    public int Year;

	public String toString() 
	{
		return Month + "/" + Year;
	}
    
	public boolean equals(Object obj) {
    	
        if (obj instanceof MonthData)
        {
            if ((Year == ((MonthData)obj).Year) &&
                (Month == ((MonthData)obj).Month))
            {
                return true;
            }
        }
        return false;
	}

    
	/* returns a MonthData object that is a specified number of months ago 
	 * from the provided reference date                                   */
    public static MonthData GetOldDate(GregorianCalendar referenceDate, int monthsago)
    {
        MonthData oldMonth = new MonthData();
        int newmonth = (referenceDate.get(Calendar.MONTH) + 1) - monthsago;
        int newyear = referenceDate.get(Calendar.YEAR);

        if (newmonth <= 0)
        {
            newmonth += 12;
            newyear -= 1;
        }

        oldMonth.Year = newyear;
        oldMonth.Month = newmonth;

        return oldMonth;
    }	
}