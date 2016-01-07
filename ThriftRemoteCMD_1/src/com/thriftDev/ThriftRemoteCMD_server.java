package com.thriftDev;

/**
 * Created by foxhound7812 on 2016/1/6.
 */

import org.apache.log4j.net.SyslogAppender;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;


public class ThriftRemoteCMD_server {


    public static void startup_exampleService( ThriftRemoteCMD_service.Processor process){

        try{

            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(process));

            System.out.println("Start Up Server..............");

            server.serve();

        }catch (Exception e){

            System.out.println("Error!!!");
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        startup_exampleService(new ThriftRemoteCMD_service.Processor<ThriftRemoteCMD_Handler>( new ThriftRemoteCMD_Handler()));
    }


}
