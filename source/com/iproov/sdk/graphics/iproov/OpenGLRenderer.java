package com.iproov.sdk.graphics.iproov;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Size;
import com.iproov.sdk.cameray.Ctry;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.Ccatch;
import com.iproov.sdk.graphics.iproov.Cdo;
import com.iproov.sdk.p018import.Cbreak;
import com.iproov.sdk.p018import.Ccase;
import com.iproov.sdk.p018import.Cclass;
import com.iproov.sdk.p018import.Cconst;
import com.iproov.sdk.p018import.Celse;
import com.iproov.sdk.p018import.Cfinal;
import com.iproov.sdk.p018import.Cgoto;
import com.iproov.sdk.p018import.Cimport;
import com.iproov.sdk.p018import.Cthis;
import com.iproov.sdk.p018import.Cthrow;
import com.iproov.sdk.p018import.Cwhile;
import com.iproov.sdk.p020native.Cfor;
import com.iproov.sdk.p020native.Cif;
import com.iproov.sdk.p020native.Cnew;
import com.iproov.sdk.p026return.Cextends;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: abstract  reason: not valid java name */
    private Cextends.Cbreak f590abstract = Cextends.Cbreak.CLEAR;

    /* renamed from: break  reason: not valid java name */
    private Cgoto f591break;

    /* renamed from: case  reason: not valid java name */
    private final Cnew f592case = new Cnew();

    /* renamed from: catch  reason: not valid java name */
    private Cwhile f593catch;

    /* renamed from: class  reason: not valid java name */
    private Cfinal f594class;

    /* renamed from: const  reason: not valid java name */
    private Cthrow f595const;

    /* renamed from: default  reason: not valid java name */
    private int f596default = 0;

    /* renamed from: do  reason: not valid java name */
    private Context f597do;

    /* renamed from: else  reason: not valid java name */
    private Celse f598else;

    /* renamed from: extends  reason: not valid java name */
    private int f599extends = 0;

    /* renamed from: final  reason: not valid java name */
    private Cthis f600final;

    /* renamed from: finally  reason: not valid java name */
    private final Cif f601finally = new Cif();

    /* renamed from: for  reason: not valid java name */
    private Cextends.Cclass f602for;

    /* renamed from: goto  reason: not valid java name */
    private com.iproov.sdk.p018import.Cnew f603goto;

    /* renamed from: if  reason: not valid java name */
    private Ctry f604if;

    /* renamed from: import  reason: not valid java name */
    private com.iproov.sdk.p018import.Cif f605import;

    /* renamed from: native  reason: not valid java name */
    private Cimport f606native;

    /* renamed from: new  reason: not valid java name */
    private com.iproov.sdk.p003case.Cdo f607new;

    /* renamed from: package  reason: not valid java name */
    private boolean f608package = false;

    /* renamed from: private  reason: not valid java name */
    private Cdo f609private;

    /* renamed from: public  reason: not valid java name */
    private boolean f610public;

    /* renamed from: return  reason: not valid java name */
    private boolean f611return;

    /* renamed from: static  reason: not valid java name */
    private SurfaceTexture f612static;

    /* renamed from: super  reason: not valid java name */
    private Cclass f613super;

    /* renamed from: switch  reason: not valid java name */
    private int f614switch;

    /* renamed from: this  reason: not valid java name */
    private Cbreak f615this;

    /* renamed from: throw  reason: not valid java name */
    private Ccase f616throw;

    /* renamed from: throws  reason: not valid java name */
    private volatile boolean f617throws;

    /* renamed from: try  reason: not valid java name */
    private com.iproov.sdk.p012final.Cif f618try;

    /* renamed from: while  reason: not valid java name */
    private com.iproov.sdk.p018import.Ctry f619while;

    /* renamed from: com.iproov.sdk.graphics.iproov.OpenGLRenderer$do  reason: invalid class name */
    public interface Cdo {
        /* renamed from: do  reason: not valid java name */
        void m714do();
    }

    public OpenGLRenderer(Context context) {
        super(context);
        m695do(context);
    }

    /* renamed from: break  reason: not valid java name */
    private void m693break() {
        Celse elseR = m702if();
        this.f598else = elseR;
        elseR.m1868else();
        this.f598else.m1866do(this.f590abstract);
    }

    /* renamed from: case  reason: not valid java name */
    private void m694case() {
        queueEvent(new b(this));
    }

    /* renamed from: do  reason: not valid java name */
    private void m695do(Context context) {
        this.f597do = context;
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setRenderer(this);
        setRenderMode(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: else  reason: not valid java name */
    public /* synthetic */ void m698else() {
        if (this.f617throws) {
            this.f596default++;
            requestRender();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: goto  reason: not valid java name */
    public /* synthetic */ void m700goto() {
        setBackgroundColor(0);
    }

    /* renamed from: if  reason: not valid java name */
    private Celse m702if() {
        DisplayMetrics displayMetrics = this.f597do.getResources().getDisplayMetrics();
        Size size = new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
        Cextends.Ccase caseR = this.f602for.m1498new();
        Cdo doVar = new Cdo(size, caseR);
        this.f603goto = (com.iproov.sdk.p018import.Cnew) doVar.m716do(this.f597do, Cdo.Cif.CROP);
        this.f615this = (Cbreak) doVar.m716do(this.f597do, Cdo.Cif.LUMINANCE);
        this.f591break = (Cgoto) doVar.m716do(this.f597do, Cdo.Cif.HORIZONTAL_BLUR);
        this.f593catch = (Cwhile) doVar.m716do(this.f597do, Cdo.Cif.VERTICAL_BLUR);
        this.f594class = (Cfinal) doVar.m716do(this.f597do, Cdo.Cif.SOBEL);
        this.f595const = (Cthrow) doVar.m716do(this.f597do, Cdo.Cif.SUPPRESSION);
        this.f600final = (Cthis) doVar.m716do(this.f597do, Cdo.Cif.INCLUSION);
        this.f613super = (Cclass) doVar.m716do(this.f597do, Cdo.Cif.SHADE);
        this.f619while = (com.iproov.sdk.p018import.Ctry) doVar.m716do(this.f597do, Cdo.Cif.FADE);
        this.f616throw = (Ccase) doVar.m716do(this.f597do, Cdo.Cif.FLASHING);
        this.f606native = (Cimport) doVar.m716do(this.f597do, Cdo.Cif.VIGNETTE);
        this.f605import = (com.iproov.sdk.p018import.Cif) doVar.m716do(this.f597do, Cdo.Cif.BLUR_WITH_HOVAL);
        Celse elseR = new Celse(com.iproov.sdk.p017implements.Cgoto.m1008do(this.f592case.m1159if()));
        if (caseR instanceof Cextends.Ccase.Cdo) {
            elseR.m1080do(m703new());
        } else {
            elseR.m1080do(m705try());
        }
        return elseR;
    }

    /* renamed from: new  reason: not valid java name */
    private Cconst m703new() {
        Cconst constR = new Cconst();
        constR.m1062do(this.f603goto);
        constR.m1062do(this.f615this);
        constR.m1062do(this.f591break);
        constR.m1062do(this.f593catch);
        constR.m1062do(this.f594class);
        constR.m1062do(this.f595const);
        constR.m1062do(this.f600final);
        constR.m1062do(this.f613super);
        constR.m1062do(this.f619while);
        constR.m1062do(this.f616throw);
        if (!this.f602for.m1497if()) {
            constR.m1062do(this.f606native);
            constR.m1062do(this.f605import);
        }
        return constR;
    }

    /* access modifiers changed from: private */
    /* renamed from: this  reason: not valid java name */
    public /* synthetic */ void m704this() {
        SurfaceTexture surfaceTexture = this.f612static;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    /* renamed from: try  reason: not valid java name */
    private Cconst m705try() {
        Cconst constR = new Cconst();
        constR.m1062do(this.f603goto);
        if (!this.f602for.m1497if()) {
            constR.m1062do(this.f606native);
            constR.m1062do(this.f605import);
        }
        return constR;
    }

    /* renamed from: catch  reason: not valid java name */
    public void m706catch() {
        this.f598else.m1080do(m699for());
    }

    /* renamed from: class  reason: not valid java name */
    public void m707class() {
        if (!this.f610public) {
            this.f610public = true;
            this.f619while.m1093new();
        }
    }

    /* renamed from: const  reason: not valid java name */
    public synchronized void m708const() {
        this.f617throws = false;
        this.f599extends = 0;
        this.f596default = 0;
        Celse elseR = this.f598else;
        if (elseR != null) {
            elseR.m1869goto();
        }
        Ctry tryR = this.f604if;
        if (tryR != null) {
            tryR.m211do((Runnable) new c(this));
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m713for(Size size) {
        float f11;
        m697do(size);
        com.iproov.sdk.p029super.Cdo.m1855for(this.f592case.m1158for(), this.f592case.m1155do());
        if (this.f607new == com.iproov.sdk.p003case.Cdo.LIVENESS) {
            this.f598else.m1870if(this.f592case.m1155do(), this.f618try.f532if);
        }
        float f12 = 0.0f;
        if (this.f602for.m1487break().isPortrait()) {
            f11 = (((float) (this.f592case.m1155do() - this.f618try.f532if)) / ((float) this.f592case.m1155do())) * 0.5f;
        } else {
            f12 = (((float) (this.f592case.m1158for() - this.f618try.f530do)) / ((float) this.f592case.m1158for())) * 0.5f;
            f11 = 0.0f;
        }
        if (this.f602for.m1498new() instanceof Cextends.Ccase.Cdo) {
            this.f619while.m1091do(f12, f11);
        }
        this.f608package = true;
    }

    public com.iproov.sdk.p017implements.Cthis getFrameRate() {
        return this.f601finally.m1152if();
    }

    public Size getScreenSize() {
        return new Size(this.f592case.m1158for(), this.f592case.m1155do());
    }

    public String getScreenSizeString() {
        return this.f592case.m1158for() + " x " + this.f592case.m1155do();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onDrawFrame(javax.microedition.khronos.opengles.GL10 r6) {
        /*
            r5 = this;
            monitor-enter(r5)
        L_0x0001:
            boolean r6 = r5.f617throws     // Catch:{ all -> 0x0064 }
            if (r6 == 0) goto L_0x0062
            int r6 = r5.f599extends     // Catch:{ all -> 0x0064 }
            int r0 = r5.f596default     // Catch:{ all -> 0x0064 }
            if (r6 == r0) goto L_0x0062
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0064 }
            r0 = 26
            if (r6 < r0) goto L_0x001b
            android.graphics.SurfaceTexture r6 = r5.f612static     // Catch:{ all -> 0x0064 }
            boolean r6 = r6.isReleased()     // Catch:{ all -> 0x0064 }
            if (r6 == 0) goto L_0x001b
            monitor-exit(r5)
            return
        L_0x001b:
            r6 = 16384(0x4000, float:2.2959E-41)
            android.opengl.GLES20.glClear(r6)     // Catch:{ all -> 0x0064 }
            android.graphics.SurfaceTexture r6 = r5.f612static     // Catch:{ all -> 0x0064 }
            r6.updateTexImage()     // Catch:{ all -> 0x0064 }
            int r6 = r5.f599extends     // Catch:{ all -> 0x0064 }
            r0 = 1
            int r6 = r6 + r0
            r5.f599extends = r6     // Catch:{ all -> 0x0064 }
            com.iproov.sdk.import.else r6 = r5.f598else     // Catch:{ all -> 0x0064 }
            int r1 = r5.f614switch     // Catch:{ all -> 0x0064 }
            com.iproov.sdk.native.new r2 = r5.f592case     // Catch:{ all -> 0x0064 }
            int r2 = r2.m1158for()     // Catch:{ all -> 0x0064 }
            com.iproov.sdk.native.new r3 = r5.f592case     // Catch:{ all -> 0x0064 }
            int r3 = r3.m1155do()     // Catch:{ all -> 0x0064 }
            com.iproov.sdk.final.if r4 = r5.f618try     // Catch:{ all -> 0x0064 }
            r6.m1862do((int) r1, (int) r2, (int) r3, (com.iproov.sdk.p012final.Cif) r4)     // Catch:{ all -> 0x0064 }
            com.iproov.sdk.while.do r6 = com.iproov.sdk.p037while.Cdo.f2401do     // Catch:{ all -> 0x0064 }
            com.iproov.sdk.native.new r1 = r5.f592case     // Catch:{ all -> 0x0064 }
            int r1 = r1.m1155do()     // Catch:{ all -> 0x0064 }
            r6.m2288do(r1)     // Catch:{ all -> 0x0064 }
            android.opengl.GLES20.glFlush()     // Catch:{ all -> 0x0064 }
            boolean r6 = r5.f611return     // Catch:{ all -> 0x0064 }
            if (r6 != 0) goto L_0x005c
            com.iproov.sdk.graphics.iproov.d r6 = new com.iproov.sdk.graphics.iproov.d     // Catch:{ all -> 0x0064 }
            r6.<init>(r5)     // Catch:{ all -> 0x0064 }
            com.iproov.sdk.p017implements.Cimport.m1017do((java.lang.Runnable) r6)     // Catch:{ all -> 0x0064 }
            r5.f611return = r0     // Catch:{ all -> 0x0064 }
        L_0x005c:
            com.iproov.sdk.native.if r6 = r5.f601finally     // Catch:{ all -> 0x0064 }
            r6.m1147case()     // Catch:{ all -> 0x0064 }
            goto L_0x0001
        L_0x0062:
            monitor-exit(r5)
            return
        L_0x0064:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.graphics.iproov.OpenGLRenderer.onDrawFrame(javax.microedition.khronos.opengles.GL10):void");
    }

    public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
        this.f592case.m1156do(i11, i12);
        m709do();
    }

    public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.f617throws = true;
    }

    public void setHovalScaleFactor(float f11) {
        com.iproov.sdk.p018import.Cif ifVar = this.f605import;
        if (ifVar != null) {
            ifVar.m1084do(f11);
        }
    }

    public void setInnerBlurProgress(float f11) {
        Celse elseR = this.f598else;
        if (elseR != null) {
            elseR.m1860do(f11);
        }
    }

    public void setLAEndAnimationFlag(boolean z11) {
        Celse elseR = this.f598else;
        if (elseR != null) {
            elseR.m1867do(z11);
        }
    }

    public void setNaturalFilterStyle(Cextends.Cbreak breakR) {
        this.f590abstract = breakR;
        Celse elseR = this.f598else;
        if (elseR != null) {
            elseR.m1866do(breakR);
        }
    }

    public void setPermissionsDelegate(Cdo doVar) {
        this.f609private = doVar;
    }

    /* renamed from: do  reason: not valid java name */
    public void m712do(Ctry tryR, Cextends.Cclass classR, Orientation orientation, com.iproov.sdk.p003case.Cdo doVar) {
        this.f604if = tryR;
        this.f602for = classR;
        this.f607new = doVar;
        this.f592case.m1157do(orientation);
        m693break();
        this.f614switch = com.iproov.sdk.p029super.Cif.m1878do(36197);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f614switch);
        this.f612static = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new a(this));
        tryR.m210do(this.f612static);
    }

    public OpenGLRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m695do(context);
    }

    /* renamed from: for  reason: not valid java name */
    private Cconst m699for() {
        Cconst constR = new Cconst();
        constR.m1062do(this.f603goto);
        constR.m1062do(this.f615this);
        constR.m1062do(this.f591break);
        constR.m1062do(this.f593catch);
        constR.m1062do(this.f594class);
        constR.m1062do(this.f595const);
        constR.m1062do(this.f600final);
        constR.m1062do(this.f613super);
        constR.m1062do(this.f616throw);
        return constR;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public /* synthetic */ void m696do(SurfaceTexture surfaceTexture) {
        com.iproov.sdk.core.Cbreak.m310do(Ccatch.AND4);
        if (this.f608package) {
            m694case();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m697do(Size size) {
        this.f618try = Cfor.m1144do(size, this.f592case.m1158for(), this.f592case.m1155do(), this.f592case.m1159if());
    }

    /* renamed from: if  reason: not valid java name */
    private Size m701if(Size size) {
        return !this.f592case.m1159if().isPortrait() ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    /* renamed from: do  reason: not valid java name */
    public void m710do(int i11, float f11, long j11) {
        Cclass classR = this.f613super;
        if (classR != null) {
            classR.m1059do(1.0f);
        }
        this.f616throw.m1055if(Cfor.m1145do(i11));
        this.f616throw.m1053do(Cfor.m1145do(Cfor.m1146if(i11)));
    }

    /* renamed from: do  reason: not valid java name */
    public void m709do() {
        this.f609private.m714do();
    }

    /* renamed from: do  reason: not valid java name */
    public void m711do(Rect rect, Size size, int i11) {
        this.f598else.m1865do(rect, m701if(size), i11);
    }
}
