package zendesk.support.request;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.zendesk.sdk.R$string;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import mz.f;
import zendesk.belvedere.MediaResult;
import zendesk.belvedere.a;
import zendesk.support.IdUtil;

class UtilsAttachment {
    private static final String ATTACHMENT_SEPARATOR = ", ";
    private static final String ATTACHMENT_TEXT_BODY = "[%s]";
    private static final String PATH_PLACEHOLDER = "%s%s%s";
    private static final AttachmentNameComparator REQUEST_ATTACHMENT_COMPARATOR = new AttachmentNameComparator();
    private static final String REQUEST_BELVEDERE_PATH;
    private static final String SUPPORT_BELVEDERE_BASE_PATH;

    public static class AttachmentNameComparator implements Comparator<StateRequestAttachment> {
        private AttachmentNameComparator() {
        }

        public int compare(StateRequestAttachment stateRequestAttachment, StateRequestAttachment stateRequestAttachment2) {
            return stateRequestAttachment.getName().compareTo(stateRequestAttachment2.getName());
        }
    }

    static {
        Locale locale = Locale.US;
        String str = File.separator;
        String format = String.format(locale, PATH_PLACEHOLDER, new Object[]{"zendesk", str, "support"});
        SUPPORT_BELVEDERE_BASE_PATH = format;
        REQUEST_BELVEDERE_PATH = String.format(locale, PATH_PLACEHOLDER, new Object[]{format, str, "request"});
    }

    private UtilsAttachment() {
    }

    public static Drawable getAppIcon(Context context, ResolveInfo resolveInfo) {
        Drawable loadIcon = resolveInfo != null ? resolveInfo.loadIcon(context.getPackageManager()) : null;
        if (loadIcon != null) {
            return loadIcon;
        }
        return ContextCompat.getDrawable(context, 17301651);
    }

    public static ResolveInfo getAppInfoForFile(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        MediaResult d11 = a.c(context).d("tmp", str);
        if (d11 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(d11.getUri());
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (!mz.a.g(queryIntentActivities)) {
            return queryIntentActivities.get(0);
        }
        return null;
    }

    public static CharSequence getAppName(Context context, ResolveInfo resolveInfo) {
        String loadLabel = resolveInfo != null ? resolveInfo.loadLabel(context.getPackageManager()) : "";
        if (!TextUtils.isEmpty(loadLabel)) {
            return loadLabel;
        }
        return context.getString(R$string.request_attachment_generic_unknown_app);
    }

    public static String getAttachmentSubDir(String str, long j11) {
        return String.format(Locale.US, PATH_PLACEHOLDER, new Object[]{str, File.separator, Long.valueOf(j11)});
    }

    public static String getCacheDirForRequestId(String str) {
        return String.format(Locale.US, PATH_PLACEHOLDER, new Object[]{REQUEST_BELVEDERE_PATH, File.separator, str});
    }

    public static String getContentDescriptionForAttachmentButton(Context context, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getString(R$string.request_menu_button_label_add_attachments));
        sb2.append(". ");
        if (i11 == 0) {
            sb2.append(context.getString(R$string.zs_request_attachment_indicator_no_attachments_selected_accessibility));
        } else if (i11 == 1) {
            sb2.append(context.getString(R$string.zs_request_attachment_indicator_one_attachments_selected_accessibility));
        } else {
            sb2.append(context.getString(R$string.zs_request_attachment_indicator_n_attachments_selected_accessibility, new Object[]{Integer.valueOf(i11)}));
        }
        return sb2.toString();
    }

    public static MediaResult getLocalFile(a aVar, String str, long j11, String str2) {
        return aVar.d(getAttachmentSubDir(getCacheDirForRequestId(str), j11), str2);
    }

    public static String getMessageBodyForAttachments(List<StateRequestAttachment> list) {
        List<TypeT> c11 = mz.a.c(list);
        Collections.sort(c11, REQUEST_ATTACHMENT_COMPARATOR);
        StringBuilder sb2 = new StringBuilder();
        int size = c11.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append(((StateRequestAttachment) c11.get(i11)).getName());
            if (i11 < size - 1) {
                sb2.append(ATTACHMENT_SEPARATOR);
            }
        }
        return String.format(Locale.US, ATTACHMENT_TEXT_BODY, new Object[]{sb2.toString()});
    }

    public static String getTemporaryRequestCacheDir() {
        return String.format(Locale.US, PATH_PLACEHOLDER, new Object[]{REQUEST_BELVEDERE_PATH, File.separator, IdUtil.newStringId()});
    }

    public static boolean hasAttachmentBody(StateMessage stateMessage) {
        if (!mz.a.i(stateMessage.getAttachments())) {
            return false;
        }
        return stateMessage.getBody().equals(getMessageBodyForAttachments(stateMessage.getAttachments()));
    }

    public static boolean isImageAttachment(StateRequestAttachment stateRequestAttachment) {
        String mimeType = stateRequestAttachment.getMimeType();
        return f.c(mimeType) && mimeType.toLowerCase(Locale.US).startsWith("image");
    }
}
