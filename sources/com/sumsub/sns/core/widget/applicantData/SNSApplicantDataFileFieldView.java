package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.widget.SNSAddFileItemView;
import com.sumsub.sns.core.widget.SNSFileItemView;
import com.sumsub.sns.core.widget.SNSProgressBarView;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import d10.a;
import d10.l;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.sequences.g;

@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002IJB1\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010E\u001a\u00020D\u0012\b\b\u0002\u0010F\u001a\u00020D¢\u0006\u0004\bG\u0010HJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005R*\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R6\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u0016\u0010*\u001a\u0004\u0018\u00010'8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R(\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8V@VX\u000e¢\u0006\f\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR(\u00100\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8V@VX\u000e¢\u0006\f\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R0\u0010:\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0005\u0018\u0001088\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006K"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataFileFieldView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataFileFieldView$Attachment;", "items", "", "populateViewItems", "cleanup", "", "value", "pickFileLabel", "Ljava/lang/CharSequence;", "getPickFileLabel", "()Ljava/lang/CharSequence;", "setPickFileLabel", "(Ljava/lang/CharSequence;)V", "files", "Ljava/util/List;", "getFiles", "()Ljava/util/List;", "setFiles", "(Ljava/util/List;)V", "", "showPickFile", "Z", "getShowPickFile", "()Z", "setShowPickFile", "(Z)V", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataFileFieldView$State;", "state", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataFileFieldView$State;", "getState", "()Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataFileFieldView$State;", "setState", "(Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataFileFieldView$State;)V", "itemStates", "getItemStates", "setItemStates", "Landroid/view/ViewGroup;", "getFilesView", "()Landroid/view/ViewGroup;", "filesView", "getError", "setError", "error", "getLabel", "setLabel", "label", "Lkotlin/Function0;", "pickFileClickListener", "Ld10/a;", "getPickFileClickListener", "()Ld10/a;", "setPickFileClickListener", "(Ld10/a;)V", "Lkotlin/Function1;", "", "deleteFileClickListener", "Ld10/l;", "getDeleteFileClickListener", "()Ld10/l;", "setDeleteFileClickListener", "(Ld10/l;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Attachment", "State", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSApplicantDataFileFieldView extends SNSApplicantDataBaseFieldView {
    private l<? super String, Unit> deleteFileClickListener;
    private List<Attachment> files;
    private List<? extends State> itemStates;
    private a<Unit> pickFileClickListener;
    private CharSequence pickFileLabel;
    private boolean showPickFile;
    private State state;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataFileFieldView$Attachment;", "", "id", "", "label", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getImageUrl", "getLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Attachment {

        /* renamed from: id  reason: collision with root package name */
        private final String f31208id;
        private final String imageUrl;
        private final String label;

        public Attachment(String str, String str2, String str3) {
            this.f31208id = str;
            this.label = str2;
            this.imageUrl = str3;
        }

        public static /* synthetic */ Attachment copy$default(Attachment attachment, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = attachment.f31208id;
            }
            if ((i11 & 2) != 0) {
                str2 = attachment.label;
            }
            if ((i11 & 4) != 0) {
                str3 = attachment.imageUrl;
            }
            return attachment.copy(str, str2, str3);
        }

        public final String component1() {
            return this.f31208id;
        }

        public final String component2() {
            return this.label;
        }

        public final String component3() {
            return this.imageUrl;
        }

        public final Attachment copy(String str, String str2, String str3) {
            return new Attachment(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Attachment)) {
                return false;
            }
            Attachment attachment = (Attachment) obj;
            return x.b(this.f31208id, attachment.f31208id) && x.b(this.label, attachment.label) && x.b(this.imageUrl, attachment.imageUrl);
        }

        public final String getId() {
            return this.f31208id;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getLabel() {
            return this.label;
        }

        public int hashCode() {
            int hashCode = this.f31208id.hashCode() * 31;
            String str = this.label;
            int i11 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.imageUrl;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "Attachment(id=" + this.f31208id + ", label=" + this.label + ", imageUrl=" + this.imageUrl + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataFileFieldView$State;", "", "(Ljava/lang/String;I)V", "DEFAULT", "LOADING", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum State {
        DEFAULT,
        LOADING
    }

    public SNSApplicantDataFileFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final ViewGroup getFilesView() {
        return (ViewGroup) findViewById(R.id.sns_data_file);
    }

    private final void populateViewItems(List<Attachment> list) {
        ViewGroup filesView = getFilesView();
        if (filesView != null) {
            cleanup();
            filesView.removeAllViews();
            Context context = filesView.getContext();
            if (context != null) {
                int i11 = 0;
                for (T next : list) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                    Attachment attachment = (Attachment) next;
                    SNSFileItemView sNSFileItemView = new SNSFileItemView(context, (AttributeSet) null, 0, 0, 14, (r) null);
                    sNSFileItemView.setText(attachment.getLabel());
                    sNSFileItemView.loadImage(attachment.getImageUrl());
                    sNSFileItemView.setStartIcon(e0.f32018a.getIconHandler().onResolveIcon(context, SNSIconHandler.SNSCommonIcons.IMAGE.getImageName()));
                    if (((State) CollectionsKt___CollectionsKt.d0(this.itemStates, i11)) == State.LOADING) {
                        sNSFileItemView.setProgressVisibility(true);
                    } else {
                        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
                        Drawable a11 = aVar.a(context, SNSIconHandler.SNSCommonIcons.DELETE.getImageName());
                        if (a11 == null) {
                            a11 = aVar.a(context, SNSIconHandler.SNSCommonIcons.BIN.getImageName());
                        }
                        sNSFileItemView.setEndIcon(a11);
                        sNSFileItemView.setEndIconClickListener(new c(this, attachment));
                    }
                    filesView.addView(sNSFileItemView);
                    i11 = i12;
                }
                if (this.showPickFile && this.state == State.DEFAULT) {
                    SNSAddFileItemView sNSAddFileItemView = new SNSAddFileItemView(context, (AttributeSet) null, 0, 0, 14, (r) null);
                    sNSAddFileItemView.setText(this.pickFileLabel);
                    sNSAddFileItemView.loadImage((String) null);
                    sNSAddFileItemView.setStartIcon(e0.f32018a.getIconHandler().onResolveIcon(context, SNSIconHandler.SNSCommonIcons.ATTACHMENT.getImageName()));
                    sNSAddFileItemView.setOnClickListener(new b(this));
                    filesView.addView(sNSAddFileItemView);
                }
                if (this.state == State.LOADING) {
                    SNSProgressBarView sNSProgressBarView = new SNSProgressBarView(context, (AttributeSet) null, 16842871);
                    sNSProgressBarView.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.sns_progress_bar_size_medium)));
                    filesView.addView(sNSProgressBarView);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: populateViewItems$lambda-7$lambda-6$lambda-5  reason: not valid java name */
    public static final void m37populateViewItems$lambda7$lambda6$lambda5(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, Attachment attachment, View view) {
        l<? super String, Unit> lVar = sNSApplicantDataFileFieldView.deleteFileClickListener;
        if (lVar != null) {
            lVar.invoke(attachment.getId());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: populateViewItems$lambda-9$lambda-8  reason: not valid java name */
    public static final void m38populateViewItems$lambda9$lambda8(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, View view) {
        a<Unit> aVar = sNSApplicantDataFileFieldView.pickFileClickListener;
        if (aVar != null) {
            aVar.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void cleanup() {
        g<View> a11;
        ViewGroup filesView = getFilesView();
        if (filesView != null && (a11 = ViewGroupKt.a(filesView)) != null) {
            for (View next : a11) {
                if (next instanceof SNSFileItemView) {
                    ((SNSFileItemView) next).loadImage((String) null);
                }
            }
        }
    }

    public final l<String, Unit> getDeleteFileClickListener() {
        return this.deleteFileClickListener;
    }

    public CharSequence getError() {
        TextView tvError = getTvError();
        if (tvError != null) {
            return tvError.getText();
        }
        return null;
    }

    public final List<Attachment> getFiles() {
        return this.files;
    }

    public final List<State> getItemStates() {
        return this.itemStates;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence getLabel() {
        /*
            r1 = this;
            android.widget.TextView r0 = r1.getTvLabel$idensic_mobile_sdk_aar_release()
            if (r0 == 0) goto L_0x000c
            java.lang.CharSequence r0 = r0.getText()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView.getLabel():java.lang.CharSequence");
    }

    public final a<Unit> getPickFileClickListener() {
        return this.pickFileClickListener;
    }

    public final CharSequence getPickFileLabel() {
        return this.pickFileLabel;
    }

    public final boolean getShowPickFile() {
        return this.showPickFile;
    }

    public final State getState() {
        return this.state;
    }

    public final void setDeleteFileClickListener(l<? super String, Unit> lVar) {
        this.deleteFileClickListener = lVar;
    }

    public void setError(CharSequence charSequence) {
        SNSStepState sNSStepState;
        TextView tvError = getTvError();
        if (tvError != null) {
            i.a(tvError, charSequence);
        }
        ViewGroup filesView = getFilesView();
        if (filesView != null) {
            int childCount = filesView.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = filesView.getChildAt(i11);
                if (charSequence == null || charSequence.length() == 0) {
                    sNSStepState = SNSStepState.INIT;
                } else {
                    sNSStepState = SNSStepState.REJECTED;
                }
                SNSStepViewExtensionsKt.setSnsStepState(childAt, sNSStepState);
            }
        }
    }

    public final void setFiles(List<Attachment> list) {
        setError((CharSequence) null);
        populateViewItems(list);
        this.files = list;
    }

    public final void setItemStates(List<? extends State> list) {
        this.itemStates = list;
        populateViewItems(this.files);
    }

    public void setLabel(CharSequence charSequence) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            i.a(tvLabel$idensic_mobile_sdk_aar_release, charSequence);
        }
    }

    public final void setPickFileClickListener(a<Unit> aVar) {
        this.pickFileClickListener = aVar;
    }

    public final void setPickFileLabel(CharSequence charSequence) {
        g<View> a11;
        View view;
        this.pickFileLabel = charSequence;
        ViewGroup filesView = getFilesView();
        if (filesView != null && (a11 = ViewGroupKt.a(filesView)) != null) {
            Iterator<View> it2 = a11.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    view = null;
                    break;
                }
                view = it2.next();
                if (view instanceof SNSAddFileItemView) {
                    break;
                }
            }
            View view2 = view;
            if (view2 != null) {
                ((SNSAddFileItemView) view2).setText(charSequence);
            }
        }
    }

    public final void setShowPickFile(boolean z11) {
        this.showPickFile = z11;
        populateViewItems(this.files);
    }

    public final void setState(State state2) {
        this.state = state2;
    }

    public SNSApplicantDataFileFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataFileFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataFileFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataFileFieldViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataFileFieldView : i12);
    }

    public SNSApplicantDataFileFieldView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.pickFileLabel = "";
        this.files = CollectionsKt__CollectionsKt.k();
        this.showPickFile = true;
        this.state = State.DEFAULT;
        this.itemStates = CollectionsKt__CollectionsKt.k();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSApplicantDataFileFieldView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSApplicantDataFileFieldView_sns_applicantDataFileFieldLayout, R.layout.sns_layout_applicant_data_file_field_view), this, true);
        obtainStyledAttributes.recycle();
        populateViewItems(CollectionsKt__CollectionsKt.k());
        onInitializationFinished();
    }
}
