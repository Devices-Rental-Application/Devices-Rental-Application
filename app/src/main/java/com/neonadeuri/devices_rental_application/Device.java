/*
* 작성자:이혁수, 정종현
* */
package com.neonadeuri.devices_rental_application;

import java.io.Serializable;

public class Device implements Serializable {
    private String id;
    private String name;
    private int maxCnt;
    private int currentCnt;
    private int resourceId;
    private String description;

    public Device(){
        this.id="1";
        this.name="1";
        this.maxCnt=1;
        this.currentCnt=1;
        this.resourceId=R.drawable.orcam;
        this.description="description";
    }

    public Device(int resourceId, String name, int currentCnt){
        this.id="1234";
        this.name=name;
        this.maxCnt=10;
        this.currentCnt=currentCnt;
        this.resourceId=resourceId;
        this.description="description";
    }

    public Device(String id,String name,int maxCnt, int currentCnt, int resourceId,
                  String description){
        this.id=id;
        this.name=name;
        this.maxCnt=maxCnt;
        this.currentCnt=currentCnt;
        this.resourceId=resourceId;
        this.description=description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxCnt() {
        return maxCnt;
    }

    public int getCurrentCnt() {
        return currentCnt;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getDescription(){return description;}

    public void setCurrentCnt(int currentCnt) {
        this.currentCnt = currentCnt;
    }
}