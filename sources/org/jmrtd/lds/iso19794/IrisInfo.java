package org.jmrtd.lds.iso19794;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.jmrtd.cbeff.BiometricDataBlock;
import org.jmrtd.cbeff.StandardBiometricHeader;
import org.jmrtd.lds.AbstractListInfo;

public class IrisInfo extends AbstractListInfo<IrisBiometricSubtypeInfo> implements BiometricDataBlock {
    public static final int CAPTURE_DEVICE_UNDEF = 0;
    private static final int FORMAT_IDENTIFIER = 1229541888;
    private static final int FORMAT_OWNER_VALUE = 257;
    private static final int FORMAT_TYPE_VALUE = 9;
    public static final int IMAGEFORMAT_MONO_JPEG = 6;
    public static final int IMAGEFORMAT_MONO_JPEG2000 = 14;
    public static final int IMAGEFORMAT_MONO_JPEG_LS = 10;
    public static final int IMAGEFORMAT_MONO_RAW = 2;
    public static final int IMAGEFORMAT_RGB_JPEG = 8;
    public static final int IMAGEFORMAT_RGB_JPEG2000 = 16;
    public static final int IMAGEFORMAT_RGB_JPEG_LS = 12;
    public static final int IMAGEFORMAT_RGB_RAW = 4;
    public static final int INTENSITY_DEPTH_UNDEF = 0;
    public static final int IRBNDY_PROCESSED = 1;
    public static final int IRBNDY_UNDEF = 0;
    public static final int IROCC_PROCESSED = 1;
    public static final int IROCC_UNDEF = 0;
    public static final int IROCC_ZEROFILL = 0;
    public static final int IROC_UNITFILL = 1;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final int ORIENTATION_BASE = 1;
    public static final int ORIENTATION_FLIPPED = 2;
    public static final int ORIENTATION_UNDEF = 0;
    public static final int SCAN_TYPE_CORRECTED = 4;
    public static final int SCAN_TYPE_INTERLACE_FIELD = 3;
    public static final int SCAN_TYPE_INTERLACE_FRAME = 2;
    public static final int SCAN_TYPE_PROGRESSIVE = 1;
    public static final int SCAN_TYPE_UNDEF = 0;
    public static final int TRANS_STD = 1;
    public static final int TRANS_UNDEF = 0;
    private static final int VERSION_NUMBER = 808529920;
    private static final long serialVersionUID = -3415309711643815511L;
    private int boundaryExtraction;
    private int captureDeviceId;
    private byte[] deviceUniqueId;
    private int horizontalOrientation;
    private int imageFormat;
    private int imageTransformation;
    private int intensityDepth;
    private int irisDiameter;
    private int irisOcclusion;
    private int occlusionFilling;
    private int rawImageHeight;
    private int rawImageWidth;
    private long recordLength;
    private StandardBiometricHeader sbh;
    private int scanType;
    private int verticalOrientation;

    public IrisInfo(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, byte[] bArr, List<IrisBiometricSubtypeInfo> list) {
        this((StandardBiometricHeader) null, i11, i12, i13, i14, i15, i16, i17, i18, i19, i21, i22, i23, i24, bArr, list);
    }

    private int getBiometricSubtype() {
        int i11 = 0;
        for (IrisBiometricSubtypeInfo biometricSubtype : getSubRecords()) {
            i11 &= biometricSubtype.getBiometricSubtype();
        }
        return i11;
    }

    public void addIrisBiometricSubtypeInfo(IrisBiometricSubtypeInfo irisBiometricSubtypeInfo) {
        add(irisBiometricSubtypeInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        IrisInfo irisInfo = (IrisInfo) obj;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        if (standardBiometricHeader == null) {
            if (irisInfo.sbh != null) {
                return false;
            }
        } else if (!standardBiometricHeader.equals(irisInfo.sbh)) {
            return false;
        }
        return this.boundaryExtraction == irisInfo.boundaryExtraction && this.captureDeviceId == irisInfo.captureDeviceId && Arrays.equals(this.deviceUniqueId, irisInfo.deviceUniqueId) && this.horizontalOrientation == irisInfo.horizontalOrientation && this.imageFormat == irisInfo.imageFormat && this.imageTransformation == irisInfo.imageTransformation && this.intensityDepth == irisInfo.intensityDepth && this.irisDiameter == irisInfo.irisDiameter && this.irisOcclusion == irisInfo.irisOcclusion && this.occlusionFilling == irisInfo.occlusionFilling && this.rawImageHeight == irisInfo.rawImageHeight && this.rawImageWidth == irisInfo.rawImageWidth && this.recordLength == irisInfo.recordLength && this.scanType == irisInfo.scanType && this.verticalOrientation == irisInfo.verticalOrientation;
    }

    public int getBoundaryExtraction() {
        return this.boundaryExtraction;
    }

    public int getCaptureDeviceId() {
        return this.captureDeviceId;
    }

    public byte[] getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    public int getHorizontalOrientation() {
        return this.horizontalOrientation;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public int getImageTransformation() {
        return this.imageTransformation;
    }

    public int getIntensityDepth() {
        return this.intensityDepth;
    }

    public List<IrisBiometricSubtypeInfo> getIrisBiometricSubtypeInfos() {
        return getSubRecords();
    }

    public int getIrisDiameter() {
        return this.irisDiameter;
    }

    public int getIrisOcclusion() {
        return this.irisOcclusion;
    }

    public int getOcclusionFilling() {
        return this.occlusionFilling;
    }

    public int getRawImageHeight() {
        return this.rawImageHeight;
    }

    public int getRawImageWidth() {
        return this.rawImageWidth;
    }

    public int getScanType() {
        return this.scanType;
    }

    public StandardBiometricHeader getStandardBiometricHeader() {
        if (this.sbh == null) {
            byte[] bArr = {(byte) getBiometricSubtype()};
            TreeMap treeMap = new TreeMap();
            treeMap.put(129, new byte[]{8});
            treeMap.put(130, bArr);
            treeMap.put(135, new byte[]{1, 1});
            treeMap.put(136, new byte[]{0, 9});
            this.sbh = new StandardBiometricHeader(treeMap);
        }
        return this.sbh;
    }

    public int getVerticalOrientation() {
        return this.verticalOrientation;
    }

    public int hashCode() {
        long j11 = this.recordLength;
        int hashCode = ((((((((((((((((((((((((((super.hashCode() * 31) + this.boundaryExtraction) * 31) + this.captureDeviceId) * 31) + Arrays.hashCode(this.deviceUniqueId)) * 31) + this.horizontalOrientation) * 31) + this.imageFormat) * 31) + this.imageTransformation) * 31) + this.intensityDepth) * 31) + this.irisDiameter) * 31) + this.irisOcclusion) * 31) + this.occlusionFilling) * 31) + this.rawImageHeight) * 31) + this.rawImageWidth) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        return ((((hashCode + (standardBiometricHeader == null ? 0 : standardBiometricHeader.hashCode())) * 31) + this.scanType) * 31) + this.verticalOrientation;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        if (readInt == FORMAT_IDENTIFIER) {
            int readInt2 = dataInputStream.readInt();
            if (readInt2 == VERSION_NUMBER) {
                long readInt3 = (long) dataInputStream.readInt();
                this.recordLength = readInt3;
                long j11 = readInt3 - 45;
                this.captureDeviceId = dataInputStream.readUnsignedShort();
                int readUnsignedByte = dataInputStream.readUnsignedByte();
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                if (((long) readUnsignedShort) == 45) {
                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                    this.horizontalOrientation = readUnsignedShort2 & 3;
                    this.verticalOrientation = (readUnsignedShort2 & 12) >> 2;
                    this.scanType = (readUnsignedShort2 & 112) >> 4;
                    this.irisOcclusion = (readUnsignedShort2 & 128) >> 7;
                    this.occlusionFilling = (readUnsignedShort2 & 256) >> 8;
                    this.boundaryExtraction = (readUnsignedShort2 & 512) >> 9;
                    this.irisDiameter = dataInputStream.readUnsignedShort();
                    this.imageFormat = dataInputStream.readUnsignedShort();
                    this.rawImageWidth = dataInputStream.readUnsignedShort();
                    this.rawImageHeight = dataInputStream.readUnsignedShort();
                    this.intensityDepth = dataInputStream.readUnsignedByte();
                    this.imageTransformation = dataInputStream.readUnsignedByte();
                    byte[] bArr = new byte[16];
                    this.deviceUniqueId = bArr;
                    dataInputStream.readFully(bArr);
                    long j12 = 0;
                    for (int i11 = 0; i11 < readUnsignedByte; i11++) {
                        IrisBiometricSubtypeInfo irisBiometricSubtypeInfo = new IrisBiometricSubtypeInfo(inputStream, this.imageFormat);
                        j12 += irisBiometricSubtypeInfo.getRecordLength();
                        add(irisBiometricSubtypeInfo);
                    }
                    if (j11 != j12) {
                        Logger logger = LOGGER;
                        logger.warning("ConstructedDataLength and dataLength differ: dataLength = " + j11 + ", constructedDataLength = " + j12);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Expected header length " + 45 + ", found " + readUnsignedShort);
            }
            throw new IllegalArgumentException("'010' version number expected! Found " + Integer.toHexString(readInt2));
        }
        throw new IllegalArgumentException("'IIR' marker expected! Found " + Integer.toHexString(readInt));
    }

    public void removeIrisBiometricSubtypeInfo(int i11) {
        remove(i11);
    }

    public String toString() {
        return "IrisInfo [" + "]";
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        List<IrisBiometricSubtypeInfo> subRecords = getSubRecords();
        int i11 = 0;
        for (IrisBiometricSubtypeInfo recordLength2 : subRecords) {
            i11 = (int) (((long) i11) + recordLength2.getRecordLength());
        }
        int i12 = i11 + 45;
        DataOutputStream dataOutputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        dataOutputStream.writeInt(FORMAT_IDENTIFIER);
        dataOutputStream.writeInt(VERSION_NUMBER);
        dataOutputStream.writeInt(i12);
        dataOutputStream.writeShort(this.captureDeviceId);
        dataOutputStream.writeByte(subRecords.size());
        dataOutputStream.writeShort(45);
        dataOutputStream.writeShort((this.horizontalOrientation & 3) | 0 | ((this.verticalOrientation << 2) & 12) | ((this.scanType << 4) & 112) | ((this.irisOcclusion << 7) & 128) | ((this.occlusionFilling << 8) & 256) | ((this.boundaryExtraction << 9) & 512));
        dataOutputStream.writeShort(this.irisDiameter);
        dataOutputStream.writeShort(this.imageFormat);
        dataOutputStream.writeShort(this.rawImageWidth);
        dataOutputStream.writeShort(this.rawImageHeight);
        dataOutputStream.writeByte(this.intensityDepth);
        dataOutputStream.writeByte(this.imageTransformation);
        dataOutputStream.write(this.deviceUniqueId);
        for (IrisBiometricSubtypeInfo writeObject : subRecords) {
            writeObject.writeObject(outputStream);
        }
    }

    public IrisInfo(StandardBiometricHeader standardBiometricHeader, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, byte[] bArr, List<IrisBiometricSubtypeInfo> list) {
        byte[] bArr2 = bArr;
        this.sbh = standardBiometricHeader;
        if (list != null) {
            this.captureDeviceId = i11;
            this.horizontalOrientation = i12;
            this.verticalOrientation = i13;
            this.scanType = i14;
            this.irisOcclusion = i15;
            this.occlusionFilling = i16;
            this.boundaryExtraction = i17;
            this.irisDiameter = i18;
            this.imageFormat = i19;
            this.rawImageWidth = i21;
            this.rawImageHeight = i22;
            this.intensityDepth = i23;
            this.imageTransformation = i24;
            long j11 = 0;
            for (IrisBiometricSubtypeInfo next : list) {
                j11 += next.getRecordLength();
                add(next);
            }
            if (bArr2 == null || bArr2.length != 16) {
                throw new IllegalArgumentException("deviceUniqueId invalid");
            }
            byte[] bArr3 = new byte[16];
            this.deviceUniqueId = bArr3;
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            this.recordLength = j11 + 45;
            return;
        }
        throw new IllegalArgumentException("Null irisBiometricSubtypeInfos");
    }

    public IrisInfo(InputStream inputStream) throws IOException {
        this((StandardBiometricHeader) null, inputStream);
    }

    public IrisInfo(StandardBiometricHeader standardBiometricHeader, InputStream inputStream) throws IOException {
        this.sbh = standardBiometricHeader;
        readObject(inputStream);
    }
}
