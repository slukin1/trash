package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import n.b;

public final class Camera2ImplConfig extends CaptureRequestOptions {

    /* renamed from: b  reason: collision with root package name */
    public static final Config.Option<Integer> f4890b = Config.Option.create("camera2.captureRequest.templateType", Integer.TYPE);

    /* renamed from: c  reason: collision with root package name */
    public static final Config.Option<Long> f4891c = Config.Option.create("camera2.cameraCaptureSession.streamUseCase", Long.TYPE);

    /* renamed from: d  reason: collision with root package name */
    public static final Config.Option<CameraDevice.StateCallback> f4892d = Config.Option.create("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);

    /* renamed from: e  reason: collision with root package name */
    public static final Config.Option<CameraCaptureSession.StateCallback> f4893e = Config.Option.create("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);

    /* renamed from: f  reason: collision with root package name */
    public static final Config.Option<CameraCaptureSession.CaptureCallback> f4894f = Config.Option.create("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);

    /* renamed from: g  reason: collision with root package name */
    public static final Config.Option<b> f4895g = Config.Option.create("camera2.cameraEvent.callback", b.class);

    /* renamed from: h  reason: collision with root package name */
    public static final Config.Option<Object> f4896h = Config.Option.create("camera2.captureRequest.tag", Object.class);

    /* renamed from: i  reason: collision with root package name */
    public static final Config.Option<String> f4897i = Config.Option.create("camera2.cameraCaptureSession.physicalCameraId", String.class);

    public static final class Builder implements ExtendableBuilder<Camera2ImplConfig> {

        /* renamed from: a  reason: collision with root package name */
        public final MutableOptionsBundle f4898a = MutableOptionsBundle.create();

        /* renamed from: a */
        public Camera2ImplConfig build() {
            return new Camera2ImplConfig(OptionsBundle.from(this.f4898a));
        }

        public Builder b(Config config) {
            for (Config.Option next : config.listOptions()) {
                this.f4898a.insertOption(next, config.retrieveOption(next));
            }
            return this;
        }

        public <ValueT> Builder c(CaptureRequest.Key<ValueT> key, ValueT valuet) {
            this.f4898a.insertOption(Camera2ImplConfig.a(key), valuet);
            return this;
        }

        public MutableConfig getMutableConfig() {
            return this.f4898a;
        }
    }

    public Camera2ImplConfig(Config config) {
        super(config);
    }

    public static Config.Option<Object> a(CaptureRequest.Key<?> key) {
        return Config.Option.create("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }

    public b b(b bVar) {
        return (b) getConfig().retrieveOption(f4895g, bVar);
    }

    public CaptureRequestOptions c() {
        return CaptureRequestOptions.Builder.c(getConfig()).build();
    }

    public Object d(Object obj) {
        return getConfig().retrieveOption(f4896h, obj);
    }

    public int e(int i11) {
        return ((Integer) getConfig().retrieveOption(f4890b, Integer.valueOf(i11))).intValue();
    }

    public CameraDevice.StateCallback f(CameraDevice.StateCallback stateCallback) {
        return (CameraDevice.StateCallback) getConfig().retrieveOption(f4892d, stateCallback);
    }

    public String g(String str) {
        return (String) getConfig().retrieveOption(f4897i, str);
    }

    public CameraCaptureSession.CaptureCallback h(CameraCaptureSession.CaptureCallback captureCallback) {
        return (CameraCaptureSession.CaptureCallback) getConfig().retrieveOption(f4894f, captureCallback);
    }

    public CameraCaptureSession.StateCallback i(CameraCaptureSession.StateCallback stateCallback) {
        return (CameraCaptureSession.StateCallback) getConfig().retrieveOption(f4893e, stateCallback);
    }

    public long j(long j11) {
        return ((Long) getConfig().retrieveOption(f4891c, Long.valueOf(j11))).longValue();
    }
}
