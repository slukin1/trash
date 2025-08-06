package com.tencent.qcloud.tuikit.tuicallkit.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.tuicallkit.TUICallKitImpl;

public final class ServiceInitializer extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public void init(final Context context) {
        TUICallingService sharedInstance = TUICallingService.sharedInstance();
        sharedInstance.init(context);
        TUICore.registerService("TUICallingService", sharedInstance);
        TUICore.registerExtension(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_AUDIO_CALL, sharedInstance);
        TUICore.registerExtension(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_VIDEO_CALL, sharedInstance);
        TUICore.registerService("TUIAudioMessageRecordService", new TUIAudioMessageRecordService(context));
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                private int foregroundActivities = 0;
                private boolean isChangingConfiguration;

                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public void onActivityDestroyed(Activity activity) {
                }

                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                    int i11 = this.foregroundActivities + 1;
                    this.foregroundActivities = i11;
                    if (i11 == 1 && !this.isChangingConfiguration && TUILogin.isUserLogined()) {
                        TUICallKitImpl.createInstance(context).queryOfflineCall();
                    }
                    this.isChangingConfiguration = false;
                }

                public void onActivityStopped(Activity activity) {
                    this.foregroundActivities--;
                    this.isChangingConfiguration = activity.isChangingConfigurations();
                }
            });
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        init(getContext().getApplicationContext());
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
