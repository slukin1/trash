package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.android.tpush.logging.TLogger;

public class c extends h {
    public c(Activity activity, d dVar, Intent intent) {
        super(activity, dVar, intent);
    }

    public RelativeLayout.LayoutParams b() {
        Point displaySize = SizeUtil.getDisplaySize(this.f69339b);
        int dipTopx = SizeUtil.dipTopx(this.f69339b, (float) this.f69389d.a());
        int dipTopx2 = SizeUtil.dipTopx(this.f69339b, (float) this.f69389d.b());
        TLogger.i("Center Popup", "size.x = " + displaySize.x + ", size.y =" + displaySize.y + "width = " + dipTopx + ", height =" + dipTopx2);
        int i11 = displaySize.x;
        int i12 = SizeUtil.dp20;
        int i13 = i11 - i12;
        int i14 = displaySize.y - i12;
        double d11 = (double) dipTopx;
        double d12 = d11 / ((double) dipTopx2);
        if (dipTopx > i13 && ((int) (d11 / d12)) < i14) {
            dipTopx2 = (int) (((double) i13) / d12);
            dipTopx = i13;
        }
        if (dipTopx2 <= i14 || ((int) (((double) dipTopx2) * d12)) >= i13) {
            i14 = dipTopx2;
        } else {
            dipTopx = (int) (((double) i14) * d12);
        }
        TLogger.i("Center Popup", "InAppMsg LayoutParams width = " + dipTopx + ", height = " + i14);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipTopx, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    public boolean d() {
        return false;
    }

    public void e() {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(2);
            if (Build.VERSION.SDK_INT >= 14) {
                window.setDimAmount(0.7f);
            }
        }
    }
}
