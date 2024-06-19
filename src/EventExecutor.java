import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventExecutor {
    private ResourcesManager resourcesManager;
    private Population population;
    private Districts districts;
    private SkillManager skillManager;
    private Scanner scanner;
    private EnemiesManager enemiesManager;
    private Map<String, Stuff> typesMap;

    public EventExecutor(ResourcesManager r, Population p, Districts ds, SkillManager s, EnemiesManager h, Scanner sc) {
        resourcesManager = r;
        population = p;
        districts = ds;
        skillManager = s;
        scanner = sc;
        enemiesManager = h;

        typesMap = new HashMap<>(); 
        typesMap.put("smieci", resourcesManager.getTrashes());
        typesMap.put("orzechy", resourcesManager.getNuts());
        typesMap.put("populacja", population);
        typesMap.put("dzielnice", districts);
        typesMap.put("martwi", enemiesManager.getDead());
        typesMap.put("chorzy", enemiesManager.getInfected());
        typesMap.put("inteligencja", skillManager.getIntelligence());
        typesMap.put("sila", skillManager.getStrength());
        typesMap.put("charyzma", skillManager.getCharisma());
        typesMap.put("szybkosc", skillManager.getSpeed());
        typesMap.put("nic", skillManager.getSpeed());
    }

    public void execute(String string) {
        if (string.equals("0")) { return; }
        Random random = new Random();
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(string);
        List<String> list = new ArrayList<String>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        Stuff toChange = typesMap.get(list.get(0));
        Integer toChangeVal = Integer.parseInt(list.get(1));
        Integer percent = Integer.parseInt(list.get(2));
        Stuff require = typesMap.get(list.get(3));
        Integer requireVal = Integer.parseInt(list.get(4));
        if (require.getCurrent()>=requireVal) {
            Integer randomInt = random.nextInt(100);
            if (randomInt<=percent) {
                if (percent!=100) {System.out.println("zaryzykowałeś i udało się :)");}
                if (toChange.getCurrent()-toChangeVal<0) { toChange.setCurrent(0); }
                else { toChange.setCurrent(toChange.getCurrent()+toChangeVal); }
            }
            else { System.out.println("zaryzykowałeś, ale nie udało się"); }
        }
        else { throw new RuntimeException("e"); }
    }

    public void executeEvent(List<String> list) {
        try {
        System.out.println("\n(wybierz opcję)");
        Integer optionInput = scanner.nextInt();
        execute(list.get(optionInput-1));
        System.out.println("(koniec eventu)\n"); 
        scanner.nextLine();
        } catch (Exception e) {
            System.out.println("(nie możesz tego zrobić, wybierz inną opcję)");
            scanner.nextLine();
            executeEvent(list);
        }
    };

    public void increaseDistrict() {districts.setCurrent(districts.getCurrent()+1);}
}