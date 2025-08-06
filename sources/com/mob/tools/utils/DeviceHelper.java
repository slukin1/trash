package com.mob.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.view.View;
import com.mob.commons.v;
import com.mob.tools.b.c;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeviceHelper implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static DeviceHelper f28042a = new DeviceHelper();

    /* renamed from: b  reason: collision with root package name */
    private Context f28043b;

    public static Object currentActivityThread() {
        return v.b();
    }

    public static synchronized DeviceHelper getInstance(Context context) {
        DeviceHelper deviceHelper;
        synchronized (DeviceHelper.class) {
            DeviceHelper deviceHelper2 = f28042a;
            if (deviceHelper2.f28043b == null && context != null) {
                deviceHelper2.f28043b = context.getApplicationContext();
            }
            deviceHelper = f28042a;
        }
        return deviceHelper;
    }

    public String Base64AES(String str, String str2) {
        return Data.Base64AES(str, str2);
    }

    public boolean checkNetworkAvailable() {
        return c.a(this.f28043b).d().G();
    }

    public boolean checkPad() {
        return c.a(this.f28043b).d().c();
    }

    public boolean checkPermission(String str) {
        return c.a(this.f28043b).d().e(str);
    }

    public boolean checkUA() {
        return c.a(this.f28043b).d().f();
    }

    public boolean cx() {
        return c.a(this.f28043b).d().b();
    }

    public boolean debugable() {
        return c.a(this.f28043b).d().d();
    }

    public boolean devEnable() {
        return c.a(this.f28043b).d().g();
    }

    public ApplicationInfo getAInfo() {
        return c.a(this.f28043b).d().ak();
    }

    public HashMap<String, Object> getALLD() {
        return c.a(this.f28043b).d().aj();
    }

    public String getAdvertisingID() throws Throwable {
        return c.a(this.f28043b).d().j();
    }

    public String getAppLanguage() {
        return c.a(this.f28043b).d().B();
    }

    public long getAppLastUpdateTime() {
        return c.a(this.f28043b).d().ad();
    }

    public String getAppName() {
        return c.a(this.f28043b).d().U();
    }

    public int getAppVersion() {
        return c.a(this.f28043b).d().V();
    }

    public String getAppVersionName() {
        return c.a(this.f28043b).d().W();
    }

    public Context getApplication() {
        return c.a(this.f28043b).d().aa();
    }

    public ArrayList<HashMap<String, Object>> getAvailableWifiListOneKey() {
        return c.a(this.f28043b).d().al();
    }

    public String getBaseband() {
        return c.a(this.f28043b).d().K();
    }

    public String getBoardFromSysProperty() {
        return c.a(this.f28043b).d().L();
    }

    public String getBoardPlatform() {
        return c.a(this.f28043b).d().M();
    }

    public String getBrand() {
        return c.a(this.f28043b).d().n();
    }

    public String getBssid() {
        return c.a(this.f28043b).d().b(false);
    }

    public String getCInfo() {
        return c.a(this.f28043b).d().ag();
    }

    public HashMap<String, Object> getCPUInfo() {
        return c.a(this.f28043b).d().w();
    }

    public String getCarrier() {
        return getCarrier(false);
    }

    public String getCarrierName() {
        return getCarrierName(false);
    }

    public String getCgroup() {
        return c.a(this.f28043b).d().af();
    }

    public String getCurrentProcessName() {
        return c.a(this.f28043b).d().Y();
    }

    public HashMap<String, Object> getCurrentWifiInfo() {
        return c.a(this.f28043b).d().r();
    }

    public int getDataNtType() {
        return c.a(this.f28043b).d().H();
    }

    public String getDefaultIMPkg() {
        return null;
    }

    public String getDetailNetworkTypeForStatic() {
        return c.a(this.f28043b).d().F();
    }

    public String getDeviceData() {
        return c.a(this.f28043b).d().ab();
    }

    public String getDeviceDataNotAES() {
        return c.a(this.f28043b).d().ac();
    }

    public String getDeviceId() {
        return null;
    }

    public String getDeviceKey() {
        return c.a(this.f28043b).d().Q();
    }

    public String getDeviceName() {
        return c.a(this.f28043b).d().ae();
    }

    public String getDeviceType() {
        return c.a(this.f28043b).d().o();
    }

    public String getFlavor() {
        return c.a(this.f28043b).d().J();
    }

    public ArrayList<HashMap<String, String>> getIA(boolean z11) {
        return c.a(this.f28043b).d().a(z11, false);
    }

    public String getIMEI() {
        return null;
    }

    public String getIMSI() {
        return null;
    }

    public String getIPAddress() {
        return c.a(this.f28043b).d().N();
    }

    public Location getLocation(int i11, int i12, boolean z11) {
        return c.a(this.f28043b).d().a(i11, i12, z11);
    }

    public String getMIUIVersion() {
        return c.a(this.f28043b).d().k();
    }

    public String getManufacturer() {
        return c.a(this.f28043b).d().m();
    }

    public HashMap<String, Long> getMemoryInfo() {
        return c.a(this.f28043b).d().A();
    }

    public String getModel() {
        return c.a(this.f28043b).d().l();
    }

    public ArrayList<HashMap<String, Object>> getNeighboringCellInfo() {
        return c.a(this.f28043b).d().q();
    }

    public String getNetworkType() {
        return getNetworkType(false);
    }

    public String getNetworkTypeForStatic() {
        return c.a(this.f28043b).d().E();
    }

    public String getOD() {
        return c.a(this.f28043b).d().ah();
    }

    public String getODH() {
        return c.a(this.f28043b).d().ai();
    }

    public String getOSCountry() {
        return c.a(this.f28043b).d().v();
    }

    public String getOSLanguage() {
        return c.a(this.f28043b).d().u();
    }

    public int getOSVersionInt() {
        return c.a(this.f28043b).d().s();
    }

    public String getOSVersionName() {
        return c.a(this.f28043b).d().t();
    }

    public PackageInfo getPInfo(String str, int i11) {
        return c.a(this.f28043b).d().a(false, 0, str, i11);
    }

    public String getPackageName() {
        return c.a(this.f28043b).d().T();
    }

    public int getPlatformCode() {
        return 1;
    }

    public String getQemuKernel() {
        return c.a(this.f28043b).d().y();
    }

    public ArrayList<HashMap<String, String>> getSA() {
        return c.a(this.f28043b).d().P();
    }

    public String getSSID() {
        return c.a(this.f28043b).d().a(false);
    }

    public String getScreenSize() {
        return c.a(this.f28043b).d().C();
    }

    public String getSdcardPath() {
        return c.a(this.f28043b).d().R();
    }

    public boolean getSdcardState() {
        return false;
    }

    public String getSerialno() {
        return null;
    }

    public String getSignMD5() {
        return c.a(this.f28043b).d().S();
    }

    public String getSimSerialNumber() {
        return null;
    }

    public HashMap<String, HashMap<String, Long>> getSizeInfo() {
        return c.a(this.f28043b).d().z();
    }

    public String getSystemProperties(String str) {
        return c.a(this.f28043b).d().a(str);
    }

    public Object getSystemServiceSafe(String str) {
        return v.d(str);
    }

    public ArrayList<ArrayList<String>> getTTYDriversInfo() {
        return c.a(this.f28043b).d().x();
    }

    public String getTimezone() {
        return c.a(this.f28043b).d().I();
    }

    public Activity getTopActivity() {
        return null;
    }

    public void hideSoftInput(View view) {
        v.a(view);
    }

    public <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
        return ReflectHelper.invokeInstanceMethodNoThrow(obj, str, null, objArr);
    }

    public boolean isInMainProcess() {
        return c.a(this.f28043b).d().X();
    }

    public boolean isPackageInstalled(String str) {
        return c.a(this.f28043b).d().b(str);
    }

    public boolean isRooted() {
        return c.a(this.f28043b).d().a();
    }

    public boolean isWifiProxy() {
        return c.a(this.f28043b).d().i();
    }

    public String[] queryIMEI() {
        return null;
    }

    public String[] queryIMSI() {
        return null;
    }

    public List<ResolveInfo> queryIntentServices(Intent intent, int i11) {
        return c.a(this.f28043b).d().a(intent, i11);
    }

    public ResolveInfo resolveActivity(Intent intent, int i11) {
        return c.a(this.f28043b).d().b(intent, i11);
    }

    public void showSoftInput(View view) {
        v.b(view);
    }

    public boolean usbEnable() {
        return c.a(this.f28043b).d().h();
    }

    public boolean vpn() {
        return c.a(this.f28043b).d().e();
    }

    public ApplicationInfo getAInfo(String str, int i11) {
        return c.a(this.f28043b).d().a(str, i11);
    }

    public String getAppName(String str) {
        return c.a(this.f28043b).d().d(str);
    }

    public String getCarrier(boolean z11) {
        return c.a(this.f28043b).d().c(z11);
    }

    public String getCarrierName(boolean z11) {
        return c.a(this.f28043b).d().d(z11);
    }

    public String getDeviceKey(boolean z11) {
        return c.a(this.f28043b).d().g(z11);
    }

    public String getNetworkType(boolean z11) {
        return c.a(this.f28043b).d().f(z11);
    }

    public PackageInfo getPInfo(boolean z11, String str, int i11) {
        return c.a(this.f28043b).d().a(z11, 0, str, i11);
    }

    public String getSignMD5(String str) {
        return c.a(this.f28043b).d().c(str);
    }

    public <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        return ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr, null);
    }

    public ApplicationInfo getAInfo(boolean z11, String str, int i11) {
        return c.a(this.f28043b).d().a(z11, str, i11);
    }

    public PackageInfo getPInfo(int i11, String str, int i12) {
        return c.a(this.f28043b).d().a(false, i11, str, i12);
    }
}
