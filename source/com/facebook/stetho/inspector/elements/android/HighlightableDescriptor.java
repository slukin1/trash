package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;

public interface HighlightableDescriptor<E> {
    Object getElementToHighlightAtPosition(E e11, int i11, int i12, Rect rect);

    View getViewAndBoundsForHighlighting(E e11, Rect rect);
}
