package gs;

import android.os.Bundle;
import bh.j;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sns.internal.core.common.n0;

public class c {
    public static void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ZendeskIdentityStorage.UUID_KEY, str);
        bundle.putString("platform", n0.f32119g);
        bundle.putString("product", "HuobiGlobal");
        FirebaseAnalytics.getInstance(j.c()).logEvent("GA_EMAIL_SUCCESS", bundle);
    }

    public static void b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ZendeskIdentityStorage.UUID_KEY, str);
        bundle.putString("platform", n0.f32119g);
        bundle.putString("product", "HuobiGlobal");
        FirebaseAnalytics.getInstance(j.c()).logEvent("GA_PHONE_SUCCESS", bundle);
    }

    public static void c() {
        Bundle bundle = new Bundle();
        bundle.putString("value", "0.25");
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, "USD");
        FirebaseAnalytics.getInstance(j.c()).logEvent("Event1", bundle);
        FirebaseAnalytics.getInstance(j.c()).logEvent("Event11", new Bundle());
        Bundle bundle2 = new Bundle();
        bundle.putString("value", "0.2");
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, "USD");
        FirebaseAnalytics.getInstance(j.c()).logEvent("Event27", bundle2);
    }
}
