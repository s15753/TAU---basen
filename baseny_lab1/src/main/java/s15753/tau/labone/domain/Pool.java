package s15753.tau.labone.domain;

public class Pool{
    protected int id;
    protected Double length;
    protected Double width;
    protected Double depth;
    
    public Pool(int id, Double length, Double width, Double depth){
        this.id = id;
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setLength(Double length){
        this.length = length;
    }

    public Double getLength(){
        return this.length;
    }

    public void setWidth(Double width){
        this.width = width;
    }

    public Double getWidth(){
        return this.width;
    }

    public void setDepth(Double depth){
        this.depth = depth;
    }

    public Double getDepth(){
        return this.depth;
    }
}