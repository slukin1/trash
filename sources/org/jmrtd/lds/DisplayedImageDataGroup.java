package org.jmrtd.lds;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;

public abstract class DisplayedImageDataGroup extends DataGroup {
    private static final int DISPLAYED_IMAGE_COUNT_TAG = 2;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 5994136177872308962L;
    private int displayedImageTagToUse;
    private List<DisplayedImageInfo> imageInfos;

    public DisplayedImageDataGroup(int i11, List<DisplayedImageInfo> list, int i12) {
        super(i11);
        if (list != null) {
            this.displayedImageTagToUse = i12;
            this.imageInfos = new ArrayList(list);
            checkTypesConsistentWithTag();
            return;
        }
        throw new IllegalArgumentException("imageInfos cannot be null");
    }

    private void add(DisplayedImageInfo displayedImageInfo) {
        if (this.imageInfos == null) {
            this.imageInfos = new ArrayList();
        }
        this.imageInfos.add(displayedImageInfo);
    }

    private void checkTypesConsistentWithTag() {
        for (DisplayedImageInfo next : this.imageInfos) {
            if (next != null) {
                int type = next.getType();
                if (type != 0) {
                    if (type != 1) {
                        LOGGER.warning("Unsupported image type");
                    } else if (this.displayedImageTagToUse != 24387) {
                        throw new IllegalArgumentException("'Portrait' image cannot be part of a 'Signature or usual mark' displayed image datagroup");
                    }
                } else if (this.displayedImageTagToUse != 24384) {
                    throw new IllegalArgumentException("'Signature or usual mark' image cannot be part of a 'Portrait' displayed image datagroup");
                }
            } else {
                throw new IllegalArgumentException("Found a null image info");
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        List<DisplayedImageInfo> list = this.imageInfos;
        List<DisplayedImageInfo> list2 = ((DisplayedImageDataGroup) obj).imageInfos;
        if (list == list2 || (list != null && list.equals(list2))) {
            return true;
        }
        return false;
    }

    public List<DisplayedImageInfo> getImages() {
        return new ArrayList(this.imageInfos);
    }

    public int hashCode() {
        List<DisplayedImageInfo> list = this.imageInfos;
        return (list == null ? 1 : list.hashCode()) + 1337 + 31337;
    }

    public void readContent(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        if (readTag != 2) {
            throw new IllegalArgumentException("Expected tag 0x02 in displayed image structure, found " + Integer.toHexString(readTag));
        } else if (tLVInputStream.readLength() == 1) {
            byte b11 = tLVInputStream.readValue()[0] & 255;
            for (int i11 = 0; i11 < b11; i11++) {
                DisplayedImageInfo displayedImageInfo = new DisplayedImageInfo(tLVInputStream);
                if (i11 == 0) {
                    this.displayedImageTagToUse = displayedImageInfo.getDisplayedImageTag();
                } else if (displayedImageInfo.getDisplayedImageTag() != this.displayedImageTagToUse) {
                    throw new IOException("Found images with different displayed image tags inside displayed image datagroup");
                }
                add(displayedImageInfo);
            }
        } else {
            throw new IllegalArgumentException("DISPLAYED_IMAGE_COUNT should have length 1");
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" [");
        List<DisplayedImageInfo> list = this.imageInfos;
        if (list != null) {
            boolean z11 = true;
            for (DisplayedImageInfo next : list) {
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append(", ");
                }
                sb2.append(next.toString());
            }
            sb2.append("]");
            return sb2.toString();
        }
        throw new IllegalStateException("imageInfos cannot be null");
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(2);
        tLVOutputStream.writeValue(new byte[]{(byte) this.imageInfos.size()});
        for (DisplayedImageInfo writeObject : this.imageInfos) {
            writeObject.writeObject(tLVOutputStream);
        }
    }

    public DisplayedImageDataGroup(int i11, InputStream inputStream) throws IOException {
        super(i11, inputStream);
        if (this.imageInfos == null) {
            this.imageInfos = new ArrayList();
        }
        checkTypesConsistentWithTag();
    }
}
