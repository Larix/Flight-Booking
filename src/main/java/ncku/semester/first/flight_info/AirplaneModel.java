package ncku.semester.first.flight_info;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Airplane Model represents that airplane detail information.
 * Created by Larix on 2017/10/17.
 */
public class AirplaneModel {
    /**
     * model
     */
    private String model="";
    /**
     *map for cabinClassSeats.
     */
    private Map<String, Integer> cabinClassSeatsMap = new HashMap<String, Integer>();
    /**
     *map for fare.
     */
    private Map<String, Integer> cabinClassFareMap = new HashMap<String, Integer>();
    /**
     * constructor.
     */
    public AirplaneModel(String model, Integer[] classSeats) {
        this.model = model;
        cabinClassSeatsMap.put("first",classSeats[0]);
        cabinClassSeatsMap.put("business",classSeats[1]);
        cabinClassSeatsMap.put("economy",classSeats[2]);
    }
    /**
     * get seats amount by differ class.
     * @param cabinClass cabinClass.
     * @return seats amount.
     */
    public Integer getSeatsAmount(String cabinClass){
        return cabinClassSeatsMap.get(cabinClass);
    }
    /**
     * set seats amount by differ class.
     * @param cabinClass cabinClass.
     * @param seatsAmount seatsAmount.
     */
    public void setSeatsAmount(String cabinClass, Integer seatsAmount){
        cabinClassSeatsMap.put(cabinClass,seatsAmount);
    }
    /**
     * Set random fare by different class.
     */
     void setRandomFare() {
        FlightProducer flightProducer = new FlightProducer();
        cabinClassFareMap.put("first", flightProducer.getRandomFare("first"));
        cabinClassFareMap.put("business", flightProducer.getRandomFare("business"));
        cabinClassFareMap.put("economy", flightProducer.getRandomFare("economy"));
    }
    /**
     * Set fare by different class.
     */
    public void setFare(String cabinClass, Integer cabinFare) {
        cabinClassFareMap.put(cabinClass,cabinFare);
    }

    /**
     * Get fare by different class.
     * @param cabinClass cabinClass.
     * @return possible fare.
     */
    Integer getFare(String cabinClass) {
        return cabinClassFareMap.get(cabinClass);
    }

    /**
     * Get fare information.
     * @return fare map.
     */
    private Map<String, Integer> getFares() {
        return Collections.unmodifiableMap (this.cabinClassFareMap);
    }

    /**
     * Gets model.
     * @return the model
     */
    private String getModel() {
        return model;
    }

    /**
     * Get cabin class seats information.
     * @return cabin class seats map.
     */
    private Map<String, Integer> getCabinClassSeats() {
        return Collections.unmodifiableMap (this.cabinClassSeatsMap);
    }
    @Override
    public String toString() {
        return  "Cabin Seats Available:" + getCabinClassSeats()  + "\n" + "Cabin Class Fare:" + getFares() + "\n";
    }
}
