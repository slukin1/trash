package com.huobi.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.app.AbstractCommonListActivity;
import com.huobi.contract.ui.ContractOrderActivity;
import com.huobi.finance.ui.LiteDwRecordActivity;
import com.huobi.finance.ui.LiteFiatDwRecordActivity;
import com.huobi.linearswap.ui.LinearSwapOrderActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.order.ui.TradeOrderActivity;
import com.huobi.otc.flutter.OtcOrderDepositActivity;
import com.huobi.swap.ui.SwapOrderActivity;
import hr.d;
import kn.a;
import pro.huobi.R;
import rn.c;

@Route(path = "/account/order")
public class AccountOrderManageActivity extends AbstractCommonListActivity implements d.a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f41130g = true;

    public static void Hh(Activity activity) {
        c.i().d(activity, new JumpTarget(new Intent(activity, AccountOrderManageActivity.class), (Intent) null));
    }

    public void Bh() {
    }

    public void Ch() {
    }

    public String D(int i11) {
        return "";
    }

    public boolean E8(int i11, View view) {
        return false;
    }

    public String Qg() {
        return null;
    }

    public String a(int i11) {
        switch (i11) {
            case 0:
                return getString(R.string.n_user_center_coin_order);
            case 1:
                return getString(R.string.n_orders_contract_title);
            case 2:
                return getString(R.string.n_orders_swap_title);
            case 3:
                return getString(R.string.n_orders_linear_swap_title);
            case 5:
                return getString(R.string.n_orders_fiat_title);
            case 6:
                return getString(R.string.n_lite_order_flash_convert_order);
            case 7:
                return getString(R.string.n_lite_order_fiat_dw_order);
            case 8:
                return getString(R.string.n_lite_order_coin_dw_order);
            default:
                return null;
        }
    }

    public String oh() {
        return getString(R.string.n_user_center_order_management);
    }

    public void onItemClick(int i11) {
        if (!c.i().d(this, (a) null)) {
            String i12 = StringUtils.i("btc");
            switch (i11) {
                case 0:
                    TradeOrderActivity.Gi(this, TradeType.PRO, (String) null, 0);
                    return;
                case 1:
                    ContractOrderActivity.Pi(this, i12, 0, (String) null, 0);
                    return;
                case 2:
                    SwapOrderActivity.Pi(this, "BTC-USD", 0, 0);
                    return;
                case 3:
                    FutureContractInfo g11 = FutureContractInfoController.n().g();
                    LinearSwapOrderActivity.Si(this, i12, 0, 0, g11.getContractCode(), g11.getContractShortType(), 0);
                    return;
                case 5:
                case 6:
                    OtcOrderDepositActivity.Di(this);
                    return;
                case 7:
                    LiteFiatDwRecordActivity.Ki(this);
                    return;
                case 8:
                    LiteDwRecordActivity.Ki(this);
                    return;
                default:
                    return;
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.f41130g) {
            Dh();
        }
        this.f41130g = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<s9.a> qh(java.util.List<s9.a> r6) {
        /*
            r5 = this;
            com.huobi.litere.helper.LiteReHelper r0 = com.huobi.litere.helper.LiteReHelper.a()
            boolean r0 = r0.b()
            r1 = 1
            r2 = 5
            r3 = 0
            if (r0 == 0) goto L_0x005e
            hr.d r0 = new hr.d
            r4 = 6
            r0.<init>(r4, r5)
            r6.add(r0)
            hr.d r0 = new hr.d
            r0.<init>(r2, r5)
            r6.add(r0)
            d7.k r0 = d7.k.C()
            java.util.List r0 = r0.w()
            if (r0 == 0) goto L_0x0047
            java.util.Iterator r0 = r0.iterator()
        L_0x002c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0047
            java.lang.Object r2 = r0.next()
            com.hbg.lib.network.pro.core.bean.CurrencyBean r2 = (com.hbg.lib.network.pro.core.bean.CurrencyBean) r2
            if (r2 == 0) goto L_0x002c
            boolean r4 = r2.isFiatTag()
            if (r4 == 0) goto L_0x002c
            boolean r2 = r2.isVisible()
            if (r2 == 0) goto L_0x002c
            goto L_0x0048
        L_0x0047:
            r1 = r3
        L_0x0048:
            if (r1 == 0) goto L_0x0053
            hr.d r0 = new hr.d
            r1 = 7
            r0.<init>(r1, r5)
            r6.add(r0)
        L_0x0053:
            hr.d r0 = new hr.d
            r1 = 8
            r0.<init>(r1, r5)
            r6.add(r0)
            goto L_0x009c
        L_0x005e:
            hr.d r0 = new hr.d
            r0.<init>(r3, r5)
            r6.add(r0)
            gj.d r0 = gj.d.n()
            boolean r0 = r0.E()
            if (r0 == 0) goto L_0x008a
            hr.d r0 = new hr.d
            r0.<init>(r1, r5)
            r6.add(r0)
            hr.d r0 = new hr.d
            r1 = 2
            r0.<init>(r1, r5)
            r6.add(r0)
            hr.d r0 = new hr.d
            r1 = 3
            r0.<init>(r1, r5)
            r6.add(r0)
        L_0x008a:
            tg.r r0 = tg.r.x()
            boolean r0 = r0.X()
            if (r0 != 0) goto L_0x009c
            hr.d r0 = new hr.d
            r0.<init>(r2, r5)
            r6.add(r0)
        L_0x009c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.account.ui.AccountOrderManageActivity.qh(java.util.List):java.util.List");
    }

    public boolean th() {
        return false;
    }

    public boolean uh() {
        return false;
    }

    public boolean v8(int i11) {
        return false;
    }
}
