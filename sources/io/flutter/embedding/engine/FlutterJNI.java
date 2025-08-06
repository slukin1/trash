package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.Keep;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.Preconditions;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.FlutterCallbackInformation;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Keep
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = null;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static String observatoryUri = null;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private AccessibilityDelegate accessibilityDelegate;
    private DeferredComponentManager deferredComponentManager;
    private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private LocalizationPlugin localizationPlugin;
    private final Looper mainLooper = Looper.getMainLooper();
    private Long nativeShellHolderId;
    private PlatformMessageHandler platformMessageHandler;
    private PlatformViewsController platformViewsController;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();

    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr);

        void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr);
    }

    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j11);
    }

    public static class Factory {
        public FlutterJNI provideFlutterJNI() {
            return new FlutterJNI();
        }
    }

    private static void asyncWaitForVsync(long j11) {
        AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2 = asyncWaitForVsyncDelegate;
        if (asyncWaitForVsyncDelegate2 != null) {
            asyncWaitForVsyncDelegate2.asyncWaitForVsync(j11);
            return;
        }
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    public static Bitmap decodeImage(ByteBuffer byteBuffer, long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new a(j11));
            } catch (IOException e11) {
                Log.e(TAG, "Failed to decode image", e11);
            }
        }
        return null;
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() != this.mainLooper) {
            throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
        }
    }

    public static String getObservatoryUri() {
        return observatoryUri;
    }

    private void handlePlatformMessageResponse(int i11, ByteBuffer byteBuffer) {
        PlatformMessageHandler platformMessageHandler2 = this.platformMessageHandler;
        if (platformMessageHandler2 != null) {
            platformMessageHandler2.handlePlatformMessageResponse(i11, byteBuffer);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$decodeImage$0(long j11, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        imageDecoder.setAllocator(1);
        Size size = imageInfo.getSize();
        nativeImageHeaderCallback(j11, size.getWidth(), size.getHeight());
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j11);

    private native void nativeDeferredComponentInstallFailure(int i11, String str, boolean z11);

    private native void nativeDestroy(long j11);

    private native void nativeDispatchEmptyPlatformMessage(long j11, String str, int i11);

    private native void nativeDispatchPlatformMessage(long j11, String str, ByteBuffer byteBuffer, int i11, int i12);

    private native void nativeDispatchPointerDataPacket(long j11, ByteBuffer byteBuffer, int i11);

    private native void nativeDispatchSemanticsAction(long j11, int i11, int i12, ByteBuffer byteBuffer, int i13);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i11);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i11);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i11);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i11);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i11);

    private native Bitmap nativeGetBitmap(long j11);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j11, int i11, int i12);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j11);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j11, int i11);

    private native void nativeInvokePlatformMessageResponseCallback(long j11, int i11, ByteBuffer byteBuffer, int i12);

    private native void nativeLoadDartDeferredLibrary(long j11, int i11, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j11);

    private native void nativeMarkTextureFrameAvailable(long j11, long j12);

    private native void nativeNotifyLowMemoryWarning(long j11);

    private native void nativeOnVsync(long j11, long j12, long j13);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterTexture(long j11, long j12, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j11, String str, String str2, String str3, AssetManager assetManager, List<String> list);

    private native void nativeSetAccessibilityFeatures(long j11, int i11);

    private native void nativeSetSemanticsEnabled(long j11, boolean z11);

    private native void nativeSetViewportMetrics(long j11, float f11, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int[] iArr, int[] iArr2, int[] iArr3);

    private native FlutterJNI nativeSpawn(long j11, String str, String str2, String str3, List<String> list);

    private native void nativeSurfaceChanged(long j11, int i11, int i12);

    private native void nativeSurfaceCreated(long j11, Surface surface);

    private native void nativeSurfaceDestroyed(long j11);

    private native void nativeSurfaceWindowChanged(long j11, Surface surface);

    private native void nativeUnregisterTexture(long j11, long j12);

    private native void nativeUpdateJavaAssetManager(long j11, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f11);

    private void onPreEngineRestart() {
        for (FlutterEngine.EngineLifecycleListener onPreEngineRestart : this.engineLifecycleListeners) {
            onPreEngineRestart.onPreEngineRestart();
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate2 = this.accessibilityDelegate;
        if (accessibilityDelegate2 != null) {
            accessibilityDelegate2.updateCustomAccessibilityActions(byteBuffer, strArr);
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate2 = this.accessibilityDelegate;
        if (accessibilityDelegate2 != null) {
            accessibilityDelegate2.updateSemantics(byteBuffer, strArr, byteBufferArr);
        }
    }

    public void addEngineLifecycleListener(FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j11) {
        nativeCleanupMessageData(j11);
    }

    public String[] computePlatformResolvedLocale(String[] strArr) {
        if (this.localizationPlugin == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < strArr.length; i11 += 3) {
            String str = strArr[i11 + 0];
            String str2 = strArr[i11 + 1];
            String str3 = strArr[i11 + 2];
            if (Build.VERSION.SDK_INT >= 21) {
                Locale.Builder builder = new Locale.Builder();
                if (!str.isEmpty()) {
                    builder.setLanguage(str);
                }
                if (!str2.isEmpty()) {
                    builder.setRegion(str2);
                }
                if (!str3.isEmpty()) {
                    builder.setScript(str3);
                }
                arrayList.add(builder.build());
            } else {
                arrayList.add(new Locale(str, str2));
            }
        }
        Locale resolveNativeLocale = this.localizationPlugin.resolveNativeLocale(arrayList);
        if (resolveNativeLocale == null) {
            return new String[0];
        }
        String[] strArr2 = new String[3];
        strArr2[0] = resolveNativeLocale.getLanguage();
        strArr2[1] = resolveNativeLocale.getCountry();
        if (Build.VERSION.SDK_INT >= 21) {
            strArr2[2] = resolveNativeLocale.getScript();
        } else {
            strArr2[2] = "";
        }
        return strArr2;
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            return platformViewsController2.createOverlaySurface();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void deferredComponentInstallFailure(int i11, String str, boolean z11) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i11, str, z11);
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.destroyOverlaySurfaces();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i11) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i11);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i11);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i11, int i12) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i11, i12);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i12);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i11);
    }

    public void dispatchSemanticsAction(int i11, AccessibilityBridge.Action action) {
        dispatchSemanticsAction(i11, action, (Object) null);
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i11, long j11) {
        PlatformMessageHandler platformMessageHandler2 = this.platformMessageHandler;
        if (platformMessageHandler2 != null) {
            platformMessageHandler2.handleMessageFromDart(str, byteBuffer, i11, j11);
        } else {
            nativeCleanupMessageData(j11);
        }
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j11) {
        if (initCalled) {
            Log.w(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j11);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i11) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i11);
            } else {
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i11);
            }
        } finally {
            this.shellHolderLock.readLock().unlock();
        }
    }

    public void invokePlatformMessageResponseCallback(int i11, ByteBuffer byteBuffer, int i12) {
        if (byteBuffer.isDirect()) {
            this.shellHolderLock.readLock().lock();
            try {
                if (isAttached()) {
                    nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i11, byteBuffer, i12);
                } else {
                    Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i11);
                }
            } finally {
                this.shellHolderLock.readLock().unlock();
            }
        } else {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i11) {
        return nativeFlutterTextUtilsIsEmoji(i11);
    }

    public boolean isCodePointEmojiModifier(int i11) {
        return nativeFlutterTextUtilsIsEmojiModifier(i11);
    }

    public boolean isCodePointEmojiModifierBase(int i11) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i11);
    }

    public boolean isCodePointRegionalIndicator(int i11) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i11);
    }

    public boolean isCodePointVariantSelector(int i11) {
        return nativeFlutterTextUtilsIsVariationSelector(i11);
    }

    public void loadDartDeferredLibrary(int i11, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i11, strArr);
    }

    public void loadLibrary() {
        if (loadLibraryCalled) {
            Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        System.loadLibrary("flutter");
        loadLibraryCalled = true;
    }

    public void markTextureFrameAvailable(long j11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j11);
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onBeginFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
    }

    public void onDisplayOverlaySurface(int i11, int i12, int i13, int i14, int i15) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onDisplayOverlaySurface(i11, i12, i13, i14, i15);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void onDisplayPlatformView(int i11, int i12, int i13, int i14, int i15, int i16, int i17, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onDisplayPlatformView(i11, i12, i13, i14, i15, i16, i17, flutterMutatorsStack);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
    }

    public void onEndFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onEndFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener onFlutterUiDisplayed : this.flutterUiDisplayListeners) {
            onFlutterUiDisplayed.onFlutterUiDisplayed();
        }
    }

    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : this.flutterUiDisplayListeners) {
            onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
        }
    }

    public void onSurfaceChanged(int i11, int i12) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i11, i12);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j11, long j12, long j13) {
        nativeOnVsync(j11, j12, j13);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerTexture(long j11, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j11, new WeakReference(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    public void requestDartDeferredLibrary(int i11) {
        DeferredComponentManager deferredComponentManager2 = this.deferredComponentManager;
        if (deferredComponentManager2 != null) {
            deferredComponentManager2.installDeferredComponent(i11, (String) null);
        } else {
            Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
        }
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list);
    }

    public void setAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate2) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = accessibilityDelegate2;
    }

    public void setAccessibilityFeatures(int i11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i11);
    }

    public void setAsyncWaitForVsyncDelegate(AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2) {
        asyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate2;
    }

    public void setDeferredComponentManager(DeferredComponentManager deferredComponentManager2) {
        ensureRunningOnMainThread();
        this.deferredComponentManager = deferredComponentManager2;
        if (deferredComponentManager2 != null) {
            deferredComponentManager2.setJNI(this);
        }
    }

    public void setLocalizationPlugin(LocalizationPlugin localizationPlugin2) {
        ensureRunningOnMainThread();
        this.localizationPlugin = localizationPlugin2;
    }

    public void setPlatformMessageHandler(PlatformMessageHandler platformMessageHandler2) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = platformMessageHandler2;
    }

    public void setPlatformViewsController(PlatformViewsController platformViewsController2) {
        ensureRunningOnMainThread();
        this.platformViewsController = platformViewsController2;
    }

    public void setRefreshRateFPS(float f11) {
        refreshRateFPS = f11;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z11);
    }

    public void setViewportMetrics(float f11, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int[] iArr, int[] iArr2, int[] iArr3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f11, i11, i12, i13, i14, i15, i16, i17, i18, i19, i21, i22, i23, i24, i25, i26, iArr, iArr2, iArr3);
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list);
        Long l11 = nativeSpawn.nativeShellHolderId;
        Preconditions.checkState((l11 == null || l11.longValue() == 0) ? false : true, "Failed to spawn new JNI connected shell from existing shell.");
        return nativeSpawn;
    }

    public void unregisterTexture(long j11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j11);
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }

    public void dispatchSemanticsAction(int i11, AccessibilityBridge.Action action, Object obj) {
        ByteBuffer byteBuffer;
        int i12;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = StandardMessageCodec.INSTANCE.encodeMessage(obj);
            i12 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i12 = 0;
        }
        dispatchSemanticsAction(i11, action.value, byteBuffer, i12);
    }

    public void dispatchSemanticsAction(int i11, int i12, ByteBuffer byteBuffer, int i13) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i11, i12, byteBuffer, i13);
    }
}
