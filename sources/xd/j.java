package xd;

import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineFixInfo;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.response.KLineResponse;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import com.hbg.lib.network.retrofit.websocket.bean.SocketReportBean;
import com.hbg.module.kline.KlineReqConfig;
import g9.a;
import i6.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import u6.g;
import xd.a;

public class j extends a {

    /* renamed from: f  reason: collision with root package name */
    public Subscription f26344f;

    /* renamed from: g  reason: collision with root package name */
    public f f26345g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f26346h = new a();

    /* renamed from: i  reason: collision with root package name */
    public KLineListener f26347i = new b();

    /* renamed from: j  reason: collision with root package name */
    public a.d f26348j = new h(this);

    /* renamed from: k  reason: collision with root package name */
    public LastKlineListener f26349k = new c();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            i.b().h(this);
            f fVar = j.this.f26345g;
            if (fVar != null) {
                fVar.A(false);
            }
        }
    }

    public class b extends KLineListener {
        public b() {
        }

        /* renamed from: j */
        public void f(KLineResponse kLineResponse) {
            j jVar = j.this;
            if (jVar.f26337e) {
                f fVar = jVar.f26345g;
                if (fVar != null) {
                    fVar.A(false);
                }
                List list = (List) kLineResponse.getData();
                if (list == null || list.isEmpty()) {
                    String str = "";
                    try {
                        ISocketSend iSocketSend = this.f70673c;
                        if (iSocketSend != null) {
                            str = iSocketSend.toString();
                        }
                        String kLineResponse2 = kLineResponse.toString();
                        RetrofitLogger.e(new SocketReportBean(this.f70671a, str, kLineResponse2, this.f70672b, SocketReportBean.REQ_RESPONSE_ERROR));
                        RetrofitLogger.h("Socket_error_report", "socket_report-->req 返回数据为空");
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                if (CollectionsUtils.b(list) || !TextUtils.equals(j.this.g().value, kLineResponse.getPeriod()) || !TextUtils.equals(j.this.k1(), kLineResponse.getSymbol())) {
                    j jVar2 = j.this;
                    if (jVar2.f26336d) {
                        jVar2.k();
                        return;
                    }
                    return;
                }
                j jVar3 = j.this;
                if (jVar3.f26336d) {
                    f fVar2 = jVar3.f26345g;
                    if (fVar2 != null) {
                        fVar2.e(list, true);
                    }
                    j.this.k();
                    if (j.this.w()) {
                        j.this.u(list, kLineResponse.getSymbol(), kLineResponse.getPeriod());
                        return;
                    }
                    return;
                }
                list.remove(list.size() - 1);
                f fVar3 = j.this.f26345g;
                if (fVar3 != null) {
                    fVar3.b(list);
                }
            }
        }

        public void onFailed(Throwable th2) {
            super.onFailed(th2);
            f fVar = j.this.f26345g;
            if (fVar != null) {
                fVar.A(false);
            }
        }
    }

    public class c extends LastKlineListener {
        public c() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            KlineInfo tick;
            f fVar;
            if (j.this.f26337e && (tick = lastKlineResponse.getTick()) != null && TextUtils.equals(j.this.f26333a, lastKlineResponse.getSymbol())) {
                Period parsePeriod = Period.parsePeriod(lastKlineResponse.getPeriod());
                i6.d.b("HuobiProKlinePresenter-->onSuccess--> mSymbolId:" + j.this.f26333a + " receivePeriod:" + parsePeriod + " mPeriod:" + j.this.f26334b);
                if (Period.samePeriodValue(parsePeriod, j.this.f26334b) && (fVar = j.this.f26345g) != null) {
                    fVar.d(tick);
                }
            }
        }
    }

    public class d extends BaseSubscriber<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f26353b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f26354c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f26355d;

        public d(String str, String str2, List list) {
            this.f26353b = str;
            this.f26354c = str2;
            this.f26355d = list;
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            wd.a b11 = wd.a.b(BaseApplication.b());
            b11.a(this.f26353b, this.f26354c);
            b11.c(this.f26355d, this.f26353b, this.f26354c);
        }
    }

    public class e extends BaseSubscriber<List<KlineFixInfo>> {
        public e() {
        }

        public void onNext(List<KlineFixInfo> list) {
            super.onNext(list);
            j jVar = j.this;
            if (jVar.f26345g != null && jVar.f26344f != null) {
                HashMap hashMap = new HashMap();
                for (KlineFixInfo next : list) {
                    hashMap.put(Long.valueOf(next.f70629id), next);
                }
                j.this.f26345g.a(hashMap);
            }
        }
    }

    public interface f extends a.C0233a {
        void a(Map<Long, KlineFixInfo> map);

        void b(List<KlineInfo> list);
    }

    public j(f fVar) {
        super(fVar);
        this.f26345g = fVar;
    }

    public static /* synthetic */ Boolean s(List list) {
        return Boolean.valueOf(list != null && list.size() > 0);
    }

    public void c(Period period, boolean z11) {
        t(period, z11);
    }

    public void e(KlineInfo klineInfo) {
        o(klineInfo);
    }

    public void f() {
        super.f();
        r();
    }

    public boolean j(String str, Period period) {
        return super.j(str, period);
    }

    public void o(KlineInfo klineInfo) {
        if (j(this.f26333a, this.f26334b)) {
            x8.a.a().f(this.f26333a, this.f26334b, KlineReqConfig.a(1, this.f26333a, Period.fromSecondTime(this.f26334b, klineInfo.getId(), i())), klineInfo.getId(), this.f26347i);
        }
    }

    public void onPause() {
        super.onPause();
        p();
    }

    public void onResume() {
        super.onResume();
        q();
    }

    public void p() {
        x8.a.a().c(this.f26348j);
        h(this.f26344f);
        this.f26344f = null;
    }

    public void q() {
        x8.a.a().d(this.f26348j);
    }

    public void r() {
        if (j(this.f26333a, this.f26334b)) {
            long fromSecondTime = Period.fromSecondTime(this.f26334b, i());
            x8.a.a().f(this.f26333a, this.f26334b, KlineReqConfig.a(1, this.f26333a, fromSecondTime), System.currentTimeMillis() / 1000, this.f26347i);
            v(ConfigPreferences.c("user_config", "KLINE_CONFIG_FIXY_SWITCH", true));
            i.b().g(this.f26346h, DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
            return;
        }
        f fVar = this.f26345g;
        if (fVar != null) {
            fVar.A(false);
        }
    }

    public void t(Period period, boolean z11) {
        if (j(this.f26333a, period)) {
            x8.a.a().g(z11, this.f26333a, period, this.f26349k);
        }
    }

    public final void u(List<KlineInfo> list, String str, String str2) {
        Observable.just(0).observeOn(Schedulers.io()).subscribe(new d(str, str2, list));
    }

    public void v(boolean z11) {
        h(this.f26344f);
        this.f26344f = null;
        if (!z11) {
            f fVar = this.f26345g;
            if (fVar != null) {
                fVar.a((Map<Long, KlineFixInfo>) null);
            }
        } else if (j(this.f26333a, this.f26334b)) {
            this.f26344f = x8.a.a().getKlineFixInfo(this.f26333a, this.f26334b.value).b().filter(i.f61534b).compose(RxJavaHelper.t((g) null)).subscribe(new e());
        }
    }

    public boolean w() {
        return true;
    }
}
