package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Log;

public final class DummySurface extends Surface {
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    public static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        public DummySurfaceThread() {
            super("ExoPlayer:DummySurface");
        }

        private void initInternal(int i11) {
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.init(i11);
            this.surface = new DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), i11 != 0);
        }

        private void releaseInternal() {
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.release();
        }

        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e11) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e11);
                    this.initException = e11;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e12) {
                    try {
                        Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e12);
                        this.initError = e12;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th2) {
                        synchronized (this) {
                            notify();
                            throw th2;
                        }
                    }
                }
                return true;
            } else if (i11 != 2) {
                return true;
            } else {
                try {
                    releaseInternal();
                } catch (Throwable th3) {
                    quit();
                    throw th3;
                }
                quit();
                return true;
            }
        }

        public DummySurface init(int i11) {
            boolean z11;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z11 = false;
                this.handler.obtainMessage(1, i11, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z11 = true;
                    }
                }
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException == null) {
                Error error = this.initError;
                if (error == null) {
                    return (DummySurface) Assertions.checkNotNull(this.surface);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void release() {
            Assertions.checkNotNull(this.handler);
            this.handler.sendEmptyMessage(2);
        }
    }

    private static int getSecureMode(Context context) {
        if (GlUtil.isProtectedContentExtensionSupported(context)) {
            return GlUtil.isSurfacelessContextExtensionSupported() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z11;
        synchronized (DummySurface.class) {
            z11 = true;
            if (!secureModeInitialized) {
                secureMode = getSecureMode(context);
                secureModeInitialized = true;
            }
            if (secureMode == 0) {
                z11 = false;
            }
        }
        return z11;
    }

    public static DummySurface newInstanceV17(Context context, boolean z11) {
        int i11 = 0;
        Assertions.checkState(!z11 || isSecureSupported(context));
        DummySurfaceThread dummySurfaceThread = new DummySurfaceThread();
        if (z11) {
            i11 = secureMode;
        }
        return dummySurfaceThread.init(i11);
    }

    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z11) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z11;
    }
}
