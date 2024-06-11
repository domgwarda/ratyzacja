import java.util.*;

public abstract class Event {
    public abstract void newEvent(EventExecutor eventExecutor);

    public static class Event0 extends Event {
        public Event0() {};

        @Override
        public void newEvent(EventExecutor eventExecutor) {
            Random random = new Random();
            Integer randomInt = random.nextInt(2);
            List<String> list = ReadFile.readEvent("/mnt/c/Users/Gwarda/Desktop/studia/po/projekt/ratyzacja/src/event/districts0/event"+randomInt+".txt");
            eventExecutor.executeEvent(list);
        }
    }

    public static class Event1 extends Event {
        public Event1() {}

        @Override
        public void newEvent(EventExecutor eventExecutor) {
            Random random = new Random();
            Integer randomInt = random.nextInt(1);
            List<String> list = ReadFile.readEvent("/mnt/c/Users/Gwarda/Desktop/studia/po/projekt/ratyzacja/src/event/districts1/event"+randomInt+".txt");
            eventExecutor.executeEvent(list);
        }
    }

    public static class Event2 extends Event {
        public Event2() {}

        @Override
        public void newEvent(EventExecutor eventExecutor) {
            Random random = new Random();
            Integer randomInt = random.nextInt(1);
            List<String> list = ReadFile.readEvent("/mnt/c/Users/Gwarda/Desktop/studia/po/projekt/ratyzacja/src/event/districts2/event"+randomInt+".txt");
            eventExecutor.executeEvent(list);
        }
    }

    public static class Event3 extends Event {
        public Event3() {}
        @Override
        public void newEvent(EventExecutor eventExecutor) {
            Random random = new Random();
            Integer randomInt = random.nextInt(1);
            List<String> list = ReadFile.readEvent("/mnt/c/Users/Gwarda/Desktop/studia/po/projekt/ratyzacja/src/event/districts3/event"+randomInt+".txt");
            eventExecutor.executeEvent(list);
        }
    }

    public static class Event4 extends Event {
        public Event4() {}

        @Override
        public void newEvent(EventExecutor eventExecutor) {
            Random random = new Random();
            Integer randomInt = random.nextInt(1);
            List<String> list = ReadFile.readEvent("/mnt/c/Users/Gwarda/Desktop/studia/po/projekt/ratyzacja/src/event/districts4/event"+randomInt+".txt");
            eventExecutor.executeEvent(list);
        }
    }

    public static class EventDistrict extends Event {
        public EventDistrict() {}

        @Override
        public void newEvent(EventExecutor eventExecutor) {
            Random random = new Random();
            Integer randomInt = random.nextInt(1);
            List<String> list = ReadFile.readEvent("/mnt/c/Users/Gwarda/Desktop/studia/po/projekt/ratyzacja/src/event/districts/event"+randomInt+".txt");
            eventExecutor.executeEvent(list);
        }
    }
}