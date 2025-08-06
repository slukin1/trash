package com.iproov.sdk.p029super;

import android.graphics.Rect;
import android.opengl.GLES20;
import android.util.Size;
import com.iproov.sdk.p012final.Cif;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.utils.Cfor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.iproov.sdk.super.do  reason: invalid class name and invalid package */
public abstract class Cdo {

    /* renamed from: const  reason: not valid java name */
    public static final float[] f1978const = {1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};

    /* renamed from: final  reason: not valid java name */
    public static final float[] f1979final = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: import  reason: not valid java name */
    private static float[] f1980import;

    /* renamed from: native  reason: not valid java name */
    private static com.iproov.sdk.p012final.Cdo f1981native;

    /* renamed from: public  reason: not valid java name */
    private static FloatBuffer f1982public;

    /* renamed from: return  reason: not valid java name */
    private static Size f1983return = new Size(0, 0);

    /* renamed from: super  reason: not valid java name */
    public static FloatBuffer f1984super;

    /* renamed from: throw  reason: not valid java name */
    public static FloatBuffer f1985throw;

    /* renamed from: while  reason: not valid java name */
    public static int f1986while;

    /* renamed from: break  reason: not valid java name */
    private float f1987break = 0.0f;

    /* renamed from: case  reason: not valid java name */
    private float f1988case = 0.0f;

    /* renamed from: catch  reason: not valid java name */
    private float f1989catch = 1.0f;

    /* renamed from: class  reason: not valid java name */
    private float f1990class = 1.0f;

    /* renamed from: do  reason: not valid java name */
    public final long f1991do = System.currentTimeMillis();

    /* renamed from: else  reason: not valid java name */
    public float f1992else = 1.0f;

    /* renamed from: for  reason: not valid java name */
    private final com.iproov.sdk.p020native.Cdo f1993for = new com.iproov.sdk.p020native.Cdo();

    /* renamed from: goto  reason: not valid java name */
    private Cextends.Cbreak f1994goto = Cextends.Cbreak.CLEAR;

    /* renamed from: if  reason: not valid java name */
    public int f1995if = 0;

    /* renamed from: new  reason: not valid java name */
    private boolean f1996new = false;

    /* renamed from: this  reason: not valid java name */
    private float f1997this = 1.0f;

    /* renamed from: try  reason: not valid java name */
    private long f1998try = 0;

    public Cdo(float[] fArr) {
        if (f1984super == null) {
            m1859try();
        }
        if (f1985throw == null) {
            m1858new();
        }
        if (f1982public == null) {
            f1980import = fArr;
            m1854for();
        }
        if (f1986while == 0) {
            f1986while = Cif.m1881do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n\nvarying vec2                texCoord;\nuniform samplerExternalOES  iChannel0;\n\nvoid main() {\n    gl_FragColor = texture2D(iChannel0, texCoord);\n}");
        }
    }

    /* renamed from: case  reason: not valid java name */
    private boolean m1851case() {
        return f1986while == 0 && f1981native == null;
    }

    /* renamed from: for  reason: not valid java name */
    private void m1854for() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(f1980import.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        f1982public = asFloatBuffer;
        asFloatBuffer.put(f1980import);
        f1982public.position(0);
    }

    /* renamed from: if  reason: not valid java name */
    public static int m1856if() {
        com.iproov.sdk.p012final.Cdo doVar = f1981native;
        if (doVar == null) {
            return f1983return.getWidth();
        }
        return doVar.m1876try();
    }

    /* renamed from: new  reason: not valid java name */
    private void m1858new() {
        float[] fArr = f1979final;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        f1985throw = asFloatBuffer;
        asFloatBuffer.put(fArr);
        f1985throw.position(0);
    }

    /* renamed from: try  reason: not valid java name */
    private void m1859try() {
        float[] fArr = f1978const;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        f1984super = asFloatBuffer;
        asFloatBuffer.put(fArr);
        f1984super.position(0);
    }

    /* renamed from: do  reason: not valid java name */
    public abstract void m1861do(int i11, int i12, int i13);

    /* renamed from: do  reason: not valid java name */
    public synchronized void m1866do(Cextends.Cbreak breakR) {
        this.f1994goto = breakR;
        if (breakR == Cextends.Cbreak.BLUR) {
            this.f1992else = 1.0f;
        } else {
            this.f1992else = 0.0f;
        }
    }

    /* renamed from: else  reason: not valid java name */
    public void m1868else() {
        this.f1995if = 0;
    }

    /* renamed from: goto  reason: not valid java name */
    public synchronized void m1869goto() {
        f1986while = 0;
        f1981native = null;
        f1984super = null;
        f1985throw = null;
        f1982public = null;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1870if(int i11, int i12) {
        this.f1993for.m1136do(i11, i12);
    }

    /* renamed from: if  reason: not valid java name */
    private void m1857if(Rect rect, Size size, int i11) {
        Rect rect2 = new Rect(rect.left, size.getHeight() - rect.top, rect.right, size.getHeight() - rect.bottom);
        Rect rect3 = Cfor.m2236do(rect2, size.getHeight());
        Rect rect4 = Cfor.m2234do(rect2);
        float f11 = (float) i11;
        float f12 = (f11 / 200.0f) / f11;
        if (rect3 != null) {
            this.f1997this = (((float) (rect3.bottom - rect2.bottom)) / ((float) rect.height())) - f12;
        }
        if (rect4 != null) {
            this.f1987break = (((float) Math.abs(rect4.bottom)) / ((float) rect.height())) + f12;
        }
    }

    /* renamed from: for  reason: not valid java name */
    public static void m1855for(int i11, int i12) {
        f1983return = new Size(i11, i12);
    }

    /* renamed from: do  reason: not valid java name */
    public void m1860do(float f11) {
        if (this.f1994goto != Cextends.Cbreak.CLEAR) {
            this.f1992else = f11;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m1867do(boolean z11) {
        if (!this.f1996new && z11) {
            this.f1988case = 0.0f;
        }
        this.f1996new = z11;
    }

    /* renamed from: do  reason: not valid java name */
    public static int m1852do() {
        com.iproov.sdk.p012final.Cdo doVar = f1981native;
        if (doVar == null) {
            return f1983return.getHeight();
        }
        return doVar.m1873for();
    }

    /* renamed from: do  reason: not valid java name */
    private void m1853do(int i11, int i12) {
        float f11 = (float) i11;
        this.f1989catch = (f11 / 0.75f) / 2.0f;
        this.f1990class = (float) Math.sqrt(Math.pow((double) (f11 / 2.0f), 2.0d) + Math.pow((double) (((float) i12) / 2.0f), 2.0d));
    }

    /* renamed from: do  reason: not valid java name */
    public final synchronized void m1862do(int i11, int i12, int i13, Cif ifVar) {
        com.iproov.sdk.p012final.Cdo doVar = f1981native;
        if (!(doVar != null && doVar.m1876try() == i12 && f1981native.m1873for() == i13)) {
            f1981native = new com.iproov.sdk.p012final.Cdo(i12, i13, 33992, ifVar);
            m1853do(i12, i13);
        }
        GLES20.glUseProgram(f1986while);
        int glGetUniformLocation = GLES20.glGetUniformLocation(f1986while, "iChannel0");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i11);
        GLES20.glUniform1i(glGetUniformLocation, 0);
        int glGetAttribLocation = GLES20.glGetAttribLocation(f1986while, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        if (f1984super == null) {
            m1859try();
        }
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, f1984super);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(f1986while, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        if (f1982public == null) {
            m1854for();
        }
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, f1982public);
        f1981native.m1872do();
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        f1981native.m1871case();
        GLES20.glClear(16384);
        m1861do(f1981native.m1875new(), i12, i13);
        this.f1995if++;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1864do(int i11, int[] iArr, int[] iArr2, int[][] iArr3) {
        if (f1984super == null) {
            m1859try();
        }
        if (f1985throw == null) {
            m1858new();
        }
        m1863do(i11, f1984super, f1985throw, iArr, iArr2, iArr3);
    }

    /* renamed from: do  reason: not valid java name */
    public void m1863do(int i11, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int[] iArr, int[] iArr2, int[][] iArr3) {
        int i12 = i11;
        int[] iArr4 = iArr2;
        int[][] iArr5 = iArr3;
        GLES20.glUseProgram(i11);
        GLES20.glUniform3fv(GLES20.glGetUniformLocation(i12, "iResolution"), 1, FloatBuffer.wrap(new float[]{(float) iArr[0], (float) iArr[1], 1.0f}));
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "screenAR"), ((float) iArr[0]) / ((float) iArr[1]));
        long currentTimeMillis = System.currentTimeMillis();
        float f11 = ((float) (currentTimeMillis - this.f1991do)) / 1000.0f;
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "iGlobalTime"), f11);
        if (this.f1996new) {
            if (this.f1998try == 0) {
                this.f1998try = currentTimeMillis;
            }
            this.f1988case = f11 - (((float) (this.f1998try - this.f1991do)) / 1000.0f);
        }
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "innerHovalBlurFactor"), this.f1992else);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "animationProgress"), this.f1988case);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(i12, "iFrame"), this.f1995if);
        int glGetAttribLocation = GLES20.glGetAttribLocation(i12, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, floatBuffer);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i12, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, floatBuffer2);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "scaleX"), this.f1993for.m1142try());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "scaleY"), this.f1993for.m1134case());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "offsetX"), this.f1993for.m1135do());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "offsetY"), this.f1993for.m1139if());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "topAreaYLimit"), this.f1997this);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "botAreaYLimit"), this.f1987break);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "innerRadius"), this.f1989catch);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i12, "outerRadius"), this.f1990class);
        for (int i13 = 0; i13 < iArr4.length; i13++) {
            int glGetUniformLocation = GLES20.glGetUniformLocation(i12, "iChannel" + i13);
            GLES20.glActiveTexture(33984 + i13);
            GLES20.glBindTexture(3553, iArr4[i13]);
            GLES20.glUniform1i(glGetUniformLocation, i13);
        }
        int length = iArr5.length * 3;
        float[] fArr = new float[length];
        for (int i14 = 0; i14 < iArr5.length; i14++) {
            int i15 = i14 * 3;
            fArr[i15] = (float) iArr5[i14][0];
            fArr[i15 + 1] = (float) iArr5[i14][1];
            fArr[i15 + 2] = 1.0f;
        }
        GLES20.glUniform3fv(GLES20.glGetUniformLocation(i12, "iChannelResolution"), length, FloatBuffer.wrap(fArr));
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized void m1865do(Rect rect, Size size, int i11) {
        if (!m1851case()) {
            this.f1993for.m1137do(rect, size);
            m1857if(rect, size, i11);
        }
    }
}
