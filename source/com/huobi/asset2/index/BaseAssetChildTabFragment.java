package com.huobi.asset2.index;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import uh.b;
import wh.a1;
import wh.b1;
import wh.c1;
import wh.d1;
import wh.e1;
import wh.f1;
import wh.g1;
import wh.h1;
import wh.i1;
import wh.j1;
import wh.q1;
import wh.r1;

public abstract class BaseAssetChildTabFragment extends Fragment implements r1 {

    /* renamed from: n  reason: collision with root package name */
    public static List<String> f42570n = Collections.singletonList("1");

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f42571b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f42572c;

    /* renamed from: d  reason: collision with root package name */
    public q1 f42573d;

    /* renamed from: e  reason: collision with root package name */
    public hk.a f42574e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42575f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42576g = false;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f42577h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f42578i;

    /* renamed from: j  reason: collision with root package name */
    public InputMethodManager f42579j;

    /* renamed from: k  reason: collision with root package name */
    public EditText f42580k;

    /* renamed from: l  reason: collision with root package name */
    public Subscription f42581l;

    /* renamed from: m  reason: collision with root package name */
    public List<String> f42582m = Arrays.asList(new String[]{"15", "17", "18", "20"});

    public class a implements TextWatcher {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Boolean c(Long l11) {
            hk.a aVar = BaseAssetChildTabFragment.this.f42574e;
            return Boolean.valueOf((aVar == null || aVar.a() == null) ? false : true);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Editable editable, Long l11) {
            if (editable.length() > 0) {
                BaseAssetChildTabFragment.this.f42574e.a().I(String.format("searchCoinEvent('%s','%s')", new Object[]{BaseAssetChildTabFragment.this.Se(), editable.toString()}));
                return;
            }
            BaseAssetChildTabFragment.this.f42574e.a().I(String.format("searchCoinEvent('%s','%s')", new Object[]{BaseAssetChildTabFragment.this.Se(), ""}));
        }

        public void afterTextChanged(Editable editable) {
            if (BaseAssetChildTabFragment.this.f42581l != null && !BaseAssetChildTabFragment.this.f42581l.isUnsubscribed()) {
                BaseAssetChildTabFragment.this.f42581l.unsubscribe();
            }
            Subscription unused = BaseAssetChildTabFragment.this.f42581l = Observable.timer(500, TimeUnit.MILLISECONDS).compose(RxJavaHelper.s()).filter(new j1(this)).subscribe(new i1(this, editable));
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ih(View view) {
        if (this.f42580k.getVisibility() == 8) {
            this.f42580k.setVisibility(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jh(AtomicLong atomicLong, AtomicBoolean atomicBoolean, View view, boolean z11) {
        if (System.currentTimeMillis() - atomicLong.get() > 300) {
            atomicLong.set(System.currentTimeMillis());
            atomicBoolean.set(z11);
            if (!z11) {
                this.f42579j.hideSoftInputFromWindow(view.getWindowToken(), 0);
                if (TextUtils.isEmpty(this.f42580k.getText().toString())) {
                    this.f42580k.setVisibility(8);
                    return;
                }
                return;
            }
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).getWindow().setSoftInputMode(32);
            }
            EventBus.d().k(new gh.a(Boolean.FALSE));
            this.f42579j.showSoftInput(view, 2);
        } else if (atomicBoolean.get()) {
            this.f42580k.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        this.f42574e.a().I(String.format("jump('%s')", new Object[]{BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP}));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Lh(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 3) {
            return false;
        }
        this.f42579j.hideSoftInputFromWindow(this.f42580k.getWindowToken(), 0);
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(ImageView imageView, View view) {
        boolean z11 = !this.f42576g;
        this.f42576g = z11;
        if (z11) {
            if (this.f42577h == null) {
                this.f42577h = ContextCompat.getDrawable(getContext(), R$drawable.ic_asset_hidden_small_select);
            }
            imageView.setImageDrawable(this.f42577h);
        } else {
            if (this.f42578i == null) {
                this.f42578i = ContextCompat.getDrawable(getContext(), R$drawable.ic_asset_hidden_small_unselect);
            }
            imageView.setImageDrawable(this.f42578i);
        }
        hk.a aVar = this.f42574e;
        if (!(aVar == null || aVar.a() == null)) {
            this.f42574e.a().I(String.format("hiddenSmallAsset('%s')", new Object[]{Se()}));
        }
        Qh(this.f42576g);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        String string = getResources().getString(R$string.n_asset_hide_small_amount_tips);
        if (Se().equalsIgnoreCase("2") || Se().equalsIgnoreCase("3")) {
            string = getResources().getString(R$string.n_asset_margin_hidden_small_asset_tip);
        }
        b.c(view, string, PixelUtils.a(40.0f));
        Fh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        EventBus.d().k(new gh.a(Boolean.FALSE));
        Rh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        JSONObject parseObject = JSON.parseObject(obj.toString());
        String string = parseObject.getString("code");
        Boolean bool = parseObject.getBoolean("succeed");
        this.f42573d.l(string, bool != null ? bool.booleanValue() : true);
    }

    public abstract String Ah();

    public void Bf() {
        EditText editText = this.f42580k;
        if (editText != null) {
            editText.clearFocus();
        }
    }

    public View Bh() {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.item_balance_func_v2, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_hide_small_select_icon);
        View findViewById = inflate.findViewById(R$id.tv_small_coin_to_htx);
        View findViewById2 = inflate.findViewById(R$id.total_balance_hide_zero_balance);
        View findViewById3 = inflate.findViewById(R$id.iv_search);
        this.f42580k = (EditText) inflate.findViewById(R$id.total_balance_search);
        ViewUtil.m(inflate, !this.f42582m.contains(Se()));
        Th(imageView);
        findViewById3.setOnClickListener(new b1(this));
        if (this.f42579j == null) {
            this.f42579j = (InputMethodManager) getContext().getSystemService("input_method");
        }
        this.f42580k.setOnFocusChangeListener(new f1(this, new AtomicLong(), new AtomicBoolean()));
        findViewById.setOnClickListener(new d1(this));
        this.f42580k.setOnEditorActionListener(new g1(this));
        imageView.setOnClickListener(new e1(this, imageView));
        this.f42580k.addTextChangedListener(new a());
        findViewById2.setOnClickListener(new c1(this));
        this.f42580k.setOnClickListener(new a1(this));
        return inflate;
    }

    public int Ch() {
        if (getActivity() == null) {
            return PixelUtils.a(52.0f);
        }
        View findViewById = getActivity().findViewById(R$id.main_tab);
        if (findViewById == null) {
            return PixelUtils.a(52.0f);
        }
        return findViewById.getHeight();
    }

    public int Dh() {
        return (PixelUtils.f() - PixelUtils.a(93.0f)) - Ch();
    }

    public final String Eh() {
        return "save_hide_small_asset_key_" + Se() + BaseModuleConfig.a().getUid();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Fh() {
        /*
            r5 = this;
            java.lang.String r0 = r5.Se()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            int r2 = r0.hashCode()
            r3 = 49
            r4 = 1
            if (r2 == r3) goto L_0x002f
            r3 = 1571(0x623, float:2.201E-42)
            if (r2 == r3) goto L_0x0025
            r3 = 1572(0x624, float:2.203E-42)
            if (r2 == r3) goto L_0x001b
            goto L_0x0039
        L_0x001b:
            java.lang.String r2 = "15"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = 2
            goto L_0x003a
        L_0x0025:
            java.lang.String r2 = "14"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = r4
            goto L_0x003a
        L_0x002f:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = -1
        L_0x003a:
            java.lang.String r2 = "app_assets_hide_small_balances_tips_click"
            java.lang.String r3 = "type"
            if (r0 == 0) goto L_0x0050
            if (r0 == r4) goto L_0x0043
            goto L_0x005c
        L_0x0043:
            java.lang.String r0 = "collatera"
            r1.put(r3, r0)
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
            r0.w(r2, r1)
            goto L_0x005c
        L_0x0050:
            java.lang.String r0 = "spot"
            r1.put(r3, r0)
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
            r0.w(r2, r1)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.BaseAssetChildTabFragment.Fh():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Gh(boolean r6) {
        /*
            r5 = this;
            java.lang.String r0 = r5.Se()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            int r2 = r0.hashCode()
            r3 = 49
            r4 = 1
            if (r2 == r3) goto L_0x002f
            r3 = 1571(0x623, float:2.201E-42)
            if (r2 == r3) goto L_0x0025
            r3 = 1572(0x624, float:2.203E-42)
            if (r2 == r3) goto L_0x001b
            goto L_0x0039
        L_0x001b:
            java.lang.String r2 = "15"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = 2
            goto L_0x003a
        L_0x0025:
            java.lang.String r2 = "14"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = r4
            goto L_0x003a
        L_0x002f:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = -1
        L_0x003a:
            java.lang.String r2 = "app_assets_hide_small_balances_click"
            java.lang.String r3 = "box"
            if (r0 == 0) goto L_0x0055
            if (r0 == r4) goto L_0x0043
            goto L_0x0066
        L_0x0043:
            if (r6 == 0) goto L_0x0048
            java.lang.String r6 = "collatera_check"
            goto L_0x004a
        L_0x0048:
            java.lang.String r6 = "collatera_uncheck"
        L_0x004a:
            r1.put(r3, r6)
            com.hbg.lib.core.BaseModuleConfig$a r6 = com.hbg.lib.core.BaseModuleConfig.a()
            r6.w(r2, r1)
            goto L_0x0066
        L_0x0055:
            if (r6 == 0) goto L_0x005a
            java.lang.String r6 = "spot_check"
            goto L_0x005c
        L_0x005a:
            java.lang.String r6 = "spot_uncheck"
        L_0x005c:
            r1.put(r3, r6)
            com.hbg.lib.core.BaseModuleConfig$a r6 = com.hbg.lib.core.BaseModuleConfig.a()
            r6.w(r2, r1)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.BaseAssetChildTabFragment.Gh(boolean):void");
    }

    public final void Hh() {
        hk.a aVar;
        if (f42570n.contains(Se())) {
            boolean l11 = SP.l(Eh(), false);
            this.f42576g = l11;
            if (l11 && (aVar = this.f42574e) != null && aVar.a() != null) {
                this.f42574e.a().I(String.format("hiddenSmallAsset('%s')", new Object[]{Se()}));
            }
        }
    }

    public void Qh(boolean z11) {
        if (f42570n.contains(Se())) {
            SP.y(Eh(), z11);
        }
        Gh(z11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Rh() {
        /*
            r5 = this;
            java.lang.String r0 = r5.Se()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            int r2 = r0.hashCode()
            r3 = 49
            r4 = 1
            if (r2 == r3) goto L_0x002f
            r3 = 1571(0x623, float:2.201E-42)
            if (r2 == r3) goto L_0x0025
            r3 = 1572(0x624, float:2.203E-42)
            if (r2 == r3) goto L_0x001b
            goto L_0x0039
        L_0x001b:
            java.lang.String r2 = "15"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = 2
            goto L_0x003a
        L_0x0025:
            java.lang.String r2 = "14"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = r4
            goto L_0x003a
        L_0x002f:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0039
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = -1
        L_0x003a:
            java.lang.String r2 = "app_assets_search_click"
            java.lang.String r3 = "type"
            if (r0 == 0) goto L_0x0050
            if (r0 == r4) goto L_0x0043
            goto L_0x005c
        L_0x0043:
            java.lang.String r0 = "collatera"
            r1.put(r3, r0)
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
            r0.w(r2, r1)
            goto L_0x005c
        L_0x0050:
            java.lang.String r0 = "spot"
            r1.put(r3, r0)
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
            r0.w(r2, r1)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.BaseAssetChildTabFragment.Rh():void");
    }

    public abstract String Se();

    public void Sh(hk.a aVar) {
        this.f42574e = aVar;
    }

    public final void Th(ImageView imageView) {
        if (this.f42576g) {
            if (this.f42577h == null) {
                this.f42577h = ContextCompat.getDrawable(getContext(), R$drawable.ic_asset_hidden_small_select);
            }
            imageView.setImageDrawable(this.f42577h);
            return;
        }
        if (this.f42578i == null) {
            this.f42578i = ContextCompat.getDrawable(getContext(), R$drawable.ic_asset_hidden_small_unselect);
        }
        imageView.setImageDrawable(this.f42578i);
    }

    public void initViews() {
        RecyclerView recyclerView = (RecyclerView) this.f42571b.findViewById(R$id.asset_tab_child_list);
        this.f42572c = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f42572c.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f42572c.getLayoutParams().height = Dh();
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.m(2, 12);
        this.f42572c.setRecycledViewPool(recycledViewPool);
        StableLinearLayoutManager stableLinearLayoutManager = new StableLinearLayoutManager(getContext());
        stableLinearLayoutManager.setMeasurementCacheEnabled(false);
        this.f42572c.setLayoutManager(stableLinearLayoutManager);
        q1 zh2 = zh();
        this.f42573d = zh2;
        this.f42572c.setAdapter(zh2);
        hk.a aVar = this.f42574e;
        if (!(aVar == null || aVar.a() == null)) {
            this.f42574e.a().v(Ah(), new h1(this));
        }
        if (Se().equals("20")) {
            ViewUtil.m(this.f42572c, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f42571b = (ViewGroup) layoutInflater.inflate(R$layout.fragment_asset_tab_child_layout, viewGroup, false);
        Hh();
        initViews();
        return this.f42571b;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        InputMethodManager inputMethodManager;
        EditText editText;
        super.onPause();
        if (!(!isAdded() || (inputMethodManager = this.f42579j) == null || (editText = this.f42580k) == null)) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        hk.a aVar = this.f42574e;
        if (!(aVar == null || aVar.a() == null || !this.f42575f)) {
            this.f42574e.a().I(String.format("assetTabEvent('%s')", new Object[]{Se()}));
        }
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public q1 zh() {
        return new q1(this.f42574e, this);
    }
}
