import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) throws Exception {
        Integer r = 0;
        Districts districts = new Districts(0);
        Population population = new Population(districts);  
        ResourcesManager resourcesManager = new ResourcesManager(population, districts);
        EnemiesManager enemiesManager = new EnemiesManager();
        SkillManager skillManager = new SkillManager();
        Date date = new Date();
        Scanner scanner = new Scanner(System.in);
        ActionManager actionManager = new ActionManager(resourcesManager, population, districts, skillManager, enemiesManager, scanner);
        EndManager endManager = new EndManager(resourcesManager, population, districts, skillManager, enemiesManager, date, scanner);
        EventExecutor eventExecutor = new EventExecutor(resourcesManager, population, districts, skillManager, enemiesManager, scanner);
        EventManager eventManager = new EventManager(districts, eventExecutor);

        //START
        ReadFile.readFile("/mnt/c/Users/Gwarda/Desktop/studia/po/projekt/ratyzacja/src/loreFiles/lore.txt");
        System.out.println("\n(dalej)");
        scanner.nextLine();
        ReadFile.readFile("/mnt/c/Users/Gwarda/Desktop/studia/po/projekt/ratyzacja/src/loreFiles/introduction.txt");
        System.out.println("\n(dalej)");
        scanner.nextLine();
        actionManager.start();
        while (!endManager.end(r)) {
            System.out.println("\n***");
            System.out.println("\n(nowy miesiąc)");
            date.showAll();
            eventManager.newEvent(r);
            String input="";
            while (!input.equals("koniec")) {
                System.out.println("\nCo chcesz zrobić? (komendy / koniec)");
                input=scanner.nextLine();
                actionManager.execute(input);
            }
            date.nextDate();
            population.newPopulation(resourcesManager, districts);
            resourcesManager.newResources(population, districts);
            enemiesManager.newEnemies(population);
            r+=1;
        }

        scanner.close();
    }
}

