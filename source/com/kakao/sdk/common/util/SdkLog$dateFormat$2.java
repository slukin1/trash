package com.kakao.sdk.common.util;

import d10.a;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/SimpleDateFormat;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SdkLog$dateFormat$2 extends Lambda implements a<SimpleDateFormat> {
    public static final SdkLog$dateFormat$2 INSTANCE = new SdkLog$dateFormat$2();

    public SdkLog$dateFormat$2() {
        super(0);
    }

    public final SimpleDateFormat invoke() {
        return new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    }
}
