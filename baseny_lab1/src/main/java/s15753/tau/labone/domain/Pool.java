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
    private Boolean is_add_dt = true;
    private Boolean is_updt_dt = true;
    private Boolean is_read_dt = true;
    private Clock clock = Clock.systemDefaultZone();

    
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

    public void setAddDt() {
        if(is_add_dt) {
            this.add_dt = LocalDateTime.now(clock);
        }
    }

    public LocalDateTime getAddDt() { return this.add_dt; }

    public void setLastUpdtDt() {
        if (is_updt_dt) {
            this.last_updt_dt = LocalDateTime.now(clock);
        }
    }

    public LocalDateTime getLastUpdtDt() { return this.last_updt_dt; }

    public void setLastReadDt() {
        if (is_read_dt) {
            this.last_read_dt = LocalDateTime.now(clock);
        }
    }

    public LocalDateTime getLastReadDt() { return this.last_read_dt; }

    public void settAddInd(Boolean is_add_dt) {
        this.is_add_dt = is_add_dt;
    }

    public Boolean getAddInd() {
        return this.is_add_dt;
    }

    public void settUpdtInd(Boolean is_updt_dt) {
        this.is_updt_dt = is_updt_dt;
    }

    public Boolean getUpdtInd() {
        return this.is_updt_dt;
    }

    public void settReadInd(Boolean is_updt_dt) {
        this.is_read_dt = is_read_dt;
    }

    public Boolean getReadInd() {
        return this.is_read_dt;
    }
}