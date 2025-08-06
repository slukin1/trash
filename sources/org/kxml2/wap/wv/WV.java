package org.kxml2.wap.wv;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.net.HttpHeaders;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huochat.community.network.domain.DomainTool;
import com.sumsub.sns.internal.core.data.model.q;

public abstract class WV {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f25573a = {"Acceptance", "AddList", "AddNickList", "SName", "WV-CSP-Message", "ClientID", "Code", "ContactList", "ContentData", "ContentEncoding", "ContentSize", "ContentType", "DateTime", "Description", "DetailedResult", "EntityList", "Group", "GroupID", "GroupList", "InUse", "Logo", "MessageCount", "MessageID", "MessageURI", "MSISDN", "Name", "NickList", "NickName", "Poll", "Presence", "PresenceSubList", "PresenceValue", "Property", "Qualifier", "Recipient", "RemoveList", "RemoveNickList", "Result", "ScreenName", "Sender", "Session", "SessionDescriptor", "SessionID", "SessionType", "Status", "Transaction", "TransactionContent", "TransactionDescriptor", "TransactionID", "TransactionMode", "URL", "URLList", "User", "UserID", "UserList", "Validity", "Value"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f25574b = {"AllFunctions", "AllFunctionsRequest", "CancelInvite-Request", "CancelInviteUser-Request", "Capability", "CapabilityList", "CapabilityRequest", "ClientCapability-Request", "ClientCapability-Response", "DigestBytes", "DigestSchema", "Disconnect", "Functions", "GetSPInfo-Request", "GetSPInfo-Response", "InviteID", "InviteNote", "Invite-Request", "Invite-Response", "InviteType", "InviteUser-Request", "InviteUser-Response", "KeepAlive-Request", "KeepAliveTime", "Login-Request", "Login-Response", "Logout-Request", "Nonce", "Password", "Polling-Request", "ResponseNote", "SearchElement", "SearchFindings", "SearchID", "SearchIndex", "SearchLimit", "KeepAlive-Response", "SearchPairList", "Search-Request", "Search-Response", "SearchResult", "Service-Request", "Service-Response", "SessionCookie", "StopSearch-Request", "TimeToLive", "SearchString", "CompletionFlag", null, "ReceiveList", "VerifyID-Request", "Extended-Request", "Extended-Response", "AgreedCapabilityList", "Extended-Data", "OtherServer", "PresenceAttributeNSName", "SessionNSName", "TransactionNSName"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f25575c = {"ADDGM", "AttListFunc", "BLENT", "CAAUT", "CAINV", "CALI", "CCLI", "ContListFunc", "CREAG", "DALI", "DCLI", "DELGR", "FundamentalFeat", "FWMSG", "GALS", "GCLI", "GETGM", "GETGP", "GETLM", "GETM", "GETPR", "GETSPI", "GETWL", "GLBLU", "GRCHN", "GroupAuthFunc", "GroupFeat", "GroupMgmtFunc", "GroupUseFunc", "IMAuthFunc", "IMFeat", "IMReceiveFunc", "IMSendFunc", "INVIT", "InviteFunc", "MBRAC", "MCLS", "MDELIV", "NEWM", "NOTIF", "PresenceAuthFunc", "PresenceDeliverFunc", "PresenceFeat", "REACT", "REJCM", "REJEC", "RMVGM", "SearchFunc", "ServiceFunc", "SETD", "SETGP", "SRCH", "STSRC", "SUBGCN", "UPDPR", "WVCSPFeat", "MF", "MG", "MM"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f25576d = {"AcceptedCharset", "AcceptedContentLength", "AcceptedContentType", "AcceptedTransferEncoding", "AnyContent", "DefaultLanguage", "InitialDeliveryMethod", "MultiTrans", "ParserSize", "ServerPollMin", "SupportedBearer", "SupportedCIRMethod", "TCPAddress", "TCPPort", "UDPPort"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f25577e = {"CancelAuth-Request", "ContactListProperties", "CreateAttributeList-Request", "CreateList-Request", "DefaultAttributeList", "DefaultContactList", "DefaultList", "DeleteAttributeList-Request", "DeleteList-Request", "GetAttributeList-Request", "GetAttributeList-Response", "GetList-Request", "GetList-Response", "GetPresence-Request", "GetPresence-Response", "GetWatcherList-Request", "GetWatcherList-Response", "ListManage-Request", "ListManage-Response", "UnsubscribePresence-Request", "PresenceAuth-Request", "PresenceAuth-User", "PresenceNotification-Request", "UpdatePresence-Request", "SubscribePresence-Request", "Auto-Subscribe", "GetReactiveAuthStatus-Request", "GetReactiveAuthStatus-Response"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f25578f = {"Accuracy", "Address", "AddrPref", "Alias", "Altitude", "Building", "Caddr", "City", "ClientInfo", "ClientProducer", "ClientType", "ClientVersion", "CommC", "CommCap", "ContactInfo", "ContainedvCard", "Country", "Crossing1", "Crossing2", "DevManufacturer", "DirectContent", "FreeTextLocation", "GeoLocation", "Language", "Latitude", "Longitude", "Model", "NamedArea", "OnlineStatus", "PLMN", "PrefC", "PreferredContacts", "PreferredLanguage", "PreferredContent", "PreferredvCard", "Registration", "StatusContent", "StatusMood", "StatusText", "Street", "TimeZone", "UserAvailability", "Cap", "Cname", AppEventsConstants.EVENT_NAME_CONTACT, "Cpriority", "Cstatus", "Note", "Zone", null, "Inf_link", "InfoLink", HttpHeaders.LINK, "Text"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f25579g = {"BlockList", "BlockEntity-Request", "DeliveryMethod", "DeliveryReport", "DeliveryReport-Request", "ForwardMessage-Request", "GetBlockedList-Request", "GetBlockedList-Response", "GetMessageList-Request", "GetMessageList-Response", "GetMessage-Request", "GetMessage-Response", "GrantList", "MessageDelivered", "MessageInfo", "MessageNotification", "NewMessage", "RejectMessage-Request", "SendMessage-Request", "SendMessage-Response", "SetDeliveryMethod-Request", "DeliveryTime"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f25580h = {"AddGroupMembers-Request", "Admin", "CreateGroup-Request", "DeleteGroup-Request", "GetGroupMembers-Request", "GetGroupMembers-Response", "GetGroupProps-Request", "GetGroupProps-Response", "GroupChangeNotice", "GroupProperties", "Joined", "JoinedRequest", "JoinGroup-Request", "JoinGroup-Response", "LeaveGroup-Request", "LeaveGroup-Response", "Left", "MemberAccess-Request", "Mod", "OwnProperties", "RejectList-Request", "RejectList-Response", "RemoveGroupMembers-Request", "SetGroupProps-Request", "SubscribeGroupNotice-Request", "SubscribeGroupNotice-Response", "Users", "WelcomeNote", "JoinGroup", "SubscribeNotification", "SubscribeType", "GetJoinedUsers-Request", "GetJoinedUsers-Response", "AdminMapList", "AdminMapping", "Mapping", "ModMapping", "UserMapList", "UserMapping"};

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f25581i = {"MP", "GETAUT", "GETJU", "VRID", "VerifyIDFunc"};

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f25582j = {"CIR", "Domain", "ExtBlock", "HistoryPeriod", "IDList", "MaxWatcherList", "ReactiveAuthState", "ReactiveAuthStatus", "ReactiveAuthStatusList", "Watcher", "WatcherStatus"};

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f25583k = {"WV-CSP-NSDiscovery-Request", "WV-CSP-NSDiscovery-Response", "VersionList"};

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f25584l = {"xmlns=http://www.wireless-village.org/CSP", "xmlns=http://www.wireless-village.org/PA", "xmlns=http://www.wireless-village.org/TRC", "xmlns=http://www.openmobilealliance.org/DTD/WV-CSP", "xmlns=http://www.openmobilealliance.org/DTD/WV-PA", "xmlns=http://www.openmobilealliance.org/DTD/WV-TRC"};

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f25585m = {"AccessType", "ActiveUsers", "Admin", "application/", "application/vnd.wap.mms-message", "application/x-sms", "AutoJoin", "BASE64", "Closed", "Default", "DisplayName", "F", "G", "GR", DomainTool.DOMAIN_PREFIX_HTTP, DomainTool.DOMAIN_PREFIX, "image/", "Inband", "IM", "MaxActiveUsers", "Mod", "Name", "None", KvStore.N, "Open", "Outband", "PR", "Private", "PrivateMessaging", "PrivilegeLevel", "Public", "P", "Request", "Response", "Restricted", "ScreenName", "Searchable", "S", "SC", "text/", "text/plain", "text/x-vCalendar", "text/x-vCard", "Topic", "T", "Type", "U", "US", "www.wireless-village.org", "AutoDelete", "GM", "Validity", "ShowID", "GRANTED", "PENDING", null, null, null, null, null, null, "GROUP_ID", "GROUP_NAME", "GROUP_TOPIC", "GROUP_USER_ID_JOINED", "GROUP_USER_ID_OWNER", "HTTP", "SMS", "STCP", "SUDP", "USER_ALIAS", "USER_EMAIL_ADDRESS", "USER_FIRST_NAME", "USER_ID", "USER_LAST_NAME", "USER_MOBILE_NUMBER", "USER_ONLINE_STATUS", "WAPSMS", "WAPUDP", "WSP", "GROUP_USER_ID_AUTOJOIN", null, null, null, null, null, null, null, null, null, null, "ANGRY", "ANXIOUS", "ASHAMED", "AUDIO_CALL", "AVAILABLE", "BORED", "CALL", "CLI", "COMPUTER", "DISCREET", "EMAIL", "EXCITED", "HAPPY", "IM", "IM_OFFLINE", "IM_ONLINE", "IN_LOVE", "INVINCIBLE", "JEALOUS", "MMS", "MOBILE_PHONE", "NOT_AVAILABLE", q.f32684d, "PDA", "SAD", "SLEEPY", "SMS", "VIDEO_CALL", "VIDEO_STREAM"};
}
