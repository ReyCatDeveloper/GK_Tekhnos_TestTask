package Environment;

public class Resources {
    String url;

    Resources(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static final Resources resource_technos = new Resources("https://www.tehnosk.ru/");
    public static final Resources resource_google = new Resources("https://www.google.com/");
    public static final Resources resource_sber = new Resources("https://www.sberbank.ru/");
    public static final Resources resource_sber_calc = new Resources("https://www.sberbank.ru/ru/person/credits/home/buying_complete_house");

    //https://www.sberbank.ru/ru/person/credits/home/buying_complete_house

}
