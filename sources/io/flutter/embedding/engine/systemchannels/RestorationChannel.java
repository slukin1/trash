package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.Map;

public class RestorationChannel {
    private static final String TAG = "RestorationChannel";
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public boolean engineHasProvidedData;
    /* access modifiers changed from: private */
    public boolean frameworkHasRequestedData;
    private final MethodChannel.MethodCallHandler handler;
    /* access modifiers changed from: private */
    public MethodChannel.Result pendingFrameworkRestorationChannelRequest;
    /* access modifiers changed from: private */
    public byte[] restorationData;
    public final boolean waitForRestorationData;

    public RestorationChannel(DartExecutor dartExecutor, boolean z11) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), z11);
    }

    /* access modifiers changed from: private */
    public Map<String, Object> packageData(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.ENABLED, Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void clearData() {
        this.restorationData = null;
    }

    public byte[] getRestorationData() {
        return this.restorationData;
    }

    public void setRestorationData(final byte[] bArr) {
        this.engineHasProvidedData = true;
        MethodChannel.Result result = this.pendingFrameworkRestorationChannelRequest;
        if (result != null) {
            result.success(packageData(bArr));
            this.pendingFrameworkRestorationChannelRequest = null;
            this.restorationData = bArr;
        } else if (this.frameworkHasRequestedData) {
            this.channel.invokeMethod(com.adjust.sdk.Constants.PUSH, packageData(bArr), new MethodChannel.Result() {
                public void error(String str, String str2, Object obj) {
                    Log.e(RestorationChannel.TAG, "Error " + str + " while sending restoration data to framework: " + str2);
                }

                public void notImplemented() {
                }

                public void success(Object obj) {
                    byte[] unused = RestorationChannel.this.restorationData = bArr;
                }
            });
        } else {
            this.restorationData = bArr;
        }
    }

    public RestorationChannel(MethodChannel methodChannel, boolean z11) {
        this.engineHasProvidedData = false;
        this.frameworkHasRequestedData = false;
        AnonymousClass2 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                str.hashCode();
                if (str.equals("get")) {
                    boolean unused = RestorationChannel.this.frameworkHasRequestedData = true;
                    if (!RestorationChannel.this.engineHasProvidedData) {
                        RestorationChannel restorationChannel = RestorationChannel.this;
                        if (restorationChannel.waitForRestorationData) {
                            MethodChannel.Result unused2 = restorationChannel.pendingFrameworkRestorationChannelRequest = result;
                            return;
                        }
                    }
                    RestorationChannel restorationChannel2 = RestorationChannel.this;
                    result.success(restorationChannel2.packageData(restorationChannel2.restorationData));
                } else if (!str.equals("put")) {
                    result.notImplemented();
                } else {
                    byte[] unused3 = RestorationChannel.this.restorationData = (byte[]) obj;
                    result.success((Object) null);
                }
            }
        };
        this.handler = r02;
        this.channel = methodChannel;
        this.waitForRestorationData = z11;
        methodChannel.setMethodCallHandler(r02);
    }
}
