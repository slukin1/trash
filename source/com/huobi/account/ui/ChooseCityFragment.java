package com.huobi.account.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.input.ClearEditText;
import com.huobi.account.entity.ChooseCityEntity;
import com.huobi.account.entity.ChooseListData;
import com.huobi.view.indexlist.EntityWrapper;
import com.huobi.view.indexlist.IndexPartAdapter;
import com.huobi.view.indexlist.IndexPartLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.n;
import i6.r;
import java.io.Serializable;
import java.util.List;
import og.f;
import og.o;
import pro.huobi.R;

public class ChooseCityFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public SearchCityFragment f41141b;

    /* renamed from: c  reason: collision with root package name */
    public ChooseListData f41142c;

    /* renamed from: d  reason: collision with root package name */
    public f f41143d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ChooseCityFragment.this.zh((ChooseCityEntity) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements IndexPartAdapter.OnItemContentClickListener<ChooseCityEntity> {
        public b() {
        }

        /* renamed from: a */
        public void onItemClick(View view, int i11, int i12, ChooseCityEntity chooseCityEntity) {
            ChooseCityFragment.this.zh(chooseCityEntity);
        }
    }

    public class c implements IndexPartAdapter.IndexCallback<ChooseCityEntity> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IndexPartLayout f41146a;

        public c(IndexPartLayout indexPartLayout) {
            this.f41146a = indexPartLayout;
        }

        public void onFinished(List<EntityWrapper<ChooseCityEntity>> list) {
            ChooseCityFragment.this.Ah(this.f41146a.getRecyclerView(), ChooseCityFragment.this.f41142c.getDefaultId(), list);
        }
    }

    public class d implements f.a {
        public d() {
        }

        public void a(ChooseCityEntity chooseCityEntity, int i11) {
            ChooseCityFragment.this.zh(chooseCityEntity);
        }
    }

    public class e implements o.d {
        public e() {
        }

        public void a(ChooseCityEntity chooseCityEntity, int i11) {
            ChooseCityFragment.this.zh(chooseCityEntity);
        }
    }

    public interface f {
        void a(ChooseCityEntity chooseCityEntity);
    }

    public static /* synthetic */ boolean Ch(long j11, EntityWrapper entityWrapper) {
        return (entityWrapper == null || entityWrapper.getData() == null || j11 != ((ChooseCityEntity) entityWrapper.getData()).getId()) ? false : true;
    }

    public static /* synthetic */ boolean Dh(long j11, ChooseCityEntity chooseCityEntity) {
        return chooseCityEntity != null && j11 == chooseCityEntity.getId();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Eh(CharSequence charSequence, int i11, int i12, int i13) {
        boolean z11 = charSequence != null && charSequence.toString().trim().length() > 0;
        if (z11 && this.f41141b.isHidden()) {
            getChildFragmentManager().q().A(this.f41141b).j();
        } else if (!z11 && !this.f41141b.isHidden()) {
            getChildFragmentManager().q().q(this.f41141b).j();
        }
        this.f41141b.rh(charSequence == null ? "" : charSequence.toString());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fh(RecyclerView recyclerView, int i11) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i11, (int) ((((float) recyclerView.getHeight()) - getResources().getDimension(R.dimen.dimen_50)) / 2.0f));
        }
    }

    public static ChooseCityFragment Gh(ChooseListData chooseListData) {
        ChooseCityFragment chooseCityFragment = new ChooseCityFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("CHOOSE_LIST_DATA", chooseListData);
        chooseCityFragment.setArguments(bundle);
        return chooseCityFragment;
    }

    public final void Ah(RecyclerView recyclerView, long j11, List<EntityWrapper<ChooseCityEntity>> list) {
        int a11;
        if (j11 != -1 && (a11 = CollectionsUtils.a(list, new h(j11))) > 0) {
            ((ChooseCityEntity) list.get(a11).getData()).setSelected(true);
            Hh(recyclerView, a11);
        }
    }

    public final void Bh(RecyclerView recyclerView, long j11, List<ChooseCityEntity> list) {
        int a11;
        if (j11 != -1 && (a11 = CollectionsUtils.a(list, new g(j11))) != -1) {
            list.get(a11).setSelected(true);
            Hh(recyclerView, a11);
        }
    }

    public final void Hh(RecyclerView recyclerView, int i11) {
        i.b().f(new j(this, recyclerView, i11));
    }

    public void Ih(f fVar) {
        this.f41143d = fVar;
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public boolean followScreenSize() {
        return true;
    }

    public int getContentViewResId() {
        return R.layout.fragment_choose_city;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("CHOOSE_LIST_DATA");
            if (serializable instanceof ChooseListData) {
                this.f41142c = (ChooseListData) serializable;
            }
        }
        if (this.f41142c == null) {
            zh((ChooseCityEntity) null);
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) rVar.b(R.id.choose_root);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) constraintLayout.getLayoutParams();
        marginLayoutParams.topMargin = (int) (getResources().getDimension(R.dimen.dimen_100) - ((float) n.h(getContext())));
        constraintLayout.setLayoutParams(marginLayoutParams);
        TextView textView = (TextView) rVar.b(R.id.tv_city);
        TextView textView2 = (TextView) rVar.b(R.id.tv_close);
        textView.setText(TextUtils.isEmpty(this.f41142c.getLeftTitle()) ? getString(R.string.city) : this.f41142c.getLeftTitle());
        textView2.setText(TextUtils.isEmpty(this.f41142c.getRightTitle()) ? getString(R.string.string_close) : this.f41142c.getRightTitle());
        textView2.setOnClickListener(new a());
        ((ClearEditText) rVar.b(R.id.et_search)).setOnTextChangedListener(new i(this));
        RecyclerView recyclerView = (RecyclerView) rVar.b(R.id.rv_list);
        IndexPartLayout indexPartLayout = (IndexPartLayout) rVar.b(R.id.ipl_city);
        int i11 = 0;
        if (this.f41142c.isSupportIndex()) {
            indexPartLayout.setVisibility(0);
            indexPartLayout.setLayoutManager(new LinearLayoutManager(getContext()));
            indexPartLayout.setCompareMode(1);
            indexPartLayout.setOverlayStyle_Center();
            indexPartLayout.showAllLetter(false);
            og.d dVar = new og.d(getContext());
            dVar.setOnItemContentClickListener(new b());
            indexPartLayout.setAdapter(dVar);
            dVar.setDatas(this.f41142c.getList(), new c(indexPartLayout));
        } else {
            recyclerView.setVisibility(0);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            og.f fVar = new og.f(this.f41142c.getList());
            fVar.f(new d());
            recyclerView.setAdapter(fVar);
            Bh(recyclerView, this.f41142c.getDefaultId(), this.f41142c.getList());
        }
        ViewGroup viewGroup = (ViewGroup) rVar.b(R.id.vg_empty);
        if (!CollectionsUtils.b(this.f41142c.getList())) {
            i11 = 8;
        }
        viewGroup.setVisibility(i11);
        yh();
    }

    public boolean isTransparent() {
        return false;
    }

    public final void yh() {
        FragmentTransaction q11 = getChildFragmentManager().q();
        SearchCityFragment searchCityFragment = (SearchCityFragment) Fragment.instantiate(getContext(), SearchCityFragment.class.getName(), getArguments());
        this.f41141b = searchCityFragment;
        searchCityFragment.th(new e());
        q11.c(R.id.fl_choose_root, this.f41141b, (String) null);
        q11.q(this.f41141b).k();
    }

    public void zh(ChooseCityEntity chooseCityEntity) {
        f fVar = this.f41143d;
        if (fVar != null) {
            fVar.a(chooseCityEntity);
        }
        dismiss();
    }
}
