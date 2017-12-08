package com.song.schedule;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class FirstScheduleBean  implements Serializable{

    public void print(){
        System.out.println("hello world");
    }
}
