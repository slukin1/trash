package com.huobi.homemarket.view;

import android.content.Context;
import android.util.AttributeSet;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.module.market.R$string;
import java.util.ArrayList;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import rl.q;

public class MarketContractIndicator extends CommonTextListIndicator {
    public ArrayList<String> A;
    public FragmentContainerHelper B;
    public int C = -1;

    public MarketContractIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q(context);
    }

    private int getSavedTabIndex() {
        int g11 = ConfigPreferences.g("user_config", "config_home_future_index", 0);
        if (g11 > this.A.size() - 1 || g11 < 0) {
            return 0;
        }
        return g11;
    }

    public int getCurrentFutureTab() {
        if (this.C == -1) {
            this.C = getSavedTabIndex();
        }
        return this.C;
    }

    public final void q(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.A = arrayList;
        arrayList.add(context.getString(R$string.n_market_contract_usdt_m));
        this.A.add(context.getString(R$string.n_market_contract_coin_m));
        setDataList(this.A);
        this.B = new FragmentContainerHelper(this);
        int savedTabIndex = getSavedTabIndex();
        this.C = savedTabIndex;
        this.B.h(savedTabIndex);
    }

    public void y(int i11) {
        if (this.C != i11) {
            q.b().f((String) null, -1);
        }
        this.C = i11;
        ConfigPreferences.k("user_config", "config_home_future_index", i11);
        this.B.h(i11);
    }
}
