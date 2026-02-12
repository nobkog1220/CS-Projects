
//package com.gradescope.hw3;



public class ToDoList { //instance vars
    //declare three instance variable, use diagram to name them correctly
    TaskNode firstTask;
    TaskNode lastTask;
    int size = 0;

    public ToDoList() { //constructor to initialize a new todolist
        firstTask = null;
        lastTask = null;
        size = 0;
        //add commands for the deafult and only costructor
    }

    //add getters
    public int size() { //the following three getters return the desired field of the todolist object
        //put your code here
        return size;

    }

    public TaskNode getFirstTask() {
        //put your code here
        return firstTask;
    }

    public TaskNode getLastTask() {
        //put your code here
        return lastTask;
    }

    //inserts task at the end

    public void insertTask(Task t) { //takes task t and adds it to the start of the list. If the list is empty it becomes the only element.
        //put your code for insertTask here
        TaskNode n = new TaskNode(t);
        if (firstTask == null) {
            firstTask = n;
            lastTask = n;
        } else {
            n.prevTask = lastTask; // needed so when I add the task node the nodes
            //previous task becomes the last task in the chain
            lastTask.nextTask = n;
            lastTask = n;
        }
        size++;
    }



    public void printToDoList() { //prints the todolist in the desired format [task, task, ...]. if the list is empty an empty [] is printed
        //put your code here

        TaskNode temp = firstTask;
        if (size == 0) {
            System.out.println("[]");
        } else {
            String ans = ("[" + firstTask.task);
            for (int i = 1; i < size; i++) {
                temp = temp.nextTask;
                ans = ans + (", " + temp.task);
            }
            ans += "]";
            System.out.println(ans);
        }

    }


    //markCompleted takes provided Task ans updates is status to completed
    public void markCompleted(Task t) {
        //using l and temp, the method checks if a given task is equal to a task in the list by doing so we know which task to update to completed status
        TaskNode l = this.firstTask;
        TaskNode temp = new TaskNode(t);
        if (l.task.getDueDate().getTime().equals(temp.task.getDueDate().getTime())
                && l.task.getDueDate().getDay() == temp.task.getDueDate().getDay()
                && l.task.getDueDate().getMonth() == temp.task.getDueDate().getMonth()) {
            l.task.completed();
        } else {
            while (l.nextTask != null) { //after checking the first task we loop through the rest until reaching the desired task
                l = l.nextTask;
                if (l.task.getDueDate().getTime().equals(temp.task.getDueDate().getTime())
                        && l.task.getDueDate().getDay() == temp.task.getDueDate().getDay()
                        && l.task.getDueDate().getMonth() == temp.task.getDueDate().getMonth()) {
                    l.task.completed();
                }
            }
        }
    }


    //creates a list that has all tasks that have this day and month as due date
    //order is exact same as in original list
    //this method checks each task and compares its day and month against the inputs day and month. If they match theyre added to a new list of tasks which is then returned. this list will be a collection of all tasks matching the desired day and month
    public ToDoList todaysList(int day, int month) {
        //put your code here
        ToDoList tTasks = new ToDoList();
        TaskNode l = this.firstTask;
        if (l.task.getDueDate().getDay() == day && l.task.getDueDate().getMonth() == month) {
            tTasks.insertTask(new Task(l.task.getTaskName(), new Date(day, month, l.task.getDueDate().getTime())));
        } else {
            while (l.nextTask != null) {
                l = l.nextTask;
                if (l.task.getDueDate().getDay() == day && l.task.getDueDate().getMonth() == month) {
                    tTasks.insertTask(new Task(l.task.getTaskName(), new Date(day, month, l.task.getDueDate().getTime())));
                }
            }
        }
        return tTasks;
    }



    //deletes task t
    public void deleteTask(Task t) {
        // put your code here
        TaskNode l = this.firstTask; //fields to track the first and last tasks
        TaskNode b = this.lastTask;

        if (l == null) {  //if the list is empty it nulls the lasttask to avoid error and uses return to end the method
            this.lastTask = null;
            return;
        }
//if the first task is being deleted, it checks equality of tasks and if equal it corrects the pointers
        if (l != null && l.task.getDueDate().getTime().equals(t.getDueDate().getTime())
                && l.task.getDueDate().getDay() == t.getDueDate().getDay()
                && l.task.getDueDate().getMonth() == t.getDueDate().getMonth()
                && l.task.getTaskName().equals(t.getTaskName())
                && l.task.getStatus() == t.getStatus()) {

            this.firstTask = l.nextTask;
            //null checks first task so it can null out last task if it is or reassigns the firsttask.prevtask to null as there wouldnt be a prev task there
            if (firstTask != null) {
                firstTask.prevTask = null;
            } else {
                lastTask = null;
            }

            size--;
            return;
        }
        // this part of the method works almost exactly the same as the above section of code
        //checks equality and null check
        if (b != null && b.task.getDueDate().getTime().equals(t.getDueDate().getTime())
                && b.task.getDueDate().getDay() == t.getDueDate().getDay()
                && b.task.getDueDate().getMonth() == t.getDueDate().getMonth()
                && b.task.getTaskName().equals(t.getTaskName())
                && b.task.getStatus() == t.getStatus()) {

            this.lastTask = b.prevTask;
            //null checks to correctly assign fields and pointers
            if (lastTask != null) {
                lastTask.nextTask = null;
            } else {
                firstTask = null;
            }

            size--;
            return;
        }
        // deletion when the task isnt the first or last task being deleted
        while (l != null) { //equality checks
            if (l.task.getDueDate().getTime().equals(t.getDueDate().getTime())
                    && l.task.getDueDate().getDay() == t.getDueDate().getDay()
                    && l.task.getDueDate().getMonth() == t.getDueDate().getMonth()
                    && l.task.getTaskName().equals(t.getTaskName())
                    && l.task.getStatus() == t.getStatus()) {

                l.prevTask.nextTask = l.nextTask;
                //null check to correctly handle fields and pointers
                if (l.nextTask != null) {
                    l.nextTask.prevTask = l.prevTask;
                }

                size--;
                return;
            }
            l = l.nextTask;
        }
    }





    //Remove all completed tasks from the list
    public void removeCompleted() { //loops through the list of tasks and checks each ones status, deleting the ones with completed status
        TaskNode l = firstTask;
        while(l!=null){
            TaskNode n = l.nextTask;
            if(l.task.getStatus()){
                deleteTask(l.task);
            }
            l = n;
        }

    }
}





