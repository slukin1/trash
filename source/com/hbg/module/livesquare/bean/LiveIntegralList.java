package com.hbg.module.livesquare.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class LiveIntegralList implements Serializable {
    public int code;
    public ArrayList<LiveIntegralInfo> data;
    public String message;

    public class LiveIntegralInfo implements Serializable {
        public static final int LIVE_INTEGRAL_TYPE_APPOINTMENT = 7;
        public static final int LIVE_INTEGRAL_TYPE_ATTENTION = 4;
        public static final int LIVE_INTEGRAL_TYPE_COMMENT = 2;
        public static final int LIVE_INTEGRAL_TYPE_PARISE = 1;
        public static final int LIVE_INTEGRAL_TYPE_REWARD = 6;
        public static final int LIVE_INTEGRAL_TYPE_SHARE = 3;
        public static final int LIVE_INTEGRAL_TYPE_WATCH = 5;
        public long createTime;
        public int drawNumber;

        /* renamed from: id  reason: collision with root package name */
        public int f26471id;
        public int number;
        public int status;
        public int type;

        public LiveIntegralInfo() {
        }
    }
}
