package yl;

import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.imsdk.HbgDialogPageBean;
import com.hbg.lib.imsdk.HbgImDialogPageType;
import com.huobi.account.ui.AccountFragment;
import com.huobi.asset2.index.AssetIndexFragmentNew;
import com.huobi.asset2.index.AssetIndexFragmentNew1;
import com.huobi.copytrading.ui.CopyTradingMainActivity;
import com.huobi.feature.ui.FutureTradeFragment;
import com.huobi.home.ui.HomeFragment;
import com.huobi.homemarket.ui.HomeMarketNewFragment;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.trade.ui.TradeFragment;
import hh.f;
import i6.d;
import java.util.ArrayList;
import java.util.HashMap;

public final class h {
    public static void a() {
        Class<OtcTradeActivity> cls = OtcTradeActivity.class;
        d.b("register===============");
        ArrayList arrayList = new ArrayList();
        arrayList.add(HomeFragment.class.getName());
        arrayList.add(HomeMarketNewFragment.class.getName());
        arrayList.add(TradeFragment.class.getName());
        arrayList.add(FutureTradeFragment.class.getName());
        if (f.h().l()) {
            arrayList.add(AssetIndexFragmentNew1.class.getName());
        } else {
            arrayList.add(AssetIndexFragmentNew.class.getName());
        }
        arrayList.add(AccountFragment.class.getName());
        HbgDialogManager.A().V(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(HuobiMainActivity.class.getName());
        arrayList2.add(cls.getName());
        HbgDialogManager.A().U(arrayList2);
        HashMap hashMap = new HashMap();
        hashMap.put(HbgImDialogPageType.INDEX.getType(), new HbgDialogPageBean(HomeFragment.class.getName(), false));
        hashMap.put(HbgImDialogPageType.MARKET.getType(), new HbgDialogPageBean(HomeMarketNewFragment.class.getName(), false));
        hashMap.put(HbgImDialogPageType.EXCHANGE.getType(), new HbgDialogPageBean(TradeFragment.class.getName(), false));
        hashMap.put(HbgImDialogPageType.CONTRACT.getType(), new HbgDialogPageBean(FutureTradeFragment.class.getName(), false));
        if (f.h().l()) {
            hashMap.put(HbgImDialogPageType.ASSET.getType(), new HbgDialogPageBean(AssetIndexFragmentNew1.class.getName(), false));
        } else {
            hashMap.put(HbgImDialogPageType.ASSET.getType(), new HbgDialogPageBean(AssetIndexFragmentNew.class.getName(), false));
        }
        hashMap.put(HbgImDialogPageType.ACCOUNT.getType(), new HbgDialogPageBean(AccountFragment.class.getName(), false));
        hashMap.put(HbgImDialogPageType.OTC.getType(), new HbgDialogPageBean(cls.getName(), true));
        hashMap.put(HbgImDialogPageType.COPY_TRADING.getType(), new HbgDialogPageBean(CopyTradingMainActivity.class.getName(), true));
        HbgDialogManager.A().F(hashMap);
    }
}
