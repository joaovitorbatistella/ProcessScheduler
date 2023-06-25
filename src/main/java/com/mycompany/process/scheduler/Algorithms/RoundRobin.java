/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process.scheduler.Algorithms;

import com.mycompany.process.scheduler.Process;
import com.mycompany.process.scheduler.Response;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author joaovitorbatistella
 */
public class RoundRobin {
    public ArrayList<com.mycompany.process.scheduler.Process> processes;
    
    public RoundRobin(ArrayList<Process> processes) {
        this.processes = processes;
    }
    
    private float sumArrayList(ArrayList<Float> arr) {
        float sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);            
        }
        return sum;
    }
    
    public Response handle(Response response, float quantum, float cst) {
        
        float algorith_runtime = 0;

        ArrayList<Integer> order = new ArrayList<>();

        int i=0;
        int size = 0;
        do {            
            for (Process process : processes) {
                if(process.remaining_runtime > 0) {
                    if(i > 0) {
                        algorith_runtime += cst;                    
                    }
                    if(process.remaining_runtime > quantum) {
                        algorith_runtime += quantum; 
                        process.real_runtime = algorith_runtime; 
                        process.remaining_runtime -= quantum;
                    } else {
                        algorith_runtime += process.remaining_runtime; 
                        process.real_runtime = algorith_runtime; 
                        process.remaining_runtime -= process.remaining_runtime;                
                    }
                    order.add(process.pid);
                    i++;
                }
            }
            ArrayList<Process> processesFilterd = 
                    (ArrayList<Process>) processes.stream().filter(
                        proc -> proc.remaining_runtime > 0
                    ).collect(Collectors.toList());
            
            size = processesFilterd.size();
        } while (size > 0);
        
        
        for (Process process : processes) {
            response.addInProcessesRuntime(process.pid, process.real_runtime);
        }
        
        response.setOrder(order);
        response.setRuntime(algorith_runtime);
        response.setAlgoritm("Round Robin");
        
        return response;
    }
}
