package com.sumsub.sns.internal.core.domain;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Size;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public interface o {

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f33649a;

        /* renamed from: com.sumsub.sns.internal.core.domain.o$a$a  reason: collision with other inner class name */
        public static final class C0374a extends a {

            /* renamed from: b  reason: collision with root package name */
            public final Throwable f33650b;

            public C0374a(Bitmap bitmap, Throwable th2) {
                super(bitmap, (r) null);
                this.f33650b = th2;
            }

            public final Throwable b() {
                return this.f33650b;
            }
        }

        public static final class b extends a {

            /* renamed from: b  reason: collision with root package name */
            public final Throwable f33651b;

            public b(Bitmap bitmap, Throwable th2) {
                super(bitmap, (r) null);
                this.f33651b = th2;
            }

            public final Throwable b() {
                return this.f33651b;
            }
        }

        public static final class c extends a {

            /* renamed from: b  reason: collision with root package name */
            public final Throwable f33652b;

            public c(Bitmap bitmap, Throwable th2) {
                super(bitmap, (r) null);
                this.f33652b = th2;
            }

            public final Throwable b() {
                return this.f33652b;
            }
        }

        public static final class d extends a {

            /* renamed from: b  reason: collision with root package name */
            public final Size f33653b;

            /* renamed from: c  reason: collision with root package name */
            public final RectF f33654c;

            public d(Bitmap bitmap, Size size, RectF rectF) {
                super(bitmap, (r) null);
                this.f33653b = size;
                this.f33654c = rectF;
            }

            public final RectF b() {
                return this.f33654c;
            }

            public final Size c() {
                return this.f33653b;
            }
        }

        public static final class e extends a {
            public e(Bitmap bitmap) {
                super(bitmap, (r) null);
            }
        }

        public static final class f extends a {

            /* renamed from: b  reason: collision with root package name */
            public final RectF f33655b;

            public f(Bitmap bitmap, RectF rectF) {
                super(bitmap, (r) null);
                this.f33655b = rectF;
            }

            public final RectF b() {
                return this.f33655b;
            }
        }

        public static final class g extends a {
            public g(Bitmap bitmap) {
                super(bitmap, (r) null);
            }
        }

        public /* synthetic */ a(Bitmap bitmap, r rVar) {
            this(bitmap);
        }

        public final Bitmap a() {
            return this.f33649a;
        }

        public a(Bitmap bitmap) {
            this.f33649a = bitmap;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f33656a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33657b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f33658c;

        public b(int i11, int i12, byte[] bArr) {
            this.f33656a = i11;
            this.f33657b = i12;
            this.f33658c = bArr;
        }

        public final int a() {
            return this.f33657b;
        }

        public final byte[] b() {
            return this.f33658c;
        }

        public final int c() {
            return this.f33656a;
        }
    }

    void a(Bitmap bitmap, RectF rectF, l<? super a, Unit> lVar);

    String getName();

    void start();

    void stop();
}
