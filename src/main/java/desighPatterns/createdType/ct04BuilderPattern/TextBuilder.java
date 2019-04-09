package desighPatterns.createdType.ct04BuilderPattern;

/**
 * @author Jzedy
 * @time 2019/4/9 21:49
 * @description
 */
public class TextBuilder extends BaseBuilder<TextBuilder, TextMessage> {
    private String content;

    public TextBuilder content(String content){
        this.content = content;
        return this;
    }

    @Override
    public TextMessage build() {
        TextMessage message = new TextMessage();
        setCommon(message);
        message.setContent(content);
        return message;
    }

}
