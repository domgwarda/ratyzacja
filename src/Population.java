import java.util.Random;

public class Population extends Stuff {
    private Integer current;
    private Integer max;
    private Random random = new Random();

    public Population(Districts districts) {
        max = 1_000_000 * (districts.getCurrent()+1);
        current = ((districts.getCurrent()+1) * 30_000) + (random.nextInt(max/2)+max/5);
    }

    @Override
    public Integer getCurrent() { return current; }
    public Integer getMax() { return max; }
    
    @Override
    public void setCurrent(Integer c) {current = c; }
    public void setMax(Integer m) { max = m; }

    public void newPopulation(ResourcesManager resourcesManager, Districts districts) {
        Resources.Trashes trashes = resourcesManager.getTrashes();
        Integer intN = trashes.getCurrent()-trashes.getMax();
        if (intN>0) { 
            current += intN*100_000+(random.nextInt(current/10));
            if (current>max) {current = max; }
        }
        else if (trashes.getCurrent()/trashes.getMax() <= 0.2) {
            current -= 20_000*(-intN)*(random.nextInt(100)/100);
        }
        else {
            current += random.nextInt(1000);
            if (current>max) { current = max; }
        }
    }

    public String show() { return String.format("%s/%s", current, max); }
    public void showAll() { System.out.println(String.format("%s", this.show())); }
}
