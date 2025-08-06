package com.tencent.qcloud.tuikit.tuichat.util;

public class PermissionHelper {
    public static final int PERMISSION_CAMERA = 2;
    public static final int PERMISSION_MICROPHONE = 1;
    public static final int PERMISSION_STORAGE = 3;

    public interface PermissionCallback {
        void onDenied();

        void onGranted();
    }

    public @interface PermissionType {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void requestPermission(@com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionType int r7, final com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback r8) {
        /*
            android.content.Context r0 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            android.content.Context r1 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
            android.content.res.Resources r1 = r1.getResources()
            int r0 = r0.labelRes
            java.lang.String r0 = r1.getString(r0)
            r2 = 0
            r3 = 1
            r4 = 0
            if (r7 == r3) goto L_0x0063
            r5 = 2
            if (r7 == r5) goto L_0x0044
            r5 = 3
            if (r7 == r5) goto L_0x0025
            r7 = r2
            r0 = r7
            r1 = r0
            goto L_0x0085
        L_0x0025:
            int r7 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_storage_reason_title
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r0
            java.lang.String r2 = r1.getString(r7, r2)
            int r7 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_storage_reason
            java.lang.String r7 = r1.getString(r7)
            int r5 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_storage_dialog_alert
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r0
            java.lang.String r0 = r1.getString(r5, r3)
            int r4 = com.tencent.qcloud.tuikit.tuichat.R.drawable.chat_permission_icon_file
            java.lang.String r1 = "android.permission-group.STORAGE"
            goto L_0x0081
        L_0x0044:
            int r7 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_camera_reason_title
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r0
            java.lang.String r2 = r1.getString(r7, r2)
            int r7 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_camera_reason
            java.lang.String r7 = r1.getString(r7)
            int r5 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_camera_dialog_alert
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r0
            java.lang.String r0 = r1.getString(r5, r3)
            int r4 = com.tencent.qcloud.tuikit.tuichat.R.drawable.chat_permission_icon_camera
            java.lang.String r1 = "android.permission-group.CAMERA"
            goto L_0x0081
        L_0x0063:
            int r7 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_mic_reason_title
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r0
            java.lang.String r2 = r1.getString(r7, r2)
            int r7 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_mic_reason
            java.lang.String r7 = r1.getString(r7)
            int r5 = com.tencent.qcloud.tuikit.tuichat.R.string.chat_permission_mic_dialog_alert
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r0
            java.lang.String r0 = r1.getString(r5, r3)
            int r4 = com.tencent.qcloud.tuikit.tuichat.R.drawable.chat_permission_icon_mic
            java.lang.String r1 = "android.permission-group.MICROPHONE"
        L_0x0081:
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r6
        L_0x0085:
            com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper$1 r3 = new com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper$1
            r3.<init>()
            boolean r8 = android.text.TextUtils.isEmpty(r2)
            if (r8 != 0) goto L_0x00ab
            com.tencent.qcloud.tuicore.util.PermissionRequester r8 = com.tencent.qcloud.tuicore.util.PermissionRequester.permission(r2)
            com.tencent.qcloud.tuicore.util.PermissionRequester r7 = r8.reason(r7)
            com.tencent.qcloud.tuicore.util.PermissionRequester r7 = r7.reasonTitle(r0)
            com.tencent.qcloud.tuicore.util.PermissionRequester r7 = r7.reasonIcon(r4)
            com.tencent.qcloud.tuicore.util.PermissionRequester r7 = r7.deniedAlert(r1)
            com.tencent.qcloud.tuicore.util.PermissionRequester r7 = r7.callback((com.tencent.qcloud.tuicore.util.PermissionRequester.SimpleCallback) r3)
            r7.request()
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.requestPermission(int, com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper$PermissionCallback):void");
    }
}
