package chars;

public class Vector2 {
    public int x,y;

    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean isEqual(Vector2 pos){
        if (pos.y == y & pos.x ==x) return true;
        return false;
    }
    @Override
    public String toString(){
        return "( "+x+","+y+")";
    }
    public float getDistance(Vector2 vector2){
        return (float) Math.sqrt((x-vector2.x)^2+(y-vector2.y));
    }
}
