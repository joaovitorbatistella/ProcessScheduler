/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.process.scheduler;

import com.mycompany.process.scheduler.Algorithms.FCFS;
import com.mycompany.process.scheduler.Algorithms.SJF;
import com.mycompany.process.scheduler.Algorithms.SRTF;
import com.mycompany.process.scheduler.Algorithms.RoundRobin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab
 */
public class ProcessScheduler {

    public static int getMenuOption()
    {
        Scanner read = new Scanner(System.in); 
        System.out.println("\nWhich algorithm do you want to use to simulate? ");
        System.out.println("0 - FCFS");
        System.out.println("1 - SJF");
        System.out.println("2 - SRTF");
        System.out.println("3 - Round Robin\n");
        return read.nextInt();
    }
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); 
        System.out.println("Welcome to...");
        System.out.println("-- Process Scheduler -- ");
        System.out.println("\n");
        
         ArrayList<Process> processes = new ArrayList<>();
        
        char input = 'Y'; 
        while(input != 'N') {
            int pid;
            String name;
            int priority;
            float execution_time;
            
            System.out.print("\nEnter a process 'pid': ");
            pid = read.nextInt();
            
            System.out.print("\nEnter a process 'name': ");
            name = read.next();
            
            System.out.print("\nEnter a process 'priority': ");
            priority = read.nextInt();
            
            System.out.print("\nEnter a process 'execution time': ");
            execution_time = read.nextFloat();
            
            processes.add((new Process(pid, name, priority, execution_time)));
            
            System.out.println("\n\nDo you enter one more process?: Y|N");
            input = read.next().charAt(0);
        }
        
        int op;
        do {
            op = getMenuOption();
            
            if(op != 0 && op != 1 && op != 2 && op != 3) {
                System.out.println("\nInvalid option, try again!");
            }
        } while (op != 0 && op != 1 && op != 2 && op != 3);
        
        try {
            switch (op) {
                case 0:
                    FCFS alg_fcfs = new FCFS(processes);
                    alg_fcfs.handle();
                    break;
                
                case 1:
                    SJF alg_sjf = new SJF(processes);
                    alg_sjf.handle();
                    break;
                
                case 2:
                    SRTF alg_srtf = new SRTF(processes);
                    alg_srtf.handle();
                    break;
                
                case 3:
                    RoundRobin alg_round_robin = new RoundRobin(processes);
                    alg_round_robin.handle();
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (AssertionError e) {
            return;
        }
        
        
        System.out.print("\n");
        for (Process process : processes) {
            System.out.println("Process name: " + process.getName());
        }
    }
}
