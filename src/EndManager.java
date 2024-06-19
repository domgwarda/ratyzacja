import java.util.Scanner;
import java.util.Random;

public class EndManager {
    private Integer counter=-1;
    private ResourcesManager resourcesManager;
    private Population population;
    private Districts districts;
    private SkillManager skillManager;
    private EnemiesManager enemiesManager;

    public EndManager(ResourcesManager r, Population p, Districts ds, SkillManager s, EnemiesManager h, Date dt, Scanner sc) {
        resourcesManager = r;
        population = p;
        districts = ds;
        skillManager = s;   
        enemiesManager = h;
    }

    public Boolean winInfected() {
        return enemiesManager.maxDeadInfected();
    }

    public Boolean winDistricts() {
        return districts.getCurrent()==districts.getMax();
    }

    public Boolean winSkill() {
        return skillManager.maxPoints()>=2;
    }


    public Boolean losePopulation() {
        return (population.getMax()/population.getCurrent())>10;
    }

    public Boolean loseTrashes() {
        return (resourcesManager.getTrashes().getCurrent()==0);
    }


    public Boolean end(Integer n) {
        Random random = new Random();
        if (counter==5) { 
            ReadFile.readFile("../loreFiles/tooLong2.txt"); 
            counter -= 1;
            return false;
        }
        else if (counter==0) { 
            ReadFile.readFile("../loreFiles/loseTooLong.txt"); 
            return true;
        }
        else if (winDistricts()) {
            ReadFile.readFile("../loreFiles/winDistricts.txt"); 
            return true;
        }
        else if (winInfected()) {
            ReadFile.readFile("../loreFiles/winInfected.txt"); 
            return true;
        }

        else if (winSkill()) {
            ReadFile.readFile("../loreFiles/winSkill.txt"); 
            return true;
        }

        else if (losePopulation()) {
            ReadFile.readFile("../loreFiles/losePopulation.txt"); 
            return true;
        }

        else if (loseTrashes()) {
            ReadFile.readFile("../loreFiles/loseTrashes.txt"); 
            return true;
        }

        else {
            if (n > 1 && counter == -1) {
                if (random.nextInt(3) == 1) { 
                    counter = 10;
                    ReadFile.readFile("../loreFiles/tooLong1.txt"); 
                    return false;
                }
                return false;
            }
            if (counter == -1) {
                return false;
            }
            else {
                counter -= 1;
                return false;
            }
        }
    }
    
}
