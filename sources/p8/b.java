package p8;

import android.content.Context;
import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.hbg.lib.network.option.core.bean.OptionCurrencyInfo;
import com.hbg.lib.network.option.core.bean.OptionFinancialRecordResponse;
import com.hbg.lib.network.option.core.bean.OptionIndexInfo;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.option.core.bean.OptionProductInfo;
import com.hbg.lib.network.option.core.bean.OptionUserInfo;
import com.hbg.lib.network.option.core.bean.PriceLimitInfo;
import com.hbg.lib.network.option.core.util.OptionDepthType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthPercentListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.listener.MarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.listener.RequestMarketTradeDetailListener;
import g9.a;
import java.util.List;

public interface b {
    void a(String str, Context context, c9.b bVar);

    void b();

    void c(a.d dVar);

    void d(a.d dVar);

    void e(boolean z11, MarketOverviewListener marketOverviewListener);

    void f(String str, Period period, long j11, long j12, KLineListener kLineListener);

    void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener);

    d9.a<List<PriceLimitInfo>> getPriceLimitLevel(String str);

    d9.a<List<OptionProductInfo>> getProductInfo(String str);

    d9.a<OptionUserInfo> getUserInfo();

    void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener);

    void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11);

    void j(boolean z11, String str, MarketDetailListener marketDetailListener);

    void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener);

    void l(boolean z11, String str, OptionDepthType optionDepthType, MarketDepthPercentListener marketDepthPercentListener);

    d9.a<List<OptionMarketIndexInfo>> m(String str, String str2, String str3);

    d9.a<OptionFinancialRecordResponse> n(String str, String str2, String str3, int i11, int i12);

    d9.a<List<OptionCurrencyInfo>> o(String str, String str2, String str3, String str4);

    d9.a<List<OptionIndexInfo>> p(String str, String str2);

    d9.a<List<OptionAccountInfo>> z(String str, String str2);
}
