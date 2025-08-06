package com.huobi.lite.kyc.aliface;

import android.content.Context;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.lite.kyc.aliface.a;
import java.util.HashMap;
import java.util.Map;

public class AliFaceCertificate extends AbstractCertificate {

    /* renamed from: c  reason: collision with root package name */
    public AbstractAliCertificateResult f75373c;

    /* renamed from: d  reason: collision with root package name */
    public String f75374d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f75375e = new HashMap(8);

    public class a implements b {
        public a() {
        }
    }

    public interface b {
    }

    public void a(a.b bVar) {
        if (bVar.h() instanceof AbstractAliCertificateResult) {
            this.f75373c = (AbstractAliCertificateResult) bVar.h();
        }
        this.f75371a = bVar.i();
        this.f75374d = bVar.f();
        b(bVar.g());
        c(bVar.g());
    }

    public final void b(Context context) {
        if (this.f75375e.isEmpty()) {
            this.f75375e.put("3001", context.getString(R$string.ali_error_be_overdue));
            this.f75375e.put("3101", context.getString(R$string.ali_error_verification_not_match));
            this.f75375e.put("3102", context.getString(R$string.ali_error_be_overdue_card_does_not_exist));
            this.f75375e.put("3103", context.getString(R$string.ali_error_be_overdue_id_number_illegal));
            this.f75375e.put("3104", context.getString(R$string.ali_error_be_overdue_re_submit));
            Map<String, String> map = this.f75375e;
            int i11 = R$string.ali_error_be_overdue_non_personal_operation;
            map.put("3204", context.getString(i11));
            this.f75375e.put("3206", context.getString(i11));
            this.f75375e.put("3208", context.getString(R$string.ali_error_be_overdue_please_uploada_again));
        }
    }

    public final void c(Context context) {
        this.f75372b = true;
        this.f75373c.a();
        OtcModuleConfig.a().R(context, this.f75371a, new a());
    }
}
