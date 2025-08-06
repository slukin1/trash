package dp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.r;
import com.hbg.lib.widgets.LoadingRelativeLayout;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.hbg.module.otc.R$style;
import com.huobi.otc.utils.SimpleTextWatcher;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class t extends r implements View.OnFocusChangeListener {

    /* renamed from: d  reason: collision with root package name */
    public View f83949d;

    /* renamed from: e  reason: collision with root package name */
    public ClearEditText f83950e;

    /* renamed from: f  reason: collision with root package name */
    public b f83951f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f83952g;

    /* renamed from: h  reason: collision with root package name */
    public int f83953h;

    /* renamed from: i  reason: collision with root package name */
    public LoadingRelativeLayout f83954i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f83955j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f83956k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f83957l;

    /* renamed from: m  reason: collision with root package name */
    public View.OnClickListener f83958m;

    public class a extends SimpleTextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            t.this.findViewById(R$id.pwd_btn_ok).setEnabled(!TextUtils.isEmpty(editable.toString()));
        }
    }

    public interface b {
        void a(String str);
    }

    public t(Context context) {
        this(context, R$style.OrderDialog);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(View view) {
        if (TextUtils.isEmpty(this.f83950e.getText().toString())) {
            HuobiToastUtil.g(R$string.n_cloud_wallet_fund_pwd_not_empty);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        b bVar = this.f83951f;
        if (bVar != null) {
            bVar.a(this.f83950e.getText().toString());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        OtcModuleConfig.b().z(getContext(), new Intent());
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void dismiss() {
        ClearEditText clearEditText = this.f83950e;
        if (clearEditText != null) {
            clearEditText.setText("");
        }
        this.f83953h = -1;
        this.f83955j = false;
        this.f83957l = false;
        super.dismiss();
    }

    public final void m() {
        this.f83950e.addTextChangedListener(new a());
        this.f83950e.setOnFocusChangeListener(this);
        findViewById(R$id.pwd_btn_ok).setOnClickListener(new r(this));
        findViewById(R$id.pwd_btn_cancel).setOnClickListener(new s(this));
        View.OnClickListener onClickListener = this.f83958m;
        if (onClickListener != null) {
            this.f83956k.setOnClickListener(onClickListener);
        }
    }

    public final void n() {
        ClearEditText clearEditText = (ClearEditText) findViewById(R$id.pwd_edit_text);
        this.f83950e = clearEditText;
        ViewUtil.d(clearEditText);
        this.f83952g = (TextView) findViewById(R$id.otc_forgot_psw);
        this.f83949d = findViewById(R$id.loading_layout);
        this.f83954i = (LoadingRelativeLayout) findViewById(R$id.loading_root);
        TextView textView = (TextView) findViewById(R$id.otc_use_verification);
        this.f83956k = textView;
        ViewUtil.m(textView, this.f83957l);
        this.f83952g.setOnClickListener(new q(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        window.setBackgroundDrawableResource(R$color.transparent);
        window.setLayout(-1, -2);
        setContentView(R$layout.otc_dialog_fund_pwd);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = PixelUtils.g();
        window.setAttributes(attributes);
        n();
        m();
    }

    public void onFocusChange(View view, boolean z11) {
        if (view.getId() == R$id.pwd_edit_text) {
            this.f83950e.onFocusChange(view, z11);
        }
    }

    public void r(b bVar) {
        this.f83951f = bVar;
    }

    public void s(boolean z11) {
        this.f83957l = z11;
    }

    public void t(View.OnClickListener onClickListener) {
        this.f83958m = onClickListener;
    }

    public t(Context context, int i11) {
        super(context, i11);
        this.f83953h = -1;
    }
}
