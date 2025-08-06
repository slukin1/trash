package androidx.camera.video;

import androidx.core.util.h;

public abstract class v1 {

    /* renamed from: a  reason: collision with root package name */
    public final t f6376a;

    /* renamed from: b  reason: collision with root package name */
    public final a1 f6377b;

    public static final class a extends v1 {

        /* renamed from: c  reason: collision with root package name */
        public final OutputResults f6378c;

        /* renamed from: d  reason: collision with root package name */
        public final int f6379d;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f6380e;

        public a(t tVar, a1 a1Var, OutputResults outputResults, int i11, Throwable th2) {
            super(tVar, a1Var);
            this.f6378c = outputResults;
            this.f6379d = i11;
            this.f6380e = th2;
        }

        public static String i(int i11) {
            switch (i11) {
                case 0:
                    return "ERROR_NONE";
                case 1:
                    return "ERROR_UNKNOWN";
                case 2:
                    return "ERROR_FILE_SIZE_LIMIT_REACHED";
                case 3:
                    return "ERROR_INSUFFICIENT_STORAGE";
                case 4:
                    return "ERROR_SOURCE_INACTIVE";
                case 5:
                    return "ERROR_INVALID_OUTPUT_OPTIONS";
                case 6:
                    return "ERROR_ENCODING_FAILED";
                case 7:
                    return "ERROR_RECORDER_ERROR";
                case 8:
                    return "ERROR_NO_VALID_DATA";
                case 9:
                    return "ERROR_DURATION_LIMIT_REACHED";
                case 10:
                    return "ERROR_RECORDING_GARBAGE_COLLECTED";
                default:
                    return "Unknown(" + i11 + ")";
            }
        }

        public Throwable j() {
            return this.f6380e;
        }

        public int k() {
            return this.f6379d;
        }

        public boolean l() {
            return this.f6379d != 0;
        }
    }

    public static final class b extends v1 {
        public b(t tVar, a1 a1Var) {
            super(tVar, a1Var);
        }
    }

    public static final class c extends v1 {
        public c(t tVar, a1 a1Var) {
            super(tVar, a1Var);
        }
    }

    public static final class d extends v1 {
        public d(t tVar, a1 a1Var) {
            super(tVar, a1Var);
        }
    }

    public static final class e extends v1 {
        public e(t tVar, a1 a1Var) {
            super(tVar, a1Var);
        }
    }

    public v1(t tVar, a1 a1Var) {
        this.f6376a = (t) h.g(tVar);
        this.f6377b = (a1) h.g(a1Var);
    }

    public static a a(t tVar, a1 a1Var, OutputResults outputResults) {
        return new a(tVar, a1Var, outputResults, 0, (Throwable) null);
    }

    public static a b(t tVar, a1 a1Var, OutputResults outputResults, int i11, Throwable th2) {
        h.b(i11 != 0, "An error type is required.");
        return new a(tVar, a1Var, outputResults, i11, th2);
    }

    public static b e(t tVar, a1 a1Var) {
        return new b(tVar, a1Var);
    }

    public static c f(t tVar, a1 a1Var) {
        return new c(tVar, a1Var);
    }

    public static d g(t tVar, a1 a1Var) {
        return new d(tVar, a1Var);
    }

    public static e h(t tVar, a1 a1Var) {
        return new e(tVar, a1Var);
    }

    public t c() {
        return this.f6376a;
    }

    public a1 d() {
        return this.f6377b;
    }
}
