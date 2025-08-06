package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ThreadBound;

public interface NodeDescriptor<E> extends ThreadBound {
    void getAttributes(E e11, AttributeAccumulator attributeAccumulator);

    void getChildren(E e11, Accumulator<Object> accumulator);

    void getComputedStyles(E e11, ComputedStyleAccumulator computedStyleAccumulator);

    String getLocalName(E e11);

    String getNodeName(E e11);

    NodeType getNodeType(E e11);

    String getNodeValue(E e11);

    void getStyleRuleNames(E e11, StyleRuleNameAccumulator styleRuleNameAccumulator);

    void getStyles(E e11, String str, StyleAccumulator styleAccumulator);

    void hook(E e11);

    void setAttributesAsText(E e11, String str);

    void setStyle(E e11, String str, String str2, String str3);

    void unhook(E e11);
}
