package com.mob.tools.utils;

public class c {
    public static synchronized boolean a() {
        synchronized (c.class) {
        }
        return false;
    }

    public static synchronized boolean b() {
        synchronized (c.class) {
        }
        return false;
    }
}
