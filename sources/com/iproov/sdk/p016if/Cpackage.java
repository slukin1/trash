package com.iproov.sdk.p016if;

import com.iproov.sdk.core.exception.IProovException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.package  reason: invalid class name and invalid package */
public abstract class Cpackage {

    /* renamed from: com.iproov.sdk.if.package$do  reason: invalid class name */
    public static final class Cdo extends Cpackage {

        /* renamed from: do  reason: not valid java name */
        private final IProovException f703do;

        public Cdo(IProovException iProovException) {
            super((r) null);
            this.f703do = iProovException;
        }

        /* renamed from: do  reason: not valid java name */
        public final IProovException m791do() {
            return this.f703do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cdo) && x.b(this.f703do, ((Cdo) obj).f703do);
        }

        public int hashCode() {
            return this.f703do.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.f703do + ')';
        }
    }

    private Cpackage() {
    }

    public /* synthetic */ Cpackage(r rVar) {
        this();
    }
}
