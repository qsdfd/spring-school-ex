package Testi;

public class Test {
}

abstract class ok {
    public int getd(){
        Double ok = 2.0;
        return 1;
    };
}

interface lol {

    default String trol(){
        return "Testi.ok";
    }
}

final class wok extends ok implements lol {
    public String trol(){
        return "bollel";
    }
}

class okok extends ok {

}
