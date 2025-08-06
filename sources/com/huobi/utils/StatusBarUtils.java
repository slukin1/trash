package com.huobi.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;

public class StatusBarUtils {

    /* renamed from: a  reason: collision with root package name */
    public static float f83704a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    public static int f83705b = -1;

    public static int a(Context context) {
        if (f83705b == -1) {
            b(context);
        }
        return f83705b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.reflect.Field} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r5) {
        /*
            r0 = 0
            java.lang.String r1 = "com.android.internal.R$dimen"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x002b }
            java.lang.Object r2 = r1.newInstance()     // Catch:{ all -> 0x002b }
            boolean r3 = com.huobi.utils.DeviceHelper.f()     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x001c
            java.lang.String r3 = "status_bar_height_large"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ all -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0025 }
        L_0x001c:
            if (r0 != 0) goto L_0x0033
            java.lang.String r3 = "status_bar_height"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ all -> 0x0025 }
            goto L_0x0033
        L_0x0025:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r2
            r2 = r4
            goto L_0x002e
        L_0x002b:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002e:
            r2.printStackTrace()
            r2 = r0
            r0 = r1
        L_0x0033:
            if (r0 == 0) goto L_0x0052
            if (r2 == 0) goto L_0x0052
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004e }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x004e }
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ all -> 0x004e }
            int r0 = r1.getDimensionPixelSize(r0)     // Catch:{ all -> 0x004e }
            f83705b = r0     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0052:
            boolean r5 = com.huobi.utils.DeviceHelper.h(r5)
            r0 = 1103626240(0x41c80000, float:25.0)
            if (r5 == 0) goto L_0x0066
            int r5 = f83705b
            int r1 = com.hbg.lib.common.utils.PixelUtils.a(r0)
            if (r5 <= r1) goto L_0x0066
            r5 = 0
            f83705b = r5
            goto L_0x0080
        L_0x0066:
            int r5 = f83705b
            if (r5 > 0) goto L_0x0080
            float r5 = f83704a
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0079
            int r5 = com.hbg.lib.common.utils.PixelUtils.a(r0)
            f83705b = r5
            goto L_0x0080
        L_0x0079:
            float r5 = r5 * r0
            r0 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 + r0
            int r5 = (int) r5
            f83705b = r5
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.utils.StatusBarUtils.b(android.content.Context):void");
    }

    public static boolean c() {
        return !DeviceHelper.j() && !DeviceHelper.i();
    }

    public static boolean d() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 >= 19 && (!DeviceHelper.c() || i11 >= 26);
    }

    public static void e(Activity activity, int i11) {
        f(activity.getWindow(), i11);
    }

    @TargetApi(19)
    public static void f(Window window, int i11) {
        if (d()) {
            if (DeviceHelper.f() || (DeviceHelper.e() && Build.VERSION.SDK_INT < 23)) {
                window.setFlags(67108864, 67108864);
                return;
            }
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 21) {
                window.getDecorView().setSystemUiVisibility(1280);
                if (i12 < 23 || !c()) {
                    window.clearFlags(67108864);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(i11);
                    return;
                }
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
        }
    }

    public static void g(Activity activity, int i11) {
        h(activity.getWindow(), i11);
    }

    @TargetApi(19)
    public static void h(Window window, int i11) {
        if (d()) {
            if (DeviceHelper.f() || (DeviceHelper.e() && Build.VERSION.SDK_INT < 23)) {
                window.setFlags(67108864, 67108864);
            } else if (Build.VERSION.SDK_INT >= 21) {
                window.getDecorView().setSystemUiVisibility(1280);
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(i11);
            }
        }
    }
}
