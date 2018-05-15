package ncku.semester.first.airline_service;

import ncku.semester.first.customer.ContactInformation;
import ncku.semester.first.customer.Passenger;
import ncku.semester.first.flight_info.Flight;
import ncku.semester.first.flight_info.FlightProducer;

import java.util.*;

/**
 * features is used to realize some services in different interface.
 * Created by Larix on 2017/10/25.
 */
public class Service implements AirlineService {
    /**
     * Store passengers' name  and their booking information.
     */
    private Map<String, String[]> bookingMap = new HashMap<String, String[]>();
    /**
     * Store customer and their passengers booking information.
     */
    private Map<Passenger, ContactInformation> contactInformationMap = new HashMap<Passenger, ContactInformation>();
    /**
     * Store passengers list.
     */
    private List<Passenger> passengerList = new ArrayList<Passenger>();

    /**
     * Book flight.
     * @param passenger passenger.
     * @param flightInfo flight name and cabin class.
     */
    public void bookFlight (Passenger passenger, String[] flightInfo) {
        bookingMap.put(passenger.getName(), flightInfo);
        passenger.setBookingNumber(flightInfo[0] + "-" + getPassengersFromFlight(flightInfo[0]).size());
        System.out.println("Your Booking Number is:" + passenger.getBookingNumber());
        adjustFlightSeats("add",flightInfo);
        passengerList.add(passenger);
    }

    /**
     * Save contact information.
     * @param passenger passenger.
     * @param contactInformation contactInformation.
     */
    public void saveContactInformation (Passenger passenger, ContactInformation contactInformation) {
        contactInformationMap.put(passenger, contactInformation);
    }

    /**
     * Cancel  booking.
     * @param passengerName customer name.
     */
    public void cancelBooking (String passengerName) {
        if(bookingMap.containsKey(passengerName)) {
            String[] flightInfo = bookingMap.get(passengerName);
            adjustFlightSeats("delete",flightInfo);
            bookingMap.remove(passengerName);
            for (Passenger passenger: passengerList) {
                if (passenger.getName().equals(passengerName)) {
                    passengerList.remove(passenger);
                }
            }
        } else {
            System.out.println("Cannot find Your Data!!");
        }

    }

    /**
     * Adjust flightSeats.
     * @param action add or delete.
     * @param flightInfo flight name and cabin class.
     */
    private void adjustFlightSeats(String action, String[] flightInfo) {
        Flight flight = FlightProducer.getFlight(flightInfo[0]);
        Integer seatsAmount = flight.getFlightScheduler().getAirplaneModel().getSeatsAmount(flightInfo[1]);
        if (action.equals("add")) {
            if(seatsAmount > 0) {
                flight.getFlightScheduler().getAirplaneModel().setSeatsAmount(flightInfo[1],seatsAmount-1);
                System.out.println("Thanks for your booking!!");
            } else {
                System.out.println("Sorry!The flight is fully booked");
            }
        } else if(action.equals("delete")) {
            flight.getFlightScheduler().getAirplaneModel().setSeatsAmount(flightInfo[1],seatsAmount+1);
            System.out.println("You just canceled a booking!!");
        }

    }

    /**
     * Show flight.
     */
    public void showFlight () {
        for (String key : FlightProducer.flightMap.keySet() ) {
            Flight flight = FlightProducer.getFlight(key);
            System.out.println("\n" + key + flight + flight.getFlightScheduler().getAirplaneModel());
        }
    }


    /**
     * Show flight by city.
     */
    public void showFlight (String fromCity, String toCity) {
        for (String key : FlightProducer.flightMap.keySet() ) {
            Flight flight = FlightProducer.getFlight(key);
            if (!fromCity.equals("") && !toCity.equals("")) {
                if (flight.getFlightScheduler().getFromCity().equals(fromCity)
                        && flight.getFlightScheduler().getToCity().equals(toCity)) {
                    System.out.println("\n" + key + flight + flight.getFlightScheduler().getAirplaneModel());

                }
            } else if (!fromCity.equals("") || !toCity.equals("")) {
                if (flight.getFlightScheduler().getFromCity().equals(fromCity)
                        || flight.getFlightScheduler().getToCity().equals(toCity)) {
                    System.out.println("\n" + key + flight + flight.getFlightScheduler().getAirplaneModel());
                }
            }
            else {
                    System.out.println("Can't find any available flights for you!!");
                }
        }
    }
    /**
     * Show flight information with passengers.
     */
    public void showFlightWithPassengerInfo () {
        for (String key : FlightProducer.flightMap.keySet() ) {
            Flight flight = FlightProducer.getFlight(key);
            System.out.println("\n" + key + flight + flight.getFlightScheduler().getAirplaneModel()
                    + "\nPassengers:" +  getPassengersFromFlight(key).toString());
        }
    }

    /**
     *Get passengers list.
     * @param flight flight name.
     * @return passengers who booked this flight.
     */
    private Set<String> getPassengersFromFlight(String flight) {
        Set<String> passengers =  new HashSet<String>();
        for (String passenger : bookingMap.keySet()) {
            if (bookingMap.get(passenger)[0].equals(flight)) {
                passengers.add(passenger);
            }
        }
        return passengers;
    }

    /**
     * Show passenger info.
     */
    public void showPassenger(String bookingNumber) {
        for (Passenger passenger: passengerList) {
            if (passenger.getBookingNumber().equals(bookingNumber)) {
                ContactInformation contactInformation = contactInformationMap.get(passenger);
                System.out.println(passenger.getOrderList() + contactInformation.toString());
                Flight flight = FlightProducer.getFlight(bookingMap.get(passenger.getName())[0]);
                System.out.println(flight.getFlightScheduler() + "/nFare:" + flight.getFare(bookingMap.get(passenger.getName())[1]));
            }
        }
    }
}
