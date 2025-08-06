package zendesk.support.request;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonElement;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import com.zendesk.logger.Logger;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import com.zendesk.sdk.R$style;
import h30.a;
import java.util.Map;
import zendesk.belvedere.BelvedereUi;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.SdkDependencyProvider;
import zendesk.support.request.RequestConfiguration;
import zendesk.support.suas.CombinedSubscription;
import zendesk.support.suas.State;
import zendesk.support.suas.Store;
import zendesk.support.suas.Subscription;

public class RequestActivity extends AppCompatActivity {
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "RequestActivity";
    private static final String SAVED_STATE = "saved_state";
    private RequestAccessibilityHerald accessibilityHerald;
    public ActionHandlerRegistry actionHandlerRegistry;

    /* renamed from: af  reason: collision with root package name */
    public ActionFactory f62979af;
    public HeadlessComponentListener headlessComponentListener;
    public Picasso picasso;
    private RefreshRequestActionHandler refreshActionHandler;
    private RequestComponent requestComponent;
    private ComponentRequestRouter requestRouter;
    public Store store;
    private Subscription subscription;

    public static class MoveUpWithSnackbarBehaviour extends AppBarLayout.ScrollingViewBehavior {
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return super.layoutDependsOn(coordinatorLayout, view, view2) || (view2 instanceof Snackbar.SnackbarLayout);
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean onDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!(view2 instanceof Snackbar.SnackbarLayout)) {
                return onDependentViewChanged;
            }
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), (int) Math.abs(Math.min(0.0f, view2.getTranslationY() - ((float) view2.getHeight()))));
            return true;
        }
    }

    public final class RefreshRequestActionHandler implements ActionHandler {
        private final String requestId;

        public RefreshRequestActionHandler(String str) {
            this.requestId = str;
        }

        public boolean canHandle(String str) {
            return str.contains("request_conversation_refresh") && str.contains(this.requestId);
        }

        public ActionDescription getActionDescription() {
            return null;
        }

        public int getPriority() {
            return 0;
        }

        public void handle(Map<String, Object> map, Context context) {
            RequestActivity requestActivity = RequestActivity.this;
            requestActivity.store.dispatch(requestActivity.f62979af.updateCommentsAsync());
        }

        public void updateSettings(Map<String, JsonElement> map) {
        }
    }

    private Subscription bindComponents(boolean z11) {
        ComponentToolbar bindToolbar = bindToolbar();
        ComponentError create = ComponentError.create(this, this.store, this.f62979af);
        this.requestRouter = ComponentRequestRouter.create(this, z11, this.requestComponent);
        this.accessibilityHerald = RequestAccessibilityHerald.create(this);
        return CombinedSubscription.from(this.store.addListener(bindToolbar.getToolbarSelector(), bindToolbar), this.store.addListener(this.requestRouter.getSelector(), this.requestRouter), this.store.addListener(ComponentError.getSelector(), create), this.store.addActionListener(this.accessibilityHerald));
    }

    @SuppressLint({"PrivateResource"})
    private ComponentToolbar bindToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R$id.activity_request_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                RequestActivity.this.onBackPressed();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        findViewById(R$id.activity_request_compat_toolbar_shadow).setVisibility(8);
        return new ComponentToolbar(this.picasso, toolbar, (ViewAlmostRealProgressBar) findViewById(R$id.activity_request_progressbar));
    }

    public static RequestConfiguration.Builder builder() {
        return new RequestConfiguration.Builder();
    }

    private void initViews() {
        ((CoordinatorLayout.LayoutParams) findViewById(R$id.activity_request_root).getLayoutParams()).o(new MoveUpWithSnackbarBehaviour());
    }

    private boolean initializeStoreAndDependencies(Bundle bundle, RequestConfiguration requestConfiguration) {
        if (!injectDependencies(requestConfiguration)) {
            State restoreState = restoreState(bundle);
            if (restoreState == null) {
                return true;
            }
            this.store.reset(restoreState);
        }
        return false;
    }

    private boolean injectDependencies(RequestConfiguration requestConfiguration) {
        boolean z11;
        RequestComponent requestComponent2 = (RequestComponent) HeadlessFragment.getData(getSupportFragmentManager());
        this.requestComponent = requestComponent2;
        if (requestComponent2 == null) {
            z11 = false;
            this.requestComponent = SdkDependencyProvider.INSTANCE.provideSupportSdkComponent().plus(new RequestModule(requestConfiguration));
            HeadlessFragment.install(getSupportFragmentManager(), this.requestComponent);
        } else {
            z11 = true;
        }
        this.requestComponent.inject(this);
        return z11;
    }

    private State restoreState(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(SAVED_STATE)) {
            return null;
        }
        return (State) bundle.getSerializable(SAVED_STATE);
    }

    public void onBackPressed() {
        RequestView currentScreen = this.requestRouter.getCurrentScreen();
        if (currentScreen == null || !currentScreen.hasUnsavedInput()) {
            super.onBackPressed();
        } else {
            new AlertDialog.a(this).setTitle(R$string.request_dialog_title_unsaved_changes).setMessage(R$string.request_dialog_body_unsaved_changes).setPositiveButton(R$string.request_dialog_button_label_delete, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    RequestActivity.super.onBackPressed();
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            }).setNegativeButton(R$string.request_dialog_button_label_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    dialogInterface.dismiss();
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            }).show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getTheme().applyStyle(R$style.ZendeskActivityDefaultTheme, true);
        setContentView(R$layout.zs_activity_request);
        BelvedereUi.c(this);
        initViews();
        if (!SdkDependencyProvider.INSTANCE.isInitialized()) {
            Logger.d(LOG_TAG, SdkDependencyProvider.NOT_INITIALIZED_LOG, new Object[0]);
            finish();
            return;
        }
        RequestConfiguration requestConfiguration = (RequestConfiguration) a.e(getIntent().getExtras(), RequestConfiguration.class);
        if (requestConfiguration == null) {
            Logger.d(LOG_TAG, "No configuration found. Please use RequestActivity.builder()", new Object[0]);
            finish();
            return;
        }
        this.refreshActionHandler = new RefreshRequestActionHandler(requestConfiguration.getRequestId());
        boolean initializeStoreAndDependencies = initializeStoreAndDependencies(bundle, requestConfiguration);
        if (initializeStoreAndDependencies) {
            this.headlessComponentListener.startListening(this.store);
            this.store.dispatch(this.f62979af.installStartConfigAsync(requestConfiguration));
            this.store.dispatch(this.f62979af.loadSettingsAsync());
        }
        this.subscription = bindComponents(initializeStoreAndDependencies);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        RequestView currentScreen = this.requestRouter.getCurrentScreen();
        return currentScreen != null && currentScreen.inflateMenu(getMenuInflater(), menu);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        RequestView currentScreen = this.requestRouter.getCurrentScreen();
        if (currentScreen != null) {
            boolean onOptionsItemClicked = currentScreen.onOptionsItemClicked(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemClicked;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    public void onPause() {
        super.onPause();
        Store store2 = this.store;
        if (store2 != null) {
            store2.dispatch(this.f62979af.androidOnPause());
        }
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.removeListener();
        }
        ActionHandlerRegistry actionHandlerRegistry2 = this.actionHandlerRegistry;
        if (actionHandlerRegistry2 != null) {
            actionHandlerRegistry2.remove(this.refreshActionHandler);
        }
    }

    public void onResume() {
        super.onResume();
        this.store.dispatch(this.f62979af.androidOnResume());
        this.subscription.addListener();
        this.subscription.informWithCurrentState();
        this.actionHandlerRegistry.add(this.refreshActionHandler);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(SAVED_STATE, this.store.getState());
        super.onSaveInstanceState(bundle);
    }
}
