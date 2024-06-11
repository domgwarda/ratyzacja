import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class ResourcesManager {
    private Map<String, Resources> resourcesMap;
    private Resources.Trashes trashes;
    private Resources.Nuts nuts;
    private Random random = new Random();

    public ResourcesManager(Population population, Districts districts) {
        trashes = new Resources.Trashes(population, districts, 1);
        nuts = new Resources.Nuts(population, districts, 1);

        resourcesMap = new HashMap<>();
        resourcesMap.put("smieci", trashes);
        resourcesMap.put("orzechy", nuts);
    }

    public Resources.Trashes getTrashes() { return trashes; }
    public Resources.Nuts getNuts() { return nuts; }
    public Map<String, Resources> getMap() { return resourcesMap; }

    public void newResources(Population population, Districts districts) {
        trashes.setMax(Math.round(population.getCurrent() / 100_000));
        if (random.nextInt(10)>7) {
            nuts.increase();
            System.out.println("\nw kanale spotkałeś syrenę, która podarowała ci złotego orzecha!");
        }
        trashes.setValue(random.nextInt(3)+1);
        nuts.setValue(random.nextInt(3)+1);
    }

    public void exchange(Resources resource, Integer amount) {
        if (resource instanceof Resources.Trashes) { Resources.exchangeR1toR2(trashes, nuts, amount); }
        else { Resources.exchangeR1toR2(nuts, trashes, amount); }
    }

    public void showAll() { System.out.println(String.format("śmieci: %s, złote orzechy: %s;", trashes.show(), nuts.show())); }
    public void showAllValue() { System.out.println(String.format("śmieci: %s, złote orzechy: %s;", trashes.getValue(), nuts.getValue())); }
}
