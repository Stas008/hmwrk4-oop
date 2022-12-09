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
        myGang.get(mostDamegedInd).damage(damage[0]);
        myGang.get(mostDamegedInd).status="stand";

    }

}
