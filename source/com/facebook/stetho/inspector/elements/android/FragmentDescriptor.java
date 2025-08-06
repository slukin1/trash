package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.android.FragmentAccessor;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;

final class FragmentDescriptor extends AbstractChainedDescriptor<Object> implements HighlightableDescriptor<Object> {
    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String TAG_ATTRIBUTE_NAME = "tag";
    private final FragmentAccessor mAccessor;

    private FragmentDescriptor(FragmentCompat fragmentCompat) {
        this.mAccessor = fragmentCompat.forFragment();
    }

    private static void maybeRegister(DescriptorMap descriptorMap, FragmentCompat fragmentCompat) {
        if (fragmentCompat != null) {
            Class fragmentClass = fragmentCompat.getFragmentClass();
            LogUtil.d("Adding support for %s", fragmentClass.getName());
            descriptorMap.registerDescriptor((Class<?>) fragmentClass, (Descriptor) new FragmentDescriptor(fragmentCompat));
        }
    }

    public static DescriptorMap register(DescriptorMap descriptorMap) {
        maybeRegister(descriptorMap, FragmentCompat.getSupportLibInstance());
        maybeRegister(descriptorMap, FragmentCompat.getFrameworkInstance());
        return descriptorMap;
    }

    public Object getElementToHighlightAtPosition(Object obj, int i11, int i12, Rect rect) {
        View view;
        HighlightableDescriptor highlightableDescriptor;
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            view = this.mAccessor.getView(obj);
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(view);
        } else {
            view = null;
            highlightableDescriptor = null;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getElementToHighlightAtPosition(view, i11, i12, rect);
    }

    public View getViewAndBoundsForHighlighting(Object obj, Rect rect) {
        return this.mAccessor.getView(obj);
    }

    public void onGetAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
        int id2 = this.mAccessor.getId(obj);
        if (id2 != 0) {
            attributeAccumulator.store("id", ResourcesUtil.getIdStringQuietly(obj, this.mAccessor.getResources(obj), id2));
        }
        String tag = this.mAccessor.getTag(obj);
        if (tag != null && tag.length() > 0) {
            attributeAccumulator.store("tag", tag);
        }
    }

    public void onGetChildren(Object obj, Accumulator<Object> accumulator) {
        View view = this.mAccessor.getView(obj);
        if (view != null) {
            accumulator.store(view);
        }
    }
}
