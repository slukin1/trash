package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
public class XGSysNotifaction {

    /* renamed from: a  reason: collision with root package name */
    private int f68089a;

    /* renamed from: b  reason: collision with root package name */
    private Notification f68090b;

    /* renamed from: c  reason: collision with root package name */
    private String f68091c;

    /* renamed from: d  reason: collision with root package name */
    private Intent f68092d;

    /* renamed from: e  reason: collision with root package name */
    private int f68093e;

    /* renamed from: f  reason: collision with root package name */
    private Object f68094f;

    public XGSysNotifaction(String str, int i11, Notification notification, Intent intent, int i12, Object obj) {
        this.f68091c = str;
        this.f68089a = i11;
        this.f68090b = notification;
        this.f68092d = intent;
        this.f68093e = i12;
        this.f68094f = obj;
    }

    public String getAppPkg() {
        return this.f68091c;
    }

    public Notification getNotifaction() {
        return this.f68090b;
    }

    public Object getNotificationChannle() {
        return this.f68094f;
    }

    public int getNotifyId() {
        return this.f68089a;
    }

    public Intent getPendintIntent() {
        return this.f68092d;
    }

    public int getPendintIntentFlag() {
        return this.f68093e;
    }
}
