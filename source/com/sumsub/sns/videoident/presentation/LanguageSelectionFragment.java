package com.sumsub.sns.videoident.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.b;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.videoident.presentation.SNSViewState;
import com.sumsub.sns.internal.videoident.presentation.a;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import java.util.ArrayList;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B\u0007¢\u0006\u0004\b6\u00107J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u001b\u0010\u001e\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u00048\u0014XD¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020#8\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u0004\u0018\u00010(8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u0002038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/sumsub/sns/videoident/presentation/LanguageSelectionFragment;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/videoident/presentation/a$c;", "Lcom/sumsub/sns/internal/videoident/presentation/a;", "", "language", "", "waitTimeSec", "", "finishWithLanguage", "", "getLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "state", "handleState", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "viewModel$delegate", "Lkotlin/i;", "getViewModel", "()Lcom/sumsub/sns/internal/videoident/presentation/a;", "viewModel", "idDocSetType", "Ljava/lang/String;", "getIdDocSetType", "()Ljava/lang/String;", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "Landroid/widget/TextView;", "title$delegate", "Lcom/sumsub/sns/internal/core/common/z;", "getTitle", "()Landroid/widget/TextView;", "title", "Landroidx/recyclerview/widget/RecyclerView;", "list$delegate", "getList", "()Landroidx/recyclerview/widget/RecyclerView;", "list", "Lcom/sumsub/sns/videoident/presentation/LanguageItemAdapter;", "adapter", "Lcom/sumsub/sns/videoident/presentation/LanguageItemAdapter;", "<init>", "()V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class LanguageSelectionFragment extends b<a.c, a> {
    public static final /* synthetic */ l<Object>[] $$delegatedProperties = {Reflection.j(new PropertyReference1Impl(LanguageSelectionFragment.class, "title", "getTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(LanguageSelectionFragment.class, "list", "getList()Landroidx/recyclerview/widget/RecyclerView;", 0))};
    public static final Companion Companion = new Companion((r) null);
    public static final String RESULT_KEY_SELECTED_LANGUAGE = "lang";
    private LanguageItemAdapter adapter;
    private final String idDocSetType = DocumentType.f32355j;
    private final z list$delegate = a0.a(this, R.id.sns_list);
    private final Screen screen = Screen.VideoidentLangSelectorScreen;
    private final z title$delegate = a0.a(this, R.id.sns_title);
    private final i viewModel$delegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/videoident/presentation/LanguageSelectionFragment$Companion;", "", "Lcom/sumsub/sns/internal/videoident/presentation/SNSViewState$b;", "state", "Lcom/sumsub/sns/videoident/presentation/LanguageSelectionFragment;", "getInstance", "", "RESULT_KEY_SELECTED_LANGUAGE", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final LanguageSelectionFragment getInstance(SNSViewState.b bVar) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(a.f36645t, new ArrayList(bVar.c()));
            bundle.putString("lang", bVar.d());
            LanguageSelectionFragment languageSelectionFragment = new LanguageSelectionFragment();
            languageSelectionFragment.setArguments(bundle);
            return languageSelectionFragment;
        }

        private Companion() {
        }
    }

    public LanguageSelectionFragment() {
        LanguageSelectionFragment$viewModel$2 languageSelectionFragment$viewModel$2 = new LanguageSelectionFragment$viewModel$2(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new LanguageSelectionFragment$special$$inlined$viewModels$default$2(new LanguageSelectionFragment$special$$inlined$viewModels$default$1(this)));
        this.viewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(a.class), new LanguageSelectionFragment$special$$inlined$viewModels$default$3(b11), new LanguageSelectionFragment$special$$inlined$viewModels$default$4((d10.a) null, b11), languageSelectionFragment$viewModel$2);
    }

    private final void finishWithLanguage(String str, long j11) {
        getAnalyticsDelegate().b(getScreen(), getIdDocSetType(), Control.ContinueButton, MapsKt__MapsKt.l(kotlin.l.a("lang", str), kotlin.l.a("waitTimeSec", Long.valueOf(j11))));
        Bundle bundle = new Bundle();
        bundle.putString("lang", str);
        Unit unit = Unit.f56620a;
        b.setResult$default(this, 0, bundle, 1, (Object) null);
    }

    private final RecyclerView getList() {
        return (RecyclerView) this.list$delegate.a(this, $$delegatedProperties[1]);
    }

    private final TextView getTitle() {
        return (TextView) this.title$delegate.a(this, $$delegatedProperties[0]);
    }

    public String getIdDocSetType() {
        return this.idDocSetType;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_video_ident_language_selection;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof a.b) {
            a.b bVar = (a.b) jVar;
            finishWithLanguage(bVar.c(), bVar.d());
            return;
        }
        super.handleEvent(jVar);
    }

    public boolean onFinishCalled(q qVar) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "LanguageSelectionFragment.onFinishCalled: " + qVar, (Throwable) null, 4, (Object) null);
        super.onFinishCalled(qVar);
        b.setResult$default(this, 0, (Bundle) null, 2, (Object) null);
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView list = getList();
        if (list != null) {
            list.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        }
        RecyclerView list2 = getList();
        if (list2 != null) {
            list2.addItemDecoration(new com.sumsub.sns.core.presentation.base.adapter.decorator.b(getResources().getDimensionPixelSize(R.dimen.sns_margin_small)));
        }
        RecyclerView list3 = getList();
        if (list3 != null) {
            LanguageItemAdapter languageItemAdapter = new LanguageItemAdapter();
            this.adapter = languageItemAdapter;
            languageItemAdapter.setSelectionCallback(new LanguageSelectionFragment$onViewCreated$1$1(this));
            list3.setAdapter(languageItemAdapter);
        }
    }

    public com.sumsub.sns.internal.videoident.presentation.a getViewModel() {
        return (com.sumsub.sns.internal.videoident.presentation.a) this.viewModel$delegate.getValue();
    }

    public void handleState(a.c cVar, Bundle bundle) {
        LanguageItemAdapter languageItemAdapter = null;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "lang selection state: " + cVar, (Throwable) null, 4, (Object) null);
        TextView title = getTitle();
        if (title != null) {
            com.sumsub.sns.internal.core.common.i.a(title, (CharSequence) cVar.d());
        }
        LanguageItemAdapter languageItemAdapter2 = this.adapter;
        if (languageItemAdapter2 != null) {
            languageItemAdapter = languageItemAdapter2;
        }
        languageItemAdapter.setItems(cVar.c());
    }
}
