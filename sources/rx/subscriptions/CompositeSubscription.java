package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription implements Subscription {
    private Set<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public CompositeSubscription() {
    }

    private static void unsubscribeFromAll(Collection<Subscription> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (Subscription unsubscribe : collection) {
                try {
                    unsubscribe.unsubscribe();
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    public void add(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.unsubscribed) {
                synchronized (this) {
                    if (!this.unsubscribed) {
                        if (this.subscriptions == null) {
                            this.subscriptions = new HashSet(4);
                        }
                        this.subscriptions.add(subscription);
                        return;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    public void addAll(Subscription... subscriptionArr) {
        int i11 = 0;
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet(subscriptionArr.length);
                    }
                    int length = subscriptionArr.length;
                    while (i11 < length) {
                        Subscription subscription = subscriptionArr[i11];
                        if (!subscription.isUnsubscribed()) {
                            this.subscriptions.add(subscription);
                        }
                        i11++;
                    }
                    return;
                }
            }
        }
        int length2 = subscriptionArr.length;
        while (i11 < length2) {
            subscriptionArr[i11].unsubscribe();
            i11++;
        }
    }

    public void clear() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    Set<Subscription> set = this.subscriptions;
                    if (set != null) {
                        this.subscriptions = null;
                        unsubscribeFromAll(set);
                    }
                }
            }
        }
    }

    public boolean hasSubscriptions() {
        Set<Subscription> set;
        boolean z11 = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && (set = this.subscriptions) != null && !set.isEmpty()) {
                z11 = true;
            }
        }
        return z11;
    }

    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        r2.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.Subscription r2) {
        /*
            r1 = this;
            boolean r0 = r1.unsubscribed
            if (r0 != 0) goto L_0x001e
            monitor-enter(r1)
            boolean r0 = r1.unsubscribed     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            java.util.Set<rx.Subscription> r0 = r1.subscriptions     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            boolean r0 = r0.remove(r2)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            r2.unsubscribe()
            goto L_0x001e
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.remove(rx.Subscription):void");
    }

    public void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    this.unsubscribed = true;
                    Set<Subscription> set = this.subscriptions;
                    this.subscriptions = null;
                    unsubscribeFromAll(set);
                }
            }
        }
    }

    public CompositeSubscription(Subscription... subscriptionArr) {
        this.subscriptions = new HashSet(Arrays.asList(subscriptionArr));
    }
}
