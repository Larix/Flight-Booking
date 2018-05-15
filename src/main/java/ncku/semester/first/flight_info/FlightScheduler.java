package ncku.semester.first.flight_info;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * The flight scheduler.
 */
public class FlightScheduler {
    /**
     *start date.
     */
    private Date startDate;
    /**
     *end date.
     */
    private Date endDate;
    /**
     *consists of two letters and four digits .
      */
    private String planeModel="";
    /**
     *from city.
     */
    private String fromCity="";
    /**
     *to city.
     */
    private String toCity="";
    /**
     *departure time.
     */
    private Date departureTime=null;
    /**
     *arrival time.
     */
    private Date arrivalTime=null;
    /**
     * airplaneModel.
     */
    private AirplaneModel airplaneModel=null;

    /**
     * Constructor.
     * @param startDate startDate
     * @param endDate endDate
     * @param planeModel planeModel
     * @param fromCity fromCity
     * @param toCity toCity
     * @param departureTime departureTime
     * @param arrivalTime arrivalTime
     * @param airplaneModel airplaneModel
     */
    public FlightScheduler(Date startDate, Date endDate, String planeModel,
                           String fromCity, String toCity, Date departureTime,
                           Date arrivalTime, AirplaneModel airplaneModel) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setPlaneModel(planeModel);
        this.setFromCity(fromCity);
        this.setToCity(toCity);
        this.setDepartureTime(departureTime);
        this.setArrivalTime(arrivalTime);
        this.setAirplaneModel(airplaneModel);
    }

    private void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    private void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    private void setToCity(String toCity) {
        this.toCity = toCity;
    }

    private void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    private void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    private void setAirplaneModel(AirplaneModel airplaneModel) {
        this.airplaneModel = airplaneModel;
    }



    /**
     * constructor without parameter.
     */
    FlightScheduler() {
        initData();
     }

    /**
     * Gets start date.
     * @return the start date
     */
    String getStartDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(startDate);
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    String getEndDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(endDate);
    }

    /**
     * Gets plane model.
     * @return the plane model
     */
    private String getPlaneModel() {
        return planeModel;
    }

    /**
     * Gets from city.
     * @return the from city
     */
    public String getFromCity() {
        return fromCity;
    }

    /**
     * Gets to city.
     * @return the to city
     */
    public String getToCity() {
        return toCity;
    }

    private String getDepartureTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
        return sdf.format(departureTime);
    }

    private String getArrivalTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
        return sdf.format(arrivalTime);
    }

    /**
     * Gets airplane model.
     * @return the airplane model
     */
    public AirplaneModel getAirplaneModel() {
        return airplaneModel;
    }

    @Override
    public String toString() {
        return "\nPlaneModel:" + getPlaneModel() + "\nStartDate:" + getStartDate() +
                "   EndDate:" +  getEndDate() + "\nFrom:"+ getFromCity() + "    To:" + getToCity() +
                "\nDepartureTime:" + getDepartureTime() + "     ArrivalTime:" + getArrivalTime();
    }
    /**
     *Data initial.
     */
    private void initData() {
        FlightProducer flightProducer = new FlightProducer();
        this.planeModel= flightProducer.getRandomPlaneModel();
        Calendar newDate = flightProducer.getRandomDateWithinWeeks();
        this.startDate= newDate.getTime();
        newDate.add(Calendar.DAY_OF_MONTH, 120);
        this.endDate = newDate.getTime();
        ArrayList<String> city = new ArrayList<String>();
        city.add(flightProducer.getRandomCity(0));
        city.add(flightProducer.getRandomCity());
        int temp = (int) (Math.random() * 2);
        this.fromCity = city.get(temp);
        int temp1 = temp < 1 ? 1 : 0;
        this.toCity = city.get(temp1);
        Calendar newTime = flightProducer.getRandomTime();
        this.departureTime = newTime.getTime();
        newTime.add(Calendar.HOUR_OF_DAY, FlightProducer.timeZone);
        this.arrivalTime =newTime.getTime();
        Integer[] seats = {20,30,200};
        this.airplaneModel= new AirplaneModel("747",seats);
    }
}
