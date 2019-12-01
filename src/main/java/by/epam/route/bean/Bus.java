package by.epam.route.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bus {
    private final int capacity;
    private List<Passenger> passengers;
    private List<BusStop> route;

    public Bus() {
        capacity = 10;
        passengers = new ArrayList<>();
        route = new ArrayList<>();
    }

    public Bus(Bus bus) {
        capacity = bus.capacity;
        passengers = new ArrayList<>(bus.passengers);
        route = new ArrayList<>(bus.route);
    }

    public Bus(int capacity, List<Passenger> passengers, List<BusStop> route) {
        this.capacity = capacity;
        this.passengers = passengers;
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return capacity == bus.capacity &&
                Objects.equals(passengers, bus.passengers) &&
                Objects.equals(route, bus.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, passengers, route);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "capacity=" + capacity +
                ", passengers=" + passengers +
                ", route=" + route +
                '}';
    }

    public int getCapacity() {
        return capacity;
    }

    public Passenger getPassenger(int index) {
        return passengers.get(index);
    }

    public void setPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = new ArrayList<>(passengers);
    }

    public BusStop getStop(int index) {
        return route.get(index);
    }

    public void setStop(BusStop stop) {
        route.add(stop);
    }

    public List<BusStop> getRoute() {
        return new ArrayList<>(route);
    }

    public void setRoute(List<BusStop> route) {
        this.route = new ArrayList<>(route);
    }

}
