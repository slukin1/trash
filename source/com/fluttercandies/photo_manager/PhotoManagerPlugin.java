package com.fluttercandies.photo_manager;

import android.app.Activity;
import com.fluttercandies.photo_manager.permission.PermissionsUtils;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.jvm.internal.r;

public final class PhotoManagerPlugin implements FlutterPlugin, ActivityAware {

    /* renamed from: f  reason: collision with root package name */
    public static final a f65009f = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public com.fluttercandies.photo_manager.core.PhotoManagerPlugin f65010b;

    /* renamed from: c  reason: collision with root package name */
    public final PermissionsUtils f65011c = new PermissionsUtils();

    /* renamed from: d  reason: collision with root package name */
    public ActivityPluginBinding f65012d;

    /* renamed from: e  reason: collision with root package name */
    public PluginRegistry.RequestPermissionsResultListener f65013e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static final boolean c(PermissionsUtils permissionsUtils, int i11, String[] strArr, int[] iArr) {
            permissionsUtils.b(i11, strArr, iArr);
            return false;
        }

        public final PluginRegistry.RequestPermissionsResultListener b(PermissionsUtils permissionsUtils) {
            return new w4.a(permissionsUtils);
        }

        public final void d(com.fluttercandies.photo_manager.core.PhotoManagerPlugin photoManagerPlugin, BinaryMessenger binaryMessenger) {
            new MethodChannel(binaryMessenger, "com.fluttercandies/photo_manager").setMethodCallHandler(photoManagerPlugin);
        }
    }

    public final void a(ActivityPluginBinding activityPluginBinding) {
        ActivityPluginBinding activityPluginBinding2 = this.f65012d;
        if (activityPluginBinding2 != null) {
            c(activityPluginBinding2);
        }
        this.f65012d = activityPluginBinding;
        com.fluttercandies.photo_manager.core.PhotoManagerPlugin photoManagerPlugin = this.f65010b;
        if (photoManagerPlugin != null) {
            photoManagerPlugin.i(activityPluginBinding.getActivity());
        }
        b(activityPluginBinding);
    }

    public final void b(ActivityPluginBinding activityPluginBinding) {
        PluginRegistry.RequestPermissionsResultListener b11 = f65009f.b(this.f65011c);
        this.f65013e = b11;
        activityPluginBinding.addRequestPermissionsResultListener(b11);
        com.fluttercandies.photo_manager.core.PhotoManagerPlugin photoManagerPlugin = this.f65010b;
        if (photoManagerPlugin != null) {
            activityPluginBinding.addActivityResultListener(photoManagerPlugin.j());
        }
    }

    public final void c(ActivityPluginBinding activityPluginBinding) {
        PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener = this.f65013e;
        if (requestPermissionsResultListener != null) {
            activityPluginBinding.removeRequestPermissionsResultListener(requestPermissionsResultListener);
        }
        com.fluttercandies.photo_manager.core.PhotoManagerPlugin photoManagerPlugin = this.f65010b;
        if (photoManagerPlugin != null) {
            activityPluginBinding.removeActivityResultListener(photoManagerPlugin.j());
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        a(activityPluginBinding);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        com.fluttercandies.photo_manager.core.PhotoManagerPlugin photoManagerPlugin = new com.fluttercandies.photo_manager.core.PhotoManagerPlugin(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger(), (Activity) null, this.f65011c);
        f65009f.d(photoManagerPlugin, flutterPluginBinding.getBinaryMessenger());
        this.f65010b = photoManagerPlugin;
    }

    public void onDetachedFromActivity() {
        ActivityPluginBinding activityPluginBinding = this.f65012d;
        if (activityPluginBinding != null) {
            c(activityPluginBinding);
        }
        com.fluttercandies.photo_manager.core.PhotoManagerPlugin photoManagerPlugin = this.f65010b;
        if (photoManagerPlugin != null) {
            photoManagerPlugin.i((Activity) null);
        }
        this.f65012d = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        com.fluttercandies.photo_manager.core.PhotoManagerPlugin photoManagerPlugin = this.f65010b;
        if (photoManagerPlugin != null) {
            photoManagerPlugin.i((Activity) null);
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f65010b = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        a(activityPluginBinding);
    }
}
