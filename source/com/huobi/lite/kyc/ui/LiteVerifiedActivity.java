package com.huobi.lite.kyc.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$font;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.lite.kyc.presenter.LiteVerifiedPresenter;
import com.huobi.otc.ui.OtcCertificationResultActivity;
import in.c;
import in.d;
import java.util.concurrent.TimeUnit;
import jp.l;

public class LiteVerifiedActivity extends BaseActivity<LiteVerifiedPresenter, LiteVerifiedPresenter.c> implements LiteVerifiedPresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public ClearEditText f75398b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f75399c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f75400d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f75401e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f75402f;

    /* renamed from: g  reason: collision with root package name */
    public View f75403g;

    /* renamed from: h  reason: collision with root package name */
    public View f75404h;

    /* renamed from: i  reason: collision with root package name */
    public String f75405i = "";

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.toString().isEmpty()) {
                LiteVerifiedActivity.this.f75398b.setTypeface(ResourcesCompat.h(LiteVerifiedActivity.this.f75398b.getContext(), R$font.roboto_regular));
            } else {
                LiteVerifiedActivity.this.f75398b.setTypeface(ResourcesCompat.h(LiteVerifiedActivity.this.f75398b.getContext(), R$font.roboto_medium));
            }
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
            if (editable == null || editable.toString().isEmpty()) {
                LiteVerifiedActivity.this.f75399c.setTypeface(ResourcesCompat.h(LiteVerifiedActivity.this.f75399c.getContext(), R$font.roboto_medium));
            } else {
                LiteVerifiedActivity.this.f75399c.setTypeface(ResourcesCompat.h(LiteVerifiedActivity.this.f75399c.getContext(), R$font.roboto_medium));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qg(Void voidR) {
        String str = "";
        String trim = this.f75398b.getText() != null ? this.f75398b.getText().toString().trim() : str;
        if (this.f75399c.getText() != null) {
            str = this.f75399c.getText().toString().trim();
        }
        if (TextUtils.isEmpty(trim)) {
            HuobiToastUtil.m(getString(R$string.verification_first_name_hint));
        } else if (TextUtils.isEmpty(str)) {
            HuobiToastUtil.m(getString(R$string.verification_cn_card_hint));
        } else if (trim.length() > 50) {
            HuobiToastUtil.m(getString(R$string.verification_fist_name_long));
        } else {
            ((LiteVerifiedPresenter) getPresenter()).U(trim, str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh(View view, boolean z11) {
        this.f75398b.onFocusChange(view, z11);
        if (z11) {
            this.f75398b.setHint("");
            this.f75403g.setBackgroundColor(getResources().getColor(R$color.global_button_end_color));
            return;
        }
        this.f75398b.setHint(R$string.verification_cn_name);
        this.f75403g.setBackgroundColor(getResources().getColor(R$color.global_divider_color));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ph(View view, boolean z11) {
        this.f75399c.onFocusChange(view, z11);
        if (z11) {
            this.f75399c.setHint("");
            this.f75404h.setBackgroundColor(getResources().getColor(R$color.global_button_end_color));
            return;
        }
        this.f75399c.setHint(R$string.lite_register_need_id);
        this.f75404h.setBackgroundColor(getResources().getColor(R$color.global_divider_color));
    }

    public static void qh(Activity activity, boolean z11, boolean z12) {
        Intent intent = new Intent(activity, LiteVerifiedActivity.class);
        intent.putExtra("LiteVerifiedActivity.isTrading", z11);
        intent.putExtra("LiteVerifiedActivity.isBackToHomePage", z12);
        activity.startActivity(intent);
    }

    public boolean Ha() {
        return false;
    }

    public void Kf(String str) {
        this.f75405i = str;
    }

    /* renamed from: Og */
    public LiteVerifiedPresenter createPresenter() {
        return new LiteVerifiedPresenter();
    }

    /* renamed from: Pg */
    public LiteVerifiedPresenter.c getUI() {
        return this;
    }

    public void Xc(String str) {
        BaseLiteFaceLiveDetectionActivity.gg(this, this.f75398b.getText().toString(), this.f75399c.getText().toString(), str, this.f75405i, this.f75400d);
    }

    public void addEvent() {
        dw.a.a(this.viewFinder.b(R$id.verified_next_tv)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new d(this));
        this.f75398b.setOnFocusChangeListener(new c(this));
        this.f75398b.addTextChangedListener(new a());
        this.f75399c.setOnFocusChangeListener(new in.b(this));
        this.f75399c.addTextChangedListener(new b());
    }

    public void finish() {
        super.finish();
    }

    public int getContentView() {
        return R$layout.activity_lite_verified_layout;
    }

    public void initView() {
        this.f75400d = getIntent().getBooleanExtra("LiteVerifiedActivity.isTrading", false);
        this.f75401e = getIntent().getBooleanExtra("LiteVerifiedActivity.isBackToHomePage", false);
        setToolBar((Toolbar) this.viewFinder.b(R$id.toolbar), "", true);
        this.f75398b = (ClearEditText) this.viewFinder.b(R$id.lite_verified_enter_name_et);
        this.f75399c = (ClearEditText) this.viewFinder.b(R$id.lite_verified_enter_card_et);
        this.f75402f = (TextView) this.viewFinder.b(R$id.verified_next_tv);
        this.f75403g = this.viewFinder.b(R$id.name_line_view);
        this.f75404h = this.viewFinder.b(R$id.card_line_view);
        l.i(this.f75402f, this.f75398b, this.f75399c);
    }

    public void ma(int i11, String str) {
        OtcCertificationResultActivity.Og(this, false, 1048578, str, this.f75400d);
    }
}
