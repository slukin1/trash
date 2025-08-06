package org.jmrtd.cbeff;

import java.io.IOException;
import java.io.InputStream;
import org.jmrtd.cbeff.BiometricDataBlock;

public interface BiometricDataBlockDecoder<B extends BiometricDataBlock> {
    B decode(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i11, int i12) throws IOException;
}
