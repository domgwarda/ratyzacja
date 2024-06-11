import java.util.Random;

public class EnemiesManager {
    private Enemies.Infected infected;
    private Enemies.Dead dead;
    private Integer max = 638659;

    public EnemiesManager() {
        Enemies humans = new Enemies(0); 
        infected = humans.new Infected(0);
        dead = humans.new Dead(0);
    }

    public Enemies.Infected getInfected() { return infected; }
    public Enemies.Dead getDead() { return dead; }
    public Integer getMax() { return max; }

    public void newEnemies(Population population) {
        Random random = new Random();
        Integer newDead = infected.getCurrent();
        Integer newInfected = Math.round(population.getCurrent()*0.1f);
        dead.setCurrent( dead.getCurrent() + newDead ); 
        infected.setCurrent( infected.getCurrent() - newDead + newInfected);
        max -= random.nextInt(2137);

        if (infected.getCurrent()+dead.getCurrent()>max) {
            infected.setCurrent(max-dead.getCurrent());
        }
    }

    public Boolean maxDeadInfected() { return (max-infected.getCurrent()-dead.getCurrent() == 0); }

    public void showAll() { System.out.println(String.format("ludzie: %s, zainfekowani: %s, martwi: %s;", max, infected.getCurrent(), dead.getCurrent())); }
}
