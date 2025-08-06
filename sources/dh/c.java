package dh;

import android.os.Build;
import android.util.Base64;
import bh.j;
import cn.sharesdk.framework.InnerShareParams;
import com.google.gson.JsonObject;
import com.hbg.lib.common.utils.crypt.rsa.RSAProvider;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.trade.prime.service.PrimeService;
import com.huobi.vulcan.model.VulcanInfo;
import com.sumsub.sns.internal.core.common.n0;
import com.twitter.sdk.android.core.identity.AuthHandler;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import tg.r;
import tq.p;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f47466a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDbApppRsKWss6oTwhSDzoFhjtow9kcA8FFDVwplIyGqmim68/6ObsQvx42dnsqyCxlGsDtQLQ5jWfGRRKgLymWvfJOmnQHeFqgoUSgSYvT1RKZanbtcPQu5N8gcwB1Q7RjXfrd7CmhT6nH7P6HSyW";

    public static String c(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("device_brand", Build.BRAND);
        jsonObject.addProperty("device_source", n0.f32119g);
        jsonObject.addProperty("device_type", Build.MODEL);
        jsonObject.addProperty("sys_type", Build.VERSION.RELEASE);
        jsonObject.addProperty("tz", TimeZone.getDefault().getDisplayName(false, 0));
        jsonObject.addProperty(VulcanInfo.FP, PhoneUtils.s(true));
        jsonObject.addProperty(AuthHandler.EXTRA_TOKEN_SECRET, String.valueOf(System.currentTimeMillis()));
        jsonObject.addProperty("uid", r.x().J());
        String[] u11 = PhoneUtils.u(j.c());
        jsonObject.addProperty("bssid", u11[1]);
        jsonObject.addProperty("ssid", u11[0]);
        jsonObject.addProperty("network_type", PhoneUtils.n(j.c()));
        jsonObject.addProperty(InnerShareParams.SCENCE, str);
        jsonObject.addProperty(VulcanInfo.IMEI, "");
        jsonObject.addProperty("mac", PhoneUtils.i());
        return jsonObject.toString();
    }

    public static String d(String str) {
        try {
            String string = j.c().getResources().getString(R.string.app_p_k);
            byte[] bytes = c(str).getBytes("utf-8");
            return Base64.encodeToString(RSAProvider.d(bytes, f47466a + string), 0);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ Observable f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("content", str);
        return ((PrimeService) p.C(PrimeService.class)).sendDeviceInfo2Hbg(hashMap).compose(p.D()).compose(RxJavaHelper.s());
    }

    public static void g(String str) {
        Observable.defer(new a(str)).delay(15, TimeUnit.SECONDS).compose(RxJavaHelper.s()).flatMap(b.f53633b).compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
    }
}
