package chars;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class Base implements BaseInterface, Iterator {
    protected int attack;
    protected int defence;
    protected int shoot;
    protected int[] damage;
    protected int damageValue;
    protected double health;
	protected int maxHealth;
    int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
	protected String status;
    private static int idCounter=0;
    private int playerID;
    protected ArrayList<Base> gang;
    protected Vector2 position;
    protected String fract;
    protected Base target;
    

    public Base(int attack, int defence, int shoot, int[] damage, double health, int speed, boolean delivery, boolean magic, String name, String fract) {
        this.attack = attack;
        this.defence = defence;
        this.shoot = shoot;
        this.damage = damage;
        this.health = health;
        this.maxHealth=maxHealth;
        this.speed = speed;
        this.gang=gang;
        this.position=new Vector2(x, y);
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        this.status="stand";
        playerID = idCounter++;
        this.fract=fract;
        this.target=null;
        this.damageValue=0;

    }

    public Vector2 getPosition() {return position;}
    public int getPlayerID() {
        return playerID;
    }
	
    public String getFract(){return fract;}

    public double getHealth() {return health;}

    public int getSpeed() {return speed;}

    public int getDefence() {return defence;}

    public int getAttack() {return attack;}

    public String getName() {return name;}

    public String getStatus() {return status;}

    public double distance(Base h){
        double result;
            result=Math.sqrt((h.getPosition().x-this.position.x)^2+(h.getPosition().y-this.position.y)^2);
        return result;

    }
    private int damageValue(Base h) {
        int value=0;
        int flag = this.getAttack() - h.getDefence();
        if (flag==0){
            value = ((this.getDamage()[0]+this.getDamage()[1])/2);
        }
        if (flag>0){
            value = this.getDamage()[1];
        }
        if (flag<0){
            value = this.getDamage()[0];
        }
        return value;
        
    }
    private int[] getDamage() {
        return null;
    }

    public void damage(){
        this.health=health-damage[0];
        if (this.health<=0){
            this.status="dead";
            this.health=0;
        }
        if (this.health>maxHealth){
            this.health=maxHealth;
        }
    }

    public boolean isEqualPos(int[] pos){
        return this.position.x==pos[0] && this.position.y==pos[1];
    }


    @Override
    public String getInfo() {
        return "attack=" + attack +
                ", protection=" + defence +
                ", shoot=" + shoot +
                ", damage=" + Arrays.toString(damage) +
                ", health=" + health +
                ", speed=" + speed +
                ", delivery=" + delivery +
                ", magic=" + magic;
    }

    @Override
    public void step(List<Base> gang) {}
    @Override
    public boolean hasNext() {
        return classFields++ < 8;
    }

    @Override
    public String next() {
        switch (classFields) {
            case 0: return "name=" + name;
            case 1: return ", attack=" + attack;
            case 2: return ", defense=" + defence;
            case 3: return ", damage=" + Arrays.toString(damage);
            case 4: return ", Max HP=" + maxHealth;
            case 5: return ", HP=" + health;
            case 6: return ", speed=" + speed;
            case 7: return ", status=" + status;


        }
        return null;
    }


}
