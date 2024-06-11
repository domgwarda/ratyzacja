public class Skill extends Stuff{
    private Integer current;
    private Integer max;

    public Skill(Integer points, Integer max) {
        this.current = points;
        this.max = max;
    }

    public void increase() { current += 1; }

    @Override
    public Integer getCurrent() { return current; }
    public Integer getMax() { return max; }

    @Override
    public void setCurrent(Integer current) { 
        if (current == max-1 && current == 1) { return; }
        this.current = current; }
        
    public void setMax(Integer max) { this.max = max; }

    public Integer isMax() { 
        if (current==max) { return 1; }
        return 0;
     }

    public String show() { return String.format("%s/%s", current, max); }

    public Integer cost() {
        if (current<6) { return 1; }
        else if (current<11) { return 2; }
        else { return 15; }
    }


    public class Intelligence extends Skill {
        public Intelligence(Integer p, Integer m) {
            super(p, m);
        }
    }

    public class Strength extends Skill {
        public Strength(Integer p, Integer m) {
            super(p, m);
        }
    }

    public class Speed extends Skill {
        public Speed(Integer p, Integer m) {
            super(p, m);
        }
    }

    public class Charisma extends Skill {
        public Charisma(Integer p, Integer m) {
            super(p, m);
        }
    }
}
