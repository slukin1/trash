package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class ActivityResultCallerLauncher$resultContract$2 extends Lambda implements d10.a {
    public final /* synthetic */ b<Object, Object> this$0;

    public static final class a extends ActivityResultContract<Unit, Object> {
        public a(b<Object, Object> bVar) {
        }

        /* renamed from: a */
        public Intent createIntent(Context context, Unit unit) {
            throw null;
        }

        public Object parseResult(int i11, Intent intent) {
            throw null;
        }
    }

    public ActivityResultCallerLauncher$resultContract$2(b<Object, Object> bVar) {
        super(0);
    }

    public final a invoke() {
        return new a(this.this$0);
    }
}
