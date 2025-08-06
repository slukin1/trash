package cn;

import a7.e;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCancelAllResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderInsertRspInfo;
import com.hbg.lib.network.linear.swap.retrofit.LinearSwapRetrofit;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.response.MarketDetailResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;
import com.huobi.feature.util.FutureOrderErrorHelper;
import dp.k;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import u6.g;

public class r extends k implements FutureLimitOrderEditDialogHelper.e {

    /* renamed from: d  reason: collision with root package name */
    public final TradeType f70966d = TradeType.LINEAR_SWAP;

    /* renamed from: e  reason: collision with root package name */
    public final FutureLimitOrderEditDialogHelper f70967e;

    /* renamed from: f  reason: collision with root package name */
    public final FutureLimitOrderEditDialogHelper.f f70968f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f70969g;

    /* renamed from: h  reason: collision with root package name */
    public final MarketDetailListener f70970h = new b();

    public class a extends EasySubscriber<LinearSwapOrderInsertRspInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapOrderInsertRspInfo linearSwapOrderInsertRspInfo) {
            super.onNext(linearSwapOrderInsertRspInfo);
            r.this.dismiss();
            r.this.f70969g.postDelayed(r.this.f70967e.j(), 2000);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            r.this.dismiss();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode = aPIStatusErrorException.getErrCode();
            errCode.hashCode();
            if (errCode.equals("1900")) {
                FutureOrderErrorHelper.c(aPIStatusErrorException.getErrMsg(), r.this.f70968f != null && "buy".equalsIgnoreCase(r.this.f70968f.i()));
            } else if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
            }
        }
    }

    public class b extends MarketDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDetailResponse marketDetailResponse) {
            if (marketDetailResponse == null || marketDetailResponse.getTick() == null || !marketDetailResponse.getSymbol().equals(r.this.f70968f.g())) {
                r.this.f70969g.setText("--");
                return;
            }
            r.this.f70969g.setText(m.i(marketDetailResponse.getTick().getClose(), FuturePrecisionUtil.c(r.this.f70968f.s())));
        }
    }

    public r(Context context, FutureLimitOrderEditDialogHelper.f fVar, FutureLimitOrderEditDialogHelper.c cVar) {
        super(context);
        this.f70967e = new FutureLimitOrderEditDialogHelper(this, fVar, cVar);
        this.f70968f = fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable q(String str, String str2, List list) {
        return r(str, str2);
    }

    public TradeType D0() {
        return this.f70966d;
    }

    public void b(EditText editText, Editable editable) {
        String str;
        if (e.E(this.f70966d)) {
            str = m.b(editable, 10, FuturePrecisionUtil.s(this.f70968f.e(), this.f70968f.g(), (String) null));
        } else {
            str = m.b(editable, 10, FuturePrecisionUtil.g(this.f70968f.s()));
        }
        this.f70967e.t(editText, str);
    }

    public void c(String str, String str2) {
        if (e.G(this.f70966d)) {
            String f11 = this.f70968f.f();
            String r11 = this.f70968f.r();
            String I = m.I(m.a(f11).multiply(m.a(str2)), 4);
            HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.contract_trade_lowest_amount), new Object[]{I, r11}));
            return;
        }
        BigDecimal a11 = m.a(this.f70968f.f());
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.contract_trade_lowest_amount), new Object[]{m.F(a11.toPlainString(), FuturePrecisionUtil.s(this.f70968f.e(), this.f70968f.g(), (String) null)), str}));
    }

    public BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        String f11 = this.f70968f.f();
        if (e.E(this.f70966d)) {
            return bigDecimal.divide(m.a(f11), 32, 1).setScale(0, 1);
        }
        return bigDecimal.divide(bigDecimal2.multiply(m.a(f11)), 32, 1).setScale(0, 1);
    }

    public void dismiss() {
        h8.a.a().j(false, this.f70968f.g(), this.f70970h);
        super.dismiss();
    }

    public void e(EditText editText, Editable editable) {
        this.f70967e.t(editText, m.b(editable, 10, FuturePrecisionUtil.y(this.f70968f.e(), this.f70968f.g(), (String) null)));
    }

    public String f() {
        String e11 = this.f70968f.e();
        String m11 = this.f70968f.m();
        String s11 = this.f70968f.s();
        String h11 = this.f70968f.h();
        String i11 = StringUtils.i(this.f70968f.r());
        return e.u(getContext(), s11, i11, e11, h11) + "·" + e.w(getContext(), Integer.parseInt(m11));
    }

    public void g(String str, String str2) {
        Observable<LinearSwapCancelAllResult> observable;
        if (Integer.parseInt(this.f70968f.m()) == 2) {
            observable = h8.a.a().q0(this.f70968f.e(), Long.parseLong(this.f70968f.o())).b();
        } else {
            observable = h8.a.a().Y(this.f70968f.e(), Long.parseLong(this.f70968f.o())).b();
        }
        observable.compose(LinearSwapRetrofit.n()).compose(RxJavaHelper.t((g) null)).delay(300, TimeUnit.MILLISECONDS).flatMap(new q(this, str, str2)).subscribe(new a());
    }

    public void j() {
    }

    public int k() {
        return this.f70967e.i();
    }

    public void l() {
        this.f70967e.l();
        this.f70969g = (TextView) findViewById(R.id.tv_contract_price);
        h8.a.a().j(true, this.f70968f.g(), this.f70970h);
    }

    public Observable<LinearSwapOrderInsertRspInfo> r(String str, String str2) {
        boolean c11 = SPUtil.j() ? pk.e.a().c() : false;
        if (Integer.parseInt(this.f70968f.m()) == 2) {
            return h8.a.a().G(this.f70968f.e(), str, this.f70968f.p(), str2, this.f70968f.i(), this.f70968f.n(), this.f70968f.l(), 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0d, c11, false, 0, this.f70968f.q()).b();
        }
        return h8.a.a().V(this.f70968f.e(), str, this.f70968f.p(), str2, this.f70968f.i(), this.f70968f.n(), this.f70968f.l(), 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0d, c11, false, 0, this.f70968f.q()).b();
    }
}
