package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.tencent.android.tpush.common.Constants;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;

public final class a extends e {

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f22116j = {1.1644f, 1.1644f, 1.1644f, 0.0f, -0.3918f, 2.0172f, 1.596f, -0.813f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final float[] f22117k = {1.0f, 1.0f, 1.0f, 0.0f, -0.3441f, 1.772f, 1.402f, -0.7141f, 0.0f};

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f22118l = {1.1644f, 1.1644f, 1.1644f, 0.0f, -0.2132f, 2.1124f, 1.7927f, -0.5329f, 0.0f};

    /* renamed from: m  reason: collision with root package name */
    private static final float[] f22119m = {1.0f, 1.0f, 1.0f, 0.0f, -0.1873f, 1.8556f, 1.5748f, -0.4681f, 0.0f};

    /* renamed from: n  reason: collision with root package name */
    private static final float[] f22120n = {-0.0627451f, -0.5019608f, -0.5019608f};

    /* renamed from: o  reason: collision with root package name */
    private static final float[] f22121o = {0.0f, -0.5019608f, -0.5019608f};

    /* renamed from: p  reason: collision with root package name */
    private int f22122p;

    /* renamed from: q  reason: collision with root package name */
    private int f22123q;

    /* renamed from: com.tencent.liteav.videobase.c.a$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22124a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.tencent.liteav.videobase.base.GLConstants$ColorRange[] r0 = com.tencent.liteav.videobase.base.GLConstants.ColorRange.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22124a = r0
                com.tencent.liteav.videobase.base.GLConstants$ColorRange r1 = com.tencent.liteav.videobase.base.GLConstants.ColorRange.FULL_RANGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22124a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.videobase.base.GLConstants$ColorRange r1 = com.tencent.liteav.videobase.base.GLConstants.ColorRange.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22124a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.videobase.base.GLConstants$ColorRange r1 = com.tencent.liteav.videobase.base.GLConstants.ColorRange.VIDEO_RANGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.c.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        super(TXCGPUImageFilter.NO_FILTER_VERTEX_SHADER, "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D uvTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(inputImageTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uvTexture, vec2(textureCoordinate.x, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uvTexture, vec2(textureCoordinate.x, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform\n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor;\n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}", colorRange, colorSpace);
    }

    public static /* synthetic */ void a(a aVar) {
        float[] fArr;
        float[] fArr2;
        GLES20.glUseProgram(aVar.f22056f);
        int i11 = aVar.f22123q;
        if (AnonymousClass1.f22124a[aVar.f22127i.ordinal()] != 1) {
            fArr = f22120n;
        } else {
            fArr = f22121o;
        }
        GLES20.glUniform3fv(i11, 1, fArr, 0);
        int i12 = aVar.f22122p;
        GLConstants.ColorSpace colorSpace = aVar.f22126h;
        if (colorSpace == null || colorSpace == GLConstants.ColorSpace.UNKNOWN) {
            colorSpace = GLConstants.ColorSpace.BT601;
        }
        GLConstants.ColorRange colorRange = aVar.f22127i;
        if (colorRange == null || colorRange == GLConstants.ColorRange.UNKNOWN) {
            colorRange = GLConstants.ColorRange.VIDEO_RANGE;
        }
        if (colorSpace == GLConstants.ColorSpace.BT601) {
            if (colorRange != GLConstants.ColorRange.VIDEO_RANGE && colorRange == GLConstants.ColorRange.FULL_RANGE) {
                fArr2 = f22117k;
                GLES20.glUniformMatrix3fv(i12, 1, false, fArr2, 0);
            }
        } else if (colorSpace == GLConstants.ColorSpace.BT709) {
            if (colorRange == GLConstants.ColorRange.VIDEO_RANGE) {
                fArr2 = f22118l;
            } else if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                fArr2 = f22119m;
            }
            GLES20.glUniformMatrix3fv(i12, 1, false, fArr2, 0);
        }
        fArr2 = f22116j;
        GLES20.glUniformMatrix3fv(i12, 1, false, fArr2, 0);
    }

    public final void b(e eVar) {
        super.b(eVar);
        this.f22122p = GLES20.glGetUniformLocation(this.f22056f, "convertMatrix");
        this.f22123q = GLES20.glGetUniformLocation(this.f22056f, Constants.FLAG_TAG_OFFSET);
        a(b.a(this));
    }

    public final int d() {
        return 6409;
    }
}
