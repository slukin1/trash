package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.content.ContextCompat;
import f1.c;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

public class y extends c implements View.OnClickListener {

    /* renamed from: m  reason: collision with root package name */
    public final SearchView f4707m;

    /* renamed from: n  reason: collision with root package name */
    public final SearchableInfo f4708n;

    /* renamed from: o  reason: collision with root package name */
    public final Context f4709o;

    /* renamed from: p  reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f4710p;

    /* renamed from: q  reason: collision with root package name */
    public final int f4711q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4712r = false;

    /* renamed from: s  reason: collision with root package name */
    public int f4713s = 1;

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f4714t;

    /* renamed from: u  reason: collision with root package name */
    public int f4715u = -1;

    /* renamed from: v  reason: collision with root package name */
    public int f4716v = -1;

    /* renamed from: w  reason: collision with root package name */
    public int f4717w = -1;

    /* renamed from: x  reason: collision with root package name */
    public int f4718x = -1;

    /* renamed from: y  reason: collision with root package name */
    public int f4719y = -1;

    /* renamed from: z  reason: collision with root package name */
    public int f4720z = -1;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f4721a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f4722b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f4723c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f4724d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f4725e;

        public a(View view) {
            this.f4721a = (TextView) view.findViewById(16908308);
            this.f4722b = (TextView) view.findViewById(16908309);
            this.f4723c = (ImageView) view.findViewById(16908295);
            this.f4724d = (ImageView) view.findViewById(16908296);
            this.f4725e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public y(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f4707m = searchView;
        this.f4708n = searchableInfo;
        this.f4711q = searchView.getSuggestionCommitIconResId();
        this.f4709o = context;
        this.f4710p = weakHashMap;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    public static String w(Cursor cursor, int i11) {
        if (i11 == -1) {
            return null;
        }
        try {
            return cursor.getString(i11);
        } catch (Exception e11) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e11);
            return null;
        }
    }

    public final void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f4710p.put(str, drawable.getConstantState());
        }
    }

    public final void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    public void a(Cursor cursor) {
        if (this.f4712r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f4715u = cursor.getColumnIndex("suggest_text_1");
                this.f4716v = cursor.getColumnIndex("suggest_text_2");
                this.f4717w = cursor.getColumnIndex("suggest_text_2_url");
                this.f4718x = cursor.getColumnIndex("suggest_icon_1");
                this.f4719y = cursor.getColumnIndex("suggest_icon_2");
                this.f4720z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e11) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e11);
        }
    }

    public CharSequence c(Cursor cursor) {
        String o11;
        String o12;
        if (cursor == null) {
            return null;
        }
        String o13 = o(cursor, "suggest_intent_query");
        if (o13 != null) {
            return o13;
        }
        if (this.f4708n.shouldRewriteQueryFromData() && (o12 = o(cursor, "suggest_intent_data")) != null) {
            return o12;
        }
        if (!this.f4708n.shouldRewriteQueryFromText() || (o11 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o11;
    }

    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f4707m.getVisibility() == 0 && this.f4707m.getWindowVisibility() == 0) {
            try {
                Cursor v11 = v(this.f4708n, charSequence2, 50);
                if (v11 != null) {
                    v11.getCount();
                    return v11;
                }
            } catch (RuntimeException e11) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e11);
            }
        }
        return null;
    }

    public void e(View view, Context context, Cursor cursor) {
        CharSequence charSequence;
        a aVar = (a) view.getTag();
        int i11 = this.f4720z;
        int i12 = i11 != -1 ? cursor.getInt(i11) : 0;
        if (aVar.f4721a != null) {
            z(aVar.f4721a, w(cursor, this.f4715u));
        }
        if (aVar.f4722b != null) {
            String w11 = w(cursor, this.f4717w);
            if (w11 != null) {
                charSequence = l(w11);
            } else {
                charSequence = w(cursor, this.f4716v);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = aVar.f4721a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f4721a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f4721a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f4721a.setMaxLines(1);
                }
            }
            z(aVar.f4722b, charSequence);
        }
        ImageView imageView = aVar.f4723c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f4724d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i13 = this.f4713s;
        if (i13 == 2 || (i13 == 1 && (i12 & 1) != 0)) {
            aVar.f4725e.setVisibility(0);
            aVar.f4725e.setTag(aVar.f4721a.getText());
            aVar.f4725e.setOnClickListener(this);
            return;
        }
        aVar.f4725e.setVisibility(8);
    }

    public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i11, view, viewGroup);
        } catch (RuntimeException e11) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e11);
            View g11 = g(this.f4709o, b(), viewGroup);
            if (g11 != null) {
                ((a) g11.getTag()).f4721a.setText(e11.toString());
            }
            return g11;
        }
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i11, view, viewGroup);
        } catch (RuntimeException e11) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e11);
            View h11 = h(this.f4709o, b(), viewGroup);
            if (h11 != null) {
                ((a) h11.getTag()).f4721a.setText(e11.toString());
            }
            return h11;
        }
    }

    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h11 = super.h(context, cursor, viewGroup);
        h11.setTag(new a(h11));
        ((ImageView) h11.findViewById(R$id.edit_query)).setImageResource(this.f4711q);
        return h11;
    }

    public boolean hasStableIds() {
        return false;
    }

    public final Drawable k(String str) {
        Drawable.ConstantState constantState = this.f4710p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence l(CharSequence charSequence) {
        if (this.f4714t == null) {
            TypedValue typedValue = new TypedValue();
            this.f4709o.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.f4714t = this.f4709o.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f4714t, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f4709o.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.w("SuggestionsAdapter", e11.toString());
            return null;
        }
    }

    public final Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f4710p.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f4710p.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f4709o.getResources());
        }
        Drawable m11 = m(componentName);
        if (m11 != null) {
            constantState = m11.getConstantState();
        }
        this.f4710p.put(flattenToShortString, constantState);
        return m11;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f4707m.onQueryRefine((CharSequence) tag);
        }
    }

    public final Drawable p() {
        Drawable n11 = n(this.f4708n.getSearchActivity());
        if (n11 != null) {
            return n11;
        }
        return this.f4709o.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable q(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r7 = r6.r(r7)     // Catch:{ NotFoundException -> 0x0016 }
            return r7
        L_0x0016:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x002d:
            android.content.Context r3 = r6.f4709o     // Catch:{ FileNotFoundException -> 0x0085 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x006e
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0055 }
            r3.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0054
        L_0x0041:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0054:
            return r4
        L_0x0055:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x006d
        L_0x005a:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006d:
            throw r4     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006e:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.q(android.net.Uri):android.graphics.drawable.Drawable");
    }

    public Drawable r(Uri uri) throws FileNotFoundException {
        int i11;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f4709o.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i11 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i11 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i11 != 0) {
                        return resourcesForApplication.getDrawable(i11);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    public final Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f4709o.getPackageName() + "/" + parseInt;
            Drawable k11 = k(str2);
            if (k11 != null) {
                return k11;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f4709o, parseInt);
            A(str2, drawable);
            return drawable;
        } catch (NumberFormatException unused) {
            Drawable k12 = k(str);
            if (k12 != null) {
                return k12;
            }
            Drawable q11 = q(Uri.parse(str));
            A(str, q11);
            return q11;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    public final Drawable t(Cursor cursor) {
        int i11 = this.f4718x;
        if (i11 == -1) {
            return null;
        }
        Drawable s11 = s(cursor.getString(i11));
        if (s11 != null) {
            return s11;
        }
        return p();
    }

    public final Drawable u(Cursor cursor) {
        int i11 = this.f4719y;
        if (i11 == -1) {
            return null;
        }
        return s(cursor.getString(i11));
    }

    public Cursor v(SearchableInfo searchableInfo, String str, int i11) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i11 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i11));
        }
        return this.f4709o.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public void x(int i11) {
        this.f4713s = i11;
    }

    public final void y(ImageView imageView, Drawable drawable, int i11) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i11);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
