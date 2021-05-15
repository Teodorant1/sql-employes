package sample;

public class worker {




    String name;
    String age;
    String adress;
    String income;

    public worker() {
    }

    public worker(String name, String age, String adress, String income)
    {   this.name = name;
        this.age = age;
        this.adress = adress;
        this.income = name; }

    public String cannibalclown() {return getName() + getAge() + getAdress() + getAdress();}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
