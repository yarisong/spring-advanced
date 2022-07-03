package hello.advanced.trace;

import java.util.UUID;

public class TraceId{

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level){
        this.id = id;
        this.level = level;
    }
    public String createId() {
        // 길이가 길어짐에 따라 8자리로만 사용(중복이 되긴 하지만 크게 영향을 받지 않음)
        return UUID.randomUUID().toString().substring(0,8);
    }

    private TraceId createNextId(){
        return new TraceId(id, level +1 );
    }

    public boolean isFirstLevel(){
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
