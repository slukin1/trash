package com.huobi.otc.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.ProgressButton;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.persenter.OtcTradeSettingPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import sp.r2;
import sp.s2;

public class OtcTradeSettingActivity extends BaseDragActivity<OtcTradeSettingPresenter, OtcTradeSettingPresenter.b> implements OtcTradeSettingPresenter.b {

    /* renamed from: d  reason: collision with root package name */
    public EditText f79570d;

    /* renamed from: e  reason: collision with root package name */
    public ClearEditText f79571e;

    /* renamed from: f  reason: collision with root package name */
    public ClearEditText f79572f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f79573g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f79574h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f79575i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f79576j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f79577k;

    /* renamed from: l  reason: collision with root package name */
    public ProgressButton f79578l;

    /* renamed from: m  reason: collision with root package name */
    public View f79579m;

    /* renamed from: n  reason: collision with root package name */
    public View f79580n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f79581o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f79582p;

    /* renamed from: q  reason: collision with root package name */
    public Toolbar f79583q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f79584r = false;

    /* renamed from: s  reason: collision with root package name */
    public boolean f79585s = false;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            OtcTradeSettingActivity.this.zh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (!z11) {
                boolean unused = OtcTradeSettingActivity.this.Bh();
            }
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            OtcTradeSettingActivity.this.zh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z11) {
            OtcTradeSettingActivity.this.f79571e.onFocusChange(view, z11);
            if (z11) {
                OtcTradeSettingActivity.this.f79579m.setBackgroundColor(OtcTradeSettingActivity.this.getResources().getColor(R$color.global_jump_btn_color));
                return;
            }
            OtcTradeSettingActivity.this.f79579m.setBackgroundColor(OtcTradeSettingActivity.this.getResources().getColor(R$color.global_divider_color));
            boolean unused = OtcTradeSettingActivity.this.Ch();
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public void afterTextChanged(Editable editable) {
            OtcTradeSettingActivity.this.zh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class f implements View.OnFocusChangeListener {
        public f() {
        }

        public void onFocusChange(View view, boolean z11) {
            OtcTradeSettingActivity.this.f79572f.onFocusChange(view, z11);
            if (z11) {
                OtcTradeSettingActivity.this.f79580n.setBackgroundColor(OtcTradeSettingActivity.this.getResources().getColor(R$color.global_jump_btn_color));
                return;
            }
            OtcTradeSettingActivity.this.f79580n.setBackgroundColor(OtcTradeSettingActivity.this.getResources().getColor(R$color.global_divider_color));
            boolean unused = OtcTradeSettingActivity.this.Ah();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (OtcTradeSettingActivity.this.f79582p) {
                OtcTradeSettingActivity.this.f79577k.setImageResource(R$drawable.icon_eye_close);
                boolean unused = OtcTradeSettingActivity.this.f79582p = false;
                OtcTradeSettingActivity.this.f79572f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                OtcTradeSettingActivity.this.f79572f.setSelection(OtcTradeSettingActivity.this.f79572f.getText().toString().length());
            } else {
                OtcTradeSettingActivity.this.f79577k.setImageResource(R$drawable.icon_eye_open);
                boolean unused2 = OtcTradeSettingActivity.this.f79582p = true;
                OtcTradeSettingActivity.this.f79572f.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                OtcTradeSettingActivity.this.f79572f.setSelection(OtcTradeSettingActivity.this.f79572f.getText().toString().length());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(View view) {
        if (((Bh() & Ch()) && Ah()) && this.f79585s) {
            ((OtcTradeSettingPresenter) getPresenter()).b0(MapParamsBuilder.c().a("nickName", this.f79570d.getText().toString()).a("tradePass", MD5Utils.d(this.f79571e.getText().toString())).b(), MD5Utils.c(this.f79571e.getText().toString()));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f79581o) {
            this.f79576j.setImageResource(R$drawable.icon_eye_close);
            this.f79581o = false;
            this.f79571e.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ClearEditText clearEditText = this.f79571e;
            clearEditText.setSelection(clearEditText.getText().toString().length());
        } else {
            this.f79576j.setImageResource(R$drawable.icon_eye_open);
            this.f79581o = true;
            this.f79571e.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ClearEditText clearEditText2 = this.f79571e;
            clearEditText2.setSelection(clearEditText2.getText().toString().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final boolean Ah() {
        String obj = this.f79572f.getText().toString();
        if (TextUtils.isEmpty(this.f79571e.getText().toString())) {
            return false;
        }
        if (this.f79571e.getText().toString().equals(obj)) {
            this.f79575i.setVisibility(8);
            return true;
        }
        this.f79575i.setVisibility(0);
        return false;
    }

    public final boolean Bh() {
        String obj = this.f79570d.getText().toString();
        if (obj.length() < 4 || obj.length() > 16 || obj.contains(" ")) {
            this.f79573g.setVisibility(0);
            return false;
        }
        this.f79573g.setVisibility(8);
        return true;
    }

    public final boolean Ch() {
        String obj = this.f79571e.getText().toString();
        if (obj.length() < 8 || obj.length() > 32 || !StringUtils.s(obj)) {
            this.f79574h.setVisibility(0);
            return false;
        }
        this.f79574h.setVisibility(8);
        return true;
    }

    /* renamed from: Dh */
    public OtcTradeSettingPresenter createPresenter() {
        return new OtcTradeSettingPresenter();
    }

    /* renamed from: Eh */
    public OtcTradeSettingPresenter.b getUI() {
        return this;
    }

    public String R0() {
        return null;
    }

    public String Xf() {
        return "passHome";
    }

    public void addEvent() {
        this.f79570d.addTextChangedListener(new a());
        this.f79570d.setOnFocusChangeListener(new b());
        this.f79571e.addTextChangedListener(new c());
        this.f79571e.setOnFocusChangeListener(new d());
        this.f79572f.addTextChangedListener(new e());
        this.f79572f.setOnFocusChangeListener(new f());
        this.f79576j.setOnClickListener(new r2(this));
        this.f79577k.setOnClickListener(new g());
        this.f79578l.setOnClickListener(new s2(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    public int getContentView() {
        return R$layout.activity_otc_trade_setting;
    }

    public boolean hasNext() {
        return this.f79584r;
    }

    public void initView() {
        super.initView();
        this.f79583q = (Toolbar) this.viewFinder.b(R$id.toolbar);
        this.f79570d = (EditText) this.viewFinder.b(R$id.otc_nick_name_et);
        this.f79571e = (ClearEditText) this.viewFinder.b(R$id.otc_trade_password_et);
        this.f79572f = (ClearEditText) this.viewFinder.b(R$id.otc_trade_password_confirm_et);
        this.f79573g = (TextView) this.viewFinder.b(R$id.nick_name_error_tv);
        this.f79574h = (TextView) this.viewFinder.b(R$id.password_error_tv);
        this.f79575i = (TextView) this.viewFinder.b(R$id.confirm_password_error_tv);
        this.f79576j = (ImageView) this.viewFinder.b(R$id.otc_trade_password_show_iv);
        this.f79577k = (ImageView) this.viewFinder.b(R$id.otc_trade_password_confirm_show_iv);
        this.f79578l = (ProgressButton) this.viewFinder.b(R$id.otc_trade_setting_btn);
        this.f79579m = this.viewFinder.b(R$id.otc_password_divider_line);
        this.f79580n = this.viewFinder.b(R$id.otc_password_confirm_divider_line);
        setToolBar(this.f79583q, getString(R$string.otc_trade_setting_title), true);
        this.f79578l.setText("");
        this.f79578l.c();
        ViewUtil.d(this.f79572f);
    }

    public void ta(boolean z11, boolean z12) {
        int i11;
        if (!z11 || !OtcModuleConfig.a().D()) {
            this.f79578l.setText(R$string.otc_trade_setting_btn_text);
            this.f79578l.a();
        } else {
            boolean z13 = 2 != OtcModuleConfig.a().j();
            this.f79584r = z13;
            ProgressButton progressButton = this.f79578l;
            if (!z13 || !z12) {
                i11 = R$string.otc_trade_setting_btn_text;
            } else {
                i11 = R$string.showcase_next;
            }
            progressButton.setRealText(i11);
            this.f79578l.a();
        }
        this.f79585s = true;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public final void zh() {
        if (TextUtils.isEmpty(this.f79570d.getText().toString()) || TextUtils.isEmpty(this.f79571e.getText().toString()) || TextUtils.isEmpty(this.f79572f.getText().toString()) || !StringUtils.s(this.f79571e.getText().toString()) || this.f79570d.getText().toString().contains(" ")) {
            this.f79578l.setEnabled(false);
        } else {
            this.f79578l.setEnabled(true);
        }
    }
}
