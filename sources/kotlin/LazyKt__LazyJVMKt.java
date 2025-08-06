package kotlin;

import kotlin.jvm.internal.r;

class LazyKt__LazyJVMKt {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56619a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.LazyThreadSafetyMode[] r0 = kotlin.LazyThreadSafetyMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.PUBLICATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f56619a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.LazyKt__LazyJVMKt.a.<clinit>():void");
        }
    }

    public static <T> i<T> a(d10.a<? extends T> aVar) {
        return new SynchronizedLazyImpl(aVar, (Object) null, 2, (r) null);
    }

    public static <T> i<T> b(LazyThreadSafetyMode lazyThreadSafetyMode, d10.a<? extends T> aVar) {
        int i11 = a.f56619a[lazyThreadSafetyMode.ordinal()];
        if (i11 == 1) {
            return new SynchronizedLazyImpl(aVar, (Object) null, 2, (r) null);
        }
        if (i11 == 2) {
            return new SafePublicationLazyImpl(aVar);
        }
        if (i11 == 3) {
            return new UnsafeLazyImpl(aVar);
        }
        throw new NoWhenBranchMatchedException();
    }
}
