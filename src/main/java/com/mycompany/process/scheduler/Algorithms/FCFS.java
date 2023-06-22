/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process.scheduler.Algorithms;

import com.mycompany.process.scheduler.Process;
import com.mycompany.process.scheduler.Response;
import java.util.ArrayList;

/**
 *
 * @author lab
 */
public class FCFS {
    
    public ArrayList<Process> processes;
    public Response response;
    
    public FCFS(ArrayList<Process> processes) {
        this.processes = processes;
    }
    
    public void handle() {
        
        float waiting_time = 0;

        int i=0;
        for (Process process : processes) {
            this.response.execution_time += process.execution_time;
            if(i>0) {
                waiting_time += processes.get(i-0).execution_time;
            }
            i++;
        }
        
        this.response.average_waiting_time = waiting_time/processes.size();
    }
    
}
