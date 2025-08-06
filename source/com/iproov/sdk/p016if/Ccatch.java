package com.iproov.sdk.p016if;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.catch  reason: invalid class name and invalid package */
public abstract class Ccatch {

    /* renamed from: com.iproov.sdk.if.catch$do  reason: invalid class name */
    public static final class Cdo extends Ccatch {

        /* renamed from: do  reason: not valid java name */
        public static final Cdo f645do = new Cdo();

        private Cdo() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.catch$for  reason: invalid class name */
    public static final class Cfor extends Ccatch {

        /* renamed from: do  reason: not valid java name */
        public static final Cfor f646do = new Cfor();

        private Cfor() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.catch$if  reason: invalid class name */
    public static final class Cif extends Ccatch {

        /* renamed from: do  reason: not valid java name */
        private final Double f647do;

        public Cif(Double d11) {
            super((r) null);
            this.f647do = d11;
        }

        /* renamed from: do  reason: not valid java name */
        public final Double m719do() {
            return this.f647do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cif) && x.b(this.f647do, ((Cif) obj).f647do);
        }

        public int hashCode() {
            Double d11 = this.f647do;
            if (d11 == null) {
                return 0;
            }
            return d11.hashCode();
        }

        public String toString() {
            return "SetScreenBrightness(screenBrightness=" + this.f647do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.catch$new  reason: invalid class name */
    public static final class Cnew extends Ccatch {

        /* renamed from: do  reason: not valid java name */
        public static final Cnew f648do = new Cnew();

        private Cnew() {
            super((r) null);
        }
    }

    private Ccatch() {
    }

    public /* synthetic */ Ccatch(r rVar) {
        this();
    }
}
