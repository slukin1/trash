package kotlinx.android.extensions;

import kotlin.jvm.internal.r;

public enum CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;
    
    public static final a Companion = null;
    /* access modifiers changed from: private */
    public static final CacheImplementation DEFAULT = null;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    /* access modifiers changed from: public */
    static {
        CacheImplementation cacheImplementation;
        Companion = new a((r) null);
        DEFAULT = cacheImplementation;
    }
}
