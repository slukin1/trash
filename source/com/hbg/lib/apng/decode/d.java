package com.hbg.lib.apng.decode;

import android.text.TextUtils;
import java.io.IOException;
import z5.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f66186a;

    /* renamed from: b  reason: collision with root package name */
    public int f66187b;

    /* renamed from: c  reason: collision with root package name */
    public int f66188c;

    /* renamed from: d  reason: collision with root package name */
    public int f66189d;

    public static int a(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    public void b(a aVar) throws IOException {
    }

    public void c(a aVar) throws IOException {
        int available = aVar.available();
        b(aVar);
        int available2 = available - aVar.available();
        int i11 = this.f66186a;
        if (available2 > i11) {
            throw new IOException("Out of chunk area");
        } else if (available2 < i11) {
            aVar.skip((long) (i11 - available2));
        }
    }
}
