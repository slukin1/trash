package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;
import okio.Okio;

public class e extends RequestHandler {

    /* renamed from: b  reason: collision with root package name */
    public static final UriMatcher f30031b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f30032a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f30031b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public e(Context context) {
        this.f30032a = context;
    }

    public boolean c(q qVar) {
        Uri uri = qVar.f30085d;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f30031b.match(qVar.f30085d) != -1;
    }

    public RequestHandler.a f(q qVar, int i11) throws IOException {
        InputStream j11 = j(qVar);
        if (j11 == null) {
            return null;
        }
        return new RequestHandler.a(Okio.source(j11), Picasso.LoadedFrom.DISK);
    }

    public final InputStream j(q qVar) throws IOException {
        ContentResolver contentResolver = this.f30032a.getContentResolver();
        Uri uri = qVar.f30085d;
        int match = f30031b.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        throw new IllegalStateException("Invalid uri: " + uri);
                    }
                }
            }
            return contentResolver.openInputStream(uri);
        }
        uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
            return null;
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
