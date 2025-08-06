package com.huobi.finance.ui;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyController;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.presenter.AddVirtualAddressPresenter;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;
import tg.r;

public class AddVirtualAddressActivity extends BaseActivity<AddVirtualAddressPresenter, AddVirtualAddressPresenter.a> implements AddVirtualAddressPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public EditText f46256b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f46257c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46258d;

    /* renamed from: e  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f46259e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f46260f;

    /* renamed from: g  reason: collision with root package name */
    public Toolbar f46261g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f46262h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f46263i;

    /* renamed from: j  reason: collision with root package name */
    public CoordinatorLayout f46264j;

    /* renamed from: k  reason: collision with root package name */
    public CollapsingToolbarLayout f46265k;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                AddVirtualAddressActivity.this.f46256b.setTypeface(ResourcesCompat.h(AddVirtualAddressActivity.this.f46256b.getContext(), R.font.roboto_regular));
            } else {
                AddVirtualAddressActivity.this.f46256b.setTypeface(ResourcesCompat.h(AddVirtualAddressActivity.this.f46256b.getContext(), R.font.roboto_medium));
            }
            AddVirtualAddressActivity.this.wh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                AddVirtualAddressActivity.this.f46257c.setTypeface(ResourcesCompat.h(AddVirtualAddressActivity.this.f46257c.getContext(), R.font.roboto_regular));
            } else {
                AddVirtualAddressActivity.this.f46257c.setTypeface(ResourcesCompat.h(AddVirtualAddressActivity.this.f46257c.getContext(), R.font.roboto_medium));
            }
            AddVirtualAddressActivity.this.wh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                AddVirtualAddressActivity.this.f46262h.setTypeface(ResourcesCompat.h(AddVirtualAddressActivity.this.f46262h.getContext(), R.font.roboto_regular));
            } else {
                AddVirtualAddressActivity.this.f46262h.setTypeface(ResourcesCompat.h(AddVirtualAddressActivity.this.f46262h.getContext(), R.font.roboto_medium));
            }
            AddVirtualAddressActivity.this.wh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d extends SecurityStrategyController {
        public d() {
        }

        public boolean C() {
            return ((AddVirtualAddressPresenter) AddVirtualAddressActivity.this.getPresenter()).q0();
        }

        public final String Y() {
            return "VERIFY_SETTING_POLICY_WITHDRAW_ADD_ADDRESS";
        }

        public void i(String str, String str2, String str3, String str4) {
            VirtualAddressInfo k02 = ((AddVirtualAddressPresenter) AddVirtualAddressActivity.this.getPresenter()).k0();
            k02.setAddress(AddVirtualAddressActivity.this.f46256b.getText().toString());
            k02.setAlias(AddVirtualAddressActivity.this.f46257c.getText().toString());
            if (((AddVirtualAddressPresenter) AddVirtualAddressActivity.this.getPresenter()).l0()) {
                k02.setTag(AddVirtualAddressActivity.this.f46262h.getText().toString());
            }
            ((AddVirtualAddressPresenter) AddVirtualAddressActivity.this.getPresenter()).I0(str, str2, str3, str4, Y(), k02);
            AddVirtualAddressActivity.this.f46259e.dismiss();
        }

        public String n() {
            return r.x().M().e();
        }

        public String o() {
            return r.x().M().h();
        }

        public Map<String, Object> p() {
            return MapParamsBuilder.c().a("use_type", Y()).b();
        }

        public Map<String, Object> s() {
            return MapParamsBuilder.c().a("use_type", Y()).a("voice", Boolean.FALSE).b();
        }

        public boolean x() {
            return ((AddVirtualAddressPresenter) AddVirtualAddressActivity.this.getPresenter()).m0();
        }

        public boolean y() {
            return ((AddVirtualAddressPresenter) AddVirtualAddressActivity.this.getPresenter()).n0();
        }

        public boolean z() {
            return ((AddVirtualAddressPresenter) AddVirtualAddressActivity.this.getPresenter()).p0();
        }
    }

    public static /* synthetic */ void Ah(View view, boolean z11) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ch(HBDialogFragment hBDialogFragment) {
        xh(true);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        xh(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        ((AddVirtualAddressPresenter) getPresenter()).J0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Dh() {
        DialogUtils.c0(this, String.format(getString(R.string.withdraw_empty_tag_confirm), new Object[]{((AddVirtualAddressPresenter) getPresenter()).h0().toUpperCase(Locale.US)}), "", getString(R.string.security_google_cancel), getString(R.string.setting_sign_out_confirm), r0.f47301a, new q0(this));
    }

    public void P0() {
        this.f46259e.Ci(new d());
        this.f46259e.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    public void addEvent() {
        this.f46258d.setOnClickListener(new n0(this));
        this.f46256b.setOnFocusChangeListener(p0.f47272b);
        this.f46256b.addTextChangedListener(new a());
        this.f46257c.addTextChangedListener(new b());
        this.f46262h.addTextChangedListener(new c());
        this.f46260f.setOnClickListener(new o0(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R.layout.activity_add_virtual_address;
    }

    public void initView() {
        this.f46256b = (EditText) this.viewFinder.b(R.id.eth_address_et);
        this.f46258d = (TextView) this.viewFinder.b(R.id.add_confirm_tv);
        this.f46257c = (EditText) this.viewFinder.b(R.id.remarks_content_et);
        this.f46264j = (CoordinatorLayout) this.viewFinder.b(R.id.cl_root);
        this.f46259e = new SecurityStrategyBottomMenuFragment();
        this.f46260f = (ImageView) this.viewFinder.b(R.id.add_address_scan_iv);
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.add_address_toolbar);
        this.f46261g = toolbar;
        setToolBar(toolbar, "", true);
        this.f46263i = (LinearLayout) this.viewFinder.b(R.id.tag_ll);
        this.f46262h = (EditText) this.viewFinder.b(R.id.tag_et);
        this.f46265k = (CollapsingToolbarLayout) this.viewFinder.b(R.id.address_manager_collapsing_toolbar);
    }

    public void l3() {
        this.f46256b.setHint(((AddVirtualAddressPresenter) getPresenter()).d0());
        this.f46257c.setText(((AddVirtualAddressPresenter) getPresenter()).i0());
        this.f46265k.setTitle(((AddVirtualAddressPresenter) getPresenter()).j0());
        this.f46263i.setVisibility(((AddVirtualAddressPresenter) getPresenter()).l0() ? 0 : 8);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 200 && intent != null) {
            this.f46256b.setText(intent.getStringExtra("result_string"));
        }
    }

    public void wh() {
        boolean z11 = !TextUtils.isEmpty(this.f46256b.getText());
        if (TextUtils.isEmpty(this.f46257c.getText())) {
            z11 = false;
        }
        this.f46258d.setEnabled(z11);
    }

    public final void xh(boolean z11) {
        if (!TextUtils.isEmpty(this.f46262h.getText()) || !((AddVirtualAddressPresenter) getPresenter()).l0()) {
            ((AddVirtualAddressPresenter) getPresenter()).c0();
        } else if (z11) {
            ((AddVirtualAddressPresenter) getPresenter()).c0();
        } else {
            Dh();
        }
    }

    public void y(boolean z11) {
        SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f46259e;
        if (securityStrategyBottomMenuFragment != null) {
            securityStrategyBottomMenuFragment.Bi(z11);
        }
    }

    /* renamed from: yh */
    public AddVirtualAddressPresenter createPresenter() {
        return new AddVirtualAddressPresenter();
    }

    /* renamed from: zh */
    public AddVirtualAddressPresenter.a getUI() {
        return this;
    }
}
