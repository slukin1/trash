package vp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.network.otc.core.bean.DialPhoneResponseBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.dialog.VoiceCallUseOtherDialogFragment;
import com.huobi.otc.persenter.OtcLiteChatPresenter;
import com.huobi.otc.persenter.a;
import com.huobi.otc.ui.OtcLiteChatActivity;
import com.huobi.otc.ui.fragments.CallPhoneBottomMenuFragment;
import com.huobi.view.CommonCaptchaDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;
import u6.g;

public class c1 implements a.k, VoiceCallUseOtherDialogFragment.b, CallPhoneBottomMenuFragment.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Context f85001a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public g f85002b;

    /* renamed from: c  reason: collision with root package name */
    public com.huobi.otc.persenter.a f85003c;

    /* renamed from: d  reason: collision with root package name */
    public VoiceCallUseOtherDialogFragment f85004d;

    /* renamed from: e  reason: collision with root package name */
    public CallPhoneBottomMenuFragment f85005e;

    /* renamed from: f  reason: collision with root package name */
    public CommonCaptchaDialog f85006f;

    /* renamed from: g  reason: collision with root package name */
    public String f85007g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentManager f85008h;

    /* renamed from: i  reason: collision with root package name */
    public b f85009i;

    /* renamed from: j  reason: collision with root package name */
    public String f85010j;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.length() < 5) {
                c1.this.f85006f.getRightBtn().setEnabled(false);
            } else {
                c1.this.f85006f.getRightBtn().setEnabled(true);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c1> f85012a;

        public b(c1 c1Var) {
            this.f85012a = new WeakReference<>(c1Var);
        }

        public void a() {
            c1 c1Var = (c1) this.f85012a.get();
            if (c1Var != null) {
                c1Var.D();
            }
        }

        public void b(boolean z11, Map<String, String> map) {
            c1 c1Var = (c1) this.f85012a.get();
            if (c1Var != null) {
                c1Var.E(z11, map);
            }
        }
    }

    public c1(Context context, g gVar, FragmentManager fragmentManager) {
        this.f85001a = context;
        this.f85002b = gVar;
        this.f85008h = fragmentManager;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(Dialog dialog, int i11) {
        this.f85006f.dismiss();
        String obj = this.f85006f.getCaptchaEdit().getText().toString();
        if (!TextUtils.isEmpty(obj) && obj.length() >= 5) {
            v().q(this.f85010j, v().l(v().k(), obj));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (this.f85005e == null) {
            CallPhoneBottomMenuFragment callPhoneBottomMenuFragment = new CallPhoneBottomMenuFragment();
            this.f85005e = callPhoneBottomMenuFragment;
            callPhoneBottomMenuFragment.Ah(this);
        }
        this.f85005e.show(this.f85008h, "callPhoneBottomMenuFragment");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        h(str);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void x(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        v().p(this.f85010j);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(Dialog dialog, int i11) {
        this.f85006f.dismiss();
    }

    public final void D() {
    }

    public final void E(boolean z11, Map<String, String> map) {
        if (z11 && this.f85004d != null) {
            HashMap hashMap = new HashMap();
            OtcModuleConfig.a().P(hashMap, map);
            v().q(this.f85004d.Ch(), hashMap);
        }
    }

    public void F(String str) {
        this.f85007g = str;
    }

    public void G(UserSecurityInfoData userSecurityInfoData) {
        if (userSecurityInfoData != null && this.f85001a != null) {
            Intent g11 = OtcModuleConfig.b().g(this.f85001a, userSecurityInfoData.getEmail());
            g11.putExtra("otc_bind_phone_action", "lite_order_otc_bind_phone");
            this.f85001a.startActivity(g11);
        }
    }

    public void N(String str) {
        g gVar;
        if (this.f85001a != null && (gVar = this.f85002b) != null && gVar.isAlive()) {
            CommonCaptchaDialog commonCaptchaDialog = new CommonCaptchaDialog(this.f85001a);
            this.f85006f = commonCaptchaDialog;
            commonCaptchaDialog.setTitle(this.f85001a.getString(R$string.login_dialog_captcha_title));
            this.f85006f.setCancelText(this.f85001a.getString(R$string.login_dialog_cancel));
            this.f85006f.setConfirmText(this.f85001a.getString(R$string.login_dialog_confirm));
            this.f85006f.setCaptchaImage(str);
            this.f85006f.show();
            this.f85006f.getImageView().setOnClickListener(new x0(this));
            this.f85006f.setCancelListener(new a1(this));
            this.f85006f.setConfirmListner(new b1(this));
            this.f85006f.getCaptchaEdit().addTextChangedListener(new a());
        }
    }

    public void Q0(Bitmap bitmap) {
        CommonCaptchaDialog commonCaptchaDialog = this.f85006f;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.getImageView().setImageBitmap(bitmap);
            this.f85006f.getCaptchaEdit().setText("");
        }
    }

    public String R0() {
        String str = this.f85007g;
        return str == null ? "" : str;
    }

    public void a(DialPhoneResponseBean dialPhoneResponseBean, String str) {
        VoiceCallUseOtherDialogFragment voiceCallUseOtherDialogFragment;
        if (this.f85002b.isAlive() && (voiceCallUseOtherDialogFragment = this.f85004d) != null) {
            voiceCallUseOtherDialogFragment.dismiss();
        }
        if (u() != null) {
            t(u(), dialPhoneResponseBean.getSecretNo(), str).show();
        }
    }

    public void b() {
        HuobiToastUtil.i(this.f85001a.getString(R$string.voice_call_sms_code_error));
    }

    public void c() {
        VoiceCallUseOtherDialogFragment voiceCallUseOtherDialogFragment = this.f85004d;
        if (voiceCallUseOtherDialogFragment != null) {
            voiceCallUseOtherDialogFragment.Jh(this.f85002b);
        }
    }

    public void d(String str, String str2) {
        v().h(str, str2);
    }

    public void e(String str) {
        v().o(2, this.f85007g, str, "");
    }

    public void f(String str) {
        this.f85010j = str;
        v().r(str);
    }

    public void g(String str) {
        g gVar;
        if (u() != null && (gVar = this.f85002b) != null && gVar.isAlive()) {
            if (this.f85009i == null) {
                this.f85009i = new b(this);
            }
            OtcModuleConfig.b().Q(this.f85001a, this.f85009i);
        }
    }

    public void h(String str) {
        try {
            if (u() != null) {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
                intent.setFlags(268435456);
                this.f85001a.startActivity(intent);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void i(String str) {
        g gVar;
        if (u() != null && (gVar = this.f85002b) != null && gVar.isAlive()) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            DialogUtils.b.d M0 = new DialogUtils.b.d(fragmentActivity).c1(str).d1(true).i1(1).M0(Integer.valueOf(R$drawable.otc_order_telephone_window_image));
            M0.C0(u().getString(R$string.otc_order_dialog_please_call_telephone, new Object[]{v().i()}) + "\n").E0(true).H0(Float.valueOf(fragmentActivity.getResources().getDimension(R$dimen.global_text_size_14))).T0(true).R0(fragmentActivity.getString(R$string.otc_order_dialog_user_other_telephone)).S0(Integer.valueOf(ContextCompat.getColor(u(), R$color.baseColorMajorTheme100))).U0(new y0(this)).N0(ad.b.f3517a).Q0(new z0(this, str)).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }

    public void s(OtcLiteChatActivity otcLiteChatActivity) {
        v().g(otcLiteChatActivity);
    }

    public final Dialog t(Context context, String str, String str2) {
        AlertDialog.a aVar = new AlertDialog.a(context);
        View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_layout_otc_voice_call_success, (ViewGroup) null);
        aVar.setView(inflate);
        TextView textView = (TextView) inflate.findViewById(R$id.dialog_call_phone_number_tv);
        TextView textView2 = (TextView) inflate.findViewById(R$id.dialog_answer_phone_number_tv);
        Button button = (Button) inflate.findViewById(R$id.dialog_i_know_btn);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            textView2.setText(str2);
        }
        AlertDialog create = aVar.create();
        button.setOnClickListener(new w0(create));
        create.setCancelable(false);
        return create;
    }

    public Context u() {
        return this.f85001a;
    }

    public com.huobi.otc.persenter.a v() {
        if (this.f85003c == null) {
            this.f85003c = new com.huobi.otc.persenter.a(this.f85002b, this);
        }
        return this.f85003c;
    }

    public void w(OtcLiteChatPresenter.s sVar) {
        v().m(sVar);
    }
}
