package org.jmrtd.lds.iso19794;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.data.Gender;
import org.jmrtd.cbeff.BiometricDataBlock;
import org.jmrtd.cbeff.StandardBiometricHeader;
import org.jmrtd.lds.AbstractListInfo;
import org.jmrtd.lds.iso19794.FaceImageInfo;

public class FaceInfo extends AbstractListInfo<FaceImageInfo> implements BiometricDataBlock {
    private static final int FORMAT_IDENTIFIER = 1178682112;
    private static final int FORMAT_OWNER_VALUE = 257;
    private static final int FORMAT_TYPE_VALUE = 8;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final int VERSION_NUMBER = 808529920;
    private static final long serialVersionUID = -6053206262773400725L;
    private StandardBiometricHeader sbh;

    public FaceInfo(List<FaceImageInfo> list) {
        this((StandardBiometricHeader) null, list);
    }

    public void addFaceImageInfo(FaceImageInfo faceImageInfo) {
        add(faceImageInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        FaceInfo faceInfo = (FaceInfo) obj;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        if (standardBiometricHeader != null) {
            StandardBiometricHeader standardBiometricHeader2 = faceInfo.sbh;
            if (standardBiometricHeader == standardBiometricHeader2 || standardBiometricHeader.equals(standardBiometricHeader2)) {
                return true;
            }
            return false;
        } else if (faceInfo.sbh == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<FaceImageInfo> getFaceImageInfos() {
        return getSubRecords();
    }

    public StandardBiometricHeader getStandardBiometricHeader() {
        if (this.sbh == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(129, new byte[]{2});
            treeMap.put(130, new byte[]{0});
            treeMap.put(135, new byte[]{1, 1});
            treeMap.put(136, new byte[]{0, 8});
            this.sbh = new StandardBiometricHeader(treeMap);
        }
        return this.sbh;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        return hashCode + (standardBiometricHeader == null ? 0 : standardBiometricHeader.hashCode());
    }

    public void readObject(InputStream inputStream) throws IOException {
        InputStream inputStream2 = inputStream;
        DataInputStream dataInputStream = inputStream2 instanceof DataInputStream ? (DataInputStream) inputStream2 : new DataInputStream(inputStream2);
        int readInt = dataInputStream.readInt();
        if (readInt != FORMAT_IDENTIFIER) {
            LOGGER.log(Level.WARNING, "'FAC' marker expected! Found " + Integer.toHexString(readInt));
            if (readInt == 12) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(readInt);
                short readShort = dataInputStream.readShort();
                dataOutputStream.writeShort(readShort);
                int i11 = 0;
                while (i11 < readShort) {
                    byte[] bArr = new byte[2048];
                    int read = dataInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr);
                    i11 += read;
                }
                int[] iArr = new int[3];
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                int[] iArr2 = new int[3];
                // fill-array-data instruction
                iArr2[0] = 0;
                iArr2[1] = 0;
                iArr2[2] = 0;
                ByteArrayInputStream byteArrayInputStream = r4;
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                add(new FaceImageInfo(Gender.UNKNOWN, FaceImageInfo.EyeColor.UNSPECIFIED, 0, 0, 0, iArr, iArr2, 1, 0, 0, 0, 0, new FaceImageInfo.FeaturePoint[0], 0, 0, byteArrayInputStream, readShort, 1));
                return;
            }
        }
        int readInt2 = dataInputStream.readInt();
        if (readInt2 == VERSION_NUMBER) {
            long readInt3 = (((long) dataInputStream.readInt()) & 4294967295L) - 14;
            long j11 = 0;
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            for (int i12 = 0; i12 < readUnsignedShort; i12++) {
                FaceImageInfo faceImageInfo = new FaceImageInfo(inputStream2);
                j11 += faceImageInfo.getRecordLength();
                add(faceImageInfo);
            }
            if (readInt3 != j11) {
                LOGGER.warning("ConstructedDataLength and dataLength differ: dataLength = " + readInt3 + ", constructedDataLength = " + j11);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("'010' version number expected! Found " + Integer.toHexString(readInt2));
    }

    public void removeFaceImageInfo(int i11) {
        remove(i11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FaceInfo [");
        for (FaceImageInfo faceImageInfo : getSubRecords()) {
            sb2.append(faceImageInfo.toString());
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        List<FaceImageInfo> subRecords = getSubRecords();
        long j11 = 0;
        for (FaceImageInfo recordLength : subRecords) {
            j11 += recordLength.getRecordLength();
        }
        long j12 = ((long) 14) + j11;
        DataOutputStream dataOutputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        dataOutputStream.writeInt(FORMAT_IDENTIFIER);
        dataOutputStream.writeInt(VERSION_NUMBER);
        dataOutputStream.writeInt((int) (4294967295L & j12));
        dataOutputStream.writeShort(subRecords.size());
        for (FaceImageInfo writeObject : subRecords) {
            writeObject.writeObject(dataOutputStream);
        }
    }

    public FaceInfo(StandardBiometricHeader standardBiometricHeader, List<FaceImageInfo> list) {
        this.sbh = standardBiometricHeader;
        addAll(list);
    }

    public FaceInfo(InputStream inputStream) throws IOException {
        this((StandardBiometricHeader) null, inputStream);
    }

    public FaceInfo(StandardBiometricHeader standardBiometricHeader, InputStream inputStream) throws IOException {
        this.sbh = standardBiometricHeader;
        readObject(inputStream);
    }
}
