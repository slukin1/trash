package ts;

import a7.e;
import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.response.MarketDetailResponse;
import com.hbg.lib.network.swap.core.bean.OrderInsertRspInfo;
import com.hbg.lib.network.swap.core.bean.SwapCancelResult;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;
import dp.k;
import i6.m;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import u6.g;
import us.i;
import us.j;

public class q extends k implements FutureLimitOrderEditDialogHelper.e {

    /* renamed from: d  reason: collision with root package name */
    public final TradeType f84891d = TradeType.SWAP;

    /* renamed from: e  reason: collision with root package name */
    public final FutureLimitOrderEditDialogHelper f84892e;

    /* renamed from: f  reason: collision with root package name */
    public final FutureLimitOrderEditDialogHelper.f f84893f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f84894g;

    /* renamed from: h  reason: collision with root package name */
    public final MarketDetailListener f84895h = new b();

    public class a extends EasySubscriber<OrderInsertRspInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(OrderInsertRspInfo orderInsertRspInfo) {
            super.onNext(orderInsertRspInfo);
            q.this.dismiss();
            q.this.f84894g.postDelayed(q.this.f84892e.j(), 2000);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            q.this.dismiss();
        }
    }

    public class b extends MarketDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDetailResponse marketDetailResponse) {
            if (marketDetailResponse == null || marketDetailResponse.getTick() == null || !marketDetailResponse.getSymbol().equals(q.this.f84893f.g())) {
                q.this.f84894g.setText("--");
                return;
            }
            q.this.f84894g.setText(m.i(marketDetailResponse.getTick().getClose(), i.q(q.this.f84893f.s())));
        }
    }

    public q(Context context, FutureLimitOrderEditDialogHelper.f fVar, FutureLimitOrderEditDialogHelper.c cVar) {
        super(context);
        this.f84892e = new FutureLimitOrderEditDialogHelper(this, fVar, cVar);
        this.f84893f = fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable q(String str, String str2, SwapCancelResult swapCancelResult) {
        return r(str, str2);
    }

    public TradeType D0() {
        return this.f84891d;
    }

    public void b(EditText editText, Editable editable) {
        String str;
        if (e.E(TradeType.SWAP)) {
            str = m.b(editable, 10, i.k(this.f84893f.s()));
        } else if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
            str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
        } else {
            str = m.b(editable, 10, i.l(this.f84893f.s()));
        }
        this.f84892e.t(editText, str);
    }

    public void c(String str, String str2) {
        BigDecimal divide = m.a(this.f84893f.f()).divide(m.a(str2), 32, 1);
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.contract_trade_lowest_amount), new Object[]{m.F(divide.toPlainString(), i.k(str)), str}));
    }

    public BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return e.E(this.f84891d) ? bigDecimal.multiply(bigDecimal2).divide(m.a(this.f84893f.f()), 32, 1).setScale(0, 1) : bigDecimal;
    }

    public void dismiss() {
        l9.a.a().j(false, this.f84893f.g(), this.f84895h);
        super.dismiss();
    }

    public void e(EditText editText, Editable editable) {
        this.f84892e.t(editText, m.b(editable, 10, i.m(this.f84893f.s())));
    }

    public String f() {
        return j.g(getContext(), this.f84893f.s());
    }

    public void g(String str, String str2) {
        l9.a.a().H(this.f84893f.e(), this.f84893f.o()).b().compose(RxJavaHelper.t((g) null)).delay(300, TimeUnit.MILLISECONDS).flatMap(new p(this, str, str2)).subscribe(new a());
    }

    public void j() {
    }

    public int k() {
        return this.f84892e.i();
    }

    public void l() {
        this.f84892e.l();
        this.f84894g = (TextView) findViewById(R.id.tv_contract_price);
        l9.a.a().j(true, this.f84893f.g(), this.f84895h);
    }

    public Observable<OrderInsertRspInfo> r(String str, String str2) {
        return l9.a.a().D(this.f84893f.e(), str, this.f84893f.p(), str2, this.f84893f.i(), this.f84893f.n(), this.f84893f.l(), 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0d).b();
    }
}
