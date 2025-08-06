package qu;

import android.app.Activity;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.gson.Gson;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.bean.BaseSettingBean;
import com.hbg.lib.network.otc.core.bean.CountryNameBean;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.network.otc.core.bean.OtcBalanceConfigInfo;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcCountryNameListInfo;
import com.hbg.lib.network.otc.core.bean.OtcNewUserTradeGuide;
import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lite.network.LiteRequestCallback1;
import com.hbg.module.otc.OtcModuleConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;
import jp.c1;
import jp.h0;
import jp.l;
import nb.g;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class d {

    /* renamed from: f  reason: collision with root package name */
    public static volatile d f23314f = new d();

    /* renamed from: a  reason: collision with root package name */
    public String f23315a = "otc-wss.huobi.com";

    /* renamed from: b  reason: collision with root package name */
    public BaseSettingBean f23316b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23317c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f23318d;

    /* renamed from: e  reason: collision with root package name */
    public OTCStatusExtendResponse<MktRuleBean> f23319e;

    public class a extends BaseSubscriber<Object> {
        public a() {
        }

        public void onNext(Object obj) {
            d.this.f23318d = true;
            boolean unused = d.this.f23317c = true;
            d.this.q();
            d.this.r();
            g.j().x(true, (g.c) null);
            d.this.u();
            d.this.v();
        }
    }

    public class b extends RequestCallback1<OTCStatusExtendResponse<MktRuleBean>> {
        public b() {
        }

        /* renamed from: a */
        public void onRequestSuccess(OTCStatusExtendResponse<MktRuleBean> oTCStatusExtendResponse) {
            if (oTCStatusExtendResponse == null || !oTCStatusExtendResponse.isSuccess() || oTCStatusExtendResponse.getData() == null) {
                l.I((MktRuleBean) null);
            } else {
                l.I(oTCStatusExtendResponse.getData());
            }
        }

        public void onRequestFailure(Throwable th2) {
            l.I((MktRuleBean) null);
        }
    }

    public class c extends RequestCallback1<OTCStatusExtendResponse<MktRuleBean>> {
        public c() {
        }

        /* renamed from: a */
        public void onRequestSuccess(OTCStatusExtendResponse<MktRuleBean> oTCStatusExtendResponse) {
            OTCStatusExtendResponse unused = d.this.f23319e = oTCStatusExtendResponse;
            EventBus.d().n(new OtcNewUserTradeGuide());
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            OTCStatusExtendResponse unused = d.this.f23319e = null;
            EventBus.d().n(new OtcNewUserTradeGuide());
        }
    }

    /* renamed from: qu.d$d  reason: collision with other inner class name */
    public class C0208d extends RequestCallback1<BaseSettingBean> {
        public C0208d() {
        }

        /* renamed from: a */
        public void onRequestSuccess(BaseSettingBean baseSettingBean) {
            BaseSettingBean unused = d.this.f23316b = baseSettingBean;
            if (d.this.f23316b != null && !TextUtils.isEmpty(d.this.f23316b.getWsBaseUrl())) {
                d dVar = d.this;
                dVar.w(dVar.f23316b.getWsBaseUrl());
            }
        }

        /* renamed from: b */
        public BaseSettingBean onRequestSuccessAsync(BaseSettingBean baseSettingBean) {
            if (baseSettingBean != null) {
                try {
                    if (!TextUtils.isEmpty(baseSettingBean.getBalanceTradeConfig())) {
                        baseSettingBean.setBalanceTradeConfigObj((OtcBalanceConfigInfo) new Gson().fromJson(baseSettingBean.getBalanceTradeConfig(), OtcBalanceConfigInfo.class));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (baseSettingBean != null) {
                try {
                    if (!TextUtils.isEmpty(baseSettingBean.getCountryLocalName())) {
                        OtcCountryNameListInfo otcCountryNameListInfo = (OtcCountryNameListInfo) new Gson().fromJson(baseSettingBean.getCountryLocalName(), OtcCountryNameListInfo.class);
                        if (otcCountryNameListInfo != null) {
                            baseSettingBean.setCountryNameData(otcCountryNameListInfo.getCountryNameData());
                        }
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            return (BaseSettingBean) super.onRequestSuccessAsync(baseSettingBean);
        }
    }

    public class e extends LiteRequestCallback1<OtcConfigBean> {
        public e() {
        }

        /* renamed from: b */
        public void onRequestSuccess(OtcConfigBean otcConfigBean) {
        }

        /* renamed from: c */
        public OtcConfigBean onRequestSuccessAsync(OtcConfigBean otcConfigBean) {
            otcConfigBean.setVersion(System.currentTimeMillis());
            va.b.o().D(otcConfigBean);
            return (OtcConfigBean) super.onRequestSuccessAsync(otcConfigBean);
        }

        public void onRequestFailure(Throwable th2) {
        }
    }

    public class f extends RequestCallback1<Boolean> {
        public f() {
        }

        /* renamed from: a */
        public void onRequestSuccess(Boolean bool) {
        }

        public void onRequestFailure(Throwable th2) {
            if (th2 instanceof APIStatusErrorException) {
                HashMap hashMap = new HashMap();
                hashMap.put("api_code", ((APIStatusErrorException) th2).getErrCode());
                hashMap.put("api_path", "/fiat/fast/base/config");
                uf.c.b().m("otc_config_failed", "", hashMap);
            } else if ((th2 instanceof IOException) || (th2 instanceof TimeoutException)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("api_path", "/fiat/fast/base/config");
                uf.c.b().m("api_config_timeout", "", hashMap2);
            }
        }
    }

    public static d i() {
        return f23314f;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String o(Boolean bool) {
        if (this.f23318d) {
            return "";
        }
        c1.h();
        g.j();
        va.b.o();
        return "";
    }

    public static /* synthetic */ Boolean p(QuickTradeConfigBean quickTradeConfigBean) {
        if (quickTradeConfigBean != null) {
            c1.h().m(quickTradeConfigBean);
        }
        return Boolean.TRUE;
    }

    public BaseSettingBean g() {
        return this.f23316b;
    }

    public String h(int i11, String str) {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return str;
        }
        String j11 = j(i11);
        if (TextUtils.isEmpty(j11) || TextUtils.isEmpty(str) || str.toLowerCase().contains(j11.toLowerCase())) {
            return str;
        }
        return str + "(" + j11 + ")";
    }

    public final String j(int i11) {
        BaseSettingBean baseSettingBean = this.f23316b;
        if (baseSettingBean == null || baseSettingBean.getCountryNameData() == null || this.f23316b.getCountryNameData().isEmpty()) {
            return null;
        }
        for (CountryNameBean next : this.f23316b.getCountryNameData()) {
            if (next.getCountry_id() == i11) {
                return next.getName();
            }
        }
        return null;
    }

    public final void k() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("factor", new MapParamsBuilder().a("appPageId", "14").a("eventId", "1402").b());
        arrayList.add(hashMap);
        new HashMap().put("list", arrayList);
        s8.a.a().bindCardMktRule(hashMap).d(new c());
    }

    public String l() {
        String str;
        String host = OtcRetrofit.g().getHost();
        if (host.startsWith(Constants.SCHEME)) {
            str = "wss" + host.replaceFirst(Constants.SCHEME, "");
        } else {
            str = "wss://" + host;
        }
        if (str.endsWith("/")) {
            return str + "wps";
        }
        return str + "/wps";
    }

    public boolean m() {
        return this.f23317c;
    }

    public boolean n() {
        OTCStatusExtendResponse<MktRuleBean> oTCStatusExtendResponse = this.f23319e;
        return (oTCStatusExtendResponse == null || oTCStatusExtendResponse.getExtend() == null || !this.f23319e.getExtend().isCanPartakeDepositActivity()) ? false : true;
    }

    public void q() {
        s8.a.a().loadApolloConfig().d(new C0208d());
    }

    public void r() {
        va.b.o().r().setVersion(System.currentTimeMillis());
        s8.a.a().d().d(new e());
    }

    public void s(boolean z11) {
        this.f23319e = null;
        if (z11 && h0.c().e()) {
            k();
        }
        Activity b11 = oa.a.g().b();
        if (b11 != null && z11) {
            OtcModuleConfig.a().E(b11, true);
        }
    }

    public void t() {
        Observable.just(Boolean.valueOf(this.f23318d)).map(new b(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public void u() {
        HashMap hashMap = new HashMap();
        hashMap.put("factor", new MapParamsBuilder().a("appPageId", "40").a("eventId", 401).b());
        s8.a.a().bindCardMktRule(hashMap).d(new b());
    }

    public void v() {
        new d9.a(s8.a.a().getExpressConfig().b().map(c.f70491b)).d(new f());
    }

    public void w(String str) {
        this.f23315a = str;
    }
}
