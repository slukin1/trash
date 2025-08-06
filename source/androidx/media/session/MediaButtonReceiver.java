package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {

    public static class a extends MediaBrowserCompat.ConnectionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Context f10194a;

        /* renamed from: b  reason: collision with root package name */
        public final Intent f10195b;

        /* renamed from: c  reason: collision with root package name */
        public final BroadcastReceiver.PendingResult f10196c;

        /* renamed from: d  reason: collision with root package name */
        public MediaBrowserCompat f10197d;

        public a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f10194a = context;
            this.f10195b = intent;
            this.f10196c = pendingResult;
        }

        public final void a() {
            this.f10197d.disconnect();
            this.f10196c.finish();
        }

        public void b(MediaBrowserCompat mediaBrowserCompat) {
            this.f10197d = mediaBrowserCompat;
        }

        public void onConnected() {
            try {
                new MediaControllerCompat(this.f10194a, this.f10197d.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f10195b.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e11) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e11);
            }
            a();
        }

        public void onConnectionFailed() {
            a();
        }

        public void onConnectionSuspended() {
            a();
        }
    }

    public static ComponentName a(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        } else if (queryBroadcastReceivers.size() <= 1) {
            return null;
        } else {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        }
    }

    public static ComponentName b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }

    public static void c(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName b11 = b(context, "android.intent.action.MEDIA_BUTTON");
        if (b11 != null) {
            intent.setComponent(b11);
            c(context, intent);
            return;
        }
        ComponentName b12 = b(context, "android.media.browse.MediaBrowserService");
        if (b12 != null) {
            BroadcastReceiver.PendingResult goAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            a aVar = new a(applicationContext, intent, goAsync);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, b12, aVar, (Bundle) null);
            aVar.b(mediaBrowserCompat);
            mediaBrowserCompat.connect();
            return;
        }
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }
}
