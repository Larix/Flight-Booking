package ncku.semester.first.customer;

import java.util.Date;

/**
 * Passenger Information..
 * Created by Larix on 2017/10/16.
 */
public class Passenger {

    private String firstName;
    private String lastName;
    private String title;
    private Date birthday;
    private String passportNumber;
    private String bookingNumber;
    private String passportCountry;
    private Date passportExpiry;

    public Passenger(String firstName, String lastName, String title, Date birthday, String passportNumber, String passportCountry, Date passportExpiry) {
        this.setName(firstName, lastName);
        this.setTitle(title);
        this.setBirthday(birthday);
        this.setPassportCountry(passportCountry);
        this.setPassportNumber(passportNumber);
        this.setPassportExpiry(passportExpiry);
    }

    /**
     * Sets name.
     * @param firstName the name
     * @param lastName the last name
     */
    private void setName(String firstName, String lastName) { this.firstName = firstName; this.lastName = lastName; }

    /**
     * Gets name.
     * @return the name
     */
    public String getName() { return lastName + "," + firstName; }

    /**
     * Sets title.
     * @param title the title
     */
    private void setTitle(String title) { this.title = title; }
    private String getTitle() { return title; }

    /**
     * Sets birthday.
     * @param birthday the birthday
     */
    private void setBirthday(Date birthday) { this.birthday = birthday; }
    private Date getBirthday() { return birthday; }


    /**
     * Set booking number.
     * @param bookingNumber the booking number
     */
    public void setBookingNumber (String bookingNumber){ this.bookingNumber = bookingNumber; }

    /**
     * Gets booking number.
     * @return the booking number
     */
    public String getBookingNumber() { return bookingNumber; }

    /**
     * Gets order list.
     * @return the order list
     */
    public String getOrderList() { return "Passenger:" +  getName() + "\nBooking Number:" + getBookingNumber();}


    /**
     * Sets passport number.
     * @param passportNumber the passport number
     */
    private void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * Gets passport country.
     * @return the passport country
     */
     private String getPassportCountry() {
        return passportCountry;
    }

    /**
     * Sets passport country.
     * @param passportCountry the passport country
     */
    private void setPassportCountry(String passportCountry) {
        this.passportCountry = passportCountry;
    }

    /**
     * Gets passport expiry.
     * @return the passport expiry
     */
     private Date getPassportExpiry() {
        return passportExpiry;
    }

    /**
     * Sets passport expiry.
     * @param passportExpiry the passport expiry
     */
    private void setPassportExpiry(Date passportExpiry) {
        this.passportExpiry = passportExpiry;
    }
    /**
     * Gets passport number.
     * @return the passport number
     */
    private String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", birthday=" + birthday +
                ", passportNumber='" + passportNumber + '\'' +
                ", bookingNumber='" + bookingNumber + '\'' +
                ", passportCountry='" + passportCountry + '\'' +
                ", passportExpiry=" + passportExpiry +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;

        Passenger passenger = (Passenger) o;

        return (firstName != null ? firstName.equals(passenger.firstName) : passenger.firstName == null) &&
                (lastName != null ? lastName.equals(passenger.lastName) : passenger.lastName == null) &&
                (getTitle() != null ? getTitle().equals(passenger.getTitle()) : passenger.getTitle() == null) &&
                (getBirthday() != null ? getBirthday().equals(passenger.getBirthday()) : passenger.getBirthday() == null) &&
                (getPassportNumber() != null ? getPassportNumber().equals(passenger.getPassportNumber()) : passenger.getPassportNumber() == null) &&
                (getBookingNumber() != null ? getBookingNumber().equals(passenger.getBookingNumber()) : passenger.getBookingNumber() == null) &&
                (getPassportCountry() != null ? getPassportCountry().equals(passenger.getPassportCountry()) : passenger.getPassportCountry() == null) &&
                (getPassportExpiry() != null ? getPassportExpiry().equals(passenger.getPassportExpiry()) : passenger.getPassportExpiry() == null);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
