package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.a.a;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

public abstract class e extends a {

    /* renamed from: h  reason: collision with root package name */
    public final GLConstants.ColorSpace f22126h;

    /* renamed from: i  reason: collision with root package name */
    public final GLConstants.ColorRange f22127i;

    /* renamed from: j  reason: collision with root package name */
    private int f22128j;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f22129k;

    /* renamed from: l  reason: collision with root package name */
    private int f22130l;

    /* renamed from: m  reason: collision with root package name */
    private int f22131m;

    public e(String str, String str2, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        super(str, str2);
        int[] iArr = new int[2];
        this.f22129k = iArr;
        this.f22130l = 0;
        this.f22131m = 0;
        Arrays.fill(iArr, -1);
        this.f22126h = colorSpace == GLConstants.ColorSpace.UNKNOWN ? GLConstants.ColorSpace.BT601 : colorSpace;
        this.f22127i = colorRange == GLConstants.ColorRange.UNKNOWN ? GLConstants.ColorRange.VIDEO_RANGE : colorRange;
    }

    private void e() {
        int i11 = 0;
        while (true) {
            int[] iArr = this.f22129k;
            if (i11 < iArr.length) {
                OpenGlUtils.deleteTexture(iArr[i11]);
                this.f22129k[i11] = -1;
                i11++;
            } else {
                return;
            }
        }
    }

    public final void a(ByteBuffer byteBuffer, int i11, int i12) {
        if (!(this.f22130l == i11 && this.f22131m == i12)) {
            e();
            this.f22130l = i11;
            this.f22131m = i12;
        }
        OpenGlUtils.loadYuv420DataToTextures(byteBuffer, d(), i11, i12, this.f22129k);
    }

    public void b(com.tencent.liteav.videobase.frame.e eVar) {
        super.b(eVar);
        this.f22128j = GLES20.glGetUniformLocation(this.f22056f, "uvTexture");
    }

    public final void c() {
        e();
        super.c();
    }

    public abstract int d();

    public final void a(int i11, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(this.f22129k[0], dVar, floatBuffer, floatBuffer2);
    }

    public final void a(int i11) {
        super.a(i11);
        GLES20.glActiveTexture(33985);
        OpenGlUtils.bindTexture(a(), this.f22129k[1]);
        GLES20.glUniform1i(this.f22128j, 1);
    }

    public e(String str, String str2) {
        this(str, str2, GLConstants.ColorRange.VIDEO_RANGE, GLConstants.ColorSpace.BT601);
    }
}
