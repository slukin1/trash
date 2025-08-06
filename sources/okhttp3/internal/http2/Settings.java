package okhttp3.internal.http2;

import kotlin.jvm.internal.r;

public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion((r) null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public final void clear() {
        this.set = 0;
        ArraysKt___ArraysJvmKt.o(this.values, 0, 0, 0, 6, (Object) null);
    }

    public final int get(int i11) {
        return this.values[i11];
    }

    public final boolean getEnablePush(boolean z11) {
        if ((this.set & 4) != 0) {
            return this.values[2] == 1;
        }
        return z11;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int i11) {
        return (this.set & 32) != 0 ? this.values[5] : i11;
    }

    public final int getMaxHeaderListSize(int i11) {
        return (this.set & 64) != 0 ? this.values[6] : i11;
    }

    public final boolean isSet(int i11) {
        return ((1 << i11) & this.set) != 0;
    }

    public final void merge(Settings settings) {
        for (int i11 = 0; i11 < 10; i11++) {
            if (settings.isSet(i11)) {
                set(i11, settings.get(i11));
            }
        }
    }

    public final Settings set(int i11, int i12) {
        if (i11 >= 0) {
            int[] iArr = this.values;
            if (i11 < iArr.length) {
                this.set = (1 << i11) | this.set;
                iArr[i11] = i12;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
