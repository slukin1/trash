package com.hbg.module.kline;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.SP;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class KLineHelper {

    /* renamed from: a  reason: collision with root package name */
    public static b f23488a;

    /* renamed from: b  reason: collision with root package name */
    public static List<a> f23489b = new ArrayList();

    public interface a {
        void a(LinkedHashSet<String> linkedHashSet);

        void b(int i11);
    }

    public interface b {
        void a(FragmentActivity fragmentActivity, View view, String str);
    }

    public static void a(a aVar) {
        f23489b.add(aVar);
    }

    public static int b(float f11, int i11) {
        return Color.argb((int) (f11 * 255.0f), Color.red(i11), Color.green(i11), Color.blue(i11));
    }

    public static int c(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    public static boolean d(String str, boolean z11) {
        return SP.l("SP_KEY_KLINE_TYPE" + str, z11);
    }

    public static b e() {
        return f23488a;
    }

    public static boolean f() {
        return SP.l("SP_KEY_THEME_LIGHT", false);
    }

    public static void g(int i11) {
        for (a next : f23489b) {
            if (next != null) {
                next.b(i11);
            }
        }
    }

    public static void h(LinkedHashSet<String> linkedHashSet) {
        for (a next : f23489b) {
            if (next != null) {
                next.a(linkedHashSet);
            }
        }
    }

    public static void i() {
        f23489b.clear();
    }

    public static void j(String str, boolean z11) {
        SP.y("SP_KEY_KLINE_TYPE" + str, z11);
    }

    public static void k() {
        SP.y("SP_KEY_KLINE_DRAW", true);
    }

    public static void l() {
        SP.y("SP_KEY_KLINE_LIGHT", true);
    }

    public static void m(b bVar) {
        f23488a = bVar;
    }

    public static void n(boolean z11) {
        SP.y("SP_KEY_THEME_LIGHT", z11);
        if (z11) {
            l();
        }
    }
}
