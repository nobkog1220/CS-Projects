package com.gradescope.hw3;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.Assert.*;


//This class should help you test your code
//Refer to HW3.pdf on order in which you should
//uncoment tests
//If you uncomment everything this file will not compile and cause
//issue, because it calls methods and uses Objects you didn't implement yet


public class TestHW3 {

    @Test
    public void testDate() {
        Date d = new Date(23, 5, "8:00AM");
        assertEquals(23, d.getDay());
        assertEquals(5, d.getMonth());
        assertEquals("8:00AM", d.getTime());
        assertEquals("5/23 8:00AM", d.toString());
    }

    @Test
    public void test1Task() {
        Date d = new Date(30, 3, "10:00PM");
        Task t = new Task("Go to sleep", d);
        assertFalse(t.getStatus());
        assertEquals(30, t.getDueDate().getDay());
        assertEquals(3, t.getDueDate().getMonth());
        assertEquals("Go to sleep", t.getTaskName());
        assertEquals("10:00PM", t.getDueDate().getTime());
    }

    @Test
    public void test2Task() {
        Date d = new Date(23, 5, "8:00AM");
        Task t = new Task("Flight to Denever", d);
        assertFalse(t.getStatus());
        assertEquals("Flight to Denever is due 5/23 8:00AM status not completed", t.toString());
        t.completed();
        assertEquals("Flight to Denever is due 5/23 8:00AM status completed", t.toString());
    }

    @Test
    public void test3TaskEquals() {
        Date d1 = new Date(23, 5, "8:00AM");
        Task t1 = new Task("Flight to Denever", d1);
        Date d2 = new Date(30, 3, "10:00PM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(30, 3, "10:00PM");
        Task t3 = new Task("Flight to Denever", d3);
        assertFalse(t1.equals(t3));
        assertTrue(t2.equals(t3));
        assertFalse(t1.equals(d1));
    }


    @Test
    public void testTaskNodeConstructor1() {
        Date d = new Date(30, 3, "10:00PM");
        TaskNode t1 = new TaskNode("Go to sleep", d);
        assertFalse(t1.task.getStatus());
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", t1.task.toString());
        assertNull(t1.nextTask);
        assertNull(t1.prevTask);
    }

    @Test
    public void testTaskNodeConstructor2() {
        Date d = new Date(30, 3, "10:00PM");
        Task t = new Task("Go to sleep", d);
        TaskNode t1 = new TaskNode(t);
        assertFalse(t1.task.getStatus());
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", t1.task.toString());
        assertNull(t1.nextTask);
        assertNull(t1.prevTask);
    }

    @Test
    public void testTaskNodeConstructor3() {
        Date d = new Date(30, 3, "10:00PM");
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(6, 12, "9:30AM");
        Task t3 = new Task("Class", d3);
        TaskNode tn3 = new TaskNode(t3);
        TaskNode tn2 = new TaskNode(t2);
        TaskNode tn1 = new TaskNode("Go to sleep", d, tn3, tn2);
        assertFalse(tn1.task.getStatus());
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", tn1.task.toString());
        assertEquals("Flight to Denever is due 5/23 8:00AM status not completed", tn1.nextTask.task.toString());
        assertEquals("Class is due 12/6 9:30AM status not completed", tn1.prevTask.task.toString());
    }

    @Test
    public void testTaskNodeConstructor4() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(6, 12, "9:30AM");
        Task t3 = new Task("Class", d3);
        TaskNode tn3 = new TaskNode(t3);
        TaskNode tn2 = new TaskNode(t2);
        TaskNode tn1 = new TaskNode(t1, tn2, tn3);
        assertFalse(tn1.task.getStatus());
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", tn1.task.toString());
        assertEquals("Flight to Denever is due 5/23 8:00AM status not completed", tn1.prevTask.task.toString());
        assertEquals("Class is due 12/6 9:30AM status not completed", tn1.nextTask.task.toString());
    }

    @Test
    public void testToDoListDefaultConstructor() {
        ToDoList list = new ToDoList();
        assertNull(list.getFirstTask());
        assertNull(list.getLastTask());
        assertEquals(0, list.size());
    }

    @Test
    public void test1ToDoListInsertTask() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(6, 12, "9:30AM");
        Task t3 = new Task("Class", d3);
        TaskNode tn3 = new TaskNode(t3);
        TaskNode tn2 = new TaskNode(t2);
        TaskNode tn1 = new TaskNode(t1, tn2, tn3);
        ToDoList list = new ToDoList();
        list.insertTask(t1);
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", list.getFirstTask().task.toString());
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", list.getLastTask().task.toString());
        assertEquals(1, list.size());
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", tn1.task.toString());
        assertEquals("Flight to Denever is due 5/23 8:00AM status not completed", tn1.prevTask.task.toString());
        assertEquals("Class is due 12/6 9:30AM status not completed", tn1.nextTask.task.toString());
    }

    @Test
    public void test2ToDoListInsertTask() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(6, 12, "9:30AM");
        Task t3 = new Task("Class", d3);
        ToDoList list = new ToDoList();
        list.insertTask(t1);
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", list.getFirstTask().task.toString());
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", list.getLastTask().task.toString());
        assertEquals(1, list.size());
        list.insertTask(t2);
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", list.getFirstTask().task.toString());
        assertEquals("Flight to Denever is due 5/23 8:00AM status not completed", list.getLastTask().task.toString());
        assertEquals(2, list.size());
        list.insertTask(t3);
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", list.getFirstTask().task.toString());
        assertEquals("Class is due 12/6 9:30AM status not completed", list.getLastTask().task.toString());
        assertEquals(3, list.size());
        assertEquals("Flight to Denever is due 5/23 8:00AM status not completed", list.getFirstTask().nextTask.task.toString());
        assertEquals("Class is due 12/6 9:30AM status not completed", list.getFirstTask().nextTask.nextTask.task.toString());
        assertEquals("Flight to Denever is due 5/23 8:00AM status not completed", list.getLastTask().prevTask.task.toString());
        assertEquals("Go to sleep is due 3/30 10:00PM status not completed", list.getLastTask().prevTask.prevTask.task.toString());
    }

    @Test
    public void testPrint() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        ToDoList list = new ToDoList();
        list.insertTask(t1);
        list.insertTask(t2);
        String ans = "[Go to sleep is due 3/30 10:00PM status not completed, Flight to Denever is due 5/23 8:00AM status not completed]";
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        list.printToDoList();
        System.setOut(originalOut);
        String separator = System.getProperty("line.separator");
        assertEquals(ans + separator, bos.toString());
    }

    @Test
    public void testMarkCompleted() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(23, 5, "8:00AM");
        Task t3 = new Task("Flight to Denever", d3);
        Date d4 = new Date(6, 12, "9:30AM");
        Task t4 = new Task("Class", d4);
        ToDoList list = new ToDoList();
        list.insertTask(t1);
        list.insertTask(t2);
        list.insertTask(t4);
        list.markCompleted(t1);
        list.markCompleted(t3);
        String ans = "[Go to sleep is due 3/30 10:00PM status completed, Flight to Denever is due 5/23 8:00AM status completed, Class is due 12/6 9:30AM status not completed]";
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        list.printToDoList();
        System.setOut(originalOut);
        String separator = System.getProperty("line.separator");
        assertEquals(ans + separator, bos.toString());
    }

    @Test
    public void testTodaysList() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(23, 5, "12:18PM");
        Task t3 = new Task("Flight to Iowa City", d3);
        Date d4 = new Date(6, 12, "9:30AM");
        Task t4 = new Task("Class", d4);
        ToDoList list = new ToDoList();
        list.insertTask(t1);
        list.insertTask(t2);
        list.insertTask(t3);
        list.insertTask(t4);
        list.markCompleted(t1);
        ToDoList today = list.todaysList(23, 5);
        String ans = "[Flight to Denever is due 5/23 8:00AM status not completed, Flight to Iowa City is due 5/23 12:18PM status not completed]";
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        today.printToDoList();
        System.setOut(originalOut);
        String separator = System.getProperty("line.separator");
        assertEquals(ans + separator, bos.toString());
    }

    @Test
    public void testDeleteTask1() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(23, 5, "12:18PM");
        Task t3 = new Task("Flight to Iowa City", d3);
        ToDoList list = new ToDoList();
        list.insertTask(t1);
        list.insertTask(t2);
        list.insertTask(t3);
        list.deleteTask(t2);
        assertEquals(2, list.size());
        String ans = "[Go to sleep is due 3/30 10:00PM status not completed, Flight to Iowa City is due 5/23 12:18PM status not completed]";
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        list.printToDoList();
        System.setOut(originalOut);
        String separator = System.getProperty("line.separator");
        assertEquals(ans + separator, bos.toString());
    }


    @Test
    public void testDeleteTask2() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(23, 5, "12:18PM");
        Task t3 = new Task("Flight to Iowa City", d3);
        Date d4 = new Date(6, 12, "9:30AM");
        Task t4 = new Task("Class", d4);
        ToDoList list = new ToDoList();
        list.insertTask(t1);
        list.insertTask(t2);
        list.insertTask(t3);
        list.deleteTask(t2);
        list.insertTask(t4);
        list.deleteTask(t1);
        assertEquals(2, list.size());
        String ans = "[Flight to Iowa City is due 5/23 12:18PM status not completed, Class is due 12/6 9:30AM status not completed]";
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        list.printToDoList();
        System.setOut(originalOut);
        String separator = System.getProperty("line.separator");
        assertEquals(ans + separator, bos.toString());
    }


    @Test

    public void testRemoveCompleted() {
        Date d1 = new Date(30, 3, "10:00PM");
        Task t1 = new Task("Go to sleep", d1);
        Date d2 = new Date(23, 5, "8:00AM");
        Task t2 = new Task("Flight to Denever", d2);
        Date d3 = new Date(23, 5, "12:18PM");
        Task t3 = new Task("Flight to Iowa City", d3);
        Date d4 = new Date(6, 12, "9:30AM");
        Task t4 = new Task("Class", d4);
        ToDoList list = new ToDoList();
        list.insertTask(t1);
        list.insertTask(t2);
        list.insertTask(t3);
        list.insertTask(t4);
        list.markCompleted(t1);
        list.markCompleted(t2);
        list.removeCompleted();
        assertEquals(2, list.size());
        String ans = "[Flight to Iowa City is due 5/23 12:18PM status not completed, Class is due 12/6 9:30AM status not completed]";
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        list.printToDoList();
        System.setOut(originalOut);
        String separator = System.getProperty("line.separator");
        assertEquals(ans + separator, bos.toString());
    }
}



