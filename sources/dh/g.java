package dh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import com.adjust.sdk.Constants;
import com.business.common.red_packet.RedPacketManager;
import com.hbg.component.kline.db.KlineDbHelper;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.lang.BaseLang;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.screenshot.ScreenShotActivityMonitor;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.HbgDataModuleConfig;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.jpush.HbJPushManager;
import com.hbg.lib.network.contract.ContractPositionApi;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.hbg.db.HbgDbHelper;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.linear.swap.core.LinearSwapModuleConfig;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.pro.db.ProDbHelper;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.tencent.push.TencentPushManager;
import com.hbg.lib.tencent.push.TencentPushModuleConfig;
import com.hbg.lib.widgets.h2;
import com.hbg.lib.widgets.photoviewer.PhotoViewConfig;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.contract.ContractModuleConfig;
import com.hbg.module.huobi.im.manager.ActiveViewManager;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.otc.OtcModuleConfig;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.app.GrayConfigHelper;
import com.huobi.app.H5CacheServiceHelper;
import com.huobi.app.JumpActivity;
import com.huobi.app.NetworkChangeReceiver;
import com.huobi.app.util.HbRetrofitLoggerImpl;
import com.huobi.app.util.StartAppUtil;
import com.huobi.assetrecord.AssetRecordActivity;
import com.huobi.bugsdk.FirebaseHelper;
import com.huobi.contract.ContractModuleConfigImpl;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.ui.ContractOrderActivity;
import com.huobi.contract.utils.LegalContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.currencyconfig.util.SymbolCurrencyModuleImplement;
import com.huobi.data.ExchangeModuleCallbackImpl;
import com.huobi.data.HbgDataModuleConfigCallbackImpl;
import com.huobi.domain.DomainSwitcher;
import com.huobi.domain.DomainTestInterceptor;
import com.huobi.dynamiclangs.db.DynamicStringsDbHelper;
import com.huobi.finance.AssetModuleCallbackImp;
import com.huobi.homemarket.bean.CollectionMultiple;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.helper.ActiveDisplayPageHelper;
import com.huobi.kline.CommunityModuleCallbackImpl;
import com.huobi.linearswap.LinearSwapModuleConfigImpl;
import com.huobi.linearswap.ui.LinearSwapOrderActivity;
import com.huobi.lite.LiteIndexInterfaceImpl;
import com.huobi.lite.LiteJumpInterfaceImpl;
import com.huobi.lite.LiteModuleInterfaceImpl;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.network.listener.HbContractInterceptorListener;
import com.huobi.network.listener.HbEtfInterceptorListener;
import com.huobi.network.listener.HbH5InterceptorListener;
import com.huobi.network.listener.HbHbgInterceptorListener;
import com.huobi.network.listener.HbIndexInterceptorListener;
import com.huobi.network.listener.HbInstInterceptorListener;
import com.huobi.network.listener.HbLinearSwapInterceptorListener;
import com.huobi.network.listener.HbMgtContentInterceptorListener;
import com.huobi.network.listener.HbMgtInterceptorListener;
import com.huobi.network.listener.HbNewKycInterceptorListener;
import com.huobi.network.listener.HbOptionInterceptorListener;
import com.huobi.network.listener.HbOtcInterceptorListener;
import com.huobi.network.listener.HbPhpInterceptorListener;
import com.huobi.network.listener.HbProInterceptorListener;
import com.huobi.network.listener.HbSwapInterceptorListener;
import com.huobi.network.listener.HbUcInterceptorListener;
import com.huobi.otc.OtcModuleCallbackImpl;
import com.huobi.otc.OtcModuleJumpCallbackImpl;
import com.huobi.search.ui.SearchFlutterActivity;
import com.huobi.search.viewhandler.SearchResultViewHandler;
import com.huobi.sharev2.manager.ShareManager;
import com.huobi.staring.helper.StaringRemindHelper;
import com.huobi.staring.ui.StaringRemindActivity;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.statistics.hbg.bean.AnalyticsExposureItem;
import com.huobi.store.AppConfigManager;
import com.huobi.swap.ui.SwapOrderActivity;
import com.huobi.trade.handler.TradeCompareViewHolderHandler;
import com.huobi.trade.handler.TradeExchangeViewHolderHandler;
import com.huobi.utils.HBHTtoHTXManager;
import com.huobi.utils.UpgradeUtil;
import com.huobi.utils.a0;
import com.huobi.utils.j0;
import com.huobi.utils.k0;
import com.huobi.view.HTUpdradeMarkView;
import com.huobi.webview2.ui.ContractWebActivity;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.network.domain.DomainTool;
import com.qihoo.stat.QHStatDo;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.rtmp.TXLiveBase;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.model.VisitorInfo;
import com.zopim.android.sdk.prechat.EmailTranscript;
import d7.b1;
import i6.k;
import i6.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.functions.Func1;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import sn.t;
import tg.r;
import wn.c0;
import yl.o;
import yl.x;
import zendesk.core.AnonymousIdentity;
import zendesk.core.Zendesk;
import zendesk.support.Support;

public final class g {

    /* renamed from: d  reason: collision with root package name */
    public static g f47475d;

    /* renamed from: a  reason: collision with root package name */
    public String f47476a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f47477b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f47478c = new AtomicBoolean(false);

    public class a implements h2.a {
        public a() {
        }

        public void e(Exception exc) {
            FirebaseHelper.e(exc);
        }
    }

    public class b implements r9.a {
        public b() {
        }

        public void a(Context context, String str, String str2, String str3) {
            i6.d.b("receiver payload TencentPushModuleConfig = " + str3);
            if (str3 == null) {
                i6.d.d("receiver payload = null");
                return;
            }
            gs.g.k(2, str3);
            Intent Af = JumpActivity.Af(context, str3);
            Af.addFlags(268435456);
            context.startActivity(Af);
        }

        public void b(Context context, String str, String str2, String str3) {
            gs.g.k(1, str3);
            IndexFeatureItem w11 = o.w(str3);
            if (w11.getJumpMode() == 1006) {
                HashMap hashMap = new HashMap();
                hashMap.put("liveid", w11.getJumpOrder());
                gs.g.i("APP_LIVE_notice_pushshow", hashMap);
            }
        }
    }

    public class c implements XGIOperateCallback {
        public c() {
        }

        public void onFail(Object obj, int i11, String str) {
            k.f("TPush", "errCode = " + i11 + ", msg = " + str);
        }

        public void onSuccess(Object obj, int i11) {
            g.this.f47477b.set(true);
            if (g.this.f47478c.get()) {
                g.this.r();
            }
        }
    }

    public class d extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47482b;

        public d(String str) {
            this.f47482b = str;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            Log.e("TPush", "sendTidToServer() called fail!! ", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            Log.e("TPush", "sendTidToServer() called fail!! ", aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            SPUtil.p("push_tokent_record", "token", this.f47482b);
            SPUtil.o("push_tokent_record", "lastSaveTime", System.currentTimeMillis());
        }
    }

    public class e implements BaseModuleConfig.a {
        public e() {
        }

        public void A(Context context, String str, int i11, String str2, int i12) {
            ContractOrderActivity.Pi(context, str, i11, str2, i12);
        }

        public void B(Activity activity) {
            activity.startActivity(sn.f.h(activity));
        }

        public void C(String str) {
            ek.b.f47515a.e(str);
        }

        public String D() {
            return "pro.huobi";
        }

        public void E(Activity activity, String str, int i11, int i12) {
            SwapOrderActivity.Pi(activity, str, i11, i12);
        }

        public rj.b F(Context context, String str) {
            return ek.b.f47515a.b(context, str);
        }

        public boolean G(Activity activity, String str) {
            return zn.a.d().k(activity, str);
        }

        public void H() {
            if (ActiveViewManager.e().f()) {
                ActiveViewManager.e().m(1);
            }
            se.d.w();
        }

        public void I(UserOtherInfoData userOtherInfoData) {
            r.x().y0(userOtherInfoData);
        }

        public void J(Context context, int i11) {
            AssetRecordActivity.Ri(context, i11);
        }

        public void K(BaseActivity baseActivity) {
        }

        public boolean L() {
            return AppConfigManager.h(MgtConfigNumber.DYNAMIC_POST.number, "isOpen", false);
        }

        public String M() {
            return LegalCurrencyConfigUtil.y();
        }

        public void N(Context context) {
            sn.f.y(context, (ZopimChat.SessionConfig) null);
        }

        public String O(String str, int i11) {
            return cl.c.a(str, i11);
        }

        public String P() {
            return c0.b();
        }

        public String Q(String str) {
            return null;
        }

        public void R(Context context) {
            AssetRecordActivity.Qi(context);
        }

        public void S(Activity activity, String str) {
            zn.a.d().s(activity, str);
        }

        public void T() {
        }

        public boolean U(String str) {
            return HBHTtoHTXManager.f83692a.f(str);
        }

        public View V(Context context) {
            return new HTUpdradeMarkView(context);
        }

        public String W() {
            return sn.f.j();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.util.Pair<java.lang.Boolean, java.lang.String> X(java.lang.String r5) {
            /*
                r4 = this;
                com.hbg.lib.network.hbg.core.util.MgtConfigNumber r0 = com.hbg.lib.network.hbg.core.util.MgtConfigNumber.H5_CACHE_CONFIG
                int r0 = r0.number
                java.lang.Class<com.huobi.app.H5CacheServiceHelper$H5CacheConfig> r1 = com.huobi.app.H5CacheServiceHelper.H5CacheConfig.class
                java.lang.Object r0 = com.huobi.store.AppConfigManager.c(r0, r1)
                com.huobi.app.H5CacheServiceHelper$H5CacheConfig r0 = (com.huobi.app.H5CacheServiceHelper.H5CacheConfig) r0
                java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r0 = r0.offlineConfig
                java.lang.Object r5 = r0.get(r5)
                java.util.Map r5 = (java.util.Map) r5
                java.lang.String r0 = ""
                if (r5 == 0) goto L_0x0049
                java.lang.String r1 = "enable"
                java.lang.Object r2 = r5.get(r1)
                boolean r2 = r2 instanceof java.lang.Boolean
                if (r2 == 0) goto L_0x002d
                java.lang.Object r1 = r5.get(r1)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                goto L_0x002e
            L_0x002d:
                r1 = 1
            L_0x002e:
                java.lang.String r2 = "offline"
                java.lang.Object r3 = r5.get(r2)
                boolean r3 = r3 instanceof java.lang.String
                if (r3 == 0) goto L_0x003f
                java.lang.Object r5 = r5.get(r2)
                r0 = r5
                java.lang.String r0 = (java.lang.String) r0
            L_0x003f:
                android.util.Pair r5 = new android.util.Pair
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                r5.<init>(r1, r0)
                return r5
            L_0x0049:
                android.util.Pair r5 = new android.util.Pair
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                r5.<init>(r1, r0)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: dh.g.e.X(java.lang.String):android.util.Pair");
        }

        public void Y(AnalyticsExposureItem analyticsExposureItem) {
            is.a.l(analyticsExposureItem);
        }

        public UserOtherInfoData Z() {
            return r.x().L();
        }

        public boolean a() {
            return r.x().F0();
        }

        public String a0(String str) {
            return String.format(Locale.US, "https://www.huobi.com%s%s", new Object[]{sn.f.s(), str});
        }

        public void b(String str, Map<String, Object> map) {
            is.a.i(str, map);
        }

        public boolean b0() {
            H5CacheServiceHelper.H5CacheConfig h5CacheConfig = (H5CacheServiceHelper.H5CacheConfig) AppConfigManager.c(MgtConfigNumber.H5_CACHE_CONFIG.number, H5CacheServiceHelper.H5CacheConfig.class);
            return h5CacheConfig != null && h5CacheConfig.handleResource;
        }

        public boolean c() {
            return r.x().X();
        }

        public void c0() {
            hf.b.A();
        }

        public void d(String str, Map<String, Object> map, String str2) {
            is.a.j(str, map, str2);
        }

        public void d0(Context context, String str) {
            sn.f.V(context, str);
        }

        public void e(Exception exc) {
            FirebaseHelper.e(exc);
        }

        public boolean e0() {
            H5CacheServiceHelper.H5CacheConfig h5CacheConfig = (H5CacheServiceHelper.H5CacheConfig) AppConfigManager.c(MgtConfigNumber.H5_CACHE_CONFIG.number, H5CacheServiceHelper.H5CacheConfig.class);
            if (h5CacheConfig == null || h5CacheConfig.offlinePackageEnable != 1) {
                return false;
            }
            return true;
        }

        public String f() {
            return r.x().I();
        }

        public String f0() {
            return HbgDialogManager.A().B();
        }

        public void g(Activity activity) {
            Intent h11 = k0.h(activity);
            rn.c.i().m(activity, new JumpTarget(h11, h11));
        }

        public void g0(Activity activity, String str, int i11, int i12, String str2, String str3, int i13) {
            LinearSwapOrderActivity.Si(activity, str, i11, i12, str2, str3, i13);
        }

        public String getAvatar() {
            return r.x().p();
        }

        public String getUid() {
            return r.x().J();
        }

        public void h(FragmentActivity fragmentActivity) {
            SearchFlutterActivity.Fi(fragmentActivity);
        }

        public void h0(Context context) {
            Intent l11 = k0.l(context);
            l11.putExtra("type", "news");
            context.startActivity(l11);
        }

        public String i() {
            return r.x().n();
        }

        public String i0() {
            return r.x().s();
        }

        public String j() {
            return a0.j();
        }

        public String j0() {
            String N = r.x().N();
            return com.hbg.module.libkt.base.ext.b.x(N) ? r.x().L().getEmail() : N;
        }

        public String k(String str) {
            return a0.k(str);
        }

        public void k0(String str) {
            try {
                zn.a.d().v(Uri.parse(str));
                zn.a.d().c();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void l(Context context, String str) {
            sn.f.N(context, str);
        }

        public void l0(String str, boolean z11) {
            try {
                zn.a.d().v(Uri.parse("holigeit://open/v1?login=" + (z11 ? 1 : 0) + "&url=ihuobiglobal://m.hbg.com" + str));
                zn.a.d().c();
            } catch (Exception e11) {
                i6.d.c("SystemConfig", "jumpToPage Error : " + e11);
            }
        }

        public String m(String str, HashMap<BaseLang, List<BaseLang>> hashMap) {
            BaseLang baseLang = null;
            if (hashMap != null && !hashMap.isEmpty()) {
                String lowerCase = m6.a.f().toLowerCase();
                for (BaseLang next : hashMap.keySet()) {
                    List list = hashMap.get(next);
                    if (list != null && !list.isEmpty()) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (((BaseLang) it2.next()).getLanguageHeader().toLowerCase().equals(lowerCase)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } else if (baseLang == null) {
                        baseLang = next;
                    }
                    baseLang = next;
                }
            }
            String languageUrlPath = baseLang != null ? baseLang.getLanguageUrlPath() : m6.a.h();
            if (languageUrlPath == null || languageUrlPath.length() == 0) {
                languageUrlPath = "/en-us/";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(j());
            stringBuffer.append("/support");
            stringBuffer.append(languageUrlPath);
            stringBuffer.append("detail/");
            stringBuffer.append(str);
            return stringBuffer.toString();
        }

        public boolean m0(Activity activity) {
            if (r.x().F0()) {
                return true;
            }
            rn.c.i().d(activity, new JumpTarget((Intent) null, (Intent) null));
            return false;
        }

        public boolean n() {
            return hh.f.h().l();
        }

        public Observable<Boolean> n0(boolean z11) {
            return r.x().S(z11);
        }

        public void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str) {
            ShareManager.getInstance().newShareWithImages(arrayList, z11, z12, str);
        }

        public String o(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "360000039481";
            }
            String s11 = sn.f.s();
            int g11 = yl.g.h().g();
            String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
            if (!SystemUtils.c()) {
                str2 = wi.b.f48038b;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append("/");
            sb2.append("support");
            sb2.append(s11);
            sb2.append("list");
            sb2.append("/");
            sb2.append(str);
            sb2.append("?");
            sb2.append("countryId=");
            sb2.append(g11 > 0 ? Integer.valueOf(g11) : "");
            return sb2.toString();
        }

        public void o0(String str) {
            TimeMonitorManager.a().b(str).c();
        }

        public int p(Context context) {
            return n.g(context);
        }

        public boolean p0(String str, String str2) {
            return GrayConfigHelper.d(str, str2);
        }

        public UserKycInfoNew q() {
            return yl.g.h().i();
        }

        public void q0(AnalyticsExposureItem analyticsExposureItem) {
            is.a.l(analyticsExposureItem);
        }

        public void r(Activity activity, String str, int i11) {
        }

        public int s() {
            return r.x().z();
        }

        public boolean t() {
            return UpgradeUtil.c();
        }

        public String u() {
            return sn.f.i();
        }

        public boolean v(FragmentActivity fragmentActivity, String str) {
            if (r.x().F0()) {
                RedPacketManager.d(fragmentActivity, str);
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra(JumpTarget.BUSINESS_TYPE_KEY, JumpTarget.BUSINESS_TYPE_RED_PACKET);
            intent.putExtra(JumpTarget.BUSINESS_TYPE_VALUE_KEY, str);
            rn.c.i().d(fragmentActivity, new JumpTarget(intent, (Intent) null));
            return false;
        }

        public void w(String str, HashMap hashMap) {
            gs.g.i(str, hashMap);
        }

        public void x(String str) {
            FirebaseHelper.e(new RuntimeException(str));
        }

        public String y(String str) {
            return DomainSwitcher.A().s(str);
        }

        public void z(String str, String str2, String str3, boolean z11) {
            TimeMonitorManager.a().b(str).a(str2, str3, z11);
        }

        public void newShareWithImages(Bitmap bitmap, String str, String str2) {
            ShareManager.getInstance().newShareWithImages(bitmap, str, str2);
        }
    }

    public class f implements ff.a {
        public f() {
        }

        public int A() {
            return j0.o();
        }

        public Observable<Object> B(String str, Activity activity, String str2) {
            return t.i(str, activity, str2);
        }

        public boolean C() {
            return bj.d.u();
        }

        public boolean D() {
            return bj.d.x();
        }

        public boolean E(int i11) {
            return bj.d.v(i11);
        }

        public int F() {
            return j0.q();
        }

        public String G() {
            return "11302";
        }

        public int H() {
            return j0.p();
        }

        public String I(SymbolPrice symbolPrice) {
            return LegalContractCurrencyUtils.a(symbolPrice);
        }

        public boolean J(String str) {
            return StaringRemindHelper.h(str);
        }

        public void K(String str) {
            GrowingIOStatics.e(str);
        }

        public void L(Activity activity, String str, int i11) {
            ContractWebActivity.Th(activity, str, i11);
        }

        public String M() {
            return SearchResultViewHandler.class.getName();
        }

        public String N() {
            return "FUTURES_INDEX";
        }

        public void O(Context context, IndexCurrencyInfo indexCurrencyInfo, TradeType tradeType) {
            sn.f.B(context, indexCurrencyInfo, tradeType);
        }

        public void P(Activity activity, String str, RemindContractType remindContractType, RemindBusinessType remindBusinessType) {
            StaringRemindActivity.oj(activity, str, remindContractType, remindBusinessType);
        }

        public boolean Q(TradeType tradeType) {
            return bj.d.w(tradeType);
        }

        public void R(List<String> list) {
            br.c.g(BaseApplication.b()).d(list);
        }

        public int S() {
            return 1;
        }

        public long T() {
            return bj.d.o();
        }

        public void U(FragmentActivity fragmentActivity) {
            x.n().t(fragmentActivity);
        }

        public boolean V(String str) {
            return cs.n.l(str);
        }

        public long W() {
            return bj.d.j();
        }

        public void X(Context context, String str, boolean z11) {
            k0.O(context, str, true);
        }

        public long Y() {
            return bj.d.e();
        }

        public Observable Z(BaseCoreActivity baseCoreActivity, List<String> list) {
            return br.c.g(baseCoreActivity).k(list);
        }

        public Observable<ContractHeartBeat> a() {
            return bj.d.p();
        }

        public void a0(Context context, String str, String str2, ContractCurrencyInfo contractCurrencyInfo, TradeType tradeType) {
            sn.f.z(context, str, str2, contractCurrencyInfo, tradeType);
        }

        public Observable<Object> b0(List<String> list, Context context, String str) {
            return t.j(list, context, str);
        }

        public void c(FragmentActivity fragmentActivity, String str, boolean z11) {
            nq.a.h(fragmentActivity, fragmentActivity.getSupportFragmentManager(), str, z11);
        }

        public Observable<Object> c0(List<CollectionMultiple> list, Activity activity) {
            return t.p(list, activity);
        }

        public boolean d() {
            return bj.d.s();
        }

        public boolean d0(String str, String str2, String str3) {
            return nq.a.e(str, str2, str3);
        }

        public void e(Context context, String str, boolean z11, TradeType tradeType) {
            sn.f.C(context, str, z11, tradeType);
        }

        public String e0(String str) {
            return t.v(str);
        }

        public void f(FragmentActivity fragmentActivity, String str) {
            nq.a.j(fragmentActivity, fragmentActivity.getSupportFragmentManager(), str);
        }

        public void f0(List<String> list) {
            t.n(list);
        }

        public void g(String str, td.g gVar) {
            t.o(str, gVar);
        }

        public Observable<Object> g0(String str, Activity activity, String str2) {
            return t.l(str, activity, str2);
        }

        public void h(FragmentActivity fragmentActivity) {
            SearchFlutterActivity.Fi(fragmentActivity);
        }

        public Fragment h0() {
            Activity f11 = oa.a.g().f(HuobiMainActivity.class);
            if (f11 instanceof HuobiMainActivity) {
                return ((HuobiMainActivity) f11).Lh().h0();
            }
            return null;
        }

        public void i() {
            fr.a.f();
        }

        public int i0() {
            return j0.g();
        }

        public void j(String str, String str2) {
            is.a.w(str, str2);
        }

        public void j0(Context context, String str, boolean z11, boolean z12, TradeType tradeType) {
            sn.f.E(context, str, z11, z12, tradeType);
        }

        public boolean k(String str) {
            return t.w(str);
        }

        public void k0(Activity activity, String str, RemindContractType remindContractType, RemindBusinessType remindBusinessType) {
            rn.c.i().d(activity, new JumpTarget(StaringRemindActivity.Pi(activity, str, remindContractType, remindBusinessType), (Intent) null));
        }

        public String l() {
            return "PRO";
        }

        public String l0() {
            return TradeExchangeViewHolderHandler.class.getName();
        }

        public void m(String str) {
            GrowingIOStatics.a(str);
        }

        public List<String> m0() {
            return t.r();
        }

        public int n() {
            return 2;
        }

        public void n0(Context context, FutureContractInfo futureContractInfo) {
            sn.f.H(context, futureContractInfo);
        }

        public int o() {
            return 10;
        }

        public Observable<List<String>> o0(boolean z11, Context context) {
            return t.s(false, context);
        }

        public long p() {
            return bj.d.h();
        }

        public void p0(BaseCoreActivity baseCoreActivity) {
            rn.c.i().d(baseCoreActivity, new JumpTarget(k0.l(baseCoreActivity), k0.l(baseCoreActivity)));
        }

        public boolean q(String str) {
            return StaringRemindHelper.i(str);
        }

        public void q0(Context context) {
            t.s(false, context).compose(RxJavaHelper.t((u6.g) null)).subscribe(new BaseSubscriber());
        }

        public String r() {
            return TradeCompareViewHolderHandler.class.getName();
        }

        public void s(Context context, String str, String str2, SwapCurrencyInfo swapCurrencyInfo, TradeType tradeType) {
            sn.f.I(context, str, str2, swapCurrencyInfo, tradeType);
        }

        public void t(String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.put("tradepair_name", str2);
            gs.g.i(str, hashMap);
        }

        public void u(Context context, FutureContractInfo futureContractInfo) {
            sn.f.G(context, futureContractInfo);
        }

        public String v() {
            return "CONTRACT_SWAP";
        }

        public boolean w() {
            return false;
        }

        public String x() {
            return "CONTRACT";
        }

        public void y(Context context, String str, boolean z11, TradeType tradeType, String str2) {
            sn.f.D(context, str, z11, tradeType, str2);
        }

        public String z() {
            return "LINEAR_SWAP";
        }
    }

    /* renamed from: dh.g$g  reason: collision with other inner class name */
    public class C0575g extends BaseSubscriber<hs.b> {
        public C0575g() {
        }

        /* renamed from: a */
        public void onNext(hs.b bVar) {
            i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " HbgExposureAnalytics.getInstance()  " + Thread.currentThread().getName());
            j.c().registerActivityLifecycleCallbacks(bVar);
        }
    }

    public class h implements Func1<String, hs.b> {
        public h() {
        }

        /* renamed from: a */
        public hs.b call(String str) {
            return hs.b.l();
        }
    }

    public class i extends RxJavaErrorHandler {
        public i() {
        }

        public void handleError(Throwable th2) {
            if (th2 == null || th2.getMessage() == null) {
                Log.d("RxJavaPlugins", "rxJava registerErrorHandler error");
            } else {
                Log.d("RxJavaPlugins", th2.getMessage());
            }
        }
    }

    public static g d() {
        if (f47475d == null) {
            synchronized (g.class) {
                if (f47475d == null) {
                    f47475d = new g();
                }
            }
        }
        return f47475d;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " SystemConfig start  asyncInit                  ");
        DynamicStringsDbHelper.a(j.c().getApplicationContext());
        KlineDbHelper.c(j.c().getApplicationContext());
        HbgDbHelper.a(j.c().getApplicationContext());
        com.huobi.utils.c0.a().c(j.c().getApplicationContext());
        RetrofitLogger.f(new HbRetrofitLoggerImpl());
        h2.b(new a());
        LinearSwapModuleConfig.b(new LinearSwapModuleConfigImpl());
        ContractModuleConfig.b(new ContractModuleConfigImpl());
        b1.a().c(new SymbolCurrencyModuleImplement());
        HbgDataModuleConfig.b(new HbgDataModuleConfigCallbackImpl());
        AssetModuleConfig.b(new AssetModuleCallbackImp());
        PhotoViewConfig.b(f.f53635a);
        CommunityModuleConfig.Companion.setModuleCallback(new CommunityModuleCallbackImpl());
        vc.b.b(new ExchangeModuleCallbackImpl());
        try {
            tu.c.e();
        } catch (Throwable unused) {
        }
        pm.j.g();
        this.f47476a = ChannelUtils.b();
        i();
        zr.e.d().h(j.c());
        e();
        TencentPushModuleConfig.b(new b());
        TencentPushManager.b(j.c().getApplicationContext(), new c(), false, new String[]{"2882303761517633326"}, new String[]{"5661763335326"});
        HbJPushManager.a(j.c().getApplicationContext());
        tu.c.d();
        g6.b.c().g();
        dd.b.f22740a.d(j.c().getApplicationContext(), SystemUtils.c());
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " SystemConfig end  asyncInit          " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void e() {
        if (!TextUtils.isEmpty(this.f47476a) && this.f47476a.startsWith("360")) {
            QHStatDo.a(j.c());
        }
    }

    public void f() {
        b2.a.e(j.c());
    }

    public void g() {
        s8.a.b(j.c(), new HbOtcInterceptorListener());
        o9.a.b(j.c(), new HbUcInterceptorListener());
        v8.a.b(j.c(), new HbPhpInterceptorListener());
        x8.a.b(j.c(), new HbProInterceptorListener());
        l8.a.b(j.c(), new HbMgtInterceptorListener());
        n7.a.b(j.c(), new HbMgtContentInterceptorListener());
        v7.b.b(j.c(), new HbHbgInterceptorListener());
        v7.a.b(j.c(), new HbH5InterceptorListener());
        q7.a.b(j.c(), new HbContractInterceptorListener());
        ContractPositionApi.f("linear-swap-notification", j.c(), new oo.a("linear-swap-notification"));
        ContractPositionApi.f("swap-notification", j.c(), new oo.a("swap-notification"));
        ContractPositionApi.f(RemoteMessageConst.NOTIFICATION, j.c(), new oo.a(RemoteMessageConst.NOTIFICATION));
        ContractPositionApi.f("ws/v5/notification", j.c(), new oo.a("ws/v5/notification"));
        h8.a.b(j.c(), new HbLinearSwapInterceptorListener());
        p8.a.b(j.c(), new HbOptionInterceptorListener());
        l9.a.b(j.c(), new HbSwapInterceptorListener());
        b8.a.b(j.c(), new HbIndexInterceptorListener());
        t7.a.b(j.c(), new HbEtfInterceptorListener());
        n8.a.b(j.c(), new HbNewKycInterceptorListener());
        f8.a.b(j.c(), new HbInstInterceptorListener());
    }

    public final void h() {
        BaseModuleConfig.b(new e());
        MarketModuleConfig.c(new f());
    }

    public final void i() {
    }

    public void j() {
        GlobalAppConfig.d(new GlobalAppConfig.AppConfigImpl().e("pro.huobi").f(false).g(Constants.REFERRER_API_GOOGLE).h(105400).i("10.54.0"));
    }

    public void k() {
        ProDbHelper.c(j.c().getApplicationContext());
        g();
        ra.c.f(new LiteModuleInterfaceImpl());
        ra.c.d(new LiteIndexInterfaceImpl());
        ra.c.e(new LiteJumpInterfaceImpl());
        OtcModuleConfig.c(new OtcModuleCallbackImpl());
        OtcModuleConfig.d(new OtcModuleJumpCallbackImpl());
        h();
        TXLiveBase.getInstance().setLicence(j.c(), "http://license.vod2.myqcloud.com/license/v1/5888af888aec93f620894c74cc9c87c7/TXLiveSDK.licence", "0fb0795b1a7d4022c2c00c10298b1344");
        q();
        NightHelper.e();
    }

    public void l() {
        NetworkStatus.d();
        c9.c.b().a(new DomainTestInterceptor());
        RxJavaPlugins.getInstance().registerErrorHandler(new i());
    }

    public void m() {
    }

    public void n() {
        Zendesk zendesk2 = Zendesk.INSTANCE;
        zendesk2.init(j.c(), "https://huobiturkey.zendesk.com", "90047718d1f1bb7b09f7490926d198f2dd21f6159c96e7ed", "mobile_sdk_client_10b8c97169b0a152d2ce");
        zendesk2.setIdentity(new AnonymousIdentity.Builder().build());
        Support.INSTANCE.init(zendesk2);
        ZopimChat.trackEvent("Application created");
        ((ZopimChat.DefaultConfig) ((ZopimChat.DefaultConfig) ZopimChat.init("gUj42jsOShnJLX9O8bhx3WnaLBpsUW3s").initializationTimeout(10000)).tags("autoanswer")).emailTranscript(EmailTranscript.DISABLED).fileSending(true);
        ZopimChat.setVisitorInfo(new VisitorInfo.Builder().build());
    }

    public boolean o() {
        return this.f47477b.get();
    }

    public void p() {
        j.c().registerActivityLifecycleCallbacks(ScreenShotActivityMonitor.b());
        j.c().registerActivityLifecycleCallbacks(com.huobi.lifecycle.a.j());
        j.c().registerActivityLifecycleCallbacks(xm.b.a());
        j.c().registerActivityLifecycleCallbacks(HbgDialogManager.A().x());
        yl.h.a();
        ActiveDisplayPageHelper.a();
        j.c().registerActivityLifecycleCallbacks(rd.a.m());
        try {
            Observable.just("").map(new h()).compose(RxJavaHelper.s()).subscribe(new C0575g());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void q() {
        if (Build.VERSION.SDK_INT >= 33) {
            j.c().registerReceiver(new NetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
        } else {
            j.c().registerReceiver(new NetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public void r() {
        String str = !SystemUtils.c() ? "ASB6T7FGUVEX" : "A1QNE66U8GZ4";
        String a11 = TencentPushManager.a(j.c().getApplicationContext());
        if (TextUtils.isEmpty(a11)) {
            Log.e("TPush", "sendTidToServer() called token is null");
            return;
        }
        String e11 = SPUtil.e("push_tokent_record", "token", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        String format = simpleDateFormat.format(Long.valueOf(SPUtil.c("push_tokent_record", "lastSaveTime", 0)));
        String format2 = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
        if (TextUtils.isEmpty(e11) || !a11.equals(e11) || !format2.equals(format)) {
            v7.b.a().f(a11, str).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new d(a11));
        }
    }

    public void s() {
        this.f47478c.set(true);
    }
}
