package td;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.kline.presenter.AbstractKlinePresenter;
import com.hbg.module.kline.presenter.MarketInfoPresenter;
import java.util.Map;
import rx.Observable;
import u6.g;

public interface h {
    int A(String str);

    int B(String str);

    Observable<Object> C(MarketInfoPresenter.e eVar, String str, String str2);

    int D(String str);

    void E(AbstractKlinePresenter.b bVar);

    BaseDialogFragment F(boolean z11, MarketInfoPresenter.e eVar, String str, BaseDialogFragment baseDialogFragment, String str2);

    int G(String str);

    boolean a(String str);

    void b(String str, Map<String, Object> map);

    void c(FragmentActivity fragmentActivity, String str, boolean z11);

    void d(String str, Map<String, Object> map, String str2);

    boolean e();

    void f(FragmentActivity fragmentActivity, String str);

    void g(String str, g gVar);

    Observable<Boolean> h(MarketInfoPresenter.e eVar, String str);

    void i(AbstractKlinePresenter.b bVar, String str, boolean z11);

    int j(String str);

    void k(String str);

    String l(String str, String str2, TradeType tradeType);

    int m(String str);

    boolean n();

    void o(g gVar, String str, BaseDialogFragment baseDialogFragment, String str2);

    void p(AbstractKlinePresenter.b bVar, ContractCurrencyInfo contractCurrencyInfo, SwapCurrencyInfo swapCurrencyInfo, FutureContractInfo futureContractInfo, String str, String str2, boolean z11);

    Observable<Object> q(MarketInfoPresenter.e eVar, String str, String str2);

    String r();

    Observable<Boolean> s(RemindContractType remindContractType, g gVar, String str);

    int t(String str);

    DialogFragment u(boolean z11, MarketInfoPresenter.e eVar, MarketInfoPresenter marketInfoPresenter, DialogFragment dialogFragment, String str);

    String v(String str);

    DialogFragment w(boolean z11, MarketInfoPresenter.e eVar, MarketInfoPresenter marketInfoPresenter, DialogFragment dialogFragment, String str);

    void x(RemindContractType remindContractType, RemindBusinessType remindBusinessType, Context context, String str);

    int y(String str);

    int z(String str);
}
