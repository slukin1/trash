package net.sf.scuba.tlv;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TLVInputStream extends InputStream {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba.tlv");
    private static final int MAX_BUFFER_LENGTH = 65535;
    private int bufferSize = 0;
    private DataInputStream inputStream;
    private TLVInputState markedState;
    private final InputStream originalInputStream;
    private TLVInputState state;

    public TLVInputStream(InputStream inputStream2) {
        try {
            if ((inputStream2 instanceof BufferedInputStream) || (inputStream2 instanceof ByteArrayInputStream)) {
                this.bufferSize = inputStream2.available();
            }
        } catch (IOException e11) {
            LOGGER.log(Level.WARNING, "Exception reading from stream", e11);
        }
        this.originalInputStream = inputStream2;
        this.inputStream = inputStream2 instanceof DataInputStream ? (DataInputStream) inputStream2 : new DataInputStream(inputStream2);
        this.state = new TLVInputState();
        this.markedState = null;
    }

    private long skipValue() throws IOException {
        if (!this.state.isAtStartOfTag() && !this.state.isAtStartOfLength()) {
            return skip((long) this.state.getValueBytesLeft());
        }
        return 0;
    }

    public int available() throws IOException {
        return this.inputStream.available();
    }

    public void close() throws IOException {
        this.inputStream.close();
    }

    public synchronized void mark(int i11) {
        this.inputStream.mark(i11);
        this.markedState = new TLVInputState(this.state);
    }

    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    public int read() throws IOException {
        int read = this.inputStream.read();
        if (read < 0) {
            return -1;
        }
        this.state.updateValueBytesProcessed(1);
        return read;
    }

    public int readLength() throws IOException {
        try {
            if (this.state.isAtStartOfLength()) {
                int readUnsignedByte = this.inputStream.readUnsignedByte();
                int i11 = 1;
                if ((readUnsignedByte & 128) != 0) {
                    int i12 = readUnsignedByte & 127;
                    int i13 = 0;
                    int i14 = 1;
                    for (int i15 = 0; i15 < i12; i15++) {
                        i14++;
                        i13 = (i13 << 8) | this.inputStream.readUnsignedByte();
                    }
                    readUnsignedByte = i13;
                    i11 = i14;
                }
                this.state.setLengthProcessed(readUnsignedByte, i11);
                return readUnsignedByte;
            }
            throw new IllegalStateException("Not at start of length");
        } catch (IOException e11) {
            throw e11;
        }
    }

    public int readTag() throws IOException {
        if (this.state.isAtStartOfTag() || this.state.isProcessingValue()) {
            try {
                int readUnsignedByte = this.inputStream.readUnsignedByte();
                int i11 = 1;
                while (true) {
                    if (readUnsignedByte != 0) {
                        if (readUnsignedByte != 255) {
                            break;
                        }
                    }
                    readUnsignedByte = this.inputStream.readUnsignedByte();
                    i11++;
                }
                if ((readUnsignedByte & 31) == 31) {
                    int readUnsignedByte2 = this.inputStream.readUnsignedByte();
                    while (true) {
                        i11++;
                        if ((readUnsignedByte2 & 128) != 128) {
                            break;
                        }
                        readUnsignedByte = (readUnsignedByte << 8) | (readUnsignedByte2 & 127);
                        readUnsignedByte2 = this.inputStream.readUnsignedByte();
                    }
                    readUnsignedByte = (readUnsignedByte << 8) | (readUnsignedByte2 & 127);
                }
                this.state.setTagProcessed(readUnsignedByte, i11);
                return readUnsignedByte;
            } catch (IOException e11) {
                throw e11;
            }
        } else {
            throw new IllegalStateException("Not at start of tag");
        }
    }

    public byte[] readValue() throws IOException {
        try {
            if (this.state.isProcessingValue()) {
                int length = this.state.getLength();
                byte[] bArr = new byte[length];
                this.inputStream.readFully(bArr);
                this.state.updateValueBytesProcessed(length);
                return bArr;
            }
            throw new IllegalStateException("Not yet processing value!");
        } catch (IOException e11) {
            throw e11;
        }
    }

    public synchronized void reset() throws IOException {
        if (markSupported()) {
            this.inputStream.reset();
            this.state = this.markedState;
            this.markedState = null;
        } else {
            throw new IOException("mark/reset not supported");
        }
    }

    public long skip(long j11) throws IOException {
        if (j11 <= 0) {
            return 0;
        }
        long skip = this.inputStream.skip(j11);
        this.state.updateValueBytesProcessed((int) skip);
        return skip;
    }

    public void skipToTag(int i11) throws IOException {
        while (true) {
            if (!this.state.isAtStartOfTag()) {
                if (this.state.isAtStartOfLength()) {
                    readLength();
                    if (TLVUtil.isPrimitive(this.state.getTag())) {
                        skipValue();
                    }
                } else if (TLVUtil.isPrimitive(this.state.getTag())) {
                    skipValue();
                }
            }
            int readTag = readTag();
            if (readTag != i11) {
                if (TLVUtil.isPrimitive(readTag) && ((int) skipValue()) < readLength()) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        return this.state.toString();
    }
}
