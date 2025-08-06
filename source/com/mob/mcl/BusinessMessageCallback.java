package com.mob.mcl;

public abstract class BusinessMessageCallback implements BusinessMessageListener {
    public static final int STATUS_NO_RECEIVED = 0;
    public static final int STATUS_RECEIVED = 1;

    public abstract void messageReceived(int i11, int i12, String str, String str2);

    public void messageReceived(int i11, String str, String str2) {
    }
}
