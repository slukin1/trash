package com.tencent.imsdk.conversation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConversationAtInfo implements Serializable {
    public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
    public static final int TIM_AT_ALL = 2;
    public static final int TIM_AT_ALL_AT_ME = 3;
    public static final int TIM_AT_ME = 1;
    public static final int TIM_AT_UNKNOWN = 0;
    private long atMessageSequence;
    private List<Integer> atTypes = new ArrayList();

    public void addAtType(int i11) {
        this.atTypes.add(Integer.valueOf(i11));
    }

    public long getAtMessageSequence() {
        return this.atMessageSequence;
    }

    public int getAtType() {
        int i11 = 0;
        for (Integer intValue : this.atTypes) {
            int intValue2 = intValue.intValue();
            if (intValue2 == 1) {
                i11 |= 1;
            } else if (intValue2 == 2) {
                i11 |= 2;
            }
        }
        return i11;
    }
}
