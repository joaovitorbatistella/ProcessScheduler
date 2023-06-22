/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process.scheduler;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author lab
 */
public class Response {

    public String algorithm;
    public float execution_time;
    public float average_waiting_time;
    public ArrayList<Integer> order;
    
    public void setAlgoritm(String value) {
        this.algorithm = value;
    }
    
    public void setExecutionTime(Float value) {
        this.execution_time = value;
    }
        
    public void setAverageWaitingTime(Float value) {
        this.average_waiting_time = value;
    }
        
    public void setExecutionTime(ArrayList<Integer> value) {
        this.order = value;
    }
}
