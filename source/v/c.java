package v;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.Quirk;
import com.adjust.sdk.Constants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class c implements Quirk {

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Pair<String, String>> f16625b = new HashSet(Arrays.asList(new Pair[]{Pair.create(Constants.REFERRER_API_SAMSUNG, "dm3q"), Pair.create(Constants.REFERRER_API_SAMSUNG, "q2q"), Pair.create(Constants.REFERRER_API_SAMSUNG, "a52sxq"), Pair.create(Constants.REFERRER_API_SAMSUNG, "b0q")}));

    /* renamed from: a  reason: collision with root package name */
    public final Set<Pair<String, Integer>> f16626a;

    public c() {
        HashSet hashSet = new HashSet();
        this.f16626a = hashSet;
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("SAMSUNG") && Build.DEVICE.equalsIgnoreCase("dm3q")) {
            hashSet.addAll(Arrays.asList(new Pair[]{Pair.create("1", 1), Pair.create("1", 4), Pair.create("3", 1), Pair.create("3", 4)}));
        } else if (str.equalsIgnoreCase("SAMSUNG") && Build.DEVICE.equalsIgnoreCase("q2q")) {
            hashSet.addAll(Arrays.asList(new Pair[]{Pair.create("0", 1), Pair.create("0", 4)}));
        } else if (str.equalsIgnoreCase("SAMSUNG") && Build.DEVICE.equalsIgnoreCase("a52sxq")) {
            hashSet.addAll(Arrays.asList(new Pair[]{Pair.create("0", 1), Pair.create("0", 4)}));
        } else if (str.equalsIgnoreCase("SAMSUNG") && Build.DEVICE.equalsIgnoreCase("b0q")) {
            hashSet.addAll(Arrays.asList(new Pair[]{Pair.create("3", 1), Pair.create("3", 4)}));
        }
    }

    public static boolean c() {
        Set<Pair<String, String>> set = f16625b;
        String str = Build.BRAND;
        Locale locale = Locale.US;
        return set.contains(Pair.create(str.toLowerCase(locale), Build.DEVICE.toLowerCase(locale)));
    }
}
