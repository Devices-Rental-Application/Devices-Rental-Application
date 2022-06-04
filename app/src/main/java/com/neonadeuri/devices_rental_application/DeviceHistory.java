package com.neonadeuri.devices_rental_application;

public class DeviceHistory {
    private int resourceId;
    private String state;
    private String deviceName;
    private String date;
    private String receiver;

    public DeviceHistory(){
        this.resourceId = 1;
        this.state = "상태 확인 불가";
        this.deviceName = "device Name";
        this.date = "0115";
        this.receiver = "jong";
    }
    public DeviceHistory(int resourceId, String state, String deviceName, String date, String receiver){
        this.resourceId = resourceId;
        this.state = state;
        this.deviceName =deviceName;
        this.date =date;
        this.receiver = receiver;
    }
    public int getResourceId(){return resourceId;}
    public void setResourceId(int resourceId){
        this.resourceId = resourceId;
    }

    public String getState(){return state;}

    public String getDeviceName(){return deviceName;}

    public String getDate(){return date;}

    public String getReceiver(){return receiver;}

    public void setState(String state){
        this.state = state;
    }
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setReceiver(String receiver){
        this.receiver = receiver;
    }

}