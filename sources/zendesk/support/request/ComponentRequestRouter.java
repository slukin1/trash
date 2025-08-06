package zendesk.support.request;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.zendesk.logger.Logger;
import com.zendesk.sdk.R$id;
import java.util.concurrent.atomic.AtomicReference;
import mz.f;
import zendesk.support.request.StateError;
import zendesk.support.suas.Listener;
import zendesk.support.suas.State;
import zendesk.support.suas.StateSelector;

class ComponentRequestRouter implements Listener<RequestScreen> {
    private final AppCompatActivity activity;
    private final RequestComponent component;
    private RequestView currentScreen;
    private final RequestViewConversationsDisabled disabledView;
    private final RequestViewConversationsEnabled enabledView;
    private final boolean isCleanStart;
    private final RequestViewLoading loadingView;
    private final ViewGroup root;
    private final AtomicReference<RequestScreen> screen = new AtomicReference<>();

    /* renamed from: zendesk.support.request.ComponentRequestRouter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$zendesk$support$request$ComponentRequestRouter$RequestScreen;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                zendesk.support.request.ComponentRequestRouter$RequestScreen[] r0 = zendesk.support.request.ComponentRequestRouter.RequestScreen.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$zendesk$support$request$ComponentRequestRouter$RequestScreen = r0
                zendesk.support.request.ComponentRequestRouter$RequestScreen r1 = zendesk.support.request.ComponentRequestRouter.RequestScreen.Loading     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$support$request$ComponentRequestRouter$RequestScreen     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.support.request.ComponentRequestRouter$RequestScreen r1 = zendesk.support.request.ComponentRequestRouter.RequestScreen.EmailForm     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$zendesk$support$request$ComponentRequestRouter$RequestScreen     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.support.request.ComponentRequestRouter$RequestScreen r1 = zendesk.support.request.ComponentRequestRouter.RequestScreen.Conversation     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$zendesk$support$request$ComponentRequestRouter$RequestScreen     // Catch:{ NoSuchFieldError -> 0x0033 }
                zendesk.support.request.ComponentRequestRouter$RequestScreen r1 = zendesk.support.request.ComponentRequestRouter.RequestScreen.Fin     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.support.request.ComponentRequestRouter.AnonymousClass1.<clinit>():void");
        }
    }

    public static class RequestRouterSelector implements StateSelector<RequestScreen> {
        public RequestScreen selectData(State state) {
            StateConfig fromState = StateConfig.fromState(state);
            StateConversation fromState2 = StateConversation.fromState(state);
            StateSettings settings = fromState.getSettings();
            StateError fromState3 = StateError.fromState(state);
            boolean hasSettings = settings.hasSettings();
            boolean c11 = f.c(fromState2.getRemoteId());
            boolean isConversationsEnabled = settings.isConversationsEnabled();
            boolean hasIdentityEmailAddress = settings.hasIdentityEmailAddress();
            boolean isNeverRequestEmailOn = settings.isNeverRequestEmailOn();
            if (fromState3.getState() == StateError.ErrorType.NoAccess) {
                Logger.d(RequestActivity.LOG_TAG, "Network returned 'No Access'. Ticket is not longer valid. Error: '%s'", fromState3.getMessage());
                return RequestScreen.Fin;
            } else if (!hasSettings) {
                return RequestScreen.Loading;
            } else {
                if (isConversationsEnabled) {
                    return RequestScreen.Conversation;
                }
                if (c11) {
                    Logger.l(RequestActivity.LOG_TAG, "Conversations are disabled. Exiting RequestActivity", new Object[0]);
                    return RequestScreen.Fin;
                } else if (hasIdentityEmailAddress || !isNeverRequestEmailOn) {
                    return RequestScreen.EmailForm;
                } else {
                    Logger.l(RequestActivity.LOG_TAG, "Conversations are disabled, never request email is enabled, with this configuration tickets would go into a black hole. Exiting RequestActivity.", new Object[0]);
                    return RequestScreen.Fin;
                }
            }
        }
    }

    public enum RequestScreen {
        Loading,
        EmailForm,
        Conversation,
        Fin
    }

    public ComponentRequestRouter(AppCompatActivity appCompatActivity, ViewGroup viewGroup, RequestViewConversationsDisabled requestViewConversationsDisabled, RequestViewConversationsEnabled requestViewConversationsEnabled, RequestViewLoading requestViewLoading, RequestComponent requestComponent, boolean z11) {
        this.activity = appCompatActivity;
        this.root = viewGroup;
        this.disabledView = requestViewConversationsDisabled;
        this.enabledView = requestViewConversationsEnabled;
        this.loadingView = requestViewLoading;
        this.component = requestComponent;
        this.isCleanStart = z11;
    }

    public static ComponentRequestRouter create(AppCompatActivity appCompatActivity, boolean z11, RequestComponent requestComponent) {
        return new ComponentRequestRouter(appCompatActivity, (ViewGroup) appCompatActivity.findViewById(R$id.activity_request_root), (RequestViewConversationsDisabled) appCompatActivity.findViewById(R$id.activity_request_conversation_disabled), (RequestViewConversationsEnabled) appCompatActivity.findViewById(R$id.activity_request_conversation), (RequestViewLoading) appCompatActivity.findViewById(R$id.activity_request_loading), requestComponent, z11);
    }

    private void displayView(View view, View... viewArr) {
        TransitionManager.b(this.root, new Fade());
        view.setVisibility(0);
        for (View visibility : viewArr) {
            visibility.setVisibility(8);
        }
        this.activity.invalidateOptionsMenu();
        TransitionManager.d(this.root);
    }

    public RequestView getCurrentScreen() {
        return this.currentScreen;
    }

    public StateSelector<RequestScreen> getSelector() {
        return new RequestRouterSelector();
    }

    public void update(RequestScreen requestScreen) {
        if (this.screen.getAndSet(requestScreen) != requestScreen) {
            int i11 = AnonymousClass1.$SwitchMap$zendesk$support$request$ComponentRequestRouter$RequestScreen[requestScreen.ordinal()];
            if (i11 == 1) {
                Logger.b(RequestActivity.LOG_TAG, "Installing screen: 'Loading Screen'", new Object[0]);
                RequestViewLoading requestViewLoading = this.loadingView;
                this.currentScreen = requestViewLoading;
                displayView(requestViewLoading, this.disabledView, this.enabledView);
            } else if (i11 == 2) {
                Logger.b(RequestActivity.LOG_TAG, "Installing screen: 'Conversations Disabled Screen'", new Object[0]);
                RequestViewConversationsDisabled requestViewConversationsDisabled = this.disabledView;
                this.currentScreen = requestViewConversationsDisabled;
                displayView(requestViewConversationsDisabled, this.enabledView, this.loadingView);
                this.disabledView.init(this.component);
            } else if (i11 == 3) {
                Logger.b(RequestActivity.LOG_TAG, "Installing screen: 'Conversations Enabled Screen'", new Object[0]);
                RequestViewConversationsEnabled requestViewConversationsEnabled = this.enabledView;
                this.currentScreen = requestViewConversationsEnabled;
                displayView(requestViewConversationsEnabled, this.disabledView, this.loadingView);
                this.enabledView.init(this.component, this.isCleanStart);
            } else if (i11 == 4) {
                Logger.b(RequestActivity.LOG_TAG, "Installing screen: 'Finish'", new Object[0]);
                this.activity.finish();
            }
        }
    }
}
