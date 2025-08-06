package com.sumsub.sns.internal.videoident.videoident.twilio;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.twilio.video.Camera2Capturer;
import com.twilio.video.CameraCapturer;
import com.twilio.video.VideoCapturer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import tvi.webrtc.Camera1Enumerator;
import tvi.webrtc.Camera2Enumerator;
import tvi.webrtc.CapturerObserver;
import tvi.webrtc.SurfaceTextureHelper;

public class CameraCapturerCompat implements VideoCapturer {

    /* renamed from: a  reason: collision with root package name */
    public CameraCapturer f37134a;

    /* renamed from: b  reason: collision with root package name */
    public Camera2Capturer f37135b;

    /* renamed from: c  reason: collision with root package name */
    public VideoCapturer f37136c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Source, String> f37137d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Source> f37138e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Map<Source, String> f37139f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, Source> f37140g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public CameraManager f37141h;

    /* renamed from: i  reason: collision with root package name */
    public CameraCapturer.Listener f37142i = new a();

    public enum Source {
        FRONT_CAMERA,
        BACK_CAMERA
    }

    public class a implements CameraCapturer.Listener {
        public a() {
        }

        public void onCameraSwitched(String str) {
        }

        public void onError(int i11) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "CameraCapturer.onError: " + i11, (Throwable) null);
        }

        public void onFirstFrameAvailable() {
        }
    }

    public boolean a(Context context, Source source) {
        if (a(context)) {
            this.f37141h = (CameraManager) context.getSystemService(OptionsBridge.CAMERA_KEY);
            b(context);
            String a11 = a(this.f37139f, source);
            if (a11 == null) {
                return false;
            }
            Camera2Capturer camera2Capturer = new Camera2Capturer(context, a11);
            this.f37135b = camera2Capturer;
            this.f37136c = camera2Capturer;
            this.f37134a = null;
            return true;
        }
        b();
        String a12 = a(this.f37137d, source);
        if (a12 == null) {
            return false;
        }
        CameraCapturer cameraCapturer = new CameraCapturer(context, a12, this.f37142i);
        this.f37134a = cameraCapturer;
        this.f37136c = cameraCapturer;
        this.f37135b = null;
        return true;
    }

    public final void b(Context context) {
        Camera2Enumerator camera2Enumerator = new Camera2Enumerator(context);
        for (String str : camera2Enumerator.getDeviceNames()) {
            if (a(str)) {
                if (camera2Enumerator.isFrontFacing(str)) {
                    Map<Source, String> map = this.f37139f;
                    Source source = Source.FRONT_CAMERA;
                    map.put(source, str);
                    this.f37140g.put(str, source);
                }
                if (camera2Enumerator.isBackFacing(str)) {
                    Map<Source, String> map2 = this.f37139f;
                    Source source2 = Source.BACK_CAMERA;
                    map2.put(source2, str);
                    this.f37140g.put(str, source2);
                }
            }
        }
    }

    public Source c() {
        String str;
        Source a11 = a();
        Map<String, Source> map = d() ? this.f37138e : this.f37140g;
        Map<Source, String> map2 = d() ? this.f37137d : this.f37139f;
        Source source = Source.FRONT_CAMERA;
        if (source == a11) {
            str = map2.get(Source.BACK_CAMERA);
        } else {
            str = map2.get(source);
        }
        if (str != null) {
            if (d()) {
                this.f37134a.switchCamera(str);
            } else {
                this.f37135b.switchCamera(str);
            }
        }
        return map.get(str);
    }

    public final boolean d() {
        return this.f37134a != null;
    }

    public void dispose() {
        this.f37136c.dispose();
    }

    public final boolean e() {
        return this.f37135b != null;
    }

    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.f37136c.initialize(surfaceTextureHelper, context, capturerObserver);
    }

    public boolean isScreencast() {
        return this.f37136c.isScreencast();
    }

    public void startCapture(int i11, int i12, int i13) {
        this.f37136c.startCapture(i11, i12, i13);
    }

    public void stopCapture() throws InterruptedException {
        this.f37136c.stopCapture();
    }

    public final void b() {
        Camera1Enumerator camera1Enumerator = new Camera1Enumerator();
        for (String str : camera1Enumerator.getDeviceNames()) {
            if (camera1Enumerator.isFrontFacing(str)) {
                Map<Source, String> map = this.f37137d;
                Source source = Source.FRONT_CAMERA;
                map.put(source, str);
                this.f37138e.put(str, source);
            }
            if (camera1Enumerator.isBackFacing(str)) {
                Map<Source, String> map2 = this.f37137d;
                Source source2 = Source.BACK_CAMERA;
                map2.put(source2, str);
                this.f37138e.put(str, source2);
            }
        }
    }

    public final boolean a(Context context) {
        return Camera2Capturer.isSupported(context) && Build.VERSION.SDK_INT > 21;
    }

    public final String a(Map<Source, String> map, Source source) {
        String str = map.get(source);
        if (str != null) {
            return str;
        }
        if (map.isEmpty()) {
            return null;
        }
        return (String) new LinkedList(map.values()).getFirst();
    }

    public Source a() {
        if (d()) {
            return this.f37138e.get(this.f37134a.getCameraId());
        }
        if (e()) {
            return this.f37140g.get(this.f37135b.getCameraId());
        }
        return null;
    }

    public final boolean a(String str) {
        try {
            CameraCharacteristics cameraCharacteristics = this.f37141h.getCameraCharacteristics(str);
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            boolean isOutputSupportedFor = (streamConfigurationMap == null || Build.VERSION.SDK_INT < 23) ? false : streamConfigurationMap.isOutputSupportedFor(34);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT);
            boolean z11 = Build.VERSION.SDK_INT >= 29 && num != null && (num.intValue() == 5 || num.intValue() == 6);
            if (!isOutputSupportedFor || z11) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }
}
