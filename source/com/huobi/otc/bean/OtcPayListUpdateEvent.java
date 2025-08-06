package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcPayListUpdateEvent implements Serializable {
    public static final int FLAG_ACTION_ACTIVITE = 0;
    public static final int FLAG_ACTION_DELETE = 2;
    public static final int FLAG_ACTION_UNACTIVITE = 1;
    public UserPayMethodBean bean;
    public int flag;
}
