package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@Beta
public final class Flushables {
    private static final Logger logger = Logger.getLogger(Flushables.class.getName());

    private Flushables() {
    }

    public static void flush(Flushable flushable, boolean z11) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e11) {
            if (z11) {
                logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", e11);
                return;
            }
            throw e11;
        }
    }

    public static void flushQuietly(Flushable flushable) {
        try {
            flush(flushable, true);
        } catch (IOException e11) {
            logger.log(Level.SEVERE, "IOException should not have been thrown.", e11);
        }
    }
}
