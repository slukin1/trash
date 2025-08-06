package o3;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class k extends i<InputStream> {

    /* renamed from: e  reason: collision with root package name */
    public static final UriMatcher f66535e;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f66535e = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public k(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* renamed from: g */
    public void d(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* renamed from: h */
    public InputStream e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream i11 = i(uri, contentResolver);
        if (i11 != null) {
            return i11;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    public final InputStream i(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f66535e.match(uri);
        if (match != 1) {
            if (match == 3) {
                return j(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return j(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    public final InputStream j(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
