
//package com.gradescope.hw3;
public class Task { //instance vars
    private String taskName;
    private Date dueDate;
    //status is true is the task is completes, else it's false
    private boolean status;
    public Task(String name, Date date){ //constructor for task objects
        this.taskName = name;
        this.dueDate = date;
        this.status = false;
    }
    public String getTaskName(){ //the following three getters return the objects fields
        //add your code here
        return this.taskName;
    }
    public Date getDueDate(){
        //add your code here
        return this.dueDate;
    }
    public boolean getStatus(){
        //add your code here
        return this.status;
    }
    //Add completed method that updates status of the Task
    public void completed(){ //updates status to true
        //add your code here
        this.status = true;
    }

    //Add toString method
    public String toString(){ //returns a visualization of the task object with two outcomes depending on its status
        if(this.status) {
            return this.taskName + " is due " + this.dueDate + " status completed";
        }
        else{
            return this.taskName + " is due " + this.dueDate + " status not completed";
        }
    }

    //equals method that recieves Object o
    //returns true only if the Object is of type Task
    //and all the fields of task match
    public boolean equals(Object o){ //similar to point class, we check if the parameter is a task and then check all of its fields for equality with the object its being checked against
        //add your code here
        if(!(o instanceof Task)){
            return false;
        }
        Task temp = (Task)o;
        return this.taskName.equals(temp.taskName)
                && this.dueDate.getTime().equals(temp.dueDate.getTime())
                && this.dueDate.getDay() == temp.dueDate.getDay()
                && this.dueDate.getMonth()==temp.dueDate.getMonth()
                && this.status == temp.status;


    }
}