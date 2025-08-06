package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import kotlin.jvm.internal.r;

public final class ActivityResultContracts$StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3724a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    /* renamed from: a */
    public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
        return new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
    }

    /* renamed from: b */
    public ActivityResult parseResult(int i11, Intent intent) {
        return new ActivityResult(i11, intent);
    }
}
