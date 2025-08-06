package com.tencent.mm.sdk.b;

import com.tencent.mm.a.a;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;

public final class d {
    private final a E;
    private c<String, String> F;

    public final String i(String str) {
        try {
            if (!str.startsWith(TopicOperation.OPERATION_PAIR_DIVIDER)) {
                return str;
            }
            if (this.F.a(str)) {
                return this.F.get(str);
            }
            String substring = str.substring(1);
            try {
                String[] split = substring.split(TIMMentionEditText.TIM_MENTION_TAG);
                if (split.length <= 1) {
                    return substring;
                }
                String str2 = split[0];
                int intValue = Integer.valueOf(split[0]).intValue();
                String substring2 = substring.substring(str2.length() + 1, str2.length() + 1 + intValue);
                String str3 = this.E.h(substring2) + substring.substring(str2.length() + 1 + intValue);
                this.F.put(str, str3);
                return str3;
            } catch (Exception e11) {
                e = e11;
                str = substring;
                e.printStackTrace();
                return "[td]" + str;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            return "[td]" + str;
        }
    }
}
