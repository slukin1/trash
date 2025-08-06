package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.util.Base64;
import android.util.Log;
import androidx.credentials.d;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.domerrors.AbortError;
import androidx.credentials.exceptions.domerrors.ConstraintError;
import androidx.credentials.exceptions.domerrors.DataError;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.InvalidStateError;
import androidx.credentials.exceptions.domerrors.NetworkError;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.domerrors.NotReadableError;
import androidx.credentials.exceptions.domerrors.NotSupportedError;
import androidx.credentials.exceptions.domerrors.SecurityError;
import androidx.credentials.exceptions.domerrors.TimeoutError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialDomException;
import androidx.credentials.n;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions;
import com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorSelectionCriteria;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension;
import com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialDescriptor;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialParameters;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRpEntity;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension;
import com.google.android.gms.fido.fido2.api.common.UvmEntries;
import com.google.android.gms.fido.fido2.api.common.UvmEntry;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.qcloud.tuicore.TUIConstants;
import e1.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class PublicKeyCredentialControllerUtility {
    public static final Companion Companion = new Companion((r) null);
    private static final int FLAGS = 11;
    /* access modifiers changed from: private */
    public static final String TAG = PublicKeyCredentialControllerUtility.class.getName();
    /* access modifiers changed from: private */
    public static final LinkedHashMap<ErrorCode, a> orderedErrorCodeToExceptions = MapsKt__MapsKt.k(l.a(ErrorCode.UNKNOWN_ERR, new UnknownError()), l.a(ErrorCode.ABORT_ERR, new AbortError()), l.a(ErrorCode.ATTESTATION_NOT_PRIVATE_ERR, new NotReadableError()), l.a(ErrorCode.CONSTRAINT_ERR, new ConstraintError()), l.a(ErrorCode.DATA_ERR, new DataError()), l.a(ErrorCode.INVALID_STATE_ERR, new InvalidStateError()), l.a(ErrorCode.ENCODING_ERR, new EncodingError()), l.a(ErrorCode.NETWORK_ERR, new NetworkError()), l.a(ErrorCode.NOT_ALLOWED_ERR, new NotAllowedError()), l.a(ErrorCode.NOT_SUPPORTED_ERR, new NotSupportedError()), l.a(ErrorCode.SECURITY_ERR, new SecurityError()), l.a(ErrorCode.TIMEOUT_ERR, new TimeoutError()));

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final void addOptionalAuthenticatorAttachmentAndExtensions(PublicKeyCredential publicKeyCredential, JSONObject jSONObject) {
            String authenticatorAttachment = publicKeyCredential.getAuthenticatorAttachment();
            AuthenticationExtensionsClientOutputs clientExtensionResults = publicKeyCredential.getClientExtensionResults();
            if (authenticatorAttachment != null) {
                jSONObject.put("authenticatorAttachment", authenticatorAttachment);
            }
            if (clientExtensionResults != null) {
                try {
                    UvmEntries uvmEntries = clientExtensionResults.getUvmEntries();
                    List<UvmEntry> uvmEntryList = uvmEntries != null ? uvmEntries.getUvmEntryList() : null;
                    if (uvmEntryList != null) {
                        JSONArray jSONArray = new JSONArray();
                        for (UvmEntry next : uvmEntryList) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("userVerificationMethod", next.getUserVerificationMethod());
                            jSONObject2.put("keyProtectionType", Short.valueOf(next.getKeyProtectionType()));
                            jSONObject2.put("matcherProtectionType", Short.valueOf(next.getMatcherProtectionType()));
                            jSONArray.put(jSONObject2);
                        }
                        jSONObject.put("uvm", jSONArray);
                    }
                } catch (Throwable th2) {
                    String access$getTAG$cp = PublicKeyCredentialControllerUtility.TAG;
                    Log.e(access$getTAG$cp, "ClientExtensionResults faced possible implementation inconsistency in uvmEntries - " + th2);
                }
            }
        }

        private final void beginSignInAssertionResponse(AuthenticatorAssertionResponse authenticatorAssertionResponse, JSONObject jSONObject, PublicKeyCredential publicKeyCredential) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("clientDataJSON", b64Encode(authenticatorAssertionResponse.getClientDataJSON()));
            jSONObject2.put("authenticatorData", b64Encode(authenticatorAssertionResponse.getAuthenticatorData()));
            jSONObject2.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, b64Encode(authenticatorAssertionResponse.getSignature()));
            if (authenticatorAssertionResponse.getUserHandle() != null) {
                jSONObject2.put("userHandle", PublicKeyCredentialControllerUtility.Companion.b64Encode(authenticatorAssertionResponse.getUserHandle()));
            }
            jSONObject.put("response", jSONObject2);
            jSONObject.put("id", publicKeyCredential.getId());
            jSONObject.put("rawId", b64Encode(publicKeyCredential.getRawId()));
            jSONObject.put("type", publicKeyCredential.getType());
        }

        private final GetCredentialException beginSignInPublicKeyCredentialResponseContainsError(AuthenticatorErrorResponse authenticatorErrorResponse) {
            ErrorCode errorCode = authenticatorErrorResponse.getErrorCode();
            a aVar = getOrderedErrorCodeToExceptions$credentials_play_services_auth_release().get(errorCode);
            String errorMessage = authenticatorErrorResponse.getErrorMessage();
            if (aVar == null) {
                return new GetPublicKeyCredentialDomException(new UnknownError(), "unknown fido gms exception - " + errorMessage);
            }
            if (errorCode == ErrorCode.CONSTRAINT_ERR) {
                boolean z11 = true;
                if (errorMessage == null || !StringsKt__StringsKt.R(errorMessage, "Unable to get sync account", false, 2, (Object) null)) {
                    z11 = false;
                }
                if (z11) {
                    return new GetCredentialCancellationException("Passkey retrieval was cancelled by the user.");
                }
            }
            return new GetPublicKeyCredentialDomException(aVar, errorMessage);
        }

        private final String[] convertToProperNamingScheme(AuthenticatorAttestationResponse authenticatorAttestationResponse) {
            String[] transports = authenticatorAttestationResponse.getTransports();
            int i11 = 0;
            for (String b11 : transports) {
                if (x.b(b11, "cable")) {
                    transports[i11] = "hybrid";
                }
                i11++;
            }
            return transports;
        }

        private final byte[] getChallenge(JSONObject jSONObject) {
            String optString = jSONObject.optString(ClientData.KEY_CHALLENGE, "");
            if (!(optString.length() == 0)) {
                return b64Decode(optString);
            }
            throw new JSONException("Challenge not found in request or is unexpectedly empty");
        }

        public final byte[] b64Decode(String str) {
            return Base64.decode(str, 11);
        }

        public final String b64Encode(byte[] bArr) {
            return Base64.encodeToString(bArr, 11);
        }

        public final boolean checkAlgSupported(int i11) {
            try {
                COSEAlgorithmIdentifier.fromCoseValue(i11);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        public final PublicKeyCredentialCreationOptions convert(d dVar) {
            JSONObject jSONObject = new JSONObject(dVar.c());
            PublicKeyCredentialCreationOptions.Builder builder = new PublicKeyCredentialCreationOptions.Builder();
            parseRequiredChallengeAndUser$credentials_play_services_auth_release(jSONObject, builder);
            parseRequiredRpAndParams$credentials_play_services_auth_release(jSONObject, builder);
            parseOptionalWithRequiredDefaultsAttestationAndExcludeCredentials$credentials_play_services_auth_release(jSONObject, builder);
            parseOptionalTimeout$credentials_play_services_auth_release(jSONObject, builder);
            parseOptionalAuthenticatorSelection$credentials_play_services_auth_release(jSONObject, builder);
            parseOptionalExtensions$credentials_play_services_auth_release(jSONObject, builder);
            return builder.build();
        }

        public final BeginSignInRequest.PasskeyJsonRequestOptions convertToPlayAuthPasskeyJsonRequest(n nVar) {
            return new BeginSignInRequest.PasskeyJsonRequestOptions.Builder().setSupported(true).setRequestJson(nVar.a()).build();
        }

        public final BeginSignInRequest.PasskeysRequestOptions convertToPlayAuthPasskeyRequest(n nVar) {
            JSONObject jSONObject = new JSONObject(nVar.a());
            String optString = jSONObject.optString("rpId", "");
            if (!(optString.length() == 0)) {
                return new BeginSignInRequest.PasskeysRequestOptions.Builder().setSupported(true).setRpId(optString).setChallenge(getChallenge(jSONObject)).build();
            }
            throw new JSONException("GetPublicKeyCredentialOption - rpId not specified in the request or is unexpectedly empty");
        }

        public final LinkedHashMap<ErrorCode, a> getOrderedErrorCodeToExceptions$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.orderedErrorCodeToExceptions;
        }

        public final void parseOptionalAuthenticatorSelection$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            if (jSONObject.has("authenticatorSelection")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("authenticatorSelection");
                AuthenticatorSelectionCriteria.Builder builder2 = new AuthenticatorSelectionCriteria.Builder();
                boolean z11 = false;
                boolean optBoolean = jSONObject2.optBoolean("requireResidentKey", false);
                String optString = jSONObject2.optString("residentKey", "");
                ResidentKeyRequirement residentKeyRequirement = null;
                if (optString.length() > 0) {
                    residentKeyRequirement = ResidentKeyRequirement.fromString(optString);
                }
                builder2.setRequireResidentKey(Boolean.valueOf(optBoolean)).setResidentKeyRequirement(residentKeyRequirement);
                String optString2 = jSONObject2.optString("authenticatorAttachment", "");
                if (optString2.length() > 0) {
                    z11 = true;
                }
                if (z11) {
                    builder2.setAttachment(Attachment.fromString(optString2));
                }
                builder.setAuthenticatorSelection(builder2.build());
            }
        }

        public final void parseOptionalExtensions$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            if (jSONObject.has("extensions")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("extensions");
                AuthenticationExtensions.Builder builder2 = new AuthenticationExtensions.Builder();
                String optString = jSONObject2.optString("appid", "");
                if (optString.length() > 0) {
                    builder2.setFido2Extension(new FidoAppIdExtension(optString));
                }
                if (jSONObject2.optBoolean("thirdPartyPayment", false)) {
                    builder2.setGoogleThirdPartyPaymentExtension(new GoogleThirdPartyPaymentExtension(true));
                }
                if (jSONObject2.optBoolean("uvm", false)) {
                    builder2.setUserVerificationMethodExtension(new UserVerificationMethodExtension(true));
                }
                builder.setAuthenticationExtensions(builder2.build());
            }
        }

        public final void parseOptionalTimeout$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            if (jSONObject.has(OptionsBridge.TIMEOUT_KEY)) {
                builder.setTimeoutSeconds(Double.valueOf(((double) jSONObject.getLong(OptionsBridge.TIMEOUT_KEY)) / ((double) 1000)));
            }
        }

        public final void parseOptionalWithRequiredDefaultsAttestationAndExcludeCredentials$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            ArrayList arrayList = new ArrayList();
            boolean z11 = true;
            if (jSONObject.has("excludeCredentials")) {
                JSONArray jSONArray = jSONObject.getJSONArray("excludeCredentials");
                int length = jSONArray.length();
                int i11 = 0;
                while (i11 < length) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                    byte[] b64Decode = b64Decode(jSONObject2.getString("id"));
                    String string = jSONObject2.getString("type");
                    if (!(b64Decode.length == 0)) {
                        if (!(string.length() == 0)) {
                            ArrayList arrayList2 = null;
                            if (jSONObject2.has("transports")) {
                                arrayList2 = new ArrayList();
                                JSONArray jSONArray2 = jSONObject2.getJSONArray("transports");
                                int length2 = jSONArray2.length();
                                int i12 = 0;
                                while (i12 < length2) {
                                    try {
                                        arrayList2.add(Transport.fromString(jSONArray2.getString(i12)));
                                        i12++;
                                    } catch (Transport.UnsupportedTransportException e11) {
                                        throw new CreatePublicKeyCredentialDomException(new EncodingError(), e11.getMessage());
                                    }
                                }
                            }
                            arrayList.add(new PublicKeyCredentialDescriptor(string, b64Decode, arrayList2));
                            i11++;
                        }
                    }
                    throw new JSONException("PublicKeyCredentialDescriptor id or type value not found or unexpectedly empty");
                }
            }
            builder.setExcludeList(arrayList);
            String str = "none";
            String optString = jSONObject.optString("attestation", str);
            if (optString.length() != 0) {
                z11 = false;
            }
            if (!z11) {
                str = optString;
            }
            builder.setAttestationConveyancePreference(AttestationConveyancePreference.fromString(str));
        }

        public final void parseRequiredChallengeAndUser$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            builder.setChallenge(getChallenge(jSONObject));
            JSONObject jSONObject2 = jSONObject.getJSONObject("user");
            byte[] b64Decode = b64Decode(jSONObject2.getString("id"));
            String string = jSONObject2.getString("name");
            String string2 = jSONObject2.getString("displayName");
            String optString = jSONObject2.optString("icon", "");
            boolean z11 = true;
            if (!(string2.length() == 0)) {
                if (!(b64Decode.length == 0)) {
                    if (string.length() != 0) {
                        z11 = false;
                    }
                    if (!z11) {
                        builder.setUser(new PublicKeyCredentialUserEntity(b64Decode, string, optString, string2));
                        return;
                    }
                }
            }
            throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing one or more of displayName, userId or userName, or they are unexpectedly empty");
        }

        public final void parseRequiredRpAndParams$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("rp");
            String string = jSONObject2.getString("id");
            String optString = jSONObject2.optString("name", "");
            String optString2 = jSONObject2.optString("icon", "");
            if (optString2.length() == 0) {
                optString2 = null;
            }
            if (!(optString.length() == 0)) {
                if (!(string.length() == 0)) {
                    builder.setRp(new PublicKeyCredentialRpEntity(string, optString, optString2));
                    JSONArray jSONArray = jSONObject.getJSONArray("pubKeyCredParams");
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length();
                    int i11 = 0;
                    while (i11 < length) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i11);
                        int i12 = (int) jSONObject3.getLong("alg");
                        String optString3 = jSONObject3.optString("type", "");
                        if (!(optString3.length() == 0)) {
                            if (checkAlgSupported(i12)) {
                                arrayList.add(new PublicKeyCredentialParameters(optString3, i12));
                            }
                            i11++;
                        } else {
                            throw new JSONException("PublicKeyCredentialCreationOptions PublicKeyCredentialParameter type missing or unexpectedly empty");
                        }
                    }
                    builder.setParameters(arrayList);
                    return;
                }
            }
            throw new JSONException("PublicKeyCredentialCreationOptions rp ID or rp name are missing or unexpectedly empty");
        }

        public final CreateCredentialException publicKeyCredentialResponseContainsError(PublicKeyCredential publicKeyCredential) {
            AuthenticatorResponse response = publicKeyCredential.getResponse();
            if (!(response instanceof AuthenticatorErrorResponse)) {
                return null;
            }
            AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) response;
            ErrorCode errorCode = authenticatorErrorResponse.getErrorCode();
            a aVar = getOrderedErrorCodeToExceptions$credentials_play_services_auth_release().get(errorCode);
            String errorMessage = authenticatorErrorResponse.getErrorMessage();
            if (aVar == null) {
                return new CreatePublicKeyCredentialDomException(new UnknownError(), "unknown fido gms exception - " + errorMessage);
            }
            if (errorCode == ErrorCode.CONSTRAINT_ERR) {
                boolean z11 = true;
                if (errorMessage == null || !StringsKt__StringsKt.R(errorMessage, "Unable to get sync account", false, 2, (Object) null)) {
                    z11 = false;
                }
                if (z11) {
                    return new CreateCredentialCancellationException("Passkey registration was cancelled by the user.");
                }
            }
            return new CreatePublicKeyCredentialDomException(aVar, errorMessage);
        }

        public final String toAssertPasskeyResponse(SignInCredential signInCredential) {
            JSONObject jSONObject = new JSONObject();
            PublicKeyCredential publicKeyCredential = signInCredential.getPublicKeyCredential();
            AuthenticatorResponse response = publicKeyCredential != null ? publicKeyCredential.getResponse() : null;
            if (!(response instanceof AuthenticatorErrorResponse)) {
                if (response instanceof AuthenticatorAssertionResponse) {
                    beginSignInAssertionResponse((AuthenticatorAssertionResponse) response, jSONObject, publicKeyCredential);
                } else {
                    String access$getTAG$cp = PublicKeyCredentialControllerUtility.TAG;
                    Log.e(access$getTAG$cp, "AuthenticatorResponse expected assertion response but got: " + response.getClass().getName());
                }
                return jSONObject.toString();
            }
            throw beginSignInPublicKeyCredentialResponseContainsError((AuthenticatorErrorResponse) response);
        }

        public final String toCreatePasskeyResponseJson(PublicKeyCredential publicKeyCredential) {
            JSONObject jSONObject = new JSONObject();
            AuthenticatorResponse response = publicKeyCredential.getResponse();
            if (response instanceof AuthenticatorAttestationResponse) {
                JSONObject jSONObject2 = new JSONObject();
                AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) response;
                jSONObject2.put("clientDataJSON", b64Encode(authenticatorAttestationResponse.getClientDataJSON()));
                jSONObject2.put("attestationObject", b64Encode(authenticatorAttestationResponse.getAttestationObject()));
                jSONObject2.put("transports", new JSONArray(convertToProperNamingScheme(authenticatorAttestationResponse)));
                jSONObject.put("response", jSONObject2);
            } else {
                String access$getTAG$cp = PublicKeyCredentialControllerUtility.TAG;
                Log.e(access$getTAG$cp, "Authenticator response expected registration response but got: " + response.getClass().getName());
            }
            addOptionalAuthenticatorAttachmentAndExtensions(publicKeyCredential, jSONObject);
            jSONObject.put("id", publicKeyCredential.getId());
            jSONObject.put("rawId", b64Encode(publicKeyCredential.getRawId()));
            jSONObject.put("type", publicKeyCredential.getType());
            return jSONObject.toString();
        }
    }

    public static final PublicKeyCredentialCreationOptions convert(d dVar) {
        return Companion.convert(dVar);
    }
}
