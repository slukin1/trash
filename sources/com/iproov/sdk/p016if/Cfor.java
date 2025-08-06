package com.iproov.sdk.p016if;

import android.graphics.RectF;
import com.iproov.sdk.core.exception.CameraException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.for  reason: invalid class name and invalid package */
public abstract class Cfor {

    /* renamed from: com.iproov.sdk.if.for$do  reason: invalid class name */
    public static final class Cdo extends Cfor {

        /* renamed from: do  reason: not valid java name */
        private final CameraException f671do;

        public Cdo(CameraException cameraException) {
            super((r) null);
            this.f671do = cameraException;
        }

        /* renamed from: do  reason: not valid java name */
        public final CameraException m770do() {
            return this.f671do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cdo) && x.b(this.f671do, ((Cdo) obj).f671do);
        }

        public int hashCode() {
            return this.f671do.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.f671do + ')';
        }
    }

    /* renamed from: com.iproov.sdk.if.for$if  reason: invalid class name */
    public static final class Cif extends Cfor {

        /* renamed from: do  reason: not valid java name */
        private final RectF f672do;

        public Cif(RectF rectF) {
            super((r) null);
            this.f672do = rectF;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cif) && x.b(this.f672do, ((Cif) obj).f672do);
        }

        public int hashCode() {
            return this.f672do.hashCode();
        }

        public String toString() {
            return "MeteringAreaDefined(area=" + this.f672do + ')';
        }
    }

    private Cfor() {
    }

    public /* synthetic */ Cfor(r rVar) {
        this();
    }
}
