package com.hbg.module.market.widget.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.lib.widgets.dialog.dialogfragment.BottomMenuNewDialogFragment;
import com.huobi.coupon.bean.CouponReturn;
import hf.b;
import java.util.ArrayList;

public class MarketWidgetCountSettingDialog extends BottomMenuNewDialogFragment implements MenuItemBean.a {
    public void Xf(View view, MenuItemBean menuItemBean, int i11) {
        b.D(Integer.parseInt(menuItemBean.getType()));
        dismiss();
    }

    public void afterInit() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItemBean("3", "3", wh("3"), this));
        arrayList.add(new MenuItemBean("4", "4", wh("4"), this));
        arrayList.add(new MenuItemBean(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, wh(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC), this));
        arrayList.add(new MenuItemBean(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, wh(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL), this));
        arrayList.add(new MenuItemBean(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, wh(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP), this));
        arrayList.add(new MenuItemBean("8", "8", wh("8"), this));
        arrayList.add(new MenuItemBean("9", "9", wh("9"), this));
        arrayList.add(new MenuItemBean(CouponReturn.TYPE_EXPERIENCE, CouponReturn.TYPE_EXPERIENCE, wh(CouponReturn.TYPE_EXPERIENCE), this));
        vh(arrayList);
        super.afterInit();
    }

    public final MenuItemBean.MenuItemStyle wh(String str) {
        return str.equalsIgnoreCase(String.valueOf(b.r())) ? MenuItemBean.MenuItemStyle.STRESS : MenuItemBean.MenuItemStyle.COMMON;
    }
}
