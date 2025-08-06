package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;

public final /* synthetic */ class e implements TrackSelectionUtil.AdaptiveTrackSelectionFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RandomTrackSelection.Factory f66070a;

    public /* synthetic */ e(RandomTrackSelection.Factory factory) {
        this.f66070a = factory;
    }

    public final ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition) {
        return this.f66070a.lambda$createTrackSelections$0(definition);
    }
}
