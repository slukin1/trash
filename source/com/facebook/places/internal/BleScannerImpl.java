package com.facebook.places.internal;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.Validate;
import com.facebook.places.internal.ScannerException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@TargetApi(21)
public class BleScannerImpl implements BleScanner {
    private static final byte[] EDDYSTONE_PREFIX = fromHexString("16aafe");
    private static final byte[] GRAVITY_PREFIX = fromHexString("17ffab01");
    private static final byte[] IBEACON_PREFIX = fromHexString("ff4c000215");
    private static final String TAG = "BleScannerImpl";
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;
    private Context context;
    /* access modifiers changed from: private */
    public int errorCode;
    private boolean isScanInProgress;
    private LocationPackageRequestParams params;
    private ScanCallBackImpl scanCallBack;
    /* access modifiers changed from: private */
    public final List<BluetoothScanResult> scanResults = new ArrayList();

    public class ScanCallBackImpl extends ScanCallback {
        private ScanCallBackImpl() {
        }

        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
            try {
                synchronized (BleScannerImpl.this.scanResults) {
                    for (ScanResult access$400 : list) {
                        BluetoothScanResult access$4002 = BleScannerImpl.newBluetoothScanResult(access$400);
                        if (access$4002 != null) {
                            BleScannerImpl.this.scanResults.add(access$4002);
                        }
                    }
                }
            } catch (Exception e11) {
                BleScannerImpl.logException("Exception in ble scan callback", e11);
            }
        }

        public void onScanFailed(int i11) {
            super.onScanFailed(i11);
            int unused = BleScannerImpl.this.errorCode = i11;
        }

        public void onScanResult(int i11, ScanResult scanResult) {
            super.onScanResult(i11, scanResult);
            try {
                synchronized (BleScannerImpl.this.scanResults) {
                    BluetoothScanResult access$400 = BleScannerImpl.newBluetoothScanResult(scanResult);
                    if (access$400 != null) {
                        BleScannerImpl.this.scanResults.add(access$400);
                    }
                }
            } catch (Exception e11) {
                BleScannerImpl.logException("Exception in ble scan callback", e11);
            }
        }
    }

    public BleScannerImpl(Context context2, LocationPackageRequestParams locationPackageRequestParams) {
        this.context = context2;
        this.params = locationPackageRequestParams;
    }

    private static String formatPayload(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return toHexString(bArr, getPayloadLength(bArr));
    }

    private static byte[] fromHexString(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i11 = 0; i11 < length; i11 += 2) {
            bArr[i11 / 2] = (byte) ((Character.digit(str.charAt(i11), 16) << 4) + Character.digit(str.charAt(i11 + 1), 16));
        }
        return bArr;
    }

    private static int getPayloadLength(byte[] bArr) {
        int i11 = 0;
        while (i11 < bArr.length) {
            byte b11 = bArr[i11];
            if (b11 == 0) {
                return i11;
            }
            if (b11 < 0) {
                return bArr.length;
            }
            i11 += b11 + 1;
        }
        return bArr.length;
    }

    private static boolean isAdvPacketBeacon(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        if (!isArrayContained(bArr, i12, IBEACON_PREFIX) && !isArrayContained(bArr, i12, EDDYSTONE_PREFIX) && !isArrayContained(bArr, i11, GRAVITY_PREFIX) && !isAltBeacon(bArr, i11)) {
            return false;
        }
        return true;
    }

    private static boolean isAltBeacon(byte[] bArr, int i11) {
        int i12 = i11 + 5;
        if (i12 >= bArr.length) {
            return false;
        }
        byte b11 = bArr[i11];
        byte b12 = bArr[i11 + 1];
        byte b13 = bArr[i11 + 4];
        byte b14 = bArr[i12];
        if (b11 == 27 && b12 == -1 && b13 == -66 && b14 == -84) {
            return true;
        }
        return false;
    }

    private static boolean isArrayContained(byte[] bArr, int i11, byte[] bArr2) {
        int length = bArr2.length;
        if (i11 + length > bArr.length) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            if (bArr[i11 + i12] != bArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBeacon(byte[] bArr) {
        int i11;
        if (bArr == null) {
            return false;
        }
        int length = bArr.length;
        int i12 = 0;
        while (i12 < length) {
            byte b11 = bArr[i12];
            if (b11 <= 0 || (i11 = b11 + 1 + i12) > length) {
                return false;
            }
            if (isAdvPacketBeacon(bArr, i12)) {
                return true;
            }
            i12 = i11;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static void logException(String str, Exception exc) {
        if (FacebookSdk.isDebugEnabled()) {
            Log.e(TAG, str, exc);
        }
    }

    /* access modifiers changed from: private */
    public static BluetoothScanResult newBluetoothScanResult(ScanResult scanResult) {
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (isBeacon(scanRecord.getBytes())) {
            return new BluetoothScanResult(formatPayload(scanRecord.getBytes()), scanResult.getRssi(), scanResult.getTimestampNanos());
        }
        return null;
    }

    private static String toHexString(byte[] bArr, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i11 < 0 || i11 > bArr.length) {
            i11 = bArr.length;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i12])}));
        }
        return stringBuffer.toString();
    }

    private void waitForMainLooper(long j11) {
        try {
            final Object obj = new Object();
            synchronized (obj) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        try {
                            synchronized (obj) {
                                obj.notify();
                            }
                        } catch (Exception e11) {
                            BleScannerImpl.logException("Exception waiting for main looper", e11);
                        }
                    }
                });
                obj.wait(j11);
            }
        } catch (Exception e11) {
            logException("Exception waiting for main looper", e11);
        }
    }

    public synchronized int getErrorCode() {
        return this.errorCode;
    }

    public synchronized List<BluetoothScanResult> getScanResults() {
        ArrayList arrayList;
        synchronized (this.scanResults) {
            int bluetoothMaxScanResults = this.params.getBluetoothMaxScanResults();
            if (this.scanResults.size() > bluetoothMaxScanResults) {
                arrayList = new ArrayList(bluetoothMaxScanResults);
                Collections.sort(this.scanResults, new Comparator<BluetoothScanResult>() {
                    public int compare(BluetoothScanResult bluetoothScanResult, BluetoothScanResult bluetoothScanResult2) {
                        return bluetoothScanResult2.rssi - bluetoothScanResult.rssi;
                    }
                });
                arrayList.addAll(this.scanResults.subList(0, bluetoothMaxScanResults));
            } else {
                arrayList = new ArrayList(this.scanResults.size());
                arrayList.addAll(this.scanResults);
            }
        }
        return arrayList;
    }

    public synchronized void initAndCheckEligibility() throws ScannerException {
        if (Build.VERSION.SDK_INT < 21) {
            throw new ScannerException(ScannerException.Type.NOT_SUPPORTED);
        } else if (!Validate.hasBluetoothPermission(this.context)) {
            throw new ScannerException(ScannerException.Type.PERMISSION_DENIED);
        } else if (Validate.hasLocationPermission(this.context)) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.bluetoothAdapter = defaultAdapter;
            if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
                throw new ScannerException(ScannerException.Type.DISABLED);
            }
            BluetoothLeScanner bluetoothLeScanner2 = this.bluetoothAdapter.getBluetoothLeScanner();
            this.bluetoothLeScanner = bluetoothLeScanner2;
            if (bluetoothLeScanner2 == null) {
                throw new ScannerException(ScannerException.Type.UNKNOWN_ERROR);
            }
        } else {
            throw new ScannerException(ScannerException.Type.PERMISSION_DENIED);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        throw new com.facebook.places.internal.ScannerException(com.facebook.places.internal.ScannerException.Type.UNKNOWN_ERROR);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void startScanning() throws com.facebook.places.internal.ScannerException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.isScanInProgress     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x0050
            com.facebook.places.internal.BleScannerImpl$ScanCallBackImpl r0 = new com.facebook.places.internal.BleScannerImpl$ScanCallBackImpl     // Catch:{ all -> 0x0058 }
            r1 = 0
            r0.<init>()     // Catch:{ all -> 0x0058 }
            r5.scanCallBack = r0     // Catch:{ all -> 0x0058 }
            r0 = 1
            r5.isScanInProgress = r0     // Catch:{ all -> 0x0058 }
            r2 = 0
            r5.errorCode = r2     // Catch:{ all -> 0x0058 }
            java.util.List<com.facebook.places.internal.BluetoothScanResult> r2 = r5.scanResults     // Catch:{ all -> 0x0058 }
            monitor-enter(r2)     // Catch:{ all -> 0x0058 }
            java.util.List<com.facebook.places.internal.BluetoothScanResult> r3 = r5.scanResults     // Catch:{ all -> 0x004d }
            r3.clear()     // Catch:{ all -> 0x004d }
            monitor-exit(r2)     // Catch:{ all -> 0x004d }
            android.bluetooth.le.BluetoothLeScanner r2 = r5.bluetoothLeScanner     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0045
            android.bluetooth.le.ScanSettings$Builder r2 = new android.bluetooth.le.ScanSettings$Builder     // Catch:{ Exception -> 0x003d }
            r2.<init>()     // Catch:{ Exception -> 0x003d }
            r3 = 2
            r2.setScanMode(r3)     // Catch:{ Exception -> 0x003d }
            r3 = 0
            r2.setReportDelay(r3)     // Catch:{ Exception -> 0x003d }
            android.bluetooth.le.BluetoothLeScanner r3 = r5.bluetoothLeScanner     // Catch:{ Exception -> 0x003d }
            android.bluetooth.le.ScanSettings r2 = r2.build()     // Catch:{ Exception -> 0x003d }
            com.facebook.places.internal.BleScannerImpl$ScanCallBackImpl r4 = r5.scanCallBack     // Catch:{ Exception -> 0x003d }
            r3.startScan(r1, r2, r4)     // Catch:{ Exception -> 0x003d }
            r5.isScanInProgress = r0     // Catch:{ Exception -> 0x003d }
            monitor-exit(r5)
            return
        L_0x003d:
            com.facebook.places.internal.ScannerException r0 = new com.facebook.places.internal.ScannerException     // Catch:{ all -> 0x0058 }
            com.facebook.places.internal.ScannerException$Type r1 = com.facebook.places.internal.ScannerException.Type.UNKNOWN_ERROR     // Catch:{ all -> 0x0058 }
            r0.<init>(r1)     // Catch:{ all -> 0x0058 }
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0045:
            com.facebook.places.internal.ScannerException r0 = new com.facebook.places.internal.ScannerException     // Catch:{ all -> 0x0058 }
            com.facebook.places.internal.ScannerException$Type r1 = com.facebook.places.internal.ScannerException.Type.UNKNOWN_ERROR     // Catch:{ all -> 0x0058 }
            r0.<init>(r1)     // Catch:{ all -> 0x0058 }
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x004d:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004d }
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0050:
            com.facebook.places.internal.ScannerException r0 = new com.facebook.places.internal.ScannerException     // Catch:{ all -> 0x0058 }
            com.facebook.places.internal.ScannerException$Type r1 = com.facebook.places.internal.ScannerException.Type.SCAN_ALREADY_IN_PROGRESS     // Catch:{ all -> 0x0058 }
            r0.<init>(r1)     // Catch:{ all -> 0x0058 }
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.BleScannerImpl.startScanning():void");
    }

    public synchronized void stopScanning() {
        this.bluetoothLeScanner.flushPendingScanResults(this.scanCallBack);
        this.bluetoothLeScanner.stopScan(this.scanCallBack);
        waitForMainLooper(this.params.getBluetoothFlushResultsTimeoutMs());
        this.isScanInProgress = false;
    }
}
