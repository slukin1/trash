package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class k1 {

    public static class a {
        public static CaptureRequest.Builder a(CameraDevice cameraDevice, TotalCaptureResult totalCaptureResult) throws CameraAccessException {
            return cameraDevice.createReprocessCaptureRequest(totalCaptureResult);
        }
    }

    public static void a(CaptureConfig captureConfig, CaptureRequest.Builder builder) {
        if (!CaptureRequestOptions.Builder.c(captureConfig.getImplementationOptions()).build().containsOption(Camera2ImplConfig.a(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE)) && !captureConfig.getExpectedFrameRateRange().equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, captureConfig.getExpectedFrameRateRange());
        }
    }

    public static void b(CaptureRequest.Builder builder, Config config) {
        CaptureRequestOptions b11 = CaptureRequestOptions.Builder.c(config).build();
        for (Config.Option option : b11.listOptions()) {
            CaptureRequest.Key key = (CaptureRequest.Key) option.getToken();
            try {
                builder.set(key, b11.retrieveOption(option));
            } catch (IllegalArgumentException unused) {
                Logger.e("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    public static CaptureRequest c(CaptureConfig captureConfig, CameraDevice cameraDevice, Map<DeferrableSurface, Surface> map) throws CameraAccessException {
        CaptureRequest.Builder builder;
        if (cameraDevice == null) {
            return null;
        }
        List<Surface> e11 = e(captureConfig.getSurfaces(), map);
        if (e11.isEmpty()) {
            return null;
        }
        CameraCaptureResult cameraCaptureResult = captureConfig.getCameraCaptureResult();
        if (Build.VERSION.SDK_INT < 23 || captureConfig.getTemplateType() != 5 || cameraCaptureResult == null || !(cameraCaptureResult.getCaptureResult() instanceof TotalCaptureResult)) {
            Logger.d("Camera2CaptureRequestBuilder", "createCaptureRequest");
            builder = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        } else {
            Logger.d("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
            builder = a.a(cameraDevice, (TotalCaptureResult) cameraCaptureResult.getCaptureResult());
        }
        b(builder, captureConfig.getImplementationOptions());
        a(captureConfig, builder);
        Config implementationOptions = captureConfig.getImplementationOptions();
        Config.Option<Integer> option = CaptureConfig.OPTION_ROTATION;
        if (implementationOptions.containsOption(option)) {
            builder.set(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.getImplementationOptions().retrieveOption(option));
        }
        Config implementationOptions2 = captureConfig.getImplementationOptions();
        Config.Option<Integer> option2 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (implementationOptions2.containsOption(option2)) {
            builder.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.getImplementationOptions().retrieveOption(option2)).byteValue()));
        }
        for (Surface addTarget : e11) {
            builder.addTarget(addTarget);
        }
        builder.setTag(captureConfig.getTagBundle());
        return builder.build();
    }

    public static CaptureRequest d(CaptureConfig captureConfig, CameraDevice cameraDevice) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        b(createCaptureRequest, captureConfig.getImplementationOptions());
        return createCaptureRequest.build();
    }

    public static List<Surface> e(List<DeferrableSurface> list, Map<DeferrableSurface, Surface> map) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : list) {
            Surface surface = map.get(deferrableSurface);
            if (surface != null) {
                arrayList.add(surface);
            } else {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
        }
        return arrayList;
    }
}
