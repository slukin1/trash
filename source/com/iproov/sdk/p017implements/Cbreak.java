package com.iproov.sdk.p017implements;

import com.iproov.sdk.p020native.Cif;
import kotlin.Unit;
import kotlin.jvm.internal.r;

/* renamed from: com.iproov.sdk.implements.break  reason: invalid class name and invalid package */
public final class Cbreak {

    /* renamed from: do  reason: not valid java name */
    private final int f909do;

    /* renamed from: for  reason: not valid java name */
    private final Cif f910for;

    /* renamed from: if  reason: not valid java name */
    private final int f911if;

    /* renamed from: new  reason: not valid java name */
    private long f912new;

    /* renamed from: try  reason: not valid java name */
    private final int f913try;

    /* renamed from: com.iproov.sdk.implements.break$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }
    }

    static {
        new Cdo((r) null);
    }

    public Cbreak(int i11, int i12) {
        this.f909do = i11;
        this.f911if = i12;
        Cif ifVar = new Cif();
        ifVar.m1151goto();
        Unit unit = Unit.f56620a;
        this.f910for = ifVar;
        this.f913try = i12 - i11;
    }

    /* renamed from: do  reason: not valid java name */
    public final boolean m976do(boolean z11) {
        int i11 = this.f909do;
        if (i11 > 0 && this.f911if >= i11) {
            this.f910for.m1147case();
            if (!z11) {
                this.f912new = 0;
            } else if (this.f912new > 0) {
                if (System.currentTimeMillis() - this.f912new > ((long) m975do())) {
                    return false;
                }
                return true;
            } else {
                this.f912new = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    /* renamed from: do  reason: not valid java name */
    private final int m975do() {
        double d11 = this.f910for.m1152if().m1040do();
        if (d11 <= 6.0d) {
            return this.f911if;
        }
        if (d11 >= 25.0d) {
            return this.f909do;
        }
        return (int) (((double) this.f909do) + (((double) this.f913try) * (((double) 1) - ((d11 - ((double) 6)) / ((double) 19)))));
    }
}
