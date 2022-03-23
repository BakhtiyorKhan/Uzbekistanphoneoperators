import java.time.LocalDate;
import java.util.*;

public class Main {
    static List<UzbMbCom> uzbMbComs = new ArrayList<>();
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Bugun sana: "+localDate);
        System.out.println("☆ O'zbekiston mobil operatorlari ☆");
        setUzbMbComs();
        mobilMenu();


    }

    static void mobilMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Abonentlar ro'yhati");
        System.out.println("2-Abonent qo'shish");
        System.out.println("3-Abonent o'chirish");
        System.out.println("4-Abonent qidirish");
        System.out.println("5-Chiqish");
        System.out.print("Tanglang: ");

        switch (scanner.nextInt()){
            case 1:
                mobilCollection();
                break;
            case 2:
                mobilAdd();
                break;
            case 3:
                mobilRemove();
                break;
            case 4:
                mobilFound();
                break;
            case 5:
                System.out.println("Sizni biz yana kutib qolamiz...");
                break;
        }
    }
    static void mobilCollection(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Ucell abonentlari");
        System.out.println("2-Beeline abonentlari");
        System.out.println("3-Uzmobile abonentlari");
        System.out.println("4-Barcha abonentlar");
        System.out.println("5-Orqaga");
        System.out.print("Tanglang: ");
        switch (scanner.nextInt()){
            case 1:
                for (UzbMbCom uzbMbCom:uzbMbComs){
                    if (uzbMbCom.getCompany().equals("UCELL"))
                    System.out.println(uzbMbCom.toString());
                }
                mobilCollection();
                break;
            case 2:
                for (UzbMbCom uzbMbCom:uzbMbComs){
                    if (uzbMbCom.getCompany().equals("BEELINE"))
                        System.out.println(uzbMbCom.toString());
                }
                mobilCollection();
                break;
            case 3:
                for (UzbMbCom uzbMbCom:uzbMbComs){
                    if (uzbMbCom.getCompany().equals("UZMOBILE"))
                        System.out.println(uzbMbCom.toString());
                }
                mobilCollection();
                break;
            case 4:
                mobilSort();
                break;
            case 5:
                mobilMenu();
                break;
        }
    }
    static void mobilSort(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saralash turini tanglang");
        System.out.println("1-Ism bo'yicha");
        System.out.println("2-Balans bo'yicha");
        System.out.println("3-Kompaniya bo'yicha");
        System.out.println("4-Orqaga");
        System.out.print("Tanglang: ");
        switch (scanner.nextInt()){
            case 1:
                Collections.sort(uzbMbComs);
                printList(uzbMbComs);
                mobilSort();
                break;
            case 2:
                Collections.sort(uzbMbComs,Comparator.comparingDouble(UzbMbCom::getMoney).reversed());

                printList(uzbMbComs);
                mobilSort();
                break;
            case 3:
                Collections.sort(uzbMbComs,Comparator.comparing(UzbMbCom::getCompany));
                printList(uzbMbComs);
                mobilSort();
                break;
            case 4:
                mobilCollection();
                break;
        }
    }
    static void mobilAdd()    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qaysi mobil operatorga qo'shmoqchisiz");
        System.out.println("1-Ucell mobil operator");
        System.out.println("2-Beeline mobil operator");
        System.out.println("3-Uzmobile mobil operator");
        System.out.print("Tanglang: ");
        int choice = scanner.nextInt();
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Abonent ismi va familyasi : ");
            String name = scanner1.nextLine();
            System.out.print("Telefon raqam kiriting: ");
            String phone = scanner1.nextLine();
            System.out.print("Pulini kiriting: ");
            double money = scanner1.nextDouble();



        switch (choice){
            case 1:
                uzbMbComs.add(new UzbMbCom(name,phone,money,"UCELL"));
                System.out.println("Xush kelibsiz Ucellga Hayotni yaxshilash sari o'zgartiring");
                mobilMenu();
                break;
            case 2:
                uzbMbComs.add(new UzbMbCom(name,phone,money,"BEELINE"));
                System.out.println("Xush kelibsiz Beelinega Hayotning yorqin tarifida bo'ling");
                mobilMenu();
                break;
            case 3:
                uzbMbComs.add(new UzbMbCom(name,phone,money,"UZMOBILE"));
                System.out.println("Xush kelibsiz Uzmobilega Milliy operator");
                mobilMenu();
                break;

        }
    }
    static void mobilRemove(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ism sharifini yoki telefon raqamini kiritng: ");
        String namePhone = scanner.nextLine();
        boolean isdelet=false;
        UzbMbCom deletUzbMbCom=null;
        for (UzbMbCom uzbMbCom:uzbMbComs){
            if (uzbMbCom.getFlName().toLowerCase().equals(namePhone.toLowerCase()) || uzbMbCom.getPhoneNumber().equals(namePhone)){
                isdelet = true;
                deletUzbMbCom = uzbMbCom;
            }

        }
        if (!isdelet){
            System.out.println("Bunday ismli yoki telefon raqamli abonent yo'q...");
            mobilMenu();
        }
        else
        {
            System.out.println(deletUzbMbCom.toString());
            System.out.println("Abonent o'chirildi...");
            uzbMbComs.remove(deletUzbMbCom);
            mobilMenu();
        }
    }
    static void mobilFound(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Abonent ismi yoki telefon  raqamini kiriting: ");
        String namePhone = scanner.nextLine();
        boolean isfound = false;
        UzbMbCom foundMobil = null;
        for (UzbMbCom uzbMbCom:uzbMbComs){
            if (uzbMbCom.getFlName().toLowerCase().equals(namePhone.toLowerCase()) || uzbMbCom.getPhoneNumber().equals(namePhone)){
                foundMobil = uzbMbCom;
                isfound = true;
            }
        }
        if (!isfound){
            System.out.println("Bunday abonent abonentlar ichida topilmadi");
            mobilMenu();
        }
        else {
            System.out.println(foundMobil.toString());
            mobilMenu();
        }

    }
    static void setUzbMbComs(){
        uzbMbComs.add(new UzbMbCom("Bohodir Jalolov","998931452685",4.25,"UCELL"));
        uzbMbComs.add(new UzbMbCom("Yulduz Nodirov","998944782146",1.23,"UCELL"));
        uzbMbComs.add(new UzbMbCom("Maxfuza Qazoqova","998938953621",5.69,"UCELL"));
        uzbMbComs.add(new UzbMbCom("Jamila Turdiyev","998931254723",2.24,"UCELL"));
        uzbMbComs.add(new UzbMbCom("Baxtiyor Melimamatov","998919789394",5.21,"BEELINE"));
        uzbMbComs.add(new UzbMbCom("Qosim To'qayev","998902561478",6.39,"BEELINE"));
        uzbMbComs.add(new UzbMbCom("Lola Yo'ldoshev","998912547869",3.01,"BEELINE"));
        uzbMbComs.add(new UzbMbCom("Nodir Hayitov","998902365478",1.58,"BEELINE"));
        uzbMbComs.add(new UzbMbCom("Guli Olimov","998992578936",4.69,"UZMOBILE"));
        uzbMbComs.add(new UzbMbCom("Tolib Salimov","998991234789",1.89,"UZMOBILE"));
        uzbMbComs.add(new UzbMbCom("Humoyun Davlatov","998997856541",3.81,"UZMOBILE"));
        uzbMbComs.add(new UzbMbCom("Aziz Qosimov","998995472196",3.81,"UZMOBILE"));


    }
    static void printList(Iterable<?> list){
        for (Object abonent:list)
        {
            System.out.println(abonent);
        }
    }
}
