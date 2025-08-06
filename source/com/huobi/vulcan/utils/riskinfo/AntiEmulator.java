package com.huobi.vulcan.utils.riskinfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.jumio.commons.log.LogUtils;
import com.sumsub.sentry.android.c;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import java.io.File;

public class AntiEmulator {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f20622a = {"/data/youwave_id", "/dev/vboxguest", "/dev/vboxuser", "/mnt/prebundledapps/bluestacks.prop.orig", "/mnt/prebundledapps/propfiles/ics.bluestacks.prop.note", "/mnt/prebundledapps/propfiles/ics.bluestacks.prop.s2", "/mnt/prebundledapps/propfiles/ics.bluestacks.prop.s3", "/mnt/sdcard/bstfolder/InputMapper/com.bluestacks.appmart.cfg", "/mnt/sdcard/buildroid-gapps-ics-20120317-signed.tgz", "/mnt/sdcard/windows/InputMapper/com.bluestacks.appmart.cfg", "/proc/irq/9/vboxguest", "/sys/bus/pci/drivers/vboxguest", "/sys/bus/pci/drivers/vboxguest/0000:00:04.0", "/sys/bus/pci/drivers/vboxguest/bind", "/sys/bus/pci/drivers/vboxguest/module", "/sys/bus/pci/drivers/vboxguest/new_id", "/sys/bus/pci/drivers/vboxguest/remove_id", "/sys/bus/pci/drivers/vboxguest/uevent", "/sys/bus/pci/drivers/vboxguest/unbind", "/sys/bus/platform/drivers/qemu_pipe", "/sys/bus/platform/drivers/qemu_trace", "/sys/class/bdi/vboxsf-c", "/sys/class/misc/vboxguest", "/sys/class/misc/vboxuser", "/sys/devices/virtual/bdi/vboxsf-c", "/sys/devices/virtual/misc/vboxguest", "/sys/devices/virtual/misc/vboxguest/dev", "/sys/devices/virtual/misc/vboxguest/power", "/sys/devices/virtual/misc/vboxguest/subsystem", "/sys/devices/virtual/misc/vboxguest/uevent", "/sys/devices/virtual/misc/vboxuser", "/sys/devices/virtual/misc/vboxuser/dev", "/sys/devices/virtual/misc/vboxuser/power", "/sys/devices/virtual/misc/vboxuser/subsystem", "/sys/devices/virtual/misc/vboxuser/uevent", "/sys/module/vboxguest", "/sys/module/vboxguest/coresize", "/sys/module/vboxguest/drivers", "/sys/module/vboxguest/drivers/pci:vboxguest", "/sys/module/vboxguest/holders", "/sys/module/vboxguest/holders/vboxsf", "/sys/module/vboxguest/initsize", "/sys/module/vboxguest/initstate", "/sys/module/vboxguest/notes", "/sys/module/vboxguest/notes/.note.gnu.build-id", "/sys/module/vboxguest/parameters", "/sys/module/vboxguest/parameters/log", "/sys/module/vboxguest/parameters/log_dest", "/sys/module/vboxguest/parameters/log_flags", "/sys/module/vboxguest/refcnt", "/sys/module/vboxguest/sections", "/sys/module/vboxguest/sections/.altinstructions", "/sys/module/vboxguest/sections/.altinstr_replacement", "/sys/module/vboxguest/sections/.bss", "/sys/module/vboxguest/sections/.data", "/sys/module/vboxguest/sections/.devinit.data", "/sys/module/vboxguest/sections/.exit.text", "/sys/module/vboxguest/sections/.fixup", "/sys/module/vboxguest/sections/.gnu.linkonce.this_module", "/sys/module/vboxguest/sections/.init.text", "/sys/module/vboxguest/sections/.note.gnu.build-id", "/sys/module/vboxguest/sections/.rodata", "/sys/module/vboxguest/sections/.rodata.str1.1", "/sys/module/vboxguest/sections/.smp_locks", "/sys/module/vboxguest/sections/.strtab", "/sys/module/vboxguest/sections/.symtab", "/sys/module/vboxguest/sections/.text", "/sys/module/vboxguest/sections/__ex_table", "/sys/module/vboxguest/sections/__ksymtab", "/sys/module/vboxguest/sections/__ksymtab_strings", "/sys/module/vboxguest/sections/__param", "/sys/module/vboxguest/srcversion", "/sys/module/vboxguest/taint", "/sys/module/vboxguest/uevent", "/sys/module/vboxguest/version", "/sys/module/vboxsf", "/sys/module/vboxsf/coresize", "/sys/module/vboxsf/holders", "/sys/module/vboxsf/initsize", "/sys/module/vboxsf/initstate", "/sys/module/vboxsf/notes", "/sys/module/vboxsf/notes/.note.gnu.build-id", "/sys/module/vboxsf/refcnt", "/sys/module/vboxsf/sections", "/sys/module/vboxsf/sections/.bss", "/sys/module/vboxsf/sections/.data", "/sys/module/vboxsf/sections/.exit.text", "/sys/module/vboxsf/sections/.gnu.linkonce.this_module", "/sys/module/vboxsf/sections/.init.text", "/sys/module/vboxsf/sections/.note.gnu.build-id", "/sys/module/vboxsf/sections/.rodata", "/sys/module/vboxsf/sections/.rodata.str1.1", "/sys/module/vboxsf/sections/.smp_locks", "/sys/module/vboxsf/sections/.strtab", "/sys/module/vboxsf/sections/.symtab", "/sys/module/vboxsf/sections/.text", "/sys/module/vboxsf/sections/__bug_table", "/sys/module/vboxsf/sections/__param", "/sys/module/vboxsf/srcversion", "/sys/module/vboxsf/taint", "/sys/module/vboxsf/uevent", "/sys/module/vboxsf/version", "/sys/module/vboxvideo", "/sys/module/vboxvideo/coresize", "/sys/module/vboxvideo/holders", "/sys/module/vboxvideo/initsize", "/sys/module/vboxvideo/initstate", "/sys/module/vboxvideo/notes", "/sys/module/vboxvideo/notes/.note.gnu.build-id", "/sys/module/vboxvideo/refcnt", "/sys/module/vboxvideo/sections", "/sys/module/vboxvideo/sections/.data", "/sys/module/vboxvideo/sections/.exit.text", "/sys/module/vboxvideo/sections/.gnu.linkonce.this_module", "/sys/module/vboxvideo/sections/.init.text", "/sys/module/vboxvideo/sections/.note.gnu.build-id", "/sys/module/vboxvideo/sections/.rodata.str1.1", "/sys/module/vboxvideo/sections/.strtab", "/sys/module/vboxvideo/sections/.symtab", "/sys/module/vboxvideo/sections/.text", "/sys/module/vboxvideo/srcversion", "/sys/module/vboxvideo/taint", "/sys/module/vboxvideo/uevent", "/sys/module/vboxvideo/version", "/system/app/bluestacksHome.apk", "/system/bin/androVM-prop", "/system/bin/androVM-vbox-sf", "/system/bin/androVM_setprop", "/system/bin/get_androVM_host", "/system/bin/mount.vboxsf", "/system/etc/init.androVM.sh", "/system/etc/init.buildroid.sh", "/system/lib/hw/audio.primary.vbox86.so", "/system/lib/hw/camera.vbox86.so", "/system/lib/hw/gps.vbox86.so", "/system/lib/hw/gralloc.vbox86.so", "/system/lib/hw/sensors.vbox86.so", "/system/lib/modules/3.0.8-android-x86+/extra/vboxguest", "/system/lib/modules/3.0.8-android-x86+/extra/vboxguest/vboxguest.ko", "/system/lib/modules/3.0.8-android-x86+/extra/vboxsf", "/system/lib/modules/3.0.8-android-x86+/extra/vboxsf/vboxsf.ko", "/system/lib/vboxguest.ko", "/system/lib/vboxsf.ko", "/system/lib/vboxvideo.ko", "/system/usr/idc/androVM_Virtual_Input.idc", "/system/usr/keylayout/androVM_Virtual_Input.kl", "/system/xbin/mount.vboxsf", "/ueventd.android_x86.rc", "/ueventd.vbox86.rc", "/ueventd.goldfish.rc", "/fstab.vbox86", "/init.vbox86.rc", "/init.goldfish.rc", "/sys/module/goldfish_audio", "/sys/module/goldfish_sync", "/data/app/com.bluestacks.appmart-1.apk", "/data/app/com.bluestacks.BstCommandProcessor-1.apk", "/data/app/com.bluestacks.help-1.apk", "/data/app/com.bluestacks.home-1.apk", "/data/app/com.bluestacks.s2p-1.apk", "/data/app/com.bluestacks.searchapp-1.apk", "/data/bluestacks.prop", "/data/data/com.androVM.vmconfig", "/data/data/com.bluestacks.accelerometerui", "/data/data/com.bluestacks.appfinder", "/data/data/com.bluestacks.appmart", "/data/data/com.bluestacks.appsettings", "/data/data/com.bluestacks.BstCommandProcessor", "/data/data/com.bluestacks.bstfolder", "/data/data/com.bluestacks.help", "/data/data/com.bluestacks.home", "/data/data/com.bluestacks.s2p", "/data/data/com.bluestacks.searchapp", "/data/data/com.bluestacks.settings", "/data/data/com.bluestacks.setup", "/data/data/com.bluestacks.spotlight", "/data/data/com.microvirt.download", "/data/data/com.microvirt.guide", "/data/data/com.microvirt.installer", "/data/data/com.microvirt.launcher", "/data/data/com.microvirt.market", "/data/data/com.microvirt.memuime", "/data/data/com.microvirt.tools", "/data/data/com.mumu.launcher", "/data/data/com.mumu.store", "/data/data/com.netease.mumu.cloner"};

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f20623a;

        /* renamed from: b  reason: collision with root package name */
        public String f20624b;

        public a(int i11, String str) {
            this.f20623a = i11;
            this.f20624b = str;
        }
    }

    public static a a() {
        String b11 = DeviceInfoUtils.b("gsm.version.baseband");
        if (TextUtils.isEmpty(b11)) {
            return new a(0, (String) null);
        }
        return new a(b11.contains("1.0.0.0") ? 1 : 2, b11);
    }

    public static a b() {
        String c11 = DeviceInfoUtils.c(TPSystemInfo.KEY_PROPERTY_BOARD, Build.BOARD);
        if (TextUtils.isEmpty(c11)) {
            return new a(0, (String) null);
        }
        String lowerCase = c11.toLowerCase();
        int i11 = 1;
        if (!lowerCase.contains("android") && !lowerCase.contains("goldfish")) {
            i11 = 2;
        }
        return new a(i11, c11);
    }

    public static a c() {
        if (new File("/proc/self/cgroup").exists()) {
            return new a(2, "/proc/self/cgroup exists");
        }
        return new a(0, (String) null);
    }

    public static a d() {
        String b11 = DeviceInfoUtils.b("ro.build.flavor");
        if (TextUtils.isEmpty(b11)) {
            return new a(0, (String) null);
        }
        String lowerCase = b11.toLowerCase();
        int i11 = 1;
        if (!lowerCase.contains("vbox") && !lowerCase.contains("sdk_gphone")) {
            i11 = 2;
        }
        return new a(i11, b11);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        if (r1.equals("cancro") == false) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huobi.vulcan.utils.riskinfo.AntiEmulator.a e() {
        /*
            java.lang.String r0 = android.os.Build.HARDWARE
            java.lang.String r1 = "ro.hardware"
            java.lang.String r0 = com.huobi.vulcan.utils.riskinfo.DeviceInfoUtils.c(r1, r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0016
            com.huobi.vulcan.utils.riskinfo.AntiEmulator$a r0 = new com.huobi.vulcan.utils.riskinfo.AntiEmulator$a
            r1 = 0
            r0.<init>(r2, r1)
            return r0
        L_0x0016:
            java.lang.String r1 = r0.toLowerCase()
            r1.hashCode()
            r3 = -1
            int r4 = r1.hashCode()
            r5 = 2
            r6 = 1
            switch(r4) {
                case -1367724016: goto L_0x006b;
                case -822798509: goto L_0x0060;
                case 109271: goto L_0x0055;
                case 3570999: goto L_0x004a;
                case 3613077: goto L_0x003f;
                case 100361430: goto L_0x0034;
                case 937844646: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            r2 = r3
            goto L_0x0074
        L_0x0029:
            java.lang.String r2 = "android_x86"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0032
            goto L_0x0027
        L_0x0032:
            r2 = 6
            goto L_0x0074
        L_0x0034:
            java.lang.String r2 = "intel"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003d
            goto L_0x0027
        L_0x003d:
            r2 = 5
            goto L_0x0074
        L_0x003f:
            java.lang.String r2 = "vbox"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0048
            goto L_0x0027
        L_0x0048:
            r2 = 4
            goto L_0x0074
        L_0x004a:
            java.lang.String r2 = "ttvm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0053
            goto L_0x0027
        L_0x0053:
            r2 = 3
            goto L_0x0074
        L_0x0055:
            java.lang.String r2 = "nox"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x005e
            goto L_0x0027
        L_0x005e:
            r2 = r5
            goto L_0x0074
        L_0x0060:
            java.lang.String r2 = "vbox86"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0069
            goto L_0x0027
        L_0x0069:
            r2 = r6
            goto L_0x0074
        L_0x006b:
            java.lang.String r4 = "cancro"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0074
            goto L_0x0027
        L_0x0074:
            switch(r2) {
                case 0: goto L_0x0078;
                case 1: goto L_0x0078;
                case 2: goto L_0x0078;
                case 3: goto L_0x0078;
                case 4: goto L_0x0078;
                case 5: goto L_0x0078;
                case 6: goto L_0x0078;
                default: goto L_0x0077;
            }
        L_0x0077:
            goto L_0x0079
        L_0x0078:
            r5 = r6
        L_0x0079:
            com.huobi.vulcan.utils.riskinfo.AntiEmulator$a r1 = new com.huobi.vulcan.utils.riskinfo.AntiEmulator$a
            r1.<init>(r5, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.riskinfo.AntiEmulator.e():com.huobi.vulcan.utils.riskinfo.AntiEmulator$a");
    }

    public static a f() {
        String c11 = DeviceInfoUtils.c(TPSystemInfo.KEY_PROPERTY_MANUFACTURER, Build.MANUFACTURER);
        if (TextUtils.isEmpty(c11)) {
            return new a(0, (String) null);
        }
        String lowerCase = c11.toLowerCase();
        int i11 = 1;
        if (!lowerCase.contains("genymotion") && !lowerCase.contains("netease")) {
            i11 = 2;
        }
        return new a(i11, c11);
    }

    public static a g() {
        String c11 = DeviceInfoUtils.c(TPSystemInfo.KEY_PROPERTY_MODEL, Build.MODEL);
        if (TextUtils.isEmpty(c11)) {
            return new a(0, (String) null);
        }
        String lowerCase = c11.toLowerCase();
        int i11 = 1;
        if (!lowerCase.contains("google_sdk") && !lowerCase.contains(c.f30264k) && !lowerCase.contains("android sdk built for x86")) {
            i11 = 2;
        }
        return new a(i11, c11);
    }

    public static a h() {
        String b11 = DeviceInfoUtils.b("ro.board.platform");
        if (TextUtils.isEmpty(b11)) {
            return new a(0, (String) null);
        }
        return new a(b11.toLowerCase().contains("android") ? 1 : 2, b11);
    }

    public static int i(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getSensorList(-1).size();
    }

    public static int j(Context context) {
        int i11 = 0;
        try {
            for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(128)) {
                int i12 = applicationInfo.flags;
                if ((i12 & 1) == 0 && (i12 & 128) == 0) {
                    i11++;
                }
            }
        } catch (Throwable unused) {
        }
        return i11;
    }

    public static a k() {
        int i11;
        String str;
        String[] strArr = f20622a;
        int length = strArr.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                i11 = 2;
                str = "";
                break;
            }
            str = strArr[i12];
            if (new File(str).exists()) {
                i11 = 1;
                break;
            }
            i12++;
        }
        return new a(i11, str);
    }

    public static boolean l(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) != null;
    }

    public static boolean m(Context context) {
        return n(context, 5);
    }

    public static boolean n(Context context, int i11) {
        int i12;
        String str;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str2;
        int i13;
        a k11 = k();
        int i14 = k11.f20623a;
        if (i14 == 0) {
            i12 = 1;
        } else if (i14 != 1) {
            i12 = 0;
        } else {
            Log.d("AntiEmulator", "emulatorFile = " + k11.f20624b);
            return true;
        }
        a e11 = e();
        int i15 = e11.f20623a;
        if (i15 == 0) {
            i12++;
        } else if (i15 == 1) {
            Log.d("AntiEmulator", "hardware = " + e11.f20624b);
            return true;
        }
        a d11 = d();
        int i16 = d11.f20623a;
        if (i16 == 0) {
            i12++;
        } else if (i16 == 1) {
            Log.d("AntiEmulator", "flavor = " + d11.f20624b);
            return true;
        }
        a g11 = g();
        int i17 = g11.f20623a;
        if (i17 == 0) {
            i12++;
        } else if (i17 == 1) {
            Log.d("AntiEmulator", "model = " + g11.f20624b);
            return true;
        }
        a f11 = f();
        int i18 = f11.f20623a;
        if (i18 == 0) {
            i12++;
        } else if (i18 == 1) {
            Log.d("AntiEmulator", "manufacturer = " + f11.f20624b);
            return true;
        }
        a b11 = b();
        int i19 = b11.f20623a;
        if (i19 == 0) {
            i12++;
        } else if (i19 == 1) {
            Log.d("AntiEmulator", "board = " + b11.f20624b);
            return true;
        }
        a h11 = h();
        int i21 = h11.f20623a;
        if (i21 == 0) {
            i12++;
        } else if (i21 == 1) {
            Log.d("AntiEmulator", "platform = " + h11.f20624b);
            return true;
        }
        a a11 = a();
        int i22 = a11.f20623a;
        a aVar = h11;
        if (i22 != 0) {
            str = "platform = ";
            if (i22 == 1) {
                Log.d("AntiEmulator", "baseBand = " + a11.f20624b);
                return true;
            }
        } else {
            str = "platform = ";
            i12 += 2;
        }
        int i23 = -1;
        if (context != null) {
            int i24 = i(context);
            if (i24 <= 7) {
                i12++;
            }
            i13 = j(context);
            int i25 = i24;
            if (i13 <= 5) {
                i12++;
            }
            boolean q11 = q(context);
            if (!q11) {
                i12++;
            }
            boolean p11 = p(context);
            if (!p11) {
                i12++;
            }
            boolean o11 = o(context);
            if (!o11) {
                i12++;
            }
            boolean l11 = l(context);
            if (!l11) {
                i12++;
            }
            z12 = o11;
            z11 = l11;
            z13 = p11;
            z14 = q11;
            i23 = i25;
            str2 = "AntiEmulator";
        } else {
            str2 = "AntiEmulator";
            i13 = -1;
            z14 = false;
            z13 = false;
            z12 = false;
            z11 = false;
        }
        a c11 = c();
        int i26 = i13;
        if (c11.f20623a == 0) {
            i12++;
        }
        StringBuffer stringBuffer = new StringBuffer("Test start");
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("hardware = ");
        stringBuffer.append(e11.f20624b);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("flavor = ");
        stringBuffer.append(d11.f20624b);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("model = ");
        stringBuffer.append(g11.f20624b);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("manufacturer = ");
        stringBuffer.append(f11.f20624b);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("board = ");
        stringBuffer.append(b11.f20624b);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append(str);
        stringBuffer.append(aVar.f20624b);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("baseBand = ");
        stringBuffer.append(a11.f20624b);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("sensorNumber = ");
        stringBuffer.append(i23);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("userAppNumber = ");
        stringBuffer.append(i26);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("supportCamera = ");
        stringBuffer.append(z13);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("supportCameraFlash = ");
        stringBuffer.append(z14);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("supportBluetooth = ");
        stringBuffer.append(z12);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("hasLightSensor = ");
        stringBuffer.append(z11);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("cgroupResult = ");
        stringBuffer.append(c11.f20624b);
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append("suspectCount = ");
        int i27 = i12;
        stringBuffer.append(i27);
        Log.d(str2, stringBuffer.toString());
        return i27 > i11;
    }

    public static boolean o(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    public static boolean p(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public static boolean q(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }
}
