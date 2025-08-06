package x6;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.webkit.ValueCallback;
import androidx.core.content.FileProvider;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public ValueCallback<Uri> f69081a;

    /* renamed from: b  reason: collision with root package name */
    public String f69082b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69083c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f69084d;

    public g(Activity activity) {
        this.f69084d = activity;
    }

    public final Intent a() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    public final Intent b() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", g(this.f69084d));
        return intent;
    }

    public final Intent c(Intent... intentArr) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        return intent;
    }

    public final Intent d() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(SelectMimeType.SYSTEM_IMAGE);
        Intent c11 = c(b(), a(), f());
        c11.putExtra("android.intent.extra.INTENT", intent);
        return c11;
    }

    public final Intent e(String str) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str);
        return intent;
    }

    public final Intent f() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public final Uri g(Context context) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(externalStoragePublicDirectory.getAbsolutePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("browser-photos");
        File file = new File(sb2.toString());
        file.mkdirs();
        this.f69082b = file.getAbsolutePath() + str + System.currentTimeMillis() + PictureMimeType.JPG;
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(new File(this.f69082b));
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", new File(this.f69082b));
    }

    public void h(int i11, Intent intent) {
        if (i11 != 0 || !this.f69083c) {
            Uri data = (intent == null || i11 != -1) ? null : intent.getData();
            if (i11 == -1) {
                File file = new File(this.f69082b);
                if (file.exists()) {
                    data = Uri.fromFile(file);
                    this.f69084d.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", data));
                }
            }
            ValueCallback<Uri> valueCallback = this.f69081a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(data);
                this.f69081a = null;
            }
            this.f69083c = false;
            return;
        }
        this.f69083c = false;
    }

    public void i(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (this.f69081a == null) {
            this.f69081a = valueCallback;
            String[] split = str.split(";");
            String str3 = split[0];
            if (str3.contains("image")) {
                str3 = SelectMimeType.SYSTEM_IMAGE;
            }
            String str4 = str2.length() > 0 ? str2 : "filesystem";
            if (str2.equals("filesystem")) {
                for (String split2 : split) {
                    String[] split3 = split2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split3.length == 2 && OptionsBridge.CAPTURE_KEY.equals(split3[0])) {
                        str4 = split3[1];
                    }
                }
            }
            this.f69082b = null;
            if (str3.equals(SelectMimeType.SYSTEM_IMAGE)) {
                if (str4.equals(OptionsBridge.CAMERA_KEY)) {
                    j(b());
                    return;
                }
                Intent c11 = c(b());
                c11.putExtra("android.intent.extra.INTENT", e(SelectMimeType.SYSTEM_IMAGE));
                j(c11);
            } else if (str3.equals(SelectMimeType.SYSTEM_VIDEO)) {
                if (str4.equals("camcorder")) {
                    j(a());
                    return;
                }
                Intent c12 = c(a());
                c12.putExtra("android.intent.extra.INTENT", e(SelectMimeType.SYSTEM_VIDEO));
                j(c12);
            } else if (!str3.equals(SelectMimeType.SYSTEM_AUDIO)) {
                j(d());
            } else if (str4.equals("microphone")) {
                j(f());
            } else {
                Intent c13 = c(f());
                c13.putExtra("android.intent.extra.INTENT", e(SelectMimeType.SYSTEM_AUDIO));
                j(c13);
            }
        }
    }

    public final void j(Intent intent) {
        try {
            this.f69084d.startActivityForResult(intent, 4);
        } catch (ActivityNotFoundException unused) {
            try {
                this.f69083c = true;
                this.f69084d.startActivityForResult(d(), 4);
            } catch (ActivityNotFoundException unused2) {
            }
        }
    }
}
