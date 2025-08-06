package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.a;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.util.concurrent.atomic.AtomicInteger;

public final class e extends a<d> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f22198a = new AtomicInteger();

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public int f22199a;

        /* renamed from: b  reason: collision with root package name */
        public final int f22200b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22201c;

        /* renamed from: d  reason: collision with root package name */
        private FrameMetaData f22202d;

        /* renamed from: e  reason: collision with root package name */
        private ProducerChainTimestamp f22203e;

        /* renamed from: f  reason: collision with root package name */
        private ConsumerChainTimestamp f22204f;

        public /* synthetic */ a(g gVar, int i11, int i12, byte b11) {
            this(gVar, i11, i12);
        }

        public final int a() {
            return this.f22199a;
        }

        public final int b() {
            return this.f22200b;
        }

        public final int c() {
            return this.f22201c;
        }

        public final FrameMetaData d() {
            return this.f22202d;
        }

        public final void e() {
            this.f22202d = null;
            this.f22203e = null;
            this.f22204f = null;
        }

        public final void release() {
            super.release();
        }

        private a(g<d> gVar, int i11, int i12) {
            super(gVar);
            this.f22199a = -1;
            this.f22200b = i11;
            this.f22201c = i12;
        }

        public final PixelFrame a(Object obj) {
            b bVar = new b(this, obj, (byte) 0);
            bVar.retain();
            return bVar;
        }
    }

    public static class b extends PixelFrame {

        /* renamed from: b  reason: collision with root package name */
        private static final g<b> f22205b = f.a();

        /* renamed from: a  reason: collision with root package name */
        private final d f22206a;

        public /* synthetic */ b(d dVar, Object obj, byte b11) {
            this(dVar, obj);
        }

        public final void setTextureId(int i11) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        private b(d dVar, Object obj) {
            super((g<? extends PixelFrame>) f22205b);
            dVar.retain();
            this.mWidth = dVar.b();
            this.mHeight = dVar.c();
            this.f22206a = dVar;
            this.mTextureId = dVar.a();
            this.mGLContext = obj;
            this.mPixelBufferType = GLConstants.a.TEXTURE_2D;
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
            this.mMetaData = dVar.d();
        }
    }

    public static class c implements a.C0174a {

        /* renamed from: a  reason: collision with root package name */
        public final int f22207a;

        /* renamed from: b  reason: collision with root package name */
        public final int f22208b;

        public c(int i11, int i12) {
            this.f22207a = i11;
            this.f22208b = i12;
        }

        public final boolean equals(Object obj) {
            if (obj.getClass() != c.class) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f22207a == cVar.f22207a && this.f22208b == cVar.f22208b) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.f22207a * 37213) + this.f22208b;
        }
    }

    public final /* synthetic */ void a(j jVar) {
        a aVar = (a) ((d) jVar);
        OpenGlUtils.deleteTexture(aVar.f22199a);
        aVar.f22199a = -1;
        f22198a.getAndDecrement();
    }

    public final /* synthetic */ a.C0174a b(j jVar) {
        d dVar = (d) jVar;
        return new c(dVar.b(), dVar.c());
    }

    public final void b() {
        super.b();
    }

    public final d a(int i11, int i12) {
        d dVar = (d) super.a((a.C0174a) new c(i11, i12));
        dVar.e();
        return dVar;
    }

    public final void a() {
        super.a();
    }

    public final /* synthetic */ j a(g gVar, a.C0174a aVar) {
        c cVar = (c) aVar;
        a aVar2 = new a(gVar, cVar.f22207a, cVar.f22208b, (byte) 0);
        aVar2.f22199a = OpenGlUtils.createTexture(aVar2.f22200b, aVar2.f22201c, 6408, 6408);
        f22198a.incrementAndGet();
        return aVar2;
    }
}
