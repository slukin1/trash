package com.huobi.asset2.index.tabfragment.spot;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fi.d;
import fi.e;
import fi.f;
import fi.g;
import fi.h;
import fi.i;
import fi.j;
import fi.k;
import fi.l;
import fi.s;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.greenrobot.eventbus.EventBus;
import uh.b;
import wh.q1;

public class AssetCollateralTabChildFragment extends BaseAssetChildTabFragment {

    /* renamed from: o  reason: collision with root package name */
    public boolean f42758o = false;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f42759p;

    /* renamed from: q  reason: collision with root package name */
    public Drawable f42760q;

    /* renamed from: r  reason: collision with root package name */
    public InputMethodManager f42761r;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() <= 0) {
                if (AssetCollateralTabChildFragment.this.f42574e != null && AssetCollateralTabChildFragment.this.f42574e.a() != null) {
                    AssetCollateralTabChildFragment.this.f42574e.a().I(String.format("searchCoinEvent('%s','%s')", new Object[]{AssetCollateralTabChildFragment.this.Se(), editable.toString()}));
                }
            } else if (AssetCollateralTabChildFragment.this.f42574e != null && AssetCollateralTabChildFragment.this.f42574e.a() != null) {
                AssetCollateralTabChildFragment.this.f42574e.a().I(String.format("searchCoinEvent('%s','%s')", new Object[]{AssetCollateralTabChildFragment.this.Se(), editable.toString()}));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        JSONObject parseObject = JSON.parseObject(obj.toString());
        ((s) this.f42573d).w(parseObject.getJSONArray("loanedList"), parseObject.getJSONArray("collateralList"));
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void ji(EditText editText, View view) {
        if (editText.getVisibility() == 8) {
            editText.setVisibility(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ki(ImageView imageView, View view) {
        boolean z11 = !this.f42758o;
        this.f42758o = z11;
        if (z11) {
            if (this.f42759p == null) {
                this.f42759p = ContextCompat.getDrawable(getContext(), R$drawable.ic_asset_hidden_small_select);
            }
            imageView.setImageDrawable(this.f42759p);
        } else {
            if (this.f42760q == null) {
                this.f42760q = ContextCompat.getDrawable(getContext(), R$drawable.ic_asset_hidden_small_unselect);
            }
            imageView.setImageDrawable(this.f42760q);
        }
        hk.a aVar = this.f42574e;
        if (!(aVar == null || aVar.a() == null)) {
            this.f42574e.a().I(String.format("hiddenSmallAsset('%s')", new Object[]{Se()}));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("box", this.f42758o ? "collatera_check" : "collatera_uncheck");
        BaseModuleConfig.a().w("app_assets_hide_small_balances_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void li(AtomicLong atomicLong, AtomicBoolean atomicBoolean, EditText editText, View view, boolean z11) {
        if (System.currentTimeMillis() - atomicLong.get() > 300) {
            atomicLong.set(System.currentTimeMillis());
            atomicBoolean.set(z11);
            if (z11) {
                EventBus.d().k(new gh.a(Boolean.FALSE));
            } else if (TextUtils.isEmpty(editText.getText().toString())) {
                editText.setVisibility(8);
            }
        } else if (atomicBoolean.get()) {
            editText.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void mi(View view) {
        BaseModuleConfig.a().w("app_assets_hide_small_balances_tips_click", (HashMap) null);
        b.c(view, getResources().getString(R$string.n_asset_hide_small_amount_tips), PixelUtils.a(40.0f));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean ni(EditText editText, TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 3) {
            return false;
        }
        this.f42761r.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        return true;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void oi(View view) {
        EventBus.d().k(new gh.a(Boolean.FALSE));
        BaseModuleConfig.a().w("app_assets_search_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pi(Object obj) {
        JSONObject parseObject = JSON.parseObject(obj.toString());
        String string = parseObject.getString("code");
        Boolean bool = parseObject.getBoolean("succeed");
        this.f42573d.l(string, bool != null ? bool.booleanValue() : true);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void qi(View view) {
        BaseModuleConfig.a().w("app_assets_collateral_apply_click", (HashMap) null);
        this.f42574e.a().I("goToCollateral()");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String Ah() {
        return "collateralDataError";
    }

    public String Se() {
        return "14";
    }

    public String e9() {
        return "asset_tab_spot_pledge_item.xml";
    }

    public void initViews() {
        super.initViews();
        hk.a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
            return;
        }
        this.f42574e.a().v("collateralData", new k(this));
        this.f42574e.a().v("collateralDataError", new l(this));
        this.f42573d.m((String) null, getString(R$string.n_balance_apply_now), new e(this));
    }

    public void onResume() {
        super.onResume();
        BaseModuleConfig.a().w("app_assets_spot_collateral_exposure", (HashMap) null);
    }

    public View ve(Context context) {
        hk.a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(getContext());
        }
        if (this.f42761r == null) {
            this.f42761r = (InputMethodManager) getContext().getSystemService("input_method");
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.f42574e.a().E("asset_tab_spot_pledge_header_layout_new.xml", getContext(), false, (JSONObject) null));
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.item_balance_func_v2, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_hide_small_select_icon);
        View findViewById = inflate.findViewById(R$id.total_balance_hide_zero_balance);
        EditText editText = (EditText) inflate.findViewById(R$id.total_balance_search);
        View findViewById2 = inflate.findViewById(R$id.iv_search);
        inflate.findViewById(R$id.v_line).setVisibility(8);
        inflate.findViewById(R$id.tv_small_coin_to_htx).setVisibility(8);
        findViewById2.setOnClickListener(new d(editText));
        imageView.setOnClickListener(new g(this, imageView));
        editText.setOnFocusChangeListener(new i(new AtomicLong(), new AtomicBoolean(), editText));
        findViewById.setOnClickListener(new f(this));
        editText.addTextChangedListener(new a());
        editText.setOnEditorActionListener(new j(this, editText));
        editText.setOnClickListener(h.f54521b);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = 20;
        linearLayout.addView(inflate, marginLayoutParams);
        return linearLayout;
    }

    public String wa() {
        return null;
    }

    public q1 zh() {
        return new s(this.f42574e, this);
    }
}
