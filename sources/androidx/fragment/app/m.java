package androidx.fragment.app;

import android.content.res.Configuration;
import androidx.core.util.Consumer;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f9766b;

    public /* synthetic */ m(FragmentActivity fragmentActivity) {
        this.f9766b = fragmentActivity;
    }

    public final void accept(Object obj) {
        this.f9766b.lambda$init$1((Configuration) obj);
    }
}
