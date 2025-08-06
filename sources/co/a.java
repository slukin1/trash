package co;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.main.trade.enums.SafeguardType;
import com.huobi.main.trade.enums.TradeTabsType;
import java.util.List;

public interface a extends b {
    void gg(TradeType tradeType, String str, SafeguardType safeguardType);

    void p7(TradeType tradeType, List<String> list);

    void sb(int i11);

    void xa(TradeType tradeType, TradeTabsType tradeTabsType, List<String> list, List<? extends s9.a> list2);

    void y7(int i11);
}
