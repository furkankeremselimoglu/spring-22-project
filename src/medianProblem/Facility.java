package medianProblem;
public class Facility{
    private int id = 0;
    private double x = 0;
    private double y = 0;
    private double supply = 0;
    
    public Facility(int id, double x, double y, double supply){
        this.id = id;
        this.x = x;
        this.y = y;
        this.supply = supply;
    }
    public double getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getSupply() {
        return supply;
    }
    public void setSupply(double supply) {
        this.supply = supply;
    }
}
