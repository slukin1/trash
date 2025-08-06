package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicReferenceArray;
import z20.d;

public final class ArrayCompositeSubscription extends AtomicReferenceArray<d> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i11) {
        super(i11);
    }

    public void dispose() {
        d dVar;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i11 = 0; i11 < length; i11++) {
                d dVar2 = (d) get(i11);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (!(dVar2 == subscriptionHelper || (dVar = (d) getAndSet(i11, subscriptionHelper)) == subscriptionHelper || dVar == null)) {
                    dVar.cancel();
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public d replaceResource(int i11, d dVar) {
        d dVar2;
        do {
            dVar2 = (d) get(i11);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar == null) {
                    return null;
                }
                dVar.cancel();
                return null;
            }
        } while (!compareAndSet(i11, dVar2, dVar));
        return dVar2;
    }

    public boolean setResource(int i11, d dVar) {
        d dVar2;
        do {
            dVar2 = (d) get(i11);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!compareAndSet(i11, dVar2, dVar));
        if (dVar2 == null) {
            return true;
        }
        dVar2.cancel();
        return true;
    }
}
