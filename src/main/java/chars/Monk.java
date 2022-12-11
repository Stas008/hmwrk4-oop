package chars;

import java.util.ArrayList;
import java.util.List;

public class Monk extends Base {
    public Monk(ArrayList<Base> myParty, int x, int y, String fraction) {
        super(12, 7, 0, new int[]{-4,-4}, 30, 5, false, true, "Monk", fraction);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(Party party){
        if (status.equals("dead")) {return;}
        double mostDamaged = myGang.get(0).maxHealth-myGang.get(0).health;
        int mostDamegedInd=0;
        for (int i=1; i<myGang.size(); i++){
            if ( (myGang.get(i).maxHealth-myGang.get(i).health)>mostDamaged ){
                mostDamaged=myGang.get(i).maxHealth-myGang.get(i).health;
                mostDamegedInd=i;
            }
        }
        if (0.75 >= mostDamagedInd) {
            ArrayList <BaseHero> enemies = party.getByFraction(fraction, false);
            for (int i = 1; i < enemies.size(); i++) {
                if(((float) (enemies.get(i).health / enemies.get(i).maxHealth)) < mostDamaged) {
                    mostDamagedInd = i;
                    mostDamaged = (float) (enemies.get(i).health / enemies.get(i).maxHealth);
                }
            }
            target = enemies.get(mostDamagedInd);
            damageValue = -damage[0];
            target.damage(damageValue);
        }
        else {
            target = allies.get(mostDamagedInd);
            if (mostDamaged == 0) { damageValue = -1; target.status = "stand"; }
            else damageValue = damage[0];
            target.damage(damageValue);
        }


        myGang.get(mostDamegedInd).damage(damage[0]);
        myGang.get(mostDamegedInd).status="stand";

    }

}
