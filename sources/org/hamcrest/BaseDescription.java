package org.hamcrest;

import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.util.Arrays;
import java.util.Iterator;
import org.hamcrest.internal.ArrayIterator;
import org.hamcrest.internal.SelfDescribingValueIterator;

public abstract class BaseDescription implements Description {
    private String descriptionOf(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + TIMMentionEditText.TIM_MENTION_TAG + Integer.toHexString(obj.hashCode());
        }
    }

    private void toJavaSyntax(String str) {
        append('\"');
        for (int i11 = 0; i11 < str.length(); i11++) {
            toJavaSyntax(str.charAt(i11));
        }
        append('\"');
    }

    public abstract void append(char c11);

    public void append(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            append(str.charAt(i11));
        }
    }

    public Description appendDescriptionOf(SelfDescribing selfDescribing) {
        selfDescribing.describeTo(this);
        return this;
    }

    public Description appendList(String str, String str2, String str3, Iterable<? extends SelfDescribing> iterable) {
        return appendList(str, str2, str3, iterable.iterator());
    }

    public Description appendText(String str) {
        append(str);
        return this;
    }

    public Description appendValue(Object obj) {
        if (obj == null) {
            append(OptionsBridge.NULL_VALUE);
        } else if (obj instanceof String) {
            toJavaSyntax((String) obj);
        } else if (obj instanceof Character) {
            append('\"');
            toJavaSyntax(((Character) obj).charValue());
            append('\"');
        } else if (obj instanceof Short) {
            append('<');
            append(descriptionOf(obj));
            append("s>");
        } else if (obj instanceof Long) {
            append('<');
            append(descriptionOf(obj));
            append("L>");
        } else if (obj instanceof Float) {
            append('<');
            append(descriptionOf(obj));
            append("F>");
        } else if (obj.getClass().isArray()) {
            appendValueList("[", ", ", "]", new ArrayIterator(obj));
        } else {
            append('<');
            append(descriptionOf(obj));
            append('>');
        }
        return this;
    }

    public <T> Description appendValueList(String str, String str2, String str3, T... tArr) {
        return appendValueList(str, str2, str3, Arrays.asList(tArr));
    }

    private Description appendList(String str, String str2, String str3, Iterator<? extends SelfDescribing> it2) {
        append(str);
        boolean z11 = false;
        while (it2.hasNext()) {
            if (z11) {
                append(str2);
            }
            appendDescriptionOf((SelfDescribing) it2.next());
            z11 = true;
        }
        append(str3);
        return this;
    }

    public <T> Description appendValueList(String str, String str2, String str3, Iterable<T> iterable) {
        return appendValueList(str, str2, str3, iterable.iterator());
    }

    private <T> Description appendValueList(String str, String str2, String str3, Iterator<T> it2) {
        return appendList(str, str2, str3, (Iterator<? extends SelfDescribing>) new SelfDescribingValueIterator(it2));
    }

    private void toJavaSyntax(char c11) {
        if (c11 == 9) {
            append("\\t");
        } else if (c11 == 10) {
            append("\\n");
        } else if (c11 == 13) {
            append("\\r");
        } else if (c11 != '\"') {
            append(c11);
        } else {
            append("\\\"");
        }
    }
}
