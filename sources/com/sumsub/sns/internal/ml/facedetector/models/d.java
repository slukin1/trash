package com.sumsub.sns.internal.ml.facedetector.models;

import kotlin.jvm.internal.r;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final float f35104a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35105b;

    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        public static final C0416a f35106c = new C0416a((r) null);

        /* renamed from: a  reason: collision with root package name */
        public float f35107a = 0.5f;

        /* renamed from: b  reason: collision with root package name */
        public int f35108b = -1;

        /* renamed from: com.sumsub.sns.internal.ml.facedetector.models.d$a$a  reason: collision with other inner class name */
        public static final class C0416a {
            public /* synthetic */ C0416a(r rVar) {
                this();
            }

            public C0416a() {
            }

            public final void a(d dVar) {
                boolean z11 = true;
                if (dVar.a() != 0 && dVar.a() >= -1) {
                    if (dVar.b() < 0.0f || dVar.b() > 1.0f) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalArgumentException("MinConfidence must be between 0 and 1".toString());
                    }
                    return;
                }
                throw new IllegalArgumentException(("MaxNumberOfFaces must be greater than 0 or -1, maxNumberOfFaces: " + dVar.a()).toString());
            }
        }

        public static /* synthetic */ void d() {
        }

        public final a a(float f11) {
            this.f35107a = f11;
            return this;
        }

        public final int b() {
            return this.f35108b;
        }

        public final float c() {
            return this.f35107a;
        }

        public final a a(int i11) {
            this.f35108b = i11;
            return this;
        }

        public final d a() {
            d dVar = new d(this, (r) null);
            f35106c.a(dVar);
            return dVar;
        }
    }

    public /* synthetic */ d(a aVar, r rVar) {
        this(aVar);
    }

    public final int a() {
        return this.f35105b;
    }

    public final float b() {
        return this.f35104a;
    }

    public d(a aVar) {
        this.f35104a = aVar.c();
        this.f35105b = aVar.b();
    }
}
