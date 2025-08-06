package com.huobi.asset2.index;

import al.p;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hbg.lib.common.mvp.BaseMVPFragment;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.MarqueeView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.account.entity.AccountType;
import com.huobi.asset.event.MyRocketGuideEvent;
import com.huobi.asset.event.TodayProfitHintEvent;
import com.huobi.asset.widget.AssetLoadingView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.utils.ReviewManger;
import com.huobi.view.AssetTabView;
import com.huochat.community.util.DisplayTool;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import dt.h2;
import i6.k;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k20.h;
import ky.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import qh.p0;
import rx.Observable;
import u6.g;
import wh.h0;
import wh.i0;
import wh.j0;
import wh.k0;
import wh.l0;
import wh.m0;
import wh.n0;
import wh.o0;
import wh.q0;
import wh.r0;
import wh.s0;
import wh.u0;
import wh.v0;
import wh.w0;
import wh.x0;
import wh.y0;
import wh.z0;

public class AssetIndexFragmentNew1 extends Fragment {
    public final int[] A = new int[1];
    public final ViewTreeObserver.OnGlobalLayoutListener B = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f42539b = "key_contract_bubble_showed";

    /* renamed from: c  reason: collision with root package name */
    public TabLayout f42540c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager2 f42541d;

    /* renamed from: e  reason: collision with root package name */
    public TabLayoutMediator f42542e;

    /* renamed from: f  reason: collision with root package name */
    public SmartRefreshLayout f42543f;

    /* renamed from: g  reason: collision with root package name */
    public ConstraintLayout f42544g;

    /* renamed from: h  reason: collision with root package name */
    public hk.a f42545h;

    /* renamed from: i  reason: collision with root package name */
    public String f42546i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f42547j;

    /* renamed from: k  reason: collision with root package name */
    public View f42548k;

    /* renamed from: l  reason: collision with root package name */
    public MarqueeView f42549l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f42550m;

    /* renamed from: n  reason: collision with root package name */
    public String f42551n;

    /* renamed from: o  reason: collision with root package name */
    public JSONArray f42552o;

    /* renamed from: p  reason: collision with root package name */
    public List<Fragment> f42553p;

    /* renamed from: q  reason: collision with root package name */
    public List<AssetTabView> f42554q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public View f42555r;

    /* renamed from: s  reason: collision with root package name */
    public AssetLoadingView f42556s;

    /* renamed from: t  reason: collision with root package name */
    public Double f42557t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f42558u = false;

    /* renamed from: v  reason: collision with root package name */
    public boolean f42559v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f42560w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f42561x = false;

    /* renamed from: y  reason: collision with root package name */
    public View f42562y;

    /* renamed from: z  reason: collision with root package name */
    public View f42563z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            TabLayout.Tab tabAt;
            View customView;
            if (AssetIndexFragmentNew1.this.f42540c.getTabCount() > 1 && (tabAt = AssetIndexFragmentNew1.this.f42540c.getTabAt(1)) != null && (customView = tabAt.getCustomView()) != null) {
                int[] iArr = new int[2];
                customView.getLocationOnScreen(iArr);
                int i11 = iArr[0];
                if (i11 > 0) {
                    AssetIndexFragmentNew1.this.f42540c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AssetIndexFragmentNew1.this.A[0] = i11 - ((DisplayTool.dp2px(43.0f) / 2) - (customView.getMeasuredWidth() / 2));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AssetIndexFragmentNew1.this.f42544g.getLayoutParams();
                    marginLayoutParams.setMarginStart(AssetIndexFragmentNew1.this.A[0]);
                    AssetIndexFragmentNew1.this.f42544g.setLayoutParams(marginLayoutParams);
                    AssetIndexFragmentNew1.this.f42544g.setVisibility(0);
                }
            }
        }
    }

    public class b extends FragmentStateAdapter {
        public b(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        public Fragment createFragment(int i11) {
            return AssetIndexFragmentNew1.this.f42553p.get(i11);
        }

        public int getItemCount() {
            List<Fragment> list = AssetIndexFragmentNew1.this.f42553p;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public long getItemId(int i11) {
            JSONArray jSONArray = AssetIndexFragmentNew1.this.f42552o;
            if (jSONArray != null) {
                try {
                    return (long) jSONArray.getJSONObject(i11).getInteger("distributionType").intValue();
                } catch (Throwable unused) {
                }
            }
            return super.getItemId(i11);
        }
    }

    public class c implements ny.d {
        public c() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            AssetIndexFragmentNew1.this.refreshData();
        }
    }

    public class d implements TabLayout.OnTabSelectedListener {
        public d() {
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        @SensorsDataInstrumented
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getCustomView() instanceof AssetTabView) {
                AssetTabView assetTabView = (AssetTabView) tab.getCustomView();
                assetTabView.tabSelect();
                if (!SPUtil.g("key_contract_bubble_showed", false) && assetTabView.getDistributionType().intValue() == 2) {
                    SPUtil.r("key_contract_bubble_showed", true);
                    AssetIndexFragmentNew1.this.f42544g.setVisibility(8);
                }
            }
            SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab.getCustomView() instanceof AssetTabView) {
                ((AssetTabView) tab.getCustomView()).tabUnSelect();
            }
        }
    }

    public class e extends ViewPager2.OnPageChangeCallback {
        public e() {
        }

        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
        }

        public void onPageSelected(int i11) {
            String str;
            super.onPageSelected(i11);
            if (i11 < AssetIndexFragmentNew1.this.f42552o.size()) {
                switch (AssetIndexFragmentNew1.this.f42552o.getJSONObject(i11).getInteger("distributionType").intValue()) {
                    case 1:
                        str = "app_assets_spot_tab1_click";
                        break;
                    case 2:
                        str = "app_assets_cumulative_interests_tips_click";
                        break;
                    case 3:
                        str = "app_assets_margin_interests_tips_click";
                        break;
                    case 4:
                        str = "app_assets_earn_interests_tips_click";
                        break;
                    case 5:
                        str = "app_assets_otc_interests_tips_click";
                        break;
                    case 6:
                        str = "app_assets_option_interests_tips_click";
                        break;
                    default:
                        str = "";
                        break;
                }
                BaseModuleConfig.a().w(str, (HashMap) null);
            }
        }
    }

    public static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42569a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent[] r0 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42569a = r0
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_WIFI_CONNECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42569a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_MOBILE_CONNECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42569a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_NET_VPN_CONNECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42569a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_NET_DISCONNECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.AssetIndexFragmentNew1.f.<clinit>():void");
        }
    }

    static {
        Class<AssetIndexFragmentNew1> cls = AssetIndexFragmentNew1.class;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Sh(View view) {
        if (!TextUtils.isEmpty(this.f42551n)) {
            mi(view.getContext(), this.f42551n);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Th(View view) {
        boolean c11 = NetworkStatus.c(getContext());
        this.f42560w = c11;
        if (c11) {
            this.f42556s.setState(1);
            this.f42545h.a().I("refreshData()");
        } else {
            HuobiToastUtil.j(R$string.n_check_network);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(View view, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f42544g.getLayoutParams();
        marginLayoutParams.setMarginStart(this.A[0] - i11);
        this.f42544g.setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        this.f42556s.setState(0);
        k.f("IndexHome", "totalBalanceData=:" + obj);
        p0.n().A(obj.toString());
        qi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(Object obj) {
        if (!this.f42561x) {
            this.f42556s.setState(2);
            return;
        }
        this.f42556s.setState(0);
        qi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xh(Object obj) {
        if (obj != null) {
            JSONObject parseObject = JSON.parseObject(obj.toString());
            parseObject.getBoolean("succeed");
            JSONArray jSONArray = parseObject.getJSONArray("msgList");
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            if (jSONArray != null && !jSONArray.isEmpty()) {
                for (int i11 = 0; i11 < jSONArray.size(); i11++) {
                    stringBuffer.append(jSONArray.get(i11).toString());
                    stringBuffer2.append(jSONArray.get(i11).toString());
                    if (i11 < jSONArray.size() - 1) {
                        stringBuffer.append("      ");
                        stringBuffer2.append("\n");
                    }
                }
            }
            this.f42551n = stringBuffer2.toString();
            if (!ReviewManger.a()) {
                ri(stringBuffer.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yh(Object obj) {
        showMyRocketGuide(new MyRocketGuideEvent());
    }

    public static /* synthetic */ List Zh(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Object ai(List list, Integer num, Integer num2, Integer num3, Map map, List list2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bi(Object obj) {
        this.f42545h.a().I("refreshData()");
    }

    public static /* synthetic */ List ei(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer fi(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer gi(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer hi(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Map ii(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ji(Map map, TabLayout.Tab tab, int i11) {
        if (getContext() != null) {
            AssetTabView assetTabView = new AssetTabView(getContext());
            if (i11 < this.f42552o.size()) {
                JSONObject jSONObject = this.f42552o.getJSONObject(i11);
                String string = p.u() ? jSONObject.getString("assetRatio") : "****";
                CharSequence charSequence = (CharSequence) map.get(jSONObject.getInteger("distributionType"));
                if (TextUtils.isEmpty(string)) {
                    string = "--";
                }
                assetTabView.setText(charSequence, string);
                assetTabView.setDistributionType(jSONObject.getInteger("distributionType"));
                tab.setCustomView((View) assetTabView);
                this.f42554q.add(assetTabView);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v9, types: [com.huobi.asset2.index.tabfragment.fiat.AssetFiatTabChildFragment, com.huobi.asset2.index.BaseAssetChildTabFragment] */
    /* JADX WARNING: type inference failed for: r1v10, types: [com.huobi.asset2.index.tabfragment.options.AssetOptionsTabChildFragment, com.huobi.asset2.index.BaseAssetChildTabFragment] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void ki(java.util.Map r8, java.lang.Object r9) {
        /*
            r7 = this;
            r0 = 1
            r7.f42561x = r0
            java.util.List<androidx.fragment.app.Fragment> r0 = r7.f42553p
            r0.clear()
            if (r9 != 0) goto L_0x000d
            java.lang.String r9 = "[]"
            goto L_0x0011
        L_0x000d:
            java.lang.String r9 = r9.toString()
        L_0x0011:
            com.alibaba.fastjson.JSONArray r9 = com.alibaba.fastjson.JSON.parseArray(r9)
            r7.f42552o = r9
            r9 = 0
        L_0x0018:
            com.alibaba.fastjson.JSONArray r0 = r7.f42552o
            int r0 = r0.size()
            if (r9 >= r0) goto L_0x0102
            com.alibaba.fastjson.JSONArray r0 = r7.f42552o
            com.alibaba.fastjson.JSONObject r0 = r0.getJSONObject(r9)
            java.lang.String r1 = "distributionType"
            java.lang.Integer r1 = r0.getInteger(r1)
            int r1 = r1.intValue()
            java.lang.String r2 = "asset_contract_config"
            switch(r1) {
                case 1: goto L_0x00ef;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00ca;
                case 4: goto L_0x0074;
                case 5: goto L_0x0068;
                case 6: goto L_0x005c;
                case 7: goto L_0x0041;
                default: goto L_0x0035;
            }
        L_0x0035:
            com.huobi.asset2.index.tabfragment.spot.AssetSpotTabFragment r1 = new com.huobi.asset2.index.tabfragment.spot.AssetSpotTabFragment
            r1.<init>()
            hk.a r0 = r7.f42545h
            r1.Ah(r0)
            goto L_0x00f9
        L_0x0041:
            com.huobi.asset2.index.tabfragment.bot.AssetTabBotFragment r1 = new com.huobi.asset2.index.tabfragment.bot.AssetTabBotFragment
            r1.<init>()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r0 = r0.toJSONString()
            r3.putString(r2, r0)
            r1.setArguments(r3)
            hk.a r0 = r7.f42545h
            r1.Ah(r0)
            goto L_0x00f9
        L_0x005c:
            com.huobi.asset2.index.tabfragment.options.AssetOptionsTabChildFragment r1 = new com.huobi.asset2.index.tabfragment.options.AssetOptionsTabChildFragment
            r1.<init>()
            hk.a r0 = r7.f42545h
            r1.Sh(r0)
            goto L_0x00f9
        L_0x0068:
            com.huobi.asset2.index.tabfragment.fiat.AssetFiatTabChildFragment r1 = new com.huobi.asset2.index.tabfragment.fiat.AssetFiatTabChildFragment
            r1.<init>()
            hk.a r0 = r7.f42545h
            r1.Sh(r0)
            goto L_0x00f9
        L_0x0074:
            com.huobi.asset2.index.tabfragment.earn.AssetTabEarnFragment r1 = new com.huobi.asset2.index.tabfragment.earn.AssetTabEarnFragment
            r1.<init>()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r4 = r0.toJSONString()
            r3.putString(r2, r4)
            r1.setArguments(r3)
            hk.a r2 = r7.f42545h
            r1.Ah(r2)
            boolean r2 = r7.isAdded()     // Catch:{ Exception -> 0x00c5 }
            if (r2 == 0) goto L_0x00f9
            androidx.fragment.app.FragmentManager r2 = r7.getChildFragmentManager()     // Catch:{ Exception -> 0x00c5 }
            java.util.List r2 = r2.B0()     // Catch:{ Exception -> 0x00c5 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00c5 }
        L_0x009f:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x00c5 }
            if (r4 == 0) goto L_0x00f9
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x00c5 }
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4     // Catch:{ Exception -> 0x00c5 }
            boolean r5 = r4 instanceof com.huobi.asset2.index.tabfragment.earn.AssetTabEarnFragment     // Catch:{ Exception -> 0x00c5 }
            if (r5 == 0) goto L_0x009f
            r5 = r4
            com.huobi.asset2.index.tabfragment.earn.AssetTabEarnFragment r5 = (com.huobi.asset2.index.tabfragment.earn.AssetTabEarnFragment) r5     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r6 = r0.toJSONString()     // Catch:{ Exception -> 0x00c5 }
            boolean r5 = r5.Ch(r6)     // Catch:{ Exception -> 0x00c5 }
            if (r5 == 0) goto L_0x009f
            r4.setArguments(r3)     // Catch:{ Exception -> 0x00c5 }
            com.huobi.asset2.index.tabfragment.earn.AssetTabEarnFragment r4 = (com.huobi.asset2.index.tabfragment.earn.AssetTabEarnFragment) r4     // Catch:{ Exception -> 0x00c5 }
            r4.Wg()     // Catch:{ Exception -> 0x00c5 }
            goto L_0x009f
        L_0x00c5:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00f9
        L_0x00ca:
            com.huobi.asset2.index.tabfragment.margin.AssetMarginTabFragment r1 = new com.huobi.asset2.index.tabfragment.margin.AssetMarginTabFragment
            r1.<init>()
            hk.a r0 = r7.f42545h
            r1.Ah(r0)
            goto L_0x00f9
        L_0x00d5:
            com.huobi.asset2.index.tabfragment.contract.AssetContractTabFragment r1 = new com.huobi.asset2.index.tabfragment.contract.AssetContractTabFragment
            r1.<init>()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r0 = r0.toJSONString()
            r3.putString(r2, r0)
            r1.setArguments(r3)
            hk.a r0 = r7.f42545h
            r1.Ah(r0)
            goto L_0x00f9
        L_0x00ef:
            com.huobi.asset2.index.tabfragment.spot.AssetSpotTabFragment r1 = new com.huobi.asset2.index.tabfragment.spot.AssetSpotTabFragment
            r1.<init>()
            hk.a r0 = r7.f42545h
            r1.Ah(r0)
        L_0x00f9:
            java.util.List<androidx.fragment.app.Fragment> r0 = r7.f42553p
            r0.add(r1)
            int r9 = r9 + 1
            goto L_0x0018
        L_0x0102:
            androidx.viewpager2.widget.ViewPager2 r9 = r7.f42541d
            androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.getAdapter()
            r9.notifyDataSetChanged()
            com.google.android.material.tabs.TabLayout r9 = r7.f42540c
            r0 = 0
            r9.setSelectedTabIndicator((android.graphics.drawable.Drawable) r0)
            java.util.List<com.huobi.view.AssetTabView> r9 = r7.f42554q
            r9.clear()
            com.google.android.material.tabs.TabLayoutMediator r9 = new com.google.android.material.tabs.TabLayoutMediator
            com.google.android.material.tabs.TabLayout r0 = r7.f42540c
            androidx.viewpager2.widget.ViewPager2 r1 = r7.f42541d
            wh.t0 r2 = new wh.t0
            r2.<init>(r7, r8)
            r9.<init>(r0, r1, r2)
            r7.f42542e = r9
            r9.attach()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.AssetIndexFragmentNew1.ki(java.util.Map, java.lang.Object):void");
    }

    public void Mh() {
        this.f42543f.e0(new c());
        this.f42540c.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        this.f42541d.registerOnPageChangeCallback(new e());
        this.f42550m.setOnClickListener(new r0(this));
        this.f42556s.setRetryListener(new h0(this));
    }

    public final void Nh() {
        try {
            if (!SPUtil.g("key_contract_bubble_showed", true)) {
                this.f42540c.getViewTreeObserver().addOnGlobalLayoutListener(this.B);
                this.f42540c.setOnScrollChangeListener(new s0(this));
            }
        } catch (Throwable th2) {
            i6.d.g(th2);
        }
    }

    public final void Oh() {
        hk.a aVar = new hk.a(getContext());
        this.f42545h = aVar;
        aVar.c();
        this.f42545h.a().v("totalBalanceData", new wh.p0(this));
        this.f42545h.a().v("totalError", new o0(this));
        this.f42545h.a().v("totalTipsError", new m0(this));
        this.f42545h.a().v("assetRocketFinished", new n0(this));
    }

    public final void Ph() {
        this.f42549l.setRate(getResources().getDimension(R$dimen.dimen_15));
        this.f42549l.setTextSpace(getResources().getDimension(R$dimen.dimen_170));
        this.f42549l.setTextSize((float) getResources().getDimensionPixelSize(R$dimen.global_text_size_12));
        this.f42549l.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
        this.f42549l.setPaintAntiAlias(true);
        String string = getString(R$string.currency_order_detail);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new UnderlineSpan(), 0, string.length(), 33);
        this.f42550m.setText(spannableStringBuilder);
    }

    public final void Qh() {
        View findViewById = this.f42562y.findViewById(R$id.asset_page_status_bar);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = BaseActivity.getStatusBarHeight(findViewById.getContext());
        findViewById.setLayoutParams(layoutParams);
    }

    public final void Rh() {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f42562y.findViewById(R$id.refresh_layout);
        this.f42543f = smartRefreshLayout;
        smartRefreshLayout.j0(new SmartRefreshHeader(getActivity()));
        this.f42543f.g(false);
        View E = this.f42545h.a().E("asset_summary.xml", getContext(), false, (JSONObject) null);
        this.f42563z = E;
        ((LinearLayout) this.f42562y.findViewById(R$id.ll_asset_header)).addView(E);
    }

    @h(threadMode = ThreadMode.MAIN)
    public void appBarExpandedEvent(gh.a aVar) {
        if (aVar != null) {
            ((AppBarLayout) this.f42562y.findViewById(R$id.app_bar)).setExpanded(aVar.a().booleanValue());
        }
    }

    public void finishRefresh() {
        SmartRefreshLayout smartRefreshLayout = this.f42543f;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
    }

    public void initViews() {
        Qh();
        this.f42544g = (ConstraintLayout) this.f42562y.findViewById(R$id.clContractApyBubble);
        this.f42540c = (TabLayout) this.f42562y.findViewById(R$id.asset_tab_layout_new);
        ViewPager2 viewPager2 = (ViewPager2) this.f42562y.findViewById(R$id.asset_tab_view_pager);
        this.f42541d = viewPager2;
        viewPager2.setUserInputEnabled(false);
        this.f42555r = this.f42562y.findViewById(R$id.asset_index_top_navigation);
        this.f42556s = (AssetLoadingView) this.f42562y.findViewById(R$id.asset_index_top_loading);
        this.f42548k = this.f42562y.findViewById(R$id.ipRestrictionsTipsContainer);
        this.f42549l = (MarqueeView) this.f42562y.findViewById(R$id.ipRestrictionsTips);
        this.f42550m = (TextView) this.f42562y.findViewById(R$id.ipRestrictionsTips_detail);
        if (this.f42560w) {
            this.f42556s.setState(1);
            li();
        } else {
            this.f42556s.setState(2);
        }
        this.f42545h.a().E("asset_header.xml", getContext(), false, (JSONObject) null);
        this.f42547j = (LinearLayout) this.f42562y.findViewById(R$id.ll_asset_top_header);
        Rh();
        Ph();
        try {
            pi();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        Nh();
    }

    public final void li() {
        Observable.zip(FutureContractInfoController.n().s(true).onErrorReturn(z0.f61356b), a7.e.K(TradeType.CONTRACT).onErrorReturn(k0.f61314b), a7.e.K(TradeType.SWAP).onErrorReturn(j0.f61311b), a7.e.K(TradeType.LINEAR_SWAP).onErrorReturn(y0.f61354b), LegalCurrencyConfigUtil.e().onErrorReturn(i0.f61307b), LinearSwapProductInfoController.o().j(false).onErrorReturn(x0.f61352b), l0.f61317b).compose(RxJavaHelper.t((g) null)).timeout(5, TimeUnit.SECONDS).subscribe(EasySubscriber.create(new u0(this), v0.f61347b, w0.f61349b));
        h2.t1().b1(TradeType.PRO, AccountType.spot.toString()).compose(RxJavaHelper.t((g) null)).subscribe();
    }

    public final void mi(Context context, String str) {
        String string = context.getString(R$string.n_otc_use_tip);
        FragmentActivity activity = getActivity();
        new DialogUtils.b.d(activity).c1(string).i1(5).C0(str).P0(context.getString(R$string.allow_access_dialog_positive_btn)).E0(true).T0(false).x0(false).q0(false).Q0(bj.o0.f12469a).j0().show(activity.getSupportFragmentManager(), "");
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void netWorkChangeEvent(NetworkStatus.ConnectEvent connectEvent) {
        boolean c11 = NetworkStatus.c(getContext());
        int i11 = f.f42569a[connectEvent.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            if (!this.f42560w && c11) {
                this.f42560w = true;
                if (!this.f42561x) {
                    this.f42556s.setState(1);
                }
                hk.a aVar = this.f42545h;
                if (aVar != null && aVar.a() != null) {
                    this.f42545h.a().I("onAppear()");
                }
            }
        } else if (i11 == 4 && this.f42560w && !c11) {
            this.f42560w = false;
        }
    }

    public final void ni(boolean z11) {
        if (!this.f42558u || !z11 || !isAdded() || oi()) {
            this.f42559v = false;
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).getWindow().setSoftInputMode(3);
            }
        } else if (!this.f42559v) {
            this.f42559v = true;
            String uid = BaseModuleConfig.a().getUid();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).getWindow().setSoftInputMode(32);
            }
            if (!uid.equalsIgnoreCase(this.f42546i)) {
                this.f42546i = uid;
                hk.a aVar = this.f42545h;
                if (!(aVar == null || aVar.a() == null)) {
                    this.f42545h.a().I("clearData()");
                }
            }
            hk.a aVar2 = this.f42545h;
            if (aVar2 != null && aVar2.a() != null) {
                this.f42545h.a().I("onAppear()");
            }
        }
    }

    public boolean oi() {
        if (getParentFragment() == null) {
            return isHidden();
        }
        if (getParentFragment() instanceof BaseMVPFragment) {
            if (((BaseMVPFragment) getParentFragment()).vh() || isHidden()) {
                return true;
            }
            return false;
        } else if (!isHidden() || !getParentFragment().isHidden()) {
            return false;
        } else {
            return true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        Oh();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f42562y = layoutInflater.inflate(R$layout.fragment_asset_index_new_1, viewGroup, false);
        this.f42560w = NetworkStatus.c(getContext());
        initViews();
        Mh();
        this.f42558u = true;
        return this.f42562y;
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f42540c.getViewTreeObserver().removeOnGlobalLayoutListener(this.B);
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        ni(!z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onHideAmountEvent(gh.b bVar) {
        if (this.f42552o != null && this.f42554q != null) {
            int i11 = 0;
            while (i11 < this.f42552o.size() && i11 < this.f42554q.size()) {
                this.f42554q.get(i11).setSubText(p.u() ? this.f42552o.getJSONObject(i11).getString("assetRatio") : "****");
                i11++;
            }
        }
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        ni(false);
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (!TextUtils.isEmpty(proTokenUpdate.getProToken())) {
            this.f42545h.a().I("refreshData()");
        }
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        ni(true);
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getActivity() != null) {
            AssetModuleConfig.a().g(getActivity());
        }
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public final void pi() {
        HashMap hashMap = new HashMap();
        hashMap.put(1, getContext().getResources().getString(R$string.n_title_spot));
        hashMap.put(2, getContext().getResources().getString(R$string.n_title_future));
        hashMap.put(3, getContext().getResources().getString(R$string.n_kline_loan));
        hashMap.put(4, getContext().getResources().getString(R$string.n_asset_ybb_stop_financial));
        hashMap.put(5, getContext().getResources().getString(R$string.n_blance_fiat_assets));
        hashMap.put(6, getContext().getResources().getString(R$string.n_option));
        hashMap.put(7, getContext().getResources().getString(R$string.n_trade_bot_key));
        this.f42553p = new ArrayList();
        this.f42541d.setOffscreenPageLimit(6);
        this.f42541d.setAdapter(new b(getChildFragmentManager(), getLifecycle()));
        this.f42545h.a().v("profitAccountBalanceList", new q0(this, hashMap));
    }

    public final void qi() {
        if (p0.n().q()) {
            this.f42555r.setVisibility(8);
            this.f42555r.setVisibility(8);
            this.f42541d.setVisibility(8);
            this.f42556s.setVisibility(0);
            this.f42556s.setState(4);
            return;
        }
        this.f42555r.setVisibility(0);
        this.f42555r.setVisibility(0);
        this.f42541d.setVisibility(0);
        this.f42556s.setVisibility(8);
    }

    public final void refreshData() {
        boolean c11 = NetworkStatus.c(getContext());
        this.f42560w = c11;
        if (c11) {
            this.f42545h.a().I("refreshData()");
        } else {
            HuobiToastUtil.j(R$string.n_check_network);
        }
        finishRefresh();
    }

    public final void ri(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f42548k.setVisibility(8);
            return;
        }
        this.f42548k.setVisibility(0);
        this.f42549l.setTextFix(str);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        ni(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    @h(threadMode = ThreadMode.MAIN)
    public void showMyRocketGuide(MyRocketGuideEvent myRocketGuideEvent) {
    }

    @h(threadMode = ThreadMode.MAIN)
    public void showTodayProfitHint(TodayProfitHintEvent todayProfitHintEvent) {
        if (todayProfitHintEvent != null) {
            View findViewWithTag = this.f42563z.findViewWithTag("-1234");
            int[] iArr = new int[2];
            findViewWithTag.getLocationOnScreen(iArr);
            uh.b.c(findViewWithTag, getString(R$string.n_balance_asset_maintain_tips), iArr[0] - PixelUtils.a(2.0f));
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    public void updateAssetProfitRate(Double d11) {
        if (d11 != null) {
            if (this.f42557t == null) {
                this.f42557t = d11;
            } else if (m.a(String.valueOf(Math.abs(d11.doubleValue() - this.f42557t.doubleValue()))).compareTo(m.a("0.05")) >= 0) {
                this.f42557t = d11;
                hk.a aVar = this.f42545h;
                if (aVar != null && aVar.a() != null) {
                    this.f42545h.a().I("showProfitRed()");
                }
            }
        }
    }
}
