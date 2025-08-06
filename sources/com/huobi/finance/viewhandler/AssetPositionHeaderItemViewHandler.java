package com.huobi.finance.viewhandler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bl.b0;
import bl.c0;
import bl.d0;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset2.index.util.b;
import com.huobi.view.FontIconTextView;
import i6.r;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import s9.c;
import vk.d;

public class AssetPositionHeaderItemViewHandler implements c {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67590a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.asset.AssetAccountType[] r0 = com.huobi.asset.AssetAccountType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f67590a = r0
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.SPOT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f67590a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.FUTURE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f67590a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.OTC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f67590a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.MARGIN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f67590a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.HUOBI_EARN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f67590a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.QUANT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f67590a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.WARRANT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.viewhandler.AssetPositionHeaderItemViewHandler.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(Context context, String str, String str2, Void voidR) {
        i(context, str, str2);
    }

    public static /* synthetic */ void g(Context context, AssetAccountType assetAccountType, Void voidR) {
        if (context instanceof Activity) {
            BaseModuleConfig.a().S((Activity) context, assetAccountType.toString());
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        AssetAccountType a11 = dVar.a();
        String upperCase = BaseModuleConfig.a().M().toUpperCase();
        View b11 = e11.b(R$id.contract_header_account_title_layout);
        TextView textView = (TextView) e11.b(R$id.contract_header_account_debts_action);
        TextView textView2 = (TextView) e11.b(R$id.contract_header_title_name);
        TextView textView3 = (TextView) e11.b(R$id.contract_header_account_title_name);
        TextView textView4 = (TextView) e11.b(R$id.contract_header_center_text);
        TextView textView5 = (TextView) e11.b(R$id.contract_header_end_text);
        FontIconTextView fontIconTextView = (FontIconTextView) e11.b(R$id.contract_header_font_icon);
        View b12 = e11.b(R$id.font_icon_layout);
        boolean e12 = b.a().e();
        ViewUtil.m(textView, e12 && a11 == AssetAccountType.SPOT);
        String str4 = "";
        switch (a.f67590a[a11.ordinal()]) {
            case 1:
                str4 = context.getString(R$string.n_spot);
                str = context.getString(R$string.n_asset_position_number, new Object[]{upperCase});
                str3 = context.getString(R$string.n_asset_position_today_pl, new Object[]{upperCase});
                str2 = context.getString(R$string.n_spot_position_header_tips);
                break;
            case 2:
                str4 = context.getString(R$string.n_balance_contract_title);
                str = context.getString(R$string.n_asset_position_number, new Object[]{upperCase});
                str3 = context.getString(R$string.n_asset_position_margin_pl, new Object[]{upperCase});
                str2 = context.getString(R$string.n_asset_future_header_dialog_sub_content);
                break;
            case 3:
                str4 = context.getString(R$string.n_blance_fiat_assets);
                str = context.getString(R$string.n_asset_position_number, new Object[]{upperCase});
                str3 = context.getString(R$string.n_asset_position_available_number, new Object[]{upperCase});
                str2 = context.getString(R$string.n_asset_otc_header_dialog_sub_content);
                break;
            case 4:
                str4 = context.getString(R$string.n_kline_loan);
                str = context.getString(R$string.n_asset_position_number, new Object[]{upperCase});
                str3 = context.getString(R$string.n_asset_position_borrow_number, new Object[]{upperCase});
                str2 = context.getString(R$string.n_asset_margin_header_dialog_sub_content);
                break;
            case 5:
                str4 = context.getString(R$string.n_asset_ybb_stop_financial);
                str = context.getString(R$string.n_asset_position_number, new Object[]{upperCase});
                if (com.huobi.asset2.index.util.a.a().b()) {
                    str3 = context.getString(R$string.n_asset_position_this_day_number, new Object[]{upperCase});
                } else {
                    str3 = context.getString(R$string.n_asset_position_yester_day_number, new Object[]{upperCase});
                }
                str2 = context.getString(R$string.n_asset_earn_active_fixed_header_dialog_sub_content);
                break;
            case 6:
                str4 = context.getString(R$string.n_balance_strategy);
                str = context.getString(R$string.n_asset_position_cost, new Object[]{upperCase});
                str3 = context.getString(R$string.n_asset_position_margin_pl, new Object[]{upperCase});
                str2 = context.getString(R$string.n_asset_quant_header_dialog_sub_content);
                break;
            case 7:
                str4 = context.getString(R$string.n_otc_options);
                str = context.getString(R$string.n_asset_position_number, new Object[]{upperCase});
                str3 = context.getString(R$string.n_asset_position_add_total_pl, new Object[]{upperCase});
                str2 = context.getString(R$string.n_asset_warrant_header_dialog_sub_content);
                break;
            default:
                str3 = str4;
                str2 = str3;
                str = str2;
                break;
        }
        textView2.setText(context.getString(R$string.n_market_collecation_tab_name));
        textView3.setText(str4);
        textView4.setText(str);
        textView5.setText(str3);
        String string = context.getString(R$string.n_introduction);
        if (e12) {
            textView.setText(b.a().c(context));
            textView.setBackgroundColor(context.getResources().getColor(b.a().b()));
        }
        Observable<Void> a12 = dw.a.a(b12);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a12.throttleFirst(1, timeUnit).subscribe(new d0(this, context, string, str2));
        dw.a.a(b11).throttleFirst(1, timeUnit).subscribe(new c0(context, a11));
    }

    public int getResId() {
        return R$layout.item_position_child_recycler_header;
    }

    public final void i(Context context, String str, String str2) {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        new DialogUtils.b.d(fragmentActivity).c1(str).i1(5).R0(str2).P0(context.getString(R$string.contract_trade_i_know)).T0(true).x0(false).q0(false).Q0(b0.f12546a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }
}
