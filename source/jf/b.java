package jf;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.hbg.module.market.widget.bean.MarketSearchResultItem;
import java.util.List;

public interface b {
    boolean a();

    void b(List<String> list);

    MarketSearchResultItem c(Activity activity, String str);

    void d();

    List<Pair<String, Object>> e(Context context, String str, boolean z11);

    List<String> f();

    void g(Context context, a aVar);

    String getUid();

    void i();
}
