package tg;

import android.content.Context;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.account.entity.KeepTimeData;
import com.huobi.store.AppConfigManager;
import i6.d;
import i6.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Integer> f47863a = new HashMap();

    public static void a() {
        KeepTimeData keepTimeData = (KeepTimeData) AppConfigManager.c(MgtConfigNumber.LOGIN_KEEP_TIME.number, KeepTimeData.class);
        if (keepTimeData != null) {
            i(keepTimeData.getLoginKeepTime());
        } else {
            i(HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE);
        }
    }

    @Deprecated
    public static int b() {
        int i11;
        String str = "SP_KEY_KEEP_LOGIN_TIME_" + r.x().J();
        if (!f47863a.containsKey(str)) {
            i11 = SP.e(str, 4);
            f47863a.put(str, Integer.valueOf(i11));
        } else {
            i11 = f47863a.get(str).intValue();
        }
        d.b("KeepLoginTimeHelper-->getCurrentType-->> key:" + str + " type:" + i11 + " mTypeMap:" + f47863a);
        return i11;
    }

    @Deprecated
    public static String c(Context context) {
        return String.format(Locale.US, context.getResources().getString(R.string.security_keep_login_time_hour), new Object[]{String.valueOf(f())});
    }

    @Deprecated
    public static String d(Context context, int i11) {
        return String.format(Locale.US, context.getResources().getString(R.string.security_keep_login_time_hour), new Object[]{String.valueOf(i11)});
    }

    public static long e() {
        long f11 = (long) (f() * 60 * 60 * 1000);
        return f11 <= 0 ? Period.WEEK_MILLS : f11;
    }

    public static int f() {
        return SP.e("SP_KEY_KEEP_LOGIN_TIME_MS", HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE);
    }

    public static boolean g() {
        return SP.l("SP_KEY_KEEP_LOGIN_TIME_TO_BACKGROUND", false);
    }

    public static void h() {
        k.o("global_login_auto", "restore2BackgroundLoginStatus : " + r.x().F0());
        SP.y("SP_KEY_KEEP_LOGIN_TIME_TO_BACKGROUND", r.x().F0());
    }

    public static void i(int i11) {
        if (i11 <= 0) {
            i11 = HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE;
        }
        SP.q("SP_KEY_KEEP_LOGIN_TIME_MS", i11);
    }

    @Deprecated
    public static void j(int i11) {
        String str = "SP_KEY_KEEP_LOGIN_TIME_" + r.x().J();
        f47863a.put(str, Integer.valueOf(i11));
        d.b("KeepLoginTimeHelper-->setCurrentType--> key:" + str + " type:" + i11 + " mTypeMap:" + f47863a);
        SP.q(str, i11);
    }
}
