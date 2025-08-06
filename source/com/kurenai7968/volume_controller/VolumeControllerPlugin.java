package com.kurenai7968.volume_controller;

import android.content.Context;
import bx.a;
import bx.b;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.x;

public final class VolumeControllerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public final String f25171b = "com.kurenai7968.volume_controller.";

    /* renamed from: c  reason: collision with root package name */
    public Context f25172c;

    /* renamed from: d  reason: collision with root package name */
    public b f25173d;

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel f25174e;

    /* renamed from: f  reason: collision with root package name */
    public EventChannel f25175f;

    /* renamed from: g  reason: collision with root package name */
    public a f25176g;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        this.f25172c = applicationContext;
        a aVar = null;
        if (applicationContext == null) {
            applicationContext = null;
        }
        this.f25173d = new b(applicationContext);
        this.f25175f = new EventChannel(flutterPluginBinding.getBinaryMessenger(), this.f25171b + "volume_listener_event");
        Context context = this.f25172c;
        if (context == null) {
            context = null;
        }
        this.f25176g = new a(context);
        EventChannel eventChannel = this.f25175f;
        if (eventChannel == null) {
            eventChannel = null;
        }
        a aVar2 = this.f25176g;
        if (aVar2 != null) {
            aVar = aVar2;
        }
        eventChannel.setStreamHandler(aVar);
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), this.f25171b + "method");
        this.f25174e = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.f25174e;
        if (methodChannel == null) {
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        EventChannel eventChannel = this.f25175f;
        if (eventChannel == null) {
            eventChannel = null;
        }
        eventChannel.setStreamHandler((EventChannel.StreamHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        b bVar = null;
        if (x.b(str, "setVolume")) {
            double doubleValue = ((Number) methodCall.argument("volume")).doubleValue();
            boolean booleanValue = ((Boolean) methodCall.argument("showSystemUI")).booleanValue();
            b bVar2 = this.f25173d;
            if (bVar2 != null) {
                bVar = bVar2;
            }
            bVar.b(doubleValue, booleanValue);
        } else if (x.b(str, "getVolume")) {
            b bVar3 = this.f25173d;
            if (bVar3 != null) {
                bVar = bVar3;
            }
            result.success(Double.valueOf(bVar.a()));
        }
    }
}
