package com.iproov.sdk.p016if;

import android.graphics.Rect;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.import  reason: invalid class name and invalid package */
public abstract class Cimport {

    /* renamed from: com.iproov.sdk.if.import$case  reason: invalid class name */
    public static final class Ccase extends Cimport {

        /* renamed from: do  reason: not valid java name */
        public static final Ccase f688do = new Ccase();

        private Ccase() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.import$do  reason: invalid class name */
    public static final class Cdo extends Cimport {

        /* renamed from: do  reason: not valid java name */
        public static final Cdo f689do = new Cdo();

        private Cdo() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.import$for  reason: invalid class name */
    public static final class Cfor extends Cimport {

        /* renamed from: do  reason: not valid java name */
        public static final Cfor f690do = new Cfor();

        private Cfor() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.import$if  reason: invalid class name */
    public static final class Cif extends Cimport {

        /* renamed from: do  reason: not valid java name */
        private final boolean f691do;

        public Cif(boolean z11) {
            super((r) null);
            this.f691do = z11;
        }

        /* renamed from: do  reason: not valid java name */
        public final boolean m782do() {
            return this.f691do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cif) && this.f691do == ((Cif) obj).f691do;
        }

        public int hashCode() {
            boolean z11 = this.f691do;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "DidRequestLivenessFrame(isFinal=" + this.f691do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.import$new  reason: invalid class name */
    public static final class Cnew extends Cimport {

        /* renamed from: do  reason: not valid java name */
        public static final Cnew f692do = new Cnew();

        private Cnew() {
            super((r) null);
        }
    }

    /* renamed from: com.iproov.sdk.if.import$try  reason: invalid class name */
    public static final class Ctry extends Cimport {

        /* renamed from: do  reason: not valid java name */
        private final Rect f693do;

        /* renamed from: for  reason: not valid java name */
        private final Rect f694for;

        /* renamed from: if  reason: not valid java name */
        private final Rect f695if;

        /* renamed from: new  reason: not valid java name */
        private final Rect f696new;

        public Ctry(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            super((r) null);
            this.f693do = rect;
            this.f695if = rect2;
            this.f694for = rect3;
            this.f696new = rect4;
        }

        /* renamed from: do  reason: not valid java name */
        public final Rect m783do() {
            return this.f694for;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ctry)) {
                return false;
            }
            Ctry tryR = (Ctry) obj;
            return x.b(this.f693do, tryR.f693do) && x.b(this.f695if, tryR.f695if) && x.b(this.f694for, tryR.f694for) && x.b(this.f696new, tryR.f696new);
        }

        /* renamed from: for  reason: not valid java name */
        public final Rect m784for() {
            return this.f695if;
        }

        public int hashCode() {
            Rect rect = this.f693do;
            int i11 = 0;
            int hashCode = (rect == null ? 0 : rect.hashCode()) * 31;
            Rect rect2 = this.f695if;
            int hashCode2 = (hashCode + (rect2 == null ? 0 : rect2.hashCode())) * 31;
            Rect rect3 = this.f694for;
            int hashCode3 = (hashCode2 + (rect3 == null ? 0 : rect3.hashCode())) * 31;
            Rect rect4 = this.f696new;
            if (rect4 != null) {
                i11 = rect4.hashCode();
            }
            return hashCode3 + i11;
        }

        /* renamed from: if  reason: not valid java name */
        public final Rect m785if() {
            return this.f693do;
        }

        /* renamed from: new  reason: not valid java name */
        public final Rect m786new() {
            return this.f696new;
        }

        public String toString() {
            return "ShowDebugOverlay(faceStartRect=" + this.f693do + ", faceTargetRect=" + this.f695if + ", faceRect=" + this.f694for + ", screenCropRect=" + this.f696new + ')';
        }
    }

    private Cimport() {
    }

    public /* synthetic */ Cimport(r rVar) {
        this();
    }
}
