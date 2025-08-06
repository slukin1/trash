package com.huochat.community.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import com.hbg.lib.common.BaseApplication;

public class ClipManager {
    public static boolean copy(Context context, CharSequence charSequence) {
        if (context == null) {
            return false;
        }
        try {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager == null) {
                return false;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("text", charSequence));
            return true;
        } catch (Exception e11) {
            Log.e("Clipboard", "copy error", e11);
            return false;
        }
    }

    public static void copyText(CharSequence charSequence) {
        ((ClipboardManager) BaseApplication.b().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", charSequence));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r1 = (r1 = r1.getPrimaryClip()).getItemAt(0).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFirstClipboardText(android.content.Context r1) {
        /*
            java.lang.String r0 = "clipboard"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.content.ClipboardManager r1 = (android.content.ClipboardManager) r1
            if (r1 == 0) goto L_0x002c
            boolean r0 = r1.hasPrimaryClip()
            if (r0 == 0) goto L_0x002c
            android.content.ClipData r1 = r1.getPrimaryClip()
            if (r1 == 0) goto L_0x002c
            int r0 = r1.getItemCount()
            if (r0 <= 0) goto L_0x002c
            r0 = 0
            android.content.ClipData$Item r1 = r1.getItemAt(r0)
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = r1.toString()
            return r1
        L_0x002c:
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.ClipManager.getFirstClipboardText(android.content.Context):java.lang.String");
    }

    public static String paste() {
        return ((ClipboardManager) BaseApplication.b().getSystemService("clipboard")).getText().toString().trim();
    }

    public static void copy(String str) {
        ((ClipboardManager) BaseApplication.b().getSystemService("clipboard")).setText(str.trim());
    }
}
