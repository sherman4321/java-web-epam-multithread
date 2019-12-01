package by.epam.route.dispetcher;

public class BusDispatcher {
    private static BusDispatcher ourInstance = new BusDispatcher();

    public static BusDispatcher getInstance() {
        return ourInstance;
    }

    private BusDispatcher() {
    }
}
