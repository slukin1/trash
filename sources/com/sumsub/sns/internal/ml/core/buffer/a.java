package com.sumsub.sns.internal.ml.core.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.r;
import org.tensorflow.lite.DataType;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0409a f35014c = new C0409a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final float[] f35015a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f35016b;

    /* renamed from: com.sumsub.sns.internal.ml.core.buffer.a$a  reason: collision with other inner class name */
    public static final class C0409a {
        public /* synthetic */ C0409a(r rVar) {
            this();
        }

        public final int a(int[] iArr) {
            int i11 = 1;
            for (int i12 : iArr) {
                i11 *= i12;
            }
            return i11;
        }

        public C0409a() {
        }
    }

    public a(float[] fArr, int[] iArr) {
        this.f35015a = fArr;
        this.f35016b = iArr;
    }

    public final ByteBuffer a() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f35014c.a(this.f35016b) * DataType.FLOAT32.byteSize());
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.asFloatBuffer().put(this.f35015a);
        return allocateDirect;
    }

    public final float[] b() {
        return this.f35015a;
    }

    public final int[] c() {
        return this.f35016b;
    }
}
