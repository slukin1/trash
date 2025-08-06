package com.jumio.core.extraction;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.r;

public class ExtractionUpdateState {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f39178a;
    public static final int centerId = f39178a.getAndIncrement();
    public static final int fallbackRequired = f39178a.getAndIncrement();
    public static final int holdStill = f39178a.getAndIncrement();
    public static final int holdStraight = f39178a.getAndIncrement();
    public static final int moveCloser = f39178a.getAndIncrement();
    public static final int receiveClickListener = f39178a.getAndIncrement();
    public static final int resetOverlay = f39178a.getAndIncrement();
    public static final int saveImage;
    public static final int shotTaken = f39178a.getAndIncrement();
    public static final int tooClose = f39178a.getAndIncrement();

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ void getId$annotations() {
        }

        public final AtomicInteger getId() {
            return ExtractionUpdateState.f39178a;
        }

        public final void setId(AtomicInteger atomicInteger) {
            ExtractionUpdateState.f39178a = atomicInteger;
        }
    }

    static {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        f39178a = atomicInteger;
        saveImage = atomicInteger.getAndIncrement();
    }

    public static final AtomicInteger getId() {
        return Companion.getId();
    }

    public static final void setId(AtomicInteger atomicInteger) {
        Companion.setId(atomicInteger);
    }
}
