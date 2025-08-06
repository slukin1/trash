package bc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractPriceInfo;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.C2CLendBalanceDetailInfo;
import com.huobi.finance.bean.C2CMarginBalanceDetailInfo;
import com.huobi.finance.bean.LegalDetailInfo;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.bean.MineDetailInfo;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.bean.SavingsDetailInfo;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.supermargin.bean.MarginCurrency;
import com.huobi.view.BaseBottomCurrencyDialogFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import u6.g;

public interface a {
    Bitmap A(View view);

    void A0(Context context, String str, boolean z11, TradeType tradeType);

    void B(FragmentActivity fragmentActivity, g gVar);

    void B0(Context context);

    void C(Activity activity);

    void C0(Context context, boolean z11, String str);

    void D(Context context, String str, boolean z11);

    Observable<ContractUserInfo.UserBean> D0(boolean z11);

    void E(Context context, String str);

    void E0(Boolean bool);

    Boolean F();

    void F0(Context context, MineDetailInfo mineDetailInfo);

    void G(Context context, LinearSwapAccountInfo linearSwapAccountInfo);

    Observable<List<MarginCurrency>> G0(boolean z11);

    void H(Context context, String str, boolean z11);

    void H0(Context context, boolean z11);

    void I(Context context, String str);

    void I0(Activity activity);

    BaseBottomCurrencyDialogFragment J();

    void J0(Context context, int i11);

    void K(Context context, String str);

    void K0(FragmentActivity fragmentActivity, String str, String str2, int i11);

    long L(int i11);

    void L0(String str, Map<String, Object> map);

    void M(Context context);

    void M0(Context context, SuperMarginDetailInfo superMarginDetailInfo);

    void N(Context context);

    boolean N0();

    void O(Context context, String str);

    long O0();

    void P(Context context, String str, boolean z11, String str2);

    void P0(Context context, String str, boolean z11);

    void Q(Context context, SwapAccountInfo swapAccountInfo);

    Observable<ContractHeartBeat> Q0();

    ContractUserInfo.UserBean R();

    void R0(Context context, String str);

    void S(Context context, C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo);

    void S0(Context context, String str);

    String T();

    void T0(Context context, BalanceDetailInfo balanceDetailInfo);

    void U(Context context);

    void U0(Context context);

    void V(Context context);

    void V0(Context context, String str, String str2);

    void W(Context context, String str);

    void W0(Context context, String str);

    Observable<ContractHeartBeat> X();

    void X0(Context context, String str);

    void Y(Context context, TradeType tradeType);

    boolean Y0(g gVar);

    void Z(Context context, String str);

    void Z0(Context context, OptionAccountInfo optionAccountInfo);

    void a0(Context context, MarginBalanceDetailInfo marginBalanceDetailInfo);

    void a1(String str);

    boolean b0(int i11);

    void b1(Context context);

    boolean c();

    void c0(Context context);

    void c1(Context context, String str);

    boolean d();

    void d0(String str);

    void d1(Context context);

    void e(Context context, String str, boolean z11, TradeType tradeType);

    void e0(Context context, String str);

    void e1(Context context);

    void f0(Context context, String str);

    void f1(Context context, String str, String str2);

    void g(Activity activity);

    void g0(Context context, boolean z11, TradeType tradeType);

    Observable<ContractUserInfo.UserBean> g1(boolean z11);

    String getUid();

    ContractUserInfo.UserBean getUserInfo();

    void h0(Context context, String str);

    void h1(Context context, String str, String str2);

    void i0(boolean z11);

    void i1(Context context);

    String j();

    boolean j0();

    void j1(Context context, String str);

    Observable<List<ContractAccountInfo>> k(boolean z11);

    Observable<List<AssetPositionContractData>> k0(Context context);

    void k1(Activity activity, String str, String str2);

    Observable<List<ContractPriceInfo>> l(boolean z11);

    void l0(String str, String str2);

    void l1(Context context);

    void m(String str);

    void m0(Context context, String str, boolean z11, int i11);

    void m1(Context context);

    void n(String str, String str2, String str3, boolean z11);

    void n0(Context context);

    void n1(String str, String str2);

    void o(Context context, int i11);

    void o0(Context context);

    void p(Context context, String str);

    void p0(Context context, String str, String str2);

    void q(Activity activity);

    void q0(Context context, LegalDetailInfo legalDetailInfo);

    void r(Context context, SavingsDetailInfo savingsDetailInfo);

    void r0(Context context);

    void s(Context context, ContractAccountInfo contractAccountInfo);

    void s0(Context context, BalanceDetailInfo balanceDetailInfo);

    void t(Context context, String str, String str2);

    void t0(Context context, String str, String str2);

    void track(String str, HashMap hashMap);

    void u(boolean z11);

    void u0(Context context, String str, String str2);

    void v(Context context, String str, String str2);

    void v0(Activity activity, String str);

    boolean w();

    void w0(Context context, String str);

    void x(Context context, OtcOptionsDetailInfo otcOptionsDetailInfo);

    void x0(Context context);

    void y(Activity activity, C2CLendBalanceDetailInfo c2CLendBalanceDetailInfo);

    void y0(Activity activity, String str);

    void z(boolean z11);

    boolean z0(String str, String str2, String str3);
}
