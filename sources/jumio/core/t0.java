package jumio.core;

import android.content.Context;
import android.provider.Settings;
import com.jumio.core.environment.CpuInfo;
import com.jumio.core.environment.Environment;
import com.jumio.core.interfaces.DeviceUtilInterface;
import kotlin.jvm.internal.x;

public final class t0 implements DeviceUtilInterface {
    public static String a() {
        int cpuFamily = CpuInfo.getCpuFamily();
        switch (cpuFamily) {
            case 1:
                return "ARM";
            case 2:
                return "X86";
            case 3:
                return "MIPS";
            case 4:
                return "ARM64";
            case 5:
                return "X86_64";
            case 6:
                return "MIPS64";
            default:
                return "UNKNOWN (" + cpuFamily + ")";
        }
    }

    public static String b() {
        int cpuFamily = CpuInfo.getCpuFamily();
        int cpuFeatures = CpuInfo.getCpuFeatures();
        String str = "";
        if (cpuFamily == 1) {
            if ((cpuFeatures & 1) == 1) {
                str = str + "ARMv7 ";
            }
            if ((cpuFeatures & 2) == 2) {
                str = str + "VFPv3 ";
            }
            if ((cpuFeatures & 4) == 4) {
                str = str + "NEON ";
            }
            if ((cpuFeatures & 8) == 8) {
                str = str + "LDREX_STREX ";
            }
            if ((cpuFeatures & 16) == 16) {
                str = str + "VFPv2 ";
            }
            if ((cpuFeatures & 32) == 32) {
                str = str + "VFP_D32 ";
            }
            if ((cpuFeatures & 64) == 64) {
                str = str + "VFP_FP16 ";
            }
            if ((cpuFeatures & 128) == 128) {
                str = str + "VFP_FMA ";
            }
            if ((cpuFeatures & 256) == 256) {
                str = str + "NEON_FMA ";
            }
            if ((cpuFeatures & 512) == 512) {
                str = str + "IDIV_ARM ";
            }
            if ((cpuFeatures & 1024) == 1024) {
                str = str + "IDIV_THUMB2 ";
            }
            if ((cpuFeatures & 2048) == 2048) {
                str = str + "iWMMXt ";
            }
            if ((cpuFeatures & 4096) == 4096) {
                str = str + "AES ";
            }
            if ((cpuFeatures & 8192) == 8192) {
                str = str + "PMULL ";
            }
            if ((cpuFeatures & 16384) == 16384) {
                str = str + "SHA1 ";
            }
            if ((cpuFeatures & 32768) == 32768) {
                str = str + "SHA2 ";
            }
            if ((65536 & cpuFeatures) != 65536) {
                return str;
            }
            return str + "CRC32 ";
        } else if (cpuFamily == 2) {
            if ((cpuFeatures & 1) == 1) {
                str = str + "SSSE3 ";
            }
            if ((cpuFeatures & 2) == 2) {
                str = str + "POPCNT ";
            }
            if ((cpuFeatures & 4) != 4) {
                return str;
            }
            return str + "MOVBE ";
        } else if (cpuFamily != 4) {
            return str;
        } else {
            if ((cpuFeatures & 1) == 1) {
                str = str + "FP ";
            }
            if ((cpuFeatures & 2) == 2) {
                str = str + "ASIMD ";
            }
            if ((cpuFeatures & 4) == 4) {
                str = str + "AES ";
            }
            if ((cpuFeatures & 8) == 8) {
                str = str + "PMULL ";
            }
            if ((cpuFeatures & 16) == 16) {
                str = str + "SHA1 ";
            }
            if ((cpuFeatures & 32) == 32) {
                str = str + "SHA2 ";
            }
            if ((cpuFeatures & 64) != 64) {
                return str;
            }
            return str + "CRC32 ";
        }
    }

    public final boolean areAnimationsEnabled(Context context) {
        if (context != null) {
            try {
                if (!(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f)) {
                    if (!(Settings.Global.getFloat(context.getContentResolver(), "transition_animation_scale", 1.0f) == 0.0f)) {
                        if (!(Settings.Global.getFloat(context.getContentResolver(), "window_animation_scale", 1.0f) == 0.0f)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }

    public final boolean isDarkModeActive(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r2 = r2.getApplicationInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isDebug(android.content.Context r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x000c
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()
            if (r2 == 0) goto L_0x000c
            int r2 = r2.flags
            goto L_0x000d
        L_0x000c:
            r2 = r0
        L_0x000d:
            r2 = r2 & 2
            if (r2 == 0) goto L_0x0012
            r0 = 1
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.t0.isDebug(android.content.Context):boolean");
    }

    public final boolean isSupportedPlatform(Context context, boolean z11) {
        if (!Environment.INSTANCE.loadCpuInfoLib(context)) {
            return false;
        }
        boolean z12 = x.b(a(), "ARM") && StringsKt__StringsKt.R(b(), "ARMv7", false, 2, (Object) null) && StringsKt__StringsKt.R(b(), "NEON", false, 2, (Object) null);
        boolean b11 = x.b(a(), "ARM64");
        boolean z13 = x.b(a(), "X86") && z11;
        boolean z14 = x.b(a(), "X86_64") && z11;
        if (z12 || b11 || z13 || z14) {
            return true;
        }
        return false;
    }
}
