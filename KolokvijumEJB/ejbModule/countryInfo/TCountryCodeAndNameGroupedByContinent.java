
package countryInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for tCountryCodeAndNameGroupedByContinent complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="tCountryCodeAndNameGroupedByContinent"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Continent" type="{http://www.oorsprong.org/websamples.countryinfo}tContinent"/&amp;gt;
 *         &amp;lt;element name="CountryCodeAndNames" type="{http://www.oorsprong.org/websamples.countryinfo}ArrayOftCountryCodeAndName"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCountryCodeAndNameGroupedByContinent", propOrder = {
    "continent",
    "countryCodeAndNames"
})
public class TCountryCodeAndNameGroupedByContinent {

    @XmlElement(name = "Continent", required = true)
    protected TContinent continent;
    @XmlElement(name = "CountryCodeAndNames", required = true)
    protected ArrayOftCountryCodeAndName countryCodeAndNames;

    /**
     * Gets the value of the continent property.
     * 
     * @return
     *     possible object is
     *     {@link TContinent }
     *     
     */
    public TContinent getContinent() {
        return continent;
    }

    /**
     * Sets the value of the continent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TContinent }
     *     
     */
    public void setContinent(TContinent value) {
        this.continent = value;
    }

    /**
     * Gets the value of the countryCodeAndNames property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCountryCodeAndName }
     *     
     */
    public ArrayOftCountryCodeAndName getCountryCodeAndNames() {
        return countryCodeAndNames;
    }

    /**
     * Sets the value of the countryCodeAndNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCountryCodeAndName }
     *     
     */
    public void setCountryCodeAndNames(ArrayOftCountryCodeAndName value) {
        this.countryCodeAndNames = value;
    }

}
