package com.huobi.otc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.client.android.clipboard.ClipboardInterface;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.OtcCountryListData;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.account.api.StepRateService;
import com.huobi.account.ui.KycAuthInfoActivity;
import com.huobi.coupon.bean.Coupon;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.kyc.util.KycProxy;
import com.huobi.lite.kyc.aliface.AliFaceCertificate;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.main.presenter.HuobiMainPresenter;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.otc.bean.VoiceInfo;
import com.huobi.otc.edgeengine.p2p.OtcMainNewFragment;
import com.huobi.otc.edgeengine.p2p.OtcMerchantSearchActivity;
import com.huobi.otc.flutter.DepositCurrencySearchFragment;
import com.huobi.otc.flutter.OtcFlutterOrderDetailActivity;
import com.huobi.otc.flutter.OtcMakerAdsFlutterFragment;
import com.huobi.otc.flutter.OtcMineFragment;
import com.huobi.otc.flutter.OtcOrderInfoActivity;
import com.huobi.otc.flutter.OtcQuickHomeFlutterFragment;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import com.huobi.otc.helper.OtcVoiceHelper;
import com.huobi.otc.widget.OtcOrderReminder;
import com.huobi.utils.a0;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import com.huobi.webview2.ui.CustomServiceWebActivity;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;
import dh.d;
import gs.e;
import i6.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.l;
import rn.c;
import rx.Observable;
import rx.functions.Func1;
import sn.f;
import tg.r;
import u6.g;
import yr.b;

public class OtcModuleCallbackImpl implements uf.a {

    public class a implements Func1<List<CountryListData>, String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f78251b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f78252c;

        public a(String str, Context context) {
            this.f78251b = str;
            this.f78252c = context;
        }

        /* renamed from: a */
        public String call(List<CountryListData> list) {
            for (CountryListData next : list) {
                if (String.valueOf(next.c()).equals(this.f78251b)) {
                    if (p.h(this.f78252c)) {
                        return next.d();
                    }
                    return next.e();
                }
            }
            return "";
        }
    }

    public static /* synthetic */ List h0(List list) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtils.b(list)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                CountryListData countryListData = (CountryListData) it2.next();
                OtcCountryListData otcCountryListData = new OtcCountryListData();
                otcCountryListData.setAreaCode(countryListData.a());
                otcCountryListData.setCountryId(countryListData.c());
                otcCountryListData.setNameCn(countryListData.d());
                otcCountryListData.setNameEn(countryListData.e());
                arrayList.add(otcCountryListData);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ Observable i0(LoginInfoData loginInfoData) {
        if (loginInfoData == null || TextUtils.isEmpty(loginInfoData.getTicket())) {
            return Observable.just("");
        }
        return Observable.just(loginInfoData.getTicket());
    }

    public void A(FragmentActivity fragmentActivity, g gVar, String str) {
        new OtcFaitDWJumpHelper(fragmentActivity, gVar, str).t(OtcFaitDWJumpHelper.f78855g, str);
    }

    public void B(Context context, Intent intent) {
        intent.setClass(context, KycAuthInfoActivity.class);
        FlutterKycConfig flutterKycConfig = new FlutterKycConfig();
        List<Integer> d11 = OtcModuleConfig.a().d();
        if (!CollectionsUtils.b(d11)) {
            flutterKycConfig.setCountryId(String.valueOf(d11.get(0)));
        }
        flutterKycConfig.setPhone(OtcModuleConfig.a().O());
        flutterKycConfig.setPhone(OtcModuleConfig.a().getUserEmail());
        flutterKycConfig.setAuthBizCode(Coupon.OTC);
        intent.putExtra("flag_kyc_config", flutterKycConfig);
        context.startActivity(intent);
    }

    public Observable<Object> C(Map<String, Object> map) {
        return UserCenterRemoteDataSource.A().I(map).compose(tq.p.c0());
    }

    public boolean D() {
        return r.x().U();
    }

    public void E(Context context, boolean z11) {
        OtcVoiceHelper.o(context, z11, (TUICallback) null);
    }

    public void F(Context context, String str, boolean z11) {
        OtcFlutterOrderDetailActivity.Ki(context, str, z11);
    }

    public Observable<UserKycInfoNew> G(boolean z11, g gVar) {
        return KycProxy.l().i(z11).compose(RxJavaHelper.t(gVar));
    }

    public boolean H(Activity activity) {
        if (activity == null) {
            return false;
        }
        return b.p(activity).isWXAppInstalled();
    }

    public Observable<OTCStatusExtendResponse<OtcAdTicket>> I(String str, Boolean bool, String str2) {
        return l.o(str, bool, str2);
    }

    public String J() {
        return sn.a.c().a();
    }

    public void K(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, OtcMerchantSearchActivity.class);
        context.startActivity(intent);
    }

    public void L(t8.a aVar) {
        d.d().f(aVar);
    }

    public Intent M(Context context) {
        return k0.h(context);
    }

    public Intent N(Activity activity) {
        String i11 = gj.b.j().i();
        if (!SystemUtils.c()) {
            i11 = "http://hbg-fed-baymax.test-1.huobiapps.com/#/h5/?sceneCode=2";
        }
        String g11 = l.g(i11, "sceneCode", "2");
        Intent createIntent = CustomServiceWebActivity.createIntent(activity, g11 + "&lang=" + g().replaceAll("/", ""), (String) null);
        k.f("CustomService", g11);
        return createIntent;
    }

    public String O() {
        return r.x().F();
    }

    public void P(Map<String, Object> map, Map<String, String> map2) {
        VerifyHelper.l(map, map2);
    }

    public Observable<String> Q(Context context, String str) {
        return CountryAreaSelectActivityV2.Qg().map(new a(str, context));
    }

    public void R(Context context, String str, AliFaceCertificate.b bVar) {
    }

    public boolean S(BaseCoreActivity baseCoreActivity) {
        return baseCoreActivity instanceof HuobiMainActivity;
    }

    public void T(String str) {
        e.b().c(str);
    }

    public Class U() {
        return OtcMakerAdsFlutterFragment.class;
    }

    public boolean V(Coupon coupon, String str) {
        return l.w(coupon, str);
    }

    public void W(RecyclerView recyclerView, boolean z11) {
        OtcOrderReminder.e().k(recyclerView, z11);
    }

    public Observable<UserVO> X(boolean z11) {
        return l.q(z11).compose(RxJavaHelper.t((g) null));
    }

    public String Y() {
        return "pro.huobi.balance";
    }

    public void Z(BaseCoreActivity baseCoreActivity) {
        OtcOrderReminder.e().c(baseCoreActivity);
    }

    public boolean a() {
        return r.x().F0();
    }

    public Intent a0(Context context) {
        Intent intent = new Intent(context, HuobiMainActivity.class);
        intent.putExtra("navigator_action", HuobiMainPresenter.f77754j);
        return intent;
    }

    public void b(String str, Map<String, Object> map) {
        is.a.i(str, map);
    }

    public String b0() {
        return d1.h();
    }

    public String c() {
        return r.x().E();
    }

    public String c0() {
        return ku.b.e().h(BaseApplication.b());
    }

    public List<Integer> d() {
        UserInfoData M = r.x().M();
        if (M == null || M.d() == null) {
            return new ArrayList();
        }
        return M.d();
    }

    public void d0(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, OtcOrderInfoActivity.class);
        intent.putExtra("com.huobi.otc.lite.order.id", str);
        intent.putExtra("com.huobi.otc.lite.order.pay.id", str2);
        intent.putExtra("com.huobi.otc.lite.order.bank.type", str3);
        context.startActivity(intent);
    }

    public void e(String str) {
        r.x().t0(str);
    }

    public boolean e0() {
        return gj.a.b().d();
    }

    public String f() {
        return r.x().I();
    }

    public String g() {
        return f.s();
    }

    public Observable<List<OtcCountryListData>> getCountryList() {
        return CountryAreaSelectActivityV2.Qg().map(ap.b.f12169b);
    }

    public String getUid() {
        return r.x().J();
    }

    public String getUserEmail() {
        return r.x().u();
    }

    public void h(CharSequence charSequence, Context context) {
        ClipboardInterface.setCopyText(charSequence, context);
    }

    public void i(BaseCoreActivity baseCoreActivity) {
        OtcOrderReminder.e().d(baseCoreActivity);
    }

    public int j() {
        return KycProxy.l().p();
    }

    public Class k() {
        return OtcMineFragment.class;
    }

    public boolean l(Activity activity, Intent intent, Intent intent2) {
        return c.i().d(activity, new JumpTarget(intent, intent2));
    }

    public void m(String str, String str2, String str3, Map<String, Object> map) {
        is.a.s(str, str2, false, str3, map);
    }

    public Observable<String> n(String str) {
        return UserCenterRemoteDataSource.A().Q(str).compose(tq.p.c0()).flatMap(ap.a.f12168b);
    }

    public Class o() {
        return OtcQuickHomeFlutterFragment.class;
    }

    public boolean p(Coupon coupon, String str, String str2) {
        return l.v(coupon, str, str2);
    }

    public String q() {
        return com.huobi.domain.d.a();
    }

    public Class r() {
        return DepositCurrencySearchFragment.class;
    }

    public Observable<Boolean> s(Map<String, Object> map) {
        return ((StepRateService) tq.p.W(StepRateService.class)).updateRateSwitch(map).compose(tq.p.D());
    }

    public String t() {
        return a0.j();
    }

    public void track(String str, HashMap hashMap) {
        gs.g.i(str, hashMap);
    }

    public Intent u(Context context) {
        return k0.p(context);
    }

    public String v(String str, int i11) {
        return l.j(str, i11);
    }

    public void w(Context context, String str, VoiceInfo voiceInfo) {
        OtcVoiceHelper.m(context, str, voiceInfo);
    }

    public boolean x() {
        return l.M();
    }

    public Class y() {
        return OtcMainNewFragment.class;
    }

    public void z(String str, String str2, t8.a aVar) {
        d.d().c(str, str2, aVar);
    }
}
