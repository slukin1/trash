package com.huobi.homemarket.view;

import android.content.Context;
import android.util.AttributeSet;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.RedPointPagerTitleView;
import com.hbg.module.market.R$string;
import gj.d;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import rl.q;

public class MarketCollectionIndicator extends CommonTextListIndicator {
    public ArrayList<String> A;
    public FragmentContainerHelper B;
    public int C = -1;

    public MarketCollectionIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int getSavedTabIndex() {
        int g11 = ConfigPreferences.g("user_config", "config_home_collection_index", 0);
        if (g11 < 0 || g11 > 2) {
            return 0;
        }
        return g11;
    }

    public void A(boolean z11, String str) {
        CommonNavigator commonNavigator = getmCommonNavigator();
        List<String> list = getList();
        int i11 = 0;
        while (i11 < list.size()) {
            if (!list.get(i11).equalsIgnoreCase(str)) {
                i11++;
            } else if (z11) {
                ((RedPointPagerTitleView) commonNavigator.d(i11)).c();
                return;
            } else {
                ((RedPointPagerTitleView) commonNavigator.d(i11)).a();
                return;
            }
        }
    }

    public int getCurrentFutureTab() {
        if (this.C == -1) {
            this.C = getSavedTabIndex();
        }
        return this.C;
    }

    public void q(Context context) {
        setShowRedPoint(true);
        ArrayList<String> arrayList = new ArrayList<>();
        this.A = arrayList;
        arrayList.add(context.getString(R$string.n_title_spot));
        if (d.n().E()) {
            this.A.add(context.getString(R$string.n_tab_contract));
        }
        this.A.add(context.getString(R$string.n_market_intelligent_stare));
        setDataList(this.A);
        this.B = new FragmentContainerHelper(this);
        int savedTabIndex = getSavedTabIndex();
        this.C = savedTabIndex;
        this.B.h(savedTabIndex);
    }

    public String y(int i11) {
        ArrayList<String> arrayList = this.A;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (i11 < 0 || i11 >= this.A.size()) {
            return this.A.get(0);
        }
        return this.A.get(i11);
    }

    public void z(int i11) {
        if (this.C != i11) {
            q.b().f((String) null, -1);
        }
        this.C = i11;
        ConfigPreferences.k("user_config", "config_home_collection_index", i11);
        this.B.h(i11);
    }
}
