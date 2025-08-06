package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();
    public final List<String> mFragments;
    public final List<BackStackRecordState> mTransactions;

    public class a implements Parcelable.Creator<BackStackState> {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: b */
        public BackStackState[] newArray(int i11) {
            return new BackStackState[i11];
        }
    }

    public BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.mFragments = list;
        this.mTransactions = list2;
    }

    public int describeContents() {
        return 0;
    }

    public List<a> instantiate(FragmentManager fragmentManager, Map<String, Fragment> map) {
        HashMap hashMap = new HashMap(this.mFragments.size());
        for (String next : this.mFragments) {
            Fragment fragment = map.get(next);
            if (fragment != null) {
                hashMap.put(fragment.mWho, fragment);
            } else {
                Bundle B = fragmentManager.A0().B(next, (Bundle) null);
                if (B != null) {
                    ClassLoader classLoader = fragmentManager.C0().f().getClassLoader();
                    Fragment instantiate = ((FragmentState) B.getParcelable("state")).instantiate(fragmentManager.z0(), classLoader);
                    instantiate.mSavedFragmentState = B;
                    if (B.getBundle("savedInstanceState") == null) {
                        instantiate.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
                    }
                    Bundle bundle = B.getBundle("arguments");
                    if (bundle != null) {
                        bundle.setClassLoader(classLoader);
                    }
                    instantiate.setArguments(bundle);
                    hashMap.put(instantiate.mWho, instantiate);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (BackStackRecordState instantiate2 : this.mTransactions) {
            arrayList.add(instantiate2.instantiate(fragmentManager, hashMap));
        }
        return arrayList;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringList(this.mFragments);
        parcel.writeTypedList(this.mTransactions);
    }

    public BackStackState(Parcel parcel) {
        this.mFragments = parcel.createStringArrayList();
        this.mTransactions = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }
}
