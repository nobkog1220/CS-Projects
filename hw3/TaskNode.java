
//package com.gradescope.hw3;


public class TaskNode { //instance variables
    //add instance variables/fields to match picture in directions
    public TaskNode prevTask;
    public TaskNode nextTask;
    public Task task;
    public String name;
    public Date date;
    public TaskNode(String name, Date date){ //constructor which only takes name and date
        //initialize all fields (default is null)
        prevTask = null;
        nextTask = null;
        this.task = new Task(name, date);
        this.name = name;
        this.date = date;

    }
    public TaskNode(Task task){ //constructor only taking in task
        //initialize all fields
        prevTask = null;
        nextTask = null;
        this.task = task;
        this.name = null;
        this.date = null;
    }
    public TaskNode(String name, Date date, TaskNode prev, TaskNode next){ //constructor taking in all fields
        //initialize all fields
        prevTask = prev;
        nextTask = next;
        this.task = new Task(name, date);
        this.name = name;
        this.date = date;

    }
    public TaskNode(Task task, TaskNode prev, TaskNode next){ //constructor taking in task, prev, and next
        //initialize all fields
        prevTask = prev;
        nextTask = next;
        this.task = task;
        this.name = null;
        this.date = null;
    }

}
