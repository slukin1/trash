package com.iproov.sdk.p016if;

import com.iproov.sdk.p021new.Cthis;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.static  reason: invalid class name and invalid package */
public abstract class Cstatic {

    /* renamed from: com.iproov.sdk.if.static$do  reason: invalid class name */
    public static final class Cdo extends Cstatic {

        /* renamed from: do  reason: not valid java name */
        private final boolean f712do;

        public Cdo(boolean z11) {
            super((r) null);
            this.f712do = z11;
        }

        /* renamed from: do  reason: not valid java name */
        public final boolean m819do() {
            return this.f712do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cdo) && this.f712do == ((Cdo) obj).f712do;
        }

        public int hashCode() {
            boolean z11 = this.f712do;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "ExposureLockChanged(isLocked=" + this.f712do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.static$for  reason: invalid class name */
    public static final class Cfor extends Cstatic {

        /* renamed from: do  reason: not valid java name */
        private final float f713do;

        public Cfor(float f11) {
            super((r) null);
            this.f713do = f11;
        }

        /* renamed from: do  reason: not valid java name */
        public final float m820do() {
            return this.f713do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cfor) && x.b(Float.valueOf(this.f713do), Float.valueOf(((Cfor) obj).f713do));
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f713do);
        }

        public String toString() {
            return "SetFocalLength(focalLength=" + this.f713do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.static$if  reason: invalid class name */
    public static final class Cif extends Cstatic {

        /* renamed from: do  reason: not valid java name */
        private final Cthis f714do;

        public Cif(Cthis thisR) {
            super((r) null);
            this.f714do = thisR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cthis m821do() {
            return this.f714do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cif) && x.b(this.f714do, ((Cif) obj).f714do);
        }

        public int hashCode() {
            return this.f714do.hashCode();
        }

        public String toString() {
            return "SetExifData(exifData=" + this.f714do + ')';
        }
    }

    private Cstatic() {
    }

    public /* synthetic */ Cstatic(r rVar) {
        this();
    }
}
