package com.iproov.sdk.p033throws;

import android.content.Context;
import com.iproov.sdk.p019interface.Cif;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.throws.else  reason: invalid class name and invalid package */
public class Celse {

    /* renamed from: case  reason: not valid java name */
    private String f2062case = "(s<0) || (p > 5) || (abs(h(0.5)-ho(0.5))>0.3 && p > 2)";

    /* renamed from: do  reason: not valid java name */
    private String f2063do = "s > 0.9";

    /* renamed from: else  reason: not valid java name */
    private String f2064else = "p > 4";

    /* renamed from: for  reason: not valid java name */
    private String f2065for = "(i*A)<(400*(v+4)*(11-s)^2)";

    /* renamed from: goto  reason: not valid java name */
    private String f2066goto = "(3*n^2)/(t*i)";

    /* renamed from: if  reason: not valid java name */
    private String f2067if = "s < 0.55";

    /* renamed from: new  reason: not valid java name */
    private String f2068new = "clamp(0.5*(c*h(0.75)^2),0.95,1)";

    /* renamed from: try  reason: not valid java name */
    private String f2069try = "vo*(1+(min(abs(h(0.5)-ho(0.5)),0.6)))";

    private Celse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f2063do = m1948do(str, "s > 0.9", str8);
        this.f2067if = m1948do(str2, this.f2067if, str8);
        this.f2065for = m1948do(str3, this.f2065for, str8);
        this.f2068new = m1948do(str4, this.f2068new, str8);
        this.f2069try = m1948do(str5, this.f2069try, str8);
        this.f2062case = m1948do(str6, this.f2062case, str8);
        this.f2064else = m1948do(str7, this.f2064else, str8);
        this.f2066goto = m1948do(str8, this.f2066goto, str8);
    }

    /* renamed from: do  reason: not valid java name */
    public static Celse m1946do(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Cif ifVar = new Cif(context);
        String str = ifVar.m1118goto();
        String str2 = ifVar.m1113else();
        String str3 = ifVar.m1126this();
        String str4 = ifVar.m1124new();
        String str5 = ifVar.m1116for();
        String str6 = ifVar.m1104case();
        String str7 = ifVar.m1129try();
        String str8 = ifVar.m1121if();
        if (str == null) {
            str = com.iproov.sdk.utils.Cif.m2277if(jSONObject2, "tc");
        }
        String str9 = str;
        if (str3 == null) {
            str3 = com.iproov.sdk.utils.Cif.m2277if(jSONObject2, "tf");
        }
        String str10 = str3;
        if (str2 == null) {
            str2 = com.iproov.sdk.utils.Cif.m2277if(jSONObject2, TtmlNode.VERTICAL);
        }
        String str11 = str2;
        if (str4 == null) {
            str4 = com.iproov.sdk.utils.Cif.m2277if(jSONObject2, "sd");
        }
        String str12 = str4;
        if (str5 == null) {
            str5 = com.iproov.sdk.utils.Cif.m2277if(jSONObject2, "ev");
        }
        String str13 = str5;
        if (str6 == null) {
            str6 = com.iproov.sdk.utils.Cif.m2277if(jSONObject2, "su");
        }
        String str14 = str6;
        if (str7 == null) {
            str7 = com.iproov.sdk.utils.Cif.m2277if(jSONObject2, "sl");
        }
        String str15 = str7;
        if (str8 == null) {
            str8 = com.iproov.sdk.utils.Cif.m2277if(jSONObject2, "cl");
        }
        return new Celse(str9, str10, str11, str12, str13, str14, str15, str8);
    }

    /* renamed from: do  reason: not valid java name */
    private String m1948do(String str, String str2, String str3) {
        return (str == null || str3 == null) ? str2 : str;
    }

    /* renamed from: break  reason: not valid java name */
    public String m1949break() {
        return this.f2067if;
    }

    /* renamed from: case  reason: not valid java name */
    public String m1950case() {
        return this.f2064else;
    }

    /* renamed from: catch  reason: not valid java name */
    public String m1951catch() {
        return m1947do(this.f2068new);
    }

    /* renamed from: class  reason: not valid java name */
    public String m1952class() {
        return m1947do(this.f2064else);
    }

    /* renamed from: const  reason: not valid java name */
    public String m1953const() {
        return m1947do(this.f2062case);
    }

    /* renamed from: else  reason: not valid java name */
    public String m1955else() {
        return this.f2062case;
    }

    /* renamed from: final  reason: not valid java name */
    public String m1956final() {
        return m1947do(this.f2065for);
    }

    /* renamed from: for  reason: not valid java name */
    public String m1957for() {
        return this.f2066goto;
    }

    /* renamed from: goto  reason: not valid java name */
    public String m1958goto() {
        return this.f2065for;
    }

    /* renamed from: if  reason: not valid java name */
    public String m1959if() {
        return m1947do(this.f2069try);
    }

    /* renamed from: new  reason: not valid java name */
    public String m1960new() {
        return this.f2069try;
    }

    /* renamed from: super  reason: not valid java name */
    public String m1961super() {
        return m1947do(this.f2063do);
    }

    /* renamed from: this  reason: not valid java name */
    public String m1962this() {
        return this.f2063do;
    }

    /* renamed from: throw  reason: not valid java name */
    public String m1963throw() {
        return m1947do(this.f2067if);
    }

    public String toString() {
        return "LightingModelParameters{tooCloseExpression='" + m1961super() + '\'' + ", tooFarExpression='" + m1963throw() + '\'' + ", tooBrightExpression='" + m1956final() + '\'' + ", screenBrightnessExpression='" + m1951catch() + '\'' + ", estimatedBrightnessExpression='" + m1959if() + '\'' + ", shouldUnlockAndPhotoExpression='" + m1953const() + '\'' + ", shouldLockAndPhotoExpression='" + m1952class() + '\'' + ", cluxExpression='" + m1954do() + '\'' + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public String m1964try() {
        return this.f2068new;
    }

    /* renamed from: do  reason: not valid java name */
    private static String m1947do(String str) {
        return str.replace("&&", String.valueOf('&')).replace("||", String.valueOf('|')).replace("<=", String.valueOf(8364)).replace(">=", String.valueOf(163));
    }

    /* renamed from: do  reason: not valid java name */
    public String m1954do() {
        return m1947do(this.f2066goto);
    }
}
