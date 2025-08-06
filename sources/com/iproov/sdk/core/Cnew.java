package com.iproov.sdk.core;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import com.iproov.sdk.logging.IPLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* renamed from: com.iproov.sdk.core.new  reason: invalid class name */
public class Cnew {

    /* renamed from: do  reason: not valid java name */
    private final Cclass f327do;

    /* renamed from: for  reason: not valid java name */
    private Method f328for = null;

    /* renamed from: if  reason: not valid java name */
    private boolean f329if = false;

    /* renamed from: com.iproov.sdk.core.new$do  reason: invalid class name */
    public enum Cdo {
        AND15,
        AND16,
        AND17,
        AND18,
        AND19
    }

    public Cnew(Context context) {
        this.f327do = new Cclass(context);
        Cfinal.m389do();
        Cbreak.f229do.clear();
        m426if(Cdo.AND15);
        m425if(context, Cdo.AND16);
        m422do(context, Cdo.AND17);
        m423do(Cdo.AND18);
        m424for(Cdo.AND19);
    }

    /* renamed from: do  reason: not valid java name */
    private void m422do(Context context, Cdo doVar) {
        Cbreak.m310do(Ccatch.AND9);
        Cfinal.m392do(doVar, Boolean.valueOf((context.getApplicationContext().getApplicationInfo().flags & 2) != 0));
    }

    /* renamed from: for  reason: not valid java name */
    private void m424for(Cdo doVar) {
        if (NativeLibraryLoader.f228do) {
            try {
                Cthis.f351do = new NativeLibraryLoader().performance();
                Cbreak.m310do(Ccatch.AND13);
                int i11 = Cthis.f351do;
                boolean z11 = true;
                if (i11 != 1) {
                    if (i11 != 2) {
                        z11 = false;
                    }
                }
                Cfinal.m392do(doVar, Boolean.valueOf(z11));
            } catch (UnsatisfiedLinkError unused) {
                IPLog.w("NativeLib", "Not loaded");
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m426if(Cdo doVar) {
        Cbreak.m310do(Ccatch.AND11);
        Cfinal.m392do(doVar, Boolean.valueOf(this.f327do.m343this()));
    }

    /* renamed from: if  reason: not valid java name */
    private void m425if(Context context, Cdo doVar) {
        boolean z11;
        Settings.System.getString(context.getContentResolver(), "android_id");
        Cbreak.m310do(Ccatch.AND12);
        String str = Build.FINGERPRINT;
        if ((!str.startsWith(Ctry.r()) || !str.endsWith(Ctry.V()) || !Build.MANUFACTURER.equals(Ctry.o()) || !Build.PRODUCT.startsWith(Ctry.D()) || !Build.BRAND.equals(Ctry.p()) || !Build.MODEL.startsWith(Ctry.D())) && !str.startsWith(Ctry.k()) && !str.startsWith(Ctry.U())) {
            String str2 = Build.MODEL;
            if (!str2.contains(Ctry.q()) && !str2.contains(Ctry.h()) && !str2.contains(Ctry.m462for()) && !Build.MANUFACTURER.contains(Ctry.l()) && !Build.HOST.equals(Ctry.m485try()) && ((!Build.BRAND.startsWith(Ctry.k()) || !Build.DEVICE.startsWith(Ctry.k())) && !Build.PRODUCT.equals(Ctry.q()) && !m421do(Ctry.z(), "").equals("1") && !Ctry.m470new().equals(GLES20.glGetString(7937)))) {
                z11 = false;
                Cfinal.m392do(doVar, Boolean.valueOf(z11));
            }
        }
        z11 = true;
        Cfinal.m392do(doVar, Boolean.valueOf(z11));
    }

    /* renamed from: do  reason: not valid java name */
    private void m423do(Cdo doVar) {
        Cbreak.m310do(Ccatch.AND10);
        Cfinal.m392do(doVar, Boolean.valueOf(Debug.isDebuggerConnected()));
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Process, java.lang.Object, java.lang.reflect.Method] */
    /* renamed from: do  reason: not valid java name */
    private String m421do(String str, String str2) {
        Class cls = String.class;
        ? r42 = 0;
        if (!this.f329if) {
            try {
                if (this.f328for == null) {
                    this.f328for = Class.forName(Ctry.N()).getMethod(Ctry.m(), new Class[]{cls, cls});
                }
                String str3 = (String) this.f328for.invoke(r42, new Object[]{str, ""});
                return str3 == null ? str2 : str3;
            } catch (Exception unused) {
                this.f328for = r42;
                this.f329if = true;
            }
        }
        try {
            Process exec = Runtime.getRuntime().exec(String.format(Ctry.y(), new Object[]{str, str2}));
            String readLine = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine();
            exec.destroy();
            return readLine;
        } catch (IOException unused2) {
            if (r42 != 0) {
                r42.destroy();
            }
            return str2;
        } catch (Throwable th2) {
            if (r42 != 0) {
                r42.destroy();
            }
            throw th2;
        }
    }
}
