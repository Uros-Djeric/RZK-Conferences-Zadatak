
package countryInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ListOfCurrenciesByCodeResult" type="{http://www.oorsprong.org/websamples.countryinfo}ArrayOftCurrency"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listOfCurrenciesByCodeResult"
})
@XmlRootElement(name = "ListOfCurrenciesByCodeResponse")
public class ListOfCurrenciesByCodeResponse {

    @XmlElement(name = "ListOfCurrenciesByCodeResult", required = true)
    protected ArrayOftCurrency listOfCurrenciesByCodeResult;

    /**
     * Gets the value of the listOfCurrenciesByCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCurrency }
     *     
     */
    public ArrayOftCurrency getListOfCurrenciesByCodeResult() {
        return listOfCurrenciesByCodeResult;
    }

    /**
     * Sets the value of the listOfCurrenciesByCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCurrency }
     *     
     */
    public void setListOfCurrenciesByCodeResult(ArrayOftCurrency value) {
        this.listOfCurrenciesByCodeResult = value;
    }

}
