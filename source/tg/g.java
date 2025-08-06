package tg;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.account.entity.MultipleAccountData;
import com.huobi.utils.GsonHelper;
import i6.d;
import i6.k;
import java.util.ArrayList;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f47864a;

    public class a extends TypeToken<List<MultipleAccountData>> {
    }

    public static List<MultipleAccountData> a() {
        String d11 = ConfigPreferences.d("user_config", "config_access_multiple_account");
        if (TextUtils.isEmpty(d11)) {
            return new ArrayList();
        }
        try {
            return (List) GsonHelper.a().fromJson(d11, new a().getType());
        } catch (Exception e11) {
            k.d(ShareConstants.ACTION, "MULTIPLE GET DATA FAIL:" + e11.toString());
            return new ArrayList();
        }
    }

    public static boolean b() {
        return f47864a;
    }

    public static void c(List<MultipleAccountData> list) {
        try {
            ConfigPreferences.m("user_config", "config_access_multiple_account", GsonHelper.a().toJson((Object) list));
        } catch (Exception unused) {
            d.c(ShareConstants.ACTION, "MultipleAccountHelper SaveData Fail");
        }
    }

    public static void d(boolean z11) {
        f47864a = z11;
    }
}
