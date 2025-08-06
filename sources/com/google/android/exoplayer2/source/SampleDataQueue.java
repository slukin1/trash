package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class SampleDataQueue {
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private AllocationNode firstAllocationNode;
    private AllocationNode readAllocationNode;
    private final ParsableByteArray scratch = new ParsableByteArray(32);
    private long totalBytesWritten;
    private AllocationNode writeAllocationNode;

    public static final class AllocationNode {
        public Allocation allocation;
        public final long endPosition;
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j11, int i11) {
            this.startPosition = j11;
            this.endPosition = j11 + ((long) i11);
        }

        public AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }

        public void initialize(Allocation allocation2, AllocationNode allocationNode) {
            this.allocation = allocation2;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public int translateOffset(long j11) {
            return ((int) (j11 - this.startPosition)) + this.allocation.offset;
        }
    }

    public SampleDataQueue(Allocator allocator2) {
        this.allocator = allocator2;
        int individualAllocationLength = allocator2.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        AllocationNode allocationNode = new AllocationNode(0, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            int i11 = (allocationNode2.wasInitialized ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
            Allocation[] allocationArr = new Allocation[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                allocationArr[i12] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private static AllocationNode getNodeContainingPosition(AllocationNode allocationNode, long j11) {
        while (j11 >= allocationNode.endPosition) {
            allocationNode = allocationNode.next;
        }
        return allocationNode;
    }

    private void postAppend(int i11) {
        long j11 = this.totalBytesWritten + ((long) i11);
        this.totalBytesWritten = j11;
        AllocationNode allocationNode = this.writeAllocationNode;
        if (j11 == allocationNode.endPosition) {
            this.writeAllocationNode = allocationNode.next;
        }
    }

    private int preAppend(int i11) {
        AllocationNode allocationNode = this.writeAllocationNode;
        if (!allocationNode.wasInitialized) {
            allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i11, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private static AllocationNode readData(AllocationNode allocationNode, long j11, ByteBuffer byteBuffer, int i11) {
        AllocationNode nodeContainingPosition = getNodeContainingPosition(allocationNode, j11);
        while (i11 > 0) {
            int min = Math.min(i11, (int) (nodeContainingPosition.endPosition - j11));
            byteBuffer.put(nodeContainingPosition.allocation.data, nodeContainingPosition.translateOffset(j11), min);
            i11 -= min;
            j11 += (long) min;
            if (j11 == nodeContainingPosition.endPosition) {
                nodeContainingPosition = nodeContainingPosition.next;
            }
        }
        return nodeContainingPosition;
    }

    private static AllocationNode readEncryptionData(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        SampleQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        long j11 = sampleExtrasHolder2.offset;
        int i11 = 1;
        parsableByteArray2.reset(1);
        AllocationNode readData = readData(allocationNode, j11, parsableByteArray.getData(), 1);
        long j12 = j11 + 1;
        byte b11 = parsableByteArray.getData()[0];
        boolean z11 = (b11 & 128) != 0;
        byte b12 = b11 & Ascii.DEL;
        CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        byte[] bArr = cryptoInfo.f65853iv;
        if (bArr == null) {
            cryptoInfo.f65853iv = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        AllocationNode readData2 = readData(readData, j12, cryptoInfo.f65853iv, (int) b12);
        long j13 = j12 + ((long) b12);
        if (z11) {
            parsableByteArray2.reset(2);
            readData2 = readData(readData2, j13, parsableByteArray.getData(), 2);
            j13 += 2;
            i11 = parsableByteArray.readUnsignedShort();
        }
        int i12 = i11;
        int[] iArr = cryptoInfo.numBytesOfClearData;
        if (iArr == null || iArr.length < i12) {
            iArr = new int[i12];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i12) {
            iArr3 = new int[i12];
        }
        int[] iArr4 = iArr3;
        if (z11) {
            int i13 = i12 * 6;
            parsableByteArray2.reset(i13);
            readData2 = readData(readData2, j13, parsableByteArray.getData(), i13);
            j13 += (long) i13;
            parsableByteArray2.setPosition(0);
            for (int i14 = 0; i14 < i12; i14++) {
                iArr2[i14] = parsableByteArray.readUnsignedShort();
                iArr4[i14] = parsableByteArray.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder2.size - ((int) (j13 - sampleExtrasHolder2.offset));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.castNonNull(sampleExtrasHolder2.cryptoData);
        cryptoInfo.set(i12, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo.f65853iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j14 = sampleExtrasHolder2.offset;
        int i15 = (int) (j13 - j14);
        sampleExtrasHolder2.offset = j14 + ((long) i15);
        sampleExtrasHolder2.size -= i15;
        return readData2;
    }

    private static AllocationNode readSampleData(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.isEncrypted()) {
            allocationNode = readEncryptionData(allocationNode, decoderInputBuffer, sampleExtrasHolder, parsableByteArray);
        }
        if (decoderInputBuffer.hasSupplementalData()) {
            parsableByteArray.reset(4);
            AllocationNode readData = readData(allocationNode, sampleExtrasHolder.offset, parsableByteArray.getData(), 4);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            sampleExtrasHolder.offset += 4;
            sampleExtrasHolder.size -= 4;
            decoderInputBuffer.ensureSpaceForWrite(readUnsignedIntToInt);
            AllocationNode readData2 = readData(readData, sampleExtrasHolder.offset, decoderInputBuffer.data, readUnsignedIntToInt);
            sampleExtrasHolder.offset += (long) readUnsignedIntToInt;
            int i11 = sampleExtrasHolder.size - readUnsignedIntToInt;
            sampleExtrasHolder.size = i11;
            decoderInputBuffer.resetSupplementalData(i11);
            return readData(readData2, sampleExtrasHolder.offset, decoderInputBuffer.supplementalData, sampleExtrasHolder.size);
        }
        decoderInputBuffer.ensureSpaceForWrite(sampleExtrasHolder.size);
        return readData(allocationNode, sampleExtrasHolder.offset, decoderInputBuffer.data, sampleExtrasHolder.size);
    }

    public void discardDownstreamTo(long j11) {
        AllocationNode allocationNode;
        if (j11 != -1) {
            while (true) {
                allocationNode = this.firstAllocationNode;
                if (j11 < allocationNode.endPosition) {
                    break;
                }
                this.allocator.release(allocationNode.allocation);
                this.firstAllocationNode = this.firstAllocationNode.clear();
            }
            if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
                this.readAllocationNode = allocationNode;
            }
        }
    }

    public void discardUpstreamSampleBytes(long j11) {
        this.totalBytesWritten = j11;
        if (j11 != 0) {
            AllocationNode allocationNode = this.firstAllocationNode;
            if (j11 != allocationNode.startPosition) {
                while (this.totalBytesWritten > allocationNode.endPosition) {
                    allocationNode = allocationNode.next;
                }
                AllocationNode allocationNode2 = allocationNode.next;
                clearAllocationNodes(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.endPosition, this.allocationLength);
                allocationNode.next = allocationNode3;
                if (this.totalBytesWritten == allocationNode.endPosition) {
                    allocationNode = allocationNode3;
                }
                this.writeAllocationNode = allocationNode;
                if (this.readAllocationNode == allocationNode2) {
                    this.readAllocationNode = allocationNode3;
                    return;
                }
                return;
            }
        }
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = allocationNode4;
        this.readAllocationNode = allocationNode4;
        this.writeAllocationNode = allocationNode4;
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public void peekToBuffer(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        readSampleData(this.readAllocationNode, decoderInputBuffer, sampleExtrasHolder, this.scratch);
    }

    public void readToBuffer(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        this.readAllocationNode = readSampleData(this.readAllocationNode, decoderInputBuffer, sampleExtrasHolder, this.scratch);
    }

    public void reset() {
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode = new AllocationNode(0, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0;
        this.allocator.trim();
    }

    public void rewind() {
        this.readAllocationNode = this.firstAllocationNode;
    }

    public int sampleData(DataReader dataReader, int i11, boolean z11) throws IOException {
        int preAppend = preAppend(i11);
        AllocationNode allocationNode = this.writeAllocationNode;
        int read = dataReader.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
        if (read != -1) {
            postAppend(read);
            return read;
        } else if (z11) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private static AllocationNode readData(AllocationNode allocationNode, long j11, byte[] bArr, int i11) {
        AllocationNode nodeContainingPosition = getNodeContainingPosition(allocationNode, j11);
        int i12 = i11;
        while (i12 > 0) {
            int min = Math.min(i12, (int) (nodeContainingPosition.endPosition - j11));
            System.arraycopy(nodeContainingPosition.allocation.data, nodeContainingPosition.translateOffset(j11), bArr, i11 - i12, min);
            i12 -= min;
            j11 += (long) min;
            if (j11 == nodeContainingPosition.endPosition) {
                nodeContainingPosition = nodeContainingPosition.next;
            }
        }
        return nodeContainingPosition;
    }

    public void sampleData(ParsableByteArray parsableByteArray, int i11) {
        while (i11 > 0) {
            int preAppend = preAppend(i11);
            AllocationNode allocationNode = this.writeAllocationNode;
            parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
            i11 -= preAppend;
            postAppend(preAppend);
        }
    }
}
