package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.dw;
import com.xiaomi.push.hc;
import java.util.Map;

public abstract class ab {
    public abstract long a(Context context, dw dwVar, Map<String, String> map);

    public abstract dw a(Context context, int i11, String str, Map<String, String> map);

    public abstract void a(hc hcVar, Map<String, String> map, int i11, Notification notification);

    public abstract void a(String str);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m2966a(Context context, int i11, String str, Map<String, String> map);

    public abstract boolean a(Map<String, String> map, int i11, Notification notification);
}
