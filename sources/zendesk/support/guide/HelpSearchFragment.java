package zendesk.support.guide;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zendesk.guide.sdk.R$id;
import com.zendesk.guide.sdk.R$layout;
import com.zendesk.guide.sdk.R$string;
import h30.a;
import java.util.Collections;
import java.util.List;
import zendesk.support.HelpCenterProvider;
import zendesk.support.SearchArticle;

public class HelpSearchFragment extends Fragment {
    private HelpSearchRecyclerViewAdapter adapter;
    private HelpCenterProvider helpCenterProvider;
    private String query = "";
    private RecyclerView recyclerView;
    private List<SearchArticle> searchArticles = Collections.emptyList();

    @SuppressLint({"RestrictedApi"})
    public static HelpSearchFragment newInstance(HelpCenterConfiguration helpCenterConfiguration, HelpCenterProvider helpCenterProvider2) {
        Bundle bundle = new Bundle();
        a.b(bundle, helpCenterConfiguration);
        HelpSearchFragment helpSearchFragment = new HelpSearchFragment();
        helpSearchFragment.setArguments(bundle);
        helpSearchFragment.helpCenterProvider = helpCenterProvider2;
        return helpSearchFragment;
    }

    private void setupRecyclerView() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter = new HelpSearchRecyclerViewAdapter(this.searchArticles, this.query, (HelpCenterConfiguration) a.e(getArguments(), HelpCenterConfiguration.class), this.helpCenterProvider);
        this.adapter = helpSearchRecyclerViewAdapter;
        this.recyclerView.setAdapter(helpSearchRecyclerViewAdapter);
    }

    public void clearResults() {
        HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter = this.adapter;
        if (helpSearchRecyclerViewAdapter != null) {
            helpSearchRecyclerViewAdapter.clearResults();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
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

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void updateResults(List<SearchArticle> list, String str) {
        RecyclerView recyclerView2;
        this.searchArticles = list;
        this.query = str;
        if (this.adapter != null && (recyclerView2 = this.recyclerView) != null) {
            recyclerView2.setVisibility(0);
            this.adapter.update(list, str);
            this.recyclerView.announceForAccessibility(getString(R$string.zs_help_center_search_loaded_accessibility));
        }
    }
}
