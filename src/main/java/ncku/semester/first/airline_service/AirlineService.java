package ncku.semester.first.airline_service;

import ncku.semester.first.customer.ContactInformation;
import ncku.semester.first.customer.Passenger;

/**
 * AirlineService interface.
 * Created by Larix on 2017/11/5.
 */
public interface AirlineService {

    /**
     * Show flight.
     */
    void showFlight();

    /**
     * Show flight by city.
     */
    void showFlight(String fromCity, String toCity);

    /**
     * Show flight with customer info.
     */
    void showFlightWithPassengerInfo();

    /**
     * Book flight.
     * @param passenger the customer
     * @param flightInfo the flight info
     */
    void bookFlight(Passenger passenger, String[] flightInfo);

    /**
     * Save contact information.
     * @param passenger passenger.
     * @param contactInformation contactInformation.
     */
    void saveContactInformation (Passenger passenger, ContactInformation contactInformation);

    /**
     * Cancel booking.
     * @param passengerName the customer name
     */
    void cancelBooking(String passengerName);

    /**
     * Show customer's information.
     * @param bookingNumber the booking number.
     */
    void showPassenger(String bookingNumber);
}
