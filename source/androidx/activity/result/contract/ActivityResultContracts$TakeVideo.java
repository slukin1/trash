package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;

public class ActivityResultContracts$TakeVideo extends ActivityResultContract<Uri, Bitmap> {
    /* renamed from: a */
    public Intent createIntent(Context context, Uri uri) {
        return new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
    }

    /* renamed from: b */
    public final ActivityResultContract.a<Bitmap> getSynchronousResult(Context context, Uri uri) {
        return null;
    }

    /* renamed from: c */
    public final Bitmap parseResult(int i11, Intent intent) {
        if (!(i11 == -1)) {
            intent = null;
        }
        if (intent != null) {
            return (Bitmap) intent.getParcelableExtra("data");
        }
        return null;
    }
}
