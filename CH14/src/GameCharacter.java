import java.io.Serializable;

public class GameCharacter implements Serializable {
    private int power;
    private String type;
    private String[] weapons;

    public GameCharacter(int p, String t, String[] w){
        power = p;
        type = t;
        weapons = w;
    }

    int getPower(){
        return power;
    }

    String getType(){
        return type;
    }

    String getWeapons(){
        StringBuilder res = new StringBuilder();
        for(String s: weapons)
            res.append(s).append(" ");
        return res.toString();
    }
}
