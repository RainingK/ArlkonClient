
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertIntoDB complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertIntoDB">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transaction_amount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="profit_value" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="loss_value" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertIntoDB", propOrder = {
    "userId",
    "transactionAmount",
    "profitValue",
    "lossValue"
})
public class InsertIntoDB {

    @XmlElement(name = "user_id")
    protected int userId;
    @XmlElement(name = "transaction_amount")
    protected double transactionAmount;
    @XmlElement(name = "profit_value")
    protected double profitValue;
    @XmlElement(name = "loss_value")
    protected double lossValue;

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
     * Gets the value of the transactionAmount property.
     * 
     */
    public double getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     * 
     */
    public void setTransactionAmount(double value) {
        this.transactionAmount = value;
    }

    /**
     * Gets the value of the profitValue property.
     * 
     */
    public double getProfitValue() {
        return profitValue;
    }

    /**
     * Sets the value of the profitValue property.
     * 
     */
    public void setProfitValue(double value) {
        this.profitValue = value;
    }

    /**
     * Gets the value of the lossValue property.
     * 
     */
    public double getLossValue() {
        return lossValue;
    }

    /**
     * Sets the value of the lossValue property.
     * 
     */
    public void setLossValue(double value) {
        this.lossValue = value;
    }

}
