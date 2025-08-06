package org.jmrtd.lds;

import com.facebook.internal.AnalyticsEvents;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jmrtd.io.SplittableInputStream;

public abstract class AbstractImageInfo implements ImageInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 2870092217269116309L;
    private int height;
    private byte[] imageBytes;
    private int imageLength;
    private int imagePositionInInputStream;
    private String mimeType;
    private transient SplittableInputStream splittableInputStream;
    private int type;
    private int width;

    public AbstractImageInfo() {
        this(-1, 0, 0, (String) null);
    }

    private byte[] getImageBytes() throws IOException {
        byte[] bArr = new byte[getImageLength()];
        new DataInputStream(getImageInputStream()).readFully(bArr);
        return bArr;
    }

    private static String typeToString(int i11) {
        if (i11 == -1) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (i11 == 0) {
            return "Portrait";
        }
        if (i11 == 1) {
            return "Signature or usual mark";
        }
        if (i11 == 2) {
            return "Finger";
        }
        if (i11 == 3) {
            return "Iris";
        }
        throw new NumberFormatException("Unknown type: " + Integer.toHexString(i11));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            if (!obj.getClass().equals(getClass())) {
                return false;
            }
            AbstractImageInfo abstractImageInfo = (AbstractImageInfo) obj;
            if (!Arrays.equals(getImageBytes(), abstractImageInfo.getImageBytes())) {
                return false;
            }
            String str = this.mimeType;
            if (((str != null || abstractImageInfo.mimeType != null) && (str == null || !str.equals(abstractImageInfo.mimeType))) || this.type != abstractImageInfo.type) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            logger.log(level, "Exception" + e11);
            return false;
        }
    }

    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeObject(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            return null;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public InputStream getImageInputStream() {
        SplittableInputStream splittableInputStream2 = this.splittableInputStream;
        if (splittableInputStream2 != null) {
            return splittableInputStream2.getInputStream(this.imagePositionInInputStream);
        }
        if (this.imageBytes != null) {
            return new ByteArrayInputStream(this.imageBytes);
        }
        throw new IllegalStateException("Both the byte buffer and the stream are null");
    }

    public int getImageLength() {
        if (this.splittableInputStream != null) {
            return this.imageLength;
        }
        byte[] bArr = this.imageBytes;
        if (bArr != null) {
            return bArr.length;
        }
        throw new IllegalStateException("Cannot get length of null");
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i11 = -591263623 + (this.type * 5);
        String str = this.mimeType;
        return i11 + ((str == null ? 1337 : str.hashCode()) * 5) + 7 + (getImageLength() * 7) + 11;
    }

    public void readImage(InputStream inputStream, long j11) throws IOException {
        this.splittableInputStream = null;
        this.imageBytes = new byte[((int) j11)];
        new DataInputStream(inputStream).readFully(this.imageBytes);
    }

    public abstract void readObject(InputStream inputStream) throws IOException;

    public final void setHeight(int i11) {
        this.height = i11;
    }

    public final void setImageBytes(byte[] bArr) {
        if (bArr != null) {
            try {
                readImage(new ByteArrayInputStream(bArr), (long) bArr.length);
            } catch (IOException e11) {
                LOGGER.log(Level.WARNING, "Exception", e11);
            }
        } else {
            throw new IllegalArgumentException("Cannot set null image bytes");
        }
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setWidth(int i11) {
        this.width = i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" [");
        sb2.append("type: ");
        sb2.append(typeToString(this.type) + ", ");
        sb2.append("size: ");
        sb2.append(getImageLength());
        sb2.append("]");
        return sb2.toString();
    }

    public void writeImage(OutputStream outputStream) throws IOException {
        outputStream.write(getImageBytes());
    }

    public abstract void writeObject(OutputStream outputStream) throws IOException;

    public AbstractImageInfo(int i11) {
        this(i11, 0, 0, (String) null);
    }

    public AbstractImageInfo(int i11, String str) {
        this(i11, 0, 0, str);
    }

    private AbstractImageInfo(int i11, int i12, int i13, String str) {
        this.type = i11;
        this.mimeType = str;
        this.width = i12;
        this.height = i13;
    }

    public AbstractImageInfo(int i11, int i12, int i13, InputStream inputStream, long j11, String str) throws IOException {
        this(i11, i12, i13, str);
        readImage(inputStream, j11);
    }
}
