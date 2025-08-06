package jumio.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogLevel;
import com.jumio.core.environment.CpuInfo;
import com.jumio.core.environment.Environment;
import com.jumio.core.image.ImageStoreInterface;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import t00.c;

public final class x0 implements ImageStoreInterface {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f56337a;

    /* renamed from: b  reason: collision with root package name */
    public final File f56338b;

    /* renamed from: c  reason: collision with root package name */
    public AuthorizationModel.SessionKey f56339c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap.CompressFormat f56340d = Bitmap.CompressFormat.WEBP;

    /* renamed from: e  reason: collision with root package name */
    public int f56341e = 95;

    /* renamed from: f  reason: collision with root package name */
    public String f56342f = "image/webp";

    /* renamed from: g  reason: collision with root package name */
    public String f56343g = "WEBP";

    public x0(Context context) {
        this.f56338b = Environment.INSTANCE.getDataDirectory(context);
    }

    public static final void a(x0 x0Var, ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect, File file) {
        x0Var.getClass();
        try {
            CameraUtils cameraUtils = CameraUtils.INSTANCE;
            Bitmap bitmap = cameraUtils.getBitmap(imageSource, previewProperties, metaData, rect);
            if (bitmap != null) {
                Log log = Log.INSTANCE;
                LogLevel logLevel = LogLevel.OFF;
                AuthorizationModel.SessionKey sessionKey = x0Var.f56339c;
                if (sessionKey != null) {
                    cameraUtils.saveBitmap(bitmap, file, x0Var.f56340d, x0Var.f56341e, sessionKey);
                }
                bitmap.recycle();
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        } catch (OutOfMemoryError e12) {
            Log.printStackTrace(e12);
            System.gc();
        }
    }

    public final void add(ImageData imageData, ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect) {
        if (this.f56337a == null) {
            start();
        }
        long timeStamp = metaData.getTimeStamp();
        File file = new File(this.f56338b, "image_" + timeStamp);
        imageData.setPath(file.getAbsolutePath());
        imageData.getSize().setWidth(imageSource.Width());
        imageData.getSize().setHeight(imageSource.Height());
        imageData.setMimeType(this.f56342f);
        imageData.setFileType(this.f56343g);
        imageData.setTimestamp(Long.valueOf(metaData.getTimeStamp()));
        ExecutorService executorService = this.f56337a;
        if (executorService != null) {
            executorService.submit(new c(this, imageSource, previewProperties, metaData, rect, file));
        }
    }

    public final void configure(AuthorizationModel.SessionKey sessionKey, Bitmap.CompressFormat compressFormat, int i11, String str, String str2) {
        this.f56339c = sessionKey;
        this.f56340d = compressFormat;
        this.f56341e = this.f56341e;
        this.f56342f = str;
        this.f56343g = str2;
    }

    public final void delete(ImageData imageData) {
        File file = new File(imageData.getPath());
        if (file.isFile()) {
            file.delete();
        }
    }

    public final void start() {
        stop(false);
        this.f56337a = Executors.newFixedThreadPool(RangesKt___RangesKt.d(CpuInfo.getCpuCount() / 2, 2));
    }

    public final void stop(boolean z11) {
        if (!z11) {
            ExecutorService executorService = this.f56337a;
            if (executorService != null) {
                executorService.shutdownNow();
                return;
            }
            return;
        }
        ExecutorService executorService2 = this.f56337a;
        if (executorService2 != null) {
            executorService2.shutdown();
            try {
                if (!executorService2.awaitTermination(20, TimeUnit.SECONDS)) {
                    executorService2.shutdownNow();
                }
            } catch (InterruptedException unused) {
                executorService2.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
