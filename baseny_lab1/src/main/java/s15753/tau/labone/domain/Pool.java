package s15753.tau.labone.domain;
import java.time.ZoneId;
import java.time.Clock;
import java.time.LocalDateTime;

public class Pool{
    private Integer id;
    private Integer length;
    private Integer width;
    private Integer depth;
    private LocalDateTime add_dt;
    private LocalDateTime last_updt_dt;
    private LocalDateTime last_read_dt;


    
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


    public void setAddDt(Clock clock) { this.add_dt = LocalDateTime.now(clock); }

    public LocalDateTime getAddDt() { return this.add_dt; }

    public void setLastUpdtDt(Clock clock) { this.last_updt_dt = LocalDateTime.now(clock); }

    public LocalDateTime getLastUpdtDt() { return this.last_updt_dt; }

    public void setLastReadDt(Clock clock) { this.last_read_dt = LocalDateTime.now(clock); }

    public LocalDateTime getLastReadDt() { return this.last_read_dt; }

}