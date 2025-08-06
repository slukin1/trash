package c3;

import android.content.Context;
import com.alibaba.sdk.android.tbrest.SendService;
import com.alibaba.sdk.android.tbrest.request.BizRequest;
import com.alibaba.sdk.android.tbrest.request.UrlWrapper;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class b {
    public static boolean a(SendService sendService, String str, Context context, String str2, long j11, String str3, int i11, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        SendService sendService2 = sendService;
        try {
            LogUtil.d("RestAPI start send log!");
            String a11 = a.a(sendService, str, j11, str3, i11, obj, obj2, obj3, map);
            if (StringUtils.e(a11)) {
                LogUtil.d("RestAPI build data succ!");
                HashMap hashMap = new HashMap(1);
                hashMap.put(String.valueOf(i11), a11);
                byte[] bArr = null;
                String str4 = str;
                Context context2 = context;
                bArr = BizRequest.b(sendService, str, context, hashMap);
                if (bArr == null) {
                    return false;
                }
                LogUtil.d("packRequest success!");
                String str5 = str2;
                return UrlWrapper.b(sendService, str2, bArr).a();
            }
            LogUtil.d("UTRestAPI build data failure!");
            return false;
        } catch (Exception e11) {
            LogUtil.b(e11.toString());
        } catch (Throwable th2) {
            LogUtil.c("system error!", th2);
            return false;
        }
    }

    public static boolean b(SendService sendService, String str, Context context, String str2, long j11, String str3, int i11, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        SendService sendService2 = sendService;
        String str4 = str;
        try {
            LogUtil.d("RestAPI start send log by url!");
            String a11 = a.a(sendService, str, j11, str3, i11, obj, obj2, obj3, map);
            if (StringUtils.e(a11)) {
                LogUtil.d("RestAPI build data succ by url!");
                HashMap hashMap = new HashMap(1);
                hashMap.put(String.valueOf(i11), a11);
                byte[] bArr = null;
                Context context2 = context;
                bArr = BizRequest.b(sendService, str, context, hashMap);
                if (bArr == null) {
                    return false;
                }
                LogUtil.d("packRequest success by url!");
                return UrlWrapper.a(sendService, str, str2, bArr).a();
            }
            LogUtil.d("UTRestAPI build data failure by url!");
            return false;
        } catch (Exception e11) {
            LogUtil.b(e11.toString());
        } catch (Throwable th2) {
            LogUtil.c("system error by url!", th2);
            return false;
        }
    }
}
