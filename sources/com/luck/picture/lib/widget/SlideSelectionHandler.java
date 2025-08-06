package com.luck.picture.lib.widget;

import com.luck.picture.lib.widget.SlideSelectTouchListener;
import java.util.HashSet;
import java.util.Set;

public class SlideSelectionHandler implements SlideSelectTouchListener.OnAdvancedSlideSelectListener {
    private HashSet<Integer> mOriginalSelection;
    private final ISelectionHandler mSelectionHandler;
    private ISelectionStartFinishedListener mStartFinishedListener = null;

    public interface ISelectionHandler {
        void changeSelection(int i11, int i12, boolean z11, boolean z12);

        Set<Integer> getSelection();
    }

    public interface ISelectionStartFinishedListener {
        void onSelectionFinished(int i11);

        void onSelectionStarted(int i11, boolean z11);
    }

    public SlideSelectionHandler(ISelectionHandler iSelectionHandler) {
        this.mSelectionHandler = iSelectionHandler;
    }

    private void checkedChangeSelection(int i11, int i12, boolean z11) {
        this.mSelectionHandler.changeSelection(i11, i12, z11, false);
    }

    public void onSelectChange(int i11, int i12, boolean z11) {
        while (i11 <= i12) {
            checkedChangeSelection(i11, i11, z11 != this.mOriginalSelection.contains(Integer.valueOf(i11)));
            i11++;
        }
    }

    public void onSelectionFinished(int i11) {
        this.mOriginalSelection = null;
        ISelectionStartFinishedListener iSelectionStartFinishedListener = this.mStartFinishedListener;
        if (iSelectionStartFinishedListener != null) {
            iSelectionStartFinishedListener.onSelectionFinished(i11);
        }
    }

    public void onSelectionStarted(int i11) {
        this.mOriginalSelection = new HashSet<>();
        Set<Integer> selection = this.mSelectionHandler.getSelection();
        if (selection != null) {
            this.mOriginalSelection.addAll(selection);
        }
        boolean contains = this.mOriginalSelection.contains(Integer.valueOf(i11));
        this.mSelectionHandler.changeSelection(i11, i11, !this.mOriginalSelection.contains(Integer.valueOf(i11)), true);
        ISelectionStartFinishedListener iSelectionStartFinishedListener = this.mStartFinishedListener;
        if (iSelectionStartFinishedListener != null) {
            iSelectionStartFinishedListener.onSelectionStarted(i11, contains);
        }
    }

    public SlideSelectionHandler withStartFinishedListener(ISelectionStartFinishedListener iSelectionStartFinishedListener) {
        this.mStartFinishedListener = iSelectionStartFinishedListener;
        return this;
    }
}
