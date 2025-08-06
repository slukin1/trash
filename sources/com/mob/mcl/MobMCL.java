package com.mob.mcl;

import android.content.Context;
import android.os.Bundle;
import com.mob.mcl.b.a;
import com.mob.mcl.c.h;
import com.mob.mgs.OnIdChangeListener;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.utils.e;

public class MobMCL implements EverythingKeeper {
    public static final String SDK_TAG = "MobMCL";

    public interface ELPMessageListener extends EverythingKeeper {
        boolean messageReceived(Bundle bundle);
    }

    public static void addBusinessMessageListener(int i11, BusinessMessageListener businessMessageListener) {
        a.a(i11, businessMessageListener);
    }

    public static void addELPMessageListener(ELPMessageListener eLPMessageListener) {
        a.a(eLPMessageListener);
    }

    public static void deleteMsg(String str) {
        h.b().a(str);
    }

    public static void getClientTcpStatus(BusinessCallBack<Boolean> businessCallBack) {
        h.b().a(businessCallBack);
    }

    public static long getCreateSuidTime() {
        return a.b();
    }

    public static String getSuid() {
        return a.a();
    }

    public static void getTcpStatus(BusinessCallBack<Boolean> businessCallBack) {
        h.b().b(businessCallBack);
    }

    public static void initMCLink(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static void registerTcpStatusListener(TcpStatusListener tcpStatusListener) {
        h.b().a(tcpStatusListener);
    }

    public static void syncSuid(String str, long j11, e<Boolean> eVar) {
        a.a(str, j11, eVar);
    }

    public void unregisterTcpStatusListener(TcpStatusListener tcpStatusListener) {
        h.b().b(tcpStatusListener);
    }

    public static void getSuid(OnIdChangeListener onIdChangeListener) {
        a.a(onIdChangeListener);
    }
}
