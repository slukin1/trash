package zendesk.support.request;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.zendesk.sdk.R$id;
import java.util.ArrayList;
import java.util.List;
import mz.a;
import mz.f;
import zendesk.belvedere.ImageStream;
import zendesk.belvedere.MediaResult;
import zendesk.support.RequestStatus;
import zendesk.support.UiUtils;
import zendesk.support.request.ViewMessageComposer;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.Listener;
import zendesk.support.suas.State;
import zendesk.support.suas.StateSelector;

class ComponentMessageComposer implements Listener<MessageComposerModel>, ViewMessageComposer.InputListener, ImageStream.b {
    private final ActionFactory actionFactory;
    private final AppCompatActivity activity;
    private final AttachmentHelper attachmentHelper = new AttachmentHelper(R$id.attachments_indicator_icon, R$id.message_composer_send_btn);
    private final Dispatcher dispatcher;
    private final ImageStream imageStream;
    /* access modifiers changed from: private */
    public final ViewMessageComposer messageComposerView;
    private final MessageComposerSelector messageFieldSelector = new MessageComposerSelector();

    public static class MessageComposerModel {
        private final boolean attachmentsButtonEnabled;
        private final List<StateRequestAttachment> extraAttachments;
        private final long maxFileSize;
        private final boolean messageComposerVisible;
        private final List<StateRequestAttachment> requestAttachments;
        private final boolean sendButtonEnabled;

        public MessageComposerModel(List<StateRequestAttachment> list, List<StateRequestAttachment> list2, long j11, boolean z11, boolean z12, boolean z13) {
            this.requestAttachments = list;
            this.extraAttachments = list2;
            this.maxFileSize = j11;
            this.sendButtonEnabled = z11;
            this.attachmentsButtonEnabled = z12;
            this.messageComposerVisible = z13;
        }

        public List<StateRequestAttachment> getExtraAttachments() {
            return this.extraAttachments;
        }

        public long getMaxFileSize() {
            return this.maxFileSize;
        }

        public List<StateRequestAttachment> getRequestAttachments() {
            return this.requestAttachments;
        }

        public boolean isAttachmentsButtonEnabled() {
            return this.attachmentsButtonEnabled;
        }

        public boolean isMessageComposerVisible() {
            return this.messageComposerVisible;
        }

        public boolean isSendButtonEnabled() {
            return this.sendButtonEnabled;
        }
    }

    public static class MessageComposerSelector implements StateSelector<MessageComposerModel> {
        public MessageComposerModel selectData(State state) {
            StateAttachments fromState = StateAttachments.fromState(state);
            StateConfig fromState2 = StateConfig.fromState(state);
            StateConversation fromState3 = StateConversation.fromState(state);
            ArrayList arrayList = new ArrayList(fromState.getAllSelectedAttachments());
            return new MessageComposerModel(a.c(fromState.getSelectedAttachments()), arrayList, fromState2.getSettings().getMaxAttachmentSize(), f.c(fromState3.getRemoteId()), fromState2.getSettings().isAttachmentsEnabled(), fromState3.getStatus() != RequestStatus.Closed);
        }
    }

    public ComponentMessageComposer(AppCompatActivity appCompatActivity, ImageStream imageStream2, ViewMessageComposer viewMessageComposer, Dispatcher dispatcher2, ActionFactory actionFactory2) {
        this.activity = appCompatActivity;
        this.messageComposerView = viewMessageComposer;
        this.dispatcher = dispatcher2;
        this.actionFactory = actionFactory2;
        this.imageStream = imageStream2;
        viewMessageComposer.addListener(this);
        initImagePicker();
    }

    private void initImagePicker() {
        this.imageStream.qh(this);
        if (this.imageStream.sh().getInputTrap().hasFocus()) {
            this.messageComposerView.requestFocusForInput();
        }
        if (this.imageStream.Eh()) {
            this.messageComposerView.post(new Runnable() {
                public void run() {
                    ComponentMessageComposer.this.onAddAttachmentsRequested();
                }
            });
        }
    }

    public StateSelector<MessageComposerModel> getSelector() {
        return this.messageFieldSelector;
    }

    public boolean hasUnsavedInput() {
        return f.c(this.messageComposerView.getMessage()) || a.i(this.attachmentHelper.getSelectedAttachments());
    }

    public void onAddAttachmentsRequested() {
        if (!this.imageStream.uh()) {
            this.attachmentHelper.showImagePicker(this.activity);
        } else {
            this.imageStream.dismiss();
        }
    }

    public void onDismissed() {
        this.messageComposerView.requestFocusForInput();
    }

    public void onMediaDeselected(List<MediaResult> list) {
        this.dispatcher.dispatch(this.actionFactory.deselectAttachment(list));
        if (!this.imageStream.uh()) {
            onAddAttachmentsRequested();
        }
    }

    public void onMediaSelected(List<MediaResult> list) {
        this.dispatcher.dispatch(this.actionFactory.selectAttachment(list));
        if (!this.imageStream.uh()) {
            onAddAttachmentsRequested();
        }
    }

    public void onSendMessageRequested(String str) {
        if (this.imageStream.uh()) {
            this.imageStream.dismiss();
        }
        this.dispatcher.dispatch(this.actionFactory.createCommentAsync(str, this.attachmentHelper.getSelectedAttachments()));
        this.dispatcher.dispatch(this.actionFactory.clearAttachments());
        this.dispatcher.dispatch(this.actionFactory.updateCommentsAsync());
    }

    public void onVisible() {
        this.messageComposerView.post(new Runnable() {
            public void run() {
                ComponentMessageComposer.this.messageComposerView.triggerStateUpdate();
            }
        });
    }

    public void update(MessageComposerModel messageComposerModel) {
        this.attachmentHelper.updateMaxFileSize(messageComposerModel.getMaxFileSize());
        this.attachmentHelper.updateAttachments(messageComposerModel.getRequestAttachments(), messageComposerModel.getExtraAttachments());
        this.messageComposerView.setAttachmentsCount(messageComposerModel.getRequestAttachments().size());
        this.messageComposerView.enableSendButton(messageComposerModel.isSendButtonEnabled());
        this.messageComposerView.enableAttachmentsButton(messageComposerModel.isAttachmentsButtonEnabled());
        this.messageComposerView.hide(!messageComposerModel.isMessageComposerVisible());
        if (!messageComposerModel.isMessageComposerVisible()) {
            UiUtils.dismissKeyboard((View) this.messageComposerView);
        }
    }
}
