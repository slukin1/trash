package com.hbg.module.libkt.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.hbg.lib.common.BaseApplication;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f24907a = new l();

    /* renamed from: b  reason: collision with root package name */
    public static final ReviewManager f24908b = ReviewManagerFactory.create(BaseApplication.b());

    public static final void c(Activity activity) {
        f24908b.requestReviewFlow().addOnCompleteListener(new j(activity));
    }

    public static final void d(Activity activity, Task task) {
        String str;
        Log.d("引导评分", "应用内 request 完成 : " + task);
        if (task.isSuccessful()) {
            Log.d("引导评分", "应用内 Task 成功");
            ReviewInfo reviewInfo = (ReviewInfo) task.getResult();
            if (reviewInfo != null) {
                f24908b.launchReviewFlow(activity, reviewInfo).addOnCompleteListener(k.f24906a);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("应用内 Task 失败 : ");
        Exception exception = task.getException();
        if (exception == null || (str = exception.getMessage()) == null) {
            str = "--";
        }
        sb2.append(str);
        Log.d("引导评分", sb2.toString());
    }

    public static final void e(Task task) {
        String str;
        if (task.isSuccessful()) {
            Log.d("引导评分", "应用内 Task 完成");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("应用内 Task 失败 : ");
        Exception exception = task.getException();
        if (exception == null || (str = exception.toString()) == null) {
            str = "--";
        }
        sb2.append(str);
        Log.d("引导评分", sb2.toString());
    }

    public static final void f(Activity activity) {
        String packageName = activity.getPackageName();
        Log.d("引导评分", "跳转商店 包名 = " + packageName);
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
            intent.setPackage("com.android.vending");
            intent.addFlags(268435456);
            activity.startActivity(intent);
            Log.d("引导评分", "跳转商店 打开Google Play Store 成功");
        } catch (Exception e11) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            intent2.setPackage("com.android.vending");
            intent2.addFlags(268435456);
            activity.startActivity(intent2);
            Log.d("引导评分", "跳转商店 打开Google Play Store 失败 : " + e11.getMessage());
        }
    }
}
