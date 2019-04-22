package desighPatterns.structureType.st05FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class ChessmanFactory {

    private static ChessmanFactory factory = new ChessmanFactory();

    private static Map<String,Chessman> map;

    public ChessmanFactory() {
        map = new HashMap();
        map.put(ChessmanColor.BLACK,new BlackChessman());
        map.put(ChessmanColor.WHITE,new WhiteChessman());
    }

    public static ChessmanFactory getInstance(){
        return factory;
    }

    public Chessman getChessman(String color){
        return map.get(color);
    }
}
