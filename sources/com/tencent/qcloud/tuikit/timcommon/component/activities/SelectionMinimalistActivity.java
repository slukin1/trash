package com.tencent.qcloud.tuikit.timcommon.component.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import java.util.ArrayList;

public class SelectionMinimalistActivity extends BaseMinimalistLightActivity {
    private static OnResultReturnListener sOnResultReturnListener;
    private EditText input;
    private int mSelectionType;
    /* access modifiers changed from: private */
    public boolean needConfirm = true;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;
    private boolean returnNow = true;
    private ArrayList<String> selectList = new ArrayList<>();
    /* access modifiers changed from: private */
    public SelectAdapter selectListAdapter;
    private RecyclerView selectListView;
    /* access modifiers changed from: private */
    public int selectedItem = -1;

    public interface OnItemClickListener {
        void onClick(int i11);
    }

    public interface OnResultReturnListener {
        void onReturn(Object obj);
    }

    public class SelectAdapter extends RecyclerView.Adapter<SelectViewHolder> {
        public ArrayList<String> data = new ArrayList<>();
        public int selectedItem = -1;

        public class SelectViewHolder extends RecyclerView.ViewHolder {
            public TextView name;
            public ImageView selectedIcon;

            public SelectViewHolder(View view) {
                super(view);
                this.name = (TextView) view.findViewById(R.id.name);
                this.selectedIcon = (ImageView) view.findViewById(R.id.selected_icon);
            }
        }

        public SelectAdapter() {
        }

        public int getItemCount() {
            return this.data.size();
        }

        public void setData(ArrayList<String> arrayList) {
            this.data.clear();
            this.data.addAll(arrayList);
        }

        public void setSelectedItem(int i11) {
            this.selectedItem = i11;
        }

        public void onBindViewHolder(SelectViewHolder selectViewHolder, final int i11) {
            selectViewHolder.name.setText(this.data.get(i11));
            if (this.selectedItem == i11) {
                selectViewHolder.selectedIcon.setVisibility(0);
            } else {
                selectViewHolder.selectedIcon.setVisibility(8);
            }
            selectViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    SelectionMinimalistActivity.this.onItemClickListener.onClick(i11);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }

        public SelectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new SelectViewHolder(LayoutInflater.from(SelectionMinimalistActivity.this).inflate(R.layout.core_select_item_layout, viewGroup, false));
        }
    }

    public static class Selection {
        public static final String CONTENT = "content";
        public static final String DEFAULT_SELECT_ITEM_INDEX = "default_select_item_index";
        public static final String INIT_CONTENT = "init_content";
        public static final String LIMIT = "limit";
        public static final String LIST = "list";
        public static final String NEED_CONFIRM = "needConfirm";
        public static final String RETURN_NOW = "returnNow";
        public static final String SELECT_ALL = "select_all";
        public static final String TITLE = "title";
        public static final String TYPE = "type";
        public static final int TYPE_LIST = 2;
        public static final int TYPE_TEXT = 1;
    }

    /* access modifiers changed from: private */
    public void echoClick() {
        OnResultReturnListener onResultReturnListener;
        int i11 = this.mSelectionType;
        if (i11 == 1) {
            OnResultReturnListener onResultReturnListener2 = sOnResultReturnListener;
            if (onResultReturnListener2 != null) {
                onResultReturnListener2.onReturn(this.input.getText().toString());
            }
        } else if (i11 == 2 && (onResultReturnListener = sOnResultReturnListener) != null) {
            onResultReturnListener.onReturn(Integer.valueOf(this.selectedItem));
        }
        if (this.returnNow) {
            finish();
        }
    }

    public static void startListSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        bundle.putInt("type", 2);
        startSelection(context, bundle, onResultReturnListener);
    }

    private static void startSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        Intent intent = new Intent(context, SelectionMinimalistActivity.class);
        intent.putExtra("content", bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
        sOnResultReturnListener = onResultReturnListener;
    }

    public static void startTextSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        bundle.putInt("type", 1);
        startSelection(context, bundle, onResultReturnListener);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.core_minimalist_selection_activity);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.edit_title_bar);
        this.selectListView = (RecyclerView) findViewById(R.id.select_list);
        SelectAdapter selectAdapter = new SelectAdapter();
        this.selectListAdapter = selectAdapter;
        this.selectListView.setAdapter(selectAdapter);
        this.selectListView.setLayoutManager(new CustomLinearLayoutManager(this));
        h hVar = new h(this, 1);
        hVar.setDrawable(getResources().getDrawable(R.drawable.core_list_divider));
        this.selectListView.addItemDecoration(hVar);
        this.onItemClickListener = new OnItemClickListener() {
            public void onClick(int i11) {
                int unused = SelectionMinimalistActivity.this.selectedItem = i11;
                SelectionMinimalistActivity.this.selectListAdapter.setSelectedItem(i11);
                SelectionMinimalistActivity.this.selectListAdapter.notifyDataSetChanged();
                if (!SelectionMinimalistActivity.this.needConfirm) {
                    SelectionMinimalistActivity.this.echoClick();
                }
            }
        };
        this.input = (EditText) findViewById(R.id.edit_content_et);
        Bundle bundleExtra = getIntent().getBundleExtra("content");
        int i11 = bundleExtra.getInt("type");
        if (i11 == 1) {
            this.selectListView.setVisibility(8);
            String string = bundleExtra.getString("init_content");
            int i12 = bundleExtra.getInt("limit");
            if (!TextUtils.isEmpty(string)) {
                this.input.setText(string);
                this.input.setSelection(string.length());
            }
            if (i12 > 0) {
                this.input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i12)});
            }
        } else if (i11 != 2) {
            finish();
            return;
        } else {
            this.input.setVisibility(8);
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("list");
            this.selectedItem = bundleExtra.getInt("default_select_item_index");
            if (stringArrayList != null && stringArrayList.size() != 0) {
                this.selectList.clear();
                this.selectList.addAll(stringArrayList);
                this.selectListAdapter.setSelectedItem(this.selectedItem);
                this.selectListAdapter.setData(this.selectList);
                this.selectListAdapter.notifyDataSetChanged();
            } else {
                return;
            }
        }
        this.mSelectionType = bundleExtra.getInt("type");
        String string2 = bundleExtra.getString("title");
        this.needConfirm = bundleExtra.getBoolean("needConfirm", true);
        this.returnNow = bundleExtra.getBoolean("returnNow", true);
        titleBarLayout.setTitle(string2, ITitleBarLayout.Position.MIDDLE);
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                SelectionMinimalistActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        titleBarLayout.getRightIcon().setVisibility(8);
        if (this.needConfirm) {
            titleBarLayout.getRightTitle().setText(getResources().getString(com.tencent.qcloud.tuicore.R.string.sure));
            titleBarLayout.setOnRightClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    SelectionMinimalistActivity.this.echoClick();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            return;
        }
        titleBarLayout.getRightGroup().setVisibility(8);
    }

    public void onStop() {
        super.onStop();
        sOnResultReturnListener = null;
    }
}
