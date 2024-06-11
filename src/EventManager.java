import java.util.HashMap;
import java.util.Map;

public class EventManager {
    private Districts districts;
    private EventExecutor eventExecutor;
    private Map<Integer, Event> eventMap;

    public EventManager(Districts ds, EventExecutor ee) {
        districts = ds;
        eventExecutor = ee;

        Event.Event0 event0 = new Event.Event0();
        Event.Event1 event1 = new Event.Event1();
        Event.Event2 event2 = new Event.Event2();
        Event.Event3 event3 = new Event.Event3();
        Event.Event4 event4 = new Event.Event4();

        eventMap = new HashMap<>();
        eventMap.put(0, event0);
        eventMap.put(1, event1);
        eventMap.put(2, event2);
        eventMap.put(3, event3);
        eventMap.put(4, event4);
    }

    public void newEvent(Integer n) {
        Event.EventDistrict eventDistrict = new Event.EventDistrict();
        if (n==0) { return; } 
        if (n%7==0 && n/7==districts.getCurrent()+1) { eventDistrict.newEvent(eventExecutor); }
        else { 
            Event eventType = eventMap.get(districts.getCurrent());
            eventType.newEvent(eventExecutor);
        }
    }
}