package zendesk.support.guide;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zendesk.guide.sdk.R$drawable;
import com.zendesk.guide.sdk.R$id;
import com.zendesk.guide.sdk.R$layout;
import h30.a;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.HelpCenterProvider;

public class HelpCenterFragment extends Fragment {
    public static final String LOG_TAG = "HelpCenterFragment";
    private HelpRecyclerViewAdapter adapter;
    public HelpCenterProvider helpCenterProvider;
    public NetworkInfoProvider networkInfoProvider;
    private HelpCenterMvp$Presenter presenter;
    private RecyclerView recyclerView;

    @SuppressLint({"RestrictedApi"})
    public static HelpCenterFragment newInstance(HelpCenterConfiguration helpCenterConfiguration) {
        Bundle bundle = new Bundle();
        a.b(bundle, helpCenterConfiguration);
        HelpCenterFragment helpCenterFragment = new HelpCenterFragment();
        helpCenterFragment.setArguments(bundle);
        return helpCenterFragment;
    }

    private void setupRecyclerView() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.recyclerView.addItemDecoration(new SeparatorDecoration(ContextCompat.getDrawable(getContext(), R$drawable.zs_help_separator)));
        this.recyclerView.setAdapter(this.adapter);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        GuideSdkDependencyProvider guideSdkDependencyProvider = GuideSdkDependencyProvider.INSTANCE;
        if (guideSdkDependencyProvider.isInitialized()) {
            guideSdkDependencyProvider.provideGuideSdkComponent().inject(this);
            HelpRecyclerViewAdapter helpRecyclerViewAdapter = new HelpRecyclerViewAdapter((HelpCenterConfiguration) a.e(getArguments(), HelpCenterConfiguration.class), this.helpCenterProvider, this.networkInfoProvider);
            this.adapter = helpRecyclerViewAdapter;
            HelpCenterMvp$Presenter helpCenterMvp$Presenter = this.presenter;
            if (helpCenterMvp$Presenter != null) {
                helpRecyclerViewAdapter.setContentUpdateListener(helpCenterMvp$Presenter);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.zs_fragment_help, viewGroup, false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R$id.help_center_article_list);
        setupRecyclerView();
        return inflate;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setPresenter(HelpCenterMvp$Presenter helpCenterMvp$Presenter) {
        this.presenter = helpCenterMvp$Presenter;
        HelpRecyclerViewAdapter helpRecyclerViewAdapter = this.adapter;
        if (helpRecyclerViewAdapter != null) {
            helpRecyclerViewAdapter.setContentUpdateListener(helpCenterMvp$Presenter);
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
