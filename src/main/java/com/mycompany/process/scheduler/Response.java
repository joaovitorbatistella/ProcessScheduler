/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process.scheduler;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joaovitorbatistella
 */
public class Response {

    private String algorithm;
    public float runtime;
    private float average_waiting_time;
    private ArrayList<Integer> order;
    private Map<Integer, Float> processes_runtime;

    public Response() {
        this.processes_runtime = new HashMap<>();
    }
    
    public void setAlgoritm(String value) {
        this.algorithm = value;
    }
    
    public void setRuntime(Float value) {
        this.runtime = value;
    }
        
    public void setAverageWaitingTime(Float value) {
        this.average_waiting_time = value;
    }
        
    public void setOrder(ArrayList<Integer> value) {
        this.order = value;
    }
    
    public void addInProcessesRuntime(int pid, float runtime) {
        this.processes_runtime.put(pid, runtime);            
    }
    
    public String getAlgoritm() {
        return this.algorithm;
    }
    
    public float getRuntime() {
        return this.runtime;
    }
        
    public float getAverageWaitingTime() {
        return this.average_waiting_time;
    }
        
    public ArrayList<Integer> getOrder() {
        return this.order;
    }
    
    public Map<Integer, Float> getProcessesRuntime() {
        return this.processes_runtime;
    }
    
    public void printRespose(int option) {
        System.out.print("\n");
        System.out.println("\t\tResults - [" + this.algorithm + "] \n");
        System.out.println("\tPID order:");
        
        for(int i = 0; i < this.order.size(); i++) {
            System.out.println("\t\t* PID: " + this.order.get(i));
        }
        
        System.out.println("\n\tAlgorithm runtime: " + this.runtime);
        
        if(!processes_runtime.isEmpty()) {
            System.out.println("\tProcesses runtime:");
            for (Map.Entry<Integer, Float> entry : processes_runtime.entrySet()) {
                Object key = entry.getKey();
                Object val = entry.getValue();
                
                System.out.println("\t\t* PID: " + key.toString() + " - " + val.toString());
            }
        }    
            
        if(option == 0 || option == 1) {
            System.out.println("\tAverage waiting time: " + this.average_waiting_time);            
        }
        
    }
}
