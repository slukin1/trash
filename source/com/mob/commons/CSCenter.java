package com.mob.commons;

import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.ServiceState;
import android.telephony.SubscriptionInfo;
import com.mob.MobCustomController;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.List;

public class CSCenter implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile CSCenter f26886a;

    /* renamed from: b  reason: collision with root package name */
    private volatile MobCustomController f26887b;

    /* renamed from: c  reason: collision with root package name */
    private a f26888c = new a();

    public class a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f26890b = false;

        public a() {
        }

        public boolean a() {
            return this.f26890b;
        }
    }

    private CSCenter() {
    }

    public static CSCenter getInstance() {
        if (f26886a == null) {
            synchronized (CSCenter.class) {
                if (f26886a == null) {
                    f26886a = new CSCenter();
                }
            }
        }
        return f26886a;
    }

    public int getActiveSubscriptionInfoCount() {
        if (this.f26887b == null) {
            return -1;
        }
        try {
            return this.f26887b.getActiveSubscriptionInfoCount();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return -1;
        }
    }

    public List<SubscriptionInfo> getActiveSubscriptionInfoList() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getActiveSubscriptionInfoList();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String getAdvertisingId() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getAdvertisingId();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public List<CellInfo> getAllCellInfo() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getAllCellInfo();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String getAndroidId() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getAndroidId();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String getCellIpv4() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getCellIpv4();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String getCellIpv6() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getCellIpv6();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public CellLocation getCellLocation() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getCellLocation();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public WifiInfo getConnectionInfo() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getConnectionInfo();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String getIpAddress() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getIpAddress();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public Location getLocation() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getLocation();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getNeighboringCellInfo();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public int getNetworkType() {
        if (this.f26887b == null) {
            return -1;
        }
        try {
            return this.f26887b.getNetworkType();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return -1;
        }
    }

    public String getOaid() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            boolean unused = this.f26888c.f26890b = true;
            return this.f26887b.getOaid();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public List<PackageInfo> getPackageInfos() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getPackageInfos();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public ServiceState getServiceState() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getServiceState();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String getSimOperator() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getSimOperator();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String getSimOperatorName() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getSimOperatorName();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public List<ScanResult> getWifiScanResults() {
        if (this.f26887b == null) {
            return null;
        }
        try {
            return this.f26887b.getWifiScanResults();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public a invocationRecord() {
        return this.f26888c;
    }

    public boolean isAdvertisingIdEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isAdvertisingIdEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isAndroidIdEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isAndroidIdEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isAppListDataEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isAppListDataEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isCellLocationDataEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isCellLocationDataEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isConfigEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isConfigEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isCusControllerNotNull() {
        return this.f26887b != null;
    }

    public boolean isDREnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isDREnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isIpAddressEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isIpAddressEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isLocationDataEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isLocationDataEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isOaidEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isOaidEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isPhoneStateDataEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isPhoneStateDataEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isSocietyPlatformDataEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isSocietyPlatformDataEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public boolean isWifiDataEnable() {
        if (this.f26887b == null) {
            return true;
        }
        try {
            return this.f26887b.isWifiDataEnable();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }

    public void updateCustomController(MobCustomController mobCustomController) {
        this.f26887b = mobCustomController;
    }
}
