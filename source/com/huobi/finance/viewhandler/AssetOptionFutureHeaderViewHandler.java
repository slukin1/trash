package com.huobi.finance.viewhandler;

import al.b;
import al.i;
import android.app.Activity;
import android.view.ViewGroup;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.account.future.subtype.AssetOptionFutureFragment$HeadViewData;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.OptionDataTotal;
import java.util.ArrayList;
import v9.c;

public class AssetOptionFutureHeaderViewHandler extends AssetHeaderViewHandler<AssetOptionFutureFragment$HeadViewData> {
    public String b() {
        return "12";
    }

    /* renamed from: d */
    public void handleView(c cVar, int i11, AssetOptionFutureFragment$HeadViewData assetOptionFutureFragment$HeadViewData, ViewGroup viewGroup) {
        super.handleView(cVar, i11, assetOptionFutureFragment$HeadViewData, viewGroup);
        AssetHeadView<T> assetHeadView = this.f67577c;
        assetHeadView.f42421f.setText(b.a(assetHeadView.getContext(), 10));
        OptionDataTotal optionDataTotal = (OptionDataTotal) assetOptionFutureFragment$HeadViewData.c();
        String currency = (optionDataTotal == null || CollectionsUtils.b(optionDataTotal.getDetailInfos())) ? "btc" : ((BaseAssetInfo) optionDataTotal.getDetailInfos().get(0)).getCurrency();
        ArrayList arrayList = new ArrayList();
        Activity activity = (Activity) cVar.itemView.getContext();
        arrayList.add(i.l(activity, currency, CouponReturn.TYPE_EXPERIENCE, activity.getResources().getString(R$string.n_balance_contract_transfer), AssetAccountType.FUTURE));
        this.f67577c.i(arrayList);
    }
}
