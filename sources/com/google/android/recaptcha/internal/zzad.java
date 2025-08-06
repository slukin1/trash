package com.google.android.recaptcha.internal;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class zzad {
    private final Context zza;

    public zzad(Context context) {
        this.zza = context;
    }

    public static final byte[] zza(File file) throws IOException, GeneralSecurityException {
        return FilesKt__FileReadWriteKt.a(file);
    }

    public static final void zzb(File file, byte[] bArr) throws IOException, GeneralSecurityException {
        if (!file.exists() || file.delete()) {
            FilesKt__FileReadWriteKt.c(file, bArr);
            return;
        }
        throw new IOException("Unable to delete existing encrypted file");
    }
}
