package utilities;
import java.time.LocalDate;
import java.util.Random;

public class Generate {

    private static String[] maleNameList = 
    {"Ahmed","Ali","Ebrahem","Mostafa","Mahmoud",
    "Zeyad","Samy","Ehab","Hany","Kamel","Mortada",
    "Gamal"};

    private static String[] feMaleNameList = {
        "Aya","Asmaa","Nada","Tahany","Khadeja","Maryam",
        "Sara","Fatma","Hala","Yasmeen"};

    public static String fullName(){
        Random rand= new Random();
        boolean isBoy = rand.nextBoolean();
        String name;
        //First name
        if (isBoy){
            name = maleNameList[rand.nextInt(maleNameList.length)];
        }else{
            name = feMaleNameList[rand.nextInt(feMaleNameList.length)];
        } 
        //Last name     
        name += " "+ maleNameList[rand.nextInt(maleNameList.length)];
        return name;
    }

    public static double money(double min, double max){
        Random rand= new Random();
        return (rand.nextDouble(max-min)+min);
    }

    public static int integer(int min, int max){
        Random rand= new Random();
        return (rand.nextInt(max-min)+min);
    }


    public static LocalDate date(int minYear, int maxYear){
        Random rand= new Random();
        int year= rand.nextInt(maxYear-minYear)+minYear;
        int month = rand.nextInt(11)+1;
        int day = rand.nextInt(27)+1;
        return LocalDate.of(year,month,day);
    }

    public static String id(String initial){
        Random rand= new Random();
        return (initial+"-"+(rand.nextInt(899)+100));
    }

    public static void printDashes(int num){
        for (int i=0;i<num;i++)
                System.out.print("-");
        System.out.println();

    }
}
