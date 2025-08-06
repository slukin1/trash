package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;

public class ActivityResultContracts$OpenDocument extends ActivityResultContract<String[], Uri> {
    /* renamed from: a */
    public Intent createIntent(Context context, String[] strArr) {
        return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
    }

    /* renamed from: b */
    public final ActivityResultContract.a<Uri> getSynchronousResult(Context context, String[] strArr) {
        return null;
    }

    public final Uri parseResult(int i11, Intent intent) {
        if (!(i11 == -1)) {
            intent = null;
        }
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }
}
