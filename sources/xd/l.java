package xd;

import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;

public interface l {
    boolean a(Period period);

    void b(boolean z11);

    void c(Period period, boolean z11);

    void d(String str);

    void e(KlineInfo klineInfo);

    void f();

    Period g();

    String k1();

    void onPause();

    void onResume();
}
