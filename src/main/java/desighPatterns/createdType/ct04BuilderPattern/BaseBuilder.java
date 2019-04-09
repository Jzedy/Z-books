package desighPatterns.createdType.ct04BuilderPattern;

/**
 * @author Jzedy
 * @time 2019/4/9 21:45
 * @description
 */
public abstract class BaseBuilder<BuilderType,ValueType> {
    protected String toUser;
    public BuilderType toUser(String toUser){
        this.toUser = toUser;
        return (BuilderType) this;
    }

    public abstract ValueType build();

    protected void setCommon(Message message){
        message.setToUser(toUser);
    }
}
