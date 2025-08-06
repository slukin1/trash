package com.iproov.sdk.p019interface;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.iproov.sdk.interface.if  reason: invalid class name and invalid package */
public class Cif {

    /* renamed from: if  reason: not valid java name */
    private static final int[] f1002if = {73, 80, 114, 111, 111, 118, 73, 110, 116, 101, 114, 110, 97, 108};

    /* renamed from: do  reason: not valid java name */
    private final SharedPreferences f1003do;

    public Cif(Context context) {
        this.f1003do = context.getSharedPreferences(m1098do(), 0);
    }

    /* renamed from: break  reason: not valid java name */
    public boolean m1101break() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getBoolean(m1098do() + "_hasNotDeletedKey", true);
    }

    /* renamed from: case  reason: not valid java name */
    public int m1103case(int i11) {
        SharedPreferences sharedPreferences = this.f1003do;
        return (int) m1097do(sharedPreferences, m1098do() + "_minMillisDebounce", (float) i11);
    }

    /* renamed from: catch  reason: not valid java name */
    public boolean m1105catch() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getBoolean(m1098do() + "_debugEnabled", false);
    }

    /* renamed from: class  reason: not valid java name */
    public void m1106class() {
        SharedPreferences.Editor edit = this.f1003do.edit();
        edit.putBoolean(m1098do() + "_hasNotDeletedKey", false).apply();
    }

    /* renamed from: const  reason: not valid java name */
    public boolean m1107const() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getBoolean(m1098do() + "_startFlashingAutomatically", false);
    }

    /* renamed from: do  reason: not valid java name */
    public double[] m1111do(double[] dArr) {
        return m1099do(this.f1003do, "wgv", dArr);
    }

    /* renamed from: else  reason: not valid java name */
    public String m1113else() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getString(m1098do() + "_tooBrightExpression", (String) null);
    }

    /* renamed from: for  reason: not valid java name */
    public String m1116for() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getString(m1098do() + "_estimatedBrightnessExpression", (String) null);
    }

    /* renamed from: goto  reason: not valid java name */
    public String m1118goto() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getString(m1098do() + "_tooCloseExpression", (String) null);
    }

    /* renamed from: if  reason: not valid java name */
    public String m1121if() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getString(m1098do() + "_cluxExpression", (String) null);
    }

    /* renamed from: new  reason: not valid java name */
    public int m1123new(int i11) {
        SharedPreferences sharedPreferences = this.f1003do;
        return (int) m1097do(sharedPreferences, m1098do() + "_maxMillisDebounce", (float) i11);
    }

    /* renamed from: this  reason: not valid java name */
    public String m1126this() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getString(m1098do() + "_tooFarExpression", (String) null);
    }

    /* renamed from: try  reason: not valid java name */
    public String m1129try() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getString(m1098do() + "_shouldLockAndPhotoExpression", (String) null);
    }

    /* renamed from: break  reason: not valid java name */
    public float m1100break(float f11) {
        return m1097do(this.f1003do, "vps", f11);
    }

    /* renamed from: case  reason: not valid java name */
    public String m1104case() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getString(m1098do() + "_shouldUnlockAndPhotoExpression", (String) null);
    }

    /* renamed from: do  reason: not valid java name */
    public float m1108do(float f11) {
        return m1097do(this.f1003do, "crs", f11);
    }

    /* renamed from: else  reason: not valid java name */
    public float m1112else(float f11) {
        return m1097do(this.f1003do, "mlt", f11);
    }

    /* renamed from: for  reason: not valid java name */
    public float m1114for(float f11) {
        return m1097do(this.f1003do, "fsr", f11);
    }

    /* renamed from: goto  reason: not valid java name */
    public float m1117goto(float f11) {
        return m1097do(this.f1003do, "lui", f11);
    }

    /* renamed from: if  reason: not valid java name */
    public int m1120if(int i11) {
        return (int) m1097do(this.f1003do, "frc", (float) i11);
    }

    /* renamed from: new  reason: not valid java name */
    public String m1124new() {
        SharedPreferences sharedPreferences = this.f1003do;
        return sharedPreferences.getString(m1098do() + "_screenBrightnessExpression", (String) null);
    }

    /* renamed from: this  reason: not valid java name */
    public float m1125this(float f11) {
        return m1097do(this.f1003do, "set", f11);
    }

    /* renamed from: try  reason: not valid java name */
    public int m1128try(int i11) {
        return (int) m1097do(this.f1003do, "mmx", (float) i11);
    }

    /* renamed from: case  reason: not valid java name */
    public float m1102case(float f11) {
        return m1097do(this.f1003do, "fdt", f11);
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m1110do(boolean z11) {
        return this.f1003do.getBoolean("elp", z11);
    }

    /* renamed from: for  reason: not valid java name */
    public int m1115for(int i11) {
        return (int) m1097do(this.f1003do, "frw", (float) i11);
    }

    /* renamed from: if  reason: not valid java name */
    public float m1119if(float f11) {
        return m1097do(this.f1003do, "fof", f11);
    }

    /* renamed from: new  reason: not valid java name */
    public float m1122new(float f11) {
        return m1097do(this.f1003do, "lft", f11);
    }

    /* renamed from: try  reason: not valid java name */
    public float m1127try(float f11) {
        return m1097do(this.f1003do, "mst", f11);
    }

    /* renamed from: do  reason: not valid java name */
    public int m1109do(int i11) {
        return (int) m1097do(this.f1003do, "dop", (float) i11);
    }

    /* renamed from: do  reason: not valid java name */
    private static String m1098do() {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 : f1002if) {
            sb2.append((char) i11);
        }
        return sb2.toString();
    }

    /* renamed from: do  reason: not valid java name */
    private static float m1097do(SharedPreferences sharedPreferences, String str, float f11) {
        String string = sharedPreferences.getString(str, (String) null);
        if (string == null) {
            return f11;
        }
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException unused) {
            return f11;
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static double[] m1099do(SharedPreferences sharedPreferences, String str, double[] dArr) {
        String string = sharedPreferences.getString(str, (String) null);
        if (string == null) {
            return dArr;
        }
        String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length != 3) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        int i11 = 0;
        while (i11 < 3) {
            try {
                dArr2[i11] = Double.parseDouble(split[i11]);
                i11++;
            } catch (NumberFormatException unused) {
                return dArr;
            }
        }
        return dArr2;
    }
}
