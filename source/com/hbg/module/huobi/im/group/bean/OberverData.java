package com.hbg.module.huobi.im.group.bean;

public class OberverData {
    private Object data;
    private int type;

    public OberverData() {
    }

    public Object getData() {
        return this.data;
    }

    public int getType() {
        return this.type;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public OberverData(int i11, Object obj) {
        this.type = i11;
        this.data = obj;
    }
}
