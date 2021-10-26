package com.fox.view;

import com.fox.controller.implementation.*;
import com.fox.model.entity.*;

import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final HotelChainController hotelChainController = new HotelChainController();
    private final CountryController countryController = new CountryController();
    private final RegionController regionController = new RegionController();
    private final CityController cityController = new CityController();
    private final HotelController hotelController = new HotelController();
    private final RoomController roomController = new RoomController();
    private final UserController userController = new UserController();
    private final ReviewController reviewController = new ReviewController();
    private final AmenityController amenityController = new AmenityController();
    private final ReservationController reservationController = new ReservationController();


    public View() {
        menu.put("11", this::getAllHotelChains);
        menu.put("12", this::getHotelChainById);
        menu.put("13", this::createHotelChain);
        menu.put("14", this::updateHotelChain);
        menu.put("15", this::deleteHotelChain);

        menu.put("21", this::getAllCountries);
        menu.put("22", this::getCountryByName);
        menu.put("23", this::createCountry);
        menu.put("24", this::updateCountry);
        menu.put("25", this::deleteCountry);

        menu.put("31", this::getAllRegions);
        menu.put("32", this::getRegionByName);
        menu.put("33", this::createRegion);
        menu.put("34", this::updateRegion);
        menu.put("35", this::deleteRegion);

        menu.put("41", this::getAllCities);
        menu.put("42", this::getCityByName);
        menu.put("43", this::createCity);
        menu.put("44", this::updateCity);
        menu.put("45", this::deleteCity);

        menu.put("51", this::getAllHotels);
        menu.put("52", this::getHotelById);
        menu.put("53", this::createHotel);
        menu.put("54", this::updateHotel);
        menu.put("55", this::deleteHotel);

        menu.put("61", this::getAllRooms);
        menu.put("62", this::getRoomById);
        menu.put("63", this::createRoom);
        menu.put("64", this::updateRoom);
        menu.put("65", this::deleteRoom);

        menu.put("71", this::getAllUsers);
        menu.put("72", this::getUserById);
        menu.put("73", this::createUser);
        menu.put("74", this::updateUser);
        menu.put("75", this::deleteUser);

        menu.put("81", this::getAllReviews);
        menu.put("82", this::getReviewById);
        menu.put("83", this::createReview);
        menu.put("84", this::updateReview);
        menu.put("85", this::deleteReview);

        menu.put("91", this::getAllAmenities);
        menu.put("92", this::getAmenityById);
        menu.put("93", this::createAmenity);
        menu.put("94", this::updateAmenity);
        menu.put("95", this::deleteAmenity);

        menu.put("101", this::getAllReservations);
        menu.put("102", this::getReservationById);
        menu.put("103", this::createReservation);
        menu.put("104", this::updateReservation);
        menu.put("105", this::deleteReservation);
    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter numbers:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    private void getAllHotelChains() throws SQLException {
        System.out.println("\n");
        System.out.println(hotelChainController.findAll() + "\n");
    }

    private void getHotelChainById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(hotelChainController.findById(id) + "\n");
    }

    private HotelChain getHotelChainInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter type: ");
        String type = SCANNER.next();
        System.out.println("Enter parent company: ");
        String parentCompany = SCANNER.next();
        return new HotelChain(name, type, parentCompany);
    }

    private void createHotelChain() throws SQLException {
        System.out.println("\n");
        HotelChain hotelChain = getHotelChainInputs();
        hotelChainController.create(hotelChain);
        System.out.println("Hotel chain was successfully created!\n");
    }

    private void updateHotelChain() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        HotelChain hotelChain = getHotelChainInputs();
        hotelChain.setId(id);
        hotelChainController.update(hotelChain.getId(), hotelChain);
        System.out.println("Updated hotel chain with ID = " + id + "\n");
    }

    private void deleteHotelChain() throws SQLException {
        System.out.println("\nEnter ID to delete hotel chain: ");
        int id = SCANNER.nextInt();
        hotelChainController.delete(id);
        System.out.println("Deleted hotel chain with ID = " + id + "\n");
    }


    private void getAllCountries() throws SQLException {
        System.out.println("\n");
        System.out.println(countryController.findAll() + "\n");
    }

    private void getCountryByName() throws SQLException {
        System.out.println("\nEnter Name: ");
        String name = SCANNER.next();
        System.out.println(countryController.findByName(name) + "\n");
    }

    private Country getCountryInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter population: ");
        Integer population = SCANNER.nextInt();
        System.out.println("Enter area: ");
        Integer area = SCANNER.nextInt();
        return new Country(population, area);
    }

    private void createCountry() throws SQLException {
        System.out.println("\n");
        Country country = getCountryInputs();
        countryController.create(country);
        System.out.println("Country was successfully created!\n");
    }

    private void updateCountry() throws SQLException {
        System.out.println("\nEnter Name for updating: ");
        String name = SCANNER.next();
        Country country = getCountryInputs();
        country.setName(name);
        countryController.update(country.getName(), country);
        System.out.println("Updated country with Name = " + name + "\n");
    }

    private void deleteCountry() throws SQLException {
        System.out.println("\nEnter name to delete country: ");
        String name = SCANNER.next();
        countryController.delete(name);
        System.out.println("Deleted country with name = " + name + "\n");
    }


    private void getAllRegions() throws SQLException {
        System.out.println("\n");
        System.out.println(cityController.findAll() + "\n");
    }

    private void getRegionByName() throws SQLException {
        System.out.println("\nEnter Name: ");
        String name = SCANNER.next();
        System.out.println(regionController.findByName(name) + "\n");
    }

    private Region getRegionInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter country name: ");
        String countryName = SCANNER.next();
        System.out.println("Enter climate: ");
        String climate = SCANNER.next();
        return new Region(name, countryName, climate);
    }

    private void createRegion() throws SQLException {
        System.out.println("\n");
        Region region = getRegionInputs();
        regionController.create(region);
        System.out.println("Region was successfully created!\n");
    }

    private void updateRegion() throws SQLException {
        System.out.println("\nEnter Name for updating: ");
        String name = SCANNER.next();
        System.out.println("\nEnter country name for updating: ");
        String countryName = SCANNER.next();
        Region region = getRegionInputs();
        region.setName(name);
        region.setCountryName(countryName);
        regionController.update(region.getName(), region);
        System.out.println("Updated region with Name = " + name + "\n");
    }

    private void deleteRegion() throws SQLException {
        System.out.println("\nEnter name to delete region: ");
        String name = SCANNER.next();
        countryController.delete(name);
        System.out.println("Deleted region with name = " + name + "\n");
    }


    private void getAllCities() throws SQLException {
        System.out.println("\n");
        System.out.println(cityController.findAll() + "\n");
    }

    private void getCityByName() throws SQLException {
        System.out.println("\nEnter Name: ");
        String name = SCANNER.next();
        System.out.println(cityController.findByName(name) + "\n");
    }

    private City getCityInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter region name: ");
        String regionName = SCANNER.next();
        System.out.println("Enter country name: ");
        String regionCountryName = SCANNER.next();
        System.out.println("Enter language: ");
        String language = SCANNER.next();
        return new City(name, regionName, regionCountryName, language);
    }

    private void createCity() throws SQLException {
        System.out.println("\n");
        City city = getCityInputs();
        cityController.create(city);
        System.out.println("City was successfully created!\n");
    }

    private void updateCity() throws SQLException {
        System.out.println("\nEnter Name for updating: ");
        String name = SCANNER.next();
        System.out.println("\nEnter region name for updating: ");
        String regionName = SCANNER.next();
        System.out.println("\nEnter country name for updating: ");
        String regionCountryName = SCANNER.next();
        City city = getCityInputs();
        city.setName(name);
        city.setRegionName(regionName);
        city.setRegionCountryName(regionCountryName);
        cityController.update(city.getName(), city);
        System.out.println("Updated city with Name = " + name + "\n");
    }

    private void deleteCity() throws SQLException {
        System.out.println("\nEnter name to delete city: ");
        String name = SCANNER.next();
        countryController.delete(name);
        System.out.println("Deleted city with name = " + name + "\n");
    }


    private void getAllHotels() throws SQLException {
        System.out.println("\n");
        System.out.println(hotelController.findAll() + "\n");
    }

    private void getHotelById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(hotelController.findById(id) + "\n");
    }

    private Hotel getHotelInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter hotel chain id: ");
        Integer hotelChainId = SCANNER.nextInt();
        System.out.println("Enter city name: ");
        String cityName = SCANNER.next();
        System.out.println("Enter region name: ");
        String cityRegionName = SCANNER.next();
        System.out.println("Enter country name: ");
        String cityRegionCountryName = SCANNER.next();
        return new Hotel(name, hotelChainId, cityName, cityRegionName, cityRegionCountryName);
    }

    private void createHotel() throws SQLException {
        System.out.println("\n");
        Hotel hotel = getHotelInputs();
        hotelController.create(hotel);
        System.out.println("Hotel was successfully created!\n");
    }

    private void updateHotel() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Hotel hotel = getHotelInputs();
        hotel.setId(id);
        hotelController.update(hotel.getId(), hotel);
        System.out.println("Updated hotel with ID = " + id + "\n");
    }

    private void deleteHotel() throws SQLException {
        System.out.println("\nEnter ID to delete hotel: ");
        int id = SCANNER.nextInt();
        hotelController.delete(id);
        System.out.println("Deleted hotel with ID = " + id + "\n");
    }


    private void getAllRooms() throws SQLException {
        System.out.println("\n");
        System.out.println(roomController.findAll() + "\n");
    }

    private void getRoomById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(roomController.findById(id) + "\n");
    }

    private Room getRoomInputs() {
        System.out.println("\nEnter hotel id: ");
        Integer hotelId = SCANNER.nextInt();
        System.out.println("Enter room number: ");
        String roomNumber = SCANNER.next();
        System.out.println("Enter description: ");
        String description = SCANNER.next();
        return new Room(hotelId, roomNumber, description);
    }

    private void createRoom() throws SQLException {
        System.out.println("\n");
        Room room = getRoomInputs();
        roomController.create(room);
        System.out.println("Room was successfully created!\n");
    }

    private void updateRoom() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Room room = getRoomInputs();
        room.setId(id);
        roomController.update(room.getId(), room);
        System.out.println("Updated room with ID = " + id + "\n");
    }

    private void deleteRoom() throws SQLException {
        System.out.println("\nEnter ID to delete room: ");
        int id = SCANNER.nextInt();
        roomController.delete(id);
        System.out.println("Deleted room with ID = " + id + "\n");
    }


    private void getAllUsers() throws SQLException {
        System.out.println("\n");
        System.out.println(userController.findAll() + "\n");
    }

    private void getUserById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userController.findById(id) + "\n");
    }

    private User getUserInputs() {
        System.out.println("\nEnter surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter email: ");
        String email = SCANNER.next();
        System.out.println("Enter gender: ");
        String gender = SCANNER.next();
        System.out.println("Enter age: ");
        Integer age = SCANNER.nextInt();
        System.out.println("Enter birthday: ");
        String birth = "2020-12-12 01:24:23";
        Timestamp birthday = Timestamp.valueOf(birth);
        System.out.println("Enter phone: ");
        String phone = SCANNER.next();
        return new User(surname, name, email, gender, age, birthday, phone);
    }

    private void createUser() throws SQLException {
        System.out.println("\n");
        User user = getUserInputs();
        userController.create(user);
        System.out.println("User was successfully created!\n");
    }

    private void updateUser() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        User user = getUserInputs();
        user.setId(id);
        userController.update(user.getId(), user);
        System.out.println("Updated user with ID = " + id + "\n");
    }

    private void deleteUser() throws SQLException {
        System.out.println("\nEnter ID to delete user: ");
        int id = SCANNER.nextInt();
        userController.delete(id);
        System.out.println("Deleted user with ID = " + id + "\n");
    }


    private void getAllReviews() throws SQLException {
        System.out.println("\n");
        System.out.println(reviewController.findAll() + "\n");
    }

    private void getReviewById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(reviewController.findById(id) + "\n");
    }

    private Review getReviewInputs() {
        System.out.println("\nEnter text: ");
        String text = SCANNER.next();
        System.out.println("Enter rate: ");
        Integer rate = SCANNER.nextInt();
        System.out.println("Enter hotel id: ");
        Integer hotelId = SCANNER.nextInt();
        System.out.println("Enter user id: ");
        Integer userId = SCANNER.nextInt();
        return new Review(text, rate, hotelId, userId);
    }

    private void createReview() throws SQLException {
        System.out.println("\n");
        Review review = getReviewInputs();
        reviewController.create(review);
        System.out.println("Review was successfully created!\n");
    }

    private void updateReview() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Review review = getReviewInputs();
        review.setId(id);
        reviewController.update(review.getId(), review);
        System.out.println("Updated review with ID = " + id + "\n");
    }

    private void deleteReview() throws SQLException {
        System.out.println("\nEnter ID to delete review: ");
        int id = SCANNER.nextInt();
        reviewController.delete(id);
        System.out.println("Deleted review with ID = " + id + "\n");
    }


    private void getAllAmenities() throws SQLException {
        System.out.println("\n");
        System.out.println(amenityController.findAll() + "\n");
    }

    private void getAmenityById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(amenityController.findById(id) + "\n");
    }

    private Amenity getAmenityInputs() {
        System.out.println("\nEnter room id: ");
        Integer roomId = SCANNER.nextInt();
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter price: ");
        BigInteger price = SCANNER.nextBigInteger();
        return new Amenity(roomId, name, price);
    }

    private void createAmenity() throws SQLException {
        System.out.println("\n");
        Amenity amenity = getAmenityInputs();
        amenityController.create(amenity);
        System.out.println("Amenity was successfully created!\n");
    }

    private void updateAmenity() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Amenity amenity = getAmenityInputs();
        amenity.setId(id);
        amenityController.update(amenity.getId(), amenity);
        System.out.println("Updated amenity with ID = " + id + "\n");
    }

    private void deleteAmenity() throws SQLException {
        System.out.println("\nEnter ID to delete amenity: ");
        int id = SCANNER.nextInt();
        amenityController.delete(id);
        System.out.println("Deleted amenity with ID = " + id + "\n");
    }


    private void getAllReservations() throws SQLException {
        System.out.println("\n");
        System.out.println(reservationController.findAll() + "\n");
    }

    private void getReservationById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(hotelChainController.findById(id) + "\n");
    }

    private Reservation getReservationInputs() {
        System.out.println("\nEnter user id: ");
        Integer userId = SCANNER.nextInt();
        System.out.println("Enter room id: ");
        Integer roomId = SCANNER.nextInt();
        System.out.println("Enter start time: ");
        String firstTime = "2020-12-12 01:24:23";
        Timestamp startTime = Timestamp.valueOf(firstTime);
        System.out.println("Enter end time: ");
        String secondTime = "2020-12-12 01:24:23";
        Timestamp endTime = Timestamp.valueOf(secondTime);
        System.out.println("Enter payment amount: ");
        BigInteger paymentAmount = SCANNER.nextBigInteger();
        System.out.println("Enter adults: ");
        Integer adults = SCANNER.nextInt();
        System.out.println("Enter kids: ");
        Integer kids = SCANNER.nextInt();
        return new Reservation(userId, roomId, startTime, endTime, paymentAmount, adults, kids);
    }

    private void createReservation() throws SQLException {
        System.out.println("\n");
        Reservation reservation = getReservationInputs();
        reservationController.create(reservation);
        System.out.println("Reservation was successfully created!\n");
    }

    private void updateReservation() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Reservation reservation = getReservationInputs();
        reservation.setId(id);
        reservationController.update(reservation.getId(), reservation);
        System.out.println("Updated reservation with ID = " + id + "\n");
    }

    private void deleteReservation() throws SQLException {
        System.out.println("\nEnter ID to delete reservation: ");
        int id = SCANNER.nextInt();
        reservationController.delete(id);
        System.out.println("Deleted reservation with ID = " + id + "\n");
    }
}
