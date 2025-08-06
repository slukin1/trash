package wn;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.utils.ImageUtils;
import com.huobi.view.CommonCaptchaDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import java.util.Objects;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import tq.p;

public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    public final d f76794a;

    /* renamed from: b  reason: collision with root package name */
    public final VerifyHelper f76795b = new VerifyHelper();

    /* renamed from: c  reason: collision with root package name */
    public CommonCaptchaDialog f76796c;

    /* renamed from: d  reason: collision with root package name */
    public String f76797d;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.length() < 5) {
                u0.this.f76796c.getRightBtn().setEnabled(false);
            } else {
                u0.this.f76796c.getRightBtn().setEnabled(true);
            }
        }
    }

    public class b extends EasySubscriber<ImgCaptchaData> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(ImgCaptchaData imgCaptchaData) {
            super.onNext(imgCaptchaData);
            String unused = u0.this.f76797d = imgCaptchaData.getKey();
            u0.this.z(ImageUtils.i(imgCaptchaData.getImage()));
        }

        public void onAfter() {
            super.onAfter();
            u0.this.f76794a.getActivity().dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            u0.this.f76794a.getActivity().dismissProgressDialog();
        }
    }

    public class c implements VerifyHelper.d {

        /* renamed from: a  reason: collision with root package name */
        public String f76800a;

        /* renamed from: b  reason: collision with root package name */
        public String f76801b;

        /* renamed from: c  reason: collision with root package name */
        public int f76802c;

        public c() {
        }

        public void a(int i11, int i12, Intent intent) {
            u0.this.f76794a.b(i11, i12, intent);
        }

        public void b(int i11, HashMap<String, Object> hashMap) {
            if (i11 != 0) {
                u0.this.f76794a.a(this.f76800a, this.f76801b, this.f76802c, hashMap);
            } else {
                u0.this.f76794a.c();
            }
        }

        public void c(String str, String str2, int i11) {
            this.f76800a = str;
            this.f76801b = str2;
            this.f76802c = i11;
        }

        public /* synthetic */ c(u0 u0Var, a aVar) {
            this();
        }
    }

    public interface d {
        void a(String str, String str2, int i11, HashMap<String, Object> hashMap);

        void b(int i11, int i12, Intent intent);

        void c();

        BaseActivity getActivity();
    }

    public interface e {
        void a();

        void b(String str, String str2);

        void onCancel();
    }

    public u0(d dVar) {
        this.f76794a = dVar;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(String str, int i11, int i12, String str2, View view) {
        A(str, i11, i12, str2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(e eVar, Dialog dialog, int i11) {
        this.f76796c.dismiss();
        eVar.onCancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(e eVar, Dialog dialog, int i11) {
        eVar.b(this.f76796c.getCaptchaEdit().getText().toString(), this.f76797d);
    }

    public static /* synthetic */ void s() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(String str, int i11, int i12, String str2, e eVar, ImgCaptchaData imgCaptchaData) {
        this.f76797d = imgCaptchaData.getKey();
        y(str, i11, i12, str2, eVar, imgCaptchaData);
    }

    public final void A(String str, int i11, int i12, String str2) {
        UserCenterRemoteDataSource A = UserCenterRemoteDataSource.A();
        if (i12 != 1) {
            str2 = null;
        }
        A.t0(str, i11, str2).compose(p.c0()).flatMap(t0.f61481b).compose(RxJavaHelper.t(this.f76794a.getActivity())).subscribe(new b());
    }

    public void B(String str, String str2, int i11, String str3, RiskControl riskControl) {
        c cVar = new c(this, (a) null);
        cVar.c(str, str2, i11);
        this.f76795b.m(this.f76794a.getActivity(), str, str3, riskControl, cVar);
    }

    public void C(String str, String str2, String str3, RiskControl riskControl) {
        B(str, str2, -1, str3, riskControl);
    }

    public void D(String str, int i11, int i12, String str2, e eVar) {
        Observable<R> compose = UserCenterRemoteDataSource.A().z().compose(p.c0()).compose(RxJavaHelper.t(this.f76794a.getActivity()));
        p0 p0Var = p0.f61466b;
        s0 s0Var = new s0(this, str, i11, i12, str2, eVar);
        q0 q0Var = new q0(eVar);
        r0 r0Var = new r0(eVar);
        Objects.requireNonNull(eVar);
        compose.subscribe((Subscriber<? super R>) EasySubscriber.create(p0Var, s0Var, q0Var, r0Var, new o0(eVar)));
    }

    public void m() {
        CommonCaptchaDialog commonCaptchaDialog = this.f76796c;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.dismiss();
        }
    }

    public final String n(int i11) {
        return this.f76794a.getActivity().getString(i11);
    }

    public boolean w(int i11, int i12, Intent intent) {
        return this.f76795b.y(i11, i12, intent);
    }

    public void x() {
        VerifyActivity.finishVerifyUI();
    }

    public final void y(String str, int i11, int i12, String str2, e eVar, ImgCaptchaData imgCaptchaData) {
        CommonCaptchaDialog commonCaptchaDialog = new CommonCaptchaDialog(this.f76794a.getActivity());
        this.f76796c = commonCaptchaDialog;
        commonCaptchaDialog.setTitle(n(R.string.login_dialog_captcha_title));
        this.f76796c.setCancelText(n(R.string.login_dialog_cancel));
        this.f76796c.setConfirmText(n(R.string.login_dialog_confirm));
        this.f76796c.setCaptchaImage(imgCaptchaData.getImage());
        this.f76796c.show();
        this.f76796c.getImageView().setOnClickListener(new l0(this, str, i11, i12, str2));
        this.f76796c.setCancelListener(new n0(this, eVar));
        this.f76796c.setConfirmListner(new m0(this, eVar));
        this.f76796c.getCaptchaEdit().addTextChangedListener(new a());
    }

    public final void z(Bitmap bitmap) {
        CommonCaptchaDialog commonCaptchaDialog = this.f76796c;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.getImageView().setImageBitmap(bitmap);
            this.f76796c.getCaptchaEdit().setText("");
        }
    }
}
