package kotlin.random;

import java.io.Serializable;
import java.util.Random;
import kotlin.jvm.internal.r;

final class PlatformRandom extends AbstractPlatformRandom implements Serializable {
    private static final a Companion = new a((r) null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private final Random impl;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public PlatformRandom(Random random) {
        this.impl = random;
    }

    public Random getImpl() {
        return this.impl;
    }
}
