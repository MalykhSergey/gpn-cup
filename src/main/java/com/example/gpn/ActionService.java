package com.example.gpn;

import com.example.gpn.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.annotation.PostConstruct;

@Service
public class ActionService extends WebServiceGatewaySupport {
    private Jaxb2Marshaller marshaller;

    @Autowired
    public ActionService(Jaxb2Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    @PostConstruct
    private void init() {
        this.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);
    }

    public AddResponse addNums(int A, int B) {
        Add addRequest = new Add();
        addRequest.setIntA(A);
        addRequest.setIntB(B);
        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", addRequest, new SoapActionCallback("http://tempuri.org/Add"));
        return response;
    }

    public SubtractResponse subtractNums(int A, int B) {
        Subtract subtractRequest = new Subtract();
        subtractRequest.setIntA(A);
        subtractRequest.setIntB(B);
        SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", subtractRequest, new SoapActionCallback("http://tempuri.org/Subtract"));
        return response;
    }

    public DivideResponse divideNums(int A, int B) {
        Divide divideRequest = new Divide();
        divideRequest.setIntA(A);
        divideRequest.setIntB(B);
        DivideResponse response = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", divideRequest, new SoapActionCallback("http://tempuri.org/Divide"));
        return response;
    }

    public MultiplyResponse multiplyNums(int A, int B) {
        Multiply multiplyRequest = new Multiply();
        multiplyRequest.setIntA(A);
        multiplyRequest.setIntB(B);
        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", multiplyRequest, new SoapActionCallback("http://tempuri.org/Multiply"));
        return response;
    }
}
