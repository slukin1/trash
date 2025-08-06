package ee;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$drawable;

public final class a {
    public static void a(FragmentActivity fragmentActivity, int i11, String str, String str2, String str3, String str4, String str5, DialogUtils.b.f fVar, DialogUtils.b.f fVar2) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        DialogUtils.b.d dVar = new DialogUtils.b.d(fragmentActivity);
        if (i11 == 0) {
            i12 = R$drawable.bg_dialog_candle_light;
        } else {
            i12 = R$drawable.bg_dialog_candle_night;
        }
        DialogUtils.b.d c12 = dVar.L0(Integer.valueOf(i12)).c1(str);
        if (i11 == 0) {
            i13 = fragmentActivity.getResources().getColor(R$color.color_14181F);
        } else {
            i13 = fragmentActivity.getResources().getColor(R$color.color_E6E6E6);
        }
        DialogUtils.b.d C0 = c12.e1(Integer.valueOf(i13)).h1(Float.valueOf(PixelUtils.b(20.0f))).C0(str2);
        if (i11 == 0) {
            i14 = fragmentActivity.getResources().getColor(R$color.color_14181F);
        } else {
            i14 = fragmentActivity.getResources().getColor(R$color.color_E6E6E6);
        }
        DialogUtils.b.d q02 = C0.D0(Integer.valueOf(i14)).H0(Float.valueOf(PixelUtils.b(16.0f))).R0(str3).T0(!TextUtils.isEmpty(str3)).P0(str5).s0(str4).q0(!TextUtils.isEmpty(str4));
        if (i11 == 0) {
            i15 = fragmentActivity.getResources().getColor(R$color.color_14181F);
        } else {
            i15 = fragmentActivity.getResources().getColor(R$color.color_E6E6E6);
        }
        DialogUtils.b.d r02 = q02.r0(Integer.valueOf(i15));
        if (i11 == 0) {
            i16 = R$drawable.selector_candle_cancel_btn_light;
        } else {
            i16 = R$drawable.selector_candle_cancel_btn_night;
        }
        r02.p0(Integer.valueOf(i16)).Q0(fVar2).N0(fVar).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }
}
