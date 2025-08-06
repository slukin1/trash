package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;

public class ActivityResultContracts$CreateDocument extends ActivityResultContract<String, Uri> {

    /* renamed from: a  reason: collision with root package name */
    public final String f3715a;

    public ActivityResultContracts$CreateDocument(String str) {
        this.f3715a = str;
    }

    /* renamed from: a */
    public final ActivityResultContract.a<Uri> getSynchronousResult(Context context, String str) {
        return null;
    }

    public Intent createIntent(Context context, String str) {
        return new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.f3715a).putExtra("android.intent.extra.TITLE", str);
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

    public ActivityResultContracts$CreateDocument() {
        this("*/*");
    }
}
