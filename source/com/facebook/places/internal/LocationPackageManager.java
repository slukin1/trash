package com.facebook.places.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.places.internal.ScannerException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class LocationPackageManager {
    private static final String TAG = "LocationPackageManager";

    public interface Listener {
        void onLocationPackage(LocationPackage locationPackage);
    }

    /* access modifiers changed from: private */
    public static void logException(String str, Throwable th2) {
        if (FacebookSdk.isDebugEnabled()) {
            Log.e(TAG, str, th2);
        }
    }

    /* access modifiers changed from: private */
    public static FutureTask<LocationPackage> newBluetoothScanFuture(final LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|6|7|8|(1:10)(3:11|(1:13)|14)) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
            /* JADX WARNING: Removed duplicated region for block: B:10:0x0029 A[Catch:{ all -> 0x0052, Exception -> 0x0057 }] */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A[Catch:{ all -> 0x0052, Exception -> 0x0057 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.facebook.places.internal.LocationPackage call() throws java.lang.Exception {
                /*
                    r7 = this;
                    com.facebook.places.internal.LocationPackage r0 = new com.facebook.places.internal.LocationPackage
                    r0.<init>()
                    r1 = 0
                    android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x0057 }
                    com.facebook.places.internal.LocationPackageRequestParams r3 = r2     // Catch:{ Exception -> 0x0057 }
                    com.facebook.places.internal.BleScanner r2 = com.facebook.places.internal.ScannerFactory.newBleScanner(r2, r3)     // Catch:{ Exception -> 0x0057 }
                    r2.initAndCheckEligibility()     // Catch:{ Exception -> 0x0057 }
                    r2.startScanning()     // Catch:{ all -> 0x0052 }
                    com.facebook.places.internal.LocationPackageRequestParams r3 = r2     // Catch:{ Exception -> 0x001f }
                    long r3 = r3.getBluetoothScanDurationMs()     // Catch:{ Exception -> 0x001f }
                    java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x001f }
                L_0x001f:
                    r2.stopScanning()     // Catch:{ Exception -> 0x0057 }
                    int r3 = r2.getErrorCode()     // Catch:{ Exception -> 0x0057 }
                    r4 = 1
                    if (r3 != 0) goto L_0x0032
                    java.util.List r2 = r2.getScanResults()     // Catch:{ Exception -> 0x0057 }
                    r0.ambientBluetoothLe = r2     // Catch:{ Exception -> 0x0057 }
                    r0.isBluetoothScanningEnabled = r4     // Catch:{ Exception -> 0x0057 }
                    goto L_0x005f
                L_0x0032:
                    boolean r2 = com.facebook.FacebookSdk.isDebugEnabled()     // Catch:{ Exception -> 0x0057 }
                    if (r2 == 0) goto L_0x004f
                    java.lang.String r2 = "LocationPackageManager"
                    java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0057 }
                    java.lang.String r6 = "Bluetooth LE scan failed with error: %d"
                    java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0057 }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0057 }
                    r4[r1] = r3     // Catch:{ Exception -> 0x0057 }
                    java.lang.String r3 = java.lang.String.format(r5, r6, r4)     // Catch:{ Exception -> 0x0057 }
                    com.facebook.internal.Utility.logd((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0057 }
                L_0x004f:
                    r0.isBluetoothScanningEnabled = r1     // Catch:{ Exception -> 0x0057 }
                    goto L_0x005f
                L_0x0052:
                    r3 = move-exception
                    r2.stopScanning()     // Catch:{ Exception -> 0x0057 }
                    throw r3     // Catch:{ Exception -> 0x0057 }
                L_0x0057:
                    r2 = move-exception
                    java.lang.String r3 = "Exception scanning for bluetooth beacons"
                    com.facebook.places.internal.LocationPackageManager.logException(r3, r2)
                    r0.isBluetoothScanningEnabled = r1
                L_0x005f:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.LocationPackageManager.AnonymousClass3.call():com.facebook.places.internal.LocationPackage");
            }
        });
    }

    /* access modifiers changed from: private */
    public static FutureTask<LocationPackage> newLocationScanFuture(final LocationScanner locationScanner, LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            public LocationPackage call() throws Exception {
                LocationPackage locationPackage = new LocationPackage();
                try {
                    locationPackage.location = locationScanner.getLocation();
                } catch (ScannerException e11) {
                    locationPackage.locationError = e11.type;
                    LocationPackageManager.logException("Exception while getting location", e11);
                } catch (Exception unused) {
                    locationPackage.locationError = ScannerException.Type.UNKNOWN_ERROR;
                }
                return locationPackage;
            }
        });
    }

    /* access modifiers changed from: private */
    public static FutureTask<LocationPackage> newWifiScanFuture(final LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            public LocationPackage call() throws Exception {
                LocationPackage locationPackage = new LocationPackage();
                try {
                    WifiScanner newWifiScanner = ScannerFactory.newWifiScanner(FacebookSdk.getApplicationContext(), locationPackageRequestParams);
                    newWifiScanner.initAndCheckEligibility();
                    locationPackage.connectedWifi = newWifiScanner.getConnectedWifi();
                    boolean isWifiScanningEnabled = newWifiScanner.isWifiScanningEnabled();
                    locationPackage.isWifiScanningEnabled = isWifiScanningEnabled;
                    if (isWifiScanningEnabled) {
                        locationPackage.ambientWifi = newWifiScanner.getWifiScans();
                    }
                } catch (Exception e11) {
                    LocationPackageManager.logException("Exception scanning for wifi access points", e11);
                    locationPackage.isWifiScanningEnabled = false;
                }
                return locationPackage;
            }
        });
    }

    public static void requestLocationPackage(final LocationPackageRequestParams locationPackageRequestParams, final Listener listener) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                FutureTask futureTask;
                FutureTask futureTask2;
                LocationPackage locationPackage = new LocationPackage();
                try {
                    FutureTask futureTask3 = null;
                    if (locationPackageRequestParams.isLocationScanEnabled()) {
                        LocationScanner newLocationScanner = ScannerFactory.newLocationScanner(FacebookSdk.getApplicationContext(), locationPackageRequestParams);
                        newLocationScanner.initAndCheckEligibility();
                        futureTask = LocationPackageManager.newLocationScanFuture(newLocationScanner, locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask);
                    } else {
                        futureTask = null;
                    }
                    if (locationPackageRequestParams.isWifiScanEnabled()) {
                        futureTask2 = LocationPackageManager.newWifiScanFuture(locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask2);
                    } else {
                        futureTask2 = null;
                    }
                    if (locationPackageRequestParams.isBluetoothScanEnabled()) {
                        futureTask3 = LocationPackageManager.newBluetoothScanFuture(locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask3);
                    }
                    if (futureTask3 != null) {
                        try {
                            LocationPackage locationPackage2 = (LocationPackage) futureTask3.get();
                            locationPackage.ambientBluetoothLe = locationPackage2.ambientBluetoothLe;
                            locationPackage.isBluetoothScanningEnabled = locationPackage2.isBluetoothScanningEnabled;
                        } catch (Exception e11) {
                            LocationPackageManager.logException("Exception scanning for bluetooth beacons", e11);
                        }
                    }
                    if (futureTask2 != null) {
                        try {
                            LocationPackage locationPackage3 = (LocationPackage) futureTask2.get();
                            locationPackage.isWifiScanningEnabled = locationPackage3.isWifiScanningEnabled;
                            locationPackage.connectedWifi = locationPackage3.connectedWifi;
                            locationPackage.ambientWifi = locationPackage3.ambientWifi;
                        } catch (Exception e12) {
                            LocationPackageManager.logException("Exception scanning for wifi access points", e12);
                        }
                    }
                    if (futureTask != null) {
                        try {
                            LocationPackage locationPackage4 = (LocationPackage) futureTask.get();
                            locationPackage.locationError = locationPackage4.locationError;
                            locationPackage.location = locationPackage4.location;
                        } catch (Exception e13) {
                            LocationPackageManager.logException("Exception getting location", e13);
                        }
                    }
                } catch (ScannerException e14) {
                    LocationPackageManager.logException("Exception scanning for locations", e14);
                    locationPackage.locationError = e14.type;
                } catch (Exception e15) {
                    LocationPackageManager.logException("Exception requesting a location package", e15);
                }
                listener.onLocationPackage(locationPackage);
            }
        });
    }
}
