package com.qihoo.stat;

import java.util.Vector;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public static Vector f28721a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f28722b = false;

    public static void a() {
        if (f28721a != null) {
            int i11 = 0;
            while (i11 < f28721a.size()) {
                if (!"begin".equals(((i) f28721a.get(i11)).f28774c)) {
                    f28721a.remove(i11);
                    i11--;
                }
                i11++;
            }
            if (f28721a.size() == 0) {
                f28721a.clear();
                f28721a = null;
            }
        }
        f28722b = false;
    }
}
