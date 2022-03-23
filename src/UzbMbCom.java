public class UzbMbCom implements Comparable<UzbMbCom>{
    private String flName;
    private String phoneNumber;
    private double money;
    private String company;

    public UzbMbCom(String flName, String phoneNumber, double money,String company) {
        this.flName = flName;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.company=company;
    }

    public String getFlName() {
        return flName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public double getMoney() {
        return money;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Abonent ismi: "+flName+" - Phone number: "+("+"+phoneNumber.substring(0,3)
        +"("+phoneNumber.substring(3,5)+")"+phoneNumber.substring(5,8)+"-"+phoneNumber.substring(8,10)+"-"+phoneNumber.substring(10))
                +" -> "+money+"$"+" | "+company;
    }


    @Override
    public int compareTo(UzbMbCom uzbMbCom) {

        return this.getFlName().compareTo(((UzbMbCom) uzbMbCom).getFlName());
    }




}
