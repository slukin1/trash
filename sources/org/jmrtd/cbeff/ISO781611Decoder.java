package org.jmrtd.cbeff;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.HashMap;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVUtil;

public class ISO781611Decoder implements ISO781611 {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private BiometricDataBlockDecoder<?> bdbDecoder;

    public ISO781611Decoder(BiometricDataBlockDecoder<?> biometricDataBlockDecoder) {
        this.bdbDecoder = biometricDataBlockDecoder;
    }

    private byte[] decodeSMTValue(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        int readLength = tLVInputStream.readLength();
        if (readTag == 129) {
            return tLVInputStream.readValue();
        }
        if (readTag != 133) {
            long j11 = 0;
            if (readTag == 142) {
                while (true) {
                    long j12 = (long) readLength;
                    if (j11 >= j12) {
                        return null;
                    }
                    j11 += tLVInputStream.skip(j12);
                }
            } else if (readTag != 158) {
                Logger logger = LOGGER;
                logger.info("Unsupported data object tag " + Integer.toHexString(readTag));
                return null;
            } else {
                while (true) {
                    long j13 = (long) readLength;
                    if (j11 >= j13) {
                        return null;
                    }
                    j11 += tLVInputStream.skip(j13);
                }
            }
        } else {
            throw new AccessControlException("Access denied. Biometric Information Template is statically protected.");
        }
    }

    private StandardBiometricHeader readBHT(InputStream inputStream, int i11, int i12, int i13) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        if (i11 != 161) {
            Logger logger = LOGGER;
            logger.warning("Expected tag " + Integer.toHexString(161) + ", found " + Integer.toHexString(i11));
        }
        HashMap hashMap = new HashMap();
        int i14 = 0;
        while (i14 < i12) {
            int readTag = tLVInputStream.readTag();
            int tagLength = i14 + TLVUtil.getTagLength(readTag) + TLVUtil.getLengthLength(tLVInputStream.readLength());
            byte[] readValue = tLVInputStream.readValue();
            i14 = tagLength + readValue.length;
            hashMap.put(Integer.valueOf(readTag), readValue);
        }
        return new StandardBiometricHeader(hashMap);
    }

    private CBEFFInfo readBIT(InputStream inputStream, int i11) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        return readBIT(tLVInputStream.readTag(), tLVInputStream.readLength(), inputStream, i11);
    }

    private ComplexCBEFFInfo readBITGroup(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        if (readTag == 32609) {
            return readBITGroup(readTag, tLVInputStream.readLength(), inputStream);
        }
        throw new IllegalArgumentException("Expected tag " + Integer.toHexString(ISO781611.BIOMETRIC_INFORMATION_GROUP_TEMPLATE_TAG) + ", found " + Integer.toHexString(readTag));
    }

    private BiometricDataBlock readBiometricDataBlock(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i11) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        if (readTag == 24366 || readTag == 32558) {
            return this.bdbDecoder.decode(inputStream, standardBiometricHeader, i11, tLVInputStream.readLength());
        }
        throw new IllegalArgumentException("Expected tag BIOMETRIC_DATA_BLOCK_TAG (" + Integer.toHexString(ISO781611.BIOMETRIC_DATA_BLOCK_TAG) + ") or BIOMETRIC_DATA_BLOCK_TAG_ALT (" + Integer.toHexString(ISO781611.BIOMETRIC_DATA_BLOCK_CONSTRUCTED_TAG) + "), found " + Integer.toHexString(readTag));
    }

    private void readStaticallyProtectedBIT(InputStream inputStream, int i11, int i12, int i13) throws IOException {
        TLVInputStream tLVInputStream = new TLVInputStream(new ByteArrayInputStream(decodeSMTValue(inputStream)));
        try {
            readBiometricDataBlock(new ByteArrayInputStream(decodeSMTValue(inputStream)), readBHT(tLVInputStream, tLVInputStream.readTag(), tLVInputStream.readLength(), i13), i13);
        } finally {
            tLVInputStream.close();
        }
    }

    public ComplexCBEFFInfo decode(InputStream inputStream) throws IOException {
        return readBITGroup(inputStream);
    }

    private CBEFFInfo readBIT(int i11, int i12, InputStream inputStream, int i13) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        if (i11 == 32608) {
            int readTag = tLVInputStream.readTag();
            int readLength = tLVInputStream.readLength();
            if (readTag == 125) {
                readStaticallyProtectedBIT(inputStream, readTag, readLength, i13);
                return null;
            } else if ((readTag & 160) == 160) {
                return new SimpleCBEFFInfo(readBiometricDataBlock(inputStream, readBHT(inputStream, readTag, readLength, i13), i13));
            } else {
                throw new IllegalArgumentException("Unsupported template tag: " + Integer.toHexString(readTag));
            }
        } else {
            throw new IllegalArgumentException("Expected tag BIOMETRIC_INFORMATION_TEMPLATE_TAG (" + Integer.toHexString(ISO781611.BIOMETRIC_INFORMATION_TEMPLATE_TAG) + "), found " + Integer.toHexString(i11) + ", index is " + i13);
        }
    }

    private ComplexCBEFFInfo readBITGroup(int i11, int i12, InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        ComplexCBEFFInfo complexCBEFFInfo = new ComplexCBEFFInfo();
        if (i11 == 32609) {
            int readTag = tLVInputStream.readTag();
            if (readTag == 2) {
                int readLength = tLVInputStream.readLength();
                if (readLength == 1) {
                    byte[] readValue = tLVInputStream.readValue();
                    byte b11 = readValue[0] & 255;
                    for (int i13 = 0; i13 < b11; i13++) {
                        complexCBEFFInfo.add(readBIT(inputStream, i13));
                    }
                    return complexCBEFFInfo;
                }
                throw new IllegalArgumentException("BIOMETRIC_INFO_COUNT should have length 1, found length " + readLength);
            }
            throw new IllegalArgumentException("Expected tag BIOMETRIC_INFO_COUNT_TAG (" + Integer.toHexString(2) + ") in CBEFF structure, found " + Integer.toHexString(readTag));
        }
        throw new IllegalArgumentException("Expected tag " + Integer.toHexString(ISO781611.BIOMETRIC_INFORMATION_GROUP_TEMPLATE_TAG) + ", found " + Integer.toHexString(i11));
    }
}
