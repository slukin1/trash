package com.tencent.thumbplayer.tcmedia.core.common;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class TPScreenRefreshRateDetector {
    public static final int DISPLAY_CHANGE = 10001;
    /* access modifiers changed from: private */
    public static String TAG = "TPScreenRefreshRateDetector";
    private static boolean isInitted = false;
    private static List<ScreenRefreshRateChangedListener> listeners = new LinkedList();
    private static WeakReference<Context> mContext;
    private static float mCurScreenRefreshRate = 60.0f;
    private static DisplayManager.DisplayListener mDisplayListener = new DisplayManager.DisplayListener() {
        public final void onDisplayAdded(int i11) {
        }

        public final void onDisplayChanged(int i11) {
            if (i11 == 0) {
                TPScreenRefreshRateDetector.mHandler.sendEmptyMessage(10001);
            }
            TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "onDisplayChanged displayId:".concat(String.valueOf(i11)));
        }

        public final void onDisplayRemoved(int i11) {
        }
    };
    /* access modifiers changed from: private */
    public static DisplayManager mDisplayManager = null;
    /* access modifiers changed from: private */
    public static Handler mHandler;
    private static WindowManager mWindowManager;

    public interface ScreenRefreshRateChangedListener {
        void onScreenRefreshRateChanged(float f11);
    }

    public static void addListener(ScreenRefreshRateChangedListener screenRefreshRateChangedListener) {
        synchronized (TPScreenRefreshRateDetector.class) {
            listeners.add(screenRefreshRateChangedListener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void deinit() {
        /*
            java.lang.Class<com.tencent.thumbplayer.tcmedia.core.common.TPScreenRefreshRateDetector> r0 = com.tencent.thumbplayer.tcmedia.core.common.TPScreenRefreshRateDetector.class
            monitor-enter(r0)
            boolean r1 = isInitted     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x001c
            java.lang.ref.WeakReference<android.content.Context> r1 = mContext     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x000c
            goto L_0x001c
        L_0x000c:
            r1.clear()     // Catch:{ all -> 0x001e }
            r1 = 0
            isInitted = r1     // Catch:{ all -> 0x001e }
            r1 = 2
            java.lang.String r2 = TAG     // Catch:{ all -> 0x001e }
            java.lang.String r3 = "TPScreenRefreshRateDetector deinit succeed!"
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r2, r3)     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPScreenRefreshRateDetector.deinit():void");
    }

    private static Looper getLooper() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static float getScreenRefreshRate() {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT < 23) {
            str = TAG;
            str2 = "Current version can not get screen refresh rate, set default.";
        } else {
            WeakReference<Context> weakReference = mContext;
            if (weakReference == null) {
                str = TAG;
                str2 = "Current mContext is null, set default.";
            } else {
                Context context = (Context) weakReference.get();
                if (context != null) {
                    if (mWindowManager == null) {
                        mWindowManager = (WindowManager) context.getSystemService("window");
                    }
                    if (mDisplayManager == null) {
                        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
                        mDisplayManager = displayManager;
                        displayManager.registerDisplayListener(mDisplayListener, mHandler);
                    }
                    WindowManager windowManager = mWindowManager;
                    if (windowManager != null) {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
                        Display.Mode mode = defaultDisplay.getMode();
                        String str3 = TAG;
                        TPNativeLog.printLog(2, str3, "getMode width:" + mode.getPhysicalWidth() + " height:" + mode.getPhysicalHeight() + " refreshRate:" + mode.getRefreshRate() + " ModeId:" + mode.getModeId());
                        String str4 = TAG;
                        StringBuilder sb2 = new StringBuilder("getSupportedModes length:");
                        sb2.append(supportedModes.length);
                        TPNativeLog.printLog(2, str4, sb2.toString());
                        for (int i11 = 0; i11 < supportedModes.length; i11++) {
                            String str5 = TAG;
                            TPNativeLog.printLog(2, str5, "getSupportedModes width:" + supportedModes[i11].getPhysicalWidth() + " height:" + supportedModes[i11].getPhysicalHeight() + " refreshRate:" + supportedModes[i11].getRefreshRate() + " ModeId:" + supportedModes[i11].getModeId());
                        }
                        mCurScreenRefreshRate = mode.getRefreshRate();
                    }
                }
                return mCurScreenRefreshRate;
            }
        }
        TPNativeLog.printLog(4, str, str2);
        return mCurScreenRefreshRate;
    }

    public static void init(Context context) {
        synchronized (TPScreenRefreshRateDetector.class) {
            TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init enter!");
            if (!isInitted) {
                mContext = new WeakReference<>(context.getApplicationContext());
                isInitted = true;
                initHandleMsg();
                TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init succeed!");
            }
        }
    }

    public static void initHandleMsg() {
        mHandler = new Handler(getLooper()) {
            public final void handleMessage(Message message) {
                if (message.what == 10001 && TPScreenRefreshRateDetector.mDisplayManager != null) {
                    Display display = TPScreenRefreshRateDetector.mDisplayManager.getDisplay(0);
                    String mode = display.getMode().toString();
                    String access$100 = TPScreenRefreshRateDetector.TAG;
                    TPNativeLog.printLog(2, access$100, "handleMessage DISPLAY_CHANGE, mode:" + mode.toString());
                    TPScreenRefreshRateDetector.notifyScreenRefreshRateChange(display.getMode().getRefreshRate());
                }
                super.handleMessage(message);
            }
        };
    }

    /* access modifiers changed from: private */
    public static void notifyScreenRefreshRateChange(float f11) {
        boolean z11;
        if (Math.abs(f11 - mCurScreenRefreshRate) >= 1.0f) {
            String str = TAG;
            TPNativeLog.printLog(2, str, "notifyScreenRefreshRateChange Change From " + mCurScreenRefreshRate + " to " + f11);
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            mCurScreenRefreshRate = f11;
            synchronized (TPScreenRefreshRateDetector.class) {
                for (ScreenRefreshRateChangedListener onScreenRefreshRateChanged : listeners) {
                    onScreenRefreshRateChanged.onScreenRefreshRateChanged(f11);
                }
            }
        }
    }

    public static void removeListener(ScreenRefreshRateChangedListener screenRefreshRateChangedListener) {
        synchronized (TPScreenRefreshRateDetector.class) {
            listeners.remove(screenRefreshRateChangedListener);
        }
    }
}
