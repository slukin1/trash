package dj;

import a7.e;
import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractOrderInsertRspInfo;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.response.MarketDetailResponse;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.service.ContractService;
import com.huobi.contract.entity.ContractCancelResult;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;
import dp.k;
import ej.f;
import ej.g;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;

public class v extends k implements FutureLimitOrderEditDialogHelper.e {

    /* renamed from: d  reason: collision with root package name */
    public final TradeType f47489d = TradeType.CONTRACT;

    /* renamed from: e  reason: collision with root package name */
    public final FutureLimitOrderEditDialogHelper f47490e;

    /* renamed from: f  reason: collision with root package name */
    public final FutureLimitOrderEditDialogHelper.f f47491f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47492g;

    /* renamed from: h  reason: collision with root package name */
    public final MarketDetailListener f47493h = new b();

    public class a extends EasySubscriber<ContractOrderInsertRspInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ContractOrderInsertRspInfo contractOrderInsertRspInfo) {
            super.onNext(contractOrderInsertRspInfo);
            v.this.dismiss();
            v.this.f47492g.postDelayed(v.this.f47490e.j(), 2000);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            v.this.dismiss();
        }
    }

    public class b extends MarketDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDetailResponse marketDetailResponse) {
            if (marketDetailResponse == null || marketDetailResponse.getTick() == null || !marketDetailResponse.getSymbol().equals(v.this.f47491f.g())) {
                v.this.f47492g.setText("--");
                return;
            }
            v.this.f47492g.setText(m.i(marketDetailResponse.getTick().getClose(), f.e(v.this.f47491f.s())));
        }
    }

    public v(Context context, FutureLimitOrderEditDialogHelper.f fVar, FutureLimitOrderEditDialogHelper.c cVar) {
        super(context);
        this.f47490e = new FutureLimitOrderEditDialogHelper(this, fVar, cVar);
        this.f47491f = fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable q(String str, String str2, ContractCancelResult contractCancelResult) {
        return r(str, str2);
    }

    public TradeType D0() {
        return this.f47489d;
    }

    public void b(EditText editText, Editable editable) {
        String str;
        if (e.E(TradeType.CONTRACT)) {
            str = m.b(editable, 10, f.n(this.f47491f.e()));
        } else if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
            str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
        } else {
            str = m.b(editable, 10, f.g(this.f47491f.s()));
        }
        this.f47490e.t(editText, str);
    }

    public void c(String str, String str2) {
        BigDecimal divide = m.a(this.f47491f.f()).divide(m.a(str2), 32, 1);
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.contract_trade_lowest_amount), new Object[]{m.F(divide.toPlainString(), f.n(this.f47491f.e())), str}));
    }

    public BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return e.E(this.f47489d) ? bigDecimal.multiply(bigDecimal2).divide(m.a(this.f47491f.f()), 32, 1).setScale(0, 1) : bigDecimal;
    }

    public void dismiss() {
        q7.a.a().j(false, this.f47491f.g(), this.f47493h);
        super.dismiss();
    }

    public void e(EditText editText, Editable editable) {
        this.f47490e.t(editText, m.b(editable, 10, f.p(this.f47491f.e())));
    }

    public String f() {
        return g.e(getContext(), this.f47491f.s(), this.f47491f.e(), (String) null);
    }

    public void g(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.f47491f.o());
        hashMap.put("symbol", this.f47491f.s());
        ((ContractService) ContractRetrofit.request(ContractService.class)).contractCancel(hashMap).compose(ContractRetrofit.h()).compose(RxJavaHelper.t((u6.g) null)).delay(300, TimeUnit.MILLISECONDS).flatMap(new u(this, str, str2)).subscribe(new a());
    }

    public void j() {
    }

    public int k() {
        return this.f47490e.i();
    }

    public void l() {
        this.f47490e.l();
        this.f47492g = (TextView) findViewById(R.id.tv_contract_price);
        q7.a.a().j(true, this.f47491f.g(), this.f47493h);
    }

    public Observable<ContractOrderInsertRspInfo> r(String str, String str2) {
        return q7.a.a().I(this.f47491f.s(), this.f47491f.h(), this.f47491f.e(), str, this.f47491f.p(), str2, this.f47491f.i(), this.f47491f.n(), this.f47491f.l(), 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0d).b();
    }
}
