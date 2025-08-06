package com.tencent.qcloud.tuikit.tuicallengine.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.engagelab.privates.push.constants.MTPushConstants;

public class BrandUtils {
    private static final String TAG = "BrandUtils";
    private static String mBrand = "";
    private static String mManufacturer = "";
    private static String mModel = "";
    private static String mOsVersion = "";

    private static void getBrand() {
        if (TextUtils.isEmpty(mBrand)) {
            synchronized (BrandUtils.class) {
                if (TextUtils.isEmpty(mBrand)) {
                    mBrand = Build.BRAND;
                    Log.i(TAG, "get BRAND by Build.BRAND :" + mBrand);
                }
            }
        }
    }

    private static void getManufacturer() {
        if (TextUtils.isEmpty(mManufacturer)) {
            synchronized (BrandUtils.class) {
                if (TextUtils.isEmpty(mManufacturer)) {
                    mManufacturer = Build.MANUFACTURER;
                    Log.i(TAG, "get MANUFACTURER by Build.MANUFACTURER :" + mManufacturer);
                }
            }
        }
    }

    public static String getModel() {
        if (TextUtils.isEmpty(mModel)) {
            synchronized (BrandUtils.class) {
                if (TextUtils.isEmpty(mModel)) {
                    mModel = Build.MODEL;
                    Log.i(TAG, "get MODEL by Build.MODEL :" + mModel);
                }
            }
        }
        return mModel;
    }

    public static String getOsVersion() {
        if (TextUtils.isEmpty(mOsVersion)) {
            synchronized (BrandUtils.class) {
                if (TextUtils.isEmpty(mOsVersion)) {
                    mOsVersion = String.valueOf(Build.VERSION.SDK_INT);
                    Log.i(TAG, "get OS version by Build.VERSION :" + mOsVersion);
                }
            }
        }
        return mOsVersion;
    }

    private static void init() {
        getBrand();
        getManufacturer();
        getModel();
        getOsVersion();
    }

    public static boolean isBrandHuawei() {
        init();
        return MTPushConstants.Manufacturer.HUAWEI.equalsIgnoreCase(mBrand) || MTPushConstants.Manufacturer.HUAWEI.equalsIgnoreCase(mManufacturer);
    }

    public static boolean isBrandMeizu() {
        init();
        return MTPushConstants.Manufacturer.MEIZU.equalsIgnoreCase(mBrand) || MTPushConstants.Manufacturer.MEIZU.equalsIgnoreCase(mManufacturer) || "22c4185e".equalsIgnoreCase(mBrand);
    }

    public static boolean isBrandOppo() {
        init();
        return MTPushConstants.Manufacturer.OPPO.equalsIgnoreCase(mBrand) || MTPushConstants.Manufacturer.REALME.equalsIgnoreCase(mBrand) || MTPushConstants.Manufacturer.ONEPLUS.equalsIgnoreCase(mBrand) || MTPushConstants.Manufacturer.OPPO.equalsIgnoreCase(mManufacturer) || MTPushConstants.Manufacturer.REALME.equalsIgnoreCase(mManufacturer) || MTPushConstants.Manufacturer.ONEPLUS.equalsIgnoreCase(mManufacturer);
    }

    public static boolean isBrandVivo() {
        init();
        return "vivo".equalsIgnoreCase(mBrand) || "vivo".equalsIgnoreCase(mManufacturer);
    }

    public static boolean isBrandXiaoMi() {
        init();
        return "xiaomi".equalsIgnoreCase(mBrand) || "xiaomi".equalsIgnoreCase(mManufacturer);
    }
}
