
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetLastChatId_QNAME = new QName("http://webservices/", "getLastChatId");
    private final static QName _GetOldMessagesResponse_QNAME = new QName("http://webservices/", "getOldMessagesResponse");
    private final static QName _SaveMessage_QNAME = new QName("http://webservices/", "saveMessage");
    private final static QName _GetLastChatUserId_QNAME = new QName("http://webservices/", "getLastChatUserId");
    private final static QName _GetOldChatIds_QNAME = new QName("http://webservices/", "getOldChatIds");
    private final static QName _SaveMessageResponse_QNAME = new QName("http://webservices/", "saveMessageResponse");
    private final static QName _GetOldMessages_QNAME = new QName("http://webservices/", "getOldMessages");
    private final static QName _OnlineUsersList_QNAME = new QName("http://webservices/", "onlineUsersList");
    private final static QName _GetLastChatDateTimeResponse_QNAME = new QName("http://webservices/", "getLastChatDateTimeResponse");
    private final static QName _DisconnectFromChatResponse_QNAME = new QName("http://webservices/", "disconnectFromChatResponse");
    private final static QName _GetLastMessage_QNAME = new QName("http://webservices/", "getLastMessage");
    private final static QName _GetOldChatIdsResponse_QNAME = new QName("http://webservices/", "getOldChatIdsResponse");
    private final static QName _GetUserIdFromChatIdResponse_QNAME = new QName("http://webservices/", "getUserIdFromChatIdResponse");
    private final static QName _GetLastMessageResponse_QNAME = new QName("http://webservices/", "getLastMessageResponse");
    private final static QName _GetLastChatIdResponse_QNAME = new QName("http://webservices/", "getLastChatIdResponse");
    private final static QName _OnlineUsersListResponse_QNAME = new QName("http://webservices/", "onlineUsersListResponse");
    private final static QName _ConnectToChatResponse_QNAME = new QName("http://webservices/", "connectToChatResponse");
    private final static QName _GetLastChatUserIdResponse_QNAME = new QName("http://webservices/", "getLastChatUserIdResponse");
    private final static QName _GetLastChatDateTime_QNAME = new QName("http://webservices/", "getLastChatDateTime");
    private final static QName _GetUserIdFromChatId_QNAME = new QName("http://webservices/", "getUserIdFromChatId");
    private final static QName _DisconnectFromChat_QNAME = new QName("http://webservices/", "disconnectFromChat");
    private final static QName _GetOldDatetimes_QNAME = new QName("http://webservices/", "getOldDatetimes");
    private final static QName _ConnectToChat_QNAME = new QName("http://webservices/", "connectToChat");
    private final static QName _GetOldDatetimesResponse_QNAME = new QName("http://webservices/", "getOldDatetimesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConnectToChat }
     * 
     */
    public ConnectToChat createConnectToChat() {
        return new ConnectToChat();
    }

    /**
     * Create an instance of {@link GetOldDatetimesResponse }
     * 
     */
    public GetOldDatetimesResponse createGetOldDatetimesResponse() {
        return new GetOldDatetimesResponse();
    }

    /**
     * Create an instance of {@link GetOldDatetimes }
     * 
     */
    public GetOldDatetimes createGetOldDatetimes() {
        return new GetOldDatetimes();
    }

    /**
     * Create an instance of {@link DisconnectFromChat }
     * 
     */
    public DisconnectFromChat createDisconnectFromChat() {
        return new DisconnectFromChat();
    }

    /**
     * Create an instance of {@link GetUserIdFromChatId }
     * 
     */
    public GetUserIdFromChatId createGetUserIdFromChatId() {
        return new GetUserIdFromChatId();
    }

    /**
     * Create an instance of {@link GetLastChatDateTime }
     * 
     */
    public GetLastChatDateTime createGetLastChatDateTime() {
        return new GetLastChatDateTime();
    }

    /**
     * Create an instance of {@link ConnectToChatResponse }
     * 
     */
    public ConnectToChatResponse createConnectToChatResponse() {
        return new ConnectToChatResponse();
    }

    /**
     * Create an instance of {@link GetLastChatUserIdResponse }
     * 
     */
    public GetLastChatUserIdResponse createGetLastChatUserIdResponse() {
        return new GetLastChatUserIdResponse();
    }

    /**
     * Create an instance of {@link OnlineUsersListResponse }
     * 
     */
    public OnlineUsersListResponse createOnlineUsersListResponse() {
        return new OnlineUsersListResponse();
    }

    /**
     * Create an instance of {@link GetLastChatIdResponse }
     * 
     */
    public GetLastChatIdResponse createGetLastChatIdResponse() {
        return new GetLastChatIdResponse();
    }

    /**
     * Create an instance of {@link GetLastMessageResponse }
     * 
     */
    public GetLastMessageResponse createGetLastMessageResponse() {
        return new GetLastMessageResponse();
    }

    /**
     * Create an instance of {@link GetUserIdFromChatIdResponse }
     * 
     */
    public GetUserIdFromChatIdResponse createGetUserIdFromChatIdResponse() {
        return new GetUserIdFromChatIdResponse();
    }

    /**
     * Create an instance of {@link GetOldChatIdsResponse }
     * 
     */
    public GetOldChatIdsResponse createGetOldChatIdsResponse() {
        return new GetOldChatIdsResponse();
    }

    /**
     * Create an instance of {@link DisconnectFromChatResponse }
     * 
     */
    public DisconnectFromChatResponse createDisconnectFromChatResponse() {
        return new DisconnectFromChatResponse();
    }

    /**
     * Create an instance of {@link GetLastMessage }
     * 
     */
    public GetLastMessage createGetLastMessage() {
        return new GetLastMessage();
    }

    /**
     * Create an instance of {@link GetLastChatDateTimeResponse }
     * 
     */
    public GetLastChatDateTimeResponse createGetLastChatDateTimeResponse() {
        return new GetLastChatDateTimeResponse();
    }

    /**
     * Create an instance of {@link GetOldMessages }
     * 
     */
    public GetOldMessages createGetOldMessages() {
        return new GetOldMessages();
    }

    /**
     * Create an instance of {@link OnlineUsersList }
     * 
     */
    public OnlineUsersList createOnlineUsersList() {
        return new OnlineUsersList();
    }

    /**
     * Create an instance of {@link GetOldChatIds }
     * 
     */
    public GetOldChatIds createGetOldChatIds() {
        return new GetOldChatIds();
    }

    /**
     * Create an instance of {@link SaveMessageResponse }
     * 
     */
    public SaveMessageResponse createSaveMessageResponse() {
        return new SaveMessageResponse();
    }

    /**
     * Create an instance of {@link GetLastChatUserId }
     * 
     */
    public GetLastChatUserId createGetLastChatUserId() {
        return new GetLastChatUserId();
    }

    /**
     * Create an instance of {@link GetLastChatId }
     * 
     */
    public GetLastChatId createGetLastChatId() {
        return new GetLastChatId();
    }

    /**
     * Create an instance of {@link GetOldMessagesResponse }
     * 
     */
    public GetOldMessagesResponse createGetOldMessagesResponse() {
        return new GetOldMessagesResponse();
    }

    /**
     * Create an instance of {@link SaveMessage }
     * 
     */
    public SaveMessage createSaveMessage() {
        return new SaveMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastChatId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLastChatId")
    public JAXBElement<GetLastChatId> createGetLastChatId(GetLastChatId value) {
        return new JAXBElement<GetLastChatId>(_GetLastChatId_QNAME, GetLastChatId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOldMessagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getOldMessagesResponse")
    public JAXBElement<GetOldMessagesResponse> createGetOldMessagesResponse(GetOldMessagesResponse value) {
        return new JAXBElement<GetOldMessagesResponse>(_GetOldMessagesResponse_QNAME, GetOldMessagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "saveMessage")
    public JAXBElement<SaveMessage> createSaveMessage(SaveMessage value) {
        return new JAXBElement<SaveMessage>(_SaveMessage_QNAME, SaveMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastChatUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLastChatUserId")
    public JAXBElement<GetLastChatUserId> createGetLastChatUserId(GetLastChatUserId value) {
        return new JAXBElement<GetLastChatUserId>(_GetLastChatUserId_QNAME, GetLastChatUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOldChatIds }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getOldChatIds")
    public JAXBElement<GetOldChatIds> createGetOldChatIds(GetOldChatIds value) {
        return new JAXBElement<GetOldChatIds>(_GetOldChatIds_QNAME, GetOldChatIds.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "saveMessageResponse")
    public JAXBElement<SaveMessageResponse> createSaveMessageResponse(SaveMessageResponse value) {
        return new JAXBElement<SaveMessageResponse>(_SaveMessageResponse_QNAME, SaveMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOldMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getOldMessages")
    public JAXBElement<GetOldMessages> createGetOldMessages(GetOldMessages value) {
        return new JAXBElement<GetOldMessages>(_GetOldMessages_QNAME, GetOldMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnlineUsersList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "onlineUsersList")
    public JAXBElement<OnlineUsersList> createOnlineUsersList(OnlineUsersList value) {
        return new JAXBElement<OnlineUsersList>(_OnlineUsersList_QNAME, OnlineUsersList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastChatDateTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLastChatDateTimeResponse")
    public JAXBElement<GetLastChatDateTimeResponse> createGetLastChatDateTimeResponse(GetLastChatDateTimeResponse value) {
        return new JAXBElement<GetLastChatDateTimeResponse>(_GetLastChatDateTimeResponse_QNAME, GetLastChatDateTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisconnectFromChatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "disconnectFromChatResponse")
    public JAXBElement<DisconnectFromChatResponse> createDisconnectFromChatResponse(DisconnectFromChatResponse value) {
        return new JAXBElement<DisconnectFromChatResponse>(_DisconnectFromChatResponse_QNAME, DisconnectFromChatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLastMessage")
    public JAXBElement<GetLastMessage> createGetLastMessage(GetLastMessage value) {
        return new JAXBElement<GetLastMessage>(_GetLastMessage_QNAME, GetLastMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOldChatIdsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getOldChatIdsResponse")
    public JAXBElement<GetOldChatIdsResponse> createGetOldChatIdsResponse(GetOldChatIdsResponse value) {
        return new JAXBElement<GetOldChatIdsResponse>(_GetOldChatIdsResponse_QNAME, GetOldChatIdsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdFromChatIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getUserIdFromChatIdResponse")
    public JAXBElement<GetUserIdFromChatIdResponse> createGetUserIdFromChatIdResponse(GetUserIdFromChatIdResponse value) {
        return new JAXBElement<GetUserIdFromChatIdResponse>(_GetUserIdFromChatIdResponse_QNAME, GetUserIdFromChatIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLastMessageResponse")
    public JAXBElement<GetLastMessageResponse> createGetLastMessageResponse(GetLastMessageResponse value) {
        return new JAXBElement<GetLastMessageResponse>(_GetLastMessageResponse_QNAME, GetLastMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastChatIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLastChatIdResponse")
    public JAXBElement<GetLastChatIdResponse> createGetLastChatIdResponse(GetLastChatIdResponse value) {
        return new JAXBElement<GetLastChatIdResponse>(_GetLastChatIdResponse_QNAME, GetLastChatIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnlineUsersListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "onlineUsersListResponse")
    public JAXBElement<OnlineUsersListResponse> createOnlineUsersListResponse(OnlineUsersListResponse value) {
        return new JAXBElement<OnlineUsersListResponse>(_OnlineUsersListResponse_QNAME, OnlineUsersListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectToChatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "connectToChatResponse")
    public JAXBElement<ConnectToChatResponse> createConnectToChatResponse(ConnectToChatResponse value) {
        return new JAXBElement<ConnectToChatResponse>(_ConnectToChatResponse_QNAME, ConnectToChatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastChatUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLastChatUserIdResponse")
    public JAXBElement<GetLastChatUserIdResponse> createGetLastChatUserIdResponse(GetLastChatUserIdResponse value) {
        return new JAXBElement<GetLastChatUserIdResponse>(_GetLastChatUserIdResponse_QNAME, GetLastChatUserIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastChatDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLastChatDateTime")
    public JAXBElement<GetLastChatDateTime> createGetLastChatDateTime(GetLastChatDateTime value) {
        return new JAXBElement<GetLastChatDateTime>(_GetLastChatDateTime_QNAME, GetLastChatDateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdFromChatId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getUserIdFromChatId")
    public JAXBElement<GetUserIdFromChatId> createGetUserIdFromChatId(GetUserIdFromChatId value) {
        return new JAXBElement<GetUserIdFromChatId>(_GetUserIdFromChatId_QNAME, GetUserIdFromChatId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisconnectFromChat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "disconnectFromChat")
    public JAXBElement<DisconnectFromChat> createDisconnectFromChat(DisconnectFromChat value) {
        return new JAXBElement<DisconnectFromChat>(_DisconnectFromChat_QNAME, DisconnectFromChat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOldDatetimes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getOldDatetimes")
    public JAXBElement<GetOldDatetimes> createGetOldDatetimes(GetOldDatetimes value) {
        return new JAXBElement<GetOldDatetimes>(_GetOldDatetimes_QNAME, GetOldDatetimes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectToChat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "connectToChat")
    public JAXBElement<ConnectToChat> createConnectToChat(ConnectToChat value) {
        return new JAXBElement<ConnectToChat>(_ConnectToChat_QNAME, ConnectToChat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOldDatetimesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getOldDatetimesResponse")
    public JAXBElement<GetOldDatetimesResponse> createGetOldDatetimesResponse(GetOldDatetimesResponse value) {
        return new JAXBElement<GetOldDatetimesResponse>(_GetOldDatetimesResponse_QNAME, GetOldDatetimesResponse.class, null, value);
    }

}
