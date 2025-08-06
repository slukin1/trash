package androidx.transition;

import android.view.View;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f11865a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f11866b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<Transition> f11867c = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.f11866b == transitionValues.f11866b && this.f11865a.equals(transitionValues.f11865a);
    }

    public int hashCode() {
        return (this.f11866b.hashCode() * 31) + this.f11865a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f11866b + "\n") + "    values:";
        for (String next : this.f11865a.keySet()) {
            str = str + "    " + next + l.f34627b + this.f11865a.get(next) + "\n";
        }
        return str;
    }

    public TransitionValues(View view) {
        this.f11866b = view;
    }
}
