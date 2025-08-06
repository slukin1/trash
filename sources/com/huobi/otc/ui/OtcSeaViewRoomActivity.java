package com.huobi.otc.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.enums.OtcAdsFilterType;
import com.huobi.otc.persenter.OtcSeaViewPresenter;
import com.huobi.otc.widget.OtcAdsFilterTopView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import jp.b1;

public class OtcSeaViewRoomActivity extends BaseActivity<OtcSeaViewPresenter, OtcSeaViewPresenter.a> implements OtcSeaViewPresenter.a, OtcAdsFilterTopView.d {

    /* renamed from: g  reason: collision with root package name */
    public static int f79533g = 12;

    /* renamed from: b  reason: collision with root package name */
    public PublicAdsCoinFragment f79534b;

    /* renamed from: c  reason: collision with root package name */
    public int f79535c;

    /* renamed from: d  reason: collision with root package name */
    public OtcTradeType f79536d;

    /* renamed from: e  reason: collision with root package name */
    public OtcAdsFilterTopView f79537e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f79538f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            OtcSeaViewRoomActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f79540a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huobi.otc.enums.OtcAdsFilterType[] r0 = com.huobi.otc.enums.OtcAdsFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f79540a = r0
                com.huobi.otc.enums.OtcAdsFilterType r1 = com.huobi.otc.enums.OtcAdsFilterType.PAY_METHOD_FILTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f79540a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.otc.enums.OtcAdsFilterType r1 = com.huobi.otc.enums.OtcAdsFilterType.AMOUNT_FILTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f79540a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.otc.enums.OtcAdsFilterType r1 = com.huobi.otc.enums.OtcAdsFilterType.PAY_METHOD_FILTER_NEW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.ui.OtcSeaViewRoomActivity.b.<clinit>():void");
        }
    }

    public void G8(OtcAdsFilterType otcAdsFilterType) {
        int i11 = b.f79540a[otcAdsFilterType.ordinal()];
        int i12 = 0;
        if (i11 == 1) {
            ph(0, this.f79536d == OtcTradeType.SELL ? 0 : 1, true ^ b1.h().j() ? 1 : 0, String.valueOf(this.f79535c));
        } else if (i11 == 2) {
            if (this.f79536d != OtcTradeType.SELL) {
                i12 = 1;
            }
            ph(6, i12, true ^ b1.h().j() ? 1 : 0, String.valueOf(this.f79535c));
        } else if (i11 == 3) {
            if (this.f79536d != OtcTradeType.SELL) {
                i12 = 1;
            }
            ph(5, i12, true ^ b1.h().j() ? 1 : 0, String.valueOf(this.f79535c));
        }
    }

    public void Og() {
        Fragment m02 = getSupportFragmentManager().m0("OtcFilterMenuFragment");
        if (m02 != null) {
            getSupportFragmentManager().q().s(m02).k();
        }
        FrameLayout frameLayout = this.f79538f;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void Pg() {
        Fragment m02 = getSupportFragmentManager().m0("OtcP2pListShareFragment");
        if (m02 != null) {
            getSupportFragmentManager().q().s(m02).k();
        }
        FrameLayout frameLayout = this.f79538f;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void Qg() {
        OtcAdsFilterTopView otcAdsFilterTopView = (OtcAdsFilterTopView) this.viewFinder.b(R$id.id_ads_filter_top_view);
        this.f79537e = otcAdsFilterTopView;
        otcAdsFilterTopView.setType(1);
        this.f79537e.setFilterCallBack(this);
        this.f79537e.getIdAdsAvaiableContainer().setVisibility(8);
        this.f79537e.m();
    }

    public void Xf(String str) {
        op.a r11 = op.a.r(1);
        r11.C(str);
        oh();
        r11.y();
    }

    public void Yf() {
        op.a r11 = op.a.r(1);
        oh();
        r11.y();
    }

    public void Zf(ArrayList<Integer> arrayList) {
        op.a r11 = op.a.r(1);
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            int intValue = arrayList.get(i11).intValue();
            sb2.append(intValue);
            if (i11 < arrayList.size() - 1) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            arrayList2.add(String.valueOf(intValue));
        }
        if (TextUtils.isEmpty(sb2.toString())) {
            sb2.append(BaseApplication.c(R$string.n_otc_payment_method));
        }
        if (arrayList.size() <= 0) {
            r11.M("0");
        } else if (arrayList.size() == 1) {
            r11.M(String.valueOf(arrayList.get(0)));
        } else {
            r11.M(r11.q(arrayList2));
        }
        oh();
        r11.y();
    }

    public void addEvent() {
    }

    /* renamed from: fg */
    public OtcSeaViewPresenter createPresenter() {
        return new OtcSeaViewPresenter();
    }

    public int getContentView() {
        return R$layout.activity_otc_sea_view_room;
    }

    /* renamed from: gg */
    public OtcSeaViewPresenter.a getUI() {
        return this;
    }

    public void initView() {
        op.a.r(1).A();
        this.f79535c = getIntent().getIntExtra("coinId", 0);
        this.f79536d = (OtcTradeType) getIntent().getBundleExtra("tradeBundle").getSerializable("TradeType");
        findViewById(R$id.back).setOnClickListener(new a());
        Qg();
    }

    public void la() {
        FragmentTransaction q11 = getSupportFragmentManager().q();
        int i11 = this.f79535c;
        PublicAdsCoinFragment Th = PublicAdsCoinFragment.Th(i11, this.f79536d, va.b.g(i11), 1);
        this.f79534b = Th;
        q11.b(R$id.sea_view_list, Th);
        q11.k();
    }

    public void oh() {
        OtcAdsFilterTopView otcAdsFilterTopView;
        if (this.f79534b != null && (otcAdsFilterTopView = this.f79537e) != null) {
            otcAdsFilterTopView.m();
        }
    }

    public void ph(int i11, int i12, int i13, String str) {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView().findViewById(R$id.rl_root);
        int i14 = R$id.ad_quick_edit_container;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(i14);
        this.f79538f = frameLayout;
        if (frameLayout == null) {
            FrameLayout frameLayout2 = new FrameLayout(this);
            this.f79538f = frameLayout2;
            frameLayout2.setId(i14);
            viewGroup.addView(this.f79538f);
        }
        OtcModuleConfig.b().s(this, i11, i12, i13, str, i14, "OtcFilterMenuFragment", 1, 1);
        this.f79538f.setVisibility(0);
    }

    public void qh(String str, int i11, String str2, String str3, String str4) {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView().findViewById(R$id.rl_root);
        int i12 = R$id.ad_quick_edit_container;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(i12);
        this.f79538f = frameLayout;
        if (frameLayout == null) {
            FrameLayout frameLayout2 = new FrameLayout(this);
            this.f79538f = frameLayout2;
            frameLayout2.setId(i12);
            viewGroup.addView(this.f79538f);
        }
        OtcModuleConfig.b().N(this, str, i11, str2, str3, str4, i12, "OtcP2pListShareFragment");
        this.f79538f.setVisibility(0);
    }
}
