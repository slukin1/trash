package com.google.android.exoplayer2.text.ttml;

final class TtmlRegion {
    public final float height;

    /* renamed from: id  reason: collision with root package name */
    public final String f66063id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final float width;

    public TtmlRegion(String str) {
        this(str, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE);
    }

    public TtmlRegion(String str, float f11, float f12, int i11, int i12, float f13, float f14, int i13, float f15, int i14) {
        this.f66063id = str;
        this.position = f11;
        this.line = f12;
        this.lineType = i11;
        this.lineAnchor = i12;
        this.width = f13;
        this.height = f14;
        this.textSizeType = i13;
        this.textSize = f15;
        this.verticalType = i14;
    }
}
