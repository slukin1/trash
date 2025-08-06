package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.r;

public final class ActivityResultContracts$StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3723a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    /* renamed from: a */
    public Intent createIntent(Context context, Intent intent) {
        return intent;
    }

    /* renamed from: b */
    public ActivityResult parseResult(int i11, Intent intent) {
        return new ActivityResult(i11, intent);
    }
}
