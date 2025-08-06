package td;

import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.symbol.TradeType;
import d7.a1;

public final class f {
    public static boolean a(String str, TradeType tradeType) {
        boolean z11 = !TradeType.isIndex(tradeType) && !(TradeType.isContractIndex(tradeType) || TradeType.isLinearSwapIndex(tradeType)) && !(TradeType.isContract(tradeType) || TradeType.isSwap(tradeType) || TradeType.isOption(tradeType) || TradeType.isLinearSwap(tradeType)) && !a1.v().p0(str);
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        if (!z11 || !isChineseLanguage) {
            return false;
        }
        return true;
    }

    public static boolean b(String str, String str2) {
        return a(str, TradeType.valueOf(str2));
    }
}
