package ag;

import com.hbg.module.libkt.base.ext.b;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f37362a = new a();

    public static final <T> void a(JSONObject jSONObject, String str, T t11) {
        if ((t11 instanceof String) && !b.x((String) t11)) {
            jSONObject.put(str, t11);
        } else if (t11 instanceof Integer) {
            Number number = (Number) t11;
            if (number.intValue() > 0) {
                jSONObject.put(str, number.intValue());
            }
        }
    }

    public static final String b(String str, String str2, String str3, String str4, String str5, String str6, int i11, String str7, String str8, int i12, int i13, String str9) {
        return "{\"shareActionTitle\":\"" + str + "\",\"shareActionUrl\":\"" + str2 + "\",\"topicId\":\"" + str3 + "\",\"shareTitle\":\"" + str4 + "\",\"shareText\":\"" + str5 + "\",\"shareContent\":\"" + str6 + "\",\"shareChannel\":" + i11 + ",\"shareUrl\":\"" + str7 + "\",\"shareImageUrl\":\"" + str8 + "\",\"shareImageWidth\":" + i12 + ",\"shareImageHeight\":" + i13 + ",\"shareSource\":\"" + str9 + "\"}";
    }

    public static /* synthetic */ String c(String str, String str2, String str3, String str4, String str5, String str6, int i11, String str7, String str8, int i12, int i13, String str9, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            str = "";
        }
        if ((i14 & 2) != 0) {
            str2 = "";
        }
        if ((i14 & 4) != 0) {
            str3 = "";
        }
        if ((i14 & 8) != 0) {
            str4 = "";
        }
        if ((i14 & 16) != 0) {
            str5 = "";
        }
        if ((i14 & 32) != 0) {
            str6 = "";
        }
        if ((i14 & 64) != 0) {
            i11 = 1;
        }
        if ((i14 & 128) != 0) {
            str7 = null;
        }
        if ((i14 & 256) != 0) {
            str8 = null;
        }
        if ((i14 & 512) != 0) {
            i12 = 0;
        }
        if ((i14 & 1024) != 0) {
            i13 = 0;
        }
        if ((i14 & 2048) != 0) {
            str9 = "";
        }
        return b(str, str2, str3, str4, str5, str6, i11, str7, str8, i12, i13, str9);
    }

    public static /* synthetic */ String e(a aVar, String str, String str2, String str3, String str4, int i11, int i12, String str5, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = "";
        }
        if ((i13 & 2) != 0) {
            str2 = "";
        }
        if ((i13 & 4) != 0) {
            str3 = "";
        }
        if ((i13 & 8) != 0) {
            str4 = null;
        }
        if ((i13 & 16) != 0) {
            i11 = 0;
        }
        if ((i13 & 32) != 0) {
            i12 = 0;
        }
        if ((i13 & 64) != 0) {
            str5 = null;
        }
        return aVar.d(str, str2, str3, str4, i11, i12, str5);
    }

    public final String d(String str, String str2, String str3, String str4, int i11, int i12, String str5) {
        if (b.x(str5)) {
            return c((String) null, (String) null, (String) null, (String) null, str2, str3, 0, str4, str, i11, i12, (String) null, 2127, (Object) null);
        }
        try {
            JSONObject jSONObject = new JSONObject(str5);
            try {
                a(jSONObject, "shareText", str2);
            } catch (Throwable th2) {
                th = th2;
                String str6 = str;
                String str7 = str3;
                String str8 = str4;
                th.printStackTrace();
                return c((String) null, (String) null, (String) null, (String) null, str2, str3, 0, str4, str, i11, i12, (String) null, 2127, (Object) null);
            }
            try {
                a(jSONObject, "shareContent", str3);
            } catch (Throwable th3) {
                th = th3;
                String str9 = str;
                String str82 = str4;
                th.printStackTrace();
                return c((String) null, (String) null, (String) null, (String) null, str2, str3, 0, str4, str, i11, i12, (String) null, 2127, (Object) null);
            }
            try {
                a(jSONObject, "shareUrl", str4);
            } catch (Throwable th4) {
                th = th4;
                String str10 = str;
                th.printStackTrace();
                return c((String) null, (String) null, (String) null, (String) null, str2, str3, 0, str4, str, i11, i12, (String) null, 2127, (Object) null);
            }
            try {
                a(jSONObject, "shareImageUrl", str);
                a(jSONObject, "shareImageWidth", Integer.valueOf(i11));
                a(jSONObject, "shareImageHeight", Integer.valueOf(i12));
                return jSONObject.toString();
            } catch (Throwable th5) {
                th = th5;
                th.printStackTrace();
                return c((String) null, (String) null, (String) null, (String) null, str2, str3, 0, str4, str, i11, i12, (String) null, 2127, (Object) null);
            }
        } catch (Throwable th6) {
            th = th6;
            String str11 = str;
            String str12 = str2;
            String str72 = str3;
            String str822 = str4;
            th.printStackTrace();
            return c((String) null, (String) null, (String) null, (String) null, str2, str3, 0, str4, str, i11, i12, (String) null, 2127, (Object) null);
        }
    }
}
