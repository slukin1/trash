package net.sf.scuba.smartcards;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Logger;

public class CardFileInputStream extends InputStream {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    private final byte[] buffer;
    private int bufferLength;
    private int fileLength;

    /* renamed from: fs  reason: collision with root package name */
    private FileSystemStructured f58528fs;
    private int markedOffset;
    private int offsetBufferInFile;
    private int offsetInBuffer;
    private FileInfo[] path;

    public CardFileInputStream(int i11, FileSystemStructured fileSystemStructured) throws CardServiceException {
        this.f58528fs = fileSystemStructured;
        synchronized (fileSystemStructured) {
            FileInfo[] selectedPath = fileSystemStructured.getSelectedPath();
            if (selectedPath == null || selectedPath.length < 1) {
                throw new CardServiceException("No valid file selected, path = " + Arrays.toString(selectedPath));
            }
            FileInfo[] fileInfoArr = new FileInfo[selectedPath.length];
            this.path = fileInfoArr;
            System.arraycopy(selectedPath, 0, fileInfoArr, 0, selectedPath.length);
            this.fileLength = selectedPath[selectedPath.length - 1].getFileLength();
            this.buffer = new byte[i11];
            this.bufferLength = 0;
            this.offsetBufferInFile = 0;
            this.offsetInBuffer = 0;
            this.markedOffset = -1;
        }
    }

    private int fillBufferFromFile(FileInfo[] fileInfoArr, int i11, int i12) throws CardServiceException {
        synchronized (this.f58528fs) {
            if (i12 <= this.buffer.length) {
                if (!Arrays.equals(this.f58528fs.getSelectedPath(), fileInfoArr)) {
                    for (FileInfo fid : fileInfoArr) {
                        this.f58528fs.selectFile(fid.getFID());
                    }
                }
                byte[] readBinary = this.f58528fs.readBinary(i11, i12);
                if (readBinary == null) {
                    return 0;
                }
                System.arraycopy(readBinary, 0, this.buffer, 0, readBinary.length);
                int length = readBinary.length;
                return length;
            }
            throw new IllegalArgumentException("length too big");
        }
    }

    public synchronized int available() {
        return this.bufferLength - this.offsetInBuffer;
    }

    public int getLength() {
        return this.fileLength;
    }

    public int getPostion() {
        return this.offsetBufferInFile + this.offsetInBuffer;
    }

    public void mark(int i11) {
        synchronized (this.f58528fs) {
            this.markedOffset = this.offsetBufferInFile + this.offsetInBuffer;
        }
    }

    public boolean markSupported() {
        synchronized (this.f58528fs) {
        }
        return true;
    }

    public int read() throws IOException {
        synchronized (this.f58528fs) {
            try {
                if (!Arrays.equals(this.path, this.f58528fs.getSelectedPath())) {
                    for (FileInfo fid : this.path) {
                        this.f58528fs.selectFile(fid.getFID());
                    }
                }
                int i11 = this.offsetBufferInFile;
                int i12 = this.offsetInBuffer;
                int i13 = i11 + i12;
                int i14 = this.fileLength;
                if (i13 >= i14) {
                    return -1;
                }
                if (i12 >= this.bufferLength) {
                    int min = Math.min(this.buffer.length, i14 - i13);
                    int i15 = this.offsetBufferInFile + this.bufferLength;
                    int i16 = 0;
                    while (i16 == 0) {
                        i16 = fillBufferFromFile(this.path, i15, min);
                    }
                    this.offsetBufferInFile = i15;
                    this.offsetInBuffer = 0;
                    this.bufferLength = i16;
                }
                byte[] bArr = this.buffer;
                int i17 = this.offsetInBuffer;
                byte b11 = bArr[i17] & 255;
                this.offsetInBuffer = i17 + 1;
                return b11;
            } catch (CardServiceException e11) {
                throw new IOException("Unexpected exception", e11);
            } catch (CardServiceException e12) {
                throw new IOException("Unexpected exception", e12);
            } catch (Exception e13) {
                throw new IOException("Unexpected exception", e13);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void reset() throws IOException {
        synchronized (this.f58528fs) {
            int i11 = this.markedOffset;
            if (i11 >= 0) {
                this.offsetBufferInFile = i11;
                this.offsetInBuffer = 0;
                this.bufferLength = 0;
            } else {
                throw new IOException("Mark not set");
            }
        }
    }

    public long skip(long j11) {
        synchronized (this.f58528fs) {
            int i11 = this.bufferLength;
            int i12 = this.offsetInBuffer;
            if (j11 < ((long) (i11 - i12))) {
                this.offsetInBuffer = (int) (((long) i12) + j11);
            } else {
                this.offsetBufferInFile = (int) (((long) (this.offsetBufferInFile + i12)) + j11);
                this.offsetInBuffer = 0;
                this.bufferLength = 0;
            }
        }
        return j11;
    }
}
