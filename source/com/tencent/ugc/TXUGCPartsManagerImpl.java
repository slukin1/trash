package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JNINamespace("liteav::ugc")
public class TXUGCPartsManagerImpl implements TXUGCPartsManager {
    private long mNativePartsManager = 0;

    public TXUGCPartsManagerImpl(long j11) {
        this.mNativePartsManager = j11;
    }

    private static native void nativeAddPart(long j11, String str, long j12);

    private static native void nativeDeleteAllParts(long j11);

    private static native void nativeDeleteLastPart(long j11);

    private static native void nativeDeletePart(long j11, int i11);

    private static native void nativeDestroy(long j11);

    private static native int nativeGetDuration(long j11);

    private static native String[] nativeGetPartsPathList(long j11);

    private static native void nativeInsertPart(long j11, String str, int i11);

    public void addClipInfo(PartInfo partInfo) {
        long j11 = this.mNativePartsManager;
        if (j11 != 0) {
            nativeAddPart(j11, partInfo.getPath(), partInfo.getDuration());
        }
    }

    public void deleteAllParts() {
        long j11 = this.mNativePartsManager;
        if (j11 != 0) {
            nativeDeleteAllParts(j11);
        }
    }

    public void deleteLastPart() {
        long j11 = this.mNativePartsManager;
        if (j11 != 0) {
            nativeDeleteLastPart(j11);
        }
    }

    public void deletePart(int i11) {
        long j11 = this.mNativePartsManager;
        if (j11 != 0) {
            nativeDeletePart(j11, i11);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        long j11 = this.mNativePartsManager;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativePartsManager = 0;
        }
    }

    public int getDuration() {
        long j11 = this.mNativePartsManager;
        if (j11 != 0) {
            return nativeGetDuration(j11);
        }
        return 0;
    }

    public List<String> getPartsPathList() {
        String[] nativeGetPartsPathList;
        ArrayList arrayList = new ArrayList();
        long j11 = this.mNativePartsManager;
        if (!(j11 == 0 || (nativeGetPartsPathList = nativeGetPartsPathList(j11)) == null || nativeGetPartsPathList.length == 0)) {
            arrayList.addAll(Arrays.asList(nativeGetPartsPathList));
        }
        return arrayList;
    }

    public void insertPart(String str, int i11) {
        long j11 = this.mNativePartsManager;
        if (j11 != 0) {
            nativeInsertPart(j11, str, i11);
        }
    }
}
