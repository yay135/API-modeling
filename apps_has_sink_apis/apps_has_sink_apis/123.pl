#!usr/bin/perl -w
@sinks=("httpDelete","httpGet","httpHead","httpPost","httpPostJson","httpPut","httpPutJson","GET","PUT","POST","DELETE","sendSms","sendSmsMessage","sendNotificationEvent","sendNotification","sendNotificationToContacts","sendPush","sendPushMessage");
foreach $api (@sinks)
{
	print $api."\n";
	`grep --exclude=apps_has_sink_apis -r $api >>../smartThings-SainT/apps_has_sink_apis`;
}

$targetDir="/home/zhexin/Desktop/SE4SmartApps/apps_has_sink_apis";
my $filename = "apps_has_sink_apis";
open($fh, $filename) or die "Could not open file '$filename' $!";
 
while ($row = <$fh>) {
  chomp $row;
  @content=(split":",$row);
  print $content[0].'\n';
	`cp $content[0] $targetDir`;
}
close $fh;
