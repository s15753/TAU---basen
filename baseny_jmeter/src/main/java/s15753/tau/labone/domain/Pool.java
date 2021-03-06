package s15753.tau.labone.domain;


public class Pool{
    private Integer id;
    private Integer length;
    private Integer width;
    private Integer depth;

    public Pool() {
    }

    public Pool(Integer length, Integer width, Integer depth) {
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    public Pool(Integer id, Integer length, Integer width, Integer depth) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.depth = depth;
    }


    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setLength(Integer length){
        this.length = length;
    }

    public Integer getLength(){
        return this.length;
    }

    public void setWidth(Integer width){
        this.width = width;
    }

    public Integer getWidth(){
        return this.width;
    }

    public void setDepth(Integer depth){
        this.depth = depth;
    }

    public Integer getDepth(){
        return this.depth;
    }

}