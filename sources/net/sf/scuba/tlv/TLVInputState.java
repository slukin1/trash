package net.sf.scuba.tlv;

import java.util.ArrayDeque;
import java.util.Deque;

class TLVInputState {
    private boolean isAtStartOfLength;
    private boolean isAtStartOfTag;
    private boolean isReadingValue;
    private Deque<TLStruct> state;

    public class TLStruct {
        private int length;
        private int tag;
        private int valueBytesRead;

        public TLStruct(TLVInputState tLVInputState, int i11) {
            this(i11, Integer.MAX_VALUE, 0);
        }

        public int getLength() {
            return this.length;
        }

        public int getTag() {
            return this.tag;
        }

        public int getValueBytesProcessed() {
            return this.valueBytesRead;
        }

        public void setLength(int i11) {
            this.length = i11;
        }

        public String toString() {
            return "[TLStruct " + Integer.toHexString(this.tag) + ", " + this.length + ", " + this.valueBytesRead + "]";
        }

        public void updateValueBytesProcessed(int i11) {
            this.valueBytesRead += i11;
        }

        public TLStruct(TLVInputState tLVInputState, TLStruct tLStruct) {
            this(tLStruct.tag, tLStruct.length, tLStruct.valueBytesRead);
        }

        public TLStruct(int i11, int i12, int i13) {
            this.tag = i11;
            this.length = i12;
            this.valueBytesRead = i13;
        }
    }

    public TLVInputState() {
        this(new ArrayDeque(), true, false, false);
    }

    private Deque<TLStruct> getDeepCopyOfState() {
        ArrayDeque arrayDeque = new ArrayDeque(this.state.size());
        for (TLStruct tLStruct : this.state) {
            arrayDeque.addLast(new TLStruct(this, tLStruct));
        }
        return arrayDeque;
    }

    public int getLength() {
        if (!this.state.isEmpty()) {
            return this.state.peek().getLength();
        }
        throw new IllegalStateException("Length not yet known.");
    }

    public int getTag() {
        if (!this.state.isEmpty()) {
            return this.state.peek().getTag();
        }
        throw new IllegalStateException("Tag not yet read.");
    }

    public int getValueBytesLeft() {
        if (!this.state.isEmpty()) {
            TLStruct peek = this.state.peek();
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

    public boolean isProcessingValue() {
        return this.isReadingValue;
    }

    public void setDummyLengthProcessed() {
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public void setLengthProcessed(int i11, int i12) {
        if (i11 >= 0) {
            TLStruct pop = this.state.pop();
            if (!this.state.isEmpty()) {
                this.state.peek().updateValueBytesProcessed(i12);
            }
            pop.setLength(i11);
            this.state.push(pop);
            this.isAtStartOfTag = false;
            this.isAtStartOfLength = false;
            this.isReadingValue = true;
            return;
        }
        throw new IllegalArgumentException("Cannot set negative length (length = " + i11 + ", 0x" + Integer.toHexString(i11) + " for tag " + Integer.toHexString(getTag()) + ").");
    }

    public void setTagProcessed(int i11, int i12) {
        TLStruct tLStruct = new TLStruct(this, i11);
        if (!this.state.isEmpty()) {
            this.state.peek().updateValueBytesProcessed(i12);
        }
        this.state.push(tLStruct);
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = true;
        this.isReadingValue = false;
    }

    public String toString() {
        return this.state.toString();
    }

    public void updateValueBytesProcessed(int i11) {
        if (!this.state.isEmpty()) {
            TLStruct peek = this.state.peek();
            int length = peek.getLength() - peek.getValueBytesProcessed();
            if (i11 <= length) {
                peek.updateValueBytesProcessed(i11);
                int length2 = peek.getLength();
                if (peek.getValueBytesProcessed() == length2) {
                    this.state.pop();
                    updateValueBytesProcessed(length2);
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
            throw new IllegalArgumentException("Cannot process " + i11 + " bytes! Only " + length + " bytes left in this TLV object " + peek);
        }
    }

    public TLVInputState(TLVInputState tLVInputState) {
        this(tLVInputState.getDeepCopyOfState(), tLVInputState.isAtStartOfTag, tLVInputState.isAtStartOfLength, tLVInputState.isReadingValue);
    }

    private TLVInputState(Deque<TLStruct> deque, boolean z11, boolean z12, boolean z13) {
        this.state = deque;
        this.isAtStartOfTag = z11;
        this.isAtStartOfLength = z12;
        this.isReadingValue = z13;
    }
}
