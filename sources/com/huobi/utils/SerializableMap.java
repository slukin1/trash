package com.huobi.utils;

import java.io.Serializable;
import java.util.Map;

public class SerializableMap<T> implements Serializable {
    private static final long serialVersionUID = -3813273698863858103L;
    private Map<String, T> map;

    public SerializableMap(Map<String, T> map2) {
        this.map = map2;
    }

    public Map<String, T> getMap() {
        return this.map;
    }

    public void setMap(Map<String, T> map2) {
        this.map = map2;
    }
}
