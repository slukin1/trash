package com.fluttercandies.photo_manager.core;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import com.fluttercandies.photo_manager.core.utils.IDBUtils;
import com.xiaomi.mipush.sdk.Constants;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.List;
import z4.e;

public final class PhotoManagerDeleteManager implements PluginRegistry.ActivityResultListener {

    /* renamed from: b  reason: collision with root package name */
    public final Context f65015b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f65016c;

    /* renamed from: d  reason: collision with root package name */
    public int f65017d = 40069;

    /* renamed from: e  reason: collision with root package name */
    public e f65018e;

    public PhotoManagerDeleteManager(Context context, Activity activity) {
        this.f65015b = context;
        this.f65016c = activity;
    }

    public final void a(Activity activity) {
        this.f65016c = activity;
    }

    public final void b(List<String> list) {
        String k02 = CollectionsKt___CollectionsKt.k0(list, Constants.ACCEPT_TIME_SEPARATOR_SP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, PhotoManagerDeleteManager$deleteInApi28$where$1.INSTANCE, 30, (Object) null);
        ContentResolver d11 = d();
        Uri a11 = IDBUtils.f65111a.a();
        d11.delete(a11, "_id in (" + k02 + ')', (String[]) list.toArray(new String[0]));
    }

    public final void c(List<? extends Uri> list, e eVar) {
        this.f65018e = eVar;
        ContentResolver d11 = d();
        ArrayList arrayList = new ArrayList();
        for (Uri uri : list) {
            if (uri != null) {
                arrayList.add(uri);
            }
        }
        PendingIntent createTrashRequest = MediaStore.createTrashRequest(d11, arrayList, true);
        Activity activity = this.f65016c;
        if (activity != null) {
            activity.startIntentSenderForResult(createTrashRequest.getIntentSender(), this.f65017d, (Intent) null, 0, 0, 0);
        }
    }

    public final ContentResolver d() {
        return this.f65015b.getContentResolver();
    }

    public final void e(int i11) {
        MethodCall d11;
        List list;
        e eVar;
        if (i11 == -1) {
            e eVar2 = this.f65018e;
            if (eVar2 != null && (d11 = eVar2.d()) != null && (list = (List) d11.argument("ids")) != null && (eVar = this.f65018e) != null) {
                eVar.h(list);
                return;
            }
            return;
        }
        e eVar3 = this.f65018e;
        if (eVar3 != null) {
            eVar3.h(CollectionsKt__CollectionsKt.k());
        }
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        if (i11 == this.f65017d) {
            e(i12);
        }
        return true;
    }
}
