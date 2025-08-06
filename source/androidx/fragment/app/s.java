package androidx.fragment.app;

import android.content.res.Configuration;
import androidx.core.util.Consumer;

public final /* synthetic */ class s implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f9782b;

    public /* synthetic */ s(FragmentManager fragmentManager) {
        this.f9782b = fragmentManager;
    }

    public final void accept(Object obj) {
        this.f9782b.Y0((Configuration) obj);
    }
}
