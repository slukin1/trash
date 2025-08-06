package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import io.flutter.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.a;
import java.nio.ByteBuffer;
import java.util.List;

@Deprecated
public class FlutterNativeView implements BinaryMessenger {
    private static final String TAG = "FlutterNativeView";
    private boolean applicationIsRunning;
    private final DartExecutor dartExecutor;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private final Context mContext;
    private final FlutterJNI mFlutterJNI;
    /* access modifiers changed from: private */
    public FlutterView mFlutterView;
    /* access modifiers changed from: private */
    public final FlutterPluginRegistry mPluginRegistry;

    public final class EngineLifecycleListenerImpl implements FlutterEngine.EngineLifecycleListener {
        private EngineLifecycleListenerImpl() {
        }

        public void onEngineWillDestroy() {
        }

        public void onPreEngineRestart() {
            if (FlutterNativeView.this.mFlutterView != null) {
                FlutterNativeView.this.mFlutterView.resetAccessibilityTree();
            }
            if (FlutterNativeView.this.mPluginRegistry != null) {
                FlutterNativeView.this.mPluginRegistry.onPreEngineRestart();
            }
        }
    }

    public FlutterNativeView(Context context) {
        this(context, false);
    }

    private void attach(FlutterNativeView flutterNativeView) {
        this.mFlutterJNI.attachToNative();
        this.dartExecutor.onAttachedToJNI();
    }

    public static String getObservatoryUri() {
        return FlutterJNI.getObservatoryUri();
    }

    public void assertAttached() {
        if (!isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public void attachViewAndActivity(FlutterView flutterView, Activity activity) {
        this.mFlutterView = flutterView;
        this.mPluginRegistry.attach(flutterView, activity);
    }

    public void destroy() {
        this.mPluginRegistry.destroy();
        this.dartExecutor.onDetachedFromJNI();
        this.mFlutterView = null;
        this.mFlutterJNI.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        this.mFlutterJNI.detachFromNativeAndReleaseResources();
        this.applicationIsRunning = false;
    }

    public void detachFromFlutterView() {
        this.mPluginRegistry.detach();
        this.mFlutterView = null;
    }

    public void disableBufferingIncomingMessages() {
    }

    public void enableBufferingIncomingMessages() {
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public FlutterJNI getFlutterJNI() {
        return this.mFlutterJNI;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.mPluginRegistry;
    }

    public boolean isApplicationRunning() {
        return this.applicationIsRunning;
    }

    public boolean isAttached() {
        return this.mFlutterJNI.isAttached();
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return a.c(this);
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return this.dartExecutor.getBinaryMessenger().makeBackgroundTaskQueue(taskQueueOptions);
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        if (flutterRunArguments.entrypoint != null) {
            assertAttached();
            if (!this.applicationIsRunning) {
                this.mFlutterJNI.runBundleAndSnapshotFromLibrary(flutterRunArguments.bundlePath, flutterRunArguments.entrypoint, flutterRunArguments.libraryPath, this.mContext.getResources().getAssets(), (List<String>) null);
                this.applicationIsRunning = true;
                return;
            }
            throw new AssertionError("This Flutter engine instance is already running an application");
        }
        throw new AssertionError("An entrypoint must be specified");
    }

    public void send(String str, ByteBuffer byteBuffer) {
        this.dartExecutor.getBinaryMessenger().send(str, byteBuffer);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.dartExecutor.getBinaryMessenger().setMessageHandler(str, binaryMessageHandler);
    }

    public FlutterNativeView(Context context, boolean z11) {
        AnonymousClass1 r02 = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                if (FlutterNativeView.this.mFlutterView != null) {
                    FlutterNativeView.this.mFlutterView.onFirstFrame();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.flutterUiDisplayListener = r02;
        if (z11) {
            Log.w(TAG, "'isBackgroundView' is no longer supported and will be ignored");
        }
        this.mContext = context;
        this.mPluginRegistry = new FlutterPluginRegistry(this, context);
        FlutterJNI flutterJNI = new FlutterJNI();
        this.mFlutterJNI = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(r02);
        this.dartExecutor = new DartExecutor(flutterJNI, context.getAssets());
        flutterJNI.addEngineLifecycleListener(new EngineLifecycleListenerImpl());
        attach(this);
        assertAttached();
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        if (!isAttached()) {
            Log.d(TAG, "FlutterView.send called on a detached view, channel=" + str);
            return;
        }
        this.dartExecutor.getBinaryMessenger().send(str, byteBuffer, binaryReply);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        this.dartExecutor.getBinaryMessenger().setMessageHandler(str, binaryMessageHandler, taskQueue);
    }
}
