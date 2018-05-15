package ncku.semester.first.flight_info;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *Produce some flight data used for our system function.
 * Created by Larix on 2017/10/21.
 */
public class FlightProducer {

    static Integer timeZone;

    public static Map<String, Flight> flightMap = new HashMap<String, Flight>();
    /**
     * Taiwan airlines' airline codes from International Air Transport Association.
     */
    private List<String> flightIATA = Arrays.asList("CI", "BR", "AE", "B7", "FE", "IT", "UV");
    /**
     * cabinClass type.
     */
    enum CabinClass {first, business, economy}

    public void produceFlightData() {
        FlightScheduler flightScheduler = new FlightScheduler();
        Date departureDate = getRandomDepartureDate(flightScheduler.getStartDate(),flightScheduler.getEndDate());
        flightScheduler.getAirplaneModel().setRandomFare();
        String flightNumber = Integer.toString(flightMap.size() + 1);
        String flightName = "flight" + flightNumber;
        Flight flight = new Flight(flightScheduler, departureDate);
        flightMap.put(flightName,flight);
    }

    public void produceFlightData(FlightScheduler flightScheduler,Date departureDate) {
        flightScheduler.getAirplaneModel().setRandomFare();
        String flightNumber = Integer.toString(flightMap.size() + 1);
        String flightName = "flight" + flightNumber;
        Flight flight = new Flight(flightScheduler, departureDate);
        flightMap.put(flightName,flight);
    }


    /**
     * Get random planeModel.
     * @return random plane model.
     */
    String getRandomPlaneModel(){
        try {
            return flightIATA.get((new Random()).nextInt(flightIATA.size())) + Integer.toString((int)(Math.random()*999+1));
        }
        catch (Throwable e){
            return null;
        }
    }

    /**
     *Get random date within weeks.
     * @return random date used for startDate.
     */
    Calendar getRandomDateWithinWeeks() {
        try {
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DAY_OF_WEEK, cal.get(Calendar.DAY_OF_MONTH) +
                    (int)(Math.random()*(cal.getActualMaximum(Calendar.DAY_OF_MONTH) -
                            cal.get(Calendar.DAY_OF_MONTH))+1));
            return cal;
        }
        catch (Throwable e){
            return null;
        }
    }

    Calendar getRandomTime() {
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, (int)(Math.random()*24+1));
            cal.set(Calendar.MINUTE, (int)(Math.random()*6)*10);
            return cal;
        }
        catch (Throwable e) {
            return null;
        }
    }

    /**
     *Get random departureDate.
     * @param startDateFromFlightScheduler is startDate from FlightScheduler.
     * @param endDateFromFlightScheduler is endDate from FlightScheduler.
     * @return random departureDate.
     */
    private Date getRandomDepartureDate(String startDateFromFlightScheduler, String endDateFromFlightScheduler) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar cal=Calendar.getInstance();
            Date startDate = sdf.parse(startDateFromFlightScheduler);
            Date endDate = sdf.parse(endDateFromFlightScheduler);
            cal.setTime(startDate);
            cal.add(Calendar.DAY_OF_WEEK,
                    (int)(Math.random()*((endDate.getTime() - startDate.getTime())/(3600*24*1000))+1));
           return cal.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *Get random fare by cabinClass.
     * @param cabinClass cabinClass.
     * @return fare.
     */
     Integer getRandomFare(String cabinClass) {
        CabinClass cabinClassValue = CabinClass.valueOf(cabinClass);
        switch(cabinClassValue) {
            case economy:
                return (int)(Math.random()*30+1)*100 + 1000 + timeZone*2000;
            case business:
                return (int)(Math.random()*80+1)*100 + 8000 + timeZone*3000;
            case first:
                return (int)(Math.random()*200+1)*100 + 16000 + timeZone*4000;
            default:
                return (int)(Math.random()*30+1)*100 + 1000 + timeZone*2000;
        }
    }

    /**
     * Get random city.
     * @return city.
     */
     String getRandomCity(Integer... areaID)  {

        Integer area = areaID.length < 1 ? null : areaID[0];
        String [] cityTaiwan = {"Taipei Taoyuan", "Taipei Sungshan","Kaohsiung"};
        String [] cityNorthEastAsia = {"Tokyo Haneda", "Tokyo Narita", "Osaka", "Sapporo", "Nagoya","Seoul Incheon","Seoul Gimpo","Pusan"};
        String [] cityNorthAmerica = {"Los Angeles", "San Francisco", "New York", "Honolulu", "Guam","Anchorage","Vancouver"};
        String [] cityEurope = {"Frankfurt", "Rome", "Amsterdam", "Vienna"};
        String [] cityAustralia = {"Sydney", "Brisbane", "Melbourne", "Auckland", "Christchurch"};
        String [][] areaSelection = {cityTaiwan,cityNorthEastAsia,cityNorthAmerica,cityEurope,cityAustralia};
        Random random = new Random();
        int areaSelect = random.nextInt(areaSelection.length - 1) + 1;
        if(area!=null) {
            areaSelect = area;
        }
        else {
            List<Integer> time = Arrays.asList(2,12,13,8);
            timeZone = time.get(areaSelect - 1);
        }
        int citySelect = random.nextInt(areaSelection[areaSelect].length);
        return areaSelection[areaSelect][citySelect];
    }

    /**
     * Get flight from flightMap.
     * @param flightName name of flight.
     * @return flight.
     */
    public static Flight getFlight(String flightName) {return flightMap.get(flightName);}
}
