# Publish CurrentCost power information to a nano broker
# Round most values and only publish if data changes
#
# Anton Piatek 04/2008

package CurrentCost;

require "nupub.pl";



sub new
{
  my $class = shift || die;
  my %params = @_;
  die "broker not set" unless $params{broker};
  die "name not set" unless $params{name};
  my $port = $params{port} || 1883;
  my $keepalive = $params{keepalive} || 120;
  my $debug = $params{debug} || 0;

  my $self = {
      _broker => $params{broker},
      _name   => $params{name},
      _port   => $port,
      _keepalive => $keepalive,
      _debug  => $debug,
      _prev_watt_value => -1,
      _prev_temperature  => 0,
      _watt_skipped => 0,
      _prev_hours => 0,
      _prev_days => 0,
      _prev_months => 0,
      _prev_years => 0,
  };
  bless $self, $class;

  return $self;
}





sub connect
{
  my $self = shift || die;
  if (&upub_connect ("currentcost_$self->{_name}",$self->{_broker},$self->{_port}))
  {
    if($self->{_debug}){
      print "connected OK\n";
    }
    $self->{_connected}=1;
    return 1;
  }else{
    print "couldnt connect\n";
    $self->{_connected}=0;
    return 0;
  }
}




sub publish_power
{
  my $self = shift || die;
  my $value = shift || die "no value to publish";

  if(! $self->{_connected}){
    $connect = $self->connect();
    if(!$connect){
      print "Not connected, not publishing\n";
      return 0;
    }
  }
  # round to the nearest 50W and convert to KW
  $value = int($value/50 + 0.5)*50;
  $value /= 1000;


  if ($value != $self->{_prev_watt_value})
  {

    if ($self->{_watt_skipped} >= 10)
    {
      #If any were skipped, republish the prev_value just before
      #publishing the new value so a long flat-line is graphed
      $self->{_watt_skipped} = 0;

      if($self->{_debug}){
        print "pub: '$self->{_prev_watt_value}' KW\n";
      }
      &upub_publish ("PowerMeter/CC/$self->{_name}","n",$self->{_prev_watt_value});
    }

    &upub_publish ("PowerMeter/CC/$self->{_name}","n",$value);

    if($self->{_debug}){
      print "pub: '$value' KW\n";
    }

    $self->{_prev_watt_value} = $value;
  }
  else
  {
    $self->{_watt_skipped}++;

    if ($self->{_watt_skipped} == 10)
    {
      print "60 second flat-line marker\n";
    }
  }
}



sub publish_temp
{
  my $self = shift || die;
  my $value = shift || die "no value to publish";

  if(! $self->{_connected}){
    $connect = $self->connect();
    if(!$connect){
      print "Not connected, not publishing\n";
      return 0;
    }
  }

  # round to nearest degree
  $value = int($value + 0.5);

  if ($value != $self->{_prev_temperature})
  {
    if($self->{_debug}){
      print "pub temp: $value\n";
    }
    $self->{_prev_temperature} = $value;
    print "temperature: $value\n";
    &upub_publish ("PowerMeter/temp/$self->{_name}","y",$value);
  }
}




sub publish_history
{
  my $self = shift || die;
  local $_ = shift || die "no xml";

  if(! $self->{_connected}){
    $connect = $self->connect();
    if(!$connect){
      print "Not connected, not publishing\n";
      return 0;
    }
  }

  $hours = &process_history(/<hrs>(.*)<\/hrs>/);                             
  $days = &process_history(/<days>(.*)<\/days>/);                            
  $months = &process_history(/<mths>(.*)<\/mths>/);                          
  $years = &process_history(/<yrs>(.*)<\/yrs>/);                             
                                                                      
  if( $hours ne $self->{_prev_hours} )
  {                                                                  
    if($self->{_debug}){
      print "pub: hours:\t$hours\n";                                    
    }
    $self->{_prev_hours} = $hours;     
                                       
    &upub_publish ("PowerMeter/history/$self->{_name}/hours","y",$hours);
  }                                                                  
  if( $days ne $self->{_prev_days} )                            
  {                                                                  
    if($self->{_debug}){
      print "pub: days: $days\n";                                          
    }
    $self->{_prev_days} = $days;      
    &upub_publish ("PowerMeter/history/$self->{_name}/days","y",$days);    
  }                                                                    
  if($months ne $self->{_prev_months} )
  {                                                                    
    if($self->{_debug}){
      print "pub: months:\t$months\n";                                      
    }
    $self->{_prev_months} = $months;                                            
    &upub_publish ("PowerMeter/history/$self->{_name}/months","y",$months);
  }                                                                    
  if($years ne $self->{_prev_years} )
  {                                                                  
    if($self->{_debug}){
      print "pub: years: $years\n";                                         
    }
    $self->{_prev_years} = $years;                                            
    &upub_publish ("PowerMeter/history/$self->{_name}/years","y",$years);
  }                                                                  
}



sub publish_all
{
  my $self = shift || die;
  my $xml = shift || die "no xml";


  if ($xml =~ /<ch1><watts>(.*?)<\/watts>/){
    $self->publish_power($1);
  }

  if ($xml =~ /<tmpr>(.*)<\/tmpr>/){
    $self->publish_temp($1);
  }

  if ($xml =~ /<hist>(.*)<\/hist>/)                                    
  {                                                                    
    $self->publish_history($1);                                                     
  }

}







                                                                            
                                                                            
sub process_history
{                                                                           
  my ($data) = @_;
  my ($result);

  #print "data: '$data'\n";                                                 
  while ($data =~ /<(.)(.*?)>(.*?)<\/.*?>/g)
  {                                                                         
    ($type,$index,$value) = ($1,$2,$3);                                     
    #print "$type $index\t$value\n";                                        
    $result .= $value." ";                                                  
  }                                                                         
  #print $result,"\n";                                                      
  return $result;                                                           
}                                            





sub disconnect
{
  my $self = shift||die;
  if($self->{_debug}){
    print "disconnecting\n";
  }
  &upub_disconnect();
}




sub DESTROY
{
  my $self = shift||die;
  $self->disconnect();  
}


1;
