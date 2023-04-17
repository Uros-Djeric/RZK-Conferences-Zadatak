
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
 *         &amp;lt;element name="FullCountryInfoAllCountriesResult" type="{http://www.oorsprong.org/websamples.countryinfo}ArrayOftCountryInfo"/&amp;gt;
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
    "fullCountryInfoAllCountriesResult"
})
@XmlRootElement(name = "FullCountryInfoAllCountriesResponse")
public class FullCountryInfoAllCountriesResponse {

    @XmlElement(name = "FullCountryInfoAllCountriesResult", required = true)
    protected ArrayOftCountryInfo fullCountryInfoAllCountriesResult;

    /**
     * Gets the value of the fullCountryInfoAllCountriesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCountryInfo }
     *     
     */
    public ArrayOftCountryInfo getFullCountryInfoAllCountriesResult() {
        return fullCountryInfoAllCountriesResult;
    }

    /**
     * Sets the value of the fullCountryInfoAllCountriesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCountryInfo }
     *     
     */
    public void setFullCountryInfoAllCountriesResult(ArrayOftCountryInfo value) {
        this.fullCountryInfoAllCountriesResult = value;
    }

}
