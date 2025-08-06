package androidx.test.runner.screenshot;

import android.os.Build;
import android.os.Environment;
import androidx.test.annotation.Beta;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;

@Beta
public class BasicScreenCaptureProcessor implements ScreenCaptureProcessor {

    /* renamed from: e  reason: collision with root package name */
    public static int f11697e = Build.VERSION.SDK_INT;

    /* renamed from: f  reason: collision with root package name */
    public static String f11698f = Build.DEVICE;

    /* renamed from: a  reason: collision with root package name */
    public String f11699a;

    /* renamed from: b  reason: collision with root package name */
    public String f11700b;

    /* renamed from: c  reason: collision with root package name */
    public String f11701c;

    /* renamed from: d  reason: collision with root package name */
    public File f11702d;

    public BasicScreenCaptureProcessor() {
        this(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "screenshots"));
    }

    public BasicScreenCaptureProcessor(File file) {
        this.f11699a = "BasicScreenCaptureProcessor";
        this.f11700b = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        this.f11701c = "screenshot";
        this.f11702d = file;
    }
}
