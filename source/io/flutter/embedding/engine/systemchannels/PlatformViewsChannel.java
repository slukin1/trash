package io.flutter.embedding.engine.systemchannels;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.android.tpush.common.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlatformViewsChannel {
    private static final String TAG = "PlatformViewsChannel";
    private final MethodChannel channel;
    /* access modifiers changed from: private */
    public PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler;

    public interface PlatformViewBufferResized {
        void run(PlatformViewBufferSize platformViewBufferSize);
    }

    public static class PlatformViewBufferSize {
        public final int height;
        public final int width;

        public PlatformViewBufferSize(int i11, int i12) {
            this.width = i11;
            this.height = i12;
        }
    }

    public static class PlatformViewCreationRequest {
        public final int direction;
        public final RequestedDisplayMode displayMode;
        public final double logicalHeight;
        public final double logicalLeft;
        public final double logicalTop;
        public final double logicalWidth;
        public final ByteBuffer params;
        public final int viewId;
        public final String viewType;

        public enum RequestedDisplayMode {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public PlatformViewCreationRequest(int i11, String str, double d11, double d12, double d13, double d14, int i12, ByteBuffer byteBuffer) {
            this(i11, str, d11, d12, d13, d14, i12, RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBuffer);
        }

        public PlatformViewCreationRequest(int i11, String str, double d11, double d12, double d13, double d14, int i12, RequestedDisplayMode requestedDisplayMode, ByteBuffer byteBuffer) {
            this.viewId = i11;
            this.viewType = str;
            this.logicalTop = d11;
            this.logicalLeft = d12;
            this.logicalWidth = d13;
            this.logicalHeight = d14;
            this.direction = i12;
            this.displayMode = requestedDisplayMode;
            this.params = byteBuffer;
        }
    }

    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i11, double d11, double d12) {
            this.viewId = i11;
            this.newLogicalWidth = d11;
            this.newLogicalHeight = d12;
        }
    }

    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;
        public final Number downTime;
        public final int edgeFlags;
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;
        public final Object rawPointerCoords;
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int i11, Number number, Number number2, int i12, int i13, Object obj, Object obj2, int i14, int i15, float f11, float f12, int i16, int i17, int i18, int i19, long j11) {
            this.viewId = i11;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i12;
            this.pointerCount = i13;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i14;
            this.buttonState = i15;
            this.xPrecision = f11;
            this.yPrecision = f12;
            this.deviceId = i16;
            this.edgeFlags = i17;
            this.source = i18;
            this.flags = i19;
            this.motionEventId = j11;
        }
    }

    public interface PlatformViewsHandler {
        public static final long NON_TEXTURE_FALLBACK = -2;

        void clearFocus(int i11);

        void createForPlatformViewLayer(PlatformViewCreationRequest platformViewCreationRequest);

        long createForTextureLayer(PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i11);

        void offset(int i11, double d11, double d12);

        void onTouch(PlatformViewTouch platformViewTouch);

        void resize(PlatformViewResizeRequest platformViewResizeRequest, PlatformViewBufferResized platformViewBufferResized);

        void setDirection(int i11, int i12);

        void synchronizeToNativeViewHierarchy(boolean z11);
    }

    public PlatformViewsChannel(DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            private void clearFocus(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                    result.success((Object) null);
                } catch (IllegalStateException e11) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e11), (Object) null);
                }
            }

            private void create(MethodCall methodCall, MethodChannel.Result result) {
                PlatformViewCreationRequest.RequestedDisplayMode requestedDisplayMode;
                MethodChannel.Result result2 = result;
                Map map = (Map) methodCall.arguments();
                boolean z11 = true;
                boolean z12 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
                ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
                if (z12) {
                    try {
                        PlatformViewsChannel.this.handler.createForPlatformViewLayer(new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue(), PlatformViewCreationRequest.RequestedDisplayMode.HYBRID_ONLY, wrap));
                        result2.success((Object) null);
                    } catch (IllegalStateException e11) {
                        result2.error("error", PlatformViewsChannel.detailedExceptionString(e11), (Object) null);
                    }
                } else {
                    if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                        z11 = false;
                    }
                    if (z11) {
                        requestedDisplayMode = PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK;
                    } else {
                        requestedDisplayMode = PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK;
                    }
                    PlatformViewCreationRequest.RequestedDisplayMode requestedDisplayMode2 = requestedDisplayMode;
                    int intValue = ((Integer) map.get("id")).intValue();
                    String str = (String) map.get("viewType");
                    double d11 = 0.0d;
                    double doubleValue = map.containsKey(ViewHierarchyConstants.DIMENSION_TOP_KEY) ? ((Double) map.get(ViewHierarchyConstants.DIMENSION_TOP_KEY)).doubleValue() : 0.0d;
                    if (map.containsKey("left")) {
                        d11 = ((Double) map.get("left")).doubleValue();
                    }
                    long createForTextureLayer = PlatformViewsChannel.this.handler.createForTextureLayer(new PlatformViewCreationRequest(intValue, str, doubleValue, d11, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue(), requestedDisplayMode2, wrap));
                    if (createForTextureLayer != -2) {
                        result2.success(Long.valueOf(createForTextureLayer));
                    } else if (z11) {
                        result2.success((Object) null);
                    } else {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                }
            }

            private void dispose(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get("id")).intValue());
                    result.success((Object) null);
                } catch (IllegalStateException e11) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e11), (Object) null);
                }
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ void lambda$resize$0(MethodChannel.Result result, PlatformViewBufferSize platformViewBufferSize) {
                if (platformViewBufferSize == null) {
                    result.error("error", "Failed to resize the platform view", (Object) null);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("width", Double.valueOf((double) platformViewBufferSize.width));
                hashMap.put("height", Double.valueOf((double) platformViewBufferSize.height));
                result.success(hashMap);
            }

            private void offset(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.offset(((Integer) map.get("id")).intValue(), ((Double) map.get(ViewHierarchyConstants.DIMENSION_TOP_KEY)).doubleValue(), ((Double) map.get("left")).doubleValue());
                    result.success((Object) null);
                } catch (IllegalStateException e11) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e11), (Object) null);
                }
            }

            private void resize(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.resize(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new b(result));
                } catch (IllegalStateException e11) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e11), (Object) null);
                }
            }

            private void setDirection(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue());
                    result.success((Object) null);
                } catch (IllegalStateException e11) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e11), (Object) null);
                }
            }

            private void synchronizeToNativeViewHierarchy(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel.this.handler.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                    result.success((Object) null);
                } catch (IllegalStateException e11) {
                    result.error("error", PlatformViewsChannel.detailedExceptionString(e11), (Object) null);
                }
            }

            private void touch(MethodCall methodCall, MethodChannel.Result result) {
                MethodChannel.Result result2;
                MethodChannel.Result result3 = result;
                List list = (List) methodCall.arguments();
                PlatformViewTouch platformViewTouch = r2;
                PlatformViewTouch platformViewTouch2 = platformViewTouch;
                PlatformViewTouch platformViewTouch3 = new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue());
                try {
                    PlatformViewsChannel.this.handler.onTouch(platformViewTouch);
                    result2 = result;
                    try {
                        result2.success((Object) null);
                    } catch (IllegalStateException e11) {
                        e = e11;
                    }
                } catch (IllegalStateException e12) {
                    e = e12;
                    result2 = result;
                    result2.error("error", PlatformViewsChannel.detailedExceptionString(e), (Object) null);
                }
            }

            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (PlatformViewsChannel.this.handler != null) {
                    Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
                    String str = methodCall.method;
                    str.hashCode();
                    char c11 = 65535;
                    switch (str.hashCode()) {
                        case -1352294148:
                            if (str.equals("create")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case -1019779949:
                            if (str.equals(Constants.FLAG_TAG_OFFSET)) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case -934437708:
                            if (str.equals("resize")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case -756050293:
                            if (str.equals("clearFocus")) {
                                c11 = 3;
                                break;
                            }
                            break;
                        case -308988850:
                            if (str.equals("synchronizeToNativeViewHierarchy")) {
                                c11 = 4;
                                break;
                            }
                            break;
                        case 110550847:
                            if (str.equals("touch")) {
                                c11 = 5;
                                break;
                            }
                            break;
                        case 576796989:
                            if (str.equals("setDirection")) {
                                c11 = 6;
                                break;
                            }
                            break;
                        case 1671767583:
                            if (str.equals("dispose")) {
                                c11 = 7;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            create(methodCall, result);
                            return;
                        case 1:
                            offset(methodCall, result);
                            return;
                        case 2:
                            resize(methodCall, result);
                            return;
                        case 3:
                            clearFocus(methodCall, result);
                            return;
                        case 4:
                            synchronizeToNativeViewHierarchy(methodCall, result);
                            return;
                        case 5:
                            touch(methodCall, result);
                            return;
                        case 6:
                            setDirection(methodCall, result);
                            return;
                        case 7:
                            dispose(methodCall, result);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.parsingHandler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    /* access modifiers changed from: private */
    public static String detailedExceptionString(Exception exc) {
        return Log.getStackTraceString(exc);
    }

    public void invokeViewFocused(int i11) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("viewFocused", Integer.valueOf(i11));
        }
    }

    public void setPlatformViewsHandler(PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}
