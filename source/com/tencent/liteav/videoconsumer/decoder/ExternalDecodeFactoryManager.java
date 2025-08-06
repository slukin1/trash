package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;

public class ExternalDecodeFactoryManager {

    /* renamed from: a  reason: collision with root package name */
    private static b f22377a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f22378b;

    public static synchronized void a(b bVar) {
        synchronized (ExternalDecodeFactoryManager.class) {
            f22378b = null;
            f22377a = bVar;
        }
    }

    public static synchronized long createH265Decoder() {
        synchronized (ExternalDecodeFactoryManager.class) {
            b bVar = f22377a;
            if (bVar == null) {
                return 0;
            }
            long a11 = bVar.a();
            return a11;
        }
    }

    public static synchronized void destroyH265Decoder(long j11) {
        synchronized (ExternalDecodeFactoryManager.class) {
            b bVar = f22377a;
            if (bVar == null) {
                LiteavLog.w("ExternalDecodeFactoryManager", "DestroyHevcDecoder sDecoderFactory is null: ".concat(String.valueOf(j11)));
            } else {
                bVar.a(j11);
            }
        }
    }

    public static synchronized boolean isExternalDecoderHevcSupport() {
        synchronized (ExternalDecodeFactoryManager.class) {
            b bVar = f22377a;
            if (bVar == null) {
                return false;
            }
            Boolean bool = f22378b;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            long a11 = bVar.a();
            if (a11 != 0) {
                f22377a.a(a11);
                f22378b = Boolean.TRUE;
            } else {
                f22378b = Boolean.FALSE;
            }
            boolean booleanValue2 = f22378b.booleanValue();
            return booleanValue2;
        }
    }
}
