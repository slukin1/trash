package ff;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.homemarket.bean.CollectionMultiple;
import java.util.List;
import rx.Observable;
import td.g;

public interface a {
    int A();

    Observable<Object> B(String str, Activity activity, String str2);

    boolean C();

    boolean D();

    boolean E(int i11);

    int F();

    String G();

    int H();

    String I(SymbolPrice symbolPrice);

    boolean J(String str);

    void K(String str);

    void L(Activity activity, String str, int i11);

    String M();

    String N();

    void O(Context context, IndexCurrencyInfo indexCurrencyInfo, TradeType tradeType);

    void P(Activity activity, String str, RemindContractType remindContractType, RemindBusinessType remindBusinessType);

    boolean Q(TradeType tradeType);

    void R(List<String> list);

    int S();

    long T();

    void U(FragmentActivity fragmentActivity);

    boolean V(String str);

    long W();

    void X(Context context, String str, boolean z11);

    long Y();

    Observable<Object> Z(BaseCoreActivity baseCoreActivity, List<String> list);

    Observable<ContractHeartBeat> a();

    void a0(Context context, String str, String str2, ContractCurrencyInfo contractCurrencyInfo, TradeType tradeType);

    Observable<Object> b0(List<String> list, Context context, String str);

    void c(FragmentActivity fragmentActivity, String str, boolean z11);

    Observable<Object> c0(List<CollectionMultiple> list, Activity activity);

    boolean d();

    boolean d0(String str, String str2, String str3);

    void e(Context context, String str, boolean z11, TradeType tradeType);

    String e0(String str);

    void f(FragmentActivity fragmentActivity, String str);

    void f0(List<String> list);

    void g(String str, g gVar);

    Observable<Object> g0(String str, Activity activity, String str2);

    void h(FragmentActivity fragmentActivity);

    Fragment h0();

    void i();

    int i0();

    void j(String str, String str2);

    void j0(Context context, String str, boolean z11, boolean z12, TradeType tradeType);

    boolean k(String str);

    void k0(Activity activity, String str, RemindContractType remindContractType, RemindBusinessType remindBusinessType);

    String l();

    String l0();

    void m(String str);

    List<String> m0();

    int n();

    void n0(Context context, FutureContractInfo futureContractInfo);

    int o();

    Observable<List<String>> o0(boolean z11, Context context);

    long p();

    void p0(BaseCoreActivity baseCoreActivity);

    boolean q(String str);

    void q0(Context context);

    String r();

    void s(Context context, String str, String str2, SwapCurrencyInfo swapCurrencyInfo, TradeType tradeType);

    void t(String str, String str2);

    void u(Context context, FutureContractInfo futureContractInfo);

    String v();

    boolean w();

    String x();

    void y(Context context, String str, boolean z11, TradeType tradeType, String str2);

    String z();
}
