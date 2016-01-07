package com.thriftDev;

import org.apache.log4j.net.SyslogAppender;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.TException;


public class ThriftRemoteCMD_client {

    public static void main(String[] args) {
	// write your code here

        try{

            TTransport transport;

            transport = new TSocket("127.0.0.1", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            ThriftRemoteCMD_service.Client client = new ThriftRemoteCMD_service.Client(protocol);

            System.out.println("Client.....Get Message.....");
            System.out.println(client.call_ifconfig());
            System.out.println(client.call_netstat());

            transport.close();

        }catch (TTransportException e){
            e.printStackTrace();
        }
        catch (TException e){
            e.printStackTrace();
        }


    }
}
