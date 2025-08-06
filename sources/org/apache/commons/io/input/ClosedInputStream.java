package org.apache.commons.io.input;

import java.io.InputStream;

public class ClosedInputStream extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public static final ClosedInputStream f58948b = new ClosedInputStream();

    public int read() {
        return -1;
    }
}
