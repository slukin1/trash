package com.tencent.android.tpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.message.d;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
public class XGNotifaction {

    /* renamed from: a  reason: collision with root package name */
    private int f67810a = 0;

    /* renamed from: b  reason: collision with root package name */
    private Notification f67811b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f67812c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f67813d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f67814e = null;

    /* renamed from: f  reason: collision with root package name */
    private Context f67815f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f67816g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f67817h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f67818i = null;

    public XGNotifaction(Context context, int i11, Notification notification, d dVar) {
        if (dVar != null) {
            this.f67815f = context.getApplicationContext();
            this.f67810a = i11;
            this.f67811b = notification;
            this.f67812c = dVar.d();
            this.f67813d = dVar.e();
            this.f67814e = dVar.f();
            this.f67816g = dVar.l().f69462d;
            this.f67817h = dVar.l().f69464f;
            this.f67818i = dVar.l().f69460b;
        }
    }

    public boolean doNotify() {
        Context context;
        NotificationManager notificationManager;
        if (this.f67811b == null || (context = this.f67815f) == null || (notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)) == null) {
            return false;
        }
        int i11 = this.f67810a;
        Notification notification = this.f67811b;
        notificationManager.notify(i11, notification);
        PushAutoTrackHelper.onNotify(notificationManager, i11, notification);
        return true;
    }

    public String getContent() {
        return this.f67813d;
    }

    public String getCustomContent() {
        return this.f67814e;
    }

    public Notification getNotifaction() {
        return this.f67811b;
    }

    public int getNotifyId() {
        return this.f67810a;
    }

    public String getTargetActivity() {
        return this.f67818i;
    }

    public String getTargetIntent() {
        return this.f67816g;
    }

    public String getTargetUrl() {
        return this.f67817h;
    }

    public String getTitle() {
        return this.f67812c;
    }

    public void setNotifyId(int i11) {
        this.f67810a = i11;
    }

    public String toString() {
        return "XGNotifaction [notifyId=" + this.f67810a + ", title=" + this.f67812c + ", content=" + this.f67813d + ", customContent=" + this.f67814e + "]";
    }
}
