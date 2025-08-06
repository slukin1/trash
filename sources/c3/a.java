package c3;

import android.os.Build;
import com.alibaba.sdk.android.tbrest.SendService;
import com.alibaba.sdk.android.tbrest.utils.DeviceUtils;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.StringUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f13004a = System.currentTimeMillis();

    public static String a(SendService sendService, String str, long j11, String str2, int i11, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        long j12;
        String str3;
        SendService sendService2 = sendService;
        String str4 = null;
        if (i11 == 0) {
            return null;
        }
        try {
            String l11 = DeviceUtils.l(sendService2.f14686a);
            if (l11 == null) {
                LogUtil.b("get utdid failure, so build report failure, now return");
                return null;
            }
            String[] i12 = DeviceUtils.i(sendService2.f14686a);
            String str5 = i12[0];
            if (i12.length > 1 && str5 != null && !"Wi-Fi".equals(str5)) {
                str4 = i12[1];
            }
            if (j11 > 0) {
                j12 = j11;
            } else {
                j12 = System.currentTimeMillis();
            }
            String str6 = "" + j12;
            String b11 = b(str2);
            String b12 = b(String.valueOf(i11));
            String b13 = b(StringUtils.b(obj));
            String b14 = b(StringUtils.b(obj2));
            String b15 = b(StringUtils.b(obj3));
            String b16 = b(StringUtils.a(map));
            String b17 = b(DeviceUtils.e(sendService2.f14686a));
            String b18 = b(DeviceUtils.f(sendService2.f14686a));
            String b19 = b(Build.BRAND);
            b(DeviceUtils.d());
            b(b17);
            String str7 = b16;
            String b21 = b(Build.MODEL);
            String str8 = b15;
            String b22 = b(DeviceUtils.j(sendService2.f14686a));
            String str9 = b14;
            String b23 = b(DeviceUtils.b(sendService2.f14686a));
            String b24 = b(str5);
            String b25 = b(str4);
            String str10 = b13;
            String b26 = b(str);
            String str11 = b12;
            String b27 = b(sendService2.f14690e);
            String str12 = b11;
            String b28 = b(sendService2.f14691f);
            String str13 = str6;
            String b29 = b(sendService2.f14692g);
            Object obj4 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String b31 = b(sendService2.f14692g);
            b(DeviceUtils.c());
            String str14 = b31;
            String b32 = b(DeviceUtils.g());
            String str15 = sendService2.f14687b;
            String str16 = "a";
            String str17 = b29;
            String b33 = b(Build.VERSION.RELEASE);
            Object obj5 = "mini";
            String b34 = b(l11);
            String b35 = b(sendService2.f14695j);
            StringUtils.c("");
            if (str15 != null) {
                str3 = b35;
                if (str15.contains("aliyunos")) {
                    str16 = "y";
                }
            } else {
                str3 = b35;
            }
            HashMap hashMap = new HashMap();
            String str18 = b34;
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.IMEI.toString(), b17);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.IMSI.toString(), b18);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.BRAND.toString(), b19);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.DEVICE_MODEL.toString(), b21);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.RESOLUTION.toString(), b22);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.CARRIER.toString(), b23);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.ACCESS.toString(), b24);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.ACCESS_SUBTYPE.toString(), b25);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.CHANNEL.toString(), b28);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.APPKEY.toString(), b26);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.APPVERSION.toString(), b27);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.LL_USERNICK.toString(), str17);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.USERNICK.toString(), str14);
            Object obj6 = obj4;
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.LL_USERID.toString(), obj6);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.USERID.toString(), obj6);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.LANGUAGE.toString(), b32);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.OS.toString(), str16);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.OSVERSION.toString(), b33);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.SDKVERSION.toString(), "1.0");
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.START_SESSION_TIMESTAMP.toString(), "" + f13004a);
            String str19 = str18;
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.UTDID.toString(), str19);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.SDKTYPE.toString(), obj5);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.RESERVE2.toString(), str19);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.RESERVE3.toString(), obj6);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.RESERVE4.toString(), obj6);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.RESERVE5.toString(), obj6);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.RESERVES.toString(), str3);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.RECORD_TIMESTAMP.toString(), str13);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.PAGE.toString(), str12);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.EVENTID.toString(), str11);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.ARG1.toString(), str10);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.ARG2.toString(), str9);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.ARG3.toString(), str8);
            hashMap.put(com.alibaba.sdk.android.tbrest.rest.a.ARGS.toString(), str7);
            return c(hashMap);
        } catch (Exception e11) {
            LogUtil.c("UTRestAPI buildTracePostReqDataObj catch!", e11);
            return "";
        }
    }

    public static String b(String str) {
        if (StringUtils.c(str)) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        if ("".equals(str)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (!(charArray[i11] == 10 || charArray[i11] == 13 || charArray[i11] == 9 || charArray[i11] == '|')) {
                sb2.append(charArray[i11]);
            }
        }
        return sb2.toString();
    }

    public static String c(Map<String, String> map) {
        boolean z11;
        com.alibaba.sdk.android.tbrest.rest.a aVar;
        StringBuffer stringBuffer = new StringBuffer();
        com.alibaba.sdk.android.tbrest.rest.a[] values = com.alibaba.sdk.android.tbrest.rest.a.values();
        int length = values.length;
        int i11 = 0;
        while (true) {
            String str = null;
            if (i11 >= length || (aVar = values[i11]) == com.alibaba.sdk.android.tbrest.rest.a.ARGS) {
                com.alibaba.sdk.android.tbrest.rest.a aVar2 = com.alibaba.sdk.android.tbrest.rest.a.ARGS;
            } else {
                if (map.containsKey(aVar.toString())) {
                    str = StringUtils.b(map.get(aVar.toString()));
                    map.remove(aVar.toString());
                }
                stringBuffer.append(b(str));
                stringBuffer.append("||");
                i11++;
            }
        }
        com.alibaba.sdk.android.tbrest.rest.a aVar22 = com.alibaba.sdk.android.tbrest.rest.a.ARGS;
        if (map.containsKey(aVar22.toString())) {
            stringBuffer.append(b(StringUtils.b(map.get(aVar22.toString()))));
            map.remove(aVar22.toString());
            z11 = false;
        } else {
            z11 = true;
        }
        for (String next : map.keySet()) {
            String b11 = map.containsKey(next) ? StringUtils.b(map.get(next)) : null;
            if (z11) {
                if ("StackTrace".equals(next)) {
                    stringBuffer.append("StackTrace=====>");
                    stringBuffer.append(b11);
                } else {
                    stringBuffer.append(b(next));
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(b11);
                }
                z11 = false;
            } else if ("StackTrace".equals(next)) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append("StackTrace=====>");
                stringBuffer.append(b11);
            } else {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuffer.append(b(next));
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(b11);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (StringUtils.d(stringBuffer2) || !stringBuffer2.endsWith("||")) {
            return stringBuffer2;
        }
        return stringBuffer2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    }
}
