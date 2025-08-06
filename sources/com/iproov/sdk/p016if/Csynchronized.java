package com.iproov.sdk.p016if;

import com.iproov.sdk.core.exception.IProovException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.synchronized  reason: invalid class name and invalid package */
public abstract class Csynchronized {

    /* renamed from: com.iproov.sdk.if.synchronized$do  reason: invalid class name */
    public static final class Cdo extends Csynchronized {

        /* renamed from: do  reason: not valid java name */
        private final IProovException f725do;

        public Cdo(IProovException iProovException) {
            super((r) null);
            this.f725do = iProovException;
        }

        /* renamed from: do  reason: not valid java name */
        public final IProovException m836do() {
            return this.f725do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cdo) && x.b(this.f725do, ((Cdo) obj).f725do);
        }

        public int hashCode() {
            return this.f725do.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.f725do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.synchronized$for  reason: invalid class name */
    public static final class Cfor extends Csynchronized {

        /* renamed from: do  reason: not valid java name */
        public static final Cfor f726do = new Cfor();

        private Cfor() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.synchronized$if  reason: invalid class name */
    public static final class Cif extends Csynchronized {

        /* renamed from: do  reason: not valid java name */
        public static final Cif f727do = new Cif();

        private Cif() {
            super((r) null);
        }
    }

    private Csynchronized() {
    }

    public /* synthetic */ Csynchronized(r rVar) {
        this();
    }
}
