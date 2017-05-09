package org.jaffa.persistence.domainobjects;

import org.jaffa.datatypes.*;

/** This is an Interface with mere getters and setters.
 * The Persistence Engine will generate a dynamic proxy for this Interface.
 * The dynamic proxy will be used for persisting data to the database.
 */
public interface IPartPicture {

    // Field constants
    /** A constant to identity the Part field.*/
    public static final String PART = "Part";
    /** A constant to identity the SmallPicture field.*/
    public static final String SMALL_PICTURE = "SmallPicture";
    /** A constant to identity the Picture field.*/
    public static final String PICTURE = "Picture";


    /** Getter for property part.
     * @return Value of property part.
     */
    public java.lang.String getPart();

    /** Setter for property part.
     * @param part Value of property part.
     */
    public void setPart(java.lang.String part);

    /** Getter for property smallPicture.
     * @return Value of property smallPicture.
     */
    public byte[] getSmallPicture();

    /** Setter for property smallPicture.
     * @param smallPicture Value of property smallPicture.
     */
    public void setSmallPicture(byte[] smallPicture);



    /** Getter for property picture.
     * @return Value of property picture.
     */
    public byte[] getPicture();

    /** Setter for property picture.
     * @param picture Value of property picture.
     */
    public void setPicture(byte[] picture);

}
