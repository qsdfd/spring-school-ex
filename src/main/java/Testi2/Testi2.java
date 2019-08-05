package Testi2;

public class Testi2 {
    public Number ok(){
        return 5;
    }

    public String ok(int ok){
        return "";
    }
}

class Wok extends Testi2{
    @Override
    public Integer ok(){
        return 4;
    }

    public String ok(int ok){

        iok bol = new lol(){
          public void nok (){

          }

          public void troll(){

          }
        };

        bol.nok();

        return "";
    }
}


interface iok{
    public void nok();
}

class lol implements iok {

    @Override
    public void nok() {

    }
}