package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;

public abstract class AbstractChainedDescriptor<E> extends Descriptor<E> implements ChainedDescriptor<E> {
    private Descriptor<? super E> mSuper;

    public final void getAttributes(E e11, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(e11, attributeAccumulator);
        onGetAttributes(e11, attributeAccumulator);
    }

    public final void getChildren(E e11, Accumulator<Object> accumulator) {
        this.mSuper.getChildren(e11, accumulator);
        onGetChildren(e11, accumulator);
    }

    public void getComputedStyles(E e11, ComputedStyleAccumulator computedStyleAccumulator) {
        this.mSuper.getComputedStyles(e11, computedStyleAccumulator);
        onGetComputedStyles(e11, computedStyleAccumulator);
    }

    public final String getLocalName(E e11) {
        return onGetLocalName(e11);
    }

    public final String getNodeName(E e11) {
        return onGetNodeName(e11);
    }

    public final NodeType getNodeType(E e11) {
        return onGetNodeType(e11);
    }

    public final String getNodeValue(E e11) {
        return onGetNodeValue(e11);
    }

    public final void getStyleRuleNames(E e11, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        this.mSuper.getStyleRuleNames(e11, styleRuleNameAccumulator);
        onGetStyleRuleNames(e11, styleRuleNameAccumulator);
    }

    public final void getStyles(E e11, String str, StyleAccumulator styleAccumulator) {
        this.mSuper.getStyles(e11, str, styleAccumulator);
        onGetStyles(e11, str, styleAccumulator);
    }

    public final Descriptor<? super E> getSuper() {
        return this.mSuper;
    }

    public final void hook(E e11) {
        verifyThreadAccess();
        this.mSuper.hook(e11);
        onHook(e11);
    }

    public void onGetAttributes(E e11, AttributeAccumulator attributeAccumulator) {
    }

    public void onGetChildren(E e11, Accumulator<Object> accumulator) {
    }

    public void onGetComputedStyles(E e11, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    public String onGetLocalName(E e11) {
        return this.mSuper.getLocalName(e11);
    }

    public String onGetNodeName(E e11) {
        return this.mSuper.getNodeName(e11);
    }

    public NodeType onGetNodeType(E e11) {
        return this.mSuper.getNodeType(e11);
    }

    public String onGetNodeValue(E e11) {
        return this.mSuper.getNodeValue(e11);
    }

    public void onGetStyleRuleNames(E e11, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    public void onGetStyles(E e11, String str, StyleAccumulator styleAccumulator) {
    }

    public void onHook(E e11) {
    }

    public void onSetAttributesAsText(E e11, String str) {
        this.mSuper.setAttributesAsText(e11, str);
    }

    public void onSetStyle(E e11, String str, String str2, String str3) {
    }

    public void onUnhook(E e11) {
    }

    public final void setAttributesAsText(E e11, String str) {
        onSetAttributesAsText(e11, str);
    }

    public final void setStyle(E e11, String str, String str2, String str3) {
        this.mSuper.setStyle(e11, str, str2, str3);
        onSetStyle(e11, str, str2, str3);
    }

    public void setSuper(Descriptor<? super E> descriptor) {
        Util.throwIfNull(descriptor);
        Descriptor<? super E> descriptor2 = this.mSuper;
        if (descriptor == descriptor2) {
            return;
        }
        if (descriptor2 == null) {
            this.mSuper = descriptor;
            return;
        }
        throw new IllegalStateException();
    }

    public final void unhook(E e11) {
        verifyThreadAccess();
        onUnhook(e11);
        this.mSuper.unhook(e11);
    }
}
