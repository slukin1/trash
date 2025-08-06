package org.jmrtd.lds.iso19794;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jmrtd.lds.AbstractImageInfo;
import org.jmrtd.lds.ImageInfo;

public class IrisImageInfo extends AbstractImageInfo {
    public static final int IMAGE_QUAL_HIGH_HI = 100;
    public static final int IMAGE_QUAL_HIGH_LO = 76;
    public static final int IMAGE_QUAL_LOW_HI = 50;
    public static final int IMAGE_QUAL_LOW_LO = 26;
    public static final int IMAGE_QUAL_MED_HI = 75;
    public static final int IMAGE_QUAL_MED_LO = 51;
    public static final int IMAGE_QUAL_UNDEF = 254;
    private static final int ROT_ANGLE_UNDEF = 65535;
    private static final int ROT_UNCERTAIN_UNDEF = 65535;
    private static final long serialVersionUID = 833541246115625112L;
    private int imageFormat;
    private int imageNumber;
    private int quality;
    private int rotationAngle;
    private int rotationAngleUncertainty;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IrisImageInfo(int i11, int i12, int i13, int i14, int i15, int i16, InputStream inputStream, int i17, int i18) throws IOException {
        super(3, i15, i16, inputStream, (long) i17, getMimeTypeFromImageFormat(i18));
        if (inputStream != null) {
            this.imageNumber = i11;
            this.quality = i12;
            this.rotationAngle = i13;
            this.rotationAngleUncertainty = i14;
            return;
        }
        throw new IllegalArgumentException("Null image bytes");
    }

    private static String getMimeTypeFromImageFormat(int i11) {
        if (i11 == 2 || i11 == 4) {
            return ImageInfo.WSQ_MIME_TYPE;
        }
        if (i11 == 6 || i11 == 8 || i11 == 10 || i11 == 12) {
            return "image/jpeg";
        }
        if (i11 == 14 || i11 == 16) {
            return ImageInfo.JPEG2000_MIME_TYPE;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        IrisImageInfo irisImageInfo = (IrisImageInfo) obj;
        if (this.imageFormat == irisImageInfo.imageFormat && this.imageNumber == irisImageInfo.imageNumber && this.quality == irisImageInfo.quality && this.rotationAngle == irisImageInfo.rotationAngle && this.rotationAngleUncertainty == irisImageInfo.rotationAngleUncertainty) {
            return true;
        }
        return false;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public int getImageNumber() {
        return this.imageNumber;
    }

    public int getQuality() {
        return this.quality;
    }

    public long getRecordLength() {
        return ((long) getImageLength()) + 11;
    }

    public int getRotationAngle() {
        return this.rotationAngle;
    }

    public int getRotationAngleUncertainty() {
        return this.rotationAngleUncertainty;
    }

    public int hashCode() {
        return (((((((((super.hashCode() * 31) + this.imageFormat) * 31) + this.imageNumber) * 31) + this.quality) * 31) + this.rotationAngle) * 31) + this.rotationAngleUncertainty;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        this.imageNumber = dataInputStream.readUnsignedShort();
        this.quality = dataInputStream.readUnsignedByte();
        this.rotationAngle = dataInputStream.readShort();
        this.rotationAngleUncertainty = dataInputStream.readUnsignedShort();
        readImage(inputStream, ((long) dataInputStream.readInt()) & 4294967295L);
    }

    public String toString() {
        return "IrisImageInfo [" + "image number: " + this.imageNumber + ", " + "quality: " + this.quality + ", " + "image: " + getWidth() + " x " + getHeight() + "mime-type: " + getMimeTypeFromImageFormat(this.imageFormat) + "]";
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        dataOutputStream.writeShort(this.imageNumber);
        dataOutputStream.writeByte(this.quality);
        dataOutputStream.writeShort(this.rotationAngle);
        dataOutputStream.writeShort(this.rotationAngleUncertainty);
        dataOutputStream.writeInt(getImageLength());
        writeImage(dataOutputStream);
    }

    public IrisImageInfo(int i11, int i12, int i13, InputStream inputStream, int i14, int i15) throws IOException {
        this(i11, 254, 65535, 65535, i12, i13, inputStream, i14, i15);
    }

    public IrisImageInfo(InputStream inputStream, int i11) throws IOException {
        super(3);
        this.imageFormat = i11;
        setMimeType(getMimeTypeFromImageFormat(i11));
        readObject(inputStream);
    }
}
