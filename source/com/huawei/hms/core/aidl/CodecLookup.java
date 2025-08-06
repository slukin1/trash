package com.huawei.hms.core.aidl;

public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec find(int i11) {
        if (i11 == 2) {
            return new MessageCodecV2();
        }
        return new MessageCodec();
    }
}
