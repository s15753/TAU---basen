package s15753.tau.labone.domain;

import java.time.LocalDateTime;

public class Pool{
    private Integer id;
    private Integer length;
    private Integer width;
    private Integer depth;
    private LocalDateTime add_dt;
    private LocalDateTime last_updt_dt;
    private LocalDateTime last_read_dt;
    
    public Pool(Integer id, Integer length, Integer width, Integer depth){
        this.id = id;
        this.length = length;
        this.width = width;
        this.depth = depth;

    }

    public Pool(Integer id, Integer length, Integer width, Integer depth, LocalDateTime add_dt, LocalDateTime last_updt_dt, LocalDateTime last_read_dt) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.add_dt = add_dt;
        this.last_updt_dt = last_updt_dt;
        this.last_read_dt = last_read_dt;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public int getId(){
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