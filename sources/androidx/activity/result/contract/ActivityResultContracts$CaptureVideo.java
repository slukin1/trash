package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;

public class ActivityResultContracts$CaptureVideo extends ActivityResultContract<Uri, Boolean> {
    /* renamed from: a */
    public Intent createIntent(Context context, Uri uri) {
        return new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
    }

    /* renamed from: b */
    public final ActivityResultContract.a<Boolean> getSynchronousResult(Context context, Uri uri) {
        return null;
    }

    /* renamed from: c */
    public final Boolean parseResult(int i11, Intent intent) {
        return Boolean.valueOf(i11 == -1);
    }
}
