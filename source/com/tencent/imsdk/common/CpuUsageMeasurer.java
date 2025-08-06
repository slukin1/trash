package com.tencent.imsdk.common;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.imsdk.manager.BaseManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CpuUsageMeasurer {
    private static final String TAG = "CpuUsageMeasurer";
    private static final long UPDATE_INTERVAL = TimeUnit.SECONDS.toMillis(2);
    private final long mClockClkInHz = BaseManager.getInstance().getClockTickInHz();
    private long mIdleCpuTime = 0;
    private float mLastAppCpuTimeUsed = 0.0f;
    private float mLastAppCpuUsage = 0.0f;
    private float mLastSysCpuUsage = 0.0f;
    private long mLastUpdateTime = 0;
    private RandomAccessFile mProcessStatFile;
    private final int mProcessorCount = Runtime.getRuntime().availableProcessors();
    private RandomAccessFile mSystemStatFile;
    private long mTotalCpuTime = 0;

    public CpuUsageMeasurer() {
        try {
            this.mProcessStatFile = new RandomAccessFile(String.format(Locale.ENGLISH, "/proc/%d/stat", new Object[]{Integer.valueOf(Process.myPid())}), "r");
        } catch (IOException e11) {
            IMLog.e(TAG, "open /proc/[PID]/stat failed. " + e11.getMessage());
        }
        try {
            this.mSystemStatFile = new RandomAccessFile("/proc/stat", "r");
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static String[] readFirstLineAndSplit(RandomAccessFile randomAccessFile) {
        String str;
        if (randomAccessFile == null) {
            return null;
        }
        try {
            randomAccessFile.seek(0);
            str = randomAccessFile.readLine();
        } catch (IOException e11) {
            IMLog.e(TAG, "read line failed. " + e11.getMessage());
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("\\s+");
    }

    private void updateCpuUsage() {
        long j11;
        long j12;
        String[] readFirstLineAndSplit = readFirstLineAndSplit(this.mProcessStatFile);
        if (readFirstLineAndSplit != null && readFirstLineAndSplit.length >= 52) {
            long parseLong = (long) ((((float) (((Long.parseLong(readFirstLineAndSplit[13]) + Long.parseLong(readFirstLineAndSplit[14])) + Long.parseLong(readFirstLineAndSplit[15])) + Long.parseLong(readFirstLineAndSplit[16]))) * 1000.0f) / ((float) this.mClockClkInHz));
            String[] readFirstLineAndSplit2 = readFirstLineAndSplit(this.mSystemStatFile);
            if (readFirstLineAndSplit2 == null || readFirstLineAndSplit2.length < 8) {
                j11 = BaseManager.getInstance().getTimeTick() * ((long) this.mProcessorCount);
                j12 = j11;
            } else {
                long parseLong2 = Long.parseLong(readFirstLineAndSplit2[1]) + Long.parseLong(readFirstLineAndSplit2[2]) + Long.parseLong(readFirstLineAndSplit2[3]) + Long.parseLong(readFirstLineAndSplit2[4]) + Long.parseLong(readFirstLineAndSplit2[5]) + Long.parseLong(readFirstLineAndSplit2[6]) + Long.parseLong(readFirstLineAndSplit2[7]);
                long parseLong3 = Long.parseLong(readFirstLineAndSplit2[4]) + Long.parseLong(readFirstLineAndSplit2[5]);
                long j13 = this.mClockClkInHz;
                j11 = (long) ((((float) parseLong2) * 1000.0f) / ((float) j13));
                j12 = (long) ((((float) parseLong3) * 1000.0f) / ((float) j13));
            }
            long j14 = j11 - this.mTotalCpuTime;
            float f11 = (float) parseLong;
            float f12 = (float) j14;
            this.mLastAppCpuUsage = ((f11 - this.mLastAppCpuTimeUsed) * 100.0f) / f12;
            this.mLastSysCpuUsage = (((float) (j14 - (j12 - this.mIdleCpuTime))) * 100.0f) / f12;
            this.mLastAppCpuTimeUsed = f11;
            this.mIdleCpuTime = j12;
            this.mTotalCpuTime = j11;
            this.mLastUpdateTime = BaseManager.getInstance().getTimeTick();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        closeQuietly(this.mProcessStatFile);
        closeQuietly(this.mSystemStatFile);
        IMLog.i(TAG, "measurer is released");
    }

    public int[] getCpuUsage() {
        int[] iArr;
        synchronized (this) {
            if (BaseManager.getInstance().getTimeTick() - this.mLastUpdateTime >= UPDATE_INTERVAL) {
                updateCpuUsage();
            }
            iArr = new int[]{(int) (this.mLastAppCpuUsage * 10.0f), (int) (this.mLastSysCpuUsage * 10.0f)};
        }
        return iArr;
    }
}
