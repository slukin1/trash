package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class ActivityResultContracts$PickContact extends ActivityResultContract<Void, Uri> {
    /* renamed from: a */
    public Intent createIntent(Context context, Void voidR) {
        return new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
    }

    public Uri parseResult(int i11, Intent intent) {
        if (!(i11 == -1)) {
            intent = null;
        }
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }
}
