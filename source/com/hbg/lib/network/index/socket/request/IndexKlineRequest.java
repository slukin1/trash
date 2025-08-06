package com.hbg.lib.network.index.socket.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hbg.lib.network.pro.socket.request.BaseSocketRequest;
import d2.b;
import e8.a;
import h2.p;

public class IndexKlineRequest extends BaseSocketRequest {
    private long from;
    @b(serialize = false)
    private String period;
    @b(serialize = false)
    private String symbol;

    /* renamed from: to  reason: collision with root package name */
    private long f70309to;

    public IndexKlineRequest(String str, String str2, long j11, long j12) {
        this.symbol = str;
        this.period = str2;
        this.from = j11;
        this.f70309to = j12;
        setReq("market." + str + ".index." + str2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toString$0(Object obj, String str, Object obj2) {
        return (!str.equals("from") && !str.equals("to")) || ((Long) obj2).longValue() > 0;
    }

    public long getFrom() {
        return this.from;
    }

    public long getTo() {
        return this.f70309to;
    }

    public void setFrom(long j11) {
        this.from = j11;
    }

    public void setTo(long j11) {
        this.f70309to = j11;
    }

    public String toString() {
        return JSON.toJSONString((Object) this, new p[]{a.f54304a}, new SerializerFeature[0]);
    }
}
