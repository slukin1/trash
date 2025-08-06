package com.tencent.android.tpush;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.xiaomi.mipush.sdk.MiPushClient;

public enum TypeStr {
    config(10, TUIConstants.TUIPlugin.PLUGIN_EXTENSION_CONFIG),
    config_all(11, "config/#"),
    msg(20, RemoteMessageConst.MessageBody.MSG),
    msg_all(21, "msg/#"),
    hearbeat(30, "heart"),
    hearbeat_all(31, "heart/#"),
    feedback(40, "feedback"),
    feedback_all(41, "feedback/#"),
    token(50, "token"),
    register(60, MiPushClient.COMMAND_REGISTER),
    pullupxg(70, "pullupxg"),
    insert_mid_new(80, "insert_mid_new"),
    insert_mid_old(81, "insert_mid_old"),
    hearbeat_cyclecheck(82, "hbcyheck");
    
    private String str;
    private int type;

    private TypeStr(int i11, String str2) {
        this.type = i11;
        this.str = str2;
    }

    public static TypeStr getTypeStr(int i11) {
        if (i11 == 10) {
            return config;
        }
        if (i11 == 11) {
            return config_all;
        }
        if (i11 == 20) {
            return msg;
        }
        if (i11 == 21) {
            return msg_all;
        }
        if (i11 == 30) {
            return hearbeat;
        }
        if (i11 == 31) {
            return hearbeat_all;
        }
        if (i11 == 40) {
            return feedback;
        }
        if (i11 == 41) {
            return feedback_all;
        }
        if (i11 == 50) {
            return token;
        }
        if (i11 == 60) {
            return register;
        }
        if (i11 == 70) {
            return pullupxg;
        }
        switch (i11) {
            case 80:
                return insert_mid_new;
            case 81:
                return insert_mid_old;
            case 82:
                return hearbeat_cyclecheck;
            default:
                return null;
        }
    }

    public String getStr() {
        return this.str;
    }

    public int getType() {
        return this.type;
    }
}
