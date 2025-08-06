package com.huobi.tradenew.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.SpotConfigInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.utils.a0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import qt.w;
import u6.g;

public class SpotMarginFuncDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public boolean f83075b;

    /* renamed from: c  reason: collision with root package name */
    public View f83076c;

    /* renamed from: d  reason: collision with root package name */
    public View f83077d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f83078e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f83079f = new ArrayList(8);

    /* renamed from: g  reason: collision with root package name */
    public List<TextView> f83080g = new ArrayList(7);

    /* renamed from: h  reason: collision with root package name */
    public TextView f83081h;

    /* renamed from: i  reason: collision with root package name */
    public b f83082i;

    public class a extends BaseSubscriber<Map<String, List<SpotConfigInfo>>> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Map<String, List<SpotConfigInfo>> map) {
            List<SpotConfigInfo> list;
            if (map != null && !map.isEmpty() && (list = map.get("1")) != null && !list.isEmpty()) {
                for (SpotConfigInfo spotConfigInfo : list) {
                    if (!TextUtils.isEmpty(spotConfigInfo.getName()) && !TextUtils.isEmpty(spotConfigInfo.getValue())) {
                        a0.a(spotConfigInfo.getName(), spotConfigInfo.getValue());
                    }
                }
            }
        }
    }

    public interface b {
        void a(int i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(Integer num, View view) {
        b bVar = this.f83082i;
        if (bVar != null) {
            bVar.a(num.intValue());
        }
        ConfigPreferences.k("_READEDNOTICE_", "SP_SPOT_MARGIN_PRE_CLICK_FUNC", num.intValue());
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(int i11, View view) {
        b bVar = this.f83082i;
        if (bVar != null) {
            bVar.a(i11);
        }
        ConfigPreferences.k("_READEDNOTICE_", "SP_SPOT_MARGIN_PRE_CLICK_FUNC", i11);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Ah(int i11, boolean z11, TextView textView) {
        switch (i11) {
            case 0:
                if (z11) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_transfer_small, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_transfer, 0, 0);
                }
                textView.setText(getString(R.string.currency_detail_transfer));
                return;
            case 1:
                if (z11) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_deposit_small, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_deposit, 0, 0);
                }
                textView.setText(getString(R.string.balance_detail_deposit));
                return;
            case 2:
                if (z11) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_spot_setting_small, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_spot_setting, 0, 0);
                }
                textView.setText(getString(R.string.n_setting_spot_set));
                return;
            case 3:
                if (this.f83075b) {
                    if (z11) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_optional_checked_small, 0, 0, 0);
                    } else {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_optional_checked, 0, 0);
                    }
                    textView.setText(getString(R.string.market_markets_removecollection));
                    return;
                }
                if (z11) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_optional_normal_small, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_optional_normal, 0, 0);
                }
                textView.setText(getString(R.string.market_markets_addcollection));
                return;
            case 4:
                if (z11) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_trade_rule_small, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_trade_rule, 0, 0);
                }
                textView.setText(getString(R.string.n_trade_rules_tips));
                return;
            case 5:
                if (z11) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_new_guide_small, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_new_guide, 0, 0);
                }
                textView.setText(getString(R.string.n_exchange_new_user_guide));
                return;
            case 6:
                if (z11) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_help_center_small, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_help_center, 0, 0);
                }
                textView.setText(getString(R.string.n_withdraw_help_center));
                return;
            case 7:
                if (z11) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_spot_margin_use_invest_small, 0, 0, 0);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_spot_margin_use_invest, 0, 0);
                }
                textView.setText(getString(R.string.n_spot_margin_setting_func_invest));
                return;
            default:
                return;
        }
    }

    public void Bh(FragmentManager fragmentManager, String str, boolean z11) {
        this.f83075b = z11;
        super.show(fragmentManager, str);
        w.b();
    }

    public void addEvent(r rVar) {
        this.f83076c.setOnClickListener(new d(this));
        this.f83077d.setOnClickListener(h.f83414b);
        this.f83078e.setOnClickListener(new e(this));
    }

    public void afterInit() {
        this.f83079f.clear();
        this.f83079f.add(0);
        this.f83079f.add(1);
        this.f83079f.add(2);
        Integer num = 3;
        this.f83079f.add(num);
        this.f83079f.add(4);
        this.f83079f.add(5);
        this.f83079f.add(6);
        this.f83079f.add(7);
        Integer valueOf = Integer.valueOf(ConfigPreferences.g("_READEDNOTICE_", "SP_SPOT_MARGIN_PRE_CLICK_FUNC", 3));
        this.f83079f.remove(valueOf);
        if (this.f83079f.size() != this.f83080g.size()) {
            this.f83079f.clear();
            this.f83079f.add(0);
            this.f83079f.add(1);
            this.f83079f.add(2);
            this.f83079f.add(4);
            this.f83079f.add(5);
            this.f83079f.add(6);
            this.f83079f.add(7);
        } else {
            num = valueOf;
        }
        int intValue = num.intValue();
        for (int i11 = 0; i11 < this.f83079f.size(); i11++) {
            TextView textView = this.f83080g.get(i11);
            Integer num2 = this.f83079f.get(i11);
            Ah(num2.intValue(), false, textView);
            textView.setOnClickListener(new g(this, num2));
        }
        Ah(num.intValue(), true, this.f83081h);
        this.f83081h.setOnClickListener(new f(this, intValue));
        v7.b.a().t0("1").b().retry(3).compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }

    public int getAnimationStyle() {
        return R.style.top_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_fragment_spot_margin_func;
    }

    public int getGravity() {
        return 48;
    }

    public void initView(r rVar) {
        this.f83076c = rVar.b(R.id.view_spot_margin_func_dialog_root);
        this.f83077d = rVar.b(R.id.clyt_spot_margin_func_dialog_panel);
        this.f83078e = (ImageView) rVar.b(R.id.iv_spot_margin_func_dialog_close);
        this.f83080g.clear();
        this.f83080g.add((TextView) rVar.b(R.id.tv_spot_margin_func_dialog_1));
        this.f83080g.add((TextView) rVar.b(R.id.tv_spot_margin_func_dialog_2));
        this.f83080g.add((TextView) rVar.b(R.id.tv_spot_margin_func_dialog_3));
        this.f83080g.add((TextView) rVar.b(R.id.tv_spot_margin_func_dialog_4));
        this.f83080g.add((TextView) rVar.b(R.id.tv_spot_margin_func_dialog_21));
        this.f83080g.add((TextView) rVar.b(R.id.tv_spot_margin_func_dialog_22));
        this.f83080g.add((TextView) rVar.b(R.id.tv_spot_margin_func_dialog_23));
        this.f83081h = (TextView) rVar.b(R.id.tv_spot_margin_func_dialog_common);
    }

    public boolean isTransparent() {
        return false;
    }

    public void zh(b bVar) {
        this.f83082i = bVar;
    }
}
