package zendesk.support.request;

import android.app.Activity;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$string;
import zendesk.support.request.StateError;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.Listener;
import zendesk.support.suas.State;
import zendesk.support.suas.StateSelector;

class ComponentError implements Listener<ErrorStateModel> {
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public final ActionFactory f62978af;
    private final CoordinatorLayout container;
    /* access modifiers changed from: private */
    public final Dispatcher dispatcher;
    /* access modifiers changed from: private */
    public StateError.ErrorType errorState;
    private Snackbar snackbar;

    /* renamed from: zendesk.support.request.ComponentError$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$zendesk$support$request$StateError$ErrorType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                zendesk.support.request.StateError$ErrorType[] r0 = zendesk.support.request.StateError.ErrorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$zendesk$support$request$StateError$ErrorType = r0
                zendesk.support.request.StateError$ErrorType r1 = zendesk.support.request.StateError.ErrorType.InitialGetComments     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$support$request$StateError$ErrorType     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.support.request.StateError$ErrorType r1 = zendesk.support.request.StateError.ErrorType.InputFormSubmission     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.support.request.ComponentError.AnonymousClass2.<clinit>():void");
        }
    }

    public static class ErrorStateModel {
        private final boolean conversationsEnabled;
        private final String errorMessage;
        /* access modifiers changed from: private */
        public final StateError.ErrorType errorState;

        public ErrorStateModel(StateError.ErrorType errorType, String str, boolean z11) {
            this.errorState = errorType;
            this.errorMessage = str;
            this.conversationsEnabled = z11;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public StateError.ErrorType getErrorState() {
            return this.errorState;
        }

        public boolean isConversationsEnabled() {
            return this.conversationsEnabled;
        }
    }

    public static class ErrorStateSelector implements StateSelector<ErrorStateModel> {
        public ErrorStateModel selectData(State state) {
            StateError fromState = StateError.fromState(state);
            return new ErrorStateModel(fromState.getState(), fromState.getMessage(), StateConfig.fromState(state).getSettings().isConversationsEnabled());
        }
    }

    private ComponentError(CoordinatorLayout coordinatorLayout, Dispatcher dispatcher2, ActionFactory actionFactory) {
        this.container = coordinatorLayout;
        this.dispatcher = dispatcher2;
        this.f62978af = actionFactory;
    }

    public static ComponentError create(Activity activity, Dispatcher dispatcher2, ActionFactory actionFactory) {
        return new ComponentError((CoordinatorLayout) activity.findViewById(R$id.activity_request), dispatcher2, actionFactory);
    }

    public static StateSelector<ErrorStateModel> getSelector() {
        return new ErrorStateSelector();
    }

    public void update(ErrorStateModel errorStateModel) {
        if (errorStateModel.errorState != this.errorState) {
            this.errorState = errorStateModel.errorState;
            if (errorStateModel.errorState != StateError.ErrorType.NoError) {
                this.snackbar = Snackbar.make((View) this.container, (CharSequence) errorStateModel.getErrorMessage(), -2);
                int i11 = AnonymousClass2.$SwitchMap$zendesk$support$request$StateError$ErrorType[errorStateModel.getErrorState().ordinal()];
                if (i11 == 1) {
                    this.snackbar.setText(R$string.request_error_load_comments);
                    this.snackbar.setAction(R$string.retry_view_button_label, (View.OnClickListener) new View.OnClickListener() {
                        @SensorsDataInstrumented
                        public void onClick(View view) {
                            StateError.ErrorType unused = ComponentError.this.errorState = StateError.ErrorType.NoError;
                            ComponentError.this.dispatcher.dispatch(ComponentError.this.f62978af.initialLoadCommentsAsync());
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        }
                    });
                    this.snackbar.show();
                } else if (i11 == 2 && !errorStateModel.isConversationsEnabled()) {
                    this.snackbar.setText(R$string.request_error_create_request);
                    this.snackbar.show();
                }
            } else {
                Snackbar snackbar2 = this.snackbar;
                if (snackbar2 != null) {
                    snackbar2.dismiss();
                }
            }
        }
    }
}
