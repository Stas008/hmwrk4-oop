package chars;

import java.util.Arrays;
import java.util.List;

public abstract class Base implements BaseInterface {
    private int attack;
    private int defence;
    protected int shoot;
    private int[] damage;
    protected double health;
	protected int maxHealth;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
	protected String status;
    private static int idCounter;
    private int playerID;
    protected List<Base> gang;
    protected Vector2 position;
    

    public Base(int attack, int defence, int shoot, int[] damage, double health, int speed, boolean delivery, boolean magic, String name) {
        this.attack = attack;
        this.defence = defence;
        this.shoot = shoot;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        this.status="stand";
        playerID = idCounter++;
    }

    public Vector2 getPosition() {return position;}
    public int getPlayerID() {
        return playerID;
    }
	
    public double getHealth() {return health;}

    public int getSpeed() {return speed;}

    public int getDefence() {return defence;}

    public int getAttack() {return attack;}

    public String getName() {return name;}

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
}
