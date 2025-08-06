package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;

public class ActivityResultContracts$GetContent extends ActivityResultContract<String, Uri> {
    /* renamed from: a */
    public final ActivityResultContract.a<Uri> getSynchronousResult(Context context, String str) {
        return null;
    }

    public Intent createIntent(Context context, String str) {
        return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
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
