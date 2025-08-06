package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;

public interface DocumentProvider extends ThreadBound {
    void dispose();

    NodeDescriptor getNodeDescriptor(Object obj);

    Object getRootElement();

    void hideHighlight();

    void highlightElement(Object obj, int i11);

    void setAttributesAsText(Object obj, String str);

    void setInspectModeEnabled(boolean z11);

    void setListener(DocumentProviderListener documentProviderListener);
}
