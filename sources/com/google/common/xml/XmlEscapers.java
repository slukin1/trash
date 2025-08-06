package com.google.common.xml;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import okio.Utf8;

@GwtCompatible
@Beta
public class XmlEscapers {
    private static final char MAX_ASCII_CONTROL_CHAR = '\u001f';
    private static final char MIN_ASCII_CONTROL_CHAR = 0;
    private static final Escaper XML_ATTRIBUTE_ESCAPER;
    private static final Escaper XML_CONTENT_ESCAPER;
    private static final Escaper XML_ESCAPER;

    static {
        Escapers.Builder builder = Escapers.builder();
        builder.setSafeRange(0, Utf8.REPLACEMENT_CHARACTER);
        builder.setUnsafeReplacement("�");
        for (char c11 = 0; c11 <= 31; c11 = (char) (c11 + 1)) {
            if (!(c11 == 9 || c11 == 10 || c11 == 13)) {
                builder.addEscape(c11, "�");
            }
        }
        builder.addEscape('&', "&amp;");
        builder.addEscape('<', "&lt;");
        builder.addEscape('>', "&gt;");
        XML_CONTENT_ESCAPER = builder.build();
        builder.addEscape('\'', "&apos;");
        builder.addEscape('\"', "&quot;");
        XML_ESCAPER = builder.build();
        builder.addEscape(9, "&#x9;");
        builder.addEscape(10, "&#xA;");
        builder.addEscape(13, "&#xD;");
        XML_ATTRIBUTE_ESCAPER = builder.build();
    }

    private XmlEscapers() {
    }

    public static Escaper xmlAttributeEscaper() {
        return XML_ATTRIBUTE_ESCAPER;
    }

    public static Escaper xmlContentEscaper() {
        return XML_CONTENT_ESCAPER;
    }
}
