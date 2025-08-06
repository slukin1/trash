package com.iproov.sdk.p016if;

import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.p017implements.Cfinal;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.volatile  reason: invalid class name and invalid package */
public abstract class Cvolatile {

    /* renamed from: com.iproov.sdk.if.volatile$case  reason: invalid class name */
    public static final class Ccase extends Cvolatile {

        /* renamed from: do  reason: not valid java name */
        private final com.iproov.sdk.p003case.Cif f732do;

        public Ccase(com.iproov.sdk.p003case.Cif ifVar) {
            super((r) null);
            this.f732do = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p003case.Cif m844do() {
            return this.f732do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ccase) && x.b(this.f732do, ((Ccase) obj).f732do);
        }

        public int hashCode() {
            return this.f732do.hashCode();
        }

        public String toString() {
            return Cvolatile.super.toString() + ' ' + Cfinal.m1002do(this.f732do);
        }
    }

    /* renamed from: com.iproov.sdk.if.volatile$do  reason: invalid class name */
    public static final class Cdo extends Cvolatile {

        /* renamed from: do  reason: not valid java name */
        public static final Cdo f733do = new Cdo();

        private Cdo() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.volatile$else  reason: invalid class name */
    public static final class Celse extends Cvolatile {

        /* renamed from: do  reason: not valid java name */
        private final com.iproov.sdk.p035try.Cdo f734do;

        public Celse(com.iproov.sdk.p035try.Cdo doVar) {
            super((r) null);
            this.f734do = doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p035try.Cdo m845do() {
            return this.f734do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Celse) && x.b(this.f734do, ((Celse) obj).f734do);
        }

        public int hashCode() {
            return this.f734do.hashCode();
        }

        public String toString() {
            return Cvolatile.super.toString() + ' ' + Cfinal.m1003do(this.f734do);
        }
    }

    /* renamed from: com.iproov.sdk.if.volatile$for  reason: invalid class name */
    public static final class Cfor extends Cvolatile {

        /* renamed from: do  reason: not valid java name */
        public static final Cfor f735do = new Cfor();

        private Cfor() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.volatile$goto  reason: invalid class name */
    public static final class Cgoto extends Cvolatile {

        /* renamed from: do  reason: not valid java name */
        private final double f736do;

        public Cgoto(double d11) {
            super((r) null);
            this.f736do = d11;
        }

        /* renamed from: do  reason: not valid java name */
        public final double m846do() {
            return this.f736do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cgoto) && x.b(Double.valueOf(this.f736do), Double.valueOf(((Cgoto) obj).f736do));
        }

        public int hashCode() {
            return Double.doubleToLongBits(this.f736do);
        }

        public String toString() {
            return Cvolatile.super.toString() + ' ' + com.iproov.sdk.p009do.Cdo.m564do(this.f736do);
        }
    }

    /* renamed from: com.iproov.sdk.if.volatile$if  reason: invalid class name */
    public static final class Cif extends Cvolatile {

        /* renamed from: do  reason: not valid java name */
        public static final Cif f737do = new Cif();

        private Cif() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.volatile$new  reason: invalid class name */
    public static final class Cnew extends Cvolatile {

        /* renamed from: do  reason: not valid java name */
        public static final Cnew f738do = new Cnew();

        private Cnew() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.volatile$try  reason: invalid class name */
    public static final class Ctry extends Cvolatile {

        /* renamed from: do  reason: not valid java name */
        private final IProovException f739do;

        public Ctry(IProovException iProovException) {
            super((r) null);
            this.f739do = iProovException;
        }

        /* renamed from: do  reason: not valid java name */
        public final IProovException m847do() {
            return this.f739do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ctry) && x.b(this.f739do, ((Ctry) obj).f739do);
        }

        public int hashCode() {
            return this.f739do.hashCode();
        }

        public String toString() {
            return Cvolatile.super.toString() + ' ' + com.iproov.sdk.p009do.Cdo.m565do(this.f739do);
        }
    }

    private Cvolatile() {
    }

    public /* synthetic */ Cvolatile(r rVar) {
        this();
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
