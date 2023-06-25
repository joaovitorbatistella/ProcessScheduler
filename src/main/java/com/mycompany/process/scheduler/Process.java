/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process.scheduler;


/**
 *
 * @author joaovitorbatistella
 */
public class Process {

    public int pid;
    public String name;
//    public int priority;
    public float arrival_time;
    public float runtime;
    public float real_runtime;
    public float remaining_runtime;
    
    public Process(int pid, String name, float arrival_time, float runtime) {
        this.pid = pid;
        this.name = name;
//        this.priority = priority;
        this.arrival_time = arrival_time;
        this.runtime = runtime;
        this.remaining_runtime = runtime;
        this.real_runtime = 0;
    }
    
    public int getPid() {
        return this.pid;
    }
    
    public String getName() {
        return this.name;
    }
}
