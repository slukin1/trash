package androidx.recyclerview.widget;

public final class ConcatAdapter$Config {

    /* renamed from: c  reason: collision with root package name */
    public static final ConcatAdapter$Config f10531c = new ConcatAdapter$Config(true, StableIdMode.NO_STABLE_IDS);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10532a;

    /* renamed from: b  reason: collision with root package name */
    public final StableIdMode f10533b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f10534a;

        /* renamed from: b  reason: collision with root package name */
        public StableIdMode f10535b;

        public Builder() {
            ConcatAdapter$Config concatAdapter$Config = ConcatAdapter$Config.f10531c;
            this.f10534a = concatAdapter$Config.f10532a;
            this.f10535b = concatAdapter$Config.f10533b;
        }
    }

    public enum StableIdMode {
        NO_STABLE_IDS,
        ISOLATED_STABLE_IDS,
        SHARED_STABLE_IDS
    }

    public ConcatAdapter$Config(boolean z11, StableIdMode stableIdMode) {
        this.f10532a = z11;
        this.f10533b = stableIdMode;
    }
}
