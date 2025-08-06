package org.jmrtd.lds;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;

public abstract class AbstractTaggedLDSFile extends AbstractLDSFile {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -4761360877353069639L;
    private int length;
    private int tag;

    public AbstractTaggedLDSFile(int i11) {
        this.tag = i11;
    }

    private byte[] getContent() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeContent(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                LOGGER.log(Level.FINE, "Error closing stream", e11);
            }
            return byteArray;
        } catch (IOException e12) {
            throw new IllegalStateException("Could not get DG content", e12);
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e13) {
                LOGGER.log(Level.FINE, "Error closing stream", e13);
            }
            throw th2;
        }
    }

    public /* bridge */ /* synthetic */ byte[] getEncoded() {
        return super.getEncoded();
    }

    public int getLength() {
        if (this.length <= 0) {
            this.length = getContent().length;
        }
        return this.length;
    }

    public int getTag() {
        return this.tag;
    }

    public abstract void readContent(InputStream inputStream) throws IOException;

    public void readObject(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        if (readTag == this.tag) {
            this.length = tLVInputStream.readLength();
            readContent(tLVInputStream);
            return;
        }
        throw new IllegalArgumentException("Was expecting tag " + Integer.toHexString(this.tag) + ", found " + Integer.toHexString(readTag));
    }

    public String toString() {
        return "TaggedLDSFile [" + Integer.toHexString(getTag()) + " (" + getLength() + ")]";
    }

    public abstract void writeContent(OutputStream outputStream) throws IOException;

    public void writeObject(OutputStream outputStream) throws IOException {
        int i11;
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        int tag2 = getTag();
        if (this.tag != tag2) {
            this.tag = tag2;
        }
        tLVOutputStream.writeTag(tag2);
        byte[] content = getContent();
        if (content == null) {
            i11 = 0;
        } else {
            i11 = content.length;
        }
        if (this.length != i11) {
            this.length = i11;
        }
        tLVOutputStream.writeValue(content);
    }

    public AbstractTaggedLDSFile(int i11, InputStream inputStream) throws IOException {
        this.tag = i11;
        readObject(inputStream);
    }
}
