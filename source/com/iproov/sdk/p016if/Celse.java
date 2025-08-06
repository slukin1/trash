package com.iproov.sdk.p016if;

import com.iproov.sdk.p021new.Cfor;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.else  reason: invalid class name and invalid package */
public abstract class Celse {

    /* renamed from: com.iproov.sdk.if.else$do  reason: invalid class name */
    public static final class Cdo extends Celse {

        /* renamed from: do  reason: not valid java name */
        private final Cfor f656do;

        /* renamed from: for  reason: not valid java name */
        private final int f657for;

        /* renamed from: if  reason: not valid java name */
        private final boolean f658if;

        public Cdo(Cfor forR, boolean z11, int i11) {
            super((r) null);
            this.f656do = forR;
            this.f658if = z11;
            this.f657for = i11;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cfor m763do() {
            return this.f656do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cdo)) {
                return false;
            }
            Cdo doVar = (Cdo) obj;
            return x.b(this.f656do, doVar.f656do) && this.f658if == doVar.f658if && this.f657for == doVar.f657for;
        }

        /* renamed from: for  reason: not valid java name */
        public final boolean m764for() {
            return this.f658if;
        }

        public int hashCode() {
            int hashCode = this.f656do.hashCode() * 31;
            boolean z11 = this.f658if;
            if (z11) {
                z11 = true;
            }
            return ((hashCode + (z11 ? 1 : 0)) * 31) + this.f657for;
        }

        /* renamed from: if  reason: not valid java name */
        public final int m765if() {
            return this.f657for;
        }

        public String toString() {
            return "SendFrame(cameraFrame=" + this.f656do + ", isSupplementary=" + this.f658if + ", frameCount=" + this.f657for + ')';
        }
    }

    private Celse() {
    }

    public /* synthetic */ Celse(r rVar) {
        this();
    }
}
