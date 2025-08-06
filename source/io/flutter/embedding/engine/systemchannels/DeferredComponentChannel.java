package io.flutter.embedding.engine.systemchannels;

import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeferredComponentChannel {
    private static final String TAG = "DeferredComponentChannel";
    private final MethodChannel channel;
    /* access modifiers changed from: private */
    public Map<String, List<MethodChannel.Result>> componentNameToResults = new HashMap();
    /* access modifiers changed from: private */
    public DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
    public final MethodChannel.MethodCallHandler parsingMethodHandler;

    public DeferredComponentChannel(DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (DeferredComponentChannel.this.deferredComponentManager != null) {
                    String str = methodCall.method;
                    Map map = (Map) methodCall.arguments();
                    Log.v(DeferredComponentChannel.TAG, "Received '" + str + "' message.");
                    int intValue = ((Integer) map.get("loadingUnitId")).intValue();
                    String str2 = (String) map.get("componentName");
                    str.hashCode();
                    char c11 = 65535;
                    switch (str.hashCode()) {
                        case -1004447972:
                            if (str.equals("uninstallDeferredComponent")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case 399701758:
                            if (str.equals("getDeferredComponentInstallState")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case 520962947:
                            if (str.equals("installDeferredComponent")) {
                                c11 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            DeferredComponentChannel.this.deferredComponentManager.uninstallDeferredComponent(intValue, str2);
                            result.success((Object) null);
                            return;
                        case 1:
                            result.success(DeferredComponentChannel.this.deferredComponentManager.getDeferredComponentInstallState(intValue, str2));
                            return;
                        case 2:
                            DeferredComponentChannel.this.deferredComponentManager.installDeferredComponent(intValue, str2);
                            if (!DeferredComponentChannel.this.componentNameToResults.containsKey(str2)) {
                                DeferredComponentChannel.this.componentNameToResults.put(str2, new ArrayList());
                            }
                            ((List) DeferredComponentChannel.this.componentNameToResults.get(str2)).add(result);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.parsingMethodHandler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/deferredcomponent", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void completeInstallError(String str, String str2) {
        if (this.componentNameToResults.containsKey(str)) {
            for (MethodChannel.Result error : this.componentNameToResults.get(str)) {
                error.error("DeferredComponent Install failure", str2, (Object) null);
            }
            this.componentNameToResults.get(str).clear();
        }
    }

    public void completeInstallSuccess(String str) {
        if (this.componentNameToResults.containsKey(str)) {
            for (MethodChannel.Result success : this.componentNameToResults.get(str)) {
                success.success((Object) null);
            }
            this.componentNameToResults.get(str).clear();
        }
    }

    public void setDeferredComponentManager(DeferredComponentManager deferredComponentManager2) {
        this.deferredComponentManager = deferredComponentManager2;
    }
}
