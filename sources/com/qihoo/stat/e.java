package com.qihoo.stat;

public class e extends Thread {
    public void run() {
        boolean z11;
        try {
            d.f28717i = "";
            d.f28718j = "";
            new q(this).start();
            boolean z12 = true;
            int i11 = 1;
            while (true) {
                if (u.V(d.f28719k) == 100) {
                    d.f28717i = u.m(d.f28719k);
                    z11 = true;
                } else {
                    d.f28717i = "";
                    z11 = false;
                }
                if (z11) {
                    d.l(d.f28719k);
                    if (!d.f28717i.equals(d.f28718j)) {
                        d.f28714f.b(d.f28717i);
                        d.f28714f.d(d.f28718j);
                    }
                }
                Thread.sleep(1000);
                if (z11 && (i11 = i11 + 1) > 5) {
                    c0.d(d.f28719k, false);
                    i11 = 1;
                }
                if (!z11 && z12) {
                    d.g(d.f28719k, true, 1000);
                }
                d.f28718j = d.f28717i;
                z12 = z11;
            }
        } catch (Exception e11) {
            g0.b(d.f28709a, e11);
        } catch (Error e12) {
            g0.a(d.f28709a, e12);
        }
    }
}
