package b8;

import android.content.Context;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
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

    d9.a<List<SymbolPrice>> h();
}
