package com.huobi.c2c.util;

import ad.b;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import c6.a;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.a;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.d1;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.k;
import java.util.HashMap;
import java.util.Objects;
import nb.c;
import pro.huobi.R;
import q6.d;
import tg.r;
import tq.p;
import u6.g;

public final class C2CDialogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43017a;

    /* renamed from: b  reason: collision with root package name */
    public static HBDialogFragment f43018b;

    public static boolean i(FragmentActivity fragmentActivity, a aVar) {
        if (f43017a || "1".equals(ConfigPreferences.d("user_config", "SP_KEY_C2C_LEND_AUTO_ORDER_TIPS"))) {
            return false;
        }
        DialogUtils.b.d dVar = new DialogUtils.b.d(fragmentActivity);
        dVar.c1(fragmentActivity.getString(R.string.n_c2c_lend_out_auto_renew));
        dVar.C0(fragmentActivity.getString(R.string.n_c2c_lend_out_auto_renew_desc));
        dVar.q0(false);
        dVar.x0(true);
        dVar.y0(fragmentActivity.getString(R.string.contract_trigger_order_change_not_show));
        dVar.v0(g.f43024a);
        dVar.P0(fragmentActivity.getString(R.string.n_known));
        dVar.Q0(new j(aVar));
        dVar.k0().show(fragmentActivity.getSupportFragmentManager(), "");
        return true;
    }

    public static void j() {
        HBDialogFragment hBDialogFragment = f43018b;
        if (hBDialogFragment != null && hBDialogFragment.th()) {
            f43018b.dismiss();
        }
    }

    public static /* synthetic */ void k(boolean z11) {
        f43017a = z11;
        if (z11) {
            ConfigPreferences.m("user_config", "SP_KEY_C2C_LEND_AUTO_ORDER_TIPS", "1");
        } else {
            ConfigPreferences.m("user_config", "SP_KEY_C2C_LEND_AUTO_ORDER_TIPS", "0");
        }
        String d11 = ConfigPreferences.d("user_config", "SP_KEY_C2C_LEND_AUTO_ORDER_TIPS");
        k.c("checkToShowAutoOrderTipsDialog--> isChecked=" + f43017a + " result=" + d11);
    }

    public static /* synthetic */ void l(a aVar, HBDialogFragment hBDialogFragment) {
        if (aVar != null) {
            aVar.a();
        }
        hBDialogFragment.dismiss();
    }

    public static /* synthetic */ void m(int i11, FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        if (r.x().U()) {
            c.h(fragmentActivity, z11, false);
        } else if (z11) {
            x(fragmentActivity);
        } else {
            KycProBaseInformationActivity.Vh(fragmentActivity, (String) null);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void n(Context context, View view) {
        HBBaseWebActivity.showWebView(context, d1.a(), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(Context context, View view) {
        HBBaseWebActivity.showWebView(context, d1.c(), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void p(HBDialogFragment hBDialogFragment, Object obj) {
        n.c().d((RequestCallback1) null);
        i b11 = i.b();
        Objects.requireNonNull(hBDialogFragment);
        b11.g(new k(hBDialogFragment), 10);
    }

    public static /* synthetic */ void q(g gVar, HBDialogFragment hBDialogFragment) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "C2C");
        UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(d.c(gVar, new l(hBDialogFragment)));
    }

    public static /* synthetic */ void r(FragmentActivity fragmentActivity, String str, HBDialogFragment hBDialogFragment) {
        ((ClipboardManager) fragmentActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
        HuobiToastUtil.t(fragmentActivity, R.string.currency_deposit_copied);
    }

    public static void s(final Context context, SpannableStringBuilder spannableStringBuilder, String str, final View.OnClickListener onClickListener) {
        int indexOf = spannableStringBuilder.toString().indexOf(str);
        if (indexOf > 0 && str.length() + indexOf <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    View.OnClickListener onClickListener = onClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ContextCompat.getColor(context, R.color.baseColorMajorTheme100));
                    textPaint.setUnderlineText(false);
                }
            }, indexOf, str.length() + indexOf, 17);
        }
    }

    public static void t(FragmentActivity fragmentActivity, int i11) {
        DialogUtils.b0(fragmentActivity, fragmentActivity.getString(R.string.lite_market_info_price_notice_title), fragmentActivity.getString(R.string.c_to_c_license_tips_high_verify), "", fragmentActivity.getString(R.string.security_google_cancel), fragmentActivity.getString(R.string.go_to_authenticate), b.f3517a, new h(i11, fragmentActivity));
    }

    public static void u(FragmentActivity fragmentActivity) {
        DialogUtils.X(fragmentActivity, fragmentActivity.getString(R.string.c_to_c_important_tips), fragmentActivity.getString(R.string.c_to_c_license_tips_user_info), "", fragmentActivity.getString(R.string.string_confirm), b.f3517a);
    }

    public static void v(Context context, g gVar, DialogInterface.OnDismissListener onDismissListener) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getString(R.string.c_to_c_open_checkbox_hint));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.baseColorPrimaryText)), 0, spannableStringBuilder.length(), 17);
        s(context, spannableStringBuilder, context.getString(R.string.c_to_c_open_checkbox_agreement), new d(context));
        s(context, spannableStringBuilder, context.getString(R.string.c_to_c_open_checkbox_clause), new e(context));
        HBDialogFragment A = new a.b(context).G(context.getString(R.string.c_to_c_open_title)).E(context.getString(R.string.c_to_c_open_content)).C(true).B(false).F(new f(gVar)).D(spannableStringBuilder).A();
        f43018b = A;
        A.wh(onDismissListener);
        f43018b.show(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), "");
    }

    public static void w(FragmentActivity fragmentActivity) {
        DialogUtils.X(fragmentActivity, fragmentActivity.getString(R.string.c_to_c_important_tips), fragmentActivity.getString(R.string.c_to_c_error_tips_dont_pay_back), "", fragmentActivity.getString(R.string.allow_access_dialog_positive_btn), b.f3517a);
    }

    public static void x(FragmentActivity fragmentActivity) {
        String e11 = o.e();
        new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getResources().getString(R.string.advance_identification_to_pc)).C0(e11).D0(Integer.valueOf(ContextCompat.getColor(fragmentActivity, R.color.global_jump_btn_color))).i1(1).M0(Integer.valueOf(R.drawable.otc_tips_toweb)).P0(fragmentActivity.getResources().getString(R.string.advance_identification_to_pc_url_copy)).Q0(new i(fragmentActivity, e11)).N0(b.f3517a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }
}
