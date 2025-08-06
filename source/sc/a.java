package sc;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.contract.entity.ContractHistoryOrderInfo;
import java.util.HashMap;

public interface a {
    boolean a();

    boolean b();

    void c(String str, HashMap hashMap);

    boolean d();

    void e(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void f(FragmentActivity fragmentActivity, ContractHistoryOrderInfo contractHistoryOrderInfo);

    String g(TradeType tradeType);

    void h(TradeType tradeType, Context context);

    void i(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    void j(Context context);

    void k();

    void l(Context context, ContractHistoryOrderInfo contractHistoryOrderInfo);
}
