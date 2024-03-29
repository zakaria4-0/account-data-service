package net.kerouad.customerdataservice.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.0
 * 2024-01-18T13:13:08.404+01:00
 * Generated source version: 4.0.0
 *
 */
@WebService(targetNamespace = "http://web.customerdataservice.kerouad.net/", name = "CustomerSoapService")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerSoapService {

    @WebMethod
    @RequestWrapper(localName = "findCustomerById", targetNamespace = "http://web.customerdataservice.kerouad.net/", className = "net.kerouad.customerdataservice.web.FindCustomerById")
    @ResponseWrapper(localName = "findCustomerByIdResponse", targetNamespace = "http://web.customerdataservice.kerouad.net/", className = "net.kerouad.customerdataservice.web.FindCustomerByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public net.kerouad.customerdataservice.web.Customer findCustomerById(

        @WebParam(name = "id", targetNamespace = "")
        java.lang.Long id
    );

    @WebMethod
    @RequestWrapper(localName = "findAll", targetNamespace = "http://web.customerdataservice.kerouad.net/", className = "net.kerouad.customerdataservice.web.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://web.customerdataservice.kerouad.net/", className = "net.kerouad.customerdataservice.web.FindAllResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<net.kerouad.customerdataservice.web.Customer> findAll()
;

    @WebMethod
    @RequestWrapper(localName = "save", targetNamespace = "http://web.customerdataservice.kerouad.net/", className = "net.kerouad.customerdataservice.web.Save")
    @ResponseWrapper(localName = "saveResponse", targetNamespace = "http://web.customerdataservice.kerouad.net/", className = "net.kerouad.customerdataservice.web.SaveResponse")
    @WebResult(name = "return", targetNamespace = "")
    public net.kerouad.customerdataservice.web.Customer save(

        @WebParam(name = "arg0", targetNamespace = "")
        net.kerouad.customerdataservice.web.CustomerRequest arg0
    );
}
