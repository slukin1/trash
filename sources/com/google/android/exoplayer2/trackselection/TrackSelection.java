package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;

public interface TrackSelection {
    public static final int TYPE_CUSTOM_BASE = 10000;
    public static final int TYPE_UNSET = 0;

    Format getFormat(int i11);

    int getIndexInTrackGroup(int i11);

    TrackGroup getTrackGroup();

    int getType();

    int indexOf(int i11);

    int indexOf(Format format);

    int length();
}
