package com.qihoo.stat;

import java.util.Vector;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static Vector f28840a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f28841b = false;

    public static void a() {
        if (f28840a != null) {
            int i11 = 0;
            while (i11 < f28840a.size()) {
                if (1 != ((o) f28840a.get(i11)).f28825d) {
                    f28840a.remove(i11);
                    i11--;
                }
                i11++;
            }
            if (f28840a.size() == 0) {
                f28840a.clear();
                f28840a = null;
            }
        }
        f28841b = false;
    }
}
