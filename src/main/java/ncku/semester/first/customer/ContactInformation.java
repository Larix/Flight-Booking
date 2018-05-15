package ncku.semester.first.customer;

/**
 * Contact Information.
 * Created by Larix on 2017/11/6.
 */
public class ContactInformation {
    /**
     * Customer name.
     */
    private String name = null;
    /**
     * Customer emailAddress.
     */
    private String emailAddress = null;

    /**
     * Customer mobile.
     */
    private String mobile = null;

    /**
     * Constructor.
     * @param name customer name
     * @param emailAddress customer emailAddress
     * @param mobile customer phone number
     */
    public ContactInformation(String name, String emailAddress, String mobile) {
        this.setCustomerName(name);
        this.setCustomerEmailAddress(emailAddress);
        this.setCustomerMobile(mobile);
    }

    /**
     * Set customer name.
     * @param name customer name
     */
    private void setCustomerName(String name) {
        this.name = name;
    }

    /**
     * Get customer name.
     * @return customer name
     */
    private String getCustomerName() {
        return this.name;
    }
    /**
     * Set customer emailAddress.
     * @param address customer emailAddress
     */
    private void setCustomerEmailAddress(String address) {
        this.emailAddress = address;
    }

    /**
     * Get customer emailAddress.
     * @return customer emailAddress
     */
    private String getCustomerEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Set customer mobile.
     * @param mobile customer mobile
     */
    private void setCustomerMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Get customer mobile.
     * @return customer mobile
     */
    private String getCustomerMobile() {
        return this.mobile;
    }

    @Override
    public String toString() {
        return "\nCustomer:" + this.name + "Email:" + this.emailAddress + "Mobile:" + this.mobile;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            ContactInformation contactInformation = (ContactInformation) obj;
            if (contactInformation.getCustomerName().equals(this.name)
                    && contactInformation.getCustomerMobile().equals(this.mobile)
                    && contactInformation.getCustomerEmailAddress().equals(this.emailAddress)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}