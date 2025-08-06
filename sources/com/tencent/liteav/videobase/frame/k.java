package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;

public final class k extends h<b> {

    public static class a extends PixelFrame {

        /* renamed from: b  reason: collision with root package name */
        private static final g<a> f22230b = l.a();

        /* renamed from: a  reason: collision with root package name */
        private final b f22231a;

        public /* synthetic */ a(b bVar, Object obj, byte b11) {
            this(bVar, obj);
        }

        public final void setTextureId(int i11) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        private a(b bVar, Object obj) {
            super((g<? extends PixelFrame>) f22230b);
            bVar.retain();
            this.mWidth = bVar.f22234c;
            this.mHeight = bVar.f22235d;
            this.f22231a = bVar;
            this.mTextureId = bVar.f22232a;
            this.mGLContext = obj;
            int i11 = bVar.f22233b;
            if (i11 == 3553) {
                this.mPixelBufferType = GLConstants.a.TEXTURE_2D;
            } else if (i11 == 36197) {
                this.mPixelBufferType = GLConstants.a.TEXTURE_OES;
            }
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
        }
    }

    public static class b extends d {

        /* renamed from: a  reason: collision with root package name */
        public int f22232a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f22233b = 3553;

        /* renamed from: c  reason: collision with root package name */
        public int f22234c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f22235d = 0;

        /* renamed from: e  reason: collision with root package name */
        private FrameMetaData f22236e;

        /* renamed from: f  reason: collision with root package name */
        private ProducerChainTimestamp f22237f;

        /* renamed from: g  reason: collision with root package name */
        private ConsumerChainTimestamp f22238g;

        public b(g<? extends d> gVar) {
            super(gVar);
        }

        public final int a() {
            return this.f22232a;
        }

        public final int b() {
            return this.f22234c;
        }

        public final int c() {
            return this.f22235d;
        }

        public final FrameMetaData d() {
            return this.f22236e;
        }

        public final void e() {
            this.f22232a = -1;
            this.f22233b = 3553;
            this.f22234c = 0;
            this.f22235d = 0;
            this.f22236e = null;
            this.f22238g = null;
            this.f22237f = null;
        }

        public final PixelFrame a(Object obj) {
            a aVar = new a(this, obj, (byte) 0);
            aVar.retain();
            return aVar;
        }
    }

    public final /* synthetic */ j a(g gVar) {
        return new b(gVar);
    }
}
