package by.epam.route.logic;

import by.epam.route.bean.Bus;
import by.epam.route.bean.BusStop;

import java.util.List;

public class BusRun implements Runnable {
    private Bus bus;

    public BusRun(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void run() {
        try {
            for (BusStop busStop : bus.getRoute()) {
                busStop.getSemaphore().acquire();
                System.out.println("Semaphore acquired");
                busStop.setBus(bus);

                if(!bus.getPassengers().isEmpty()){
                    busStop.addPassengers(bus.getPassengers().subList(0, 4));
                    bus.removePassengers(busStop.getPassengers());
                }
                int busFill = bus.getPassengers().size() - bus.getCapacity();
                if(busFill >= 8){
                    bus.addPassengers(busStop.getPassengers().subList(0, 8));
                    busStop.removePassengers(bus.getPassengers());
                }
                else if(busFill > 0){
                    bus.addPassengers(busStop.getPassengers().subList(0, busFill));
                    busStop.removePassengers(bus.getPassengers());
                }

                busStop.getBuses().remove(bus);
                busStop.getSemaphore().release();
                System.out.println("Semaphore released");
                System.out.println();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
