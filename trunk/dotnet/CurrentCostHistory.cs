using System;
using System.Collections.Generic;
using System.Text;

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

namespace CurrentCost
{
    public class CurrentCostHistory
    {
        public Dictionary<YearData, int>   yearDataCollection  = new Dictionary<YearData, int>();
        public Dictionary<MonthData, int>  monthDataCollection = new Dictionary<MonthData, int>();
        public Dictionary<DayData, int>    dayDataCollection   = new Dictionary<DayData, int>();
        public Dictionary<HourData, float> hourDataCollection  = new Dictionary<HourData, float>();


        public void UpdateData(CurrentCostUpdate datasource)
        {
            // --- YEARS ----------------------------------
            YearData y1 = YearData.GetOldDate(datasource.TimeStamp, 1);
            yearDataCollection[y1] = datasource.WattsYear1;

            YearData y2 = YearData.GetOldDate(datasource.TimeStamp, 2);
            yearDataCollection[y2] = datasource.WattsYear2;

            YearData y3 = YearData.GetOldDate(datasource.TimeStamp, 3);
            yearDataCollection[y3] = datasource.WattsYear3;

            YearData y4 = YearData.GetOldDate(datasource.TimeStamp, 4);
            yearDataCollection[y4] = datasource.WattsYear4;

            // --- MONTHS ---------------------------------
            MonthData m1 = MonthData.GetOldDate(datasource.TimeStamp, 1);
            monthDataCollection[m1] = datasource.WattsMonth01;

            MonthData m2 = MonthData.GetOldDate(datasource.TimeStamp, 2);
            monthDataCollection[m2] = datasource.WattsMonth02;

            MonthData m3 = MonthData.GetOldDate(datasource.TimeStamp, 3);
            monthDataCollection[m3] = datasource.WattsMonth03;

            MonthData m4 = MonthData.GetOldDate(datasource.TimeStamp, 4);
            monthDataCollection[m4] = datasource.WattsMonth04;

            MonthData m5 = MonthData.GetOldDate(datasource.TimeStamp, 5);
            monthDataCollection[m5] = datasource.WattsMonth05;

            MonthData m6 = MonthData.GetOldDate(datasource.TimeStamp, 6);
            monthDataCollection[m6] = datasource.WattsMonth06;

            MonthData m7 = MonthData.GetOldDate(datasource.TimeStamp, 7);
            monthDataCollection[m7] = datasource.WattsMonth07;

            MonthData m8 = MonthData.GetOldDate(datasource.TimeStamp, 8);
            monthDataCollection[m8] = datasource.WattsMonth08;

            MonthData m9 = MonthData.GetOldDate(datasource.TimeStamp, 9);
            monthDataCollection[m9] = datasource.WattsMonth09;

            MonthData m10 = MonthData.GetOldDate(datasource.TimeStamp, 10);
            monthDataCollection[m10] = datasource.WattsMonth10;

            MonthData m11 = MonthData.GetOldDate(datasource.TimeStamp, 11);
            monthDataCollection[m11] = datasource.WattsMonth11;

            MonthData m12 = MonthData.GetOldDate(datasource.TimeStamp, 12);
            monthDataCollection[m12] = datasource.WattsMonth12;

            // --- DAYS ------------------------------------
            DayData d1 = DayData.GetOldDate(datasource.TimeStamp, 1);
            dayDataCollection[d1] = datasource.WattsDay01;

            DayData d2 = DayData.GetOldDate(datasource.TimeStamp, 2);
            dayDataCollection[d2] = datasource.WattsDay02;

            DayData d3 = DayData.GetOldDate(datasource.TimeStamp, 3);
            dayDataCollection[d3] = datasource.WattsDay03;

            DayData d4 = DayData.GetOldDate(datasource.TimeStamp, 4);
            dayDataCollection[d4] = datasource.WattsDay04;

            DayData d5 = DayData.GetOldDate(datasource.TimeStamp, 5);
            dayDataCollection[d5] = datasource.WattsDay05;

            DayData d6 = DayData.GetOldDate(datasource.TimeStamp, 6);
            dayDataCollection[d6] = datasource.WattsDay06;

            DayData d7 = DayData.GetOldDate(datasource.TimeStamp, 7);
            dayDataCollection[d7] = datasource.WattsDay07;

            DayData d8 = DayData.GetOldDate(datasource.TimeStamp, 8);
            dayDataCollection[d8] = datasource.WattsDay08;

            DayData d9 = DayData.GetOldDate(datasource.TimeStamp, 9);
            dayDataCollection[d9] = datasource.WattsDay09;

            DayData d10 = DayData.GetOldDate(datasource.TimeStamp, 10);
            dayDataCollection[d10] = datasource.WattsDay10;

            DayData d11 = DayData.GetOldDate(datasource.TimeStamp, 11);
            dayDataCollection[d11] = datasource.WattsDay11;

            DayData d12 = DayData.GetOldDate(datasource.TimeStamp, 12);
            dayDataCollection[d12] = datasource.WattsDay12;

            DayData d13 = DayData.GetOldDate(datasource.TimeStamp, 13);
            dayDataCollection[d13] = datasource.WattsDay13;

            DayData d14 = DayData.GetOldDate(datasource.TimeStamp, 14);
            dayDataCollection[d14] = datasource.WattsDay14;

            DayData d15 = DayData.GetOldDate(datasource.TimeStamp, 15);
            dayDataCollection[d15] = datasource.WattsDay15;

            DayData d16 = DayData.GetOldDate(datasource.TimeStamp, 16);
            dayDataCollection[d16] = datasource.WattsDay16;

            DayData d17 = DayData.GetOldDate(datasource.TimeStamp, 17);
            dayDataCollection[d17] = datasource.WattsDay17;

            DayData d18 = DayData.GetOldDate(datasource.TimeStamp, 18);
            dayDataCollection[d18] = datasource.WattsDay18;

            DayData d19 = DayData.GetOldDate(datasource.TimeStamp, 19);
            dayDataCollection[d19] = datasource.WattsDay19;

            DayData d20 = DayData.GetOldDate(datasource.TimeStamp, 20);
            dayDataCollection[d20] = datasource.WattsDay20;

            DayData d21 = DayData.GetOldDate(datasource.TimeStamp, 21);
            dayDataCollection[d21] = datasource.WattsDay21;

            DayData d22 = DayData.GetOldDate(datasource.TimeStamp, 22);
            dayDataCollection[d22] = datasource.WattsDay22;

            DayData d23 = DayData.GetOldDate(datasource.TimeStamp, 23);
            dayDataCollection[d23] = datasource.WattsDay23;

            DayData d24 = DayData.GetOldDate(datasource.TimeStamp, 24);
            dayDataCollection[d24] = datasource.WattsDay24;

            DayData d25 = DayData.GetOldDate(datasource.TimeStamp, 25);
            dayDataCollection[d25] = datasource.WattsDay25;

            DayData d26 = DayData.GetOldDate(datasource.TimeStamp, 26);
            dayDataCollection[d26] = datasource.WattsDay26;

            DayData d27 = DayData.GetOldDate(datasource.TimeStamp, 27);
            dayDataCollection[d27] = datasource.WattsDay27;

            DayData d28 = DayData.GetOldDate(datasource.TimeStamp, 28);
            dayDataCollection[d28] = datasource.WattsDay28;

            DayData d29 = DayData.GetOldDate(datasource.TimeStamp, 29);
            dayDataCollection[d29] = datasource.WattsDay29;

            DayData d30 = DayData.GetOldDate(datasource.TimeStamp, 30);
            dayDataCollection[d30] = datasource.WattsDay30;

            DayData d31 = DayData.GetOldDate(datasource.TimeStamp, 31);
            dayDataCollection[d31] = datasource.WattsDay31;

            // --- HOURS ----------------------------------
            HourData h0 = HourData.GetOldDate(datasource.TimeStamp, 0);
            hourDataCollection[h0] = datasource.kWattsHour02;

            HourData h2 = HourData.GetOldDate(datasource.TimeStamp, 2);
            hourDataCollection[h2] = datasource.kWattsHour04;

            HourData h4 = HourData.GetOldDate(datasource.TimeStamp, 4);
            hourDataCollection[h4] = datasource.kWattsHour06;

            HourData h6 = HourData.GetOldDate(datasource.TimeStamp, 6);
            hourDataCollection[h6] = datasource.kWattsHour08;

            HourData h8 = HourData.GetOldDate(datasource.TimeStamp, 8);
            hourDataCollection[h8] = datasource.kWattsHour10;

            HourData h10 = HourData.GetOldDate(datasource.TimeStamp, 10);
            hourDataCollection[h10] = datasource.kWattsHour12;

            HourData h12 = HourData.GetOldDate(datasource.TimeStamp, 12);
            hourDataCollection[h12] = datasource.kWattsHour14;

            HourData h14 = HourData.GetOldDate(datasource.TimeStamp, 14);
            hourDataCollection[h14] = datasource.kWattsHour16;

            HourData h16 = HourData.GetOldDate(datasource.TimeStamp, 16);
            hourDataCollection[h16] = datasource.kWattsHour18;

            HourData h18 = HourData.GetOldDate(datasource.TimeStamp, 18);
            hourDataCollection[h18] = datasource.kWattsHour20;

            HourData h20 = HourData.GetOldDate(datasource.TimeStamp, 20);
            hourDataCollection[h20] = datasource.kWattsHour22;

            HourData h22 = HourData.GetOldDate(datasource.TimeStamp, 22);
            hourDataCollection[h22] = datasource.kWattsHour24;

            HourData h24 = HourData.GetOldDate(datasource.TimeStamp, 24);
            hourDataCollection[h24] = datasource.kWattsHour26;
        }


        /***************************************************/
        /*  debug                                          */
        /***************************************************/

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();

            foreach (KeyValuePair<CurrentCostHistory.HourData, float> kvp in hourDataCollection)
            {
                sb.AppendLine(kvp.Key + "  =  " + kvp.Value);
            }
            foreach (KeyValuePair<CurrentCostHistory.DayData, int> kvp in dayDataCollection)
            {
                sb.AppendLine(kvp.Key + "  =  " + kvp.Value);
            }
            foreach (KeyValuePair<CurrentCostHistory.MonthData, int> kvp in monthDataCollection)
            {
                sb.AppendLine(kvp.Key + "  =  " + kvp.Value);
            }
            foreach (KeyValuePair<CurrentCostHistory.YearData, int> kvp in yearDataCollection)
            {
                sb.AppendLine(kvp.Key + "  =  " + kvp.Value);
            }

            return sb.ToString();
        }




        /***********************************************************/
        /*   inner classes used to define custom calendar types    */
        /***********************************************************/


        public abstract class CurrentCostTime
        {            
        }


        /*****************************************************/
        /* Represents the date for a CurrentCost record of a */
        /*   year's electricity usage.                       */
        /*****************************************************/
        public class YearData : CurrentCostTime, IComparable
        {
            public int Year;

            public static YearData GetOldDate(DateTime referenceDate, int yearsago)
            {
                YearData oldYear = new YearData();
                oldYear.Year = referenceDate.Year - yearsago;

                return oldYear;
            }

            /**************************************************/
            /*  we add the following methods so that we can   */
            /*   store YearData in Dictionary objects         */
            /**************************************************/

            public int CompareTo(object obj)
            {
                if (obj is YearData)
                {
                    YearData comp = (YearData)obj;

                    return Year.CompareTo(comp.Year);
                }

                throw new ArgumentException();
            }

            public override bool Equals(object compare)
            {
                if (compare is YearData)
                {
                    if (Year == ((YearData)compare).Year)
                    {
                        return true;
                    }
                }
                return false;
            }

            public override int GetHashCode()
            {
                return Year.GetHashCode();
            }

            /***************************************************/
            /*  debug                                          */
            /***************************************************/
            public override string ToString()
            {
                return Year.ToString();
            }
        }


        /*****************************************************/
        /* Represents the date for a CurrentCost record of a */
        /*   month's electricity usage.                      */
        /*****************************************************/
        public class MonthData : CurrentCostTime, IComparable
        {
            public int Month;
            public int Year;


            public static MonthData GetOldDate(DateTime referenceDate, int monthsago)
            {
                MonthData oldMonth = new MonthData();
                int newmonth = referenceDate.Month - monthsago;
                int newyear = referenceDate.Year;

                if (newmonth <= 0)
                {
                    newmonth += 12;
                    newyear -= 1;
                }

                oldMonth.Year = newyear;
                oldMonth.Month = newmonth;

                return oldMonth;
            }

            /**************************************************/
            /*  we add the following methods so that we can   */
            /*   store MonthData in Dictionary objects        */
            /**************************************************/

            public int CompareTo(object obj)
            {
                if (obj is MonthData)
                {
                    MonthData comp = (MonthData)obj;

                    switch (Year.CompareTo(comp.Year))
                    {
                        case -1:
                            return -1;
                        case 1:
                            return 1;
                        case 0:
                            return Month.CompareTo(comp.Month);
                    }
                }

                throw new ArgumentException();
            }

            public override bool Equals(object compare)
            {
                if (compare is MonthData)
                {
                    if ((Year == ((MonthData)compare).Year) &&
                        (Month == ((MonthData)compare).Month))
                    {
                        return true;
                    }
                }
                return false;
            }

            public override int GetHashCode()
            {
                return Month.GetHashCode() ^ Year.GetHashCode();
            }

            /***************************************************/
            /*  debug                                          */
            /***************************************************/

            public override string ToString()
            {
                switch (Month)
                {
                    case 1:
                        return "Jan " + Year;
                    case 2:
                        return "Feb " + Year;
                    case 3:
                        return "Mar " + Year;
                    case 4:
                        return "Apr " + Year;
                    case 5:
                        return "May " + Year;
                    case 6:
                        return "Jun " + Year;
                    case 7:
                        return "Jul " + Year;
                    case 8:
                        return "Aug " + Year;
                    case 9:
                        return "Sep " + Year;
                    case 10:
                        return "Oct " + Year;
                    case 11:
                        return "Nov " + Year;
                    case 12:
                        return "Dec " + Year;
                    default:
                        return Month + " / " + Year;
                }                
            }
        }



        /*****************************************************/
        /* Represents the date for a CurrentCost record of a */
        /*   days's electricity usage.                       */
        /*****************************************************/
        public class DayData : CurrentCostTime, IComparable
        {
            public int Date;
            public int Month;
            public int Year;


            public static DayData GetOldDate(DateTime referenceDate, int daysago)
            {
                DayData oldDay = new DayData();
                int newday = referenceDate.Day - daysago;
                int newmonth = referenceDate.Month;
                int newyear = referenceDate.Year;

                if (newday <= 0)
                {
                    DateTime sub = referenceDate.Subtract(new TimeSpan(daysago, 0, 0, 0));
                    newday = sub.Day;
                    newmonth = sub.Month;
                    newyear = sub.Year;
                }

                oldDay.Date = newday;
                oldDay.Month = newmonth;
                oldDay.Year = newyear;

                return oldDay;
            }

            /**************************************************/
            /*  we add the following methods so that we can   */
            /*   store DayData in Dictionary objects          */
            /**************************************************/

            public int CompareTo(object obj)
            {
                if (obj is DayData)
                {
                    DayData comp = (DayData)obj;

                    switch (Year.CompareTo(comp.Year))
                    {
                        case -1:
                            return -1;
                        case 1:
                            return 1;
                        case 0:
                            switch (Month.CompareTo(comp.Month))
                            {
                                case -1:
                                    return -1;
                                case 1:
                                    return 1;
                                case 0:
                                    return Date.CompareTo(comp.Date);
                            }
                            break;
                    }
                }

                throw new ArgumentException();
            }

            public override bool Equals(object compare)
            {
                if (compare is DayData)
                {
                    if ((Year == ((DayData)compare).Year) &&
                        (Month == ((DayData)compare).Month) &&
                        (Date == ((DayData)compare).Date))
                    {
                        return true;
                    }
                }
                return false;
            }

            public override int GetHashCode()
            {
                return Date.GetHashCode() ^ Month.GetHashCode() ^ Year.GetHashCode();
            }

            /***************************************************/
            /*  debug                                          */
            /***************************************************/

            public override string ToString()
            {
                return Date + "/" + Month + "/" + Year;
            }
        }


        /******************************************************/
        /* Represents the date for a CurrentCost record of an */
        /*   hour's electricity usage.                        */
        /******************************************************/

        public class HourData : CurrentCostTime, IComparable
        {
            public int TwoHourBlock;
            public int Date;
            public int Month;
            public int Year;


            public static HourData GetOldDate(DateTime referenceDate, int hoursago)
            {
                int start = referenceDate.Hour;
                if ((start % 2) == 0)
                {
                    hoursago += 1;
                }

                int newhour = start - hoursago;
                int newday = referenceDate.Day;
                int newmonth = referenceDate.Month;
                int newyear = referenceDate.Year;

                if (newhour < -24)
                {
                    newhour += 48;

                    DateTime sub = referenceDate.Subtract(new TimeSpan(1, 0, 0, 0));
                    newday = sub.Day;
                    newmonth = sub.Month;
                    newyear = sub.Year;
                }
                else if (newhour < 0)
                {
                    newhour += 24;

                    DateTime sub = referenceDate.Subtract(new TimeSpan(1, 0, 0, 0));
                    newday = sub.Day;
                    newmonth = sub.Month;
                    newyear = sub.Year;
                }

                HourData oldHour = new HourData();
                oldHour.TwoHourBlock = newhour;
                oldHour.Date = newday;
                oldHour.Month = newmonth;
                oldHour.Year = newyear;

                return oldHour;
            }


            /**************************************************/
            /*  we add the following methods so that we can   */
            /*   store DayData in Dictionary objects          */
            /**************************************************/

            public int CompareTo(object obj)
            {
                if (obj is HourData)
                {
                    HourData comp = (HourData)obj;

                    switch (Year.CompareTo(comp.Year))
                    {
                        case -1:
                            return -1;
                        case 1:
                            return 1;
                        case 0:
                            switch (Month.CompareTo(comp.Month))
                            {
                                case -1:
                                    return -1;
                                case 1:
                                    return 1;
                                case 0:
                                    switch (Date.CompareTo(comp.Date))
                                    {
                                        case -1:
                                            return -1;
                                        case 1:
                                            return 1;
                                        case 0:
                                            return TwoHourBlock.CompareTo(comp.TwoHourBlock);
                                    }
                                    break;
                            }
                            break;
                    }
                }

                throw new ArgumentException();
            }

            public override bool Equals(object compare)
            {
                if (compare is HourData)
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

            public override int GetHashCode()
            {
                return TwoHourBlock.GetHashCode() ^ Date.GetHashCode() ^ Month.GetHashCode() ^ Year.GetHashCode();
            }

            /***************************************************/
            /*  debug                                          */
            /***************************************************/

            public override string ToString()
            {
                return TwoHourBlock + ":00  " + Date + "/" + Month + "/" + Year;
            }
        }
    }
}
