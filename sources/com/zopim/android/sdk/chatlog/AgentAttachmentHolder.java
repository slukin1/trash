package com.zopim.android.sdk.chatlog;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.luck.picture.lib.config.SelectMimeType;
import com.sebchlan.picassocompat.CallbackCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.belvedere.Belvedere;
import com.zendesk.belvedere.BelvedereResult;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.attachment.FileExtension;
import com.zopim.android.sdk.model.items.AgentAttachment;
import mz.b;

final class AgentAttachmentHolder extends AgentHolder<AgentAttachment> {
    private View attachmentDocumentContainer;
    private ImageView attachmentDocumentIcon;
    private TextView attachmentDocumentName;
    private TextView attachmentDocumentSize;
    private View attachmentImageContainer;
    /* access modifiers changed from: private */
    public ProgressBar attachmentProgress;
    private ImageView attachmentThumbnail;
    private View.OnClickListener mAttachmentClickListener = new View.OnClickListener() {
        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!IntentResolver.startActivity(AgentAttachmentHolder.this.itemView.getContext(), AgentAttachmentHolder.this.openAttachmentIntent)) {
                Toast.makeText(AgentAttachmentHolder.this.itemView.getContext(), R.string.attachment_open_error_message, 0).show();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    };
    /* access modifiers changed from: private */
    public Intent openAttachmentIntent = new Intent("android.intent.action.VIEW");

    /* renamed from: com.zopim.android.sdk.chatlog.AgentAttachmentHolder$3  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.chatlog.AgentAttachmentHolder.AnonymousClass3.<clinit>():void");
        }
    }

    public AgentAttachmentHolder(View view) {
        super(view);
        this.attachmentDocumentContainer = view.findViewById(R.id.attachment_document);
        this.attachmentDocumentName = (TextView) view.findViewById(R.id.attachment_name);
        this.attachmentDocumentSize = (TextView) view.findViewById(R.id.attachment_size);
        this.attachmentDocumentIcon = (ImageView) view.findViewById(R.id.attachment_icon);
        this.attachmentImageContainer = view.findViewById(R.id.attachment_image_container);
        this.attachmentThumbnail = (ImageView) view.findViewById(R.id.attachment_thumbnail);
        this.attachmentProgress = (ProgressBar) view.findViewById(R.id.attachment_progress);
        this.openAttachmentIntent.setFlags(1073741825);
        this.attachmentImageContainer.setOnClickListener(this.mAttachmentClickListener);
        this.attachmentDocumentContainer.setOnClickListener(this.mAttachmentClickListener);
    }

    private String humanReadableByteCount(long j11, boolean z11) {
        return b.c(Long.valueOf(j11), z11);
    }

    public void bind(AgentAttachment agentAttachment) {
        super.bind(agentAttachment);
        if (agentAttachment.getAttachmentUrl() != null && agentAttachment.getAttachmentFile() != null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(agentAttachment.getAttachmentUrl().toExternalForm());
            Uri parse = Uri.parse(agentAttachment.getAttachmentUrl().toExternalForm());
            BelvedereResult d11 = Belvedere.b(this.itemView.getContext()).i().d(agentAttachment.getAttachmentFile().getName());
            Uri uri = d11 != null ? d11.getUri() : null;
            switch (AnonymousClass3.$SwitchMap$com$zopim$android$sdk$attachment$FileExtension[FileExtension.valueOfExtension(fileExtensionFromUrl).ordinal()]) {
                case 1:
                    if (uri != null) {
                        this.openAttachmentIntent.setDataAndType(uri, "application/pdf");
                    } else {
                        this.openAttachmentIntent.setData(parse);
                    }
                    this.attachmentDocumentIcon.setImageResource(R.drawable.ic_chat_attachment_pdf);
                    this.attachmentDocumentName.setText(agentAttachment.getAttachmentName());
                    if (agentAttachment.getAttachmentSize() != null) {
                        this.attachmentDocumentSize.setVisibility(0);
                        this.attachmentDocumentSize.setText(humanReadableByteCount(agentAttachment.getAttachmentSize().longValue(), true));
                    } else {
                        this.attachmentDocumentSize.setVisibility(8);
                    }
                    this.attachmentDocumentContainer.setVisibility(0);
                    this.attachmentImageContainer.setVisibility(8);
                    return;
                case 2:
                    if (uri != null) {
                        this.openAttachmentIntent.setDataAndType(uri, "text/plain");
                    } else {
                        this.openAttachmentIntent.setData(parse);
                    }
                    this.attachmentDocumentIcon.setImageResource(R.drawable.ic_chat_attachment_txt);
                    this.attachmentDocumentName.setText(agentAttachment.getAttachmentName());
                    if (uri != null) {
                        this.attachmentDocumentSize.setVisibility(0);
                        this.attachmentDocumentSize.setText(humanReadableByteCount(agentAttachment.getAttachmentSize().longValue(), true));
                    } else {
                        this.attachmentDocumentSize.setVisibility(8);
                    }
                    this.attachmentDocumentContainer.setVisibility(0);
                    this.attachmentImageContainer.setVisibility(8);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    if (uri != null) {
                        this.openAttachmentIntent.setDataAndType(uri, SelectMimeType.SYSTEM_IMAGE);
                    } else {
                        this.openAttachmentIntent.setDataAndType(parse, SelectMimeType.SYSTEM_IMAGE);
                    }
                    if (FileExtension.GIF.equals(FileExtension.valueOfExtension(fileExtensionFromUrl))) {
                        this.openAttachmentIntent.setData(parse);
                    }
                    this.attachmentProgress.setVisibility(0);
                    PicassoHelper.loadImage(this.attachmentThumbnail, parse, (CallbackCompat) new CallbackCompat() {
                        public void onError() {
                            AgentAttachmentHolder.this.attachmentProgress.setVisibility(8);
                        }

                        public void onSuccess() {
                            AgentAttachmentHolder.this.attachmentProgress.setVisibility(8);
                        }
                    });
                    this.attachmentDocumentContainer.setVisibility(8);
                    this.attachmentImageContainer.setVisibility(0);
                    return;
                default:
                    if (uri != null) {
                        this.openAttachmentIntent.setData(uri);
                    } else {
                        this.openAttachmentIntent.setData(parse);
                    }
                    this.attachmentDocumentIcon.setImageResource(R.drawable.ic_chat_attachment_unknown);
                    this.attachmentDocumentName.setText(agentAttachment.getAttachmentName());
                    if (agentAttachment.getAttachmentSize() != null) {
                        this.attachmentDocumentSize.setVisibility(0);
                        this.attachmentDocumentSize.setText(humanReadableByteCount(agentAttachment.getAttachmentSize().longValue(), true));
                    } else {
                        this.attachmentDocumentSize.setVisibility(8);
                    }
                    this.attachmentDocumentContainer.setVisibility(0);
                    this.attachmentImageContainer.setVisibility(8);
                    return;
            }
        }
    }
}
