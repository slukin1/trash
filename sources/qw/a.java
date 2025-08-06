package qw;

import android.content.Context;
import com.kakao.common.KakaoPhase;
import com.kakao.util.helper.Utility;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final KakaoPhase f25615a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25616b;

    public a(Context context) {
        String c11 = Utility.c(context, "com.kakao.sdk.Phase");
        if (c11 != null) {
            this.f25615a = KakaoPhase.ofName(c11);
        } else {
            this.f25615a = KakaoPhase.PRODUCTION;
        }
        this.f25616b = Utility.c(context, "com.kakao.sdk.AppKey");
    }

    public KakaoPhase a() {
        return this.f25615a;
    }

    public String b() {
        return this.f25616b;
    }
}
