package chars;

import java.util.ArrayList;
import java.util.List;

public class Spearman extends Base {
    private String fraction;
    public Spearman(ArrayList<Base> gang, int x, int y, String fraction, int fieldSize) {
        super(4, 5, 0, new int[]{1,3}, 10, 4, false, false, "Spearman",fraction);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
    @Override
    public void step(Party party) {
        if (status.equals("dead")) {
            return;
        }
        Base target = position.findNearest(party.getByFraction(fraction, false));

        if (position.distance(target.position) <= (int) Math.sqrt(2)) {
            int damageValue = super.damageValue(target);
            target.damage(damageValue);
            return;
        }
        if (target.position.x < position.x && position.isValid(new Vector2(--position.x, position.y, fieldSize), myParty)) {
            --position.x;
            return;
        }
        if (target.position.x > position.x && position.isValid(new Vector2(++position.x, position.y, fieldSize), myParty)) {
            ++position.x;
            return;
        }
        if (target.position.y < position.y && position.isValid(new Vector2(position.x, --position.y, fieldSize), myParty)) {
            --position.y;
            return;
        }
        if (target.position.y > position.y && position.isValid(new Vector2(position.x, ++position.y, fieldSize), myParty)) {
            ++position.y;
        }
}
}
