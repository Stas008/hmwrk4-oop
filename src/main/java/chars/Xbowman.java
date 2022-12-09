package chars;

import java.util.ArrayList;
import java.util.List;

public class Xbowman extends Base {
    public Xbowman(List<Base> gang, int x, int y, String fraction) {
        super(6, 3, 16, new int[]{2,3}, 10, 4, false, false, "Xbowman",fraction);
        super.gang = (ArrayList<Base>) gang;
        super.position = new Vector2(x, y);}
    
    public int getShoot(){
        return shoot;
    }
    public void setShoot(int shoot){
        this.shoot=shoot;

    }

    @Override
    public void step(Party party){
        for (Base h: this.gang){
            if ((h.getName().equals("Peasant")) & (h.status=="stand")){
                this.shoot++;
                h.status="used";
                break;


            }

        }
        double nearest=this.distance(gang.get(0));
        int nearestInd=0;
        for(int i=1; i<gang.size(); i++){
            if (this.distance(gang.get(i))<nearest){
                nearest=this.distance(gang.get(i));
                nearestInd=i;
            }
        }
        gang.get(nearestInd).damage(nearest < this.getSpeed() ?
            super.damageValue(gang.get(nearestInd)):
            super.damageValue(gang.get(nearestInd))/2);
        if (this.shoot>0){
            this.shoot--;
        }
        

    }
}


