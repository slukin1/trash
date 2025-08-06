package org.jmrtd.cbeff;

import java.io.IOException;
import java.io.OutputStream;
import org.jmrtd.cbeff.BiometricDataBlock;

public interface BiometricDataBlockEncoder<B extends BiometricDataBlock> {
    void encode(B b11, OutputStream outputStream) throws IOException;
}
