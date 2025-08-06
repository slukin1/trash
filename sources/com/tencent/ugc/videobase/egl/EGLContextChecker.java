package com.tencent.ugc.videobase.egl;

import android.opengl.GLES20;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class EGLContextChecker {
    private static final String TAG = "EGLContextChecker";
    private final CustomHandler mCustomHandler;
    private EGLCore mEGLCore;
    private final String mFragmentShaderSource;
    private Object mLastContext = null;
    private final AtomicInteger mShaderId = new AtomicInteger(-1);

    public EGLContextChecker(Looper looper) {
        this.mCustomHandler = new CustomHandler(looper);
        this.mFragmentShaderSource = String.format(Locale.ENGLISH, "// %s-%s E8083882-0D59-47A1-B4B6-25C15A69875A\nvoid main() {gl_FragColor = vec4(0, 0, 0, 0);}", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(SystemClock.uptimeMillis())});
    }

    private void initGLComponents(Object obj) {
        if (this.mEGLCore == null) {
            try {
                EGLCore eGLCore = new EGLCore();
                this.mEGLCore = eGLCore;
                eGLCore.initialize(obj, (Surface) null, 128, 128);
                int glCreateShader = GLES20.glCreateShader(35632);
                GLES20.glShaderSource(glCreateShader, this.mFragmentShaderSource);
                this.mShaderId.set(glCreateShader);
                LiteavLog.i(TAG, "create shader id: %d", Integer.valueOf(glCreateShader));
            } catch (EGLException e11) {
                LiteavLog.i(TAG, "create EGLCore failed.", e11);
            }
        }
    }

    public static /* synthetic */ void lambda$recreateShader$0(EGLContextChecker eGLContextChecker, Object obj) {
        eGLContextChecker.uninitGLComponents();
        eGLContextChecker.initGLComponents(obj);
    }

    private void recreateShader(Object obj) {
        this.mCustomHandler.runAndWaitDone(b.a(this, obj));
    }

    /* access modifiers changed from: private */
    public void uninitGLComponents() {
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore != null) {
            try {
                eGLCore.makeCurrent();
                OpenGlUtils.deleteShaderId(this.mShaderId.getAndSet(-1));
            } catch (EGLException e11) {
                LiteavLog.i(TAG, "release EGLCore failed.", e11);
            }
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
        }
    }

    public boolean isSameOrSharedContext(Object obj) {
        if (obj == null) {
            return true;
        }
        boolean z11 = !CommonUtil.equals(this.mLastContext, obj);
        this.mLastContext = obj;
        if (!z11) {
            return true;
        }
        return false;
    }

    public void uninitialize() {
        this.mCustomHandler.post(a.a(this));
    }
}
