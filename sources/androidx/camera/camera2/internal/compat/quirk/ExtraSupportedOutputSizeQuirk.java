package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;

public class ExtraSupportedOutputSizeQuirk implements Quirk {
    public static boolean e() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean f() {
        return e();
    }

    public Size[] c(int i11) {
        return (i11 != 34 || !e()) ? new Size[0] : d();
    }

    public final Size[] d() {
        return new Size[]{new Size(1920, 1080), new Size(1440, 1080), new Size(1280, 720), new Size(960, 720), new Size(864, TXVodDownloadDataSource.QUALITY_480P), new Size(720, TXVodDownloadDataSource.QUALITY_480P)};
    }
}
