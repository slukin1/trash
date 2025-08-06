package cn.sharesdk.loopshare;

import android.app.Activity;
import android.content.Intent;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.loopshare.utils.MobLinkImpl;
import com.mob.tools.proguard.ProtectedMemberKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;

public class MobLink implements ProtectedMemberKeeper, PublicMemberKeeper {
    public static final boolean DEBUGGABLE = false;

    /* renamed from: a  reason: collision with root package name */
    private static MobLinkImpl f13673a;

    static {
        a();
    }

    private static synchronized void a() {
        synchronized (MobLink.class) {
            if (f13673a == null) {
                f13673a = new MobLinkImpl();
            }
        }
    }

    public static void getMobID(Scene scene, ActionListener<String> actionListener) {
        a();
        f13673a.a(scene, actionListener);
    }

    public static String getSdkTag() {
        return "MOBLINK";
    }

    public static int getSdkVersion() {
        String[] split = ShareSDK.SDK_VERSION_NAME.split("\\.");
        int i11 = 0;
        for (String parseInt : split) {
            i11 = (i11 * 100) + Integer.parseInt(parseInt);
        }
        return i11;
    }

    public static void registerSpecifiedSchemeListener(String str, RestoreSceneListener restoreSceneListener) {
        a();
        f13673a.a(str, restoreSceneListener);
    }

    public static void setActivityDelegate(Activity activity, SceneRestorable sceneRestorable) {
        a();
        f13673a.a(activity, sceneRestorable);
    }

    public static void setRestoreSceneListener(RestoreSceneListener restoreSceneListener) {
        a();
        f13673a.a(restoreSceneListener);
    }

    public static void skipRestoreSceneFromWx(Class<? extends Activity>... clsArr) {
        a();
        f13673a.a(clsArr);
    }

    public static void updateNewIntent(Intent intent, Activity activity) {
        a();
        f13673a.a(intent, activity);
    }
}
