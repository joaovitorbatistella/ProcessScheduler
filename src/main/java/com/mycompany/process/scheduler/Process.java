/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process.scheduler;

import java.util.PriorityQueue;

/**
 *
 * @author lab
 */
public class Process {

    public int pid;
    public String name;
    public int priority;
    public float execution_time;
    
    public Process(int pid, String name, int priority, float execution_time) {
        this.pid = pid;
        this.name = name;
        this.priority = priority;
        this.execution_time = execution_time;
    }
    
    public int getPid() {
        return this.pid;
    }
    
    public String getName() {
        return this.name;
    }
}
