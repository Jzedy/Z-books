package desighPatterns.createdType.ct04BuilderPattern;

/**
 * @author Jzedy
 * @time 2019/4/9 21:50
 * @description
 */
public class TextMessage extends Message {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "content='" + content + '\'' +
                ", toUser='" + toUser + '\'' +
                '}';
    }
}
