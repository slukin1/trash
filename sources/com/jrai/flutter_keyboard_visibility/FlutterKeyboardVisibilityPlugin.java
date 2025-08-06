package com.jrai.flutter_keyboard_visibility;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

public class FlutterKeyboardVisibilityPlugin implements FlutterPlugin, ActivityAware, EventChannel.StreamHandler, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public EventChannel.EventSink f38885b;

    /* renamed from: c  reason: collision with root package name */
    public View f38886c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38887d;

    public final void a(BinaryMessenger binaryMessenger) {
        new EventChannel(binaryMessenger, "flutter_keyboard_visibility").setStreamHandler(this);
    }

    public final void b(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        this.f38886c = findViewById;
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final void c() {
        View view = this.f38886c;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f38886c = null;
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        b(activityPluginBinding.getActivity());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        a(flutterPluginBinding.getBinaryMessenger());
    }

    public void onCancel(Object obj) {
        this.f38885b = null;
    }

    public void onDetachedFromActivity() {
        c();
    }

    public void onDetachedFromActivityForConfigChanges() {
        c();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        c();
    }

    public void onGlobalLayout() {
        if (this.f38886c != null) {
            Rect rect = new Rect();
            this.f38886c.getWindowVisibleDisplayFrame(rect);
            boolean z11 = ((double) rect.height()) / ((double) this.f38886c.getRootView().getHeight()) < 0.85d;
            if (z11 != this.f38887d) {
                this.f38887d = z11;
                EventChannel.EventSink eventSink = this.f38885b;
                if (eventSink != null) {
                    eventSink.success(Integer.valueOf(z11 ? 1 : 0));
                }
            }
        }
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.f38885b = eventSink;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        b(activityPluginBinding.getActivity());
    }
}
