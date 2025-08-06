package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.contract.ActivityResultContract;

public class ActivityResultContracts$OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
    /* renamed from: a */
    public Intent createIntent(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        if (Build.VERSION.SDK_INT >= 26 && uri != null) {
            intent.putExtra("android.provider.extra.INITIAL_URI", uri);
        }
        return intent;
    }

    /* renamed from: b */
    public final ActivityResultContract.a<Uri> getSynchronousResult(Context context, Uri uri) {
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
