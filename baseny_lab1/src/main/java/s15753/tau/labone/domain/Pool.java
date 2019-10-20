package s15753.tau.labone.domain;

public class Pool{
    protected Integer id;
    protected double length;
    protected double width;
    protected double depth;
    
    public Pool(Integer id, Double length, Double width, Double depth){
        this.id = id;
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setLength(double length){
        this.length = length;
    }

    public Double getLength(){
        return this.length;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public Double getWidth(){
        return this.width;
    }

    public void setDepth(double depth){
        this.depth = depth;
    }

    public Double getDepth(){
        return this.depth;
    }
}