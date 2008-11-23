using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;

/*
 * Represents the data contained in a single update from a CurrentCost meter
 *
 * It's a Java object representation of the XML - as described here:
 * http://cumbers.wordpress.com/2008/05/07/breakdown-of-currentcost-xml-output/
 *
 * Class includes a constructor to create an update object from a line of 
 * CurrentCost XML.
 * 
 *  Dale Lane (http://dalelane.co.uk/blog)
 */

namespace CurrentCost
{
    public class CurrentCostUpdate
    {
        public bool ValidUpdate = false;

        public int DaysSinceBirth;
        public DateTime TimeStamp;
        public string MeterName;
        public int MeterId;
        public int MeterType;
        public string MeterSoftwareVersion;
        public int Channel1Watts;
        public int Channel2Watts;
        public int Channel3Watts;
        public string Temperature;
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


        public CurrentCostUpdate()
        {
            // invalid by default
            ValidUpdate = false;
        }

        public CurrentCostUpdate(string xmloutput)
            : this(xmloutput, false)
        {

        }

        public CurrentCostUpdate(string xmloutput, bool UseLocalTime)
        {
            XmlReaderSettings settings = new XmlReaderSettings();
            settings.ConformanceLevel = ConformanceLevel.Fragment;
            settings.IgnoreComments = true;
            settings.IgnoreWhitespace = true;

            XmlReader reader = XmlReader.Create(new System.IO.StringReader(xmloutput));

            try
            {
                reader.Read();
                reader.ReadStartElement("msg");

                reader.ReadStartElement("date");

                reader.ReadStartElement("dsb");
                DaysSinceBirth = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadStartElement("hr");
                int hrs = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("min");
                int mins = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("sec");
                int secs = reader.ReadContentAsInt();
                reader.ReadEndElement();
                if (UseLocalTime)
                {
                    TimeStamp = DateTime.Now;
                }
                else
                {
                    TimeStamp = new DateTime(DateTime.Today.Year,
                                         DateTime.Today.Month,
                                         DateTime.Today.Day,
                                         hrs,
                                         mins,
                                         secs);
                }
                reader.ReadEndElement(); // end of date

                reader.ReadStartElement("src");

                reader.ReadStartElement("name");
                MeterName = reader.ReadString();
                reader.ReadEndElement();

                reader.ReadStartElement("id");
                MeterId = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadStartElement("type");
                MeterType = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadStartElement("sver");
                MeterSoftwareVersion = reader.ReadContentAsString();
                reader.ReadEndElement();

                reader.ReadEndElement(); // end of src

                reader.ReadStartElement("ch1");

                reader.ReadStartElement("watts");
                Channel1Watts = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadEndElement(); // end of ch1

                reader.ReadStartElement("ch2");

                reader.ReadStartElement("watts");
                Channel2Watts = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadEndElement(); // end of ch2

                reader.ReadStartElement("ch3");

                reader.ReadStartElement("watts");
                Channel3Watts = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadEndElement(); // end of ch3

                reader.ReadStartElement("tmpr");
                Temperature = reader.ReadContentAsString();
                reader.ReadEndElement();

                reader.ReadStartElement("hist");

                reader.ReadStartElement("hrs");

                reader.ReadStartElement("h02");
                kWattsHour02 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h04");
                kWattsHour04 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h06");
                kWattsHour06 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h08");
                kWattsHour08 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h10");
                kWattsHour10 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h12");
                kWattsHour12 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h14");
                kWattsHour14 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h16");
                kWattsHour16 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h18");
                kWattsHour18 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h20");
                kWattsHour20 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h22");
                kWattsHour22 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h24");
                kWattsHour24 = reader.ReadContentAsFloat();
                reader.ReadEndElement();
                reader.ReadStartElement("h26");
                kWattsHour26 = reader.ReadContentAsFloat();
                reader.ReadEndElement();

                reader.ReadEndElement(); // end of hrs

                reader.ReadStartElement("days");

                reader.ReadStartElement("d01");
                WattsDay01 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d02");
                WattsDay02 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d03");
                WattsDay03 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d04");
                WattsDay04 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d05");
                WattsDay05 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d06");
                WattsDay06 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d07");
                WattsDay07 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d08");
                WattsDay08 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d09");
                WattsDay09 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d10");
                WattsDay10 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d11");
                WattsDay11 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d12");
                WattsDay12 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d13");
                WattsDay13 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d14");
                WattsDay14 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d15");
                WattsDay15 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d16");
                WattsDay16 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d17");
                WattsDay17 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d18");
                WattsDay18 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d19");
                WattsDay19 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d20");
                WattsDay20 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d21");
                WattsDay21 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d22");
                WattsDay22 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d23");
                WattsDay23 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d24");
                WattsDay24 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d25");
                WattsDay25 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d26");
                WattsDay26 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d27");
                WattsDay27 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d28");
                WattsDay28 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d29");
                WattsDay29 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d30");
                WattsDay30 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("d31");
                WattsDay31 = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadEndElement(); // end of days

                reader.ReadStartElement("mths");

                reader.ReadStartElement("m01");
                WattsMonth01 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m02");
                WattsMonth02 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m03");
                WattsMonth03 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m04");
                WattsMonth04 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m05");
                WattsMonth05 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m06");
                WattsMonth06 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m07");
                WattsMonth07 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m08");
                WattsMonth08 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m09");
                WattsMonth09 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m10");
                WattsMonth10 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m11");
                WattsMonth11 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("m12");
                WattsMonth12 = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadEndElement(); // end of mths

                reader.ReadStartElement("yrs");

                reader.ReadStartElement("y1");
                WattsYear1 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("y2");
                WattsYear2 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("y3");
                WattsYear3 = reader.ReadContentAsInt();
                reader.ReadEndElement();
                reader.ReadStartElement("y4");
                WattsYear4 = reader.ReadContentAsInt();
                reader.ReadEndElement();

                reader.ReadEndElement(); // end of yrs


                reader.ReadEndElement(); // end of hist

                ValidUpdate = true;
            }
            catch (XmlException exc)
            {
                ValidUpdate = false;

                /* partial updates from CurrentCost meters are not uncommon */
                /*  so this is unlikely to be a severe error                */
                /* the normal solution is just to try again with another    */
                /*  line of data from the CurrentCost meter                 */
                /* however, it might be good to count how many times we end */
                /*  up in here, and put a limit on how many times we try?   */
            }
            finally
            {
                reader.Close();
            }
        }
    }
}
