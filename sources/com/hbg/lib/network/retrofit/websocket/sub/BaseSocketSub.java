package com.hbg.lib.network.retrofit.websocket.sub;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSub;
import d2.b;
import h2.l;
import h2.p;
import i9.a;

public class BaseSocketSub implements ISocketSub {
    private static final int HQ_FREQ_FAST = 0;
    private static final int HQ_FREQ_SLOW = 5000;
    private static final long serialVersionUID = -2364550896775432140L;
    @b(serialize = false)
    private String channel;
    private l filter;
    @b(name = "freq-ms")
    private int freqMs;

    /* renamed from: id  reason: collision with root package name */
    private String f70674id;
    @b(serialize = false)
    private boolean isSubscribe;
    private String sub;
    private String unsub;

    public BaseSocketSub(boolean z11) {
        this(z11, (String) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Object obj, String str, Object obj2) {
        if (obj2 instanceof Integer) {
            if (((Integer) obj2).intValue() != 0) {
                return true;
            }
            return false;
        } else if (obj2 != null) {
            return true;
        } else {
            return false;
        }
    }

    public String getChannel() {
        if (this.isSubscribe) {
            return this.sub;
        }
        return this.unsub;
    }

    public String getSub() {
        return this.sub;
    }

    public String getUnsub() {
        return this.unsub;
    }

    public boolean isSame(ISocketSend iSocketSend) {
        if (iSocketSend.getClass() != getClass()) {
            return false;
        }
        BaseSocketSub baseSocketSub = (BaseSocketSub) iSocketSend;
        if (!TextUtils.equals(this.sub, baseSocketSub.sub) || !TextUtils.equals(this.unsub, baseSocketSub.unsub) || !TextUtils.equals(getChannel(), baseSocketSub.getChannel())) {
            return false;
        }
        return true;
    }

    public boolean isSubscribe() {
        return this.isSubscribe;
    }

    public void setChannel(String str) {
        this.channel = str;
        if (this.isSubscribe) {
            this.sub = str;
        } else {
            this.unsub = str;
        }
    }

    public void setFreqMs(int i11) {
        this.freqMs = i11;
    }

    public void setSub(boolean z11) {
        this.isSubscribe = z11;
    }

    public void setSubscribe(String str) {
        this.sub = str;
    }

    public void setUnsub(String str) {
        this.unsub = str;
    }

    public String toString() {
        this.f70674id = String.valueOf(System.currentTimeMillis() / 1000);
        return JSON.toJSONString((Object) this, new p[]{this.filter}, new SerializerFeature[0]);
    }

    public BaseSocketSub(boolean z11, String str) {
        this(z11, str, true);
    }

    public BaseSocketSub(boolean z11, boolean z12) {
        this(z11, (String) null, z12);
    }

    public BaseSocketSub(boolean z11, String str, boolean z12) {
        this.filter = a.f55031a;
        this.isSubscribe = z11;
        setFreqMs(z12 ? 5000 : 0);
        setChannel(str);
    }
}
