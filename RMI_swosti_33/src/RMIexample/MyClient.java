/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIexample;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author swosti
 */
public class MyClient {
     public static void main(String[] args) {
try {
Registry reg=LocateRegistry.getRegistry("localhost",5000);
adder ad=(adder)reg.lookup("hi_server");
System.out.println("Addition:"+ad.add(20, 30)); 

} catch (Exception e) {
System.out.println(e);
}
}
}

