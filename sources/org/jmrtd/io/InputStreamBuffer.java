package org.jmrtd.io;

import java.io.IOException;
import java.io.InputStream;
import org.jmrtd.io.FragmentBuffer;

public class InputStreamBuffer {
    /* access modifiers changed from: private */
    public FragmentBuffer buffer;
    /* access modifiers changed from: private */
    public PositionInputStream carrier;

    public InputStreamBuffer(InputStream inputStream, int i11) {
        PositionInputStream positionInputStream = new PositionInputStream(inputStream);
        this.carrier = positionInputStream;
        positionInputStream.mark(i11);
        this.buffer = new FragmentBuffer(i11);
    }

    public synchronized int getBytesBuffered() {
        return this.buffer.getBytesBuffered();
    }

    public SubInputStream getInputStream() {
        SubInputStream subInputStream;
        synchronized (this.carrier) {
            subInputStream = new SubInputStream(this.carrier);
        }
        return subInputStream;
    }

    public int getLength() {
        return this.buffer.getLength();
    }

    public synchronized int getPosition() {
        return this.buffer.getPosition();
    }

    public String toString() {
        return "InputStreamBuffer [" + this.buffer + "]";
    }

    public void updateFrom(InputStreamBuffer inputStreamBuffer) {
        this.buffer.updateFrom(inputStreamBuffer.buffer);
    }

    public class SubInputStream extends InputStream {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private int markedPosition = -1;
        private int position = 0;
        private Object syncObject;

        public SubInputStream(Object obj) {
            this.syncObject = obj;
        }

        private void syncCarrierPosition(int i11) throws IOException {
            long j11 = (long) i11;
            if (j11 != InputStreamBuffer.this.carrier.getPosition()) {
                InputStreamBuffer.this.carrier.reset();
                int i12 = 0;
                while (i12 < i11) {
                    long j12 = (long) i12;
                    i12 = (int) (j12 + InputStreamBuffer.this.carrier.skip(j11 - j12));
                }
            }
        }

        public int available() throws IOException {
            return InputStreamBuffer.this.buffer.getBufferedLength(this.position);
        }

        public void close() throws IOException {
        }

        public FragmentBuffer getBuffer() {
            return InputStreamBuffer.this.buffer;
        }

        public int getPosition() {
            return this.position;
        }

        public synchronized void mark(int i11) {
            this.markedPosition = this.position;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() throws IOException {
            synchronized (this.syncObject) {
                if (this.position >= InputStreamBuffer.this.buffer.getLength()) {
                    return -1;
                }
                if (InputStreamBuffer.this.buffer.isCoveredByFragment(this.position)) {
                    byte[] buffer = InputStreamBuffer.this.buffer.getBuffer();
                    int i11 = this.position;
                    this.position = i11 + 1;
                    byte b11 = buffer[i11] & 255;
                    return b11;
                }
                if (InputStreamBuffer.this.carrier.markSupported()) {
                    syncCarrierPosition(this.position);
                }
                try {
                    int read = InputStreamBuffer.this.carrier.read();
                    if (read < 0) {
                        return -1;
                    }
                    FragmentBuffer access$000 = InputStreamBuffer.this.buffer;
                    int i12 = this.position;
                    this.position = i12 + 1;
                    access$000.addFragment(i12, (byte) read);
                    return read;
                } catch (IOException e11) {
                    throw e11;
                }
            }
        }

        public synchronized void reset() throws IOException {
            int i11 = this.markedPosition;
            if (i11 >= 0) {
                this.position = i11;
            } else {
                throw new IOException("Invalid reset, was mark() called?");
            }
        }

        public long skip(long j11) throws IOException {
            long j12;
            synchronized (this.syncObject) {
                int bufferedLength = InputStreamBuffer.this.buffer.getBufferedLength(this.position);
                long j13 = (long) bufferedLength;
                if (j11 <= j13) {
                    this.position = (int) (((long) this.position) + j11);
                    return j11;
                }
                this.position += bufferedLength;
                if (InputStreamBuffer.this.carrier.markSupported()) {
                    syncCarrierPosition(this.position);
                    j12 = InputStreamBuffer.this.carrier.skip(j11 - j13);
                    this.position += (int) j12;
                } else {
                    j12 = super.skip(j11 - j13);
                }
                long j14 = j13 + j12;
                return j14;
            }
        }

        public int read(byte[] bArr) throws IOException {
            int read;
            synchronized (this.syncObject) {
                read = read(bArr, 0, bArr.length);
            }
            return read;
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            synchronized (this.syncObject) {
                if (bArr != null) {
                    if (i11 >= 0 && i12 >= 0) {
                        if (i12 <= bArr.length - i11) {
                            if (i12 == 0) {
                                return 0;
                            }
                            if (i12 > InputStreamBuffer.this.buffer.getLength() - this.position) {
                                i12 = InputStreamBuffer.this.buffer.getLength() - this.position;
                            }
                            if (this.position >= InputStreamBuffer.this.buffer.getLength()) {
                                return -1;
                            }
                            if (InputStreamBuffer.this.carrier.markSupported()) {
                                syncCarrierPosition(this.position);
                            }
                            FragmentBuffer.Fragment smallestUnbufferedFragment = InputStreamBuffer.this.buffer.getSmallestUnbufferedFragment(this.position, i12);
                            if (smallestUnbufferedFragment.getLength() > 0) {
                                int offset = smallestUnbufferedFragment.getOffset() - this.position;
                                int length = smallestUnbufferedFragment.getLength();
                                System.arraycopy(InputStreamBuffer.this.buffer.getBuffer(), this.position, bArr, i11, offset);
                                this.position += offset;
                                if (InputStreamBuffer.this.carrier.markSupported()) {
                                    syncCarrierPosition(this.position);
                                }
                                int i13 = i11 + offset;
                                int read = InputStreamBuffer.this.carrier.read(bArr, i13, length);
                                InputStreamBuffer.this.buffer.addFragment(smallestUnbufferedFragment.getOffset(), bArr, i13, read);
                                this.position += read;
                                int i14 = offset + read;
                                return i14;
                            }
                            int min = Math.min(i12, InputStreamBuffer.this.buffer.getLength() - this.position);
                            System.arraycopy(InputStreamBuffer.this.buffer.getBuffer(), this.position, bArr, i11, min);
                            this.position += min;
                            return min;
                        }
                    }
                    throw new IndexOutOfBoundsException();
                }
                throw new NullPointerException();
            }
        }
    }
}
