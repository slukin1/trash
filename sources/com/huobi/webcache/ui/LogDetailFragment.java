package com.huobi.webcache.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bbc876219.webview_cache.R$id;
import com.bbc876219.webview_cache.R$layout;
import com.bbc876219.webview_cache.R$menu;
import com.huobi.view.roundimg.RoundedDrawable;
import com.huobi.webcache.LogCollectionService;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.tencent.mmkv.MMKVContentProvider;
import java.util.ArrayList;
import java.util.List;

public class LogDetailFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f20761b;

    /* renamed from: c  reason: collision with root package name */
    public d f20762c;

    /* renamed from: d  reason: collision with root package name */
    public LogCollectionService.H5Url f20763d;

    /* renamed from: e  reason: collision with root package name */
    public List<LogCollectionService.c> f20764e;

    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f20765a;

        public b(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R$id.tv_detail);
            this.f20765a = textView;
            textView.setTextIsSelectable(true);
        }
    }

    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f20767a;

        public c(View view) {
            super(view);
            this.f20767a = (TextView) view.findViewById(R$id.emptyText);
        }
    }

    public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public int f20769a;

        /* renamed from: b  reason: collision with root package name */
        public int f20770b;

        /* renamed from: c  reason: collision with root package name */
        public int f20771c;

        public d() {
            this.f20769a = 0;
            this.f20770b = 1;
            this.f20771c = 2;
        }

        public int getItemCount() {
            if (LogDetailFragment.this.f20764e == null) {
                return 0;
            }
            if (LogDetailFragment.this.f20764e.size() > 0) {
                return LogDetailFragment.this.f20764e.size();
            }
            return 1;
        }

        public long getItemId(int i11) {
            return super.getItemId(i11);
        }

        public int getItemViewType(int i11) {
            if (LogDetailFragment.this.f20764e.size() == 0) {
                return this.f20769a;
            }
            if (LogDetailFragment.this.f20764e.size() > 0 && i11 == 0) {
                return this.f20771c;
            }
            if (LogDetailFragment.this.f20764e.size() <= 0 || i11 <= 0) {
                return this.f20770b;
            }
            return this.f20770b;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            if (viewHolder instanceof c) {
                ((c) viewHolder).f20767a.setText("暂无详细数据");
            } else if (viewHolder instanceof b) {
                ((b) viewHolder).f20765a.setText(LogDetailFragment.this.f20763d.getDetailTitle());
            } else if (viewHolder instanceof e) {
                e eVar = (e) viewHolder;
                LogCollectionService.c cVar = (LogCollectionService.c) LogDetailFragment.this.f20764e.get(i11);
                if (cVar.a()) {
                    eVar.f20773a.setTextColor(-65536);
                } else {
                    eVar.f20773a.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
                }
                eVar.f20773a.setText(cVar.toString());
            }
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == this.f20769a) {
                return new c(LayoutInflater.from(LogDetailFragment.this.getActivity()).inflate(R$layout.empty_recycler, viewGroup, false));
            } else if (i11 == this.f20771c) {
                return new b(LayoutInflater.from(LogDetailFragment.this.getActivity()).inflate(R$layout.item_detail, viewGroup, false));
            } else {
                return new e(LayoutInflater.from(LogDetailFragment.this.getActivity()).inflate(R$layout.item_detail, viewGroup, false));
            }
        }
    }

    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f20773a;

        public e(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R$id.tv_detail);
            this.f20773a = textView;
            textView.setTextIsSelectable(true);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R$menu.menu_item_detail, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        if (getArguments().containsKey(MMKVContentProvider.KEY)) {
            this.f20763d = LogCollectionService.e().d(getArguments().getString(MMKVContentProvider.KEY));
        } else if (getArguments().containsKey("ARG_ITEM_OBJECT")) {
            this.f20763d = (LogCollectionService.H5Url) getArguments().getSerializable("ARG_ITEM_OBJECT");
        } else {
            Toast.makeText(getContext(), "没有详细数据", 0).show();
        }
        Log.d("LogDetailFragment", "onCreateView() called with: inflater = [" + layoutInflater + "], container = [" + viewGroup + "], savedInstanceState = [" + bundle + "]");
        return layoutInflater.inflate(R$layout.fr_detail_log, viewGroup, false);
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R$id.action_detail_finish) {
            getActivity().finish();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (itemId == R$id.action_detail_clean) {
            LogCollectionService.f20647b.remove(this.f20763d.getUrl());
            List<LogCollectionService.c> list = this.f20764e;
            if (list != null) {
                list.clear();
                this.f20762c.notifyDataSetChanged();
            }
            NavHostFragment.sh(this).O(R$id.action_LogDetailFragment_to_LogListFragment);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected;
        }
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
        this.f20761b = (RecyclerView) view.findViewById(R$id.item_detail);
        if (this.f20763d.getPairs().size() > 0) {
            ArrayList arrayList = new ArrayList();
            this.f20764e = arrayList;
            arrayList.add(new LogCollectionService.c(0, 0, ""));
            this.f20764e.addAll(this.f20763d.getPairs());
        }
        d dVar = new d();
        this.f20762c = dVar;
        this.f20761b.setAdapter(dVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.f20761b.setLayoutManager(linearLayoutManager);
        getActivity().setTitle("日志详情");
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
