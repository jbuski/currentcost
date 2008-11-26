# read the currentcost meter and publish the power in KW, to the nearest
# 100 watts, to an MQTT broker, along with temperature and history data.

# Andy S-C 16-Sep-07

########################################################################

$your_name = "yourname";

#$serial_port = "/dev/ttyUSB0";

$broker = "127.0.0.1";
#$broker = "realtime.ngi.ibm.com";

########################################################################

use CurrentCost;

while (1)
{
  #open (SERIAL,"+<$serial_port") || die "can't open $serial_port";
	$cc = new CurrentCost(broker=>$broker,name=>$your_name,debug=>1);

	while (<>)
	{
		$xml = $_;
		$cc->publish_all($xml);
	}
}
                                

                                
