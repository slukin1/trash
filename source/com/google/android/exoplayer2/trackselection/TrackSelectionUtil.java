package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.MimeTypes;

public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition);
    }

    private TrackSelectionUtil() {
    }

    public static ExoTrackSelection[] createTrackSelectionsForDefinitions(ExoTrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        boolean z11 = false;
        for (int i11 = 0; i11 < definitionArr.length; i11++) {
            ExoTrackSelection.Definition definition = definitionArr[i11];
            if (definition != null) {
                int[] iArr = definition.tracks;
                if (iArr.length <= 1 || z11) {
                    exoTrackSelectionArr[i11] = new FixedTrackSelection(definition.group, iArr[0], definition.type);
                } else {
                    exoTrackSelectionArr[i11] = adaptiveTrackSelectionFactory.createAdaptiveTrackSelection(definition);
                    z11 = true;
                }
            }
        }
        return exoTrackSelectionArr;
    }

    public static boolean hasTrackOfType(TrackSelectionArray trackSelectionArray, int i11) {
        for (int i12 = 0; i12 < trackSelectionArray.length; i12++) {
            TrackSelection trackSelection = trackSelectionArray.get(i12);
            if (trackSelection != null) {
                for (int i13 = 0; i13 < trackSelection.length(); i13++) {
                    if (MimeTypes.getTrackType(trackSelection.getFormat(i13).sampleMimeType) == i11) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static DefaultTrackSelector.Parameters updateParametersWithOverride(DefaultTrackSelector.Parameters parameters, int i11, TrackGroupArray trackGroupArray, boolean z11, DefaultTrackSelector.SelectionOverride selectionOverride) {
        DefaultTrackSelector.ParametersBuilder rendererDisabled = parameters.buildUpon().clearSelectionOverrides(i11).setRendererDisabled(i11, z11);
        if (selectionOverride != null) {
            rendererDisabled.setSelectionOverride(i11, trackGroupArray, selectionOverride);
        }
        return rendererDisabled.build();
    }
}
