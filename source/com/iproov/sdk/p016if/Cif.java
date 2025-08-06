package com.iproov.sdk.p016if;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.if  reason: invalid class name and invalid package */
public abstract class Cif {

    /* renamed from: com.iproov.sdk.if.if$do  reason: invalid class name */
    public static final class Cdo extends Cif {

        /* renamed from: do  reason: not valid java name */
        public static final Cdo f676do = new Cdo();

        private Cdo() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.if$for  reason: invalid class name */
    public static final class Cfor extends Cif {

        /* renamed from: do  reason: not valid java name */
        private final boolean f677do;

        public Cfor(boolean z11) {
            super((r) null);
            this.f677do = z11;
        }

        /* renamed from: do  reason: not valid java name */
        public final boolean m772do() {
            return this.f677do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cfor) && this.f677do == ((Cfor) obj).f677do;
        }

        public int hashCode() {
            boolean z11 = this.f677do;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "SetExposureLocked(locked=" + this.f677do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.if$if  reason: invalid class name */
    public static final class Cif extends Cif {

        /* renamed from: do  reason: not valid java name */
        private final Throwable f678do;

        public Cif(Throwable th2) {
            super((r) null);
            this.f678do = th2;
        }

        /* renamed from: do  reason: not valid java name */
        public final Throwable m773do() {
            return this.f678do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cif) && x.b(this.f678do, ((Cif) obj).f678do);
        }

        public int hashCode() {
            return this.f678do.hashCode();
        }

        public String toString() {
            return "LightingModelError(throwable=" + this.f678do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.if$new  reason: invalid class name */
    public static final class Cnew extends Cif {

        /* renamed from: do  reason: not valid java name */
        public static final Cnew f679do = new Cnew();

        private Cnew() {
            super((r) null);
        }
    }

    private Cif() {
    }

    public /* synthetic */ Cif(r rVar) {
        this();
    }
}
