package com.google.zxing.client.android.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import bh.j;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import pro.huobi.R;

public final class ClipboardInterface {
    private static final String TAG = "ClipboardInterface";

    private ClipboardInterface() {
    }

    private static ClipboardManager getManager(Context context) {
        return (ClipboardManager) context.getSystemService("clipboard");
    }

    public static CharSequence getText(Context context) {
        ClipData primaryClip = getManager(context).getPrimaryClip();
        if (hasText(context)) {
            return primaryClip.getItemAt(0).coerceToText(context);
        }
        return null;
    }

    public static boolean hasText(Context context) {
        ClipData primaryClip = getManager(context).getPrimaryClip();
        return primaryClip != null && primaryClip.getItemCount() > 0;
    }

    public static void setCopyText(CharSequence charSequence, Context context) {
        if (charSequence != null) {
            try {
                getManager(context).setPrimaryClip(ClipData.newPlainText((CharSequence) null, charSequence));
                HuobiToastUtil.v(j.c().getString(R.string.currency_detail_notice_dialog_toast));
            } catch (IllegalStateException | NullPointerException | SecurityException e11) {
                Log.w(TAG, "Clipboard bug", e11);
            }
        }
    }

    public static void setText(CharSequence charSequence, Context context) {
        if (charSequence != null) {
            try {
                getManager(context).setPrimaryClip(ClipData.newPlainText((CharSequence) null, charSequence));
            } catch (IllegalStateException | NullPointerException | SecurityException e11) {
                Log.w(TAG, "Clipboard bug", e11);
            }
        }
    }
}
