package desighPatterns.createdType.ct04BuilderPattern;

/**
 * @author Jzedy
 * @time 2019/4/9 21:45
 * @description
 */
public class Message {

    protected String toUser;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public static TextBuilder TEXT(){
        return new TextBuilder();
    }
}
