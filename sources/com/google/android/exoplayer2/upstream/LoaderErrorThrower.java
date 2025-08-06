package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface LoaderErrorThrower {

    public static final class Dummy implements LoaderErrorThrower {
        public void maybeThrowError() {
        }

        public void maybeThrowError(int i11) {
        }
    }

    void maybeThrowError() throws IOException;

    void maybeThrowError(int i11) throws IOException;
}
