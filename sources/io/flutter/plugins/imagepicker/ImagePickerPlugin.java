package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;

public class ImagePickerPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    private static final int CAMERA_DEVICE_FRONT = 1;
    private static final int CAMERA_DEVICE_REAR = 0;
    private static final String CHANNEL = "plugins.flutter.io/image_picker";
    public static final String METHOD_CALL_IMAGE = "pickImage";
    public static final String METHOD_CALL_MULTI_IMAGE = "pickMultiImage";
    private static final String METHOD_CALL_RETRIEVE = "retrieve";
    public static final String METHOD_CALL_VIDEO = "pickVideo";
    private static final int SOURCE_CAMERA = 0;
    private static final int SOURCE_GALLERY = 1;
    private Activity activity;
    private ActivityPluginBinding activityBinding;
    private Application application;
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public ImagePickerDelegate delegate;
    private Lifecycle lifecycle;
    private LifeCycleObserver observer;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;

    public class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
        private final Activity thisActivity;

        public LifeCycleObserver(Activity activity) {
            this.thisActivity = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.thisActivity == activity && activity.getApplicationContext() != null) {
                ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
            if (this.thisActivity == activity) {
                ImagePickerPlugin.this.delegate.saveStateBeforeResult();
            }
        }

        public void onCreate(LifecycleOwner lifecycleOwner) {
        }

        public void onDestroy(LifecycleOwner lifecycleOwner) {
            onActivityDestroyed(this.thisActivity);
        }

        public void onPause(LifecycleOwner lifecycleOwner) {
        }

        public void onResume(LifecycleOwner lifecycleOwner) {
        }

        public void onStart(LifecycleOwner lifecycleOwner) {
        }

        public void onStop(LifecycleOwner lifecycleOwner) {
            onActivityStopped(this.thisActivity);
        }
    }

    public static class MethodResultWrapper implements MethodChannel.Result {
        private Handler handler = new Handler(Looper.getMainLooper());
        /* access modifiers changed from: private */
        public MethodChannel.Result methodResult;

        public MethodResultWrapper(MethodChannel.Result result) {
            this.methodResult = result;
        }

        public void error(final String str, final String str2, final Object obj) {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.error(str, str2, obj);
                }
            });
        }

        public void notImplemented() {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.notImplemented();
                }
            });
        }

        public void success(final Object obj) {
            this.handler.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.methodResult.success(obj);
                }
            });
        }
    }

    public ImagePickerPlugin() {
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        if (registrar.activity() != null) {
            Activity activity2 = registrar.activity();
            Application application2 = null;
            if (registrar.context() != null) {
                application2 = (Application) registrar.context().getApplicationContext();
            }
            new ImagePickerPlugin().setup(registrar.messenger(), application2, activity2, registrar, (ActivityPluginBinding) null);
        }
    }

    private void setup(BinaryMessenger binaryMessenger, Application application2, Activity activity2, PluginRegistry.Registrar registrar, ActivityPluginBinding activityPluginBinding) {
        this.activity = activity2;
        this.application = application2;
        this.delegate = constructDelegate(activity2);
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity2);
        this.observer = lifeCycleObserver;
        if (registrar != null) {
            application2.registerActivityLifecycleCallbacks(lifeCycleObserver);
            registrar.addActivityResultListener(this.delegate);
            registrar.addRequestPermissionsResultListener(this.delegate);
            return;
        }
        activityPluginBinding.addActivityResultListener(this.delegate);
        activityPluginBinding.addRequestPermissionsResultListener(this.delegate);
        Lifecycle activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
        this.lifecycle = activityLifecycle;
        activityLifecycle.a(this.observer);
    }

    private void tearDown() {
        this.activityBinding.removeActivityResultListener(this.delegate);
        this.activityBinding.removeRequestPermissionsResultListener(this.delegate);
        this.activityBinding = null;
        this.lifecycle.d(this.observer);
        this.lifecycle = null;
        this.delegate = null;
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
        this.application.unregisterActivityLifecycleCallbacks(this.observer);
        this.application = null;
    }

    public final ImagePickerDelegate constructDelegate(Activity activity2) {
        ImagePickerCache imagePickerCache = new ImagePickerCache(activity2);
        File cacheDir = activity2.getCacheDir();
        return new ImagePickerDelegate(activity2, cacheDir, new ImageResizer(cacheDir, new ExifDataCopier()), imagePickerCache);
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activityBinding = activityPluginBinding;
        setup(this.pluginBinding.getBinaryMessenger(), (Application) this.pluginBinding.getApplicationContext(), this.activityBinding.getActivity(), (PluginRegistry.Registrar) null, this.activityBinding);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
    }

    public void onDetachedFromActivity() {
        tearDown();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        CameraDevice cameraDevice;
        if (this.activity == null) {
            result.error("no_activity", "image_picker plugin requires a foreground activity.", (Object) null);
            return;
        }
        MethodResultWrapper methodResultWrapper = new MethodResultWrapper(result);
        if (methodCall.argument("cameraDevice") != null) {
            if (((Integer) methodCall.argument("cameraDevice")).intValue() == 1) {
                cameraDevice = CameraDevice.FRONT;
            } else {
                cameraDevice = CameraDevice.REAR;
            }
            this.delegate.setCameraDevice(cameraDevice);
        }
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1708939613:
                if (str.equals(METHOD_CALL_MULTI_IMAGE)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1457314374:
                if (str.equals(METHOD_CALL_IMAGE)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1445424934:
                if (str.equals(METHOD_CALL_VIDEO)) {
                    c11 = 2;
                    break;
                }
                break;
            case -310034372:
                if (str.equals(METHOD_CALL_RETRIEVE)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.delegate.chooseMultiImageFromGallery(methodCall, methodResultWrapper);
                return;
            case 1:
                int intValue = ((Integer) methodCall.argument("source")).intValue();
                if (intValue == 0) {
                    this.delegate.takeImageWithCamera(methodCall, methodResultWrapper);
                    return;
                } else if (intValue == 1) {
                    this.delegate.chooseImageFromGallery(methodCall, methodResultWrapper);
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid image source: " + intValue);
                }
            case 2:
                int intValue2 = ((Integer) methodCall.argument("source")).intValue();
                if (intValue2 == 0) {
                    this.delegate.takeVideoWithCamera(methodCall, methodResultWrapper);
                    return;
                } else if (intValue2 == 1) {
                    this.delegate.chooseVideoFromGallery(methodCall, methodResultWrapper);
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid video source: " + intValue2);
                }
            case 3:
                this.delegate.retrieveLostImage(methodResultWrapper);
                return;
            default:
                throw new IllegalArgumentException("Unknown method " + methodCall.method);
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }

    public ImagePickerPlugin(ImagePickerDelegate imagePickerDelegate, Activity activity2) {
        this.delegate = imagePickerDelegate;
        this.activity = activity2;
    }
}
