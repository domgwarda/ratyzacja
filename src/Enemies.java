public class Enemies {
    private Integer current;

    public Enemies(Integer c) {
        current = c;
    }

    public Integer getCurrent() { return current; }
    public void setCurrent(Integer c) { current = c; }

    public String show() { return String.format("%s", current); }
    
    public class Infected extends Enemies {
        public Infected(Integer c) { super(c); }
    }

    public class Dead extends Enemies {
        public Dead(Integer c) { super(c); }
    }
}
