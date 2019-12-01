package by.epam.route.logic;

import by.epam.route.bean.Bus;
import by.epam.route.bean.BusStop;
import by.epam.route.bean.Passenger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Passenger> passengers1 = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            passengers1.add(new Passenger(i));
        }
        List<Passenger> passengers2 = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            passengers2.add(new Passenger(i+30));
        }
        List<Passenger> passengers3 = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            passengers3.add(new Passenger(i+60));
        }
        List<BusStop> stops = new ArrayList<>();
        BusStop stop1 = new BusStop(3, new ArrayList<>(passengers1));
        BusStop stop2 = new BusStop(3, new ArrayList<>(passengers2));
        BusStop stop3 = new BusStop(3, new ArrayList<>(passengers3));
        stops.add(stop1);
        stops.add(stop2);
        stops.add(stop3);
        Bus bus = new Bus(100, new ArrayList<>(), stops);
        Bus bus1 = new Bus(bus);
        Bus bus2 = new Bus(bus);
        Bus bus3 = new Bus(bus);
        BusRun run2 = new BusRun(bus1);
        BusRun run3 = new BusRun(bus2);
        BusRun run4 = new BusRun(bus3);
        //Thread thread1 = new Thread(bus);
        Thread thread2 = new Thread(run2);
        Thread thread3 = new Thread(run3);
        Thread thread4 = new Thread(run4);
       // thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        System.out.println();
    }
}
