/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process.scheduler.Algorithms;

import com.mycompany.process.scheduler.Process;
import com.mycompany.process.scheduler.Response;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author joaovitorbatistella
 */
public class SJF {
    public ArrayList<Process> processes;
    
    public SJF(ArrayList<Process> processes) {
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
        ArrayList<Float> processes_times = new ArrayList<>();

        int i=0;
        ArrayList<Integer> order = new ArrayList<>();
        
        Collections.sort(processes, (Process p1, Process p2) -> {
            if (p1.arrival_time > p2.arrival_time)
                return 1;
            if (p1.arrival_time < p2.arrival_time)
                return -1;
            return 0;
        });
        
        ArrayList<Process> auxProcess = (ArrayList) processes.clone();
        
//        System.out.println("\nBefore Sorted");
//        for (Process process : auxProcess) {
//            System.out.println("PID: " + process.pid);
//        }
        
        
        for (Process process : processes) {
//            ArrayList<Process> processesFilterd = 
//                    (ArrayList<Process>) processes.stream().filter(
//                        proc -> proc.arrival_time > process.execution_time
//                    ).collect(Collectors.toList());

//            ArrayList<Process> processesFilterd = 
//                    (ArrayList<Process>) processes.stream().filter(
//                        proc -> proc.arrival_time > process.arrival_time
//                    ).collect(Collectors.toList());

            
            Collections.sort(auxProcess, (Process p1, Process p2) -> {
                if(p2.arrival_time <= process.arrival_time) {
                    return 1;
                } else {
                    if (p1.runtime > p2.runtime) {
                        return 1;                        
                    }
                    if (p1.runtime < p2.runtime) {
                        return -1;                                            
                    }
                }
                return 0;
            });
            
        }
        
//        System.out.println("\nSorted");
//        for (Process process : auxProcess) {
//            System.out.println("PID: " + process.pid);
//        }
        
        processes = auxProcess;
        
        i=0;
        for (Process process : processes) {
            waiting_time = 0;
            algorith_runtime += process.runtime;
            order.add(process.pid);
            response.runtime += process.runtime;
            if(i>0) {
                waiting_time = (sumArrayList(processes_times) - process.arrival_time);
            }

            response.addInProcessesRuntime(process.pid, algorith_runtime);

            processes_times.add(process.runtime);
            waiting_times.add(waiting_time);
            i++;
        }
        
        response.setAverageWaitingTime(sumArrayList(waiting_times)/processes.size());
        response.setOrder(order);
        response.setAlgoritm("SJF");
        
        return response;
    }
}
