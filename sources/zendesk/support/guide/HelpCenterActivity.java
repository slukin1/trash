package zendesk.support.guide;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.guide.sdk.R$id;
import com.zendesk.guide.sdk.R$layout;
import com.zendesk.guide.sdk.R$menu;
import com.zendesk.guide.sdk.R$string;
import com.zendesk.guide.sdk.R$style;
import com.zendesk.logger.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mz.a;
import zendesk.classic.messaging.MessagingActivity;
import zendesk.classic.messaging.c;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.NetworkInfoProvider;
import zendesk.core.RetryAction;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSettingsProvider;
import zendesk.support.SearchArticle;
import zendesk.support.guide.HelpCenterConfiguration;

public class HelpCenterActivity extends AppCompatActivity implements HelpCenterMvp$View {
    public static final String LOG_TAG = "HelpCenterActivity";
    public ActionHandlerRegistry actionHandlerRegistry;
    public ConfigurationHelper configurationHelper;
    private FloatingActionButton contactUsButton;
    private MenuItem conversationsMenuItem;
    private List<c> engines;
    /* access modifiers changed from: private */
    public Snackbar errorSnackbar;
    private HelpCenterConfiguration helpCenterConfiguration;
    public HelpCenterProvider helpCenterProvider;
    private View loadingView;
    public NetworkInfoProvider networkInfoProvider;
    /* access modifiers changed from: private */
    public HelpCenterMvp$Presenter presenter;
    private MenuItem searchViewMenuItem;
    public HelpCenterSettingsProvider settingsProvider;
    /* access modifiers changed from: private */
    public SnackbarStatus snackbarStatus = SnackbarStatus.NONE;

    /* renamed from: zendesk.support.guide.HelpCenterActivity$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$zendesk$support$guide$HelpCenterMvp$ErrorType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                zendesk.support.guide.HelpCenterMvp$ErrorType[] r0 = zendesk.support.guide.HelpCenterMvp$ErrorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$zendesk$support$guide$HelpCenterMvp$ErrorType = r0
                zendesk.support.guide.HelpCenterMvp$ErrorType r1 = zendesk.support.guide.HelpCenterMvp$ErrorType.CATEGORY_LOAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$support$guide$HelpCenterMvp$ErrorType     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.support.guide.HelpCenterMvp$ErrorType r1 = zendesk.support.guide.HelpCenterMvp$ErrorType.SECTION_LOAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$zendesk$support$guide$HelpCenterMvp$ErrorType     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.support.guide.HelpCenterMvp$ErrorType r1 = zendesk.support.guide.HelpCenterMvp$ErrorType.ARTICLES_LOAD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.support.guide.HelpCenterActivity.AnonymousClass5.<clinit>():void");
        }
    }

    public enum SnackbarStatus {
        NO_CONNECTION,
        NONE,
        CONTENT_ERROR
    }

    private void addFragment(Fragment fragment) {
        getSupportFragmentManager().q().c(R$id.fragment_container, fragment, fragment.getClass().getSimpleName()).j();
    }

    private void addOnBackStackChangedListener() {
        getSupportFragmentManager().l(new FragmentManager.m() {
            public /* bridge */ /* synthetic */ void onBackStackChangeCommitted(Fragment fragment, boolean z11) {
                x.a(this, fragment, z11);
            }

            public /* bridge */ /* synthetic */ void onBackStackChangeStarted(Fragment fragment, boolean z11) {
                x.b(this, fragment, z11);
            }

            public void onBackStackChanged() {
                if (HelpCenterActivity.this.getCurrentFragment().isHidden()) {
                    HelpCenterActivity.this.getSupportFragmentManager().q().A(HelpCenterActivity.this.getCurrentFragment()).j();
                    if (HelpCenterActivity.this.getCurrentFragment() instanceof HelpCenterFragment) {
                        ((HelpCenterFragment) HelpCenterActivity.this.getCurrentFragment()).setPresenter(HelpCenterActivity.this.presenter);
                    }
                }
            }
        });
    }

    public static HelpCenterConfiguration.Builder builder() {
        return new HelpCenterConfiguration.Builder();
    }

    /* access modifiers changed from: private */
    public Fragment getCurrentFragment() {
        return getSupportFragmentManager().l0(R$id.fragment_container);
    }

    private HelpSearchFragment getSearchFragment() {
        if (getCurrentFragment() instanceof HelpSearchFragment) {
            Logger.b(LOG_TAG, "showSearchResults: current fragment is a HelpSearchFragment", new Object[0]);
            return (HelpSearchFragment) getCurrentFragment();
        }
        HelpSearchFragment newInstance = HelpSearchFragment.newInstance(this.helpCenterConfiguration, this.helpCenterProvider);
        getSupportFragmentManager().q().t(R$id.fragment_container, newInstance).h((String) null).j();
        return newInstance;
    }

    private ActionBar initToolbar() {
        findViewById(R$id.support_compat_shadow).setVisibility(8);
        setSupportActionBar((Toolbar) findViewById(R$id.support_toolbar));
        return getSupportActionBar();
    }

    private boolean noFragmentAdded() {
        return getCurrentFragment() == null;
    }

    private void showCreateRequest(Map<String, Object> map) {
        ActionHandler handlerByAction = this.actionHandlerRegistry.handlerByAction("action_contact_option");
        if (handlerByAction != null) {
            ActionDescription actionDescription = handlerByAction.getActionDescription();
            Logger.b(LOG_TAG, "No Deflection ActionHandler Available, opening %s", actionDescription != null ? actionDescription.getLocalizedLabel() : handlerByAction.getClass().getSimpleName());
            handlerByAction.handle(map, this);
        }
    }

    public void announceContentLoaded() {
        this.contactUsButton.announceForAccessibility(getString(R$string.zs_help_center_content_loaded_accessibility));
    }

    public void clearSearchResults() {
        if (getCurrentFragment() instanceof HelpSearchFragment) {
            ((HelpSearchFragment) getCurrentFragment()).clearResults();
        }
    }

    public void dismissError() {
        Snackbar snackbar = this.errorSnackbar;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.snackbarStatus = SnackbarStatus.NONE;
    }

    public void exitActivity() {
        finish();
    }

    public Context getContext() {
        return getApplicationContext();
    }

    public void hideLoadingState() {
        this.loadingView.setVisibility(8);
    }

    public boolean isShowingHelp() {
        return getCurrentFragment() instanceof HelpCenterFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Resources.Theme theme = getTheme();
        theme.applyStyle(R$style.ZendeskActivityDefaultTheme, true);
        theme.applyStyle(R$style.ZendeskSupportActivityThemeDefaultIcon, false);
        setContentView(R$layout.zs_activity_help_center);
        GuideSdkDependencyProvider guideSdkDependencyProvider = GuideSdkDependencyProvider.INSTANCE;
        if (!guideSdkDependencyProvider.isInitialized()) {
            Logger.d(LOG_TAG, GuideSdkDependencyProvider.NOT_INITIALIZED_LOG, new Object[0]);
            finish();
            return;
        }
        guideSdkDependencyProvider.provideGuideSdkComponent().inject(this);
        HelpCenterConfiguration helpCenterConfiguration2 = (HelpCenterConfiguration) this.configurationHelper.f(getIntent().getExtras(), HelpCenterConfiguration.class);
        this.helpCenterConfiguration = helpCenterConfiguration2;
        if (helpCenterConfiguration2 == null) {
            Logger.d(LOG_TAG, "No configuration found. Please use HelpCenterActivity.builder()", new Object[0]);
            finish();
            return;
        }
        this.engines = helpCenterConfiguration2.getEngines();
        initToolbar().setDisplayHomeAsUpEnabled(true);
        this.loadingView = findViewById(R$id.loading_view);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R$id.contact_us_button);
        this.contactUsButton = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                HelpCenterActivity.this.showContactZendesk();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        HelpCenterPresenter helpCenterPresenter = new HelpCenterPresenter(this, new HelpCenterModel(this.helpCenterProvider, this.settingsProvider), this.networkInfoProvider, this.actionHandlerRegistry);
        this.presenter = helpCenterPresenter;
        helpCenterPresenter.init(this.helpCenterConfiguration, this.engines);
        addOnBackStackChangedListener();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.zs_fragment_help_menu_conversations, menu);
        this.conversationsMenuItem = menu.findItem(R$id.fragment_help_menu_contact);
        MenuItem findItem = menu.findItem(R$id.fragment_help_menu_search);
        this.searchViewMenuItem = findItem;
        if (findItem == null) {
            return true;
        }
        if (!this.networkInfoProvider.isNetworkAvailable()) {
            this.searchViewMenuItem.setEnabled(false);
        }
        SearchView searchView = (SearchView) this.searchViewMenuItem.getActionView();
        searchView.setImeOptions(searchView.getImeOptions() | 268435456);
        searchView.setOnQueryTextListener(new SearchView.m() {
            public boolean onQueryTextChange(String str) {
                return false;
            }

            public boolean onQueryTextSubmit(String str) {
                if (HelpCenterActivity.this.presenter == null) {
                    return false;
                }
                HelpCenterActivity.this.presenter.onSearchSubmit(str);
                return true;
            }
        });
        return true;
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (itemId == R$id.fragment_help_menu_contact) {
            showRequestList();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else {
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return false;
        }
    }

    public void onPause() {
        super.onPause();
        HelpCenterMvp$Presenter helpCenterMvp$Presenter = this.presenter;
        if (helpCenterMvp$Presenter != null) {
            helpCenterMvp$Presenter.onPause();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem;
        HelpCenterMvp$Presenter helpCenterMvp$Presenter = this.presenter;
        if (!(helpCenterMvp$Presenter == null || (menuItem = this.searchViewMenuItem) == null)) {
            menuItem.setVisible(helpCenterMvp$Presenter.shouldShowSearchMenuItem());
        }
        if (!(this.presenter == null || this.conversationsMenuItem == null)) {
            boolean z11 = true;
            boolean z12 = this.actionHandlerRegistry.handlerByAction("action_conversation_list") != null;
            MenuItem menuItem2 = this.conversationsMenuItem;
            if (!this.presenter.shouldShowConversationsMenuItem() || !z12) {
                z11 = false;
            }
            menuItem2.setVisible(z11);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void onResume() {
        super.onResume();
        HelpCenterMvp$Presenter helpCenterMvp$Presenter = this.presenter;
        if (helpCenterMvp$Presenter != null) {
            helpCenterMvp$Presenter.onResume(this);
        }
    }

    public void onStart() {
        Snackbar snackbar;
        super.onStart();
        if (this.snackbarStatus != SnackbarStatus.NONE && (snackbar = this.errorSnackbar) != null) {
            snackbar.show();
        }
    }

    public void setSearchEnabled(boolean z11) {
        this.searchViewMenuItem.setEnabled(z11);
    }

    public void showContactUsButton() {
        this.contactUsButton.setVisibility(0);
    }

    public void showContactZendesk() {
        HashMap hashMap = new HashMap();
        this.configurationHelper.d(hashMap, this.helpCenterConfiguration);
        if (a.i(this.engines)) {
            MessagingActivity.Af().k(this.engines).j(this, this.helpCenterConfiguration.getConfigurations());
        } else {
            showCreateRequest(hashMap);
        }
    }

    public void showHelp(HelpCenterConfiguration helpCenterConfiguration2) {
        if (noFragmentAdded()) {
            HelpCenterFragment newInstance = HelpCenterFragment.newInstance(helpCenterConfiguration2);
            newInstance.setPresenter(this.presenter);
            addFragment(newInstance);
        } else if (getCurrentFragment() instanceof HelpCenterFragment) {
            ((HelpCenterFragment) getCurrentFragment()).setPresenter(this.presenter);
        }
        invalidateOptionsMenu();
    }

    public void showLoadArticleErrorWithRetry(HelpCenterMvp$ErrorType helpCenterMvp$ErrorType, final RetryAction retryAction) {
        String str;
        if (helpCenterMvp$ErrorType == null) {
            Logger.l(LOG_TAG, "ErrorType was null, falling back to 'retry' as label", new Object[0]);
            str = getString(R$string.zui_retry_button_label);
        } else {
            int i11 = AnonymousClass5.$SwitchMap$zendesk$support$guide$HelpCenterMvp$ErrorType[helpCenterMvp$ErrorType.ordinal()];
            if (i11 == 1) {
                str = getString(R$string.support_categories_list_fragment_error_message);
            } else if (i11 == 2) {
                str = getString(R$string.support_sections_list_fragment_error_message);
            } else if (i11 != 3) {
                Logger.l(LOG_TAG, "Unknown or unhandled error type, falling back to error type name as label", new Object[0]);
                str = getString(R$string.support_help_search_no_results_label) + " " + helpCenterMvp$ErrorType.name();
            } else {
                str = getString(R$string.support_articles_list_fragment_error_message);
            }
        }
        if (this.snackbarStatus == SnackbarStatus.NONE) {
            Snackbar make = Snackbar.make((View) this.contactUsButton, (CharSequence) str, -2);
            this.errorSnackbar = make;
            make.setAction(R$string.zui_retry_button_label, (View.OnClickListener) new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    HelpCenterActivity.this.errorSnackbar.dismiss();
                    SnackbarStatus unused = HelpCenterActivity.this.snackbarStatus = SnackbarStatus.NONE;
                    retryAction.onRetry();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            this.errorSnackbar.show();
            this.snackbarStatus = SnackbarStatus.CONTENT_ERROR;
        }
    }

    public void showLoadingState() {
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment != null && currentFragment.isVisible()) {
            getSupportFragmentManager().q().q(getCurrentFragment()).j();
        }
        this.loadingView.setVisibility(0);
    }

    public void showNoConnectionError() {
        SnackbarStatus snackbarStatus2 = this.snackbarStatus;
        SnackbarStatus snackbarStatus3 = SnackbarStatus.NO_CONNECTION;
        if (snackbarStatus2 != snackbarStatus3) {
            Snackbar make = Snackbar.make((View) this.contactUsButton, R$string.zg_general_no_connection_message, -2);
            this.errorSnackbar = make;
            make.show();
            this.snackbarStatus = snackbarStatus3;
        }
    }

    public void showRequestList() {
        ActionHandler handlerByAction = this.actionHandlerRegistry.handlerByAction("action_conversation_list");
        if (handlerByAction != null) {
            HashMap hashMap = new HashMap();
            this.configurationHelper.d(hashMap, this.helpCenterConfiguration);
            handlerByAction.handle(hashMap, this);
        }
    }

    public void showSearchResults(List<SearchArticle> list, String str) {
        getSearchFragment().updateResults(list, str);
    }
}
