package ncku.semester.first.flight_info;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Flight information.
 * Created by Larix on 2017/10/16.
 */
public class Flight{

    private FlightScheduler flightScheduler;
    private Date departureDate;

    /**
     * constructor.
     * @param flightScheduler the flight scheduler
     * @param departureDate   the departure date
     */
    Flight(FlightScheduler flightScheduler, Date departureDate) {
        this.flightScheduler = flightScheduler;
        this.departureDate = departureDate;
    }

    /**
     * Gets fare.
     * @param cabinClass the cabin class
     * @return the fare
     */
    public double getFare(String cabinClass) {
        return this.flightScheduler.getAirplaneModel().getFare(cabinClass);
    }

    private String getDepartureDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(this.departureDate);
    }

    /**
     * Gets flight scheduler.
     * @return the flight scheduler
     */
    public FlightScheduler getFlightScheduler() {
        return this.flightScheduler;
    }

    @Override
    public String toString() {
        return getFlightScheduler() + "\ndepartureDate:" + getDepartureDate() + "\n";
    }
}
