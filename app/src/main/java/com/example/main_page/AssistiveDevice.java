package com.example.main_page;

import java.lang.reflect.Field;


public class AssistiveDevice {
    int remainCnt;
    int maxCnt;

    String imgName;
    String name;
    // state : 대여 상태(default : 대여 가능)
    // 찜
    // 품목별로 id

    public AssistiveDevice(String imgName, String name, int remainCnt, int maxCnt) {
        this.imgName = imgName;
        this.name = name;
        this.remainCnt = remainCnt;
        this.maxCnt = maxCnt;
    }

    public String getName () {
        return this.name;
    }

    public int getRemainCnt () { return this.remainCnt; }

    public String getImgName () { return this.imgName; }
};
