package cn.sharesdk.loopshare.beans;

import com.mob.tools.proguard.PrivateMemberKeeper;

public abstract class ServerData implements PrivateMemberKeeper {
    private String error;
    private int status;

    public static class Res implements PrivateMemberKeeper {
    }

    public static int a(int i11) {
        return i11;
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static boolean a(ServerData serverData) {
        return serverData != null && 200 == serverData.h();
    }

    public boolean a_() {
        return a(this);
    }

    public int h() {
        return a(this.status);
    }

    public String i() {
        return a(this.error);
    }
}
