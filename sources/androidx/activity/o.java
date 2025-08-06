package androidx.activity;

import d10.a;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;

public abstract class o {
    private final CopyOnWriteArrayList<d> cancellables = new CopyOnWriteArrayList<>();
    private a<Unit> enabledChangedCallback;
    private boolean isEnabled;

    public o(boolean z11) {
        this.isEnabled = z11;
    }

    public final void addCancellable(d dVar) {
        this.cancellables.add(dVar);
    }

    public final a<Unit> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(c cVar) {
    }

    public void handleOnBackStarted(c cVar) {
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        for (d cancel : this.cancellables) {
            cancel.cancel();
        }
    }

    public final void removeCancellable(d dVar) {
        this.cancellables.remove(dVar);
    }

    public final void setEnabled(boolean z11) {
        this.isEnabled = z11;
        a<Unit> aVar = this.enabledChangedCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(a<Unit> aVar) {
        this.enabledChangedCallback = aVar;
    }
}
