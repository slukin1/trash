package com.huobi.webcache.ui;

import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bbc876219.webview_cache.R$id;
import com.bbc876219.webview_cache.R$layout;
import com.bbc876219.webview_cache.R$menu;
import com.huobi.webcache.LogCollectionService;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.tencent.mmkv.MMKVContentProvider;
import java.util.List;

public class LogListFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f20775b;

    /* renamed from: c  reason: collision with root package name */
    public i f20776c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f20777d = new a();

    public class a implements View.OnLongClickListener {
        public a() {
        }

        public boolean onLongClick(View view) {
            ((ClipboardManager) LogListFragment.this.getContext().getSystemService("clipboard")).setText(((TextView) view).getText().toString());
            Toast.makeText(LogListFragment.this.getContext(), "copy sucess", 0).show();
            return true;
        }
    }

    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    public class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditText f20780b;

        public c(EditText editText) {
            this.f20780b = editText;
        }

        @SensorsDataInstrumented
        public void onClick(DialogInterface dialogInterface, int i11) {
            LogListFragment.this.f20776c.f20791c.clear();
            List unused = LogListFragment.this.f20776c.f20791c = LogCollectionService.e().c(this.f20780b.getText().toString());
            LogListFragment.this.f20776c.notifyDataSetChanged();
            dialogInterface.dismiss();
            SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(DialogInterface dialogInterface, int i11) {
            dialogInterface.dismiss();
            SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
        }
    }

    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    public class f implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditText f20784b;

        public f(EditText editText) {
            this.f20784b = editText;
        }

        @SensorsDataInstrumented
        public void onClick(DialogInterface dialogInterface, int i11) {
            LogListFragment.this.sh(this.f20784b.getText().toString());
            dialogInterface.dismiss();
            LogListFragment.this.getActivity().finish();
            SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @SensorsDataInstrumented
        public void onClick(DialogInterface dialogInterface, int i11) {
            dialogInterface.dismiss();
            SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
        }
    }

    public class h extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f20787a;

        public h(View view) {
            super(view);
            this.f20787a = (TextView) view.findViewById(R$id.emptyText);
        }
    }

    public class i extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public int f20789a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f20790b = 1;

        /* renamed from: c  reason: collision with root package name */
        public List<LogCollectionService.H5Url> f20791c;

        public class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f20793b;

            public a(View view) {
                this.f20793b = view;
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                LogCollectionService.H5Url h5Url = (LogCollectionService.H5Url) this.f20793b.getTag();
                Bundle bundle = new Bundle();
                if (LogCollectionService.e().d(h5Url.getUrl()) == null) {
                    bundle.putSerializable("ARG_ITEM_OBJECT", h5Url);
                } else {
                    bundle.putString(MMKVContentProvider.KEY, h5Url.getUrl());
                }
                NavHostFragment.sh(LogListFragment.this).P(R$id.action_LogListFragment_to_LogDetailFragment, bundle);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RecyclerView.ViewHolder f20795b;

            public b(RecyclerView.ViewHolder viewHolder) {
                this.f20795b = viewHolder;
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                LogCollectionService.H5Url h5Url = (LogCollectionService.H5Url) this.f20795b.itemView.getTag();
                Bundle bundle = new Bundle();
                if (LogCollectionService.e().d(h5Url.getUrl()) == null) {
                    bundle.putSerializable("ARG_ITEM_OBJECT", h5Url);
                } else {
                    bundle.putString(MMKVContentProvider.KEY, h5Url.getUrl());
                }
                NavHostFragment.sh(LogListFragment.this).P(R$id.action_LogListFragment_to_LogDetailFragment, bundle);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public i(List<LogCollectionService.H5Url> list) {
            this.f20791c = list;
        }

        public int getItemCount() {
            if (this.f20791c.size() > 0) {
                return this.f20791c.size();
            }
            return 1;
        }

        public long getItemId(int i11) {
            return super.getItemId(i11);
        }

        public int getItemViewType(int i11) {
            if (this.f20791c.size() == 0) {
                return this.f20789a;
            }
            if (this.f20791c.size() > 0) {
                return this.f20790b;
            }
            return super.getItemViewType(i11);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            if (viewHolder instanceof h) {
                ((h) viewHolder).f20787a.setText("暂无数据");
            } else if (viewHolder instanceof j) {
                j jVar = (j) viewHolder;
                LogCollectionService.H5Url h5Url = this.f20791c.get(i11);
                viewHolder.itemView.setTag(h5Url);
                jVar.f20797a.setText(String.format("%s\t%s\t开始:%s\t结束:%s", new Object[]{h5Url.getTypeString(), h5Url.getStateString(), h5Url.getStartTimeText(), h5Url.getEndTimeText()}));
                jVar.f20798b.setText(h5Url.getUrl());
                jVar.f20798b.setOnClickListener(new b(viewHolder));
                jVar.f20798b.setOnLongClickListener(LogListFragment.this.f20777d);
            }
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == this.f20789a) {
                return new h(LayoutInflater.from(LogListFragment.this.getActivity()).inflate(R$layout.empty_recycler, viewGroup, false));
            }
            View inflate = LayoutInflater.from(LogListFragment.this.getActivity()).inflate(R$layout.item_list_content, viewGroup, false);
            inflate.setOnClickListener(new a(inflate));
            return new j(inflate);
        }
    }

    public class j extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f20797a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20798b;

        public j(View view) {
            super(view);
            this.f20797a = (TextView) view.findViewById(R$id.id_text);
            this.f20798b = (TextView) view.findViewById(R$id.content);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R$menu.menu_item_list, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.d("LogListFragment", "onCreateView() called with: inflater = [" + layoutInflater + "], container = [" + viewGroup + "], savedInstanceState = [" + bundle + "]");
        setHasOptionsMenu(true);
        return layoutInflater.inflate(R$layout.fr_list_log, viewGroup, false);
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R$id.action_finish) {
            getActivity().finish();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (itemId == R$id.action_okhttp) {
            this.f20776c.f20791c.clear();
            List unused = this.f20776c.f20791c = LogCollectionService.e().f();
            this.f20776c.notifyDataSetChanged();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (itemId == R$id.action_web) {
            this.f20776c.f20791c.clear();
            List unused2 = this.f20776c.f20791c = LogCollectionService.e().g();
            this.f20776c.notifyDataSetChanged();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (itemId == R$id.action_custom) {
            View inflate = getLayoutInflater().inflate(R$layout.dialog_edit_view, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R$id.editText);
            editText.setHint("要过滤的关键字");
            new AlertDialog.a(getActivity()).setTitle((CharSequence) "输入要过滤的关键字").setNegativeButton((CharSequence) "取消", (DialogInterface.OnClickListener) new d()).setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) new c(editText)).setView(inflate).setCancelable(true).setOnCancelListener(new b()).create().show();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (itemId == R$id.action_open) {
            View inflate2 = getLayoutInflater().inflate(R$layout.dialog_edit_view, (ViewGroup) null);
            EditText editText2 = (EditText) inflate2.findViewById(R$id.editText);
            editText2.setHint("请输入Url");
            new AlertDialog.a(getActivity()).setTitle((CharSequence) "请输入要打开的url").setNegativeButton((CharSequence) "取消", (DialogInterface.OnClickListener) new g()).setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) new f(editText2)).setView(inflate2).setCancelable(true).setOnCancelListener(new e()).create().show();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (itemId == R$id.action_reload) {
            this.f20776c.f20791c.clear();
            List unused3 = this.f20776c.f20791c = LogCollectionService.e().b();
            this.f20776c.notifyDataSetChanged();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (itemId == R$id.action_clean) {
            LogCollectionService.e().a();
            this.f20776c.f20791c.clear();
            this.f20776c.notifyDataSetChanged();
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
        this.f20775b = (RecyclerView) view.findViewById(R$id.item_list);
        i iVar = new i(LogCollectionService.e().b());
        this.f20776c = iVar;
        this.f20775b.setAdapter(iVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.f20775b.setLayoutManager(linearLayoutManager);
        getActivity().setTitle("日志列表");
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final void sh(String str) {
        Intent intent = new Intent();
        intent.setClassName(getContext().getPackageName(), "com.hbg.lib.core.webview.HBBaseWebActivity");
        intent.putExtra("url", str);
        getActivity().startActivity(intent);
    }
}
