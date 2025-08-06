package com.iproov.sdk.p016if;

import com.iproov.sdk.core.exception.IProovException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.goto  reason: invalid class name and invalid package */
public abstract class Cgoto {

    /* renamed from: com.iproov.sdk.if.goto$do  reason: invalid class name */
    public static final class Cdo extends Cgoto {

        /* renamed from: do  reason: not valid java name */
        private final IProovException f673do;

        public Cdo(IProovException iProovException) {
            super((r) null);
            this.f673do = iProovException;
        }

        /* renamed from: do  reason: not valid java name */
        public final IProovException m771do() {
            return this.f673do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cdo) && x.b(this.f673do, ((Cdo) obj).f673do);
        }

        public int hashCode() {
            return this.f673do.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.f673do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.goto$for  reason: invalid class name */
    public static final class Cfor extends Cgoto {

        /* renamed from: do  reason: not valid java name */
        public static final Cfor f674do = new Cfor();

        private Cfor() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.goto$if  reason: invalid class name */
    public static final class Cif extends Cgoto {

        /* renamed from: do  reason: not valid java name */
        public static final Cif f675do = new Cif();

        private Cif() {
            super((r) null);
        }
    }

    private Cgoto() {
    }

    public /* synthetic */ Cgoto(r rVar) {
        this();
    }
}
