package com.huobi.otc.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import bj.o0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.otc.core.OTCStatusStringExtendResponse;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.network.otc.core.bean.MktRuleTXBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$anim;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.account.entity.OTCKycInfo;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.OtcBannerBean;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.enums.TradeBusinessEnum;
import com.huobi.otc.event.JumpOtcTradeAreaEvent;
import com.huobi.otc.event.LinksJumpOtcEvent;
import com.huobi.otc.event.OnFilterEvent;
import com.huobi.otc.event.OnImageToTopEvent;
import com.huobi.otc.event.OnScrollToTopImageClickEvent;
import com.huobi.otc.event.OnSelectCoinEvent;
import com.huobi.otc.event.OtcAdModeChangeEvent;
import com.huobi.otc.persenter.OtcTradePresenter;
import com.huobi.otc.widget.OtcMainHeaderView;
import com.huobi.otc.widget.OtcTradeBannerView;
import com.huobi.otc.widget.OtcTradeBottomTab;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.n;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jp.b1;
import jp.c1;
import jp.k0;
import jp.q0;
import jp.w1;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import sp.m2;
import sp.n2;
import sp.o2;
import sp.p2;
import sp.q2;
import uf.d;
import up.g;
import up.h;

@Route(path = "/otc/index")
public class OtcTradeActivity extends BaseLifeCycleFlutterFragmentActivity<OtcTradePresenter, OtcTradePresenter.i> implements OtcTradePresenter.i, lp.e, q0.d, up.a {
    public static String E;
    public Fragment A;
    public boolean B;
    public boolean C;
    public ImageView D;

    /* renamed from: e  reason: collision with root package name */
    public OtcMainHeaderView f79541e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f79542f;

    /* renamed from: g  reason: collision with root package name */
    public OtcTradeBannerView f79543g;

    /* renamed from: h  reason: collision with root package name */
    public OtcTradeBottomTab f79544h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f79545i;

    /* renamed from: j  reason: collision with root package name */
    public OtcTradeAreaEnum f79546j = OtcTradeAreaEnum.FAST_AREA;

    /* renamed from: k  reason: collision with root package name */
    public int f79547k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f79548l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f79549m = -1;

    /* renamed from: n  reason: collision with root package name */
    public int f79550n = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f79551o = -1;

    /* renamed from: p  reason: collision with root package name */
    public int f79552p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f79553q = -1;

    /* renamed from: r  reason: collision with root package name */
    public int f79554r = -1;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f79555s;

    /* renamed from: t  reason: collision with root package name */
    public ImageView f79556t;

    /* renamed from: u  reason: collision with root package name */
    public View f79557u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f79558v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f79559w;

    /* renamed from: x  reason: collision with root package name */
    public q0 f79560x;

    /* renamed from: y  reason: collision with root package name */
    public lp.b f79561y;

    /* renamed from: z  reason: collision with root package name */
    public n f79562z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            List<MktRuleTXBean> link;
            MktRuleTXBean mktRuleTXBean;
            if (!(OtcTradeActivity.this.getPresenter() == null || ((OtcTradePresenter) OtcTradeActivity.this.getPresenter()).c0() == null || (link = ((OtcTradePresenter) OtcTradeActivity.this.getPresenter()).c0().getLink()) == null || link.isEmpty() || (mktRuleTXBean = link.get(0)) == null || TextUtils.isEmpty(mktRuleTXBean.getLink()))) {
                HBBaseWebActivity.showWebView(OtcTradeActivity.this, mktRuleTXBean.getLink(), (String) null, (String) null, true);
                HashMap hashMap = new HashMap();
                hashMap.put("otc_step", "otc_popups_app_click");
                if (OtcTradeActivity.this.f79546j == OtcTradeAreaEnum.FREE_AREA) {
                    uf.c.b().h("otc_p2p_adlist", hashMap);
                } else if (OtcTradeActivity.this.f79546j == OtcTradeAreaEnum.FAST_AREA) {
                    uf.c.b().h("otc_fast_landing", hashMap);
                } else {
                    uf.c.b().h("deposit_landing", hashMap);
                }
                OtcTradeActivity.this.f79562z.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements MessageQueue.IdleHandler {
        public b() {
        }

        public boolean queueIdle() {
            String Ih = OtcTradeActivity.this.Ih();
            if (TextUtils.isEmpty(Ih) || Ih.equals(OtcTradeActivity.E)) {
                return false;
            }
            String unused = OtcTradeActivity.E = Ih;
            ((OtcTradePresenter) OtcTradeActivity.this.getPresenter()).z0(Ih);
            return false;
        }
    }

    public class c implements DialogUtils.b.f {
        public c() {
        }

        public void a(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
        }
    }

    public class d implements DialogUtils.b.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f79566a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79567b;

        public d(String str, String str2) {
            this.f79566a = str;
            this.f79567b = str2;
        }

        public void a(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            OtcModuleConfig.b().M(OtcTradeActivity.this, this.f79566a, this.f79567b);
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f79569a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huobi.otc.enums.OtcTradeAreaEnum[] r0 = com.huobi.otc.enums.OtcTradeAreaEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f79569a = r0
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.FREE_AREA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f79569a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.FAST_AREA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f79569a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.DEPOSIT_AREA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.ui.OtcTradeActivity.e.<clinit>():void");
        }
    }

    public static void Ci(Context context, Intent intent) {
        if (OtcModuleConfig.a().a()) {
            context.startActivity(intent);
        } else if (context instanceof Activity) {
            OtcModuleConfig.a().l((Activity) context, intent, (Intent) null);
        } else {
            context.startActivity(intent);
        }
    }

    public static Intent Uh(Context context, OtcTradeAreaEnum otcTradeAreaEnum, String str, int i11, boolean z11) {
        Intent intent = new Intent(context, OtcTradeActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("tradeCurrency", str);
        }
        if (otcTradeAreaEnum != null) {
            intent.putExtra("tradeArea", otcTradeAreaEnum.getCode());
        }
        intent.putExtra("tradeSide", i11 + "");
        intent.putExtra("isOutArea", z11 ? "true" : com.sumsub.sns.internal.core.analytics.d.f31895b);
        return intent;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei(Void voidR) {
        List<MktRuleTXBean> link;
        MktRuleTXBean mktRuleTXBean;
        if (getPresenter() != null && ((OtcTradePresenter) getPresenter()).b0().get(this.f79546j) != null && (link = ((OtcTradePresenter) getPresenter()).b0().get(this.f79546j).getLink()) != null && !link.isEmpty() && (mktRuleTXBean = link.get(0)) != null && !TextUtils.isEmpty(mktRuleTXBean.getLink())) {
            HBBaseWebActivity.showWebView(this, mktRuleTXBean.getLink(), (String) null, (String) null, true);
            Bi("otc_activity_entrance_click");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(Void voidR) {
        OtcTradeAreaEnum otcTradeAreaEnum = this.f79546j;
        if (otcTradeAreaEnum == OtcTradeAreaEnum.FAST_AREA) {
            ((OtcTradePresenter) getPresenter()).u0(true);
        } else if (otcTradeAreaEnum == OtcTradeAreaEnum.FREE_AREA) {
            ((OtcTradePresenter) getPresenter()).v0(true);
        } else {
            ((OtcTradePresenter) getPresenter()).t0(true);
        }
        this.f79555s.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gi(Void voidR) {
        Gh();
    }

    public static /* synthetic */ void hi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        OtcModuleConfig.b().L();
    }

    public static void mi(Context context, OtcTradeAreaEnum otcTradeAreaEnum, String str, boolean z11) {
        Ci(context, Uh(context, otcTradeAreaEnum, str, -1, z11));
    }

    public final void Ah() {
        if (getIntent().getBooleanExtra("isOutArea", false)) {
            this.f79546j = OtcTradeAreaEnum.matchTradeArea(getIntent().getIntExtra("tradeArea", OtcTradeAreaEnum.FAST_AREA.getCode()));
        } else {
            this.f79546j = k0.e();
        }
        if (!OtcTradeAreaEnum.checkIsLegal(this.f79546j)) {
            this.f79546j = OtcTradeAreaEnum.FAST_AREA;
        }
    }

    public void Ai(Fragment fragment, boolean z11) {
        this.B = z11;
        Eh(false);
        if (this.A == null) {
            this.A = fragment;
        }
        qi(true);
        getSupportFragmentManager().q().v(R$anim.anim_enter_from_bottom, R$anim.anim_exit_from_bottom).c(R$id.cl_trade_root, this.A, "tutorialFragment").k();
    }

    public final void Bh() {
        E = "";
        try {
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence) null, ""));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void Bi(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", str);
        OtcTradeAreaEnum otcTradeAreaEnum = this.f79546j;
        if (otcTradeAreaEnum == OtcTradeAreaEnum.FREE_AREA) {
            hashMap.put("pageId", "50");
        } else if (otcTradeAreaEnum == OtcTradeAreaEnum.FAST_AREA) {
            hashMap.put("pageId", CouponReturn.TYPE_EXPERIENCE);
        } else {
            hashMap.put("pageId", "60");
        }
        uf.c.b().h("otc_activity", hashMap);
    }

    public void Ch(HashMap<String, Object> hashMap) {
        if (Lh(OtcTradeAreaEnum.P2P_TRAD_AREA) != null) {
            OnFilterEvent onFilterEvent = new OnFilterEvent();
            onFilterEvent.setJsonToMap(hashMap);
            EventBus.d().k(onFilterEvent);
        }
    }

    /* renamed from: Dh */
    public OtcTradePresenter createPresenter() {
        return new OtcTradePresenter();
    }

    public OtcTradeAreaEnum Ed() {
        return this.f79560x.d();
    }

    public void Eh(boolean z11) {
        if (this.A != null) {
            oi();
            this.A = null;
            qi(false);
        }
        if (!this.B && z11) {
            h.l(this, true);
        }
    }

    public ViewGroup Fc() {
        return this.f79542f;
    }

    public void Fh() {
        this.C = true;
    }

    public final void Gh() {
        if (Lh(OtcTradeAreaEnum.P2P_TRAD_AREA) != null) {
            EventBus.d().k(new OnScrollToTopImageClickEvent());
        }
    }

    public final void Hh() {
        this.f79542f = (ViewGroup) this.viewFinder.b(R$id.tab_content);
        this.f79555s = (LinearLayout) this.viewFinder.b(R$id.ll_operate);
        this.f79556t = (ImageView) this.viewFinder.b(R$id.iv_float_operate_bottom);
        this.f79557u = this.viewFinder.b(R$id.iv_float_operate_close);
        this.f79541e = (OtcMainHeaderView) this.viewFinder.b(R$id.id_main_header_view);
        this.f79543g = (OtcTradeBannerView) this.viewFinder.b(R$id.otc_trade_banner);
        this.f79544h = (OtcTradeBottomTab) this.viewFinder.b(R$id.id_p2p_ad_mode_tab);
        this.f79545i = (FrameLayout) this.viewFinder.b(R$id.otc_banner_container);
        this.D = (ImageView) this.viewFinder.b(R$id.image_to_top);
    }

    public String Ih() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence text;
        if (isFinishing()) {
            return null;
        }
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() <= 0 || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null) {
            return "";
        }
        return text.toString();
    }

    public void J6(boolean z11) {
        Fragment m02 = getSupportFragmentManager().m0("AdQuickEditFragment");
        if (m02 != null) {
            getSupportFragmentManager().q().s(m02).k();
        }
        ri();
    }

    public int Jh() {
        return this.f79549m;
    }

    public int Kh() {
        return this.f79553q;
    }

    public void L3(String str) {
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.rl_drag).getParent();
        int i11 = R$id.ad_quick_edit_container;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(i11);
        if (frameLayout == null) {
            frameLayout = new FrameLayout(this);
            frameLayout.setId(i11);
            viewGroup.addView(frameLayout);
        }
        OtcModuleConfig.b().w(this, str, i11, "AdQuickEditFragment");
        frameLayout.setVisibility(0);
    }

    public Fragment Lh(OtcTradeAreaEnum otcTradeAreaEnum) {
        return this.f79560x.f(otcTradeAreaEnum);
    }

    public int Mh() {
        return this.f79554r;
    }

    public View Nh() {
        return this.f79541e.getGuideTab();
    }

    public OTCKycInfo Oh() {
        return null;
    }

    public OtcTradeBannerView P3() {
        return this.f79543g;
    }

    public View Ph() {
        return this.f79541e.getMenuGroup();
    }

    public void Qh() {
        if (getPresenter() != null) {
            ((OtcTradePresenter) getPresenter()).d0();
        }
    }

    public String R0() {
        return null;
    }

    public void Rg(JumpOtcTradeAreaEvent jumpOtcTradeAreaEvent) {
        Bundle bundle;
        if (jumpOtcTradeAreaEvent == null) {
            return;
        }
        if (jumpOtcTradeAreaEvent.getChildtTradeAreaEnum() != null) {
            if (jumpOtcTradeAreaEvent.isToSell()) {
                bundle = new Bundle();
                bundle.putString("side", "sell");
            } else {
                bundle = null;
            }
            this.f79560x.p(jumpOtcTradeAreaEvent.getTradeAreaEnum(), (Bundle) null, jumpOtcTradeAreaEvent.getChildtTradeAreaEnum(), bundle);
            return;
        }
        this.f79560x.o(jumpOtcTradeAreaEvent.getTradeAreaEnum(), (Bundle) null);
    }

    public int Rh() {
        return 1;
    }

    public int Sh() {
        return this.f79552p;
    }

    public void Th(d.a aVar) {
        this.f79560x.g(aVar);
    }

    public FragmentManager Vd() {
        return getSupportFragmentManager();
    }

    /* renamed from: Vh */
    public OtcTradePresenter.i getUI() {
        return this;
    }

    public UserSecurityInfoData Wh() {
        if (getPresenter() == null) {
            return null;
        }
        return ((OtcTradePresenter) getPresenter()).h0();
    }

    public void X5(int i11) {
        if (this.f79552p == 0) {
            this.f79547k = i11;
        } else {
            this.f79548l = i11;
        }
    }

    public String Xf() {
        OtcTradeAreaEnum otcTradeAreaEnum = this.f79546j;
        if (otcTradeAreaEnum != OtcTradeAreaEnum.FREE_AREA) {
            return otcTradeAreaEnum == OtcTradeAreaEnum.FAST_AREA ? "quickHome" : "";
        }
        if (this.f79560x.e() == OtcTradeAreaEnum.AD_AREA) {
            return "advHome";
        }
        return this.f79560x.e() == OtcTradeAreaEnum.ORDER_AREA ? "orderList" : "freeHome";
    }

    public void Xh() {
        Fragment m02 = getSupportFragmentManager().m0("OtcFilterMenuFragment");
        if (m02 != null) {
            getSupportFragmentManager().q().s(m02).k();
        }
        ri();
    }

    public void Yh() {
        Fragment m02 = getSupportFragmentManager().m0("OtcP2pListShareFragment");
        if (m02 != null) {
            getSupportFragmentManager().q().s(m02).k();
        }
        ri();
    }

    public void Zd() {
        if (!b1.h().j()) {
            zh();
        }
        this.f79560x.r(OtcTradeAreaEnum.AD_AREA, (Bundle) null);
    }

    public boolean Zf() {
        if (this.f79546j == OtcTradeAreaEnum.DEPOSIT_AREA) {
            return false;
        }
        return super.Zf();
    }

    public final void Zh() {
        this.f79560x = new q0(this, this);
        this.f79541e.setHeaderCallback(new n2(this));
        this.f79541e.i(this.f79546j);
    }

    public void aa(boolean z11) {
        if (this.D != null) {
            int i11 = 8;
            if (!b1.h().j()) {
                ImageView imageView = this.D;
                if (z11) {
                    i11 = 0;
                }
                imageView.setVisibility(i11);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public void addEvent() {
        Observable<Void> a11 = dw.a.a(this.f79556t);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new o2(this));
        dw.a.a(this.f79557u).throttleFirst(300, timeUnit).subscribe(new p2(this));
        dw.a.a(this.D).throttleFirst(1, TimeUnit.SECONDS).subscribe(new q2(this));
    }

    public final void ai(Intent intent, boolean z11) {
        int i11;
        int i12;
        if (intent != null) {
            if (intent.hasExtra("siteType")) {
                i11 = intent.getIntExtra("siteType", -1);
                if (i11 == -1) {
                    try {
                        i11 = Integer.parseInt(intent.getStringExtra("siteType"));
                    } catch (Exception unused) {
                    }
                }
            } else {
                i11 = -1;
            }
            int intExtra = intent.getIntExtra("tradeSide", 0);
            this.f79550n = intExtra;
            this.f79551o = intExtra;
            String stringExtra = intent.getStringExtra("tradeCurrency");
            if (TextUtils.isEmpty(stringExtra)) {
                i12 = -1;
            } else {
                i12 = va.b.e(stringExtra);
            }
            this.f79549m = i12;
            this.f79547k = i12;
            this.f79548l = i12;
            String stringExtra2 = intent.getStringExtra("fiatName");
            if (!TextUtils.isEmpty(stringExtra2) && c1.h().b(TradeBusinessEnum.ALL, stringExtra2)) {
                stringExtra2 = stringExtra2.toUpperCase();
                g.e(this.f79552p == 0 ? "otc_brand_select_trade_currency_quote_asset" : "otc_select_trade_currency_quote_asset", stringExtra2);
            }
            if (z11) {
                LinksJumpOtcEvent linksJumpOtcEvent = new LinksJumpOtcEvent();
                if (!TextUtils.isEmpty(stringExtra2)) {
                    yh(stringExtra2);
                    linksJumpOtcEvent.setFiatName(stringExtra2);
                }
                if (!TextUtils.isEmpty(stringExtra)) {
                    String upperCase = stringExtra.toUpperCase();
                    linksJumpOtcEvent.setCryptoName(upperCase);
                    getIntent().putExtra("tradeCurrency", upperCase);
                }
                if (i11 != -1) {
                    this.f79552p = i11;
                }
                linksJumpOtcEvent.setSiteType(this.f79552p);
                EventBus.d().k(linksJumpOtcEvent);
                return;
            }
            this.f79552p = i11;
        }
    }

    public boolean bi() {
        return ((OtcTradePresenter) getPresenter()).l0();
    }

    public boolean canFullScreen() {
        return Build.VERSION.SDK_INT < 21;
    }

    public boolean ci() {
        return ((OtcTradePresenter) getPresenter()).m0();
    }

    public boolean di() {
        n nVar = this.f79562z;
        return nVar != null && nVar.isShowing();
    }

    public int fd() {
        if (this.f79552p == 0) {
            return this.f79547k;
        }
        return this.f79548l;
    }

    public void fh(OtcTradeAreaEnum otcTradeAreaEnum, OtcTradeAreaEnum otcTradeAreaEnum2, Fragment fragment, Fragment fragment2) {
        this.f79546j = otcTradeAreaEnum;
        this.f79541e.i(otcTradeAreaEnum);
        o9();
        wi();
        this.f79543g.setVisibility(8);
        if (getPresenter() != null) {
            ((OtcTradePresenter) getPresenter()).Y();
        }
        if (otcTradeAreaEnum != OtcTradeAreaEnum.FREE_AREA) {
            aa(false);
        }
    }

    public int getContentView() {
        return R$layout.activity_otc_trade;
    }

    public int getTradePosition() {
        if (Sh() == 0) {
            return this.f79551o;
        }
        return this.f79550n;
    }

    public void h8(String str, String str2, OTCStatusStringExtendResponse<Ads> oTCStatusStringExtendResponse) {
        if (!isFinishing() && oTCStatusStringExtendResponse != null) {
            String extend = oTCStatusStringExtendResponse.getExtend();
            if (extend == null) {
                extend = "";
            }
            DialogUtils.b0(this, getResources().getString(R$string.n_otc_word_ad_search_title), extend, "", getResources().getString(R$string.n_otc_no), getResources().getString(R$string.n_otc_yes), new c(), new d(str, str2));
            Bh();
        }
    }

    public void ii(int i11) {
        OtcMainHeaderView otcMainHeaderView = this.f79541e;
        if (otcMainHeaderView != null) {
            otcMainHeaderView.o(i11);
        }
    }

    public void initView() {
        super.initView();
        Hh();
        Zh();
        ji(this.f79546j);
    }

    public void jg() {
        ((OtcTradePresenter) getPresenter()).x0();
        ua((List<OtcBannerBean>) null, true);
    }

    public void ji(OtcTradeAreaEnum otcTradeAreaEnum) {
        this.f79560x.o(otcTradeAreaEnum, (Bundle) null);
    }

    public void ki(boolean z11, HashMap<String, Object> hashMap) {
        if (z11) {
            Fragment Lh = Lh(OtcTradeAreaEnum.P2P_TRAD_AREA);
            String obj = hashMap.get("coinName").toString();
            X5(va.b.e(obj));
            if (Lh != null) {
                OnSelectCoinEvent onSelectCoinEvent = new OnSelectCoinEvent();
                onSelectCoinEvent.setCoinName(obj);
                EventBus.d().k(onSelectCoinEvent);
                return;
            }
            return;
        }
        Fragment Lh2 = Lh(OtcTradeAreaEnum.FAST_AREA);
        if (Lh2 != null) {
            ((uf.d) Lh2).pc(hashMap);
        }
    }

    public void li(int i11, boolean z11, HashMap<String, Object> hashMap) {
        String obj = hashMap.get("currencyName").toString();
        if (!TextUtils.isEmpty(obj)) {
            if (i11 == 0) {
                if (z11) {
                    g.e("otc_brand_select_trade_currency_quote_asset", obj);
                }
                op.a r11 = op.a.r(2);
                r11.F(obj);
                r11.z(false);
            } else {
                if (z11) {
                    g.e("otc_select_trade_currency_quote_asset", obj);
                }
                op.a r12 = op.a.r(0);
                r12.F(obj);
                r12.z(false);
            }
            ((OtcTradePresenter) getPresenter()).b0().clear();
            ((OtcTradePresenter) getPresenter()).r0();
            ((OtcTradePresenter) getPresenter()).Z(obj, va.b.g(Jh()));
        }
        OtcTradeAreaEnum otcTradeAreaEnum = this.f79546j;
        if (otcTradeAreaEnum == OtcTradeAreaEnum.FREE_AREA) {
            uf.c.b().r("change_fiat", "otc.adlist.layer_coin.change_LC", (HashMap) null);
            return;
        }
        OtcTradeAreaEnum otcTradeAreaEnum2 = OtcTradeAreaEnum.FAST_AREA;
        if (otcTradeAreaEnum == otcTradeAreaEnum2) {
            uf.c.b().n("change_fiat", "otc.fast.page.change_LC", (HashMap) null);
            Fragment Lh = Lh(otcTradeAreaEnum2);
            if (Lh != null) {
                ((uf.d) Lh).v8(hashMap);
            }
        }
    }

    public q0 m5() {
        return this.f79560x;
    }

    public void md(OtcTradeAreaEnum otcTradeAreaEnum, MktRuleBean mktRuleBean) {
        if (this.f79546j == OtcTradeAreaEnum.FAST_AREA && ((OtcTradePresenter) getPresenter()).j0()) {
            this.f79555s.setVisibility(8);
        } else if (this.f79546j == OtcTradeAreaEnum.FREE_AREA && ((OtcTradePresenter) getPresenter()).k0()) {
            this.f79555s.setVisibility(8);
        } else if (this.f79546j != OtcTradeAreaEnum.DEPOSIT_AREA || !((OtcTradePresenter) getPresenter()).i0()) {
            if (this.f79546j == otcTradeAreaEnum && mktRuleBean != null) {
                String image = mktRuleBean.getImage();
                if (!TextUtils.isEmpty(image)) {
                    if (image.endsWith("svg")) {
                        f6.c.a().l(this, image, this.f79556t, R$drawable.coin_default_icon);
                    } else {
                        f6.c.a().f(this.f79556t, image, R$drawable.coin_default_icon);
                    }
                    this.f79555s.setVisibility(0);
                    Bi("otc_activity_entrance_uv");
                    return;
                }
            }
            this.f79555s.setVisibility(8);
        } else {
            this.f79555s.setVisibility(8);
        }
    }

    public void n9(String str, String str2) {
        DialogUtils.X(this, getString(R$string.n_kyc_authentication_fail), getString(R$string.n_otc_kyc_id_expired), "", getString(R$string.n_known), o0.f12469a);
    }

    public void ni(OtcTradeAreaEnum otcTradeAreaEnum) {
        if ((otcTradeAreaEnum == OtcTradeAreaEnum.ORDER_AREA || otcTradeAreaEnum == OtcTradeAreaEnum.AD_AREA || otcTradeAreaEnum == OtcTradeAreaEnum.MINE) ? false : true) {
            this.f79541e.setVisibility(0);
        } else {
            this.f79541e.setVisibility(8);
        }
        if ((otcTradeAreaEnum == OtcTradeAreaEnum.FAST_AREA || otcTradeAreaEnum == OtcTradeAreaEnum.DEPOSIT_AREA) && !CollectionsUtils.b(this.f79543g.getOtcBannerBeans())) {
            this.f79543g.setVisibility(0);
        } else {
            this.f79543g.setVisibility(8);
        }
    }

    public void o2(int i11) {
        this.f79541e.setUnreadNum(i11);
        lp.b bVar = this.f79561y;
        if (bVar != null) {
            bVar.m3257if(i11);
        }
    }

    public void o9() {
        View findViewById = this.f79545i.findViewById(R$id.otc_trade_banner);
        if (this.f79560x.d() != OtcTradeAreaEnum.FREE_AREA && findViewById == null) {
            ViewGroup viewGroup = (ViewGroup) this.f79543g.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.f79545i.addView(this.f79543g);
        }
    }

    public void oe(int i11) {
    }

    public final void oi() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment m02 = supportFragmentManager.m0("tutorialFragment");
        if (m02 != null) {
            supportFragmentManager.q().s(m02).j();
        }
    }

    public void onCreate(Bundle bundle) {
        oi();
        ti(R$color.baseColorContentBackground);
        changeStatusBarTextColor(!NightHelper.e().g());
        try {
            if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l(this, getIntent(), (Intent) null);
                finish();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        k0.c(getIntent());
        Ah();
        ai(getIntent(), false);
        int i11 = this.f79550n;
        if (i11 != -1) {
            this.f79553q = i11;
            this.f79554r = i11;
        }
        if (bundle != null) {
            bundle.putParcelable("android:support:fragments", (Parcelable) null);
        }
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        w1.b().a();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k0.c(intent);
        if (intent.getIntExtra("tradeArea", -1) != -1) {
            OtcTradeAreaEnum matchTradeArea = OtcTradeAreaEnum.matchTradeArea(intent.getIntExtra("tradeArea", OtcTradeAreaEnum.FAST_AREA.getCode()));
            this.f79546j = matchTradeArea;
            this.f79560x.o(matchTradeArea, (Bundle) null);
        }
        ai(intent, true);
    }

    public void onPause() {
        super.onPause();
        this.f79559w = false;
    }

    public void onResume() {
        super.onResume();
        pi();
        if (this.C) {
            this.C = false;
            Eh(false);
        }
        Looper.myQueue().addIdleHandler(new b());
    }

    public void onStart() {
        super.onStart();
        OtcModuleConfig.a().Z(this);
    }

    public void onStop() {
        super.onStop();
        OtcModuleConfig.a().i(this);
    }

    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        h.l(this, z11);
        if (z11 && this.A == null) {
            h.j(this);
        }
    }

    public void p7(lp.b bVar) {
        this.f79561y = bVar;
    }

    public final void pi() {
        if (!this.f79559w && getPresenter() != null && !CollectionsUtils.b(((OtcTradePresenter) getPresenter()).f0())) {
            for (OtcBannerBean next : ((OtcTradePresenter) getPresenter()).f0()) {
                if (next != null && next.getJumpUrl() != null && next.getJumpUrl().contains("/otc/user/guide")) {
                    uf.c.b().l("banner_bonus_view", (HashMap) null);
                    this.f79559w = true;
                    return;
                }
            }
        }
    }

    public void qi(boolean z11) {
        ((OtcTradePresenter) getPresenter()).w0(z11);
    }

    public final void ri() {
        View findViewById = findViewById(R$id.ad_quick_edit_container);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void si(int i11) {
        this.f79552p = i11;
    }

    public void tf(OtcTradeAreaEnum otcTradeAreaEnum, OtcTradeAreaEnum otcTradeAreaEnum2) {
        int i11 = e.f79569a[otcTradeAreaEnum2.ordinal()];
        if (i11 == 1) {
            ViewUtil.m(this.f79544h, b1.h().j());
        } else if (i11 == 2) {
            this.f79544h.setVisibility(8);
        } else if (i11 == 3) {
            this.f79544h.setVisibility(8);
        }
    }

    public void ti(int i11) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, i11));
        }
    }

    public void u6(MktRuleBean mktRuleBean) {
        if (!h.i() && this.A == null) {
            if (this.f79562z == null) {
                n nVar = new n(this);
                this.f79562z = nVar;
                nVar.o(new a(), mktRuleBean.getImage());
            }
            if (!this.f79562z.isShowing()) {
                this.f79562z.show();
                OtcTradePresenter otcTradePresenter = (OtcTradePresenter) getPresenter();
                OtcTradePresenter.y0(true);
                HashMap hashMap = new HashMap();
                hashMap.put("otc_step", "otc_popups_app_show");
                OtcTradeAreaEnum otcTradeAreaEnum = this.f79546j;
                if (otcTradeAreaEnum == OtcTradeAreaEnum.FREE_AREA) {
                    uf.c.b().h("otc_p2p_adlist", hashMap);
                } else if (otcTradeAreaEnum == OtcTradeAreaEnum.FAST_AREA) {
                    uf.c.b().h("otc_fast_landing", hashMap);
                } else {
                    uf.c.b().h("deposit_landing", hashMap);
                }
            }
        }
    }

    public void ua(List<OtcBannerBean> list, boolean z11) {
        this.f79543g.g(list, this, z11);
        pi();
    }

    public void uc() {
        Fragment m02 = getSupportFragmentManager().m0("OtcStrictSelectionFragment");
        if (m02 != null) {
            getSupportFragmentManager().q().s(m02).k();
        }
        ri();
    }

    public void uf(boolean z11, String str) {
        if (!z11) {
            DialogUtils.c0(this, getString(R$string.n_otc_high_level_kyc), "", getString(R$string.n_cancel), getString(R$string.n_otc_go_verification), o0.f12469a, m2.f26049a);
            return;
        }
        OtcCardManagerActivity.Bh(this, this.f79546j.getCode());
    }

    public final void ui() {
        if (Lh(OtcTradeAreaEnum.P2P_TRAD_AREA) != null) {
            EventBus.d().k(new OnImageToTopEvent());
        }
    }

    public OtcTradeBottomTab v4() {
        return this.f79544h;
    }

    public void vi(int i11) {
        if (Sh() == 0) {
            this.f79551o = i11;
        } else {
            this.f79550n = i11;
        }
    }

    public final void wi() {
        if (getPresenter() != null) {
            MktRuleBean mktRuleBean = ((OtcTradePresenter) getPresenter()).b0().get(this.f79546j);
            if (mktRuleBean != null) {
                md(this.f79546j, mktRuleBean);
                return;
            }
            this.f79555s.setVisibility(8);
            ((OtcTradePresenter) getPresenter()).r0();
        }
    }

    public void xi(int i11, int i12, int i13, String str, int i14) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.rl_drag).getParent();
        int i15 = R$id.ad_quick_edit_container;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(i15);
        if (frameLayout == null) {
            frameLayout = new FrameLayout(this);
            frameLayout.setId(i15);
            viewGroup.addView(frameLayout);
        }
        FrameLayout frameLayout2 = frameLayout;
        OtcModuleConfig.b().s(this, i11, i12, i13, str, i15, "OtcFilterMenuFragment", i14 == 0 ? 2 : 0, i14);
        frameLayout2.setVisibility(0);
    }

    public void y5(boolean z11) {
        ViewUtil.m(this.f79544h, z11);
    }

    public void yh(String str) {
        String c11 = g.c(this.f79552p == 0 ? "otc_brand_select_trade_currency_quote_asset" : "otc_select_trade_currency_quote_asset");
        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(c11)) {
            HashMap hashMap = new HashMap();
            hashMap.put("currencyName", str);
            li(1, true, hashMap);
        }
    }

    public void yi(String str, int i11, String str2, String str3, String str4) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.rl_drag).getParent();
        int i12 = R$id.ad_quick_edit_container;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(i12);
        if (frameLayout == null) {
            frameLayout = new FrameLayout(this);
            frameLayout.setId(i12);
            viewGroup.addView(frameLayout);
        }
        OtcModuleConfig.b().N(this, str, i11, str2, str3, str4, i12, "OtcP2pListShareFragment");
        frameLayout.setVisibility(0);
    }

    public void zh() {
        b1.h().f();
        this.f79561y.M5();
        EventBus.d().k(new OtcAdModeChangeEvent());
        if (b1.h().j()) {
            aa(false);
        } else {
            ui();
        }
    }

    public void zi() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.rl_drag).getParent();
        int i11 = R$id.ad_quick_edit_container;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(i11);
        if (frameLayout == null) {
            frameLayout = new FrameLayout(this);
            frameLayout.setId(i11);
            viewGroup.addView(frameLayout);
        }
        OtcModuleConfig.b().A(this, i11, "OtcStrictSelectionFragment");
        frameLayout.setVisibility(0);
    }
}
