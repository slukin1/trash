package com.iproov.sdk.p016if;

import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.p033throws.Cbreak;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.strictfp  reason: invalid class name and invalid package */
public abstract class Cstrictfp {

    /* renamed from: com.iproov.sdk.if.strictfp$case  reason: invalid class name */
    public static final class Ccase extends Cstrictfp {

        /* renamed from: do  reason: not valid java name */
        private final Cbreak f715do;

        public Ccase(Cbreak breakR) {
            super((r) null);
            this.f715do = breakR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cbreak m822do() {
            return this.f715do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ccase) && x.b(this.f715do, ((Ccase) obj).f715do);
        }

        public int hashCode() {
            return this.f715do.hashCode();
        }

        public String toString() {
            return "SendLuxData(luxData=" + this.f715do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.strictfp$do  reason: invalid class name */
    public static final class Cdo extends Cstrictfp {

        /* renamed from: do  reason: not valid java name */
        private final com.iproov.sdk.cameray.Cbreak f716do;

        /* renamed from: if  reason: not valid java name */
        private final int f717if;

        public Cdo(com.iproov.sdk.cameray.Cbreak breakR, int i11) {
            super((r) null);
            this.f716do = breakR;
            this.f717if = i11;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.cameray.Cbreak m823do() {
            return this.f716do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cdo)) {
                return false;
            }
            Cdo doVar = (Cdo) obj;
            return this.f716do == doVar.f716do && this.f717if == doVar.f717if;
        }

        public int hashCode() {
            return (this.f716do.hashCode() * 31) + this.f717if;
        }

        /* renamed from: if  reason: not valid java name */
        public final int m824if() {
            return this.f717if;
        }

        public String toString() {
            return "CameraSettings(lensFacing=" + this.f716do + ", orientation=" + this.f717if + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.strictfp$else  reason: invalid class name */
    public static final class Celse extends Cstrictfp {

        /* renamed from: do  reason: not valid java name */
        private final Cimplements f718do;

        public Celse(Cimplements implementsR) {
            super((r) null);
            this.f718do = implementsR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cimplements m825do() {
            return this.f718do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Celse) && x.b(this.f718do, ((Celse) obj).f718do);
        }

        public int hashCode() {
            return this.f718do.hashCode();
        }

        public String toString() {
            return "VideoFrame(videoData=" + this.f718do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.strictfp$for  reason: invalid class name */
    public static final class Cfor extends Cstrictfp {

        /* renamed from: do  reason: not valid java name */
        public static final Cfor f719do = new Cfor();

        private Cfor() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.strictfp$if  reason: invalid class name */
    public static final class Cif extends Cstrictfp {

        /* renamed from: do  reason: not valid java name */
        private final com.iproov.sdk.p035try.Cif f720do;

        public Cif(com.iproov.sdk.p035try.Cif ifVar) {
            super((r) null);
            this.f720do = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p035try.Cif m826do() {
            return this.f720do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cif) && x.b(this.f720do, ((Cif) obj).f720do);
        }

        public int hashCode() {
            return this.f720do.hashCode();
        }

        public String toString() {
            return "ClientStart(clientStartPacket=" + this.f720do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.strictfp$new  reason: invalid class name */
    public static final class Cnew extends Cstrictfp {

        /* renamed from: do  reason: not valid java name */
        private final IProovException f721do;

        public Cnew(IProovException iProovException) {
            super((r) null);
            this.f721do = iProovException;
        }

        /* renamed from: do  reason: not valid java name */
        public final IProovException m827do() {
            return this.f721do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cnew) && x.b(this.f721do, ((Cnew) obj).f721do);
        }

        public int hashCode() {
            return this.f721do.hashCode();
        }

        public String toString() {
            return "SendClaimAbort(cause=" + this.f721do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.strictfp$try  reason: invalid class name */
    public static final class Ctry extends Cstrictfp {

        /* renamed from: do  reason: not valid java name */
        private final com.iproov.sdk.Cif f722do;

        public Ctry(com.iproov.sdk.Cif ifVar) {
            super((r) null);
            this.f722do = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.Cif m828do() {
            return this.f722do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ctry) && this.f722do == ((Ctry) obj).f722do;
        }

        public int hashCode() {
            return this.f722do.hashCode();
        }

        public String toString() {
            return "SendClaimCancelled(canceller=" + this.f722do + ')';
        }
    }

    private Cstrictfp() {
    }

    public /* synthetic */ Cstrictfp(r rVar) {
        this();
    }
}
