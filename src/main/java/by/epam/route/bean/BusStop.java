package by.epam.route.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Semaphore;

public class BusStop {
    private Semaphore semaphore;
    private final int maxBuses;
    private List<Passenger> passengers;
    private List<Bus> buses;

    public BusStop() {
        maxBuses = 3;
        semaphore = new Semaphore(maxBuses, true);
        passengers = new ArrayList<>();
        buses = new ArrayList<>();
    }

    public BusStop(int maxBuses, List<Passenger> passengers) {
        this.maxBuses = maxBuses;
        this.passengers = passengers;
        semaphore = new Semaphore(maxBuses, true);
        buses = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return getMaxBuses() == busStop.getMaxBuses() &&
                Objects.equals(getSemaphore(), busStop.getSemaphore()) &&
                Objects.equals(getPassengers(), busStop.getPassengers()) &&
                Objects.equals(buses, busStop.buses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemaphore(), getMaxBuses(), getPassengers(), buses);
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "semaphore=" + semaphore +
                ", maxBuses=" + maxBuses +
                ", passengers=" + passengers +
                ", buses=" + buses +
                '}';
    }

    public int getMaxBuses() {
        return maxBuses;
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

    public Bus getBus(int index) {
        return buses.get(index);
    }

    public void setBus(Bus bus) {
        buses.add(bus);
    }

    public List<Bus> getBuses() {
        return new ArrayList<>(buses);
    }

    public void setBuses(List<Bus> buses) {
        this.buses = new ArrayList<>(buses);
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}
