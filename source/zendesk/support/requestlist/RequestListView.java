package zendesk.support.requestlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import com.zendesk.logger.Logger;
import com.zendesk.sdk.R$attr;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import java.util.List;
import mz.a;
import mz.f;
import v1.k;
import zendesk.support.UiUtils;
import zendesk.support.request.RequestConfiguration;
import zendesk.support.request.ViewAlmostRealProgressBar;

@SuppressLint({"ViewConstructor"})
class RequestListView extends FrameLayout {
    private static final String IS_SHOWING_SNACKBAR_KEY = "is_showing_snackbar";
    private static final String REQUEST_LIST_VIEW_SUPERSTATE_KEY = "request_list_view_superstate";
    private final AppCompatActivity activity;
    private final RequestListAdapter adapter;
    private final RequestListConfiguration config;
    private final FloatingActionButton createTicketFab;
    private final k emptyScene;
    private final Fade fade = new Fade();
    private boolean isLoading = false;
    private boolean isStopped = true;
    /* access modifiers changed from: private */
    public OnItemClick itemClickListener = null;
    private final k listScene;
    private final View listSceneView;
    private final View logoImage;
    private final View logoImageEmpty;
    private final ViewAlmostRealProgressBar progressBar;
    private final RecyclerView recyclerView;
    private View.OnClickListener retryClickListener = null;
    private final ViewGroup rootLayout;
    private final ViewGroup sceneRoot;
    private SceneState sceneState = SceneState.NONE;
    public Snackbar snackbar;
    private final View startConversationButton;
    private final SwipeRefreshLayout swipeRefreshLayout;
    private final SwipeRefreshLayout swipeRefreshLayoutEmpty;
    private final Toolbar toolbar;

    public interface OnItemClick {
        void onClick(RequestListItem requestListItem);
    }

    public enum SceneState {
        LIST,
        EMPTY,
        NONE
    }

    public RequestListView(AppCompatActivity appCompatActivity, RequestListConfiguration requestListConfiguration, Picasso picasso) {
        super(appCompatActivity);
        this.activity = appCompatActivity;
        this.config = requestListConfiguration;
        setId(R$id.request_list_view);
        FrameLayout.inflate(appCompatActivity, R$layout.zs_activity_request_list, this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.request_list_scene_root);
        this.sceneRoot = viewGroup;
        LayoutInflater from = LayoutInflater.from(appCompatActivity);
        View inflate = from.inflate(R$layout.zs_activity_request_list_scene_data, viewGroup, false);
        this.listSceneView = inflate;
        View inflate2 = from.inflate(R$layout.zs_activity_request_list_scene_empty, viewGroup, false);
        this.listScene = new k(viewGroup, inflate);
        this.emptyScene = new k(viewGroup, inflate2);
        this.progressBar = (ViewAlmostRealProgressBar) findViewById(R$id.request_list_progressBar);
        this.toolbar = (Toolbar) findViewById(R$id.request_list_toolbar);
        this.rootLayout = (ViewGroup) findViewById(R$id.request_list_coordinator_layout);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R$id.request_list_create_new_ticket_fab);
        this.createTicketFab = floatingActionButton;
        this.logoImage = inflate.findViewById(R$id.request_list_zendesk_logo);
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R$id.request_list_recycler);
        this.recyclerView = recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) inflate.findViewById(R$id.request_list_swipe_refresh_layout);
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.startConversationButton = inflate2.findViewById(R$id.request_list_empty_start_conversation);
        SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) inflate2.findViewById(R$id.request_list_swipe_refresh_layout_empty);
        this.swipeRefreshLayoutEmpty = swipeRefreshLayout3;
        this.logoImageEmpty = inflate2.findViewById(R$id.request_list_zendesk_logo_empty);
        RequestListAdapter requestListAdapter = new RequestListAdapter(new OnItemClick() {
            public void onClick(RequestListItem requestListItem) {
                if (RequestListView.this.itemClickListener != null) {
                    RequestListView.this.itemClickListener.onClick(requestListItem);
                }
            }
        }, picasso);
        this.adapter = requestListAdapter;
        recyclerView2.setAdapter(requestListAdapter);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(appCompatActivity, 1, false));
        recyclerView2.addItemDecoration(new h(appCompatActivity, 1));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        floatingActionButton.hide();
        View findViewById = findViewById(R$id.request_list_compat_shadow);
        ((ViewGroup) findViewById.getParent()).removeView(findViewById);
        int themeAttributeToColor = UiUtils.themeAttributeToColor(R$attr.colorAccent, getContext(), R$color.zs_color_black);
        swipeRefreshLayout2.setColorSchemeColors(themeAttributeToColor);
        swipeRefreshLayout3.setColorSchemeColors(themeAttributeToColor);
    }

    private void dismissSnackbar() {
        Snackbar snackbar2 = this.snackbar;
        if (snackbar2 != null) {
            snackbar2.dismiss();
        }
        this.snackbar = null;
    }

    private boolean isShowingSnackBar() {
        Snackbar snackbar2 = this.snackbar;
        return snackbar2 != null && snackbar2.isShownOrQueued();
    }

    public void announceAccessibility(int i11) {
        announceForAccessibility(getResources().getString(i11));
    }

    public void finish(String str) {
        if (f.c(str)) {
            Logger.b(RequestListActivity.LOG_TAG, str, new Object[0]);
        }
        finish();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            boolean z11 = bundle.getBoolean(IS_SHOWING_SNACKBAR_KEY);
            parcelable = bundle.getParcelable(REQUEST_LIST_VIEW_SUPERSTATE_KEY);
            if (z11) {
                showErrorMessage();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(REQUEST_LIST_VIEW_SUPERSTATE_KEY, super.onSaveInstanceState());
        bundle.putBoolean(IS_SHOWING_SNACKBAR_KEY, isShowingSnackBar());
        return bundle;
    }

    public void onStart() {
        this.isStopped = false;
    }

    public void onStop() {
        this.isStopped = true;
        dismissSnackbar();
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        this.toolbar.setNavigationOnClickListener(onClickListener);
    }

    public void setCreateRequestListener(View.OnClickListener onClickListener) {
        this.createTicketFab.setOnClickListener(onClickListener);
        this.startConversationButton.setOnClickListener(onClickListener);
    }

    public void setItemClickListener(OnItemClick onItemClick) {
        this.itemClickListener = onItemClick;
    }

    public void setLoading(boolean z11) {
        dismissSnackbar();
        if (this.isLoading != z11) {
            if (z11) {
                if (!this.swipeRefreshLayout.i() && !this.swipeRefreshLayoutEmpty.i()) {
                    announceAccessibility(R$string.zs_request_list_content_loading_accessibility);
                    this.progressBar.start(ViewAlmostRealProgressBar.DONT_STOP_MOVING);
                }
            } else if (this.swipeRefreshLayout.i() || this.swipeRefreshLayoutEmpty.i()) {
                this.swipeRefreshLayout.setRefreshing(false);
                this.swipeRefreshLayoutEmpty.setRefreshing(false);
            } else {
                this.progressBar.stop(300);
            }
        }
        this.isLoading = z11;
    }

    public void setLogoClickListener(boolean z11, View.OnClickListener onClickListener) {
        int i11;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 4;
            onClickListener = null;
        }
        this.logoImage.setVisibility(i11);
        this.logoImageEmpty.setVisibility(i11);
        this.logoImage.setOnClickListener(onClickListener);
        this.logoImageEmpty.setOnClickListener(onClickListener);
    }

    public void setRetryClickListener(View.OnClickListener onClickListener) {
        this.retryClickListener = onClickListener;
    }

    public void setSwipeRefreshListener(SwipeRefreshLayout.j jVar) {
        this.swipeRefreshLayout.setOnRefreshListener(jVar);
        this.swipeRefreshLayoutEmpty.setOnRefreshListener(jVar);
    }

    public void showErrorMessage() {
        if (!this.isStopped && !isShowingSnackBar()) {
            announceAccessibility(R$string.zs_request_list_content_load_failed_accessibility);
            Snackbar action = Snackbar.make((View) this.rootLayout, R$string.request_list_error_message, -2).setAction(R$string.zendesk_retry_button_label, this.retryClickListener);
            this.snackbar = action;
            action.show();
        }
    }

    public void showRequestList(List<RequestListItem> list) {
        dismissSnackbar();
        this.progressBar.stop(300);
        if (a.g(list)) {
            SceneState sceneState2 = this.sceneState;
            SceneState sceneState3 = SceneState.EMPTY;
            if (sceneState2 != sceneState3) {
                this.createTicketFab.hide();
                TransitionManager.f(this.emptyScene, this.fade);
                announceAccessibility(R$string.zs_request_list_content_loaded_empty_accessibility);
                this.sceneState = sceneState3;
                return;
            }
            return;
        }
        this.adapter.swapRequests(list);
        this.progressBar.stop(300);
        SceneState sceneState4 = this.sceneState;
        SceneState sceneState5 = SceneState.LIST;
        if (sceneState4 != sceneState5) {
            if (this.config.isContactUsButtonVisible()) {
                this.createTicketFab.show();
            } else {
                this.createTicketFab.hide();
            }
            if (this.listSceneView.getParent() == null) {
                TransitionManager.f(this.listScene, this.fade);
            }
            announceAccessibility(R$string.zs_request_list_content_loaded_accessibility);
            this.sceneState = sceneState5;
        }
    }

    public void startReferrerPage(String str) {
        this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void startRequestActivity(RequestConfiguration.Builder builder) {
        builder.show((Context) this.activity, this.config.getConfigurations());
    }

    public void finish() {
        if (!this.activity.isFinishing()) {
            this.activity.finish();
        }
    }
}
