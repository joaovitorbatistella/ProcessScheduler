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
 * @author joaovitorbatistella
 */
public class FCFS {
    
    public ArrayList<Process> processes;
    
    public FCFS(ArrayList<Process> processes) {
        this.processes = processes;
    }
    
    private float sumArrayList(ArrayList<Float> arr) {
        float sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);            
        }
        return sum;
    }
    
    public Response handle(Response response) {
        
        float waiting_time = 0;
        float algorith_runtime = 0;
        ArrayList<Float> waiting_times = new ArrayList<>();

        int i=0;
        ArrayList<Integer> order = new ArrayList<>();
        for (Process process : processes) {
            algorith_runtime += process.runtime;
            order.add(process.pid);
            response.runtime += process.runtime;
            if(i>0) {
                waiting_time += processes.get(i-1).runtime;
            }

            response.addInProcessesRuntime(process.pid, algorith_runtime);
            waiting_times.add(waiting_time);
            i++;
        }
        
        response.setAverageWaitingTime(sumArrayList(waiting_times)/processes.size());
        response.setOrder(order);
        response.setAlgoritm("FCFS");
        
        return response;
    }
    
}
