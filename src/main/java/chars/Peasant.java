package chars;

import java.util.ArrayList;
import java.util.List;

public class Peasant extends Base {


    public Peasant(ArrayList<Base> gang, int x, int y, String fraction) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, true, false, "Peasant",fraction);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(Party party){
        if (this.status.equals("used")){
            this.status="stand";
        }
    }
}
