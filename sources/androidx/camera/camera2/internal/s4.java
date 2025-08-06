package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ZslRingBuffer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import o.y;
import q.d;

public final class s4 implements o4 {

    /* renamed from: a  reason: collision with root package name */
    public final y f5315a;

    /* renamed from: b  reason: collision with root package name */
    public final ZslRingBuffer f5316b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5317c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5318d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5319e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5320f = false;

    /* renamed from: g  reason: collision with root package name */
    public SafeCloseImageReaderProxy f5321g;

    /* renamed from: h  reason: collision with root package name */
    public CameraCaptureCallback f5322h;

    /* renamed from: i  reason: collision with root package name */
    public DeferrableSurface f5323i;

    /* renamed from: j  reason: collision with root package name */
    public ImageWriter f5324j;

    public class a extends CameraCaptureSession.StateCallback {
        public a() {
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            Surface inputSurface = cameraCaptureSession.getInputSurface();
            if (inputSurface != null) {
                s4.this.f5324j = ImageWriterCompat.newInstance(inputSurface, 1);
            }
        }
    }

    public s4(y yVar) {
        boolean z11 = false;
        this.f5315a = yVar;
        this.f5319e = t4.a(yVar, 4);
        this.f5320f = d.a(ZslDisablerQuirk.class) != null ? true : z11;
        this.f5316b = new ZslRingBuffer(3, q4.f5284a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage != null) {
                this.f5316b.enqueue(acquireLatestImage);
            }
        } catch (IllegalStateException e11) {
            Logger.e("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e11.getMessage());
        }
    }

    public boolean a() {
        return this.f5317c;
    }

    public void addZslConfig(SessionConfig.Builder builder) {
        h();
        if (!this.f5317c && !this.f5320f) {
            Map<Integer, Size> i11 = i(this.f5315a);
            if (this.f5319e && !i11.isEmpty() && i11.containsKey(34) && j(this.f5315a, 34)) {
                Size size = i11.get(34);
                MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), 34, 9);
                this.f5322h = metadataImageReader.getCameraCaptureCallback();
                this.f5321g = new SafeCloseImageReaderProxy(metadataImageReader);
                metadataImageReader.setOnImageAvailableListener(new p4(this), CameraXExecutors.ioExecutor());
                ImmediateSurface immediateSurface = new ImmediateSurface(this.f5321g.getSurface(), new Size(this.f5321g.getWidth(), this.f5321g.getHeight()), 34);
                this.f5323i = immediateSurface;
                SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.f5321g;
                ListenableFuture<Void> terminationFuture = immediateSurface.getTerminationFuture();
                Objects.requireNonNull(safeCloseImageReaderProxy);
                terminationFuture.addListener(new r4(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
                builder.addSurface(this.f5323i);
                builder.addCameraCaptureCallback(this.f5322h);
                builder.addSessionStateCallback(new a());
                builder.setInputConfiguration(new InputConfiguration(this.f5321g.getWidth(), this.f5321g.getHeight(), this.f5321g.getImageFormat()));
            }
        }
    }

    public void b(boolean z11) {
        this.f5318d = z11;
    }

    public ImageProxy c() {
        try {
            return (ImageProxy) this.f5316b.dequeue();
        } catch (NoSuchElementException unused) {
            Logger.e("ZslControlImpl", "dequeueImageFromBuffer no such element");
            return null;
        }
    }

    public boolean d(ImageProxy imageProxy) {
        ImageWriter imageWriter;
        Image image = imageProxy.getImage();
        if (!(Build.VERSION.SDK_INT < 23 || (imageWriter = this.f5324j) == null || image == null)) {
            try {
                ImageWriterCompat.queueInputImage(imageWriter, image);
                return true;
            } catch (IllegalStateException e11) {
                Logger.e("ZslControlImpl", "enqueueImageToImageWriter throws IllegalStateException = " + e11.getMessage());
            }
        }
        return false;
    }

    public boolean e() {
        return this.f5318d;
    }

    public final void h() {
        ZslRingBuffer zslRingBuffer = this.f5316b;
        while (!zslRingBuffer.isEmpty()) {
            ((ImageProxy) zslRingBuffer.dequeue()).close();
        }
        DeferrableSurface deferrableSurface = this.f5323i;
        if (deferrableSurface != null) {
            SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.f5321g;
            if (safeCloseImageReaderProxy != null) {
                deferrableSurface.getTerminationFuture().addListener(new r4(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
                this.f5321g = null;
            }
            deferrableSurface.close();
            this.f5323i = null;
        }
        ImageWriter imageWriter = this.f5324j;
        if (imageWriter != null) {
            imageWriter.close();
            this.f5324j = null;
        }
    }

    public final Map<Integer, Size> i(y yVar) {
        StreamConfigurationMap streamConfigurationMap;
        try {
            streamConfigurationMap = (StreamConfigurationMap) yVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (AssertionError e11) {
            Logger.e("ZslControlImpl", "Failed to retrieve StreamConfigurationMap, error = " + e11.getMessage());
            streamConfigurationMap = null;
        }
        if (streamConfigurationMap == null || streamConfigurationMap.getInputFormats() == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (int i11 : streamConfigurationMap.getInputFormats()) {
            Size[] inputSizes = streamConfigurationMap.getInputSizes(i11);
            if (inputSizes != null) {
                Arrays.sort(inputSizes, new CompareSizesByArea(true));
                hashMap.put(Integer.valueOf(i11), inputSizes[0]);
            }
        }
        return hashMap;
    }

    public final boolean j(y yVar, int i11) {
        int[] validOutputFormatsForInput;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) yVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null || (validOutputFormatsForInput = streamConfigurationMap.getValidOutputFormatsForInput(i11)) == null) {
            return false;
        }
        for (int i12 : validOutputFormatsForInput) {
            if (i12 == 256) {
                return true;
            }
        }
        return false;
    }

    public void setZslDisabledByUserCaseConfig(boolean z11) {
        this.f5317c = z11;
    }
}
