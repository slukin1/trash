package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class ViewModel {
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;
    private final Set<Closeable> mCloseables;

    public ViewModel() {
        this.mBagOfTags = new HashMap();
        this.mCloseables = new LinkedHashSet();
        this.mCleared = false;
    }

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public void addCloseable(Closeable closeable) {
        if (this.mCleared) {
            closeWithRuntimeException(closeable);
            return;
        }
        Set<Closeable> set = this.mCloseables;
        if (set != null) {
            synchronized (set) {
                this.mCloseables.add(closeable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                for (Object closeWithRuntimeException : this.mBagOfTags.values()) {
                    closeWithRuntimeException(closeWithRuntimeException);
                }
            }
        }
        Set<Closeable> set = this.mCloseables;
        if (set != null) {
            synchronized (set) {
                for (Closeable closeWithRuntimeException2 : this.mCloseables) {
                    closeWithRuntimeException(closeWithRuntimeException2);
                }
            }
            this.mCloseables.clear();
        }
        onCleared();
    }

    public <T> T getTag(String str) {
        T t11;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t11 = this.mBagOfTags.get(str);
        }
        return t11;
    }

    public void onCleared() {
    }

    public <T> T setTagIfAbsent(String str, T t11) {
        T t12;
        synchronized (this.mBagOfTags) {
            t12 = this.mBagOfTags.get(str);
            if (t12 == null) {
                this.mBagOfTags.put(str, t11);
            }
        }
        if (t12 != null) {
            t11 = t12;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t11);
        }
        return t11;
    }

    public ViewModel(Closeable... closeableArr) {
        this.mBagOfTags = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.mCloseables = linkedHashSet;
        this.mCleared = false;
        linkedHashSet.addAll(Arrays.asList(closeableArr));
    }
}
