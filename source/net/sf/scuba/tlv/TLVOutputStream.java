package net.sf.scuba.tlv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TLVOutputStream extends OutputStream {
    private DataOutputStream outputStream;
    private TLVOutputState state;

    public TLVOutputStream(OutputStream outputStream2) {
        this.outputStream = outputStream2 instanceof DataOutputStream ? (DataOutputStream) outputStream2 : new DataOutputStream(outputStream2);
        this.state = new TLVOutputState();
    }

    public void close() throws IOException {
        if (this.state.canBeWritten()) {
            this.outputStream.close();
            return;
        }
        throw new IllegalStateException("Cannot close stream yet, illegal TLV state.");
    }

    public void flush() throws IOException {
        this.outputStream.flush();
    }

    public void write(int i11) throws IOException {
        write(new byte[]{(byte) i11}, 0, 1);
    }

    public void writeLength(int i11) throws IOException {
        byte[] lengthAsBytes = TLVUtil.getLengthAsBytes(i11);
        this.state.setLengthProcessed(i11);
        if (this.state.canBeWritten()) {
            this.outputStream.write(lengthAsBytes);
        }
    }

    public void writeTag(int i11) throws IOException {
        byte[] tagAsBytes = TLVUtil.getTagAsBytes(i11);
        if (this.state.canBeWritten()) {
            this.outputStream.write(tagAsBytes);
        }
        this.state.setTagProcessed(i11);
    }

    public void writeValue(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new IllegalArgumentException("Cannot write null.");
        } else if (this.state.isAtStartOfTag()) {
            throw new IllegalStateException("Cannot write value bytes yet. Need to write a tag first.");
        } else if (this.state.isAtStartOfLength()) {
            writeLength(bArr.length);
            write(bArr);
        } else {
            write(bArr);
            this.state.updatePreviousLength(bArr.length);
        }
    }

    public void writeValueEnd() throws IOException {
        if (this.state.isAtStartOfLength()) {
            throw new IllegalStateException("Not processing value yet.");
        } else if (!this.state.isAtStartOfTag() || this.state.isDummyLengthSet()) {
            byte[] value = this.state.getValue();
            int length = value.length;
            this.state.updatePreviousLength(length);
            if (this.state.canBeWritten()) {
                this.outputStream.write(TLVUtil.getLengthAsBytes(length));
                this.outputStream.write(value);
            }
        }
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (!this.state.isAtStartOfTag()) {
            if (this.state.isAtStartOfLength()) {
                this.state.setDummyLengthProcessed();
            }
            this.state.updateValueBytesProcessed(bArr, i11, i12);
            if (this.state.canBeWritten()) {
                this.outputStream.write(bArr, i11, i12);
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot write value bytes yet. Need to write a tag first.");
    }
}
