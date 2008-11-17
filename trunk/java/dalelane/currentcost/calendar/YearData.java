package dalelane.currentcost.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;


/* 
 * Internal calendar class for CurrentCost yearly totals.
 * 
 *  Dale Lane (http://dalelane.co.uk/blog)
 */

public class YearData {
		
	public int Year;
	
	public String toString() 
	{
		return Integer.toString(Year);
	}
	
	public boolean equals(Object obj) 
	{
        if (obj instanceof YearData)
        {
            if (Year == ((YearData)obj).Year)
            {
                return true;
            }
        }
        return false;		
	}
	
	/* returns a YearData object that is a specified number of years ago 
	 * from the provided reference date                                   */
	public static YearData GetOldDate(GregorianCalendar referenceDate, int yearsago)
	{
		YearData oldYear = new YearData();
        oldYear.Year = referenceDate.get(Calendar.YEAR) - yearsago;
        return oldYear;		
	}	
}