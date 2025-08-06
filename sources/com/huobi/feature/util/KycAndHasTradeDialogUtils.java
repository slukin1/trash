package com.huobi.feature.util;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.utils.KycLimitCodeUtils;
import com.huobi.coupon.bean.Coupon;
import pro.huobi.R;
import qk.p0;
import qk.q0;
import qk.r0;
import qk.s0;
import qk.t0;
import sn.f;

public final class KycAndHasTradeDialogUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f45172a = false;

    public static /* synthetic */ void f(DialogUtils.b.f fVar, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        fVar.a(hBDialogFragment);
    }

    public static /* synthetic */ void g(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        KycLimitCodeUtils.c();
    }

    public static /* synthetic */ void h(Context context, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        KycLimitCodeUtils.c();
        o(context);
    }

    public static /* synthetic */ void i(DialogUtils.b.f fVar, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        fVar.a(hBDialogFragment);
    }

    public static /* synthetic */ void j(DialogUtils.b.f fVar, Context context, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        fVar.a(hBDialogFragment);
        o(context);
    }

    public static void k(boolean z11) {
        f45172a = z11;
    }

    public static void l(Context context, String str, DialogUtils.b.f fVar) {
        if (context instanceof FragmentActivity) {
            DialogUtils.Y((FragmentActivity) context, str, "", context.getString(R.string.n_known), new r0(fVar));
        }
    }

    public static void m(Context context) {
        if (context instanceof FragmentActivity) {
            DialogUtils.c0((FragmentActivity) context, context.getString(R.string.n_contract_kyc_not_varify_new_tip), "", context.getString(R.string.n_known), context.getString(R.string.go_to_authenticate), t0.f59997a, new p0(context));
        }
    }

    public static void n(Context context, String str, DialogUtils.b.f fVar) {
        if (context instanceof FragmentActivity) {
            DialogUtils.c0((FragmentActivity) context, str, "", context.getString(R.string.n_known), context.getString(R.string.go_to_authenticate), new q0(fVar), new s0(fVar, context));
        }
    }

    public static void o(Context context) {
        context.startActivity(f.q(context, Coupon.SPOT, "1"));
    }
}
