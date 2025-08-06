package com.huobi.framework.im.common.utils;

import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.huobi.framework.im.common.ImManager;
import com.tencent.qcloud.tuicore.util.TUIBuild;

public final class BrandUtil {
    public static final BrandUtil INSTANCE = new BrandUtil();

    private BrandUtil() {
    }

    public final String getBuildBrand() {
        return TUIBuild.getBrand();
    }

    public final String getBuildManufacturer() {
        return TUIBuild.getManufacturer();
    }

    public final String getBuildModel() {
        return TUIBuild.getModel();
    }

    public final String getBuildVersionRelease() {
        return TUIBuild.getVersion();
    }

    public final int getBuildVersionSDKInt() {
        return TUIBuild.getVersionInt();
    }

    public final boolean isBrandHuawei() {
        if (StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.HUAWEI, getBuildBrand(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.HUAWEI, getBuildManufacturer(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.HONOR, getBuildBrand(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.HONOR, getBuildManufacturer(), true)) {
            return true;
        }
        return false;
    }

    public final boolean isBrandMeizu() {
        if (StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.MEIZU, getBuildBrand(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.MEIZU, getBuildManufacturer(), true) || StringsKt__StringsJVMKt.w("22c4185e", getBuildBrand(), true)) {
            return true;
        }
        return false;
    }

    public final boolean isBrandOppo() {
        if (StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.OPPO, getBuildBrand(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.REALME, getBuildBrand(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.ONEPLUS, getBuildBrand(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.OPPO, getBuildManufacturer(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.REALME, getBuildManufacturer(), true) || StringsKt__StringsJVMKt.w(MTPushConstants.Manufacturer.ONEPLUS, getBuildManufacturer(), true)) {
            return true;
        }
        return false;
    }

    public final boolean isBrandVivo() {
        if (StringsKt__StringsJVMKt.w("vivo", getBuildBrand(), true) || StringsKt__StringsJVMKt.w("vivo", getBuildManufacturer(), true)) {
            return true;
        }
        return false;
    }

    public final boolean isBrandXiaoMi() {
        if (StringsKt__StringsJVMKt.w("xiaomi", getBuildBrand(), true) || StringsKt__StringsJVMKt.w("xiaomi", getBuildManufacturer(), true)) {
            return true;
        }
        return false;
    }

    public final boolean isGoogleServiceSupport() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ImManager.INSTANCE.getAppContext()) == 0;
    }
}
