package zendesk.support.request;

import androidx.core.util.c;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import zendesk.belvedere.MediaResult;
import zendesk.belvedere.a;
import zendesk.core.AuthenticationProvider;
import zendesk.core.Zendesk;
import zendesk.support.CommentsResponse;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.SupportUiStorage;
import zendesk.support.UploadProvider;
import zendesk.support.request.ActionCreateComment;
import zendesk.support.suas.Action;

class ActionFactory {
    public static final String ANDROID_ON_PAUSE = "ANDROID_ON_PAUSE";
    public static final String ANDROID_ON_RESUME = "ANDROID_ON_RESUME";
    public static final String ATTACHMENTS_DESELECTED = "ATTACHMENTS_DESELECTED";
    public static final String ATTACHMENTS_SELECTED = "ATTACHMENTS_SELECTED";
    public static final String ATTACHMENT_DOWNLOADED = "ATTACHMENT_DOWNLOADED";
    public static final String CLEAR_ATTACHMENTS = "CLEAR_ATTACHMENTS";
    public static final String CLEAR_MESSAGES = "CLEAR_MESSAGES";
    public static final String CREATE_COMMENT = "CREATE_COMMENT";
    public static final String CREATE_COMMENT_ERROR = "CREATE_COMMENT_ERROR";
    public static final String CREATE_COMMENT_SUCCESS = "CREATE_COMMENT_SUCCESS";
    public static final String CREATE_REQUEST = "CREATE_REQUEST";
    public static final String CREATE_REQUEST_ERROR = "CREATE_REQUEST_ERROR";
    public static final String CREATE_REQUEST_SUCCESS = "CREATE_REQUEST_SUCCESS";
    public static final String DELETE_MESSAGE = "DELETE_MESSAGE";
    public static final String DIALOG_DISMISSED = "DIALOG_DISMISSED";
    public static final String LOAD_COMMENTS_FROM_CACHE = "LOAD_COMMENTS_FROM_CACHE";
    public static final String LOAD_COMMENTS_FROM_CACHE_ERROR = "LOAD_COMMENTS_FROM_CACHE_ERROR";
    public static final String LOAD_COMMENTS_FROM_CACHE_SUCCESS = "LOAD_COMMENTS_FROM_CACHE_SUCCESS";
    public static final String LOAD_COMMENTS_INITIAL = "LOAD_COMMENT_INITIAL";
    public static final String LOAD_COMMENTS_INITIAL_ERROR = "LOAD_COMMENTS_INITIAL_ERROR";
    public static final String LOAD_COMMENTS_INITIAL_SUCCESS = "LOAD_COMMENTS_INITIAL_SUCCESS";
    public static final String LOAD_COMMENTS_UPDATE = "LOAD_COMMENTS_UPDATE";
    public static final String LOAD_COMMENTS_UPDATE_ERROR = "LOAD_COMMENTS_UPDATE_ERROR";
    public static final String LOAD_COMMENTS_UPDATE_SUCCESS = "LOAD_COMMENTS_UPDATE_SUCCESS";
    public static final String LOAD_REQUEST = "LOAD_REQUEST";
    public static final String LOAD_REQUEST_ERROR = "LOAD_REQUEST_ERROR";
    public static final String LOAD_REQUEST_SUCCESS = "LOAD_REQUEST_SUCCESS";
    public static final String LOAD_SETTINGS = "LOAD_SETTINGS";
    public static final String LOAD_SETTINGS_ERROR = "LOAD_SETTINGS_ERROR";
    public static final String LOAD_SETTINGS_SUCCESS = "LOAD_SETTINGS_SUCCESS";
    public static final String REQUEST_CLOSED = "REQUEST_CLOSED";
    public static final String SHOW_RETRY_DIALOG = "SHOW_RETRY_DIALOG";
    public static final String SKIP_ACTION = "SKIP_ACTION";
    public static final String START_CONFIG = "START_CONFIG";
    private final AuthenticationProvider authProvider;
    private final a belvedere;
    private final Executor executorService;
    private final Executor mainThreadExecutor;
    private final RequestProvider requestProvider;
    private final String sdkVersion;
    private final SupportSettingsProvider settingsProvider;
    private final SupportBlipsProvider supportBlipsProvider;
    private final SupportUiStorage supportUiStorage;
    private final UploadProvider uploadProvider;

    /* renamed from: zendesk  reason: collision with root package name */
    private final Zendesk f62965zendesk;

    public static class ErrorAction<E> extends Action<E> {
        private final lz.a errorResponse;

        public ErrorAction(String str, lz.a aVar) {
            this(str, aVar, (Object) null);
        }

        public lz.a getErrorResponse() {
            return this.errorResponse;
        }

        public ErrorAction(String str, lz.a aVar, E e11) {
            super(str, e11);
            this.errorResponse = aVar;
        }
    }

    public ActionFactory(RequestProvider requestProvider2, UploadProvider uploadProvider2, SupportSettingsProvider supportSettingsProvider, a aVar, SupportUiStorage supportUiStorage2, Executor executor, String str, AuthenticationProvider authenticationProvider, Zendesk zendesk2, SupportBlipsProvider supportBlipsProvider2, Executor executor2) {
        this.requestProvider = requestProvider2;
        this.uploadProvider = uploadProvider2;
        this.settingsProvider = supportSettingsProvider;
        this.belvedere = aVar;
        this.supportUiStorage = supportUiStorage2;
        this.executorService = executor;
        this.mainThreadExecutor = executor2;
        this.sdkVersion = str;
        this.authProvider = authenticationProvider;
        this.f62965zendesk = zendesk2;
        this.supportBlipsProvider = supportBlipsProvider2;
    }

    public Action androidOnPause() {
        return new Action(ANDROID_ON_PAUSE);
    }

    public Action androidOnResume() {
        return new Action(ANDROID_ON_RESUME);
    }

    public Action attachmentDownloaded(StateRequestAttachment stateRequestAttachment, MediaResult mediaResult) {
        return new Action(ATTACHMENT_DOWNLOADED, c.a(stateRequestAttachment, mediaResult));
    }

    public Action clearAttachments() {
        return new Action(CLEAR_ATTACHMENTS);
    }

    public Action clearMessages() {
        return new Action(CLEAR_MESSAGES);
    }

    public Action createComment(StateMessage stateMessage) {
        return new Action(CREATE_COMMENT, stateMessage);
    }

    public Action createCommentAsync(String str, List<StateRequestAttachment> list) {
        return AsyncMiddleware.createAction(new ActionCreateComment(this, this.requestProvider, new AttachmentUploadService(this.uploadProvider, this.belvedere, list), new StateMessage(str, list)));
    }

    public Action createCommentError(lz.a aVar, StateMessage stateMessage) {
        return new ErrorAction(CREATE_COMMENT_ERROR, aVar, stateMessage);
    }

    public Action createCommentSuccess(ActionCreateComment.CreateCommentResult createCommentResult) {
        return new Action(CREATE_COMMENT_SUCCESS, createCommentResult);
    }

    public Action createRequestError(lz.a aVar, StateMessage stateMessage) {
        return new ErrorAction(CREATE_REQUEST_ERROR, aVar, stateMessage);
    }

    public Action createRequestSuccess(ActionCreateComment.CreateCommentResult createCommentResult) {
        return new Action(CREATE_REQUEST_SUCCESS, createCommentResult);
    }

    public Action deleteMessage(StateMessage stateMessage) {
        return new Action(DELETE_MESSAGE, stateMessage);
    }

    public Action deselectAttachment(List<MediaResult> list) {
        return new Action(ATTACHMENTS_DESELECTED, list);
    }

    public Action initialLoadCommentsAsync() {
        return AsyncMiddleware.createAction(new ActionLoadComments(this, this.requestProvider, this.belvedere, true));
    }

    public Action installStartConfigAsync(RequestConfiguration requestConfiguration) {
        return AsyncMiddleware.createAction(new ActionInstallConfiguration(this.supportUiStorage, requestConfiguration, this.executorService, this.mainThreadExecutor, this, this.supportBlipsProvider));
    }

    public Action loadComments(boolean z11) {
        if (z11) {
            return new Action(LOAD_COMMENTS_INITIAL);
        }
        return new Action(LOAD_COMMENTS_UPDATE);
    }

    public Action loadCommentsError(boolean z11, lz.a aVar) {
        if (z11) {
            return new ErrorAction(LOAD_COMMENTS_INITIAL_ERROR, aVar);
        }
        return new ErrorAction(LOAD_COMMENTS_UPDATE_ERROR, aVar);
    }

    public Action loadCommentsFromCache() {
        return new Action(LOAD_COMMENTS_FROM_CACHE);
    }

    public Action loadCommentsFromCacheAsync() {
        return AsyncMiddleware.createAction(new ActionLoadCachedComments(this, this.supportUiStorage, this.belvedere, this.executorService, this.sdkVersion));
    }

    public Action loadCommentsFromCacheError() {
        return new Action(LOAD_COMMENTS_FROM_CACHE_ERROR);
    }

    public Action loadCommentsFromCacheSuccess(StateConversation stateConversation) {
        return new Action(LOAD_COMMENTS_FROM_CACHE_SUCCESS, stateConversation);
    }

    public Action loadCommentsSuccess(boolean z11, CommentsResponse commentsResponse, Map<Long, MediaResult> map) {
        c cVar = new c(commentsResponse, map);
        if (z11) {
            return new Action(LOAD_COMMENTS_INITIAL_SUCCESS, cVar);
        }
        return new Action(LOAD_COMMENTS_UPDATE_SUCCESS, cVar);
    }

    public Action loadRequest() {
        return new Action(LOAD_REQUEST);
    }

    public Action loadRequestAsync() {
        return AsyncMiddleware.createAction(new ActionLoadRequest(this, this.requestProvider));
    }

    public Action loadRequestError(lz.a aVar) {
        return new ErrorAction(LOAD_REQUEST_ERROR, aVar);
    }

    public Action loadRequestSuccess(Request request) {
        return new Action(LOAD_REQUEST_SUCCESS, request);
    }

    public Action loadSettings() {
        return new Action(LOAD_SETTINGS);
    }

    public Action loadSettingsAsync() {
        return AsyncMiddleware.createAction(new ActionLoadSettings(this, this.settingsProvider, this.authProvider));
    }

    public Action loadSettingsError(lz.a aVar) {
        return new ErrorAction(LOAD_SETTINGS_ERROR, aVar);
    }

    public Action loadSettingsSuccess(StateSettings stateSettings) {
        return new Action(LOAD_SETTINGS_SUCCESS, stateSettings);
    }

    public Action onDialogDismissed() {
        return new Action(DIALOG_DISMISSED);
    }

    public Action requestClosed() {
        return new Action(REQUEST_CLOSED);
    }

    public Action resendCommentAsync(StateMessage stateMessage) {
        return AsyncMiddleware.createAction(new ActionCreateComment(this, this.requestProvider, new AttachmentUploadService(this.uploadProvider, this.belvedere, stateMessage.getAttachments()), stateMessage));
    }

    public Action selectAttachment(List<MediaResult> list) {
        return new Action(ATTACHMENTS_SELECTED, list);
    }

    public Action showRetryDialog(List<StateMessage> list) {
        return new Action(SHOW_RETRY_DIALOG, list);
    }

    public Action skipAction() {
        return new Action(SKIP_ACTION);
    }

    public Action startConfig(RequestConfiguration requestConfiguration) {
        return new Action(START_CONFIG, requestConfiguration);
    }

    public Action updateCommentsAsync() {
        return AsyncMiddleware.createAction(new ActionLoadComments(this, this.requestProvider, this.belvedere, false));
    }

    public Action updateNameEmailAsync(String str, String str2) {
        return AsyncMiddleware.createAction(new ActionUpdateNameEmail(str, str2, this.authProvider, this.f62965zendesk));
    }
}
