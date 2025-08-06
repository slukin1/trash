package l8;

import android.content.Context;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.huobi.currencyconfig.bean.StableCoinHints;
import d9.a;
import java.util.List;

public interface b {
    void a(String str, Context context, c9.b bVar);

    a<List<LegalRateBean>> getCurrencyRateList();

    a<List<StableCoinHints>> getStableCoinHints();
}
