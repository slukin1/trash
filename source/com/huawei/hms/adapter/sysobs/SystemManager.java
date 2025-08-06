package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SystemManager {

    /* renamed from: a  reason: collision with root package name */
    private static SystemManager f37737a = new SystemManager();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Object f37738b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static SystemNotifier f37739c = new a();

    private SystemManager() {
    }

    public static SystemManager getInstance() {
        return f37737a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f37739c;
    }

    public void notifyNoticeResult(int i11) {
        f37739c.notifyNoticeObservers(i11);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f37739c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i11) {
        f37739c.notifyObservers(i11);
    }

    public class a implements SystemNotifier {

        /* renamed from: a  reason: collision with root package name */
        private final List<SystemObserver> f37740a = new ArrayList();

        public void notifyNoticeObservers(int i11) {
            synchronized (SystemManager.f37738b) {
                Iterator<SystemObserver> it2 = this.f37740a.iterator();
                while (it2.hasNext()) {
                    if (it2.next().onNoticeResult(i11)) {
                        it2.remove();
                    }
                }
            }
        }

        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f37738b) {
                Iterator<SystemObserver> it2 = this.f37740a.iterator();
                while (it2.hasNext()) {
                    if (it2.next().onSolutionResult(intent, str)) {
                        it2.remove();
                    }
                }
            }
        }

        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver != null && !this.f37740a.contains(systemObserver)) {
                synchronized (SystemManager.f37738b) {
                    this.f37740a.add(systemObserver);
                }
            }
        }

        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f37738b) {
                this.f37740a.remove(systemObserver);
            }
        }

        public void notifyObservers(int i11) {
            synchronized (SystemManager.f37738b) {
                Iterator<SystemObserver> it2 = this.f37740a.iterator();
                while (it2.hasNext()) {
                    if (it2.next().onUpdateResult(i11)) {
                        it2.remove();
                    }
                }
            }
        }
    }
}
