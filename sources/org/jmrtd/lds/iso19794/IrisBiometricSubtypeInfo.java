package org.jmrtd.lds.iso19794;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.jmrtd.lds.AbstractListInfo;

public class IrisBiometricSubtypeInfo extends AbstractListInfo<IrisImageInfo> {
    public static final int EYE_LEFT = 2;
    public static final int EYE_RIGHT = 1;
    public static final int EYE_UNDEF = 0;
    private static final long serialVersionUID = -6588640634764878039L;
    private int biometricSubtype;
    private int imageFormat;

    public IrisBiometricSubtypeInfo(int i11, int i12, List<IrisImageInfo> list) {
        this.biometricSubtype = i11;
        this.imageFormat = i12;
        addAll(list);
    }

    private static String biometricSubtypeToString(int i11) {
        if (i11 == 0) {
            return "Undefined";
        }
        if (i11 == 1) {
            return "Right eye";
        }
        if (i11 == 2) {
            return "Left eye";
        }
        throw new NumberFormatException("Unknown biometric subtype: " + Integer.toHexString(i11));
    }

    public void addIrisImageInfo(IrisImageInfo irisImageInfo) {
        add(irisImageInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        IrisBiometricSubtypeInfo irisBiometricSubtypeInfo = (IrisBiometricSubtypeInfo) obj;
        if (this.biometricSubtype == irisBiometricSubtypeInfo.biometricSubtype && this.imageFormat == irisBiometricSubtypeInfo.imageFormat) {
            return true;
        }
        return false;
    }

    public int getBiometricSubtype() {
        return this.biometricSubtype;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public List<IrisImageInfo> getIrisImageInfos() {
        return getSubRecords();
    }

    public long getRecordLength() {
        long j11 = 3;
        for (IrisImageInfo recordLength : getSubRecords()) {
            j11 += recordLength.getRecordLength();
        }
        return j11;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.biometricSubtype) * 31) + this.imageFormat;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        this.biometricSubtype = dataInputStream.readUnsignedByte();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        for (int i11 = 0; i11 < readUnsignedShort; i11++) {
            IrisImageInfo irisImageInfo = new IrisImageInfo(inputStream, this.imageFormat);
            irisImageInfo.getRecordLength();
            add(irisImageInfo);
        }
    }

    public void removeIrisImageInfo(int i11) {
        remove(i11);
    }

    public String toString() {
        List subRecords = getSubRecords();
        return "IrisBiometricSubtypeInfo [biometric subtype: " + biometricSubtypeToString(this.biometricSubtype) + ", imageCount = " + subRecords.size() + "]";
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        dataOutputStream.writeByte(this.biometricSubtype & 255);
        List<IrisImageInfo> subRecords = getSubRecords();
        dataOutputStream.writeShort(subRecords.size() & 65535);
        for (IrisImageInfo writeObject : subRecords) {
            writeObject.writeObject(dataOutputStream);
        }
    }

    public IrisBiometricSubtypeInfo(InputStream inputStream, int i11) throws IOException {
        this.imageFormat = i11;
        readObject(inputStream);
    }
}
