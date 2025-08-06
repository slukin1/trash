package com.huobi.feature.util;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Locale;
import oa.a;
import pro.huobi.R;
import qk.r;
import qk.s;

public final class FutureOrderErrorHelper {
    public static void c(String str, boolean z11) {
        String str2;
        if (TextUtils.isEmpty(str) || !str.contains(";")) {
            HuobiToastUtil.l(BaseApplication.b(), str);
            return;
        }
        String[] split = str.split(";");
        if (!(a.g().b() instanceof FragmentActivity)) {
            if (z11) {
                str2 = String.format(Locale.US, a.g().b().getString(R.string.n_exceed_single_user_long_position_limit_tips), new Object[]{split[0]});
            } else {
                str2 = String.format(Locale.US, a.g().b().getString(R.string.n_exceed_single_user_short_position_limit_tips), new Object[]{split[0]});
            }
            HuobiToastUtil.l(BaseApplication.b(), str2);
            return;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) a.g().b();
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R.layout.dialog_swap_order_error_1900, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_sub_title);
        if (z11) {
            textView.setText(String.format(Locale.US, fragmentActivity.getString(R.string.n_exceed_single_user_long_position_limit_tips), new Object[]{split[0]}));
        } else {
            textView.setText(String.format(Locale.US, fragmentActivity.getString(R.string.n_exceed_single_user_short_position_limit_tips), new Object[]{split[0]}));
        }
        ((TextView) inflate.findViewById(R.id.dialog_link)).setOnClickListener(new r(split, DialogUtils.a0(fragmentActivity, fragmentActivity.getString(R.string.n_all_cancel_title), inflate, fragmentActivity.getResources().getString(R.string.n_copy_trading_i_got_it), s.f59994a)));
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e(String[] strArr, DialogFragment dialogFragment, View view) {
        zn.a.d().v(Uri.parse(strArr[1])).a().c();
        dialogFragment.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
