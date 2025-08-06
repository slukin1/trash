package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import java.util.List;

public class ActivityResultContracts$OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
    /* renamed from: a */
    public Intent createIntent(Context context, String[] strArr) {
        return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
    }

    /* renamed from: b */
    public final ActivityResultContract.a<List<Uri>> getSynchronousResult(Context context, String[] strArr) {
        return null;
    }

    public final List<Uri> parseResult(int i11, Intent intent) {
        List<Uri> a11;
        if (!(i11 == -1)) {
            intent = null;
        }
        return (intent == null || (a11 = ActivityResultContracts$GetMultipleContents.f3716a.a(intent)) == null) ? CollectionsKt__CollectionsKt.k() : a11;
    }
}
