import ncku.semester.first.customer.ContactInformation;
import ncku.semester.first.airline_service.AirlineService;
import ncku.semester.first.airline_service.Service;
import ncku.semester.first.flight_info.AirplaneModel;
import ncku.semester.first.flight_info.FlightProducer;
import ncku.semester.first.flight_info.Flight;
import ncku.semester.first.customer.Passenger;
import ncku.semester.first.flight_info.FlightScheduler;
import ncku.semester.first.script.Scripts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Main
 * Created by Daniel on 2017/10/17.
 */
public class Test {

    public static void main(String args[]) throws Exception
    {
        FlightProducer flightProducer = new FlightProducer();
        flightProducer.produceFlightData();
        AirlineService service = new Service();

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        boolean running = true;
        while (running) {
            System.out.println(Scripts.sayHello);
            System.out.println(Scripts.features);
            int choose = Integer.parseInt(scanner.readLine());
            features:
            switch (choose) {
                case 1:
                    while (true) {
                        System.out.println(Scripts.userFeature);
                        int userChoose = Integer.parseInt(scanner.readLine());
                        switch (userChoose) {
                            case 1:
                                System.out.println("Please Enter Your First Name!");
                                String firstName = scanner.readLine();
                                System.out.println("Please Enter Your Last Name!");
                                String lastName = scanner.readLine();
                                System.out.println("Please Enter Your Title!");
                                System.out.println("Mr/Mrs/Ms");
                                String title = scanner.readLine();
                                System.out.println("Please Enter Your Email!");
                                String emailAddress = scanner.readLine();
                                System.out.println("Please Enter Your Mobile!");
                                String mobile = scanner.readLine();
                                System.out.println("Please Enter Your Birthday!(EX:1991/02/06)");
                                String birthday = scanner.readLine();
                                System.out.println("Please Enter Your Passport Number!");
                                String passportNumber = scanner.readLine();
                                System.out.println("Please Enter Your Passport Country!");
                                String passportCountry = scanner.readLine();
                                System.out.println("Please Enter Your Passport Expiry!(EX:2018/09/06)");
                                String passportExpiry = scanner.readLine();
                                System.out.println("Please Enter Flight You Want To Book!");
                                String flight = scanner.readLine();
                                System.out.println("Please Choose Cabin Class!");
                                String cabinClass = scanner.readLine();
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                String[] userFlightChoose = {flight, cabinClass};
                                Passenger passenger = new Passenger(firstName,
                                        lastName, title, sdf.parse(birthday),
                                        passportNumber, passportCountry, sdf.parse(passportExpiry));
                                String name= lastName + "-" + firstName;
                                ContactInformation contactInformation = new ContactInformation(name, emailAddress, mobile);
                                service.saveContactInformation(passenger, contactInformation);
                                service.bookFlight(passenger, userFlightChoose);
                                break;
                            case 2:
                                System.out.println("Please Enter Your First Name!");
                                firstName = scanner.readLine();
                                System.out.println("Please Enter Your Last Name!");
                                lastName = scanner.readLine();
                                service.cancelBooking(lastName + "," + firstName);
                                break;
                            case 3:
                                service.showFlight();
                                break;
                            case 4:
                                System.out.println("Choose The Departure City!");
                                String departureCity = scanner.readLine();
                                System.out.println("Choose The Arrival City!");
                                String arrivalCity = scanner.readLine();
                                service.showFlight(departureCity,arrivalCity);
                                break;
                            case 5:
                                System.out.println("Please Enter Your Booking Number!");
                                String bookingNumber = scanner.readLine();
                                service.showPassenger(bookingNumber);
                                break;
                            case 6:
                                System.out.println("Exit");
                                break features;
                        }
                    }
                case 2:
                    while (true) {
                        System.out.println(Scripts.managerFeature);
                        int managerChoose = Integer.parseInt(scanner.readLine());
                        switch (managerChoose) {
                            case 1:
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm");
                                System.out.println("Please Enter Start Date!(yyyy/MM/dd)");
                                Date startDate = sdf.parse(scanner.readLine());
                                System.out.println("Please Enter End Date!(yyyy/MM/dd)");
                                Date endDate = sdf.parse(scanner.readLine());
                                System.out.println("Please Enter Plane Model!");
                                String planeModel = scanner.readLine();
                                System.out.println("Please Enter Departure From Which City!");
                                String fromCity = scanner.readLine();
                                System.out.println("Please Enter Arrive To Which City!");
                                String toCity = scanner.readLine();
                                System.out.println("Please Enter Departure Time!(hh:mm)");
                                Date departureTime = sdfTime.parse(scanner.readLine());
                                System.out.println("Please Enter Arrival Time!(hh:mm)");
                                Date arrivalTime = sdfTime.parse(scanner.readLine());
                                System.out.println("Please Enter Seats Amount of First Class!");
                                Integer first = Integer.parseInt(scanner.readLine());
                                System.out.println("Please Enter Seats Amount of Economy Class!");
                                Integer economy = Integer.parseInt(scanner.readLine());
                                System.out.println("Please Enter Seats Amount of Business Class!");
                                Integer business = Integer.parseInt(scanner.readLine());
                                Integer[] seats = {first,economy,business};
                                System.out.println("Please Enter Model of This Plane!");
                                String model = scanner.readLine();
                                AirplaneModel airplaneModel = new AirplaneModel(model,seats);
                                FlightScheduler flightScheduler = new FlightScheduler(startDate, endDate,  planeModel,
                                    fromCity,  toCity,  departureTime, arrivalTime, airplaneModel);
                                System.out.println("Please Enter The Departure Date!");
                                String departureDate = scanner.readLine();

                                flightProducer.produceFlightData(flightScheduler, sdf.parse(departureDate));
                                flightProducer.produceFlightData();
                                break;
                            case 2:
                                flightProducer.produceFlightData();
                                break;
                            case 3:
                                System.out.println("Please Enter The Flight You Want To Remove");
                                for (String key : FlightProducer.flightMap.keySet()) {
                                    Flight flight = FlightProducer.getFlight(key);
                                    System.out.println(key + flight + flight.getFlightScheduler().getAirplaneModel());
                                }
                                String flight = scanner.readLine();
                                FlightProducer.flightMap.remove(flight);
                                break;
                            case 4:
                                service.showFlightWithPassengerInfo();
                                break;
                            case 5:
                                System.out.println("Exit");
                                break features;
                        }
                    }
                case 3:
                    running = false;
                default:
                    System.out.println("GoodBye!");
                    break;
            }
        }
    }
}
