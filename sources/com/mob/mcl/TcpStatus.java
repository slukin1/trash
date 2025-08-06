package com.mob.mcl;

import com.mob.tools.proguard.EverythingKeeper;

public class TcpStatus implements EverythingKeeper {
    public static final int TYPE_FORCE_CLOSE = 22;
    public static final int TYPE_INIT_FLOW_END = 20;
    public static final int TYPE_INIT_FLOW_EXCEPTION = 23;
    public static final int TYPE_REGISTER_FAILED = 24;
    public static final int TYPE_REGISTER_SUCCESS = 10;
    public static final int TYPE_TCP_UNAVAILABLE = 21;
    public int code;
    public String detailedMsg;
    public String msg;

    private TcpStatus(int i11, String str) {
        this.code = i11;
        this.msg = str;
    }

    public static TcpStatus obtain(int i11) {
        String str;
        if (i11 != 10) {
            switch (i11) {
                case 20:
                    str = "20:tcp init flow end(rare status)";
                    break;
                case 21:
                    str = "21:tcp unavailable";
                    break;
                case 22:
                    str = "22:tcp force close(rare status)";
                    break;
                case 23:
                    str = "23:tcp init flow exception(rare status)";
                    break;
                case 24:
                    str = "24:register failed";
                    break;
                default:
                    str = "0:unknown(rare status)";
                    break;
            }
        } else {
            str = "10:tcp register success";
        }
        String[] split = str.split(":");
        return new TcpStatus(Integer.parseInt(split[0]), split[1]);
    }

    public TcpStatus setDetailedMsg(String str) {
        this.detailedMsg = str;
        return this;
    }

    public String toString() {
        return "TcpStatus[code: " + this.code + ", msg: " + this.msg + ", detailedMsg: " + this.detailedMsg + "]";
    }
}
