
package net.kerouad.customerdataservice.web;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.kerouad.customerdataservice.web package. 
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

    private final static QName _FindAll_QNAME = new QName("http://web.customerdataservice.kerouad.net/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://web.customerdataservice.kerouad.net/", "findAllResponse");
    private final static QName _FindCustomerById_QNAME = new QName("http://web.customerdataservice.kerouad.net/", "findCustomerById");
    private final static QName _FindCustomerByIdResponse_QNAME = new QName("http://web.customerdataservice.kerouad.net/", "findCustomerByIdResponse");
    private final static QName _Save_QNAME = new QName("http://web.customerdataservice.kerouad.net/", "save");
    private final static QName _SaveResponse_QNAME = new QName("http://web.customerdataservice.kerouad.net/", "saveResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.kerouad.customerdataservice.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindCustomerById }
     * 
     */
    public FindCustomerById createFindCustomerById() {
        return new FindCustomerById();
    }

    /**
     * Create an instance of {@link FindCustomerByIdResponse }
     * 
     */
    public FindCustomerByIdResponse createFindCustomerByIdResponse() {
        return new FindCustomerByIdResponse();
    }

    /**
     * Create an instance of {@link Save }
     * 
     */
    public Save createSave() {
        return new Save();
    }

    /**
     * Create an instance of {@link SaveResponse }
     * 
     */
    public SaveResponse createSaveResponse() {
        return new SaveResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link CustomerRequest }
     * 
     */
    public CustomerRequest createCustomerRequest() {
        return new CustomerRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customerdataservice.kerouad.net/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customerdataservice.kerouad.net/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindCustomerById }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customerdataservice.kerouad.net/", name = "findCustomerById")
    public JAXBElement<FindCustomerById> createFindCustomerById(FindCustomerById value) {
        return new JAXBElement<FindCustomerById>(_FindCustomerById_QNAME, FindCustomerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindCustomerByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customerdataservice.kerouad.net/", name = "findCustomerByIdResponse")
    public JAXBElement<FindCustomerByIdResponse> createFindCustomerByIdResponse(FindCustomerByIdResponse value) {
        return new JAXBElement<FindCustomerByIdResponse>(_FindCustomerByIdResponse_QNAME, FindCustomerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Save }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Save }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customerdataservice.kerouad.net/", name = "save")
    public JAXBElement<Save> createSave(Save value) {
        return new JAXBElement<Save>(_Save_QNAME, Save.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customerdataservice.kerouad.net/", name = "saveResponse")
    public JAXBElement<SaveResponse> createSaveResponse(SaveResponse value) {
        return new JAXBElement<SaveResponse>(_SaveResponse_QNAME, SaveResponse.class, null, value);
    }

}
