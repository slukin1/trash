package zendesk.support.request;

import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.sdk.R$id;
import java.util.Collection;
import java.util.List;
import zendesk.belvedere.ImageStream;
import zendesk.belvedere.MediaResult;
import zendesk.support.request.RequestViewConversationsDisabled;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.Listener;
import zendesk.support.suas.State;
import zendesk.support.suas.StateSelector;

class ComponentAttachmentCarousel implements ImageStream.b, Listener<AttachmentCarouselModel>, RequestViewConversationsDisabled.MenuItemsDelegate {
    private final ActionFactory actionFactory;
    private final AppCompatActivity activity;
    private MenuItem attachmentButton;
    private final AttachmentHelper attachmentHelper;
    private boolean attachmentSupportEnabled = false;
    private final Dispatcher dispatcher;
    private final ImageStream imageStream;
    private final RecyclerView recyclerView;
    /* access modifiers changed from: private */
    public final ScrollView scrollView;
    private final StateSelector<AttachmentCarouselModel> selector;

    public static class AttachmentCarouselModel {
        private final Collection<StateRequestAttachment> additionalAttachments;
        private final boolean isAttachmentSupportEnabled;
        private final boolean isLoading;
        private final long maxAttachmentSize;
        private final Collection<StateRequestAttachment> selectedAttachments;

        public AttachmentCarouselModel(Collection<StateRequestAttachment> collection, Collection<StateRequestAttachment> collection2, boolean z11, boolean z12, long j11) {
            this.selectedAttachments = collection;
            this.additionalAttachments = collection2;
            this.isLoading = z11;
            this.isAttachmentSupportEnabled = z12;
            this.maxAttachmentSize = j11;
        }

        public Collection<StateRequestAttachment> getAdditionalAttachments() {
            return this.additionalAttachments;
        }

        public long getMaxAttachmentSize() {
            return this.maxAttachmentSize;
        }

        public Collection<StateRequestAttachment> getSelectedAttachments() {
            return this.selectedAttachments;
        }

        public boolean isAttachmentSupportEnabled() {
            return this.isAttachmentSupportEnabled;
        }

        public boolean isLoading() {
            return this.isLoading;
        }
    }

    public static class AttachmentCarouselSelector implements StateSelector<AttachmentCarouselModel> {
        public AttachmentCarouselModel selectData(State state) {
            StateAttachments fromState = StateAttachments.fromState(state);
            StateConfig fromState2 = StateConfig.fromState(state);
            return new AttachmentCarouselModel(fromState.getSelectedAttachments(), fromState.getAllSelectedAttachments(), StateProgress.fomState(state).getRunningRequests() > 0, fromState2.getSettings().isAttachmentsEnabled(), fromState2.getSettings().getMaxAttachmentSize());
        }
    }

    public ComponentAttachmentCarousel(Dispatcher dispatcher2, ActionFactory actionFactory2, ImageStream imageStream2, AppCompatActivity appCompatActivity, AttachmentHelper attachmentHelper2, RecyclerView recyclerView2) {
        this.dispatcher = dispatcher2;
        this.actionFactory = actionFactory2;
        this.imageStream = imageStream2;
        this.activity = appCompatActivity;
        this.attachmentHelper = attachmentHelper2;
        this.recyclerView = recyclerView2;
        this.scrollView = (ScrollView) appCompatActivity.findViewById(R$id.request_conversations_disabled_scrollview);
        this.selector = new AttachmentCarouselSelector();
        initImagePicker();
    }

    private void attachmentButtonVisibility(boolean z11, boolean z12) {
        MenuItem menuItem = this.attachmentButton;
        if (menuItem != null) {
            menuItem.setVisible(z11);
            this.attachmentButton.getActionView().setEnabled(z12);
        }
    }

    private void attachmentCount(int i11) {
        MenuItem menuItem = this.attachmentButton;
        if (menuItem != null) {
            ((ViewCellAttachmentMenuItem) menuItem.getActionView()).setBadgeCount(i11);
        }
    }

    private void initImagePicker() {
        this.imageStream.qh(this);
        if (this.imageStream.sh().getInputTrap().hasFocus()) {
            this.scrollView.requestFocus();
        }
        if (this.imageStream.Eh()) {
            this.scrollView.post(new Runnable() {
                public void run() {
                    ComponentAttachmentCarousel.this.onAddAttachmentsRequested(true);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onAddAttachmentsRequested(boolean z11) {
        if (!this.imageStream.uh()) {
            this.attachmentHelper.showImagePicker(this.activity);
        } else if (z11) {
            this.imageStream.dismiss();
        }
    }

    private void scroll(final int i11) {
        this.scrollView.post(new Runnable() {
            public void run() {
                ComponentAttachmentCarousel.this.scrollView.fullScroll(i11);
            }
        });
    }

    public StateSelector<AttachmentCarouselModel> getSelector() {
        return this.selector;
    }

    public void onDismissed() {
        this.scrollView.requestFocus();
        scroll(33);
    }

    public void onMediaDeselected(List<MediaResult> list) {
        this.dispatcher.dispatch(this.actionFactory.deselectAttachment(list));
        onAddAttachmentsRequested(false);
    }

    public void onMediaSelected(List<MediaResult> list) {
        this.dispatcher.dispatch(this.actionFactory.selectAttachment(list));
        onAddAttachmentsRequested(false);
    }

    public void onMenuItemsClicked(MenuItem menuItem) {
    }

    public void onMenuItemsInflated(MenuItem menuItem, MenuItem menuItem2) {
        this.attachmentButton = menuItem2;
        menuItem2.getActionView().setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ComponentAttachmentCarousel.this.onAddAttachmentsRequested(true);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        attachmentButtonVisibility(this.attachmentSupportEnabled, true);
    }

    public void onVisible() {
        scroll(130);
    }

    public void update(AttachmentCarouselModel attachmentCarouselModel) {
        boolean isAttachmentSupportEnabled = attachmentCarouselModel.isAttachmentSupportEnabled();
        this.attachmentSupportEnabled = isAttachmentSupportEnabled;
        attachmentButtonVisibility(isAttachmentSupportEnabled, !attachmentCarouselModel.isLoading());
        if (!attachmentCarouselModel.isLoading()) {
            this.attachmentHelper.updateAttachments(attachmentCarouselModel.getSelectedAttachments(), attachmentCarouselModel.getAdditionalAttachments());
            this.attachmentHelper.updateMaxFileSize(attachmentCarouselModel.getMaxAttachmentSize());
            attachmentCount(this.attachmentHelper.getSelectedAttachments().size());
            if (this.attachmentHelper.getSelectedAttachments().size() > 0) {
                scroll(130);
            } else {
                scroll(33);
            }
            this.recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
