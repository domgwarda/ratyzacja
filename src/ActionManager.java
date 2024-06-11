
import java.util.Map;
import java.util.Scanner;

public class ActionManager {
    private ResourcesManager resourcesManager;
    private Population population;
    private Districts districts;
    private SkillManager skillManager;
    private EnemiesManager enemiesManager;
    private Scanner scanner;

    public ActionManager(ResourcesManager r, Population p, Districts ds, SkillManager s, EnemiesManager e, Scanner sc) {
        resourcesManager = r;
        population = p;
        districts = ds;
        skillManager = s;   
        enemiesManager = e;
        scanner = sc;
    }

    public void start() {
        System.out.println("Twój pierwszy dzień jako przewodniczący akcji ratyzacja:");
        System.out.println(String.format("populacja szczurów: %s", population.show()));
        resourcesManager.showAll();
        System.out.println(String.format("Ludzie: %s", enemiesManager.getMax()));
        System.out.println("\n(start)");
        scanner.nextLine();
    }

    public void execute(String action) {
        if (action.equals("komendy")) {
            System.out.println("'zasoby' -> pokazuje, ile kubłów na śmieci posiadają szczury oraz ile posiadają tych orzechów;");
            System.out.println("'zasoby-wartosc' -> pokazuje, jaką wartość na rynku mają kubły na śmieci i orzechy;");
            System.out.println("'populacja' -> pokazuje wielkość populacji szczurów;");
            System.out.println("'dzielnice' -> pokazuje, ile wrocławskich dzielnic przejęły już szczury;");
            System.out.println("'ludzie' -> pokazuje stan ludzi (wszystkich, zainfekowanych, martwych);");
            System.out.println("'cechy' -> pokazuje, jakie cechy rozwinął gatunek szczurów;");
            System.out.println("'wymien' -> wymienia zasoby między sobą"); 
            System.out.println("'rozwin' -> wymienia złote orzechy na jeden punkt wybranej cechy;"); 
        }

        else if (action.equals("zasoby")) { resourcesManager.showAll(); }
        else if (action.equals("zasoby-wartosc")) { resourcesManager.showAllValue(); }
        else if (action.equals("populacja")) { population.showAll(); }
        else if (action.equals("dzielnice")) { districts.showAll(); }
        else if (action.equals("ludzie")) { enemiesManager.showAll(); }
        else if (action.equals("cechy")) { skillManager.showAll(); }

        else if (action.equals("wymien")) {
            Map<String,Resources> resourcesMap = resourcesManager.getMap();
            System.out.println("co chcesz wymienić? (smieci / orzechy);");
            String resourceInput = scanner.nextLine();
            if (resourcesMap.containsKey(resourceInput)) {
                Resources resource = resourcesMap.get(resourceInput);
                System.out.println("ile chcesz wymienic?");
                Integer amountInput = scanner.nextInt();
                scanner.nextLine();
                if (amountInput<0) { 
                    System.out.println("ilość, którą chcesz wymienić, ma być nieujemna!"); 
                    return; }
                else { resourcesManager.exchange(resource, amountInput); };
            }
            else { System.out.println("nie rozpoznaję typu, spróbuj jeszcze raz :("); }
        }

        else if (action.equals("rozwin")) {
            Resources.Nuts nuts = resourcesManager.getNuts();
            Map<String, Skill> skillMap = skillManager.getMap();
            System.out.println("jaką cechę chcesz rozwinąć? (inteligencja/ sila/ charyzma/ szybkosc);");
            String skillInput = scanner.nextLine();
            if (skillMap.containsKey(skillInput)) {
                Skill skill = skillMap.get(skillInput);
                Integer skillCost = skill.cost();
                if (skill.getCurrent().equals(skill.getMax())) { System.out.println("nie możesz bardziej rozwinąć tej cechy!"); }
                else {
                    System.out.println(String.format("aby rozwinąć cechę %s o 1 punkt potrzebujesz %s orzechów, jesteś zdecydowany? (tak / nie)", skillInput, skillCost));
                    String input = scanner.nextLine();
                    if (input.equals("nie")) { return; }
                    else if (input.equals("tak") && nuts.getCurrent()>=skillCost) { 
                        nuts.setCurrent(nuts.getCurrent()-skillCost);
                        skill.increase();
                    }
                    else  { System.out.println("masz za mało orzechów!"); }
                }
            }
            else {
                System.out.println("nie rozpoznaję nazwy cechy :(");
            }
        }
    }
}
