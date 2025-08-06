package com.jumio.core.extraction.liveness.extraction;

import com.jumio.core.extraction.ExtractionUpdateState;

public final class LivenessUpdateState extends ExtractionUpdateState {
    public static final LivenessUpdateState INSTANCE = new LivenessUpdateState();

    /* renamed from: b  reason: collision with root package name */
    public static final int f39205b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39206c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f39207d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f39208e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f39209f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f39210g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f39211h;

    static {
        ExtractionUpdateState.Companion companion = ExtractionUpdateState.Companion;
        f39205b = companion.getId().getAndIncrement();
        f39206c = companion.getId().getAndIncrement();
        f39207d = companion.getId().getAndIncrement();
        f39208e = companion.getId().getAndIncrement();
        f39209f = companion.getId().getAndIncrement();
        f39210g = companion.getId().getAndIncrement();
        f39211h = companion.getId().getAndIncrement();
    }

    public final int getCenterFace() {
        return f39207d;
    }

    public final int getFaceCenterArea() {
        return f39206c;
    }

    public final int getFaceRoiRect() {
        return f39205b;
    }

    public final int getFaceTooClose() {
        return f39209f;
    }

    public final int getLevelEyesAndDevice() {
        return f39208e;
    }

    public final int getLivenessFinished() {
        return f39211h;
    }

    public final int getMoveFaceCloser() {
        return f39210g;
    }
}
