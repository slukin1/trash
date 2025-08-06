package qt;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.trade.bean.OrderConfirmBean;
import com.huobi.tradenew.ui.TradeOrderConfirmFragment;
import com.huobi.utils.v0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public final class v {

    public class a extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f84720b;

        public a(FragmentActivity fragmentActivity) {
            this.f84720b = fragmentActivity;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            v0.e(this.f84720b, "94896387719534");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f84720b.getResources().getColor(R.color.baseColorMajorTheme100));
            textPaint.setUnderlineText(false);
        }
    }

    public static boolean d() {
        return !g.a().b();
    }

    public static /* synthetic */ void e(boolean[] zArr, boolean z11) {
        zArr[0] = z11;
    }

    public static /* synthetic */ void f(boolean[] zArr, DialogUtils.b.f fVar, HBDialogFragment hBDialogFragment) {
        if (!zArr[0]) {
            g.a().e(false);
            hBDialogFragment.dismiss();
        } else if (fVar != null) {
            fVar.a(hBDialogFragment);
        }
    }

    public static /* synthetic */ void g(DialogUtils.b.f fVar, HBDialogFragment hBDialogFragment) {
        g.a().e(false);
        if (fVar != null) {
            fVar.a(hBDialogFragment);
        }
        hBDialogFragment.dismiss();
    }

    public static boolean h() {
        if (ConfigPreferences.c("_READEDNOTICE_", "REMINDER_ORDER_CONFIRM_DIALOG_OLD_DATA_TRANS", false)) {
            return !ConfigPreferences.c("_READEDNOTICE_", "REMINDER_ORDER_SPOT_CONFIRM_DIALOG", false);
        }
        boolean z11 = !ConfigPreferences.c("_READEDNOTICE_", "REMINDER_ORDER_CONFIRM_DIALOG", false);
        ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_CONFIRM_DIALOG", !z11);
        ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_LOAN_CONFIRM_DIALOG", !z11);
        ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_CONFIRM_DIALOG_OLD_DATA_TRANS", true);
        return z11;
    }

    public static boolean i() {
        if (ConfigPreferences.c("_READEDNOTICE_", "REMINDER_ORDER_CONFIRM_DIALOG_OLD_DATA_TRANS", false)) {
            return !ConfigPreferences.c("_READEDNOTICE_", "REMINDER_ORDER_SPOT_LOAN_CONFIRM_DIALOG", false);
        }
        boolean z11 = !ConfigPreferences.c("_READEDNOTICE_", "REMINDER_ORDER_CONFIRM_DIALOG", false);
        ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_CONFIRM_DIALOG", !z11);
        ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_LOAN_CONFIRM_DIALOG", !z11);
        ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_CONFIRM_DIALOG_OLD_DATA_TRANS", true);
        return z11;
    }

    public static void j(FragmentManager fragmentManager, OrderConfirmBean orderConfirmBean, TradeOrderConfirmFragment.a aVar) {
        TradeOrderConfirmFragment uh2 = TradeOrderConfirmFragment.uh();
        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA", orderConfirmBean);
        uh2.setArguments(bundle);
        uh2.zh(aVar);
        uh2.show(fragmentManager, "TradeOrderConfirmFragment");
    }

    public static void k(FragmentActivity fragmentActivity, DialogUtils.b.f fVar, DialogUtils.b.f fVar2) {
        boolean[] zArr = {false};
        String string = fragmentActivity.getString(R.string.n_exchange_risk_agreement);
        String string2 = fragmentActivity.getString(R.string.n_exchange_risk_sign_agreement);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string2, new Object[]{string}));
        a aVar = new a(fragmentActivity);
        int indexOf = string2.indexOf("%s");
        spannableStringBuilder.setSpan(aVar, indexOf, string.length() + indexOf, 17);
        new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getString(R.string.n_trade_reminder_loan_title)).C0(fragmentActivity.getString(R.string.n_exchange_risk_operate_agreement)).P0(fragmentActivity.getString(R.string.n_sure)).s0(fragmentActivity.getString(R.string.n_trade_reminder_cancel)).w0(spannableStringBuilder).J0(zArr[0]).K0(R.drawable.selector_trade_spot_margin_check).t0(true).q0(true).x0(true).u0(true).v0(new s(zArr)).Q0(new u(zArr, fVar)).N0(new t(fVar2)).l0().show(fragmentActivity.getSupportFragmentManager(), "");
        g.a().e(true);
    }
}
