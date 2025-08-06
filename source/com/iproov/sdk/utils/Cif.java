package com.iproov.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p026return.Cextends;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.utils.if  reason: invalid class name */
public class Cif {

    /* renamed from: do  reason: not valid java name */
    public static final String f2380do = "if";

    /* renamed from: com.iproov.sdk.utils.if$do  reason: invalid class name */
    public static /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f2381do;

        /* renamed from: for  reason: not valid java name */
        public static final /* synthetic */ int[] f2382for;

        /* renamed from: if  reason: not valid java name */
        public static final /* synthetic */ int[] f2383if;

        /* renamed from: new  reason: not valid java name */
        public static final /* synthetic */ int[] f2384new;

        /* renamed from: try  reason: not valid java name */
        public static final /* synthetic */ int[] f2385try;

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|(2:29|30)|31|33|34|(2:35|36)|37|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b3 */
        static {
            /*
                com.iproov.sdk.return.extends$try[] r0 = com.iproov.sdk.p026return.Cextends.Ctry.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2385try = r0
                r1 = 1
                com.iproov.sdk.return.extends$try r2 = com.iproov.sdk.p026return.Cextends.Ctry.CLASSIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f2385try     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.return.extends$try r3 = com.iproov.sdk.p026return.Cextends.Ctry.BLAZEFACE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f2385try     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.return.extends$try r4 = com.iproov.sdk.p026return.Cextends.Ctry.ML_KIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f2385try     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.return.extends$try r5 = com.iproov.sdk.p026return.Cextends.Ctry.AUTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.iproov.sdk.return.extends$do[] r4 = com.iproov.sdk.p026return.Cextends.Cdo.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f2384new = r4
                com.iproov.sdk.return.extends$do r5 = com.iproov.sdk.p026return.Cextends.Cdo.EXTERNAL     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = f2384new     // Catch:{ NoSuchFieldError -> 0x004e }
                com.iproov.sdk.return.extends$do r5 = com.iproov.sdk.p026return.Cextends.Cdo.FRONT     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                com.iproov.sdk.cameray.Orientation[] r4 = com.iproov.sdk.cameray.Orientation.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f2382for = r4
                com.iproov.sdk.cameray.Orientation r5 = com.iproov.sdk.cameray.Orientation.LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x005f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                int[] r4 = f2382for     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.iproov.sdk.cameray.Orientation r5 = com.iproov.sdk.cameray.Orientation.REVERSE_PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r4 = f2382for     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.iproov.sdk.cameray.Orientation r5 = com.iproov.sdk.cameray.Orientation.REVERSE_LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r4 = f2382for     // Catch:{ NoSuchFieldError -> 0x007d }
                com.iproov.sdk.cameray.Orientation r5 = com.iproov.sdk.cameray.Orientation.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x007d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                com.iproov.sdk.return.extends$break[] r3 = com.iproov.sdk.p026return.Cextends.Cbreak.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f2383if = r3
                com.iproov.sdk.return.extends$break r4 = com.iproov.sdk.p026return.Cextends.Cbreak.BLUR     // Catch:{ NoSuchFieldError -> 0x008e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                int[] r3 = f2383if     // Catch:{ NoSuchFieldError -> 0x0098 }
                com.iproov.sdk.return.extends$break r4 = com.iproov.sdk.p026return.Cextends.Cbreak.CLEAR     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                com.iproov.sdk.return.extends$this[] r3 = com.iproov.sdk.p026return.Cextends.Cthis.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f2381do = r3
                com.iproov.sdk.return.extends$this r4 = com.iproov.sdk.p026return.Cextends.Cthis.CLASSIC     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r1 = f2381do     // Catch:{ NoSuchFieldError -> 0x00b3 }
                com.iproov.sdk.return.extends$this r3 = com.iproov.sdk.p026return.Cextends.Cthis.VIBRANT     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                int[] r0 = f2381do     // Catch:{ NoSuchFieldError -> 0x00bd }
                com.iproov.sdk.return.extends$this r1 = com.iproov.sdk.p026return.Cextends.Cthis.SHADED     // Catch:{ NoSuchFieldError -> 0x00bd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00bd }
            L_0x00bd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.utils.Cif.Cdo.<clinit>():void");
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static String m2268do(JSONObject jSONObject, String str, String str2) {
        return (jSONObject == null || jSONObject.isNull(str)) ? str2 : jSONObject.optString(str);
    }

    /* renamed from: if  reason: not valid java name */
    public static String m2277if(JSONObject jSONObject, String str) {
        return m2268do(jSONObject, str, (String) null);
    }

    /* renamed from: do  reason: not valid java name */
    public static float m2244do(JSONObject jSONObject, String str, float f11) {
        return (float) jSONObject.optDouble(str, (double) f11);
    }

    /* renamed from: if  reason: not valid java name */
    public static void m2278if(JSONObject jSONObject, String str, Orientation orientation) {
        m2276do(jSONObject, str, (Object) m2261do(orientation));
    }

    /* renamed from: do  reason: not valid java name */
    public static Bitmap m2247do(JSONObject jSONObject, String str) throws JSONException {
        byte[] decode = Base64.decode(jSONObject.getString(str), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    /* renamed from: if  reason: not valid java name */
    public static void m2281if(JSONObject jSONObject, String str, Integer num) {
        m2276do(jSONObject, str, (Object) m2266do(num));
    }

    /* renamed from: if  reason: not valid java name */
    public static void m2279if(JSONObject jSONObject, String str, Cextends.Cdo doVar) {
        m2276do(jSONObject, str, (Object) m2263do(doVar));
    }

    /* renamed from: do  reason: not valid java name */
    public static Bitmap m2248do(JSONObject jSONObject, String str, Bitmap bitmap) {
        try {
            return m2247do(jSONObject, str);
        } catch (JSONException unused) {
            return bitmap;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m2280if(JSONObject jSONObject, String str, Cextends.Ctry tryR) {
        m2276do(jSONObject, str, (Object) m2265do(tryR));
    }

    /* renamed from: do  reason: not valid java name */
    public static Cextends.Ccase.Cdo m2252do(JSONObject jSONObject, String str, Cextends.Ccase.Cdo doVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return doVar;
        }
        return new Cextends.Ccase.Cdo(m2256do(optJSONObject.optString("style"), doVar != null ? doVar.m1482for() : Cextends.Cthis.SHADED), m2246do(optJSONObject, OptionsBridge.FILTER_FOREGROUND_COLOR, doVar != null ? doVar.m1483if() : Color.parseColor("#404040")), m2246do(optJSONObject, OptionsBridge.FILTER_BACKGROUND_COLOR, doVar != null ? doVar.m1481do() : Color.parseColor("#FAFAFA")));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.iproov.sdk.return.extends$case$do} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.iproov.sdk.return.extends$case$if} */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.iproov.sdk.p026return.Cextends.Ccase m2253do(org.json.JSONObject r3, java.lang.String r4, com.iproov.sdk.p026return.Cextends.Ccase r5) {
        /*
            org.json.JSONObject r0 = r3.optJSONObject(r4)
            if (r0 != 0) goto L_0x0007
            return r5
        L_0x0007:
            java.lang.String r1 = "name"
            java.lang.String r2 = "line_drawing"
            java.lang.String r1 = r0.optString(r1, r2)
            java.lang.String r2 = "natural"
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x0038
            boolean r3 = r5 instanceof com.iproov.sdk.p026return.Cextends.Ccase.Cif
            if (r3 == 0) goto L_0x001f
            r2 = r5
            com.iproov.sdk.return.extends$case$if r2 = (com.iproov.sdk.p026return.Cextends.Ccase.Cif) r2
        L_0x001f:
            if (r2 == 0) goto L_0x0026
            com.iproov.sdk.return.extends$break r3 = r2.m1484do()
            goto L_0x0028
        L_0x0026:
            com.iproov.sdk.return.extends$break r3 = com.iproov.sdk.p026return.Cextends.Cbreak.CLEAR
        L_0x0028:
            com.iproov.sdk.return.extends$case$if r4 = new com.iproov.sdk.return.extends$case$if
            java.lang.String r5 = "style"
            java.lang.String r5 = r0.optString(r5)
            com.iproov.sdk.return.extends$break r3 = m2251do((java.lang.String) r5, (com.iproov.sdk.p026return.Cextends.Cbreak) r3)
            r4.<init>(r3)
            return r4
        L_0x0038:
            boolean r0 = r5 instanceof com.iproov.sdk.p026return.Cextends.Ccase.Cdo
            if (r0 == 0) goto L_0x003f
            r2 = r5
            com.iproov.sdk.return.extends$case$do r2 = (com.iproov.sdk.p026return.Cextends.Ccase.Cdo) r2
        L_0x003f:
            com.iproov.sdk.return.extends$case$do r3 = m2252do((org.json.JSONObject) r3, (java.lang.String) r4, (com.iproov.sdk.p026return.Cextends.Ccase.Cdo) r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.utils.Cif.m2253do(org.json.JSONObject, java.lang.String, com.iproov.sdk.return.extends$case):com.iproov.sdk.return.extends$case");
    }

    /* renamed from: do  reason: not valid java name */
    public static int m2246do(JSONObject jSONObject, String str, int i11) {
        try {
            return jSONObject.has(str) ? Color.parseColor(jSONObject.optString(str)) : i11;
        } catch (IllegalArgumentException unused) {
            return i11;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static Orientation m2250do(JSONObject jSONObject, String str, Orientation orientation) {
        return m2249do(jSONObject.optString(str, m2261do(orientation)), orientation);
    }

    /* renamed from: do  reason: not valid java name */
    public static Cextends.Cdo m2255do(JSONObject jSONObject, String str, Cextends.Cdo doVar) {
        return m2254do(jSONObject.optString(str, m2263do(doVar)), doVar);
    }

    /* renamed from: do  reason: not valid java name */
    public static Cextends.Ctry m2258do(JSONObject jSONObject, String str, Cextends.Ctry tryR) {
        return m2257do(jSONObject.optString(str, m2265do(tryR)), tryR);
    }

    /* renamed from: do  reason: not valid java name */
    public static Double m2259do(JSONObject jSONObject, String str, Double d11) {
        return (!jSONObject.has(str) || jSONObject.isNull(str)) ? d11 : Double.valueOf((double) ((float) jSONObject.optDouble(str)));
    }

    /* renamed from: do  reason: not valid java name */
    public static Integer m2260do(JSONObject jSONObject, String str, Integer num) {
        return (!jSONObject.has(str) || jSONObject.isNull(str)) ? num : Integer.valueOf(jSONObject.optInt(str));
    }

    /* renamed from: do  reason: not valid java name */
    public static String m2264do(Cextends.Cthis thisR) {
        int i11 = Cdo.f2381do[thisR.ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? "shaded" : "vibrant";
        }
        return "classic";
    }

    /* renamed from: do  reason: not valid java name */
    public static String m2262do(Cextends.Cbreak breakR) {
        return Cdo.f2383if[breakR.ordinal()] != 1 ? "clear" : "blur";
    }

    /* renamed from: do  reason: not valid java name */
    public static Cextends.Cbreak m2251do(String str, Cextends.Cbreak breakR) {
        str.hashCode();
        if (str.equals("blur")) {
            return Cextends.Cbreak.BLUR;
        }
        if (!str.equals("clear")) {
            return breakR;
        }
        return Cextends.Cbreak.CLEAR;
    }

    /* renamed from: do  reason: not valid java name */
    public static Cextends.Cthis m2256do(String str, Cextends.Cthis thisR) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -903579689:
                if (str.equals("shaded")) {
                    c11 = 0;
                    break;
                }
                break;
            case 451310788:
                if (str.equals("vibrant")) {
                    c11 = 1;
                    break;
                }
                break;
            case 853620882:
                if (str.equals("classic")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return Cextends.Cthis.SHADED;
            case 1:
                return Cextends.Cthis.VIBRANT;
            case 2:
                return Cextends.Cthis.CLASSIC;
            default:
                return thisR;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m2274do(JSONObject jSONObject, String str, int i11, int i12) {
        m2276do(jSONObject, str, (Object) m2267do((Object) m2266do(Integer.valueOf(i11)), (Object) m2266do(Integer.valueOf(i12))));
    }

    /* renamed from: do  reason: not valid java name */
    public static String m2267do(Object obj, Object obj2) {
        if (obj != null && obj.equals(obj2)) {
            return "default";
        }
        if (obj == null && obj2 == null) {
            return "default";
        }
        if ((obj instanceof List) && ((List) obj).isEmpty()) {
            return OptionsBridge.EMPTY_VALUE;
        }
        if (!(obj instanceof String) || !((String) obj).isEmpty()) {
            return obj == null ? OptionsBridge.NULL_VALUE : "custom";
        }
        return OptionsBridge.EMPTY_VALUE;
    }

    /* renamed from: do  reason: not valid java name */
    private static Orientation m2249do(String str, Orientation orientation) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -675508834:
                if (str.equals("reverse_landscape")) {
                    c11 = 0;
                    break;
                }
                break;
            case -31410088:
                if (str.equals("reverse_portrait")) {
                    c11 = 1;
                    break;
                }
                break;
            case 729267099:
                if (str.equals("portrait")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1430647483:
                if (str.equals("landscape")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return Orientation.REVERSE_LANDSCAPE;
            case 1:
                return Orientation.REVERSE_PORTRAIT;
            case 2:
                return Orientation.PORTRAIT;
            case 3:
                return Orientation.LANDSCAPE;
            default:
                return orientation;
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static String m2261do(Orientation orientation) {
        int i11 = Cdo.f2382for[orientation.ordinal()];
        if (i11 == 1) {
            return "landscape";
        }
        if (i11 != 2) {
            return i11 != 3 ? "portrait" : "reverse_landscape";
        }
        return "reverse_portrait";
    }

    /* renamed from: do  reason: not valid java name */
    private static Cextends.Cdo m2254do(String str, Cextends.Cdo doVar) {
        str.hashCode();
        if (str.equals("external")) {
            return Cextends.Cdo.EXTERNAL;
        }
        if (!str.equals("front")) {
            return doVar;
        }
        return Cextends.Cdo.FRONT;
    }

    /* renamed from: do  reason: not valid java name */
    private static String m2263do(Cextends.Cdo doVar) {
        return Cdo.f2384new[doVar.ordinal()] != 1 ? "front" : "external";
    }

    /* renamed from: do  reason: not valid java name */
    private static Cextends.Ctry m2257do(String str, Cextends.Ctry tryR) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1071713226:
                if (str.equals("ml_kit")) {
                    c11 = 0;
                    break;
                }
                break;
            case -563351033:
                if (str.equals("firebase")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals(TtmlNode.TEXT_EMPHASIS_AUTO)) {
                    c11 = 2;
                    break;
                }
                break;
            case 103987415:
                if (str.equals("mlkit")) {
                    c11 = 3;
                    break;
                }
                break;
            case 853620882:
                if (str.equals("classic")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1985755167:
                if (str.equals("blazeface")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 3:
                return Cextends.Ctry.ML_KIT;
            case 2:
                return Cextends.Ctry.AUTO;
            case 4:
                return Cextends.Ctry.CLASSIC;
            case 5:
                return Cextends.Ctry.BLAZEFACE;
            default:
                return tryR;
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static String m2265do(Cextends.Ctry tryR) {
        int i11 = Cdo.f2385try[tryR.ordinal()];
        if (i11 == 1) {
            return "classic";
        }
        if (i11 != 2) {
            return i11 != 3 ? TtmlNode.TEXT_EMPHASIS_AUTO : "mlkit";
        }
        return "blazeface";
    }

    /* renamed from: do  reason: not valid java name */
    public static String m2266do(Integer num) {
        return String.format("#%08X", new Object[]{num});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        r1 = r1.getResources().getIdentifier(r2, r4, r1.getPackageName());
     */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m2245do(android.content.Context r1, org.json.JSONObject r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r2 = r2.optString(r3, r0)
            int r3 = r2.length()
            if (r3 != 0) goto L_0x000d
            return r5
        L_0x000d:
            android.content.res.Resources r3 = r1.getResources()
            java.lang.String r1 = r1.getPackageName()
            int r1 = r3.getIdentifier(r2, r4, r1)
            if (r1 == 0) goto L_0x001c
            r5 = r1
        L_0x001c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.utils.Cif.m2245do(android.content.Context, org.json.JSONObject, java.lang.String, java.lang.String, int):int");
    }

    /* renamed from: do  reason: not valid java name */
    public static List<Cextends.Cfor> m2269do(Context context, JSONObject jSONObject, String str, List<Cextends.Cfor> list) throws InvalidOptionsException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < optJSONArray.length()) {
            String optString = optJSONArray.optString(i11, (String) null);
            if (optString != null) {
                arrayList.add(new Cextends.Cfor.Cdo(Base64.decode(optString, 2)));
                i11++;
            } else {
                throw new InvalidOptionsException(context, "Certificates array can not contain a null certificate, item must be a base 64 encoded string in DER format");
            }
        }
        return arrayList;
    }

    /* renamed from: do  reason: not valid java name */
    public static void m2276do(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
            IPLog.w(f2380do, String.format("JSON Error adding value %s to key %s", new Object[]{obj, str}));
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static JSONArray m2272do(String[] strArr) {
        try {
            return new JSONArray(strArr);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static JSONArray m2270do(float[] fArr) {
        try {
            return new JSONArray(fArr);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static JSONArray m2271do(int[] iArr) {
        try {
            return new JSONArray(iArr);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m2275do(JSONObject jSONObject, String str, Cextends.Ccase caseR, Cextends.Ccase caseR2) {
        m2276do(jSONObject, str, (Object) m2273do(caseR, caseR2));
    }

    /* renamed from: do  reason: not valid java name */
    private static JSONObject m2273do(Cextends.Ccase caseR, Cextends.Ccase caseR2) {
        if (caseR instanceof Cextends.Ccase.Cdo) {
            JSONObject jSONObject = new JSONObject();
            Cextends.Ccase.Cdo doVar = (Cextends.Ccase.Cdo) caseR;
            m2276do(jSONObject, "name", (Object) OptionsBridge.FILTER_LINE_DRAWING);
            m2276do(jSONObject, "style", (Object) m2264do(doVar.m1482for()));
            if (caseR2 instanceof Cextends.Ccase.Cdo) {
                Cextends.Ccase.Cdo doVar2 = (Cextends.Ccase.Cdo) caseR2;
                m2274do(jSONObject, OptionsBridge.FILTER_FOREGROUND_COLOR, doVar.m1483if(), doVar2.m1483if());
                m2274do(jSONObject, OptionsBridge.FILTER_BACKGROUND_COLOR, doVar.m1481do(), doVar2.m1481do());
            } else {
                m2276do(jSONObject, OptionsBridge.FILTER_FOREGROUND_COLOR, (Object) "custom");
                m2276do(jSONObject, OptionsBridge.FILTER_BACKGROUND_COLOR, (Object) "custom");
            }
            return jSONObject;
        } else if (!(caseR instanceof Cextends.Ccase.Cif)) {
            return null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            m2276do(jSONObject2, "name", (Object) OptionsBridge.FILTER_NATURAL);
            m2276do(jSONObject2, "style", (Object) m2262do(((Cextends.Ccase.Cif) caseR).m1484do()));
            return jSONObject2;
        }
    }
}
