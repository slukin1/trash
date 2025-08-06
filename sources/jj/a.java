package jj;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import rx.Observable;

public interface a {
    String a(String str, String str2, String str3);

    String b(String str, BigDecimal bigDecimal, String str2, int i11);

    String c(String str, String str2, String str3);

    String d(String str);

    Map<String, SymbolPrice> e(TradeType tradeType);

    Map<String, SymbolPrice> f();

    BigDecimal g(String str);

    Observable<Map<String, SymbolPrice>> h();

    void i(Map<String, SymbolPrice> map);

    boolean j(String str);

    Observable<Map<String, SymbolPrice>> k(boolean z11);

    String l(String str, String str2, int i11);

    String m(String str, String str2);

    Observable<List<LegalRateBean>> n(boolean z11);

    String o(String str, String str2);

    String p(String str, String str2);
}
