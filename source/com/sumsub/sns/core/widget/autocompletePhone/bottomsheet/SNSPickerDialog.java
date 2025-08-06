package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.core.widget.SNSBottomSheetView;
import com.sumsub.sns.core.widget.SNSToolbarView;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.d;
import d10.l;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\b\u0017\u0018\u0000 72\u00020\u0001:\u0006789:;<B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0015J\u0014\u0010\u001b\u001a\u00060\u0017R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020 H\u0014¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u001d2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010/\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u000202H\u0002J\u001b\u00103\u001a\u00020\u000f*\u00020\u001a2\b\u00104\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0002\b6R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006="}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "internalPickerCallback", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerCallBack;", "itemLayoutId", "", "getItemLayoutId", "()I", "pickerCallBack", "getPickerCallBack", "()Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerCallBack;", "setPickerCallBack", "(Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerCallBack;)V", "showSearch", "", "getShowSearch", "()Z", "sortAlphabetically", "getSortAlphabetically", "bindItemViewHolder", "", "holder", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerItemViewHolder;", "position", "item", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "createItemViewHolder", "parentView", "Landroid/view/ViewGroup;", "getThemeBackgroundColor", "view", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Integer;", "getWindowHeight", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDismiss", "onViewCreated", "setupFullHeight", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "isEligibleForQuery", "query", "", "isEligibleForQuery$idensic_mobile_sdk_aar_release", "Companion", "DiffCallBack", "Item", "ItemAdapter", "PickerCallBack", "PickerItemViewHolder", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public class SNSPickerDialog extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((r) null);
    public static final String EXTRA_ITEMS = "extra_items";
    public static final String EXTRA_ITEM_LAYOUT_ID = "extra_item_layout_id";
    public static final String EXTRA_REQUEST_KEY = "extra_request_key";
    public static final String EXTRA_RESULT_KEY = "EXTRA_RESULT_KEY";
    public static final String EXTRA_SHOW_SEARCH = "extra_show_search";
    public static final String EXTRA_SORT = "extra_sort";
    public static final String TAG = "SNSPickerDialog";
    private final PickerCallBack internalPickerCallback = new SNSPickerDialog$internalPickerCallback$1(this);
    private PickerCallBack pickerCallBack;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JO\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Companion;", "", "()V", "EXTRA_ITEMS", "", "EXTRA_ITEM_LAYOUT_ID", "EXTRA_REQUEST_KEY", "EXTRA_RESULT_KEY", "EXTRA_SHOW_SEARCH", "EXTRA_SORT", "TAG", "newInstance", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog;", "items", "", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "itemLayoutId", "", "sort", "", "showSearch", "requestKey", "resultKey", "([Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;IZZLjava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ SNSPickerDialog newInstance$default(Companion companion, Item[] itemArr, int i11, boolean z11, boolean z12, String str, String str2, int i12, Object obj) {
            return companion.newInstance(itemArr, i11, (i12 & 4) != 0 ? true : z11, (i12 & 8) != 0 ? true : z12, (i12 & 16) != 0 ? null : str, (i12 & 32) != 0 ? null : str2);
        }

        public final SNSPickerDialog newInstance(Item[] itemArr, int i11, boolean z11, boolean z12, String str, String str2) {
            SNSPickerDialog sNSPickerDialog = new SNSPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(SNSPickerDialog.EXTRA_ITEMS, itemArr);
            bundle.putInt(SNSPickerDialog.EXTRA_ITEM_LAYOUT_ID, i11);
            bundle.putBoolean(SNSPickerDialog.EXTRA_SORT, z11);
            bundle.putBoolean(SNSPickerDialog.EXTRA_SHOW_SEARCH, z12);
            if (str != null) {
                bundle.putString(SNSPickerDialog.EXTRA_REQUEST_KEY, str);
            }
            if (str2 != null) {
                bundle.putString(SNSPickerDialog.EXTRA_RESULT_KEY, str2);
            }
            sNSPickerDialog.setArguments(bundle);
            return sNSPickerDialog;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$DiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DiffCallBack extends DiffUtil.Callback {
        private final List<Item> newList;
        private final List<Item> oldList;

        public DiffCallBack(List<Item> list, List<Item> list2) {
            this.oldList = list;
            this.newList = list2;
        }

        public boolean areContentsTheSame(int i11, int i12) {
            return x.b(this.oldList.get(i11), this.newList.get(i12));
        }

        public boolean areItemsTheSame(int i11, int i12) {
            return x.b(this.oldList.get(i11), this.newList.get(i12));
        }

        public int getNewListSize() {
            return this.newList.size();
        }

        public int getOldListSize() {
            return this.oldList.size();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "Landroid/os/Parcelable;", "id", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Item implements Parcelable {
        public static final Parcelable.Creator<Item> CREATOR = new Creator();

        /* renamed from: id  reason: collision with root package name */
        private final String f31227id;
        private final String title;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Item> {
            public final Item createFromParcel(Parcel parcel) {
                return new Item(parcel.readString(), parcel.readString());
            }

            public final Item[] newArray(int i11) {
                return new Item[i11];
            }
        }

        public Item(String str, String str2) {
            this.f31227id = str;
            this.title = str2;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = item.f31227id;
            }
            if ((i11 & 2) != 0) {
                str2 = item.title;
            }
            return item.copy(str, str2);
        }

        public final String component1() {
            return this.f31227id;
        }

        public final String component2() {
            return this.title;
        }

        public final Item copy(String str, String str2) {
            return new Item(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return x.b(this.f31227id, item.f31227id) && x.b(this.title, item.title);
        }

        public final String getId() {
            return this.f31227id;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (this.f31227id.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "Item(id=" + this.f31227id + ", title=" + this.title + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f31227id);
            parcel.writeString(this.title);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u00012\u00020\u0004B7\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0002R\u00020\u00030\u001e¢\u0006\u0004\b \u0010!J\u001c\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\r\u001a\u00020\f2\n\u0010\n\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerItemViewHolder;", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog;", "Landroid/widget/Filterable;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "Landroid/widget/Filter;", "getFilter", "", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "items", "[Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "Ljava/text/Collator;", "collator", "Ljava/text/Collator;", "Ljava/util/Comparator;", "itemComparator", "Ljava/util/Comparator;", "", "filteredItems", "Ljava/util/List;", "Lkotlin/Function1;", "itemViewHolderFactory", "<init>", "(Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog;[Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;Ljava/text/Collator;Ld10/l;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public final class ItemAdapter extends RecyclerView.Adapter<PickerItemViewHolder> implements Filterable {
        private final Collator collator;
        /* access modifiers changed from: private */
        public final List<Item> filteredItems;
        /* access modifiers changed from: private */
        public final Comparator<Item> itemComparator;
        private final l<ViewGroup, PickerItemViewHolder> itemViewHolderFactory;
        /* access modifiers changed from: private */
        public final Item[] items;

        public ItemAdapter(Item[] itemArr, Collator collator2, l<? super ViewGroup, PickerItemViewHolder> lVar) {
            this.items = itemArr;
            this.collator = collator2;
            this.itemViewHolderFactory = lVar;
            d dVar = new d(this);
            this.itemComparator = dVar;
            ArrayList arrayList = new ArrayList();
            if (itemArr != null) {
                boolean unused = CollectionsKt__MutableCollectionsKt.B(arrayList, itemArr);
            }
            if (SNSPickerDialog.this.getSortAlphabetically()) {
                Collections.sort(arrayList, dVar);
            }
            this.filteredItems = arrayList;
        }

        /* access modifiers changed from: private */
        /* renamed from: itemComparator$lambda-0  reason: not valid java name */
        public static final int m53itemComparator$lambda0(ItemAdapter itemAdapter, Item item, Item item2) {
            return itemAdapter.collator.compare(item.getTitle(), item2.getTitle());
        }

        public Filter getFilter() {
            return new SNSPickerDialog$ItemAdapter$getFilter$1(this, SNSPickerDialog.this);
        }

        public int getItemCount() {
            return this.filteredItems.size();
        }

        public void onBindViewHolder(PickerItemViewHolder pickerItemViewHolder, int i11) {
            pickerItemViewHolder.bind(i11, this.filteredItems.get(i11));
        }

        public PickerItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return this.itemViewHolderFactory.invoke(viewGroup);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerCallBack;", "", "onCancel", "", "onDialogClose", "onDismiss", "onItemSelected", "item", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface PickerCallBack {
        void onCancel();

        void onDialogClose();

        void onDismiss();

        void onItemSelected(Item item);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog;Landroid/view/View;)V", "bind", "", "position", "", "item", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class PickerItemViewHolder extends RecyclerView.ViewHolder {
        public PickerItemViewHolder(View view) {
            super(view);
        }

        public final void bind(int i11, Item item) {
            SNSPickerDialog.this.bindItemViewHolder(this, i11, item);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindItemViewHolder$lambda-10  reason: not valid java name */
    public static final void m50bindItemViewHolder$lambda10(SNSPickerDialog sNSPickerDialog, Item item, View view) {
        sNSPickerDialog.internalPickerCallback.onItemSelected(item);
    }

    /* access modifiers changed from: private */
    public final PickerItemViewHolder createItemViewHolder(ViewGroup viewGroup) {
        Integer a11;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(getItemLayoutId(), viewGroup, false);
        a aVar = a.f31095a;
        d a12 = aVar.a();
        if (!(a12 == null || (a11 = aVar.a(a12, SNSColorElement.LIST_SELECTED_ITEM_BACKGROUND, aVar.a(inflate))) == null)) {
            int intValue = a11.intValue();
            Drawable background = inflate.getBackground();
            RippleDrawable rippleDrawable = background instanceof RippleDrawable ? (RippleDrawable) background : null;
            if (rippleDrawable != null) {
                rippleDrawable.setColor(ColorStateList.valueOf(intValue));
            }
        }
        return new PickerItemViewHolder(inflate);
    }

    private final int getItemLayoutId() {
        return requireArguments().getInt(EXTRA_ITEM_LAYOUT_ID);
    }

    private final boolean getShowSearch() {
        return requireArguments().getBoolean(EXTRA_SHOW_SEARCH, true);
    }

    /* access modifiers changed from: private */
    public final boolean getSortAlphabetically() {
        return requireArguments().getBoolean(EXTRA_SORT, true);
    }

    private final int getWindowHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateDialog$lambda-0  reason: not valid java name */
    public static final void m51onCreateDialog$lambda0(SNSPickerDialog sNSPickerDialog, DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        if (sNSPickerDialog.getShowSearch()) {
            sNSPickerDialog.setupFullHeight(bottomSheetDialog);
        } else {
            BottomSheetBehavior.from((FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet)).setFitToContents(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m52onViewCreated$lambda4(SNSPickerDialog sNSPickerDialog, View view) {
        PickerCallBack pickerCallBack2 = sNSPickerDialog.pickerCallBack;
        if (pickerCallBack2 != null) {
            pickerCallBack2.onDialogClose();
        }
        sNSPickerDialog.dismiss();
    }

    private final void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
        Float a11;
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        int windowHeight = getWindowHeight();
        if (layoutParams != null) {
            layoutParams.height = windowHeight;
        }
        frameLayout.setLayoutParams(layoutParams);
        Integer themeBackgroundColor = getThemeBackgroundColor(frameLayout);
        if (themeBackgroundColor != null) {
            int intValue = themeBackgroundColor.intValue();
            Drawable background = frameLayout.getBackground();
            MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
            if (materialShapeDrawable != null) {
                a aVar = a.f31095a;
                d a12 = aVar.a();
                if (!(a12 == null || (a11 = aVar.a(a12, SNSMetricElement.BOTTOM_SHEET_CORNER_RADIUS)) == null)) {
                    materialShapeDrawable.setCornerSize(a11.floatValue());
                }
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(intValue));
                View findViewById = frameLayout.findViewById(com.sumsub.sns.R.id.sns_bottom_sheet);
                SNSBottomSheetView sNSBottomSheetView = findViewById instanceof SNSBottomSheetView ? (SNSBottomSheetView) findViewById : null;
                if (sNSBottomSheetView != null) {
                    sNSBottomSheetView.setBackground((Drawable) null);
                }
            } else {
                frameLayout.setBackgroundColor(0);
            }
        }
        from.setState(3);
    }

    public void bindItemViewHolder(PickerItemViewHolder pickerItemViewHolder, int i11, Item item) {
        View view = pickerItemViewHolder.itemView;
        ((TextView) view.findViewById(16908308)).setText(item.getTitle());
        view.setOnClickListener(new c(this, item));
    }

    public final PickerCallBack getPickerCallBack() {
        return this.pickerCallBack;
    }

    public Integer getThemeBackgroundColor(View view) {
        a aVar = a.f31095a;
        d a11 = aVar.a();
        if (a11 != null) {
            return aVar.a(a11, SNSColorElement.BOTTOM_SHEET_BACKGROUND, aVar.a(view));
        }
        return null;
    }

    public final boolean isEligibleForQuery$idensic_mobile_sdk_aar_release(Item item, CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        return StringsKt__StringsKt.P(item.getTitle(), charSequence, true);
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        PickerCallBack pickerCallBack2 = this.pickerCallBack;
        if (pickerCallBack2 != null) {
            pickerCallBack2.onCancel();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener(new a(this));
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(getShowSearch() ? com.sumsub.sns.R.layout.sns_picker_dialog : com.sumsub.sns.R.layout.sns_picker_dialog_no_search, viewGroup, false);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        PickerCallBack pickerCallBack2 = this.pickerCallBack;
        if (pickerCallBack2 != null) {
            pickerCallBack2.onDismiss();
        }
        super.onDismiss(dialogInterface);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Item[] itemArr;
        EditText editText;
        EditText editText2;
        EditText editText3;
        Parcelable[] parcelableArray;
        super.onViewCreated(view, bundle);
        SNSToolbarView sNSToolbarView = (SNSToolbarView) view.findViewById(com.sumsub.sns.R.id.sns_toolbar);
        if (sNSToolbarView != null) {
            Drawable onResolveIcon = e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.CLOSE.getImageName());
            if (onResolveIcon == null) {
                onResolveIcon = ResourcesCompat.f(requireContext().getResources(), com.sumsub.sns.R.drawable.sns_ic_close, requireContext().getTheme());
            }
            sNSToolbarView.setCloseButtonDrawable(onResolveIcon);
        }
        if (sNSToolbarView != null) {
            sNSToolbarView.setOnCloseButtonClickListener(new b(this));
        }
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(com.sumsub.sns.R.id.sns_editor_layout);
        ViewGroup.LayoutParams layoutParams = null;
        v.a(this).b(new SNSPickerDialog$onViewCreated$2(this, textInputLayout, (c<? super SNSPickerDialog$onViewCreated$2>) null));
        if (textInputLayout != null) {
            Drawable onResolveIcon2 = e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.SEARCH.getImageName());
            if (onResolveIcon2 == null) {
                onResolveIcon2 = ResourcesCompat.f(requireContext().getResources(), com.sumsub.sns.R.drawable.sns_ic_search, requireContext().getTheme());
            }
            textInputLayout.setStartIconDrawable(onResolveIcon2);
        }
        Bundle arguments = getArguments();
        boolean z11 = false;
        if (arguments == null || (parcelableArray = arguments.getParcelableArray(EXTRA_ITEMS)) == null) {
            itemArr = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                if (parcelable instanceof Item) {
                    arrayList.add(parcelable);
                }
            }
            itemArr = (Item[]) arrayList.toArray(new Item[0]);
        }
        ItemAdapter itemAdapter = new ItemAdapter(itemArr, Collator.getInstance(e0.f32018a.getLocale()), new SNSPickerDialog$onViewCreated$adapter$1(this));
        if (!(textInputLayout == null || (editText3 = textInputLayout.getEditText()) == null)) {
            editText3.addTextChangedListener(new SNSPickerDialog$onViewCreated$$inlined$doOnTextChanged$1(itemAdapter, textInputLayout));
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(com.sumsub.sns.R.id.sns_list);
        if (recyclerView != null) {
            recyclerView.getLayoutManager();
        }
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        }
        if (recyclerView != null) {
            recyclerView.setAdapter(itemAdapter);
        }
        if (!getShowSearch()) {
            if (recyclerView != null) {
                layoutParams = recyclerView.getLayoutParams();
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                recyclerView.setLayoutParams(layoutParams);
            }
        }
        a aVar = a.f31095a;
        d a11 = aVar.a();
        if (a11 != null) {
            Integer a12 = aVar.a(a11, SNSColorElement.LIST_SEPARATOR, recyclerView != null ? aVar.a((View) recyclerView) : false);
            Float a13 = aVar.a(a11, SNSMetricElement.LIST_SEPARATOR_HEIGHT);
            if (!(a12 == null || recyclerView == null)) {
                Float a14 = aVar.a(a11, SNSMetricElement.LIST_SEPARATOR_MARGIN_LEFT);
                float f11 = 0.0f;
                float floatValue = a14 != null ? a14.floatValue() : 0.0f;
                Float a15 = aVar.a(a11, SNSMetricElement.LIST_SEPARATOR_MARGIN_RIGHT);
                if (a15 != null) {
                    f11 = a15.floatValue();
                }
                recyclerView.addItemDecoration(new com.sumsub.sns.core.presentation.base.adapter.decorator.a(floatValue, f11, a13 != null ? a13.floatValue() : (float) i.a(1), a12.intValue()));
            }
            SNSColorElement sNSColorElement = SNSColorElement.FIELD_PLACEHOLDER;
            if (recyclerView != null) {
                z11 = aVar.a((View) recyclerView);
            }
            Integer a16 = aVar.a(a11, sNSColorElement, z11);
            if (a16 != null) {
                int intValue = a16.intValue();
                if (!(textInputLayout == null || (editText2 = textInputLayout.getEditText()) == null)) {
                    editText2.setHintTextColor(intValue);
                }
            }
            if (textInputLayout != null && (editText = textInputLayout.getEditText()) != null) {
                aVar.a((TextView) editText, SNSTypographyElement.SUBTITLE2, SNSColorElement.FIELD_CONTENT);
            }
        }
    }

    public final void setPickerCallBack(PickerCallBack pickerCallBack2) {
        this.pickerCallBack = pickerCallBack2;
    }
}
