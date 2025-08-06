package ml;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import s9.a;

public interface b extends a {
    int b();

    String getBaseCurrency();

    String getBaseCurrencyDisplayName();

    String getQuoteCurrency();

    SymbolPrice getSymbolPrice();

    int getWeight();
}
