package com.facebook.stetho.inspector.elements.android;

import com.facebook.stetho.inspector.elements.Descriptor;

interface AndroidDescriptorHost extends Descriptor.Host {
    HighlightableDescriptor getHighlightableDescriptor(Object obj);
}
