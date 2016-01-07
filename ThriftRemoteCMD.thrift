/***ThriftRemoteCMD.thrift***/

namespace java com.thrift.ThriftRemoteCMD

service ThriftRemoteCMD_service{
	string call_ifconfig();
	string call_netstat();
}