package com.hbg.component.kline.render.buffer;

public abstract class DataBuffer {

    public enum BufferType {
        NONE,
        EXCLUDE_INCLUDE,
        EXCLUDE_EXCLUDE,
        INCLUDE_EXCLUDE,
        INCLUDE_INCLUDE
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f67299a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f67300b;

        /* renamed from: c  reason: collision with root package name */
        public BufferType f67301c;

        /* renamed from: d  reason: collision with root package name */
        public int f67302d = 0;

        public a(int i11) {
            this.f67300b = i11;
            this.f67301c = BufferType.NONE;
        }

        public void a() {
            this.f67301c = BufferType.NONE;
        }

        public void b(BufferType bufferType) {
            this.f67301c = bufferType;
        }

        public int c() {
            return this.f67300b;
        }
    }

    public static class b extends a {

        /* renamed from: e  reason: collision with root package name */
        public float[] f67303e;

        public b(int i11) {
            super(i11);
            this.f67303e = new float[i11];
        }
    }

    public static class c extends b {

        /* renamed from: f  reason: collision with root package name */
        public int f67304f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f67305g;

        public c(int i11) {
            super(i11);
            int i12 = this.f67299a;
            this.f67304f = i12;
            this.f67305g = i12;
            this.f67305g = i11;
        }

        public void a() {
            super.a();
            this.f67304f = -1;
            this.f67305g = this.f67300b;
        }

        public void d(float[] fArr) {
            if (fArr != null && fArr.length % 4 == 0 && i(fArr)) {
                for (int i11 = 0; i11 < fArr.length; i11 += 4) {
                    float[] fArr2 = this.f67303e;
                    int i12 = this.f67304f + 1;
                    this.f67304f = i12;
                    int i13 = i11 << 2;
                    fArr2[i12] = fArr[i13 + 0];
                    int i14 = i12 + 1;
                    this.f67304f = i14;
                    fArr2[i14] = fArr[i13 + 1];
                    int i15 = i14 + 1;
                    this.f67304f = i15;
                    fArr2[i15] = fArr[i13 + 2];
                    int i16 = i15 + 1;
                    this.f67304f = i16;
                    fArr2[i16] = fArr[i13 + 3];
                }
            }
        }

        public void e(float[] fArr) {
            if (fArr != null && fArr.length % 4 == 0 && i(fArr)) {
                for (int i11 = 0; i11 < fArr.length; i11 += 4) {
                    float[] fArr2 = this.f67303e;
                    int i12 = this.f67305g - 1;
                    this.f67305g = i12;
                    int i13 = i11 << 2;
                    fArr2[i12] = fArr[i13 + 3];
                    int i14 = i12 - 1;
                    this.f67305g = i14;
                    fArr2[i14] = fArr[i13 + 2];
                    int i15 = i14 - 1;
                    this.f67305g = i15;
                    fArr2[i15] = fArr[i13 + 1];
                    int i16 = i15 - 1;
                    this.f67305g = i16;
                    fArr2[i16] = fArr[i13 + 0];
                }
            }
        }

        public void f(c cVar) {
            this.f67304f = cVar.f67304f;
            this.f67305g = cVar.f67305g;
        }

        public int g() {
            return this.f67304f;
        }

        public int h() {
            return this.f67305g;
        }

        public final boolean i(float[] fArr) {
            if ((this.f67305g - this.f67304f) - 1 >= (fArr == null ? 0 : fArr.length)) {
                return true;
            }
            return false;
        }
    }
}
