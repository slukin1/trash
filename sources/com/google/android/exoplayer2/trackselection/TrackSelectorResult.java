package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.util.Util;

public final class TrackSelectorResult {
    public final Object info;
    public final int length;
    public final RendererConfiguration[] rendererConfigurations;
    public final ExoTrackSelection[] selections;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr, Object obj) {
        this.rendererConfigurations = rendererConfigurationArr;
        this.selections = (ExoTrackSelection[]) exoTrackSelectionArr.clone();
        this.info = obj;
        this.length = rendererConfigurationArr.length;
    }

    public boolean isEquivalent(TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.selections.length != this.selections.length) {
            return false;
        }
        for (int i11 = 0; i11 < this.selections.length; i11++) {
            if (!isEquivalent(trackSelectorResult, i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean isRendererEnabled(int i11) {
        return this.rendererConfigurations[i11] != null;
    }

    public boolean isEquivalent(TrackSelectorResult trackSelectorResult, int i11) {
        if (trackSelectorResult != null && Util.areEqual(this.rendererConfigurations[i11], trackSelectorResult.rendererConfigurations[i11]) && Util.areEqual(this.selections[i11], trackSelectorResult.selections[i11])) {
            return true;
        }
        return false;
    }
}
