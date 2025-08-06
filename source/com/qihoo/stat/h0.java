package com.qihoo.stat;

import java.util.Vector;

public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static Vector f28769a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f28770b = false;

    public static void a() {
        if (f28769a != null) {
            int i11 = 0;
            while (i11 < f28769a.size()) {
                if (1 != ((k) f28769a.get(i11)).f28792e) {
                    f28769a.remove(i11);
                    i11--;
                }
                i11++;
            }
            if (f28769a.size() == 0) {
                f28769a.clear();
                f28769a = null;
            }
        }
        f28770b = false;
    }
}
