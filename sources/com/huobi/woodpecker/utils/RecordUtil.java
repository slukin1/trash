package com.huobi.woodpecker.utils;

import com.huobi.woodpecker.b;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.ExtRecord;
import kv.a;

public class RecordUtil {

    /* renamed from: a  reason: collision with root package name */
    public static String f21167a = "Init";

    public static void a(BaseRecord baseRecord) {
        baseRecord.setSessionid(b());
        baseRecord.setUuid(b.n());
        baseRecord.setSid(b.o());
        baseRecord.setApp(b.f());
        baseRecord.setUid(b.m());
        baseRecord.setEnv(b.k());
        baseRecord.setSource(String.valueOf(3));
        if (baseRecord.getExt() == null) {
            baseRecord.setExt(new ExtRecord());
        }
        baseRecord.getExt().setAppbi(ContextUtil.c());
        baseRecord.getExt().setAppwm(b.q());
        baseRecord.getExt().setAppv(ContextUtil.d());
        baseRecord.getExt().setApposv(ContextUtil.m());
        baseRecord.getExt().setAppsdkv(ContextUtil.l());
        baseRecord.getExt().setApppt(ContextUtil.f());
        baseRecord.getExt().setApproot(a.d());
        baseRecord.getExt().setTimezone(TimeZoneUtils.a());
        baseRecord.getExt().setVPNon(CheckVPNUtils.a());
        baseRecord.getExt().setCarrierName(ContextUtil.i());
    }

    public static String b() {
        if ("Init".equals(f21167a)) {
            f21167a = b.a();
        }
        return f21167a;
    }

    public static void c() {
        f21167a = b.a();
    }
}
