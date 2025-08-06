package com.huobi.c2c.lend;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.c2c.C2CCurrencyProvider;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import com.hbg.lib.network.hbg.core.bean.C2CLendThresholdGetAssetInfo;
import com.hbg.lib.network.hbg.core.bean.C2CLoanBalanceInfo;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.network.hbg.core.util.C2COrderState;
import com.hbg.lib.network.hbg.core.util.C2CloanOrderDirect;
import com.hbg.lib.network.hbg.socket.listener.C2CMarketDepthListener;
import com.hbg.lib.network.hbg.socket.response.C2CMarketDepthResponse;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.c2c.lend.bean.C2CLendOrderHistoryItem;
import com.huobi.c2c.lend.dialog.C2CLendIncomeDetailDialog;
import com.huobi.c2c.lend.view.C2CLendTradeView2;
import com.huobi.c2c.ui.C2CLoanOrderActivity;
import com.huobi.c2c.util.C2CDialogUtil;
import com.huobi.c2c.util.n;
import com.huobi.c2c.util.o;
import com.huobi.utils.d1;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.xiaomi.mipush.sdk.Constants;
import dt.h2;
import g9.a;
import i6.g;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import oi.a;
import oi.b;
import pro.huobi.R;
import rx.Observable;
import tg.r;

public class a implements C2CLendTradeView2.g, a.C0580a, g.a, C2CLendOrderHistoryItem.a {
    public static final C2COrderState[] E;
    public static final Set<String> F = new HashSet();
    public int A;
    public boolean B;
    public CommonPopListItem.a C;
    public boolean D;

    /* renamed from: a  reason: collision with root package name */
    public HuobiKeyboardHelper f42868a;

    /* renamed from: b  reason: collision with root package name */
    public final zs.b f42869b;

    /* renamed from: c  reason: collision with root package name */
    public final FragmentActivity f42870c;

    /* renamed from: d  reason: collision with root package name */
    public C2CLendTradeView2 f42871d;

    /* renamed from: e  reason: collision with root package name */
    public String f42872e;

    /* renamed from: f  reason: collision with root package name */
    public d9.a<C2CLoanBalanceInfo> f42873f;

    /* renamed from: g  reason: collision with root package name */
    public d9.a<Object> f42874g;

    /* renamed from: h  reason: collision with root package name */
    public d9.a<List<C2CLoanOrderBean>> f42875h;

    /* renamed from: i  reason: collision with root package name */
    public C2CLoanBalanceInfo f42876i;

    /* renamed from: j  reason: collision with root package name */
    public C2CLendThresholdGetAssetInfo f42877j;

    /* renamed from: k  reason: collision with root package name */
    public String f42878k;

    /* renamed from: l  reason: collision with root package name */
    public final C2CLendIncomeDetailDialog f42879l;

    /* renamed from: m  reason: collision with root package name */
    public C2CCurrencyBean f42880m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f42881n;

    /* renamed from: o  reason: collision with root package name */
    public final List<s9.a> f42882o;

    /* renamed from: p  reason: collision with root package name */
    public final List<s9.a> f42883p;

    /* renamed from: q  reason: collision with root package name */
    public m f42884q;

    /* renamed from: r  reason: collision with root package name */
    public i6.g f42885r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f42886s;

    /* renamed from: t  reason: collision with root package name */
    public final List<s9.a> f42887t;

    /* renamed from: u  reason: collision with root package name */
    public final List<CommonPopListItem> f42888u;

    /* renamed from: v  reason: collision with root package name */
    public final CommonListPopupDialog f42889v;

    /* renamed from: w  reason: collision with root package name */
    public final Handler f42890w;

    /* renamed from: x  reason: collision with root package name */
    public C2CMarketDepthListener f42891x;

    /* renamed from: y  reason: collision with root package name */
    public a.d f42892y;

    /* renamed from: z  reason: collision with root package name */
    public b.a f42893z;

    /* renamed from: com.huobi.c2c.lend.a$a  reason: collision with other inner class name */
    public class C0562a implements CommonPopListItem.a {
        public C0562a() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            a.this.f42889v.dismiss();
            if (commonPopListItem.getType() != a.this.A) {
                v7.b.a().r(false, a.this.f42872e, a.this.g0(), a.this.f42891x);
                i6.d.b("c2c_socket-->subscribeC2CMarketDepth-->false");
                a.this.f42887t.clear();
                a.this.x0();
                int unused = a.this.A = commonPopListItem.getType();
                a.this.w0(true, 0);
            }
            a.this.y0();
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return a.this.A == commonPopListItem.getType();
        }
    }

    public class b extends q6.b<Object> {
        public b(u6.g gVar) {
            super(gVar);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (String.valueOf(1003).equals(aPIStatusErrorException.getErrCode())) {
                HuobiToastUtil.j(R.string.common_tips_server_error);
            } else {
                super.onFailed(aPIStatusErrorException);
            }
        }

        public void onRequestSuccess(Object obj) {
            super.onRequestSuccess(obj);
            HuobiToastUtil.s(R.string.string_order_cancel_ok);
            if (isAlive()) {
                a.this.f42885r.d();
                a.this.f42885r.c();
            }
        }
    }

    public class c extends q6.a<Object> {
        public c(u6.g gVar) {
            super(gVar);
        }

        public void onRequestSuccess(Object obj) {
            if (isAlive()) {
                a.this.f42885r.d();
                a.this.f42885r.c();
            }
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                a.this.v0();
                if (a.this.l0()) {
                    a.this.f42890w.sendEmptyMessageDelayed(1, 15000);
                }
            } else if (i11 == 2) {
                a.this.d0(((Boolean) message.obj).booleanValue());
            }
        }
    }

    public class e implements BaseDialogFragment.c {
        public e() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            a.this.f42871d.B(true, false);
        }

        public void onDialogFragmentResume() {
            a.this.f42871d.B(true, true);
        }
    }

    public class f extends q6.a<C2CLoanBalanceInfo> {
        public f(u6.g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(C2CLoanBalanceInfo c2CLoanBalanceInfo) {
            i6.d.b("C2CLendTradeView-->requestC2CLoanBalance-->" + c2CLoanBalanceInfo);
            C2CLoanBalanceInfo unused = a.this.f42876i = c2CLoanBalanceInfo;
            a.this.f42873f.e(false);
            a.this.Z("mC2CLoanBalanceRequester");
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            i6.d.f("C2CLendTradeView-->requestC2CLoanBalance-->", th2);
            a.this.f42873f.e(false);
            a.this.Z("mC2CLoanBalanceRequester");
        }
    }

    public class g extends q6.a<Object> {
        public g(u6.g gVar, boolean z11) {
            super(gVar, z11);
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            i6.d.f("C2CLendTradeView-->requestAvailable-->", th2);
            a.this.f42874g.e(false);
            a.this.Z("mAvailableRequester");
        }

        public void onRequestSuccess(Object obj) {
            a.this.f42871d.setAvailable(a.this.f42878k);
            a.this.f42874g.e(false);
            a.this.Z("mAvailableRequester");
        }
    }

    public class h extends q6.a<List<C2CLoanOrderBean>> {
        public h(u6.g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(List<C2CLoanOrderBean> list) {
            i6.d.b("C2CLendTradeView-->requestOrders-->" + list);
            a.this.f42882o.clear();
            for (C2CLoanOrderBean aVar : list) {
                a.this.f42882o.add(new oi.a(aVar, a.this));
            }
            if (a.this.f42886s) {
                a.this.f42871d.setOrderList(a.this.f42882o);
            }
            a.this.f42875h.e(false);
            a.this.Z("mOrderRequester");
            a.this.h0().dismissProgressDialog();
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            i6.d.f("C2CLendTradeView-->requestOrders-->", th2);
            a.this.f42875h.e(false);
            a.this.Z("mOrderRequester");
            a.this.h0().dismissProgressDialog();
        }
    }

    public class i extends q6.a<List<C2CLoanOrderBean>> {
        public i(u6.g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(List<C2CLoanOrderBean> list) {
            i6.d.b("C2CLendTradeView-->requestHistoryOrders-->" + list);
            a.this.f42883p.clear();
            for (C2CLoanOrderBean next : list) {
                if (a.F.contains(next.getState())) {
                    C2CLendOrderHistoryItem c2CLendOrderHistoryItem = new C2CLendOrderHistoryItem(next, a.this);
                    c2CLendOrderHistoryItem.setId(next.getId());
                    c2CLendOrderHistoryItem.setCurrency(next.getCurrency());
                    c2CLendOrderHistoryItem.setState(next.getState());
                    c2CLendOrderHistoryItem.setDisplayAmount(i6.m.m(next.getAmount(), o.a()));
                    c2CLendOrderHistoryItem.setDisplayInterestRate(i6.m.Q(next.getInterestRate(), o.e(), 1));
                    long term = next.getTerm() / Period.DAY_MILLS;
                    Locale locale = Locale.US;
                    String string = a.this.f42870c.getString(R.string.n_c2c_lend_days);
                    c2CLendOrderHistoryItem.setDisplayTerm(String.format(locale, string, new Object[]{term + ""}));
                    c2CLendOrderHistoryItem.setDisplayActualIncome(i6.m.m(next.getActualIncome(), o.d(next.getCurrency())));
                    c2CLendOrderHistoryItem.setDisplayFilledAmount(i6.m.m(next.getFilledAmount(), o.a()));
                    c2CLendOrderHistoryItem.setDisplayReturnedAmount(i6.m.m(next.getReturnedAmount(), o.a()));
                    c2CLendOrderHistoryItem.setDisplayDate(DateTimeUtils.C(next.getCreatedAt()));
                    a.this.f42883p.add(c2CLendOrderHistoryItem);
                }
            }
            if (!a.this.f42886s) {
                a.this.f42871d.setOrderList(a.this.f42883p);
            }
            a.this.f42875h.e(false);
            a.this.Z("mHistoryOrderRequester");
            a.this.h0().dismissProgressDialog();
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            i6.d.f("C2CLendTradeView-->requestHistoryOrders-->", th2);
            a.this.f42875h.e(false);
            a.this.Z("mHistoryOrderRequester");
            a.this.h0().dismissProgressDialog();
        }
    }

    public class j extends q6.b<Object> {
        public j(u6.g gVar) {
            super(gVar);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (String.valueOf(40311).equals(aPIStatusErrorException.getErrCode())) {
                if (isAlive()) {
                    C2CDialogUtil.w(a.this.f42870c);
                }
            } else if (String.valueOf(1003).equals(aPIStatusErrorException.getErrCode())) {
                HuobiToastUtil.j(R.string.common_tips_server_error);
            } else {
                super.onFailed(aPIStatusErrorException);
            }
        }

        public void onRequestSuccess(Object obj) {
            super.onRequestSuccess(obj);
            a.this.f42871d.w();
            HuobiToastUtil.s(R.string.string_order_op_ok);
            if (isAlive()) {
                a.this.f42885r.d();
                a.this.f42885r.c();
            }
        }
    }

    public class k extends C2CMarketDepthListener {
        public k() {
        }

        /* renamed from: j */
        public void f(C2CMarketDepthResponse c2CMarketDepthResponse) {
            String str;
            if (a.this.isCanBeSeen() && !TextUtils.isEmpty(c2CMarketDepthResponse.getCurrency()) && c2CMarketDepthResponse.getCurrency().equals(a.this.f42872e) && c2CMarketDepthResponse.getTerm() == a.this.g0()) {
                List list = (List) c2CMarketDepthResponse.getData();
                i6.d.b("C2CLendConfirmDialog-->mC2CMarketDepthListener-->" + list);
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        List list2 = (List) list.get(i11);
                        String str2 = null;
                        try {
                            str = (String) list2.get(0);
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            str = null;
                        }
                        try {
                            str2 = (String) list2.get(1);
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                        arrayList.add(new oi.b(i11, str, str2, a.this.f42893z));
                    }
                }
                a.this.f42887t.clear();
                a.this.f42887t.addAll(arrayList);
                a.this.x0();
            }
        }
    }

    public class l implements b.a {
        public l() {
        }

        public void a(oi.b bVar) {
            String q11 = !TextUtils.isEmpty(bVar.f()) ? i6.m.q(i6.m.a(bVar.f()).multiply(i6.m.a("100")), o.e()) : "";
            a.this.f42871d.setBestBtnSelected(false);
            a.this.f42871d.x(q11, true);
            a.this.f42868a.hideKeyboard();
        }
    }

    public interface m {
    }

    static {
        C2COrderState[] c2COrderStateArr = {C2COrderState.FILLED, C2COrderState.PARTICAL_CANCELED, C2COrderState.PARTICAL_FILLED};
        E = c2COrderStateArr;
        for (C2COrderState c2COrderState : c2COrderStateArr) {
            F.add(c2COrderState.state);
        }
    }

    public a(FragmentActivity fragmentActivity, String str, zs.b bVar, m mVar) {
        this(fragmentActivity, str, bVar, false, mVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0() {
        if (this.f42880m != null) {
            w0(true, 0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String o0(Map map) {
        if (map != null) {
            return (String) map.get(this.f42872e);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean p0(C2CLendThresholdGetAssetInfo c2CLendThresholdGetAssetInfo, String str) {
        i6.d.b("C2CLendTradeView-->requestAvailable--> available:" + str + " info:" + c2CLendThresholdGetAssetInfo);
        this.f42877j = c2CLendThresholdGetAssetInfo;
        if (!(c2CLendThresholdGetAssetInfo == null || str == null)) {
            BigDecimal subtract = i6.m.a(c2CLendThresholdGetAssetInfo.getMaxLendAmount()).subtract(i6.m.a(this.f42877j.getLendedAmount()));
            BigDecimal a11 = i6.m.a(str);
            if (subtract.compareTo(a11) > 0) {
                this.f42878k = a11.toPlainString();
            } else {
                this.f42878k = subtract.toPlainString();
            }
        }
        this.f42874g.e(false);
        return Boolean.TRUE;
    }

    public final void X() {
        this.f42889v.setDialogFragmentListener(new e());
    }

    public final void Y() {
        this.f42885r = new i6.g(this);
    }

    public final void Z(String str) {
        d9.a<C2CLoanBalanceInfo> aVar = this.f42873f;
        boolean z11 = true;
        boolean z12 = aVar == null || !aVar.c();
        d9.a<Object> aVar2 = this.f42874g;
        boolean z13 = aVar2 == null || !aVar2.c();
        d9.a<List<C2CLoanOrderBean>> aVar3 = this.f42875h;
        if (aVar3 != null && aVar3.c()) {
            z11 = false;
        }
        i6.d.b("checkToResetRefresh--> tag:" + str + " isBalanceOk:" + z12 + " isAvailableOk:" + z13 + " isOrderOk:" + z11);
        this.D = false;
        s0();
    }

    public void a() {
        HBBaseWebActivity.showWebView(this.f42870c, d1.b(), "", "", false);
    }

    /* renamed from: a0 */
    public void n0(C2CLoanOrderBean c2CLoanOrderBean, CommonSwitchButton commonSwitchButton) {
        h0().showProgressDialog();
        v7.b.a().Q0(c2CLoanOrderBean.getId(), commonSwitchButton.isChecked() ^ true ? 1 : 0).d(new c(this.f42869b));
    }

    public boolean b() {
        if (!r.x().F0()) {
            sn.f.f(TradeType.C2C_LEND, this.f42870c);
            return true;
        }
        if (h0() != null) {
            h0().z8(false, true);
        }
        return false;
    }

    public final void b0(String str, int i11, String str2) {
        if (r.x().F0()) {
            String str3 = str2;
            String str4 = str;
            int i12 = i11;
            v7.b.a().B0(str3, str4, i12, this.f42872e, this.f42871d.o() ? 1 : 0, this.f42871d.p() ? 1 : 0).d(new j(h0()));
        }
    }

    public void c(boolean z11) {
        if (this.f42886s != z11) {
            this.f42886s = z11;
            this.f42871d.A(z11);
            if (z11) {
                this.f42871d.setOrderList(this.f42882o);
            } else {
                this.f42871d.setOrderList(this.f42883p);
            }
            v0();
        }
    }

    public final void c0() {
        if (!this.f42881n) {
            u0();
            t0();
            v0();
        }
    }

    public void d(boolean z11) {
        if (z11) {
            C2CDialogUtil.i(this.f42870c, (c6.a) null);
        }
    }

    public final void d0(boolean z11) {
        boolean isCanBeSeen = isCanBeSeen();
        boolean e11 = v7.b.a().e();
        i6.d.b("c2c_socket-->doSocketSub--> isCanBeSeen:" + isCanBeSeen + " socketAlive:" + e11 + " isSub:" + z11);
        if (!isCanBeSeen || !z11) {
            v7.b.a().r(false, this.f42872e, g0(), this.f42891x);
        } else if (e11) {
            v7.b.a().r(true, this.f42872e, g0(), this.f42891x);
        } else {
            w0(true, 100);
        }
    }

    public void e() {
        String str;
        if (r.x().F0()) {
            int g02 = g0();
            if (TextUtils.isEmpty(this.f42872e) || g02 <= 0) {
                HuobiToastUtil.g(R.string.common_tips_server_error);
                return;
            }
            if (!this.f42871d.p()) {
                BigDecimal a11 = i6.m.a(this.f42871d.getRateText());
                if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.g(R.string.c_to_c_please_input_right_rate);
                    return;
                } else {
                    str = a11.divide(i6.m.a("100"), o.b(), 1).toPlainString();
                }
            } else {
                str = "";
            }
            String amountText = this.f42871d.getAmountText();
            if (i6.m.a(amountText).compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.g(R.string.c_to_c_please_input_amount);
            } else if (n.d()) {
                b0(str, g02, amountText);
            } else {
                n.h(this.f42870c, h0());
            }
        } else {
            sn.f.f(TradeType.C2C_LEND, this.f42870c);
            is.a.j("4250", (Map<String, Object>) null, "1005132");
        }
    }

    public String e0() {
        return this.f42872e;
    }

    public void f(C2CLoanOrderBean c2CLoanOrderBean, CommonSwitchButton commonSwitchButton) {
        if (commonSwitchButton.isChecked()) {
            n0(c2CLoanOrderBean, commonSwitchButton);
        } else if (!C2CDialogUtil.i(this.f42870c, new mi.b(this, c2CLoanOrderBean, commonSwitchButton))) {
            n0(c2CLoanOrderBean, commonSwitchButton);
        }
    }

    public C2CLendTradeView2 f0() {
        return this.f42871d;
    }

    public void g(boolean z11) {
    }

    public final int g0() {
        return this.A;
    }

    public void h(View view) {
        if (this.f42870c != null && this.f42888u.size() > 1) {
            this.f42889v.setData(this.f42888u);
            this.f42889v.setFollowViewWidth(true);
            this.f42889v.showAsDropDown(this.f42870c.getSupportFragmentManager(), view);
        }
    }

    public final zs.b h0() {
        return this.f42869b;
    }

    public void i() {
        if (!r.x().F0()) {
            sn.f.f(TradeType.C2C_LEND, this.f42870c);
        } else if (!TextUtils.isEmpty(this.f42872e)) {
            this.f42871d.k();
            this.f42879l.vh(this.f42872e);
            this.f42879l.uh(this.f42876i);
            this.f42879l.th(this.f42877j);
            this.f42879l.show(this.f42870c.getSupportFragmentManager(), "C2CLendIncomeDetail");
        }
    }

    public final void i0() {
        boolean z11;
        C2CCurrencyBean c2CCurrencyBean = this.f42880m;
        if (c2CCurrencyBean != null) {
            List<Integer> termDayConfigs = c2CCurrencyBean.getTermDayConfigs();
            if (termDayConfigs == null || termDayConfigs.isEmpty()) {
                this.A = 0;
                return;
            }
            Iterator<Integer> it2 = termDayConfigs.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().intValue() == this.A) {
                        z11 = true;
                        break;
                    }
                } else {
                    z11 = false;
                    break;
                }
            }
            if (!z11) {
                this.A = termDayConfigs.get(0).intValue();
            }
        }
    }

    public boolean isCanBeSeen() {
        return h0() != null && h0().isCanBeSeen();
    }

    public void j() {
        this.f42868a.getBoardView().hideKeyboardLayout();
    }

    public final void j0() {
        List<Integer> termDayConfigs;
        this.f42888u.clear();
        C2CCurrencyBean c2CCurrencyBean = this.f42880m;
        if (c2CCurrencyBean != null && (termDayConfigs = c2CCurrencyBean.getTermDayConfigs()) != null) {
            String string = this.f42870c.getResources().getString(R.string.n_c2c_lend_days);
            for (int i11 = 0; i11 < termDayConfigs.size(); i11++) {
                int intValue = termDayConfigs.get(i11).intValue();
                this.f42888u.add(new CommonPopListItem(intValue, String.format(Locale.US, string, new Object[]{String.valueOf(intValue)}), this.C));
            }
        }
    }

    public void k() {
        HBBaseWebActivity.showWebView(this.f42870c, d1.d(), "", "", false);
    }

    public final void k0() {
        this.f42871d = new C2CLendTradeView2(this.f42870c, this.f42872e, this);
        this.f42868a = new HuobiKeyboardHelper().attach(this.f42870c);
    }

    public void l(String str) {
        C2CLoanOrderActivity.Gi(this.f42870c, str, 0);
    }

    public final boolean l0() {
        return this.B;
    }

    public void m(int i11) {
        if (!l0()) {
            this.f42885r.d();
        } else {
            c0();
        }
    }

    public void n(C2CLoanOrderBean c2CLoanOrderBean) {
        v7.b.a().requestC2CLoanOrderCancel(String.valueOf(c2CLoanOrderBean.getId())).d(new b(h0()));
    }

    public void onRefresh() {
        if (r.x().F0()) {
            this.D = true;
            this.f42885r.d();
            c0();
            this.f42890w.postDelayed(new mi.d(this), 15000);
            return;
        }
        this.f42890w.postDelayed(new mi.d(this), 1000);
    }

    public void q0() {
        i6.d.b("C2CLendTradeViewController-->onPause--> mCurrency: " + this.f42872e + " isDefault: " + this.f42881n);
        this.B = false;
        this.f42885r.d();
        this.f42871d.t(this.f42870c);
        this.f42871d.v(true);
        if (this.f42889v.isVisible()) {
            this.f42889v.dismiss();
        }
        if (this.f42879l.isVisible()) {
            this.f42879l.dismiss();
        }
        if (!this.f42881n) {
            v7.b.a().c(this.f42892y);
        }
        if (!this.f42881n && this.f42880m != null) {
            v7.b.a().r(false, this.f42872e, g0(), this.f42891x);
        }
        this.f42890w.removeCallbacksAndMessages((Object) null);
    }

    public void r0() {
        this.B = true;
        this.f42880m = C2CCurrencyProvider.m(this.f42872e);
        i6.d.b("C2CLendTradeViewController-->onResume--> mCurrency: " + this.f42872e + " isDefault: " + this.f42881n + " mCurrencyBean: " + this.f42880m);
        C2CCurrencyBean c2CCurrencyBean = this.f42880m;
        if (c2CCurrencyBean != null) {
            this.f42871d.setLendMinAmount(c2CCurrencyBean.getLoanMinAmount());
        }
        j0();
        if (!this.f42881n && this.f42880m != null) {
            w0(true, 0);
        }
        z0();
        i0();
        y0();
        this.f42887t.clear();
        x0();
        boolean F0 = r.x().F0();
        if (!F0) {
            this.f42878k = null;
            this.f42876i = null;
            this.f42877j = null;
        }
        this.f42871d.u(F0);
        this.f42871d.setAvailable(this.f42878k);
        if (!F0) {
            this.f42882o.clear();
            this.f42883p.clear();
            if (this.f42886s) {
                this.f42871d.setOrderList(this.f42882o);
            } else {
                this.f42871d.setOrderList(this.f42883p);
            }
        }
        c0();
        if (!this.f42881n) {
            this.f42885r.d();
            this.f42885r.c();
        }
        if (!TextUtils.isEmpty(this.f42872e) && F0) {
            this.f42890w.removeMessages(1);
            this.f42890w.sendEmptyMessageDelayed(1, 15000);
        }
        if (this.f42879l.isVisible()) {
            this.f42879l.dismiss();
        }
        if (!this.f42881n) {
            v7.b.a().d(this.f42892y);
        }
    }

    public final void s0() {
        if (isCanBeSeen()) {
            if (this.D) {
                if (!TextUtils.isEmpty(this.f42872e) && r.x().F0()) {
                    this.f42890w.removeMessages(1);
                    this.f42890w.sendEmptyMessageDelayed(1, 15000);
                }
                this.D = false;
            }
            C2CLendTradeView2 c2CLendTradeView2 = this.f42871d;
            if (c2CLendTradeView2 != null) {
                c2CLendTradeView2.v(true);
            }
        }
    }

    public final void t0() {
        if (!this.f42881n && r.x().F0() && !TextUtils.isEmpty(this.f42872e)) {
            i6.d.b("C2CLendTradeView-->requestAvailable-->");
            d9.a<Object> aVar = this.f42874g;
            if (aVar != null) {
                aVar.a();
            }
            d9.a<Object> aVar2 = new d9.a<>(Observable.zip(v7.b.a().requestC2CLendThresholdGetAsset(this.f42872e).b(), h2.t1().y3(TradeType.PRO, false).map(new mi.e(this)), new mi.f(this)));
            this.f42874g = aVar2;
            aVar2.d(new g(h0(), false));
        }
    }

    public final void u0() {
        if (!this.f42881n && r.x().F0() && !TextUtils.isEmpty(this.f42872e)) {
            i6.d.b("C2CLendTradeView-->requestC2CLoanBalance-->");
            d9.a<C2CLoanBalanceInfo> aVar = this.f42873f;
            if (aVar != null) {
                aVar.a();
            }
            d9.a<C2CLoanBalanceInfo> c2CLoanBalance = v7.b.a().getC2CLoanBalance(this.f42872e);
            this.f42873f = c2CLoanBalance;
            c2CLoanBalance.d(new f(h0(), false));
        }
    }

    public final void v0() {
        if (!this.f42881n && r.x().F0() && !TextUtils.isEmpty(this.f42872e) && l0()) {
            d9.a<List<C2CLoanOrderBean>> aVar = this.f42875h;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f42886s) {
                i6.d.b("C2CLendTradeView-->requestOrders1--> isCurrentOrder" + this.f42886s + " mCurrency" + this.f42872e);
                d9.a<List<C2CLoanOrderBean>> l02 = v7.b.a().l0(0, C2CloanOrderDirect.NEXT, 10, this.f42872e);
                this.f42875h = l02;
                l02.d(new h(h0(), false));
                return;
            }
            i6.d.b("C2CLendTradeView-->requestHistoryOrders-->");
            d9.a<List<C2CLoanOrderBean>> I = v7.b.a().I(0, C2CloanOrderDirect.NEXT, 10, this.f42872e);
            this.f42875h = I;
            I.d(new i(h0(), false));
        }
    }

    public final void w0(boolean z11, long j11) {
        if (!this.f42881n) {
            this.f42890w.removeMessages(2);
            Message message = new Message();
            message.what = 2;
            message.obj = Boolean.valueOf(z11);
            this.f42890w.sendMessageDelayed(message, j11);
        }
    }

    public final void x0() {
        int size = this.f42887t.size();
        if (size < 13) {
            for (int i11 = 0; i11 < 13 - size; i11++) {
                this.f42887t.add(new oi.b(0, (String) null, (String) null, (b.a) null));
            }
        }
        this.f42871d.setRateList(this.f42887t);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (r0.size() > 1) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y0() {
        /*
            r6 = this;
            com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean r0 = r6.f42880m
            r1 = 1
            r2 = 0
            java.lang.String r3 = "--"
            if (r0 == 0) goto L_0x0038
            int r0 = r6.g0()
            if (r0 <= 0) goto L_0x0029
            androidx.fragment.app.FragmentActivity r3 = r6.f42870c
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2132020356(0x7f140c84, float:1.9679073E38)
            java.lang.String r3 = r3.getString(r4)
            java.util.Locale r4 = java.util.Locale.US
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r5[r2] = r0
            java.lang.String r3 = java.lang.String.format(r4, r3, r5)
        L_0x0029:
            com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean r0 = r6.f42880m
            java.util.List r0 = r0.getTermConfigs()
            if (r0 == 0) goto L_0x0038
            int r0 = r0.size()
            if (r0 <= r1) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = r2
        L_0x0039:
            com.huobi.c2c.lend.view.C2CLendTradeView2 r0 = r6.f42871d
            r0.setPeriod(r3)
            com.huobi.c2c.lend.view.C2CLendTradeView2 r0 = r6.f42871d
            r0.B(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.c2c.lend.a.y0():void");
    }

    public final void z0() {
        String str;
        String string = this.f42870c.getResources().getString(R.string.n_c2c_lend_out_range);
        C2CCurrencyBean c2CCurrencyBean = this.f42880m;
        if (c2CCurrencyBean != null) {
            String str2 = null;
            String Q = !TextUtils.isEmpty(c2CCurrencyBean.getMinInterestRate()) ? i6.m.Q(this.f42880m.getMinInterestRate(), o.e(), 1) : null;
            if (!TextUtils.isEmpty(this.f42880m.getMaxInterestRate())) {
                str2 = i6.m.Q(this.f42880m.getMaxInterestRate(), o.e(), 1);
            }
            if (!(Q == null || str2 == null)) {
                str = Q + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2;
                this.f42871d.setRange(string + " " + str);
            }
        }
        str = "--";
        this.f42871d.setRange(string + " " + str);
    }

    public a(FragmentActivity fragmentActivity, String str, zs.b bVar, boolean z11, m mVar) {
        this.f42879l = new C2CLendIncomeDetailDialog();
        this.f42882o = new ArrayList();
        this.f42883p = new ArrayList();
        this.f42886s = true;
        this.f42887t = new ArrayList();
        this.f42888u = new ArrayList();
        this.f42889v = new CommonListPopupDialog();
        this.f42890w = new d(Looper.getMainLooper());
        this.f42891x = new k();
        this.f42892y = new mi.c(this);
        this.f42893z = new l();
        this.C = new C0562a();
        this.f42869b = bVar;
        this.f42870c = fragmentActivity;
        this.f42872e = str;
        this.f42884q = mVar;
        this.f42881n = z11;
        k0();
        X();
        Y();
    }
}
