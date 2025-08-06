package zendesk.support.request;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.zendesk.logger.Logger;
import com.zendesk.service.ErrorResponseAdapter;
import com.zendesk.service.ZendeskCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mz.f;
import zendesk.belvedere.Callback;
import zendesk.belvedere.MediaResult;
import zendesk.belvedere.a;
import zendesk.support.Attachment;
import zendesk.support.UploadProvider;
import zendesk.support.UploadResponse;

class AttachmentUploadService {
    private final a belvedere;
    private final List<StateRequestAttachment> errorItems;
    private final List<StateRequestAttachment> itemsForUpload;
    /* access modifiers changed from: private */
    public final Map<Long, Long> localToRemoteMap;
    private final Object lock = new Object();
    private final List<StateRequestAttachment> processedItems;
    private List<ResolveCallback> resolveCallbacks;
    private ZendeskCallback<AttachmentUploadResult> resultListener;
    private String subDirectory;
    /* access modifiers changed from: private */
    public final UploadProvider uploadProvider;

    public static class AttachmentUploadResult {
        private final Map<Long, Long> localToRemoteIdMap;
        private final List<StateRequestAttachment> requestAttachments;

        public AttachmentUploadResult(List<StateRequestAttachment> list, Map<Long, Long> map) {
            this.requestAttachments = list;
            this.localToRemoteIdMap = map;
        }

        public Map<Long, Long> getLocalToRemoteIdMap() {
            return this.localToRemoteIdMap;
        }

        public List<StateRequestAttachment> getRequestAttachments() {
            return this.requestAttachments;
        }
    }

    public class AttachmentsCallback extends ZendeskCallback<UploadResponse> {
        private final StateRequestAttachment requestAttachment;

        public AttachmentsCallback(StateRequestAttachment stateRequestAttachment) {
            this.requestAttachment = stateRequestAttachment;
        }

        public void onError(lz.a aVar) {
            Logger.l(RequestActivity.LOG_TAG, "Error uploading file: %s | Error: %s", this.requestAttachment, aVar.getReason());
            AttachmentUploadService.this.errorUpload(this.requestAttachment);
        }

        public void onSuccess(UploadResponse uploadResponse) {
            Logger.b(RequestActivity.LOG_TAG, "Successfully uploaded file: %s | Result: %s", this.requestAttachment, uploadResponse);
            AttachmentUploadService.this.localToRemoteMap.put(Long.valueOf(this.requestAttachment.getId()), uploadResponse.getAttachment().getId());
            AttachmentUploadService.this.uploadSuccess(this.requestAttachment, uploadResponse);
        }
    }

    public class ResolveCallback extends Callback<List<MediaResult>> {
        private final StateRequestAttachment requestAttachment;

        private ResolveCallback(StateRequestAttachment stateRequestAttachment) {
            this.requestAttachment = stateRequestAttachment;
        }

        public void success(List<MediaResult> list) {
            Uri parsedLocalUri = this.requestAttachment.getParsedLocalUri();
            if (list.size() <= 0 || AttachmentUploadService.this.isUploadFinished()) {
                Logger.l(RequestActivity.LOG_TAG, "Unable to resolve attachment: %s", parsedLocalUri);
                AttachmentUploadService.this.errorUpload(this.requestAttachment);
                return;
            }
            Logger.l(RequestActivity.LOG_TAG, "Successfully resolved attachment: %s", parsedLocalUri);
            StateRequestAttachment access$200 = AttachmentUploadService.this.updateRequestAttachment(this.requestAttachment, list.get(0));
            AttachmentUploadService.this.uploadProvider.uploadAttachment(access$200.getName(), access$200.getLocalFile(), access$200.getMimeType(), new AttachmentsCallback(access$200));
        }
    }

    @SuppressLint({"UseSparseArrays"})
    public AttachmentUploadService(UploadProvider uploadProvider2, a aVar, List<StateRequestAttachment> list) {
        this.uploadProvider = uploadProvider2;
        this.belvedere = aVar;
        this.itemsForUpload = list;
        this.resolveCallbacks = new ArrayList(list.size());
        this.subDirectory = UtilsAttachment.getTemporaryRequestCacheDir();
        this.processedItems = new ArrayList(list.size());
        this.errorItems = new ArrayList(list.size());
        this.localToRemoteMap = new HashMap();
    }

    /* access modifiers changed from: private */
    public void errorUpload(StateRequestAttachment stateRequestAttachment) {
        synchronized (this.lock) {
            this.errorItems.add(stateRequestAttachment);
        }
        notifyIfFinished();
    }

    /* access modifiers changed from: private */
    public boolean isUploadFinished() {
        boolean z11;
        synchronized (this.lock) {
            boolean i11 = mz.a.i(this.errorItems);
            z11 = true;
            boolean z12 = this.processedItems.size() == this.itemsForUpload.size();
            if (!i11) {
                if (!z12) {
                    z11 = false;
                }
            }
        }
        return z11;
    }

    private void notifyIfFinished() {
        Logger.b(RequestActivity.LOG_TAG, "Notify if finished. Listener: %s, isUploadFinished: %s", this.resultListener, Boolean.valueOf(isUploadFinished()));
        if (isUploadFinished() && this.resultListener != null) {
            if (mz.a.g(this.errorItems)) {
                this.resultListener.onSuccess(new AttachmentUploadResult(mz.a.c(this.processedItems), this.localToRemoteMap));
            } else {
                this.resultListener.onError(new ErrorResponseAdapter("Error uploading attachments."));
            }
            this.resultListener = null;
        }
    }

    private MediaResult renameFile(File file, long j11) {
        MediaResult d11 = this.belvedere.d(UtilsAttachment.getAttachmentSubDir(this.subDirectory, j11), file.getName());
        Logger.b(RequestActivity.LOG_TAG, "Rename local file: %s -> %s", file.getAbsolutePath(), d11.getFile().getAbsolutePath());
        if (file.renameTo(d11.getFile())) {
            return d11;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public StateRequestAttachment updateRequestAttachment(StateRequestAttachment stateRequestAttachment, MediaResult mediaResult) {
        return stateRequestAttachment.newBuilder().setLocalFile(mediaResult.getFile()).setName(mediaResult.getName()).setMimeType(mediaResult.getMimeType()).setLocalUri(mediaResult.getUri().toString()).build();
    }

    private void uploadAttachment(StateRequestAttachment stateRequestAttachment) {
        Uri parsedLocalUri = stateRequestAttachment.getParsedLocalUri();
        if (parsedLocalUri == null || isUploadFinished()) {
            Logger.l(RequestActivity.LOG_TAG, "Unable to parse uri, skipping. | %s", stateRequestAttachment.getLocalUri());
            errorUpload(stateRequestAttachment);
            return;
        }
        ResolveCallback resolveCallback = new ResolveCallback(stateRequestAttachment);
        this.resolveCallbacks.add(resolveCallback);
        this.belvedere.h(Collections.singletonList(parsedLocalUri), this.subDirectory, resolveCallback);
    }

    /* access modifiers changed from: private */
    public void uploadSuccess(StateRequestAttachment stateRequestAttachment, UploadResponse uploadResponse) {
        String str;
        File file;
        Attachment attachment = uploadResponse.getAttachment();
        MediaResult renameFile = renameFile(stateRequestAttachment.getLocalFile(), attachment.getId().longValue());
        if (renameFile != null) {
            str = renameFile.getUri().toString();
            file = renameFile.getFile();
        } else {
            str = stateRequestAttachment.getLocalUri();
            file = stateRequestAttachment.getLocalFile();
        }
        StateRequestAttachment build = stateRequestAttachment.newBuilder().setLocalUri(str).setLocalFile(file).setToken(uploadResponse.getToken()).setUrl(attachment.getContentUrl()).setMimeType(attachment.getContentType()).setName(attachment.getFileName()).build();
        synchronized (this.lock) {
            this.processedItems.add(build);
        }
        notifyIfFinished();
    }

    public void setResultListener(ZendeskCallback<AttachmentUploadResult> zendeskCallback) {
        this.resultListener = zendeskCallback;
        notifyIfFinished();
    }

    public void start(String str) {
        if (f.c(str)) {
            this.subDirectory = UtilsAttachment.getCacheDirForRequestId(str);
        }
        Logger.b(RequestActivity.LOG_TAG, "Start uploading attachments", new Object[0]);
        for (StateRequestAttachment uploadAttachment : this.itemsForUpload) {
            uploadAttachment(uploadAttachment);
        }
    }
}
