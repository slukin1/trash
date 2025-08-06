package androidx.activity.result;

import android.annotation.SuppressLint;
import p0.c;

public abstract class ActivityResultLauncher<I> {
    public void a(@SuppressLint({"UnknownNullness"}) I i11) {
        b(i11, (c) null);
    }

    public abstract void b(@SuppressLint({"UnknownNullness"}) I i11, c cVar);

    public abstract void c();
}
