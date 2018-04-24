
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertIntoDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertIntoDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transaction_result" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="end_method" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertIntoDetails", propOrder = {
    "userId",
    "transactionResult",
    "endMethod"
})
public class InsertIntoDetails {

    @XmlElement(name = "user_id")
    protected int userId;
    @XmlElement(name = "transaction_result")
    protected double transactionResult;
    @XmlElement(name = "end_method")
    protected String endMethod;

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Gets the value of the transactionResult property.
     * 
     */
    public double getTransactionResult() {
        return transactionResult;
    }

    /**
     * Sets the value of the transactionResult property.
     * 
     */
    public void setTransactionResult(double value) {
        this.transactionResult = value;
    }

    /**
     * Gets the value of the endMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndMethod() {
        return endMethod;
    }

    /**
     * Sets the value of the endMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndMethod(String value) {
        this.endMethod = value;
    }

}
