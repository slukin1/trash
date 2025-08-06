package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huobi.view.roundimg.RoundedDrawable;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

public class dv extends dy {

    /* renamed from: a  reason: collision with root package name */
    private int f51662a = 16777216;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f51663b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f51664c;

    public dv(Context context, String str) {
        super(context, str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public dy m2613a(Bitmap bitmap) {
        return this;
    }

    public String a() {
        return "notification_banner";
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2615a() {
        if (!j.a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a11 = a(a().getResources(), "bg", "id", a().getPackageName());
        int a12 = a(resources, "icon", "id", packageName);
        int a13 = a(resources, "title", "id", packageName);
        if (a11 == 0 || a12 == 0 || a13 == 0 || j.a(a()) < 9) {
            return false;
        }
        return true;
    }

    public dv b(Bitmap bitmap) {
        if (b() && bitmap != null) {
            this.f51664c = bitmap;
        }
        return this;
    }

    public String b() {
        return null;
    }

    /* renamed from: a */
    public dv setLargeIcon(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                b.a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.f51663b = bitmap;
            }
        }
        return this;
    }

    public dv a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.f51662a = Color.parseColor(str);
            } catch (Exception unused) {
                b.a("parse banner notification image text color error");
            }
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2614a() {
        if (!b() || this.f51663b == null) {
            b();
            return;
        }
        super.a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a11 = a(resources, "bg", "id", packageName);
        if (j.a(a()) >= 10) {
            a().setImageViewBitmap(a11, a(this.f51663b, 30.0f));
        } else {
            a().setImageViewBitmap(a11, this.f51663b);
        }
        int a12 = a(resources, "icon", "id", packageName);
        if (this.f51664c != null) {
            a().setImageViewBitmap(a12, this.f51664c);
        } else {
            a(a12);
        }
        int a13 = a(resources, "title", "id", packageName);
        a().setTextViewText(a13, this.f2754a);
        Map<String, String> map = this.f2757a;
        if (map != null && this.f51662a == 16777216) {
            a(map.get("notification_image_text_color"));
        }
        RemoteViews a14 = a();
        int i11 = this.f51662a;
        a14.setTextColor(a13, (i11 == 16777216 || !a(i11)) ? -1 : RoundedDrawable.DEFAULT_BORDER_COLOR);
        setCustomContentView(a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }
}
