package nb;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.hbg.lite.trade.ui.LiteOtcTradeSettingActivity;
import dw.a;
import i6.m;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class c {
    public static String b(String str, int i11) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.CHINA);
        numberInstance.setRoundingMode(RoundingMode.FLOOR);
        if (i11 >= 0) {
            numberInstance.setMaximumFractionDigits(i11);
            numberInstance.setMinimumFractionDigits(i11);
        }
        return numberInstance.format(m.a(str));
    }

    public static String c(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        try {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.CHINA);
            numberInstance.setRoundingMode(RoundingMode.FLOOR);
            numberInstance.setMaximumFractionDigits(i11);
            return numberInstance.format(m.a(str).stripTrailingZeros());
        } catch (NumberFormatException unused) {
            return "0";
        }
    }

    public static String d(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        try {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.CHINA);
            numberInstance.setRoundingMode(RoundingMode.FLOOR);
            numberInstance.setGroupingUsed(false);
            numberInstance.setMaximumFractionDigits(i11);
            return numberInstance.format(m.a(str));
        } catch (NumberFormatException unused) {
            return "0";
        }
    }

    public static /* synthetic */ void e(View.OnClickListener onClickListener, View view, Void voidR) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static void f(Activity activity, String str, String str2, boolean z11) {
    }

    public static void g(Activity activity, String str, String str2, boolean z11) {
    }

    public static void h(Activity activity, boolean z11, boolean z12) {
        i(activity, z11, z12, false);
    }

    public static void i(Activity activity, boolean z11, boolean z12, boolean z13) {
        if (!ra.c.c().p()) {
            ra.c.b().e(activity, (Intent) null, (Intent) null);
        } else {
            ra.c.b().i(activity, z11, z12, z13);
        }
    }

    public static void j(Activity activity, boolean z11) {
        Class<LiteOtcTradeSettingActivity> cls = LiteOtcTradeSettingActivity.class;
        if (z11) {
            activity.startActivityForResult(new Intent(activity, cls), 4658);
        } else {
            activity.startActivity(new Intent(activity, cls));
        }
    }

    public static void k(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new b(onClickListener, view));
        }
    }
}
