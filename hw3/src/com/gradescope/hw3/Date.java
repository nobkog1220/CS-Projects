
//package com.gradescope.hw3;
public class Date { //instance vars
    private int day;
    private int month;
    //String time is specially formated with hour(HH):minutes(MM)(AM/PM)
    //Examples: 05:30PM, 12:23AM and 03:45PM
    private String time;
    //To construct a date a legit day, month and string representing time are required
    //Assume correct input, not need to check if input is legit
    public Date(int day, int month, String time){ //constructor for date objects
        this.day = day;
        this.month = month;
        this.time = time;
    }
    public int getDay(){ //the following three getters get the objects fields
        return day;
    }
    public int getMonth(){
        return month;
    }
    public String getTime(){
        return time;
    }
    //Add toString method
    public String toString(){ //prints a formatted visualization of the date object
        return month + "/" + day +" "+ time;
    }
}
