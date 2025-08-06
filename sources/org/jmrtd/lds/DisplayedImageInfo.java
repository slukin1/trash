package org.jmrtd.lds;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import net.sf.scuba.tlv.TLVUtil;

public class DisplayedImageInfo extends AbstractImageInfo {
    public static final int DISPLAYED_PORTRAIT_TAG = 24384;
    public static final int DISPLAYED_SIGNATURE_OR_MARK_TAG = 24387;
    private static final long serialVersionUID = 3801320585294302721L;
    private int displayedImageTag;

    public DisplayedImageInfo(int i11, byte[] bArr) {
        super(i11, getMimeTypeFromType(i11));
        this.displayedImageTag = getDisplayedImageTagFromType(i11);
        setImageBytes(bArr);
    }

    private static int getDisplayedImageTagFromType(int i11) {
        if (i11 == 0) {
            return DISPLAYED_PORTRAIT_TAG;
        }
        if (i11 == 1) {
            return DISPLAYED_SIGNATURE_OR_MARK_TAG;
        }
        throw new NumberFormatException("Unknown type: " + Integer.toHexString(i11));
    }

    private static String getMimeTypeFromType(int i11) {
        if (i11 == 0 || i11 == 1) {
            return "image/jpeg";
        }
        if (i11 == 2) {
            return ImageInfo.WSQ_MIME_TYPE;
        }
        throw new NumberFormatException("Unknown type: " + Integer.toHexString(i11));
    }

    private static int getTypeFromDisplayedImageTag(int i11) {
        if (i11 == 24384) {
            return 0;
        }
        if (i11 == 24387) {
            return 1;
        }
        throw new NumberFormatException("Unknown tag: " + Integer.toHexString(i11));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        if (this.displayedImageTag == ((DisplayedImageInfo) obj).displayedImageTag) {
            return true;
        }
        return false;
    }

    public int getDisplayedImageTag() {
        return this.displayedImageTag;
    }

    public long getRecordLength() {
        int imageLength = getImageLength();
        return ((long) TLVUtil.getTagLength(getDisplayedImageTagFromType(getType()))) + 0 + ((long) TLVUtil.getLengthLength(imageLength)) + ((long) imageLength);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.displayedImageTag;
    }

    public void readObject(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        this.displayedImageTag = readTag;
        if (readTag == 24384 || readTag == 24387) {
            int typeFromDisplayedImageTag = getTypeFromDisplayedImageTag(readTag);
            setType(typeFromDisplayedImageTag);
            setMimeType(getMimeTypeFromType(typeFromDisplayedImageTag));
            readImage(tLVInputStream, (long) tLVInputStream.readLength());
            return;
        }
        throw new IllegalArgumentException("Expected tag 0x5F40 or 0x5F43, found " + Integer.toHexString(this.displayedImageTag));
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(getDisplayedImageTagFromType(getType()));
        writeImage(tLVOutputStream);
        tLVOutputStream.writeValueEnd();
    }

    public DisplayedImageInfo(InputStream inputStream) throws IOException {
        readObject(inputStream);
    }
}
