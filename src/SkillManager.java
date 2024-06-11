import java.util.HashMap;
import java.util.Map;

public class SkillManager {
    private Map<String, Skill> skillMap;
    private Skill.Intelligence intelligence;
    private Skill.Strength strength;
    private Skill.Charisma charisma;
    private Skill.Speed speed;

    public SkillManager() {
        Skill skill = new Skill(1,15);
        intelligence = skill.new Intelligence(1,15);
        strength = skill.new Strength(1, 15);
        charisma = skill.new Charisma(1,15);
        speed = skill.new Speed(1, 15);

        skillMap = new HashMap<>();
        skillMap.put("inteligencja", intelligence);
        skillMap.put("sila", strength);
        skillMap.put("charyzma", charisma);
        skillMap.put("szybkosc", speed);
    }

    public Skill.Intelligence getIntelligence() { return intelligence; }
    public Skill.Strength getStrength() { return strength; }
    public Skill.Charisma getCharisma() { return charisma; }
    public Skill.Speed getSpeed() { return speed; }
    public Map<String, Skill> getMap() { return skillMap; }

    public void setIntelligence(Integer p) { intelligence.setCurrent(p); }
    public void setStrength(Integer p) { strength.setCurrent(p); }
    public void setCharisma(Integer p) { charisma.setCurrent(p); }
    public void setSpeed(Integer p) { charisma.setCurrent(p); }

    
    public Integer maxPoints() {
        return (intelligence.isMax()+strength.isMax()+charisma.isMax()+speed.isMax());
    } 
    public void showAll() { System.out.println(String.format("inteligencja: %s, siła: %s, charyzma: %s, szybkość: %s;", intelligence.show(), strength.show(), charisma.show(), speed.show())); }
}
