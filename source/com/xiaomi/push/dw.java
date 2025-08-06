package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

@SuppressLint({"NewApi"})
public class dw extends Notification.Builder {

    /* renamed from: a  reason: collision with root package name */
    private Context f51665a;

    public dw(Context context) {
        super(context);
        this.f51665a = context;
    }

    public Context a() {
        return this.f51665a;
    }

    public dw a(Map<String, String> map) {
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2617a() {
    }

    public Notification build() {
        a();
        return super.build();
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return 0;
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    /* renamed from: a */
    public dw addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    /* renamed from: a */
    public dw setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dw m2616a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ax.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e11) {
                b.d("fail to set color. " + e11);
            }
        }
        return this;
    }
}
