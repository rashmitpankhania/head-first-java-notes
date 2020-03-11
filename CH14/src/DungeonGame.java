import java.io.*;

public class DungeonGame implements Serializable {
    public int x = 3;
    transient long y = 4;
    private short z = 5;

    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();
        try{
            FileOutputStream f = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(d);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(d.getX()+d.getY()+d.getZ());
        try{
            FileInputStream f= new FileInputStream("dg.ser");
            ObjectInputStream oin = new ObjectInputStream(f);
            d = (DungeonGame) oin.readObject();
            oin.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(d.getX()+d.getY()+d.getZ());
    }

    int getX(){
        return x;
    }

    short getZ(){
        return z;
    }

    long getY(){
        return y;
    }
}
