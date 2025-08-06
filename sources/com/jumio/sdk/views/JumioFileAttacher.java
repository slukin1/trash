package com.jumio.sdk.views;

import android.os.ParcelFileDescriptor;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.io.File;
import java.util.List;
import jumio.core.j1;
import jumio.core.p1;
import kotlin.Unit;
import kotlin.jvm.internal.x;

public final class JumioFileAttacher {

    /* renamed from: a  reason: collision with root package name */
    public j1 f25021a;

    public static final class JumioFileRequirements {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f25022a;

        /* renamed from: b  reason: collision with root package name */
        public final int f25023b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25024c;

        public JumioFileRequirements(List<String> list, int i11, int i12) {
            this.f25022a = list;
            this.f25023b = i11;
            this.f25024c = i12;
        }

        public static /* synthetic */ JumioFileRequirements copy$default(JumioFileRequirements jumioFileRequirements, List<String> list, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                list = jumioFileRequirements.f25022a;
            }
            if ((i13 & 2) != 0) {
                i11 = jumioFileRequirements.f25023b;
            }
            if ((i13 & 4) != 0) {
                i12 = jumioFileRequirements.f25024c;
            }
            return jumioFileRequirements.copy(list, i11, i12);
        }

        public final List<String> component1() {
            return this.f25022a;
        }

        public final int component2() {
            return this.f25023b;
        }

        public final int component3() {
            return this.f25024c;
        }

        public final JumioFileRequirements copy(List<String> list, int i11, int i12) {
            return new JumioFileRequirements(list, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JumioFileRequirements)) {
                return false;
            }
            JumioFileRequirements jumioFileRequirements = (JumioFileRequirements) obj;
            return x.b(this.f25022a, jumioFileRequirements.f25022a) && this.f25023b == jumioFileRequirements.f25023b && this.f25024c == jumioFileRequirements.f25024c;
        }

        public final int getMaxFileSize() {
            return this.f25023b;
        }

        public final List<String> getMimeTypes() {
            return this.f25022a;
        }

        public final int getPdfMaxPages() {
            return this.f25024c;
        }

        public int hashCode() {
            return this.f25024c + p1.a(this.f25023b, this.f25022a.hashCode() * 31, 31);
        }

        public String toString() {
            List<String> list = this.f25022a;
            int i11 = this.f25023b;
            int i12 = this.f25024c;
            return "JumioFileRequirements(mimeTypes=" + list + ", maxFileSize=" + i11 + ", pdfMaxPages=" + i12 + ")";
        }
    }

    public final void attach(JumioScanPart jumioScanPart) {
        if (jumioScanPart.getScanPart$jumio_core_release() instanceof j1) {
            this.f25021a = (j1) jumioScanPart.getScanPart$jumio_core_release();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.jumio.sdk.views.JumioFileAttacher.JumioFileRequirements getRequirements() {
        /*
            r3 = this;
            jumio.core.j1 r0 = r3.f25021a
            if (r0 == 0) goto L_0x000a
            com.jumio.sdk.views.JumioFileAttacher$JumioFileRequirements r0 = r0.b()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            com.jumio.sdk.views.JumioFileAttacher$JumioFileRequirements r0 = new com.jumio.sdk.views.JumioFileAttacher$JumioFileRequirements
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            r2 = 0
            r0.<init>(r1, r2, r2)
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.views.JumioFileAttacher.getRequirements():com.jumio.sdk.views.JumioFileAttacher$JumioFileRequirements");
    }

    public final Unit setFile(File file) {
        j1 j1Var = this.f25021a;
        if (j1Var == null) {
            return null;
        }
        j1Var.a(file);
        return Unit.f56620a;
    }

    public final Unit setFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        j1 j1Var = this.f25021a;
        if (j1Var == null) {
            return null;
        }
        j1Var.a(parcelFileDescriptor);
        return Unit.f56620a;
    }
}
