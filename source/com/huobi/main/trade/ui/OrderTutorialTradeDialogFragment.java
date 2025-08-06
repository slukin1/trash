package com.huobi.main.trade.ui;

import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.symbol.TradeType;

public class OrderTutorialTradeDialogFragment extends TradeDialogFragment {
    public void Ki(FragmentManager fragmentManager) {
        ConfigPreferences.k("user_config", "config_home_market_linear_swap_index", 1);
        Bi(fragmentManager, "trade", TradeType.LINEAR_SWAP);
    }

    public void vi(boolean z11) {
        super.vi(false);
    }
}
