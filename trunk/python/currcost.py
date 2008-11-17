import xml.parsers.expat
import serial

# Parses data from a CurrentCost meter
# 
# Note that this is provided to help get you started, but it lacks careful 
#  error-handling or proper documentation.
# 
# If you have any questions about it, or even just find it useful, please do 
#  let me know - dale.lane@gmail.com
# 
# 
#  Dale Lane (http://dalelane.co.uk/blog)
# 

YOURCOMPORT = "COM21"


# this class lets you store the CurrentCost XML data as a Python object
from currentcostdata           import CurrentCostUpdate

# this class lets you translate the CurrentCost data into values and their timestamps
from currentcostdatafunctions  import CurrentCostDataFunctions

# this class lets you store your CurrentCost data
from currentcostdatastore      import CurrentCostDataStore


# XML parsing functions 
def start_element(name, attrs):
    global currentelement
    currentelement = name
def end_element(name):
    global currentelement
    currentelement = "none"
def char_data(data):
    global currentelement, newupd
    newupd.UpdateProperty(currentelement, data)

currentelement = "none"

# object to represent the CurrentCost data received
newupd = CurrentCostUpdate ()

# objects to parse and store the data
ccfuncs = CurrentCostDataFunctions()
ccdb = CurrentCostDataStore()

ser = None

try:
    # connect to the CurrentCost meter
    ser = serial.Serial(port=YOURCOMPORT, timeout=3)
except serial.SerialException, msg:
    print("Failed to connect to CurrentCost meter :: " + str(msg))
    exit(1)

# we keep trying to get an update from the CurrentCost meter 
#  until we successfully populate the CurrentCost data object

while newupd.WattsDay01 == -1:

    # read a line of XML from the CurrentCost meter
    line = ser.readline()

    print "> " + line

    try:
        # parse it
        p = xml.parsers.expat.ParserCreate()
        p.StartElementHandler = start_element
        p.EndElementHandler = end_element
        p.CharacterDataHandler = char_data
        p.Parse(line, 1)

    except xml.parsers.expat.ExpatError:
        print("Received incomplete data from CurrentCost meter. Will try and get a new reading")
    
    except serial.SerialException, err:
        print("Failed to receive data from CurrentCost meter :: " + str(err))
        ser.close()
        exit(1)

# finished with serial port - close it
ser.close()

# store it
ccfuncs.ParseCurrentCostXML(ccdb, newupd)


exit(0)
