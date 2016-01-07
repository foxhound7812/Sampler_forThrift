package com.thriftDev;

/**
 * Created by foxhound7812 on 2016/1/6.
 */

import org.apache.thrift.TException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ThriftRemoteCMD_Handler implements ThriftRemoteCMD_service.Iface {


    @Override
    public String call_ifconfig() throws TException{

        ArrayList ifconfigMsg = new ArrayList();

        try{


            Process p = Runtime.getRuntime().exec("ifconfig");

            p.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = reader.readLine();

            while (line != null){
                System.out.println(line);
                ifconfigMsg.add(line);
                line = reader.readLine();
            }



        }catch (Exception e){
            e.printStackTrace();
        }

        return ifconfigMsg.toString();


    }

    @Override
    public String call_netstat() throws TException{

        ArrayList ifconfigMsg = new ArrayList();

        try{


            Process p = Runtime.getRuntime().exec("netstat");

            p.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = reader.readLine();

            while (line != null){
                System.out.println(line);
                ifconfigMsg.add(line);
                line = reader.readLine();
            }



        }catch (Exception e){
            e.printStackTrace();
        }

        return ifconfigMsg.toString();
    }




}
