package com.zopim.android.sdk.chatlog;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.core.widget.ContentLoadingProgressBar;
import com.luck.picture.lib.config.SelectMimeType;
import com.sebchlan.picassocompat.CallbackCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.attachment.FileExtension;
import com.zopim.android.sdk.model.items.VisitorAttachment;
import java.util.Locale;

final class VisitorAttachmentHolder extends VisitorHolder<VisitorAttachment> {
    private View.OnClickListener attachmentClickListener = new View.OnClickListener() {
        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!IntentResolver.startActivity(VisitorAttachmentHolder.this.itemView.getContext(), VisitorAttachmentHolder.this.openAttachmentIntent)) {
                Toast.makeText(VisitorAttachmentHolder.this.itemView.getContext(), R.string.attachment_open_error_message, 0).show();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    };
    private View attachmentImageContainer;
    /* access modifiers changed from: private */
    public ContentLoadingProgressBar attachmentProgress;
    private ImageView attachmentThumbnail;
    /* access modifiers changed from: private */
    public Intent openAttachmentIntent = new Intent("android.intent.action.VIEW");

    /* renamed from: com.zopim.android.sdk.chatlog.VisitorAttachmentHolder$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$attachment$FileExtension;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.zopim.android.sdk.attachment.FileExtension[] r0 = com.zopim.android.sdk.attachment.FileExtension.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$attachment$FileExtension = r0
                com.zopim.android.sdk.attachment.FileExtension r1 = com.zopim.android.sdk.attachment.FileExtension.PDF     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$attachment$FileExtension     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.attachment.FileExtension r1 = com.zopim.android.sdk.attachment.FileExtension.TXT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$attachment$FileExtension     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.attachment.FileExtension r1 = com.zopim.android.sdk.attachment.FileExtension.JPG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$attachment$FileExtension     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zopim.android.sdk.attachment.FileExtension r1 = com.zopim.android.sdk.attachment.FileExtension.JPEG     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$attachment$FileExtension     // Catch:{ NoSuchFieldError -> 0x003e }
                com.zopim.android.sdk.attachment.FileExtension r1 = com.zopim.android.sdk.attachment.FileExtension.PNG     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$attachment$FileExtension     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.zopim.android.sdk.attachment.FileExtension r1 = com.zopim.android.sdk.attachment.FileExtension.GIF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.chatlog.VisitorAttachmentHolder.AnonymousClass3.<clinit>():void");
        }
    }

    public VisitorAttachmentHolder(View view) {
        super(view);
        this.attachmentImageContainer = view.findViewById(R.id.attachment_image_container);
        this.attachmentThumbnail = (ImageView) view.findViewById(R.id.attachment_thumbnail);
        this.attachmentProgress = (ContentLoadingProgressBar) view.findViewById(R.id.attachment_progress);
        this.attachmentThumbnail.setOnClickListener(this.attachmentClickListener);
        this.openAttachmentIntent.setFlags(1073741825);
    }

    /* access modifiers changed from: private */
    public void setProgressVisibility(int i11) {
        if (i11 == -1 || i11 == 0) {
            this.attachmentProgress.setVisibility(4);
        } else if (i11 != 100) {
            this.attachmentProgress.setVisibility(0);
        } else {
            this.attachmentProgress.setVisibility(4);
        }
    }

    public void bind(final VisitorAttachment visitorAttachment) {
        super.bind(visitorAttachment);
        if (visitorAttachment.getFile() != null) {
            int i11 = AnonymousClass3.$SwitchMap$com$zopim$android$sdk$attachment$FileExtension[FileExtension.getExtension(visitorAttachment.getFile()).ordinal()];
            if (i11 == 3 || i11 == 4 || i11 == 5 || i11 == 6) {
                PicassoHelper.loadImage(this.attachmentThumbnail, visitorAttachment.getFile(), (CallbackCompat) new CallbackCompat() {
                    public void onError() {
                        VisitorAttachmentHolder.this.attachmentProgress.setVisibility(4);
                    }

                    public void onSuccess() {
                        VisitorAttachmentHolder.this.setProgressVisibility(visitorAttachment.getUploadProgress());
                    }
                });
                String string = this.itemView.getContext().getString(R.string.belvedere_sdk_fpa_suffix);
                this.openAttachmentIntent.setDataAndType(FileProvider.getUriForFile(this.itemView.getContext(), String.format(Locale.US, "%s%s", new Object[]{this.itemView.getContext().getPackageName(), string}), visitorAttachment.getFile()), SelectMimeType.SYSTEM_IMAGE);
            }
        }
    }
}
