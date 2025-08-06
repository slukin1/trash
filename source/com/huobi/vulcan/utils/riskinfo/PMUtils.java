package com.huobi.vulcan.utils.riskinfo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PMUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f20635a = {"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su", "com.topjohnwu.magisk", "com.kingroot.kinguser", "com.kingo.root", "com.smedialink.oneclickroot", "com.zhiqupk.root.global", "com.alephzain.framaroot"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f20636b = {"me.weishu.exp", "io.va.exposed", "de.robv.android.xposed.installer", "com.saurik.substrate", "org.meowcat.edxposed.manager", "com.soft.controllers", "com.soft.apk008v", "com.soft.apk008Tool", "com.doubee.ig", "com.cyjh.mobileanjian", "com.ruokuai.rktech", "com.touchsprite.android", "com.stardust.scriptdroid", "com.mobileuncle.toolhero", "com.huluxia.gametools", "com.gmail.heagoo.apkeditor.pro", "com.sollyu.xposed.hook.model.dev", "com.txy.anywhere", "pro.burgerz.wsm.manager", "com.virtualdroid.loc", "com.virtualdroid.txl", "com.virtualdroid.wzs", "com.virtualdroid.kit", "com.virtualdroid.wxg", "com.virtualdroid.gps", "top.a1024bytes.mockloc.ca.pro", "com.deruhai.guangzi.noroot2", "com.mcmonjmb.yggb", "xiake.xserver", "com.dracrays.fakeloc", "net.anylocation.ultra", "com.wifi99.android.locationcheater", "com.dingweizshou", "top.a1024bytes.mockloc.ca.pro", "com.txy.anywhere.clone", "com.dracrays.fakelocc", "com.tandy.android.mockwxlocation", "net.anylocation", "com.sigma_rt.totalcontrol", "com.chuangdian.ipjl2"};

    public static List<String> a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (!(context == null || list == null || list.isEmpty())) {
            PackageManager packageManager = context.getPackageManager();
            for (String next : list) {
                try {
                    packageManager.getPackageInfo(next, 0);
                    Log.e("PMUtils", next + " app Installed!");
                    arrayList.add(next);
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public static boolean b(Context context, List<String> list) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        for (String next : list) {
            try {
                packageManager.getPackageInfo(next, 0);
                Log.e("PMUtils", next + " app Installed!");
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String c(Context context, List<String> list) {
        List asList = Arrays.asList(f20635a);
        List asList2 = Arrays.asList(f20636b);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(asList2);
        arrayList.addAll(asList);
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        return Utils.b(a(context, arrayList), Constants.ACCEPT_TIME_SEPARATOR_SP);
    }
}
