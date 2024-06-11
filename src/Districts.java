public class Districts extends Stuff {
    private Integer current; //start
    private Integer max = 5;

    public Districts(Integer c) { current = c; }  

    @Override
    public Integer getCurrent() { return current; }
    public Integer getMax() { return max; }

    @Override
    public void setCurrent(Integer c) { current = c; }
    public void increase() { current += 1; }

    public String show() { return String.format("%s/%s", current, max); }
    public void showAll() { System.out.println(String.format("%s", this.show())); }
}
