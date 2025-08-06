package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;

public abstract class ActivityResultContract<I, O> {

    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f3714a;

        public a(T t11) {
            this.f3714a = t11;
        }

        public final T a() {
            return this.f3714a;
        }
    }

    public abstract Intent createIntent(Context context, I i11);

    public a<O> getSynchronousResult(Context context, I i11) {
        return null;
    }

    public abstract O parseResult(int i11, Intent intent);
}
