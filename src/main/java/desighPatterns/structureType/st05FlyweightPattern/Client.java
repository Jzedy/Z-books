package desighPatterns.structureType.st05FlyweightPattern;

/**
 *享元模式
 *  优点：
 *      1）极大减少内存中对象的数量，使得相同或相似对象在内存中只保存一份，从而节约资源，提高系统性能
 *      2）享元模式的外部状态相对独立,而且不会影响其内部状态，从而使得享元模式可以在不同环境中被共享
 *  缺点：
 *      1）享元模式使得系统变得复杂，需要分离出内部状态和外部状态，这使得程序的逻辑复杂化
 *      2）为了使对象可以共享，享元模式需要享元对象的部分状态外部化，而读取外部状态将使得运行时间变长
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class Client {

    public static void main(String[] args) {
        ChessmanFactory fa = ChessmanFactory.getInstance();
        Chessman chessman = fa.getChessman(ChessmanColor.BLACK);
        Chessman chessman2 = fa.getChessman(ChessmanColor.BLACK);
        System.out.println(chessman.getColor());
        System.out.println(chessman2.getColor());
        System.out.println(chessman == chessman2);
        Chessman chessman3 = fa.getChessman(ChessmanColor.WHITE);
        chessman3.display();
    }
}
