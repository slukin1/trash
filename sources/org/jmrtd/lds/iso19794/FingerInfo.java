package org.jmrtd.lds.iso19794;

import com.luck.picture.lib.config.PictureMimeType;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.jmrtd.cbeff.BiometricDataBlock;
import org.jmrtd.cbeff.StandardBiometricHeader;
import org.jmrtd.lds.AbstractListInfo;
import org.jmrtd.lds.ImageInfo;

public class FingerInfo extends AbstractListInfo<FingerImageInfo> implements BiometricDataBlock {
    public static final int COMPRESSION_JPEG = 3;
    public static final int COMPRESSION_JPEG2000 = 4;
    public static final int COMPRESSION_PNG = 5;
    public static final int COMPRESSION_UNCOMPRESSED_BIT_PACKED = 1;
    public static final int COMPRESSION_UNCOMPRESSED_NO_BIT_PACKING = 0;
    public static final int COMPRESSION_WSQ = 2;
    private static final int FORMAT_IDENTIFIER = 1179210240;
    private static final int FORMAT_OWNER_VALUE = 257;
    private static final int FORMAT_TYPE_VALUE = 7;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final int SCALE_UNITS_PPCM = 2;
    public static final int SCALE_UNITS_PPI = 1;
    private static final int VERSION_NUMBER = 808529920;
    private static final long serialVersionUID = 5808625058034008176L;
    private int acquisitionLevel;
    private int captureDeviceId;
    private int compressionAlgorithm;
    private int depth;
    private int imageResolutionHorizontal;
    private int imageResolutionVertical;
    private StandardBiometricHeader sbh;
    private int scaleUnits;
    private int scanResolutionHorizontal;
    private int scanResolutionVertical;

    public FingerInfo(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, List<FingerImageInfo> list) {
        this((StandardBiometricHeader) null, i11, i12, i13, i14, i15, i16, i17, i18, i19, list);
    }

    public static int fromMimeType(String str) {
        if (ImageInfo.WSQ_MIME_TYPE.equals(str)) {
            return 2;
        }
        if ("image/jpeg".equals(str)) {
            return 3;
        }
        if ("image/jpeg2000".equals(str)) {
            return 4;
        }
        if ("images/png".equals(str)) {
            return 5;
        }
        throw new IllegalArgumentException("Did not recognize mimeType");
    }

    private int getBiometricSubtype() {
        boolean z11 = true;
        int i11 = 0;
        for (FingerImageInfo biometricSubtype : getSubRecords()) {
            int biometricSubtype2 = biometricSubtype.getBiometricSubtype();
            if (z11) {
                z11 = false;
                i11 = biometricSubtype2;
            } else {
                i11 &= biometricSubtype2;
            }
        }
        return i11;
    }

    private static long readUnsignedLong(InputStream inputStream, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        (inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream)).readFully(bArr);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) + ((long) (bArr[i12] & 255));
        }
        return j11;
    }

    public static String toMimeType(int i11) {
        if (i11 == 0 || i11 == 1) {
            return "image/raw";
        }
        if (i11 == 2) {
            return ImageInfo.WSQ_MIME_TYPE;
        }
        if (i11 == 3) {
            return "image/jpeg";
        }
        if (i11 == 4) {
            return "image/jpeg2000";
        }
        if (i11 != 5) {
            return null;
        }
        return PictureMimeType.PNG_Q;
    }

    private static void writeLong(long j11, OutputStream outputStream, int i11) throws IOException {
        if (i11 > 0) {
            for (int i12 = 0; i12 < i11 - 8; i12++) {
                outputStream.write(0);
            }
            if (i11 > 8) {
                i11 = 8;
            }
            for (int i13 = i11 - 1; i13 >= 0; i13--) {
                int i14 = i13 * 8;
                outputStream.write((byte) ((int) (((255 << i14) & j11) >> i14)));
            }
        }
    }

    public void addFingerImageInfo(FingerImageInfo fingerImageInfo) {
        add(fingerImageInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        FingerInfo fingerInfo = (FingerInfo) obj;
        if (this.acquisitionLevel == fingerInfo.acquisitionLevel && this.captureDeviceId == fingerInfo.captureDeviceId && this.compressionAlgorithm == fingerInfo.compressionAlgorithm && this.depth == fingerInfo.depth && this.imageResolutionHorizontal == fingerInfo.imageResolutionHorizontal && this.imageResolutionVertical == fingerInfo.imageResolutionVertical && this.scaleUnits == fingerInfo.scaleUnits && this.scanResolutionHorizontal == fingerInfo.scanResolutionHorizontal && this.scanResolutionVertical == fingerInfo.scanResolutionVertical) {
            return true;
        }
        return false;
    }

    public int getAcquisitionLevel() {
        return this.acquisitionLevel;
    }

    public int getCaptureDeviceId() {
        return this.captureDeviceId;
    }

    public int getCompressionAlgorithm() {
        return this.compressionAlgorithm;
    }

    public int getDepth() {
        return this.depth;
    }

    public List<FingerImageInfo> getFingerImageInfos() {
        return getSubRecords();
    }

    public int getHorizontalImageResolution() {
        return this.imageResolutionHorizontal;
    }

    public int getHorizontalScanningResolution() {
        return this.scanResolutionHorizontal;
    }

    public int getScaleUnits() {
        return this.scaleUnits;
    }

    public StandardBiometricHeader getStandardBiometricHeader() {
        if (this.sbh == null) {
            byte[] bArr = {(byte) getBiometricSubtype()};
            TreeMap treeMap = new TreeMap();
            treeMap.put(129, new byte[]{8});
            treeMap.put(130, bArr);
            treeMap.put(135, new byte[]{1, 1});
            treeMap.put(136, new byte[]{0, 7});
            this.sbh = new StandardBiometricHeader(treeMap);
        }
        return this.sbh;
    }

    public int getVerticalImageResolution() {
        return this.imageResolutionVertical;
    }

    public int getVerticalScanningResolution() {
        return this.scanResolutionVertical;
    }

    public int hashCode() {
        int hashCode = ((((((((((((super.hashCode() * 31) + this.acquisitionLevel) * 31) + this.captureDeviceId) * 31) + this.compressionAlgorithm) * 31) + this.depth) * 31) + this.imageResolutionHorizontal) * 31) + this.imageResolutionVertical) * 31;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        return ((((((hashCode + (standardBiometricHeader == null ? 0 : standardBiometricHeader.hashCode())) * 31) + this.scaleUnits) * 31) + this.scanResolutionHorizontal) * 31) + this.scanResolutionVertical;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        if (readInt == FORMAT_IDENTIFIER) {
            int readInt2 = dataInputStream.readInt();
            if (readInt2 == VERSION_NUMBER) {
                long readUnsignedLong = readUnsignedLong(dataInputStream, 6);
                this.captureDeviceId = dataInputStream.readUnsignedShort();
                this.acquisitionLevel = dataInputStream.readUnsignedShort();
                int readUnsignedByte = dataInputStream.readUnsignedByte();
                this.scaleUnits = dataInputStream.readUnsignedByte();
                this.scanResolutionHorizontal = dataInputStream.readUnsignedShort();
                this.scanResolutionVertical = dataInputStream.readUnsignedShort();
                this.imageResolutionHorizontal = dataInputStream.readUnsignedShort();
                this.imageResolutionVertical = dataInputStream.readUnsignedShort();
                this.depth = dataInputStream.readUnsignedByte();
                this.compressionAlgorithm = dataInputStream.readUnsignedByte();
                dataInputStream.readUnsignedShort();
                long j11 = readUnsignedLong - 32;
                long j12 = 0;
                for (int i11 = 0; i11 < readUnsignedByte; i11++) {
                    FingerImageInfo fingerImageInfo = new FingerImageInfo(inputStream, this.compressionAlgorithm);
                    j12 += fingerImageInfo.getRecordLength();
                    add(fingerImageInfo);
                }
                if (j11 != j12) {
                    Logger logger = LOGGER;
                    logger.warning("ConstructedDataLength and dataLength differ: dataLength = " + j11 + ", constructedDataLength = " + j12);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("'010' version number expected! Found " + Integer.toHexString(readInt2));
        }
        throw new IllegalArgumentException("'FIR' marker expected! Found " + Integer.toHexString(readInt));
    }

    public void removeFingerImageInfo(int i11) {
        remove(i11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FingerInfo [");
        for (FingerImageInfo fingerImageInfo : getSubRecords()) {
            sb2.append(fingerImageInfo.toString());
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        List<FingerImageInfo> subRecords = getSubRecords();
        long j11 = 0;
        for (FingerImageInfo recordLength : subRecords) {
            j11 += recordLength.getRecordLength();
        }
        long j12 = 32 + j11;
        DataOutputStream dataOutputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        dataOutputStream.writeInt(FORMAT_IDENTIFIER);
        dataOutputStream.writeInt(VERSION_NUMBER);
        writeLong(j12, dataOutputStream, 6);
        dataOutputStream.writeShort(this.captureDeviceId);
        dataOutputStream.writeShort(this.acquisitionLevel);
        dataOutputStream.writeByte(subRecords.size());
        dataOutputStream.writeByte(this.scaleUnits);
        dataOutputStream.writeShort(this.scanResolutionHorizontal);
        dataOutputStream.writeShort(this.scanResolutionVertical);
        dataOutputStream.writeShort(this.imageResolutionHorizontal);
        dataOutputStream.writeShort(this.imageResolutionVertical);
        dataOutputStream.writeByte(this.depth);
        dataOutputStream.writeByte(this.compressionAlgorithm);
        dataOutputStream.writeShort(0);
        for (FingerImageInfo writeObject : subRecords) {
            writeObject.writeObject(dataOutputStream);
        }
    }

    public FingerInfo(StandardBiometricHeader standardBiometricHeader, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, List<FingerImageInfo> list) {
        this.sbh = standardBiometricHeader;
        this.captureDeviceId = i11;
        this.acquisitionLevel = i12;
        this.scaleUnits = i13;
        this.scanResolutionHorizontal = i14;
        this.scanResolutionVertical = i15;
        this.imageResolutionHorizontal = i16;
        this.imageResolutionVertical = i17;
        this.depth = i18;
        this.compressionAlgorithm = i19;
        addAll(list);
    }

    public FingerInfo(InputStream inputStream) throws IOException {
        this((StandardBiometricHeader) null, inputStream);
    }

    public FingerInfo(StandardBiometricHeader standardBiometricHeader, InputStream inputStream) throws IOException {
        this.sbh = standardBiometricHeader;
        readObject(inputStream);
    }
}
