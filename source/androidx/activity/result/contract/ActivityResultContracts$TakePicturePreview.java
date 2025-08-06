package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.activity.result.contract.ActivityResultContract;

public class ActivityResultContracts$TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
    /* renamed from: a */
    public Intent createIntent(Context context, Void voidR) {
        return new Intent("android.media.action.IMAGE_CAPTURE");
    }

    /* renamed from: b */
    public final ActivityResultContract.a<Bitmap> getSynchronousResult(Context context, Void voidR) {
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
