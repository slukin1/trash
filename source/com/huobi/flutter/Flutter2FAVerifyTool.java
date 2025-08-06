package com.huobi.flutter;

import androidx.fragment.app.FragmentActivity;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.finance.utils.Security2FADialogHelper;
import cp.c;
import dp.t;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import u6.g;

public class Flutter2FAVerifyTool {

    /* renamed from: a  reason: collision with root package name */
    public com.huobi.otc.helper.a f67673a;

    /* renamed from: b  reason: collision with root package name */
    public t f67674b;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f67675a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel f67676b;

        public a(MethodCall methodCall, MethodChannel methodChannel) {
            this.f67675a = methodCall;
            this.f67676b = methodChannel;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("securityToken", str);
            this.f67676b.invokeMethod((String) this.f67675a.argument("action"), hashMap);
        }

        public void d(BaseDialogFragment baseDialogFragment) {
        }

        public void e() {
        }

        public void f(t tVar) {
            t unused = Flutter2FAVerifyTool.this.f67674b = tVar;
        }

        public boolean g() {
            return false;
        }

        public void h(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, str);
            this.f67676b.invokeMethod((String) this.f67675a.argument("action"), hashMap);
            if (Flutter2FAVerifyTool.this.f67674b != null && Flutter2FAVerifyTool.this.f67674b.isShowing()) {
                Flutter2FAVerifyTool.this.f67674b.dismiss();
            }
        }
    }

    public class b implements jp.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f67678a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f67679b;

        public class a extends Security2FADialogHelper.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Security2FADialogHelper f67681a;

            public a(Security2FADialogHelper security2FADialogHelper) {
                this.f67681a = security2FADialogHelper;
            }

            public void onFailed(String str) {
            }

            public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                Flutter2FAVerifyTool.this.f67673a.s().c(authResult.getToken());
                this.f67681a.v();
            }
        }

        /* renamed from: com.huobi.flutter.Flutter2FAVerifyTool$b$b  reason: collision with other inner class name */
        public class C0736b implements jp.c {
            public C0736b() {
            }

            public void call() {
                Flutter2FAVerifyTool.this.f67673a.I();
            }
        }

        public b(FragmentActivity fragmentActivity, g gVar) {
            this.f67678a = fragmentActivity;
            this.f67679b = gVar;
        }

        public void call() {
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(this.f67678a, this.f67679b, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.S(new a(security2FADialogHelper), new C0736b());
        }
    }

    public void d(MethodCall methodCall, MethodChannel methodChannel, FragmentActivity fragmentActivity, g gVar) {
        if (this.f67673a == null) {
            this.f67673a = new com.huobi.otc.helper.a(fragmentActivity, gVar);
        }
        this.f67673a.J(new a(methodCall, methodChannel));
        this.f67673a.M(new b(fragmentActivity, gVar));
    }
}
