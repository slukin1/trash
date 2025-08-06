package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

public class PersistentLoader {
    private static Context context;
    private static volatile PersistentLoader instance;

    private PersistentLoader(Context context2) {
        context = context2.getApplicationContext();
    }

    public static PersistentLoader initLoader(Context context2) {
        if (instance == null) {
            instance = new PersistentLoader(context2);
        }
        return instance;
    }

    public static PersistentIdentity<?> loadPersistent(String str) {
        if (instance == null) {
            throw new RuntimeException("you should call 'PersistentLoader.initLoader(Context)' first");
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1436067305:
                    if (str.equals(DbParams.PersistentName.LOGIN_ID)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -951089033:
                    if (str.equals(DbParams.PersistentName.SUPER_PROPERTIES)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -854148740:
                    if (str.equals(DbParams.PersistentName.FIRST_INSTALL_CALLBACK)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -690407917:
                    if (str.equals(DbParams.PersistentName.FIRST_START)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -456824111:
                    if (str.equals(DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -266152892:
                    if (str.equals(DbParams.PersistentName.PERSISTENT_USER_ID)) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -212773998:
                    if (str.equals(DbParams.PersistentName.VISUAL_PROPERTIES)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 133344653:
                    if (str.equals(DbParams.PersistentName.FIRST_DAY)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 721318680:
                    if (str.equals(DbParams.PersistentName.DISTINCT_ID)) {
                        c11 = 8;
                        break;
                    }
                    break;
                case 923005325:
                    if (str.equals(DbParams.APP_EXIT_DATA)) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 947194773:
                    if (str.equals(DbParams.PersistentName.REMOTE_CONFIG)) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 1214783133:
                    if (str.equals(DbParams.PersistentName.FIRST_INSTALL)) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 1521941740:
                    if (str.equals(DbParams.PersistentName.APP_END_DATA)) {
                        c11 = 12;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    return new PersistentLoginId();
                case 1:
                    return new PersistentSuperProperties();
                case 2:
                    return new PersistentFirstTrackInstallationWithCallback();
                case 3:
                    return new PersistentFirstStart();
                case 4:
                    return new LoginIdKeyPersistent();
                case 5:
                    return new UserIdentityPersistent();
                case 6:
                    return new PersistentVisualConfig();
                case 7:
                    return new PersistentFirstDay();
                case 8:
                    return new PersistentDistinctId(context);
                case 9:
                    return new PersistentAppExitData();
                case 10:
                    return new PersistentRemoteSDKConfig();
                case 11:
                    return new PersistentFirstTrackInstallation();
                case 12:
                    return new PersistentAppEndData();
                default:
                    return null;
            }
        }
    }
}
