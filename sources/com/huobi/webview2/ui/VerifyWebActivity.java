package com.huobi.webview2.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.huobi.domain.DomainSwitcher;
import com.huobi.login.bean.H5VerifyCodeData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.webview2.action.JsCommonActionHelper;
import i6.d;
import java.util.Locale;
import v6.u;
import wi.b;
import x6.c;

public class VerifyWebActivity extends HBBaseWebActivity {

    /* renamed from: e  reason: collision with root package name */
    public static final String f20906e = (b.f48047k + "/%1$s/user/captcha/");

    /* renamed from: b  reason: collision with root package name */
    public String f20907b;

    /* renamed from: c  reason: collision with root package name */
    public String f20908c;

    /* renamed from: d  reason: collision with root package name */
    public RiskControl f20909d;

    public class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f20910b;

        /* renamed from: c  reason: collision with root package name */
        public String f20911c;

        public a(u uVar, String str, String str2) {
            super(uVar);
            this.f20910b = str;
            this.f20911c = str2;
        }

        public boolean b(JsMessage jsMessage, u uVar) {
            d.b("VerifyWebViewPresenter-->dispatchAction-->onAliVerifySuccess-->result:" + jsMessage.getAction());
            if (JsCommonActionHelper.ACTION_VERIFY_CODE.equals(jsMessage.getAction())) {
                JsMessage jsMessage2 = new JsMessage();
                jsMessage2.setCode(200);
                jsMessage2.setData(new H5VerifyCodeData(this.f20910b, this.f20911c, 3, VerifyWebActivity.this.f20909d.getWebItems()));
                jsMessage2.setAction(jsMessage.getCallback());
                x6.b.d(jsMessage2, uVar);
                return true;
            } else if (!JsCommonActionHelper.ACTION_VERIFY_SUCCESS.equals(jsMessage.getAction())) {
                return false;
            } else {
                VerifyWebActivity.this.yh(jsMessage.getData().toString());
                return true;
            }
        }
    }

    public static void zh(Activity activity, String str, String str2, RiskControl riskControl) {
        Intent intent = new Intent(activity, VerifyWebActivity.class);
        intent.addFlags(67108864);
        String curLanguageUrlLowerCase = AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase();
        Locale locale = Locale.US;
        String format = String.format(locale, DomainSwitcher.K() + "/%1$s/user/captcha/", new Object[]{curLanguageUrlLowerCase});
        d.b("VerifyWebViewActivity-->startForResult-->url:" + format);
        intent.putExtra("url", format);
        intent.putExtra("extra_login_name", str);
        intent.putExtra("extra_scene", str2);
        intent.putExtra("extra_risk_control", riskControl);
        activity.startActivityForResult(intent, 100);
    }

    public c getJavascriptInterface() {
        return new a(this, this.f20907b, this.f20908c);
    }

    public void onCreate(Bundle bundle) {
        this.f20907b = getIntent().getStringExtra("extra_login_name");
        this.f20908c = getIntent().getStringExtra("extra_scene");
        this.f20909d = (RiskControl) getIntent().getSerializableExtra("extra_risk_control");
        super.onCreate(bundle);
    }

    public void yh(String str) {
        Intent intent = new Intent();
        intent.putExtra("extra_result", str);
        setResult(200, intent);
        finish();
    }
}
