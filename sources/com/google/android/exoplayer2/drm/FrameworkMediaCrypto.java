package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Util;
import java.util.UUID;

public final class FrameworkMediaCrypto implements ExoMediaCrypto {
    public static final boolean WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC;
    public final boolean forceAllowInsecureDecoderComponents;
    public final byte[] sessionId;
    public final UUID uuid;

    static {
        boolean z11;
        if ("Amazon".equals(Util.MANUFACTURER)) {
            String str = Util.MODEL;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z11 = true;
                WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC = z11;
            }
        }
        z11 = false;
        WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC = z11;
    }

    public FrameworkMediaCrypto(UUID uuid2, byte[] bArr, boolean z11) {
        this.uuid = uuid2;
        this.sessionId = bArr;
        this.forceAllowInsecureDecoderComponents = z11;
    }
}
