package by.epam.route.logic;

import by.epam.route.bean.Bus;
import by.epam.route.bean.BusStop;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BusRun implements Runnable {
    private Bus bus;

    public BusRun(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void run() {
        try {
            Lock locker = new ReentrantLock();
            for (BusStop i : bus.getRoute()) {
                i.getSemaphore().acquire();
                System.out.println("Semaphore acquired");
                i.setBus(bus);

                locker.lock();
                List stopList = i.getPassengers();
                List busList = bus.getPassengers();
                if(!bus.getPassengers().isEmpty()){
                    stopList.addAll(bus.getPassengers().subList(0, 4));
                    i.setPassengers(stopList);
                    busList.removeAll(stopList);
                    bus.setPassengers(busList);
                }
                busList.addAll(i.getPassengers().subList(0, 8));
                if(bus.getCapacity() >= busList.size()) {
                    bus.setPassengers(busList);

                    stopList.removeAll(busList);
                    i.setPassengers(stopList);
                }
                locker.unlock();

                i.getBuses().remove(bus);
                i.getSemaphore().release();
                System.out.println("Semaphore released");
                System.out.println();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
