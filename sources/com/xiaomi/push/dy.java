package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.af;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class dy extends dw {

    /* renamed from: a  reason: collision with root package name */
    private int f51669a;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f2752a;

    /* renamed from: a  reason: collision with other field name */
    private RemoteViews f2753a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f2754a;

    /* renamed from: a  reason: collision with other field name */
    private String f2755a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<Notification.Action> f2756a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f2757a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2758a;

    /* renamed from: b  reason: collision with root package name */
    private int f51670b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f2759b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2760b;

    public dy(Context context, String str) {
        this(context, 0, str);
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m2621c() {
        Map<String, String> map = this.f2757a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f2754a);
        super.setContentText(this.f2759b);
    }

    private boolean e() {
        return d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> b11;
        if (Build.VERSION.SDK_INT >= 20 && (b11 = af.a(a(), this.f2755a).b()) != null && !b11.isEmpty()) {
            for (StatusBarNotification statusBarNotification : b11) {
                if (statusBarNotification.getId() == this.f51669a) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public dy setContentTitle(CharSequence charSequence) {
        this.f2754a = charSequence;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m2624a();

    public void a(int i11, Notification.Action action) {
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m2626a();

    /* renamed from: b */
    public dy setContentText(CharSequence charSequence) {
        this.f2759b = charSequence;
        return this;
    }

    public abstract String b();

    public dy(Context context, int i11, String str) {
        super(context);
        this.f2756a = new ArrayList<>();
        this.f51670b = 0;
        this.f2755a = str;
        this.f51669a = i11;
        c();
    }

    /* renamed from: a */
    public dy setLargeIcon(Bitmap bitmap) {
        this.f2752a = bitmap;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m2628b() {
        super.setContentTitle(this.f2754a);
        super.setContentText(this.f2759b);
        Bitmap bitmap = this.f2752a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m2622d() {
        return !TextUtils.isEmpty(b()) && !TextUtils.isEmpty(this.f2755a);
    }

    public dw a(Map<String, String> map) {
        this.f2757a = map;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m2620c() {
        int a11 = a(a().getResources(), c(), TtmlNode.TAG_LAYOUT, a().getPackageName());
        if (a11 != 0) {
            this.f2753a = new RemoteViews(a().getPackageName(), a11);
            this.f2758a = a();
            return;
        }
        b.a("create RemoteViews failed, no such layout resource was found");
    }

    /* renamed from: a */
    public dy addAction(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i11, charSequence, pendingIntent));
        return this;
    }

    /* renamed from: a */
    public dy addAction(Notification.Action action) {
        if (action != null) {
            this.f2756a.add(action);
        }
        int i11 = this.f51670b;
        this.f51670b = i11 + 1;
        a(i11, action);
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m2629b() {
        return this.f2758a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2625a() {
        super.a();
        Bundle bundle = new Bundle();
        if (d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f2760b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f2756a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f2756a.size()];
            this.f2756a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (c() || !ag.a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f2754a);
            bundle.putCharSequence("mipush.customContent", this.f2759b);
        }
        addExtras(bundle);
    }

    private String c() {
        boolean e11 = e();
        this.f2760b = e11;
        return e11 ? b() : a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public final RemoteViews m2623a() {
        return this.f2753a;
    }

    public void a(int i11) {
        Bitmap a11 = a();
        if (a11 != null) {
            a().setImageViewBitmap(i11, a11);
            return;
        }
        int b11 = g.b(a(), this.f2755a);
        if (b11 != 0) {
            a().setImageViewResource(i11, b11);
        }
    }

    private Bitmap a() {
        return x.a(g.a(a(), this.f2755a));
    }

    public int a(float f11) {
        return (int) ((f11 * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public Bitmap a(Bitmap bitmap, float f11) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f11, f11, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m2627a(int i11) {
        return ((((double) Color.red(i11)) * 0.299d) + (((double) Color.green(i11)) * 0.587d)) + (((double) Color.blue(i11)) * 0.114d) < 192.0d;
    }
}
