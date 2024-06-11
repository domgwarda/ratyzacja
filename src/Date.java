public class Date {
    private Integer month;

    public Date() { 
        month = 6;
    }

    public void nextDate() { 
        if (month==12) {
            month=1;
        }
        else month+=1;
    }
    
    public Integer getMonth() { return month; }
    
    public void showAll() { System.out.println(String.format("%s miesiąc roku;", month)); }


}