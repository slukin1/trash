package zendesk.support.request;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mz.f;
import okhttp3.ResponseBody;
import zendesk.belvedere.MediaResult;
import zendesk.belvedere.a;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.Listener;

class AttachmentDownloaderComponent implements Listener<StateConversation> {
    /* access modifiers changed from: private */
    public final ActionFactory actionFactory;
    private final AttachmentDownloader attachmentDownloader;
    /* access modifiers changed from: private */
    public final Dispatcher dispatcher;
    private final AttachmentDownloaderSelector selector = new AttachmentDownloaderSelector();

    public static class AttachmentDownloader {
        /* access modifiers changed from: private */
        public final AttachmentDownloadService attachmentIo;
        /* access modifiers changed from: private */
        public final a belvedere;
        /* access modifiers changed from: private */
        public final Set<String> downloadingHistory = new HashSet();

        public class CacheCallback extends ZendeskCallback<MediaResult> {
            private final ZendeskCallback<MediaResult> callback;
            private final StateRequestAttachment requestAttachment;

            public CacheCallback(StateRequestAttachment stateRequestAttachment, ZendeskCallback<MediaResult> zendeskCallback) {
                this.requestAttachment = stateRequestAttachment;
                this.callback = zendeskCallback;
            }

            public void onError(lz.a aVar) {
                AttachmentDownloader.this.handleError(this.requestAttachment.getUrl(), aVar, this.callback);
            }

            public void onSuccess(MediaResult mediaResult) {
                this.callback.onSuccess(mediaResult);
                AttachmentDownloader.this.downloadingHistory.remove(this.requestAttachment.getUrl());
            }
        }

        public class HttpCallback extends ZendeskCallback<ResponseBody> {
            private final ZendeskCallback<MediaResult> callback;
            private final Request request;
            private final StateRequestAttachment requestAttachment;

            public HttpCallback(Request request2, StateRequestAttachment stateRequestAttachment, ZendeskCallback<MediaResult> zendeskCallback) {
                this.request = request2;
                this.requestAttachment = stateRequestAttachment;
                this.callback = zendeskCallback;
            }

            public void onError(lz.a aVar) {
                AttachmentDownloader.this.handleError(this.requestAttachment.getUrl(), aVar, this.callback);
            }

            public void onSuccess(ResponseBody responseBody) {
                AttachmentDownloader.this.attachmentIo.storeAttachment(responseBody, UtilsAttachment.getLocalFile(AttachmentDownloader.this.belvedere, this.request.getRequestId(), this.request.getRemoteAttachmentId(), this.requestAttachment.getName()), new CacheCallback(this.requestAttachment, this.callback));
            }
        }

        public static class Request {
            private final long remoteAttachmentId;
            private final StateRequestAttachment requestAttachment;
            private final String requestId;

            public Request(String str, long j11, StateRequestAttachment stateRequestAttachment) {
                this.requestId = str;
                this.remoteAttachmentId = j11;
                this.requestAttachment = stateRequestAttachment;
            }

            public long getRemoteAttachmentId() {
                return this.remoteAttachmentId;
            }

            public StateRequestAttachment getRequestAttachment() {
                return this.requestAttachment;
            }

            public String getRequestId() {
                return this.requestId;
            }
        }

        public AttachmentDownloader(a aVar, AttachmentDownloadService attachmentDownloadService) {
            this.belvedere = aVar;
            this.attachmentIo = attachmentDownloadService;
        }

        /* access modifiers changed from: private */
        public void handleError(String str, lz.a aVar, ZendeskCallback zendeskCallback) {
            this.downloadingHistory.remove(str);
            if (zendeskCallback != null) {
                zendeskCallback.onError(aVar);
            }
        }

        public void download(Request request, ZendeskCallback<MediaResult> zendeskCallback) {
            StateRequestAttachment requestAttachment = request.getRequestAttachment();
            String url = requestAttachment.getUrl();
            if (!this.downloadingHistory.contains(url)) {
                this.downloadingHistory.add(url);
                this.attachmentIo.downloadAttachment(url, new HttpCallback(request, requestAttachment, zendeskCallback));
            }
        }
    }

    public static class AttachmentDownloaderSelector {
        public List<AttachmentDownloader.Request> selectData(StateConversation stateConversation) {
            StateIdMapper attachmentIdMapper = stateConversation.getAttachmentIdMapper();
            String localId = stateConversation.getLocalId();
            List<StateMessage> messages = stateConversation.getMessages();
            LinkedList linkedList = new LinkedList();
            for (StateMessage attachments : messages) {
                for (StateRequestAttachment next : attachments.getAttachments()) {
                    long id2 = next.getId();
                    boolean z11 = next.getLocalFile() != null;
                    boolean hasRemoteId = attachmentIdMapper.hasRemoteId(Long.valueOf(id2));
                    boolean c11 = f.c(next.getUrl());
                    if (!z11 && hasRemoteId && c11) {
                        linkedList.add(new AttachmentDownloader.Request(localId, attachmentIdMapper.getRemoteId(Long.valueOf(id2)).longValue(), next));
                    }
                }
            }
            return linkedList;
        }
    }

    public class DownloadCallback extends ZendeskCallback<MediaResult> {
        private final StateRequestAttachment requestAttachment;

        public DownloadCallback(StateRequestAttachment stateRequestAttachment) {
            this.requestAttachment = stateRequestAttachment;
        }

        public void onError(lz.a aVar) {
            Logger.b(RequestActivity.LOG_TAG, "Unable to download attachment. Error: %s", aVar.getReason());
        }

        public void onSuccess(MediaResult mediaResult) {
            AttachmentDownloaderComponent.this.dispatcher.dispatch(AttachmentDownloaderComponent.this.actionFactory.attachmentDownloaded(this.requestAttachment, mediaResult));
        }
    }

    public AttachmentDownloaderComponent(Dispatcher dispatcher2, ActionFactory actionFactory2, AttachmentDownloader attachmentDownloader2) {
        this.dispatcher = dispatcher2;
        this.actionFactory = actionFactory2;
        this.attachmentDownloader = attachmentDownloader2;
    }

    public void update(StateConversation stateConversation) {
        for (AttachmentDownloader.Request next : this.selector.selectData(stateConversation)) {
            this.attachmentDownloader.download(next, new DownloadCallback(next.getRequestAttachment()));
        }
    }
}
