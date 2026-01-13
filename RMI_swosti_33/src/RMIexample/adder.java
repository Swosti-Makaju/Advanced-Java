/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMIexample;

import java.rmi.*;
/**
 *
 * @author swosti
 */
public interface adder extends Remote {
    public int add(int x,int y)throws RemoteException; 
}

 