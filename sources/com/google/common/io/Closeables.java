package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@Beta
public final class Closeables {
    @VisibleForTesting
    public static final Logger logger = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void close(Closeable closeable, boolean z11) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e11) {
                if (z11) {
                    logger.log(Level.WARNING, "IOException thrown while closing Closeable.", e11);
                    return;
                }
                throw e11;
            }
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public static void closeQuietly(Reader reader) {
        try {
            close(reader, true);
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
