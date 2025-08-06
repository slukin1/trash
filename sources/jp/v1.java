package jp;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lite.enums.OtcTradeMode;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;

public final class v1 {

    /* renamed from: b  reason: collision with root package name */
    public static final v1 f84395b = new v1();

    /* renamed from: a  reason: collision with root package name */
    public int f84396a = 0;

    public static v1 a() {
        return f84395b;
    }

    public static int b() {
        return ContextCompat.getColor(BaseApplication.b(), R$color.baseColorMajorTheme100);
    }

    public static OtcTradeMode c(int i11) {
        if (i11 == 0) {
            return OtcTradeMode.C2C_BRAND;
        }
        return OtcTradeMode.C2C_SIMPLE;
    }

    public static void d(TextView textView) {
        if (textView != null) {
            textView.setTextColor(b());
        }
    }

    public void e(Context context, String str, int i11) {
        OtcModuleConfig.a().d0(context, str, String.valueOf(i11), "");
    }

    public void f(Context context, String str) {
        OtcModuleConfig.a().F(context, str, false);
    }

    public void g(Context context, String str, boolean z11) {
        OtcModuleConfig.a().F(context, str, z11);
    }
}
