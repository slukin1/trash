package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class DefaultAllocator implements Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean z11, int i11) {
        this(z11, i11, 0);
    }

    public synchronized Allocation allocate() {
        Allocation allocation;
        this.allocatedCount++;
        int i11 = this.availableCount;
        if (i11 > 0) {
            Allocation[] allocationArr = this.availableAllocations;
            int i12 = i11 - 1;
            this.availableCount = i12;
            allocation = (Allocation) Assertions.checkNotNull(allocationArr[i12]);
            this.availableAllocations[this.availableCount] = null;
        } else {
            allocation = new Allocation(new byte[this.individualAllocationSize], 0);
        }
        return allocation;
    }

    public int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }

    public synchronized int getTotalBytesAllocated() {
        return this.allocatedCount * this.individualAllocationSize;
    }

    public synchronized void release(Allocation allocation) {
        Allocation[] allocationArr = this.singleAllocationReleaseHolder;
        allocationArr[0] = allocation;
        release(allocationArr);
    }

    public synchronized void reset() {
        if (this.trimOnReset) {
            setTargetBufferSize(0);
        }
    }

    public synchronized void setTargetBufferSize(int i11) {
        boolean z11 = i11 < this.targetBufferSize;
        this.targetBufferSize = i11;
        if (z11) {
            trim();
        }
    }

    public synchronized void trim() {
        int i11 = 0;
        int max = Math.max(0, Util.ceilDivide(this.targetBufferSize, this.individualAllocationSize) - this.allocatedCount);
        int i12 = this.availableCount;
        if (max < i12) {
            if (this.initialAllocationBlock != null) {
                int i13 = i12 - 1;
                while (i11 <= i13) {
                    Allocation allocation = (Allocation) Assertions.checkNotNull(this.availableAllocations[i11]);
                    if (allocation.data == this.initialAllocationBlock) {
                        i11++;
                    } else {
                        Allocation allocation2 = (Allocation) Assertions.checkNotNull(this.availableAllocations[i13]);
                        if (allocation2.data != this.initialAllocationBlock) {
                            i13--;
                        } else {
                            Allocation[] allocationArr = this.availableAllocations;
                            allocationArr[i11] = allocation2;
                            allocationArr[i13] = allocation;
                            i13--;
                            i11++;
                        }
                    }
                }
                max = Math.max(max, i11);
                if (max >= this.availableCount) {
                    return;
                }
            }
            Arrays.fill(this.availableAllocations, max, this.availableCount, (Object) null);
            this.availableCount = max;
        }
    }

    public DefaultAllocator(boolean z11, int i11, int i12) {
        Assertions.checkArgument(i11 > 0);
        Assertions.checkArgument(i12 >= 0);
        this.trimOnReset = z11;
        this.individualAllocationSize = i11;
        this.availableCount = i12;
        this.availableAllocations = new Allocation[(i12 + 100)];
        if (i12 > 0) {
            this.initialAllocationBlock = new byte[(i12 * i11)];
            for (int i13 = 0; i13 < i12; i13++) {
                this.availableAllocations[i13] = new Allocation(this.initialAllocationBlock, i13 * i11);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    public synchronized void release(Allocation[] allocationArr) {
        int i11 = this.availableCount;
        int length = allocationArr.length + i11;
        Allocation[] allocationArr2 = this.availableAllocations;
        if (length >= allocationArr2.length) {
            this.availableAllocations = (Allocation[]) Arrays.copyOf(allocationArr2, Math.max(allocationArr2.length * 2, i11 + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            Allocation[] allocationArr3 = this.availableAllocations;
            int i12 = this.availableCount;
            this.availableCount = i12 + 1;
            allocationArr3[i12] = allocation;
        }
        this.allocatedCount -= allocationArr.length;
        notifyAll();
    }
}
