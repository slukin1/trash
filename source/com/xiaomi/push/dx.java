package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huobi.view.roundimg.RoundedDrawable;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.x;
import java.util.Map;

public class dx extends dy {

    /* renamed from: a  reason: collision with root package name */
    private int f51666a = 16777216;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f2749a;

    /* renamed from: b  reason: collision with root package name */
    private int f51667b = 16777216;

    /* renamed from: b  reason: collision with other field name */
    private Bitmap f2750b;

    /* renamed from: c  reason: collision with root package name */
    private int f51668c = 16777216;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f2751c;

    public dx(Context context, int i11, String str) {
        super(context, i11, str);
    }

    public String a() {
        return "notification_colorful";
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2619a() {
        if (!j.a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a11 = a(resources, "icon", "id", packageName);
        int a12 = a(resources, "title", "id", packageName);
        int a13 = a(resources, "content", "id", packageName);
        if (a11 == 0 || a12 == 0 || a13 == 0) {
            return false;
        }
        return true;
    }

    public dx b(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f51666a = Color.parseColor(str);
            } catch (Exception unused) {
                b.a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    public String b() {
        return "notification_colorful_copy";
    }

    public dx c(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f51668c = Color.parseColor(str);
            } catch (Exception unused) {
                b.a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    public dx a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f2751c = charSequence;
            this.f2749a = pendingIntent;
        }
        return this;
    }

    public dx a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f51667b = Color.parseColor(str);
            } catch (Exception unused) {
                b.a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    public dx a(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                b.a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f2750b = bitmap;
            }
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2618a() {
        if (b()) {
            super.a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a11 = a(resources, "icon", "id", packageName);
            if (this.f2752a == null) {
                a(a11);
            } else {
                a().setImageViewBitmap(a11, this.f2752a);
            }
            int a12 = a(resources, "title", "id", packageName);
            int a13 = a(resources, "content", "id", packageName);
            a().setTextViewText(a12, this.f2754a);
            a().setTextViewText(a13, this.f2759b);
            if (!TextUtils.isEmpty(this.f2751c)) {
                int a14 = a(resources, "buttonContainer", "id", packageName);
                int a15 = a(resources, "button", "id", packageName);
                int a16 = a(resources, "buttonBg", "id", packageName);
                a().setViewVisibility(a14, 0);
                a().setTextViewText(a15, this.f2751c);
                a().setOnClickPendingIntent(a14, this.f2749a);
                if (this.f51667b != 16777216) {
                    int a17 = a(70.0f);
                    int a18 = a(29.0f);
                    a().setImageViewBitmap(a16, x.a(a(this.f51667b, a17, a18, ((float) a18) / 2.0f)));
                    a().setTextColor(a15, a(this.f51667b) ? -1 : RoundedDrawable.DEFAULT_BORDER_COLOR);
                }
            }
            int a19 = a(resources, "bg", "id", packageName);
            int a21 = a(resources, TtmlNode.RUBY_CONTAINER, "id", packageName);
            if (this.f51666a != 16777216) {
                if (j.a(a()) >= 10) {
                    a().setImageViewBitmap(a19, x.a(a(this.f51666a, 984, 192, 30.0f)));
                } else {
                    a().setImageViewBitmap(a19, x.a(a(this.f51666a, 984, 192, 0.0f)));
                }
                a(a(), a21, a12, a13, a(this.f51666a));
            } else if (this.f2750b != null) {
                if (j.a(a()) >= 10) {
                    a().setImageViewBitmap(a19, a(this.f2750b, 30.0f));
                } else {
                    a().setImageViewBitmap(a19, this.f2750b);
                }
                Map<String, String> map = this.f2757a;
                if (map != null && this.f51668c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i11 = this.f51668c;
                a(a(), a21, a12, a13, i11 == 16777216 || !a(i11));
            } else if (Build.VERSION.SDK_INT >= 24) {
                a().setViewVisibility(a11, 8);
                a().setViewVisibility(a19, 8);
                try {
                    ax.a((Object) this, "setStyle", s.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    b.a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(a());
            return;
        }
        b();
    }

    private void a(RemoteViews remoteViews, int i11, int i12, int i13, boolean z11) {
        int a11 = a(6.0f);
        remoteViews.setViewPadding(i11, a11, 0, a11, 0);
        if (z11) {
            remoteViews.setTextColor(i12, -1);
            remoteViews.setTextColor(i13, -1);
            return;
        }
        remoteViews.setTextColor(i12, RoundedDrawable.DEFAULT_BORDER_COLOR);
        remoteViews.setTextColor(i13, RoundedDrawable.DEFAULT_BORDER_COLOR);
    }

    private Drawable a(int i11, int i12, int i13, float f11) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f11, f11, f11, f11, f11, f11, f11, f11}, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(i11);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i12);
        shapeDrawable.setIntrinsicHeight(i13);
        return shapeDrawable;
    }
}
