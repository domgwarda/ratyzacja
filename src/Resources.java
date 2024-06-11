public abstract class Resources extends Stuff {
    private Integer current;
    private Integer max;
    private Integer value;
    //jeden smietnik na 100_000 szczurow

    @Override
    public Integer getCurrent() { return current; }
    public Integer getMax() { return max; }  
    public Integer getValue() { return value; } 

    @Override
    public void setCurrent(Integer newCurrent) { current=newCurrent; } 
    public void setMax(Integer newMax) { max=newMax; } 
    public void setValue(Integer newValue) { value=newValue; } 

    public abstract String show();
    
    public static void exchangeR1toR2(Resources r1, Resources r2, Integer amt) {
        if (amt>r1.getCurrent()) {
            System.out.println("masz za mało zasobu :(");
        }
        Integer v1 = r1.getValue();
        Integer v2 = r2.getValue();
        r1.setCurrent(r1.getCurrent()-amt);
        r2.setCurrent(r2.getCurrent()+(amt*v1)/v2);
    };

    public void increase() { setCurrent(getCurrent()+1); }

    public static class Trashes extends Resources {
        public Trashes(Population population, Districts districts, Integer val) { 
            setCurrent((districts.getCurrent() + 1) * 5); // na jednej dzielnicy jest defaultowo 5 smietnikow. Mozna to zwiekszyc wymieniajac smietniki lub w evencie
            setMax(Math.round(population.getCurrent() / 100_000));
            setValue(val);
        }

        public String show() { return String.format("%s/%s", getCurrent(), getMax()); }
    }

    public static class Nuts extends Resources {
        public Nuts(Population population, Districts districts, Integer val) { 
            setCurrent((districts.getCurrent() + 1) * 10); // za jedna dzielnice dostaje sie 10 orzechy 
            setValue(val);
        }
        @Override
        public String show() { return String.format("%s", getCurrent()); }
    }
}
