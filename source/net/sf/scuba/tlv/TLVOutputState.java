package net.sf.scuba.tlv;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.util.Hex;

class TLVOutputState {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger("net.sf.scuba.tlv");
    private boolean isAtStartOfLength;
    private boolean isAtStartOfTag;
    private boolean isReadingValue;
    private Deque<TLVStruct> state;

    public class TLVStruct {
        /* access modifiers changed from: private */
        public boolean isLengthSet;
        private int length;
        private int tag;
        private ByteArrayOutputStream value;

        public TLVStruct(TLVOutputState tLVOutputState, TLVStruct tLVStruct) {
            this(tLVStruct.tag, tLVStruct.length, tLVStruct.isLengthSet, tLVStruct.getValue());
        }

        public int getLength() {
            return this.length;
        }

        public int getTag() {
            return this.tag;
        }

        public byte[] getValue() {
            return this.value.toByteArray();
        }

        public int getValueBytesProcessed() {
            return this.value.size();
        }

        public boolean isLengthSet() {
            return this.isLengthSet;
        }

        public void setLength(int i11) {
            this.length = i11;
            this.isLengthSet = true;
        }

        public String toString() {
            byte[] byteArray = this.value.toByteArray();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[TLVStruct ");
            sb2.append(Integer.toHexString(this.tag));
            sb2.append(", ");
            sb2.append(this.isLengthSet ? Integer.valueOf(this.length) : "UNDEFINED");
            sb2.append(", ");
            sb2.append(Hex.bytesToHexString(byteArray));
            sb2.append("(");
            sb2.append(byteArray.length);
            sb2.append(") ]");
            return sb2.toString();
        }

        public void write(byte[] bArr, int i11, int i12) {
            this.value.write(bArr, i11, i12);
        }

        public TLVStruct(TLVOutputState tLVOutputState, int i11) {
            this(i11, Integer.MAX_VALUE, false, (byte[]) null);
        }

        public TLVStruct(int i11, int i12, boolean z11, byte[] bArr) {
            this.tag = i11;
            this.length = i12;
            this.isLengthSet = z11;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.value = byteArrayOutputStream;
            if (bArr != null) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e11) {
                    TLVOutputState.LOGGER.log(Level.FINE, "Exception writing bytes in memory", e11);
                }
            }
        }
    }

    public TLVOutputState() {
        this(new ArrayDeque(), true, false, false);
    }

    private Deque<TLVStruct> getDeepCopyOfState() {
        ArrayDeque arrayDeque = new ArrayDeque(this.state.size());
        for (TLVStruct tLVStruct : this.state) {
            arrayDeque.add(new TLVStruct(this, tLVStruct));
        }
        return arrayDeque;
    }

    public boolean canBeWritten() {
        for (TLVStruct isLengthSet : this.state) {
            if (!isLengthSet.isLengthSet()) {
                return false;
            }
        }
        return true;
    }

    public int getLength() {
        if (!this.state.isEmpty()) {
            int length = this.state.peek().getLength();
            if (length >= 0) {
                return length;
            }
            throw new IllegalStateException("Length not yet knwon.");
        }
        throw new IllegalStateException("Length not yet known.");
    }

    public int getTag() {
        if (!this.state.isEmpty()) {
            return this.state.peek().getTag();
        }
        throw new IllegalStateException("Tag not yet read.");
    }

    public byte[] getValue() {
        if (!this.state.isEmpty()) {
            return this.state.peek().getValue();
        }
        throw new IllegalStateException("Cannot get value yet.");
    }

    public int getValueBytesLeft() {
        if (!this.state.isEmpty()) {
            TLVStruct peek = this.state.peek();
            return peek.getLength() - peek.getValueBytesProcessed();
        }
        throw new IllegalStateException("Length of value is unknown.");
    }

    public int getValueBytesProcessed() {
        return this.state.peek().getValueBytesProcessed();
    }

    public boolean isAtStartOfLength() {
        return this.isAtStartOfLength;
    }

    public boolean isAtStartOfTag() {
        return this.isAtStartOfTag;
    }

    public boolean isDummyLengthSet() {
        if (this.state.isEmpty()) {
            return false;
        }
        return !this.state.peek().isLengthSet();
    }

    public boolean isProcessingValue() {
        return this.isReadingValue;
    }

    public void setDummyLengthProcessed() {
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public void setLengthProcessed(int i11) {
        if (i11 >= 0) {
            TLVStruct pop = this.state.pop();
            if (!this.state.isEmpty()) {
                byte[] lengthAsBytes = TLVUtil.getLengthAsBytes(i11);
                this.state.peek().write(lengthAsBytes, 0, lengthAsBytes.length);
            }
            pop.setLength(i11);
            this.state.push(pop);
            this.isAtStartOfTag = false;
            this.isAtStartOfLength = false;
            this.isReadingValue = true;
            return;
        }
        throw new IllegalArgumentException("Cannot set negative length (length = " + i11 + ").");
    }

    public void setTagProcessed(int i11) {
        TLVStruct tLVStruct = new TLVStruct(this, i11);
        if (!this.state.isEmpty()) {
            byte[] tagAsBytes = TLVUtil.getTagAsBytes(i11);
            this.state.peek().write(tagAsBytes, 0, tagAsBytes.length);
        }
        this.state.push(tLVStruct);
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = true;
        this.isReadingValue = false;
    }

    public String toString() {
        return this.state.toString();
    }

    public void updatePreviousLength(int i11) {
        if (!this.state.isEmpty()) {
            TLVStruct peek = this.state.peek();
            if (!peek.isLengthSet || peek.getLength() != i11) {
                peek.setLength(i11);
                if (peek.getValueBytesProcessed() == peek.getLength()) {
                    this.state.pop();
                    byte[] lengthAsBytes = TLVUtil.getLengthAsBytes(i11);
                    byte[] value = peek.getValue();
                    updateValueBytesProcessed(lengthAsBytes, 0, lengthAsBytes.length);
                    updateValueBytesProcessed(value, 0, value.length);
                    this.isAtStartOfTag = true;
                    this.isAtStartOfLength = false;
                    this.isReadingValue = false;
                }
            }
        }
    }

    public void updateValueBytesProcessed(byte[] bArr, int i11, int i12) {
        if (!this.state.isEmpty()) {
            TLVStruct peek = this.state.peek();
            int length = peek.getLength() - peek.getValueBytesProcessed();
            if (i12 <= length) {
                peek.write(bArr, i11, i12);
                if (peek.getValueBytesProcessed() == peek.getLength()) {
                    this.state.pop();
                    updateValueBytesProcessed(peek.getValue(), 0, peek.getLength());
                    this.isAtStartOfTag = true;
                    this.isAtStartOfLength = false;
                    this.isReadingValue = false;
                    return;
                }
                this.isAtStartOfTag = false;
                this.isAtStartOfLength = false;
                this.isReadingValue = true;
                return;
            }
            throw new IllegalArgumentException("Cannot process " + i12 + " bytes! Only " + length + " bytes left in this TLV object " + peek);
        }
    }

    public TLVOutputState(TLVOutputState tLVOutputState) {
        this(tLVOutputState.getDeepCopyOfState(), tLVOutputState.isAtStartOfTag, tLVOutputState.isAtStartOfLength, tLVOutputState.isReadingValue);
    }

    private TLVOutputState(Deque<TLVStruct> deque, boolean z11, boolean z12, boolean z13) {
        this.state = deque;
        this.isAtStartOfTag = z11;
        this.isAtStartOfLength = z12;
        this.isReadingValue = z13;
    }
}
