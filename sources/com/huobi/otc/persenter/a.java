package com.huobi.otc.persenter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.network.otc.core.bean.DialPhoneResponseBean;
import com.hbg.lib.network.otc.core.bean.OtcContactsResponseBean;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.network.uc.retrofit.UcRetrofit;
import com.hbg.lib.network.uc.retrofit.service.UserCenterService;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.R$string;
import com.hbg.module.otc.OtcModuleConfig;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.otc.persenter.OtcLiteChatPresenter;
import com.huobi.otc.ui.OtcLiteChatActivity;
import com.huobi.utils.ImageUtils;
import java.util.HashMap;
import java.util.Map;
import qp.a0;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public u6.g f79188a;

    /* renamed from: b  reason: collision with root package name */
    public k f79189b;

    /* renamed from: c  reason: collision with root package name */
    public String f79190c;

    /* renamed from: d  reason: collision with root package name */
    public String f79191d;

    /* renamed from: e  reason: collision with root package name */
    public OtcContactsResponseBean f79192e;

    /* renamed from: com.huobi.otc.persenter.a$a  reason: collision with other inner class name */
    public class C0845a extends q6.b<ImgCaptchaData> {
        public C0845a(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: a */
        public void onRequestSuccess(ImgCaptchaData imgCaptchaData) {
            super.onRequestSuccess(imgCaptchaData);
            String unused = a.this.f79191d = imgCaptchaData.getKey();
            a.this.f79189b.Q0(ImageUtils.i(imgCaptchaData.getImage()));
        }
    }

    public class b implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f79194a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcLiteChatActivity f79195b;

        public b(String str, OtcLiteChatActivity otcLiteChatActivity) {
            this.f79194a = str;
            this.f79195b = otcLiteChatActivity;
        }

        public void a() {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.f79194a));
            intent.setFlags(268435456);
            this.f79195b.startActivity(intent);
        }
    }

    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f79197a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcLiteChatActivity f79198b;

        public c(String str, OtcLiteChatActivity otcLiteChatActivity) {
            this.f79197a = str;
            this.f79198b = otcLiteChatActivity;
        }

        public void a() {
            if (this.f79197a.startsWith("http")) {
                this.f79198b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f79197a)));
                return;
            }
            String str = this.f79197a;
            ((ClipboardManager) this.f79198b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
            HuobiToastUtil.t(this.f79198b, R$string.n_otc_copy_success);
        }
    }

    public class d extends q6.a<OtcContactsResponseBean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtcLiteChatPresenter.s f79200a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(u6.g gVar, OtcLiteChatPresenter.s sVar) {
            super(gVar);
            this.f79200a = sVar;
        }

        /* renamed from: a */
        public void onRequestSuccess(OtcContactsResponseBean otcContactsResponseBean) {
            OtcContactsResponseBean unused = a.this.f79192e = otcContactsResponseBean;
            if (otcContactsResponseBean.isShow()) {
                this.f79200a.f8(true);
                a.this.f(this.f79200a);
                return;
            }
            this.f79200a.f8(false);
        }

        public void onRequestFailure(Throwable th2) {
            th2.printStackTrace();
            u6.g gVar = this.f69029ui;
            if (gVar != null) {
                gVar.dismissProgressDialog();
            }
        }
    }

    public class e extends q6.b<DialPhoneResponseBean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f79202b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f79203c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(u6.g gVar, int i11, String str) {
            super(gVar);
            this.f79202b = i11;
            this.f79203c = str;
        }

        /* renamed from: a */
        public void onRequestSuccess(DialPhoneResponseBean dialPhoneResponseBean) {
            super.onRequestSuccess(dialPhoneResponseBean);
            if (this.f79202b == 1) {
                if (TextUtils.isEmpty(this.f79203c)) {
                    a.this.f79189b.a(dialPhoneResponseBean, a.this.i());
                } else {
                    a.this.f79189b.a(dialPhoneResponseBean, this.f79203c);
                }
            } else if (TextUtils.isEmpty(this.f79203c)) {
                a.this.f79189b.i(dialPhoneResponseBean.getSecretNo());
            } else {
                a.this.f79189b.h(dialPhoneResponseBean.getSecretNo());
            }
        }
    }

    public class f extends q6.b<Object> {
        public f(u6.g gVar) {
            super(gVar);
        }

        public void onRequestSuccess(Object obj) {
            super.onRequestSuccess(obj);
            a.this.f79189b.c();
        }
    }

    public class g extends q6.b<CodeVerifyData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79206b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(u6.g gVar, String str) {
            super(gVar);
            this.f79206b = str;
        }

        /* renamed from: a */
        public void onRequestSuccess(CodeVerifyData codeVerifyData) {
            super.onRequestSuccess(codeVerifyData);
            if (codeVerifyData == null || TextUtils.isEmpty(codeVerifyData.getToken())) {
                a.this.f79189b.b();
                return;
            }
            a aVar = a.this;
            aVar.o(1, aVar.f79189b.R0(), this.f79206b, codeVerifyData.getToken());
        }
    }

    public class h extends q6.b<RiskControl> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79208b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(u6.g gVar, String str) {
            super(gVar);
            this.f79208b = str;
        }

        /* renamed from: a */
        public void onRequestSuccess(RiskControl riskControl) {
            super.onRequestSuccess(riskControl);
            if (riskControl.getRisk() <= 0) {
                a.this.q(this.f79208b, (Map<String, Object>) null);
            } else if (riskControl.getCaptcha_type() == 0) {
                a.this.j();
            } else {
                a.this.f79189b.g(this.f79208b);
            }
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
        }
    }

    public class i extends q6.b<ImgCaptchaData> {
        public i(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: a */
        public void onRequestSuccess(ImgCaptchaData imgCaptchaData) {
            super.onRequestSuccess(imgCaptchaData);
            String unused = a.this.f79191d = imgCaptchaData.getKey();
            a.this.f79189b.N(imgCaptchaData.getImage());
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
        }
    }

    public interface j {
        void a();
    }

    public interface k {
        void N(String str);

        void Q0(Bitmap bitmap);

        String R0();

        void a(DialPhoneResponseBean dialPhoneResponseBean, String str);

        void b();

        void c();

        void g(String str);

        void h(String str);

        void i(String str);
    }

    public a(u6.g gVar, k kVar) {
        this.f79188a = gVar;
        this.f79189b = kVar;
    }

    public void f(OtcLiteChatPresenter.s sVar) {
        OtcContactsResponseBean otcContactsResponseBean = this.f79192e;
        if (otcContactsResponseBean != null && otcContactsResponseBean.getContacts() != null && this.f79192e.getContacts().size() > 0) {
            Double d11 = (Double) this.f79192e.getContacts().get(0).get("constraintType");
            if (this.f79192e.getContacts().size() == 1 && d11.doubleValue() == 2.0d && !((String) this.f79192e.getContacts().get(0).get("contactInfo")).startsWith("http")) {
                sVar.f8(false);
            }
        }
    }

    public void g(OtcLiteChatActivity otcLiteChatActivity) {
        OtcLiteChatActivity otcLiteChatActivity2 = otcLiteChatActivity;
        OtcContactsResponseBean otcContactsResponseBean = this.f79192e;
        if (otcContactsResponseBean != null && otcContactsResponseBean.getContacts() != null && this.f79192e.getContacts().size() > 0) {
            if (this.f79192e.getContacts().size() == 1) {
                Double d11 = (Double) this.f79192e.getContacts().get(0).get("constraintType");
                if (d11.doubleValue() == 1.0d) {
                    String str = (String) this.f79192e.getContacts().get(0).get("contactInfo");
                    if (!TextUtils.isEmpty(str)) {
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
                        intent.setFlags(268435456);
                        otcLiteChatActivity2.startActivity(intent);
                    }
                } else if (d11.doubleValue() == 2.0d) {
                    String str2 = (String) this.f79192e.getContacts().get(0).get("contactInfo");
                    if (str2.startsWith("http")) {
                        otcLiteChatActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                        return;
                    }
                    ((ClipboardManager) otcLiteChatActivity2.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str2, str2));
                    HuobiToastUtil.t(otcLiteChatActivity2, R$string.n_otc_copy_success);
                }
            } else if (this.f79192e.getContacts() != null && this.f79192e.getContacts().size() >= 2) {
                String str3 = "";
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                for (int i11 = 0; i11 < this.f79192e.getContacts().size(); i11++) {
                    Double d12 = (Double) this.f79192e.getContacts().get(i11).get("constraintType");
                    if (d12.doubleValue() == 1.0d) {
                        String str7 = (String) this.f79192e.getContacts().get(i11).get("contactInfo");
                        str6 = (String) this.f79192e.getContacts().get(i11).get("contactTypeName");
                        str3 = str7;
                    } else if (d12.doubleValue() == 2.0d) {
                        String str8 = (String) this.f79192e.getContacts().get(i11).get("contactInfo");
                        str5 = (String) this.f79192e.getContacts().get(i11).get("contactTypeName");
                        str4 = str8;
                    }
                }
                otcLiteChatActivity2.Oi(str6, str5, new b(str3, otcLiteChatActivity2), new c(str4, otcLiteChatActivity2));
            }
        }
    }

    public void h(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", "VERIFY_SETTING_FICTITIOUS_PHONE");
        hashMap.put(PlaceFields.PHONE, str);
        hashMap.put("country_code", "0086");
        hashMap.put("sms_code", str2);
        new d9.a(((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestVerifySmsCode(hashMap).compose(UcRetrofit.h())).d(new g(this.f79188a, str));
    }

    public String i() {
        return this.f79190c;
    }

    public final void j() {
        new d9.a(((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestImgCaptcha().compose(UcRetrofit.h())).d(new i(this.f79188a));
    }

    public String k() {
        return this.f79191d;
    }

    public Map<String, Object> l(String str, String str2) {
        return MapParamsBuilder.c().a("captcha_key", str).a("captcha_code", str2).b();
    }

    public void m(OtcLiteChatPresenter.s sVar) {
        s8.a.a().contactList(this.f79189b.R0()).d(new d(this.f79188a, sVar));
    }

    public void o(int i11, String str, String str2, String str3) {
        s8.b a11 = s8.a.a();
        a11.dialPhone(i11 + "", str, str2, str3).d(new e(this.f79188a, i11, str2));
    }

    public void p(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(InnerShareParams.SCENCE, 2);
        hashMap.put("login_name", str);
        hashMap.put("source", 3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("version", "2");
        new d9.a(((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestRiskControl(hashMap).compose(UcRetrofit.h()).flatMap(a0.f60070b)).d(new C0845a(this.f79188a));
    }

    public void q(String str, Map<String, Object> map) {
        Map<String, Object> b11 = MapParamsBuilder.c().a("use_type", "VERIFY_SETTING_FICTITIOUS_PHONE").a("country_code", "0086").a(PlaceFields.PHONE, str).a("voice", Boolean.FALSE).b();
        if (map != null) {
            b11.putAll(map);
        }
        new d9.a(OtcModuleConfig.a().C(b11)).d(new f(this.f79188a));
    }

    public void r(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(InnerShareParams.SCENCE, 2);
        hashMap.put("login_name", str);
        hashMap.put("source", 3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("version", "2");
        new d9.a(((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestRiskControl(hashMap).compose(UcRetrofit.h())).d(new h(this.f79188a, str));
    }
}
