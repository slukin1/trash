package com.hbg.lite.wallet.viewhandler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.search.ui.LiteCurrencyChooseActivity;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import g6.b;
import i6.m;
import i6.r;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import s9.c;
import wa.a;

public class BalanceInfoFirstViewHandler implements c {
    public static /* synthetic */ void e(Context context, Void voidR) {
        ra.c.c().l("185", (Map<String, Object>) null);
        LiteCurrencyChooseActivity.vh(context);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, LegalDetailInfo legalDetailInfo, ViewGroup viewGroup) {
        int i12;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        ConstraintLayout constraintLayout = (ConstraintLayout) e11.b(R$id.cl_wallet_first);
        if (ConfigPreferences.c("user_config", "LITE_ASSETS_HINT", true)) {
            i12 = R$drawable.shape_wallet_first_item_rect_bg;
        } else {
            i12 = R$drawable.shape_wallet_first_item_bg;
        }
        constraintLayout.setBackgroundResource(i12);
        TextView textView = (TextView) e11.b(R$id.currency_zh_name_iv);
        TextView textView2 = (TextView) e11.b(R$id.currency_balance_amount_tv);
        TextView textView3 = (TextView) e11.b(R$id.currency_balance_convert_tv);
        View b11 = e11.b(R$id.buy_more_ll);
        b.c().i((ImageView) e11.b(R$id.currency_icon_iv), legalDetailInfo.getLogo(), R$drawable.shape_logo_default_bg);
        ((TextView) e11.b(R$id.currency_name_tv)).setText(legalDetailInfo.getCurrency().toUpperCase());
        String fullName = va.b.s(legalDetailInfo.getCoinId()).getFullName();
        String string = context.getString(R$string.two_label_with_space);
        Object[] objArr = new Object[2];
        if (TextUtils.isEmpty(fullName)) {
            fullName = "";
        }
        objArr[0] = fullName;
        objArr[1] = context.getString(R$string.lite_currency_usdt_hint);
        textView.setText(String.format(string, objArr));
        if (legalDetailInfo.isShow()) {
            textView2.setText(m.u0(m.a(legalDetailInfo.getAvailable()).add(m.a(legalDetailInfo.getOnOrders())).toPlainString(), 12, a.a(legalDetailInfo.getCoinId())));
            textView3.setText(String.format(context.getString(R$string.two_label_with_space_with_space_abount), new Object[]{va.b.n(sa.a.c()), ra.c.c().v(m.a(legalDetailInfo.getEstimateAmountToLegal()))}));
        } else {
            int i13 = R$string.balance_hide_star;
            textView2.setText(context.getString(i13));
            textView3.setText(context.getString(i13));
        }
        Observable<Void> a11 = dw.a.a(b11);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new vb.a(context));
        dw.a.a(cVar.itemView).throttleFirst(300, timeUnit).subscribe(new vb.b(context, legalDetailInfo));
    }

    public int getResId() {
        return R$layout.item_lite_wallet_first;
    }
}
