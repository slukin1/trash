package com.huobi.otc.persenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.internal.LinkedTreeMap;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.bean.WebViewLoadFailedEvent;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.OTCStatusStringExtendResponse;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.network.otc.core.bean.MktRulePageBean;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcNewUserTradeGuide;
import com.hbg.lib.network.otc.core.bean.OtcTokenUpdate;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.network.uc.retrofit.UcRetrofit;
import com.hbg.lib.network.uc.retrofit.service.UserCenterService;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.OtcBannerBean;
import com.huobi.otc.bean.ReminderData;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.event.JumpOtcTradeAreaEvent;
import com.huobi.otc.event.OtcNewOrderTipOpenEvent;
import com.huobi.otc.event.OtcRefreshMessageEvent;
import com.huobi.otc.helper.OtcNewOrderTipHelper;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.widget.OtcOrderReminder;
import com.huobi.otc.widget.OtcTradeBannerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.h0;
import jp.l;
import jp.m;
import nb.g;
import okhttp3.HttpUrl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import up.x;

public class OtcTradePresenter extends ActivityPresenter<i> {

    /* renamed from: m  reason: collision with root package name */
    public static boolean f79127m;

    /* renamed from: a  reason: collision with root package name */
    public Map<OtcTradeAreaEnum, List<OtcBannerBean>> f79128a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public String f79129b = "USDT";

    /* renamed from: c  reason: collision with root package name */
    public OtcTradeChatNumP f79130c;

    /* renamed from: d  reason: collision with root package name */
    public UserSecurityInfoData f79131d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<OtcTradeAreaEnum, MktRuleBean> f79132e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public MktRuleBean f79133f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f79134g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f79135h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f79136i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f79137j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f79138k;

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f79139l;

    public class a extends OtcTradeChatNumP {
        public a() {
        }

        public String r() {
            return ((i) OtcTradePresenter.this.getUI()).R0();
        }

        public u6.g s() {
            return (u6.g) OtcTradePresenter.this.getUI();
        }

        public void v(int i11) {
            ((i) OtcTradePresenter.this.getUI()).o2(i11);
        }
    }

    public class b extends BaseSubscriber<OtcConfigBean> {
        public b() {
        }
    }

    public class c extends q6.a<List<MktRuleBean>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtcTradeAreaEnum f79142a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(u6.g gVar, OtcTradeAreaEnum otcTradeAreaEnum) {
            super(gVar);
            this.f79142a = otcTradeAreaEnum;
        }

        /* renamed from: a */
        public void onRequestSuccess(List<MktRuleBean> list) {
            if (OtcTradePresenter.this.getUI() != null && ((i) OtcTradePresenter.this.getUI()).isAlive()) {
                if (list == null || list.isEmpty()) {
                    OtcTradePresenter.this.f79132e.put(this.f79142a, (Object) null);
                    ((i) OtcTradePresenter.this.getUI()).md(this.f79142a, (MktRuleBean) null);
                    return;
                }
                boolean z11 = false;
                for (MktRuleBean next : list) {
                    if (next != null) {
                        if (44785702 == next.getEventId()) {
                            z11 = true;
                            OtcTradePresenter.this.f79132e.put(this.f79142a, next);
                            ((i) OtcTradePresenter.this.getUI()).md(this.f79142a, next);
                        } else if (507 == next.getEventId() && !OtcTradePresenter.f79127m && !TextUtils.isEmpty(next.getImage())) {
                            MktRuleBean unused = OtcTradePresenter.this.f79133f = next;
                            if (!OtcTradePresenter.f79127m) {
                                ((i) OtcTradePresenter.this.getUI()).u6(OtcTradePresenter.this.f79133f);
                            }
                        }
                    }
                }
                if (!z11) {
                    OtcTradePresenter.this.f79132e.put(this.f79142a, (Object) null);
                    ((i) OtcTradePresenter.this.getUI()).md(this.f79142a, (MktRuleBean) null);
                }
            }
        }

        public void onError2(Throwable th2) {
            OtcTradePresenter.this.f79132e.put(this.f79142a, (Object) null);
            ((i) OtcTradePresenter.this.getUI()).md(this.f79142a, (MktRuleBean) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            OtcTradePresenter.this.f79132e.put(this.f79142a, (Object) null);
            ((i) OtcTradePresenter.this.getUI()).md(this.f79142a, (MktRuleBean) null);
        }
    }

    public class d extends BaseSubscriber<UserSecurityInfoData> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(UserSecurityInfoData userSecurityInfoData) {
            super.onNext(userSecurityInfoData);
            if (userSecurityInfoData != null) {
                UserSecurityInfoData unused = OtcTradePresenter.this.f79131d = userSecurityInfoData;
            }
        }
    }

    public class e extends q6.b<OTCStatusExtendResponse<MktRuleBean>> {
        public e(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: a */
        public void onRequestSuccess(OTCStatusExtendResponse<MktRuleBean> oTCStatusExtendResponse) {
            super.onRequestSuccess(oTCStatusExtendResponse);
            if (oTCStatusExtendResponse != null) {
                boolean z11 = false;
                String content = oTCStatusExtendResponse.getData() != null ? oTCStatusExtendResponse.getData().getContent() : "";
                if (oTCStatusExtendResponse.getExtend() != null) {
                    String kycStatusOfT2 = oTCStatusExtendResponse.getExtend().getKycStatusOfT2();
                    if (TextUtils.equals(kycStatusOfT2, OTCStatusExtendResponse.ExtendBean.KYC_STATUS_OF_T2_FAIL)) {
                        HuobiToastUtil.m(OtcTradePresenter.this.getString(R$string.n_check_network));
                        return;
                    }
                    Boolean kycForbidden = oTCStatusExtendResponse.getExtend().getKycForbidden();
                    if (kycForbidden == null || !kycForbidden.booleanValue()) {
                        Boolean kycIdExpired = oTCStatusExtendResponse.getExtend().getKycIdExpired();
                        if (kycIdExpired != null && kycIdExpired.booleanValue()) {
                            ((i) OtcTradePresenter.this.getUI()).n9(oTCStatusExtendResponse.getData().getTitle(), oTCStatusExtendResponse.getData().getContent());
                        } else if (TextUtils.equals(kycStatusOfT2, OTCStatusExtendResponse.ExtendBean.KYC_STATUS_OF_T2_FAIL)) {
                            HuobiToastUtil.m(OtcTradePresenter.this.getString(R$string.n_check_network));
                        } else {
                            if (!TextUtils.isEmpty(kycStatusOfT2) && TextUtils.equals(kycStatusOfT2, String.valueOf(2))) {
                                z11 = true;
                            }
                            ((i) OtcTradePresenter.this.getUI()).uf(z11, content);
                        }
                    } else {
                        ((i) OtcTradePresenter.this.getUI()).uf(false, content);
                    }
                } else {
                    ((i) OtcTradePresenter.this.getUI()).uf(false, content);
                }
            }
        }
    }

    public class f extends RequestCallback1<MktRuleBean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtcTradeAreaEnum f79146a;

        public f(OtcTradeAreaEnum otcTradeAreaEnum) {
            this.f79146a = otcTradeAreaEnum;
        }

        /* renamed from: a */
        public void onRequestSuccess(MktRuleBean mktRuleBean) {
            if (mktRuleBean != null) {
                List<MktRulePageBean> pageList = mktRuleBean.getPageList();
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < pageList.size(); i11++) {
                    if (pageList.get(i11).getContent() != null) {
                        List<Map<String, Object>> content = pageList.get(i11).getContent();
                        OtcBannerBean otcBannerBean = new OtcBannerBean();
                        for (int i12 = 0; i12 < content.size(); i12++) {
                            Map map = content.get(i12);
                            double doubleValue = ((Double) map.get("type")).doubleValue();
                            Object obj = map.get("value");
                            if (doubleValue == 4.0d) {
                                if (obj instanceof String) {
                                    otcBannerBean.setImageUrl((String) obj);
                                }
                                arrayList.add(otcBannerBean);
                            } else if (doubleValue == 8.0d && (obj instanceof LinkedTreeMap)) {
                                otcBannerBean.setJumpUrl(((LinkedTreeMap) obj).get("link").toString());
                            }
                        }
                    }
                }
                OtcTradePresenter.this.f79128a.put(this.f79146a, arrayList);
                if (OtcTradePresenter.this.getUI() != null && ((i) OtcTradePresenter.this.getUI()).Ed() == this.f79146a) {
                    ((i) OtcTradePresenter.this.getUI()).ua(arrayList, false);
                }
            } else if (OtcTradePresenter.this.getUI() != null && ((i) OtcTradePresenter.this.getUI()).Ed() == this.f79146a) {
                OtcTradePresenter.this.f79128a.put(this.f79146a, new ArrayList());
                ((i) OtcTradePresenter.this.getUI()).ua((List) OtcTradePresenter.this.f79128a.get(this.f79146a), false);
            }
        }

        public void onRequestFailure(Throwable th2) {
            if (OtcTradePresenter.this.getActivity() != null && OtcTradePresenter.this.getActivity().isAlive()) {
                super.onRequestFailure(th2);
            }
            if (OtcTradePresenter.this.getUI() != null && ((i) OtcTradePresenter.this.getUI()).Ed() == this.f79146a) {
                ((i) OtcTradePresenter.this.getUI()).ua((List) OtcTradePresenter.this.f79128a.get(this.f79146a), false);
            }
        }
    }

    public class g extends EasySubscriber<OTCStatusStringExtendResponse<Ads>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79148b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f79149c;

        public g(String str, String str2) {
            this.f79148b = str;
            this.f79149c = str2;
        }

        /* renamed from: a */
        public void onNext(OTCStatusStringExtendResponse<Ads> oTCStatusStringExtendResponse) {
            if (oTCStatusStringExtendResponse != null && oTCStatusStringExtendResponse.isSuccess() && oTCStatusStringExtendResponse.getData() != null) {
                ((i) OtcTradePresenter.this.getUI()).h8(this.f79148b, this.f79149c, oTCStatusStringExtendResponse);
            } else if (oTCStatusStringExtendResponse != null && oTCStatusStringExtendResponse.getCode() == 10301 && !TextUtils.isEmpty(oTCStatusStringExtendResponse.getMessage())) {
                HuobiToastUtil.m(oTCStatusStringExtendResponse.getMessage());
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class h extends EasySubscriber<OTCStatusResponse<ReminderData>> {
        public h() {
        }

        /* renamed from: a */
        public void onNext(OTCStatusResponse<ReminderData> oTCStatusResponse) {
            ReminderData reminderData;
            OtcOrderReminder e11 = OtcOrderReminder.e();
            if (oTCStatusResponse == null) {
                reminderData = null;
            } else {
                reminderData = oTCStatusResponse.getData();
            }
            e11.l(reminderData);
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public interface i extends u6.g {
        OtcTradeAreaEnum Ed();

        void J6(boolean z11);

        void L3(String str);

        String R0();

        void Rg(JumpOtcTradeAreaEvent jumpOtcTradeAreaEvent);

        void Zd();

        void h8(String str, String str2, OTCStatusStringExtendResponse<Ads> oTCStatusStringExtendResponse);

        void jg();

        void md(OtcTradeAreaEnum otcTradeAreaEnum, MktRuleBean mktRuleBean);

        void n9(String str, String str2);

        void o2(int i11);

        void oe(int i11);

        void u6(MktRuleBean mktRuleBean);

        void ua(List<OtcBannerBean> list, boolean z11);

        void uc();

        void uf(boolean z11, String str);

        void y5(boolean z11);
    }

    public static void y0(boolean z11) {
        f79127m = z11;
    }

    public void Y() {
        OtcTradeAreaEnum Ed = ((i) getUI()).Ed();
        if (Ed != OtcTradeAreaEnum.FREE_AREA) {
            if (!ConfigPreferences.c("otc_config", OtcTradeBannerView.getOtcBannerShowKey(), false)) {
                Z(up.g.c("otc_select_trade_currency_quote_asset"), "");
                return;
            }
            List list = this.f79128a.get(Ed);
            if (list != null) {
                list.clear();
            }
            if (getUI() != null) {
                ((i) getUI()).ua(list, false);
            }
        }
    }

    public void Z(String str, String str2) {
        OtcTradeAreaEnum Ed = ((i) getUI()).Ed();
        if (Ed != OtcTradeAreaEnum.FREE_AREA) {
            String str3 = Ed == OtcTradeAreaEnum.FAST_AREA ? CouponReturn.TYPE_EXPERIENCE : "60";
            HashMap hashMap = new HashMap();
            hashMap.put("appPageId", str3);
            hashMap.put("eventId", "502");
            hashMap.put("mgtRuleSceneCode", "page_init");
            hashMap.put("currencyAssetName", str);
            if (!TextUtils.isEmpty(str2)) {
                this.f79129b = str2;
            }
            hashMap.put("cryptoAssetName", this.f79129b);
            s8.a.a().mktRule(hashMap).d(new f(Ed));
        }
    }

    public Observable<UserSecurityInfoData> a0() {
        return ((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestUserSecurityInfo().compose(UcRetrofit.h()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public HashMap<OtcTradeAreaEnum, MktRuleBean> b0() {
        return this.f79132e;
    }

    public MktRuleBean c0() {
        return this.f79133f;
    }

    public void d0() {
        HashMap hashMap = new HashMap();
        hashMap.put("factor", new MapParamsBuilder().a("appPageId", CouponReturn.TYPE_EXPERIENCE).b());
        hashMap.put("material", new MapParamsBuilder().a("appId", m.a().b("bind_card_auth_type", up.g.c("otc_select_trade_currency_quote_asset"))).b());
        s8.a.a().bindCardMktRule(hashMap).d(new e((u6.g) getUI()));
    }

    public List<OtcBannerBean> f0() {
        return this.f79128a.get(((i) getUI()).Ed());
    }

    public void g0() {
        a0().subscribe(new d());
    }

    public UserSecurityInfoData h0() {
        return this.f79131d;
    }

    public boolean i0() {
        return this.f79136i;
    }

    public boolean j0() {
        return this.f79134g;
    }

    public boolean k0() {
        return this.f79135h;
    }

    public boolean l0() {
        return this.f79138k;
    }

    public boolean m0() {
        return this.f79139l;
    }

    public final void n0() {
        if (!va.b.o().x()) {
            va.b.o().B().subscribe(new b());
        }
        if (!OtcModuleConfig.a().a()) {
            nb.g.j().x(false, (g.c) null);
        } else if (!nb.g.j().o()) {
            nb.g.j().w(OtcModuleConfig.a().c());
            nb.g.j().x(true, (g.c) null);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        OtcTradeChatNumP otcTradeChatNumP = this.f79130c;
        if (otcTradeChatNumP != null) {
            otcTradeChatNumP.h();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onJumpOtcTradeAreaEvent(JumpOtcTradeAreaEvent jumpOtcTradeAreaEvent) {
        if (jumpOtcTradeAreaEvent != null) {
            ((i) getUI()).Rg(jumpOtcTradeAreaEvent);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onNewOrderTipOpenEvent(OtcNewOrderTipOpenEvent otcNewOrderTipOpenEvent) {
        if (getUI() != null && ((i) getUI()).isAlive()) {
            if ("1".equalsIgnoreCase(otcNewOrderTipOpenEvent.status)) {
                OtcNewOrderTipHelper.o();
            } else {
                OtcNewOrderTipHelper.q();
            }
        }
    }

    @k20.h(sticky = true, threadMode = ThreadMode.MAIN)
    @Keep
    public void onNewUserGoVideoGuide(OtcNewUserTradeGuide otcNewUserTradeGuide) {
        this.f79139l = true;
        if (!qu.d.i().n() || !h0.c().e()) {
            w0(false);
        } else {
            w0(true);
        }
        Activity b11 = oa.a.g().b();
        if (this.f79138k && b11 != null && (b11 instanceof OtcTradeActivity) && this.f79137j) {
            up.h.j((OtcTradeActivity) b11);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onOtcTokenUpdate(OtcTokenUpdate otcTokenUpdate) {
        if (!TextUtils.isEmpty(OtcModuleConfig.a().c()) && ((i) getUI()).isCanBeSeen() && OtcModuleConfig.a().a() && !nb.g.j().o()) {
            nb.g.j().t(OtcModuleConfig.a().c(), (g.c) null);
        }
        Y();
    }

    public void onPause() {
        super.onPause();
        OtcTradeChatNumP otcTradeChatNumP = this.f79130c;
        if (otcTradeChatNumP != null) {
            otcTradeChatNumP.i();
        }
        this.f79137j = false;
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onRefreshMessage(OtcRefreshMessageEvent otcRefreshMessageEvent) {
        if (getUI() != null && ((i) getUI()).isAlive()) {
            ((i) getUI()).o2(0);
        }
    }

    public void onResume() {
        super.onResume();
        OtcTradeChatNumP otcTradeChatNumP = this.f79130c;
        if (otcTradeChatNumP != null) {
            otcTradeChatNumP.j();
        }
        if (getUI() != null) {
            this.f79137j = true;
        }
        UserSecurityInfoData userSecurityInfoData = this.f79131d;
        if (userSecurityInfoData == null || TextUtils.isEmpty(userSecurityInfoData.getPhone())) {
            g0();
        }
        s0();
    }

    @Keep
    public void onTokenError(mo.a aVar) {
        Intent M = OtcModuleConfig.a().M(getActivity());
        OtcModuleConfig.a().l(getActivity(), M, M);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onWebViewLoadFailed(WebViewLoadFailedEvent webViewLoadFailedEvent) {
        if (webViewLoadFailedEvent != null) {
            try {
                HashMap hashMap = new HashMap();
                String str = webViewLoadFailedEvent.failingUrl;
                if (!TextUtils.isEmpty(str)) {
                    Uri parse = Uri.parse(str);
                    hashMap.put("url_host", parse.getHost());
                    hashMap.put("url_path", parse.getPath());
                    if (str.contains("?")) {
                        hashMap.put("url_query", str.substring(str.indexOf("?"), str.length()));
                    }
                    uf.c.b().h("app_h5_load_failed", hashMap);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: p0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, i iVar) {
        super.onUIReady(baseCoreActivity, iVar);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        a aVar = new a();
        this.f79130c = aVar;
        aVar.k();
        op.a.r(0).A();
        op.a.r(2).A();
        n0();
        Y();
        r0();
    }

    public final void q0(OtcTradeAreaEnum otcTradeAreaEnum) {
        String str;
        if (otcTradeAreaEnum == OtcTradeAreaEnum.FAST_AREA) {
            str = CouponReturn.TYPE_EXPERIENCE;
        } else if (otcTradeAreaEnum == OtcTradeAreaEnum.FREE_AREA) {
            str = "50";
        } else if (otcTradeAreaEnum == OtcTradeAreaEnum.DEPOSIT_AREA) {
            str = "60";
        } else {
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("factor", new MapParamsBuilder().a("eventId", "44785702").a("currencyAssetName", up.g.c("otc_select_trade_currency_quote_asset")).a("appPageId", str).b());
        arrayList.add(hashMap);
        if (!f79127m) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("factor", new MapParamsBuilder().a("eventId", "507").a("appPageId", str).b());
            arrayList.add(hashMap2);
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("list", arrayList);
        s8.a.a().depositOperationBatch(hashMap3).d(new c((u6.g) getUI(), otcTradeAreaEnum));
    }

    public void r0() {
        if (!this.f79138k) {
            q0(((i) getUI()).Ed());
        }
    }

    public final void s0() {
        if (!x.j().l() && OtcModuleConfig.a().a()) {
            l.n().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h());
        }
    }

    public void t0(boolean z11) {
        this.f79136i = z11;
    }

    public void u0(boolean z11) {
        this.f79134g = z11;
    }

    public void v0(boolean z11) {
        this.f79135h = z11;
    }

    public void w0(boolean z11) {
        this.f79138k = z11;
    }

    public void x0() {
        this.f79128a.put(((i) getUI()).Ed(), new ArrayList());
    }

    public void z0(String str) {
        String queryParameter;
        String str2 = null;
        if (!TextUtils.isEmpty(str) && str.contains("http")) {
            String substring = str.substring(str.indexOf("http"));
            if (substring.contains("【")) {
                substring = substring.substring(0, substring.indexOf("【"));
            }
            HttpUrl parse = HttpUrl.parse(substring.trim());
            if (parse != null && !TextUtils.isEmpty(parse.queryParameter("redirectUrl")) && (queryParameter = parse.queryParameter("redirectUrl")) != null && queryParameter.contains("?")) {
                for (String split : queryParameter.substring(queryParameter.lastIndexOf("?") + 1).split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split2 = split.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2.length == 2 && "watchword".equalsIgnoreCase(split2[0])) {
                        str = split2[1];
                    } else if (split2.length == 2 && "shareCode".equalsIgnoreCase(split2[0])) {
                        str2 = split2[1];
                    }
                }
            }
        }
        l.u(str).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g(str, str2));
    }
}
