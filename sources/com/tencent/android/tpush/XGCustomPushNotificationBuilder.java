package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.RemoteViews;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class XGCustomPushNotificationBuilder extends XGPushNotificationBuilder {
    private Integer F = null;
    private Integer G = null;
    private Integer H = null;
    private Integer I = null;
    private Integer J = null;
    private Integer K = null;
    private Integer L = null;
    private Bitmap M = null;

    public void a(JSONObject jSONObject) {
        CommonHelper.jsonPut(jSONObject, "layoutId", this.F);
        CommonHelper.jsonPut(jSONObject, "layoutIconId", this.G);
        CommonHelper.jsonPut(jSONObject, "layoutTitleId", this.H);
        CommonHelper.jsonPut(jSONObject, "layoutTextId", this.I);
        CommonHelper.jsonPut(jSONObject, "layoutIconDrawableId", this.J);
        CommonHelper.jsonPut(jSONObject, "statusBarIconDrawableId", this.K);
        CommonHelper.jsonPut(jSONObject, "layoutTimeId", this.L);
    }

    public void b(JSONObject jSONObject) {
        this.F = (Integer) CommonHelper.jsonGet(jSONObject, "layoutId", (Object) null);
        this.G = (Integer) CommonHelper.jsonGet(jSONObject, "layoutIconId", (Object) null);
        this.H = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTitleId", (Object) null);
        this.I = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTextId", (Object) null);
        this.J = (Integer) CommonHelper.jsonGet(jSONObject, "layoutIconDrawableId", (Object) null);
        this.K = (Integer) CommonHelper.jsonGet(jSONObject, "statusBarIconDrawableId", (Object) null);
        this.L = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTimeId", (Object) null);
    }

    public Pair<Notification, Object> buildNotification(Context context) {
        if (this.F == null) {
            return a(context);
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), this.F.intValue());
        Integer num = this.H;
        if (num != null) {
            remoteViews.setTextViewText(num.intValue(), getTitle(context));
        }
        Integer num2 = this.I;
        if (num2 != null) {
            remoteViews.setTextViewText(num2.intValue(), this.f68044s);
        }
        Integer num3 = this.G;
        if (num3 != null) {
            remoteViews.setImageViewResource(num3.intValue(), this.J.intValue());
            if (this.M != null) {
                remoteViews.setImageViewBitmap(this.G.intValue(), this.M);
            }
        }
        Integer num4 = this.K;
        if (num4 != null) {
            remoteViews.setTextViewText(num4.intValue(), getTitle(context));
        }
        if (this.L != null) {
            remoteViews.setTextViewText(this.L.intValue(), String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis()))));
        }
        this.f68030e = remoteViews;
        return a(context);
    }

    public int getLayoutIconDrawableId() {
        return this.J.intValue();
    }

    public Integer getLayoutIconId() {
        return this.G;
    }

    public int getLayoutId() {
        return this.F.intValue();
    }

    public int getLayoutTextId() {
        return this.I.intValue();
    }

    public int getLayoutTimeId() {
        return this.L.intValue();
    }

    public int getLayoutTitleId() {
        return this.H.intValue();
    }

    public String getType() {
        return "custom";
    }

    public XGCustomPushNotificationBuilder setLayoutIconDrawableBmp(Bitmap bitmap) {
        this.M = bitmap;
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutIconDrawableId(int i11) {
        this.J = Integer.valueOf(i11);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutIconId(int i11) {
        this.G = Integer.valueOf(i11);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutId(int i11) {
        this.F = Integer.valueOf(i11);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutTextId(int i11) {
        this.I = Integer.valueOf(i11);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutTimeId(int i11) {
        this.L = Integer.valueOf(i11);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutTitleId(int i11) {
        this.H = Integer.valueOf(i11);
        return this;
    }
}
