package com.zopim.android.sdk.data;

import com.zendesk.logger.Logger;

class PathUpdater {
    private static final boolean DEBUG = false;
    private static final String DELIMITER = ";";
    private static final String LOG_TAG = "PathUpdater";

    /* renamed from: com.zopim.android.sdk.data.PathUpdater$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$data$PathName;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.zopim.android.sdk.data.PathName[] r0 = com.zopim.android.sdk.data.PathName.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$data$PathName = r0
                com.zopim.android.sdk.data.PathName r1 = com.zopim.android.sdk.data.PathName.LIVECHAT_CHANNEL_LOG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$data$PathName     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.data.PathName r1 = com.zopim.android.sdk.data.PathName.LIVECHAT_PROFILE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$data$PathName     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.data.PathName r1 = com.zopim.android.sdk.data.PathName.LIVECHAT_AGENTS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$data$PathName     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zopim.android.sdk.data.PathName r1 = com.zopim.android.sdk.data.PathName.LIVECHAT_DEPARTMENTS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$data$PathName     // Catch:{ NoSuchFieldError -> 0x003e }
                com.zopim.android.sdk.data.PathName r1 = com.zopim.android.sdk.data.PathName.LIVECHAT_ACCOUNT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$data$PathName     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.zopim.android.sdk.data.PathName r1 = com.zopim.android.sdk.data.PathName.LIVECHAT_SETTINGS_FORMS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$data$PathName     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.zopim.android.sdk.data.PathName r1 = com.zopim.android.sdk.data.PathName.LIVECHAT_SETTINGS_FILE_SENDING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$data$PathName     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.zopim.android.sdk.data.PathName r1 = com.zopim.android.sdk.data.PathName.CONNECTION     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.data.PathUpdater.AnonymousClass1.<clinit>():void");
        }
    }

    private String getBody(String str) {
        if (str == null) {
            return "";
        }
        try {
            return str.substring(str.indexOf(DELIMITER) + 1);
        } catch (IndexOutOfBoundsException e11) {
            Logger.l(LOG_TAG, "Failed to parse the json message in order to retrieve message body. " + e11.getMessage(), new Object[0]);
            return "";
        }
    }

    private PathName getPath(String str) {
        if (str == null) {
            return PathName.UNKNOWN;
        }
        try {
            return PathName.get(str.substring(0, (str.indexOf(DELIMITER) + 1) - 1));
        } catch (IndexOutOfBoundsException e11) {
            Logger.l(LOG_TAG, "Failed to parse the json message in order to retrieve path name. " + e11.getMessage(), new Object[0]);
            return PathName.UNKNOWN;
        }
    }

    public PathName updatePath(String str) {
        String body = getBody(str);
        PathName path = getPath(str);
        switch (AnonymousClass1.$SwitchMap$com$zopim$android$sdk$data$PathName[path.ordinal()]) {
            case 1:
                LivechatChatLogPath.getInstance().update(body);
                break;
            case 2:
                LivechatProfilePath.getInstance().update(body);
                break;
            case 3:
                LivechatAgentsPath.getInstance().update(body);
                break;
            case 4:
                LivechatDepartmentsPath.getInstance().update(body);
                break;
            case 5:
                LivechatAccountPath.getInstance().update(body);
                break;
            case 6:
                LivechatFormsPath.getInstance().update(body);
                break;
            case 7:
                LivechatFileSendingPath.getInstance().update(body);
                break;
            case 8:
                ConnectionPath.getInstance().update(body);
                break;
        }
        return path;
    }
}
