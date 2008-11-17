# Stores your CurrentCost data
# 
# Okay, so this doesn't really store data. 
#
# These are really just stubs, replace them functions which store the data 
#  the way you like
# I'm a big fan of pysqlite, but you can use anything you like.
# 
#  Dale Lane (http://dalelane.co.uk/blog)
# 

class CurrentCostDataStore():

    def StoreHourData (self, updatetimestamp, ccvalue):
        print "2-HOUR :: " + str(updatetimestamp) + " = " + str(ccvalue) + "kWh"

    def StoreDayData (self, updatetimestamp, ccvalue):
        print "DAY :: " + str(updatetimestamp) + " = " + str(ccvalue) + "kWh"

    def StoreMonthData (self, updatetimestamp, ccvalue):
        print "MONTH :: " + str(updatetimestamp) + " = " + str(ccvalue) + "kWh"
