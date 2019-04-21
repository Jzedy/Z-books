package desighPatterns.structureType.st03CompositePattern;

/**
 *组合模式：
 *  优点：
 *      1）清楚定义分层次的复杂对象，是使客户端忽略层次的差异，方便对整个层次结构进行控制
 *      2）客户端一致地使用组合结构或其中一个对象，不必关心处理的是单个对象还是整个组合结构，简化类客户端代码
 *      3）组合模式中增加新的容器结构和叶子结构都很方便，无需对现有类库进行修改，符合‘开闭原则’
 *      4）组合模式为树形结构的面向对象提供了一种灵活的解决方案，通过叶子对象和容器的递归组合，可以形成复杂的树形结构，但树形结构的控制非常简单
 *   缺点：
 *      1）在增加新构件时很难对构件类型进行控制
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class File extends AbstractFile {
    public File(String fileName) {
        super(fileName);
    }

    @Override
    public void killVirus() {
        System.out.println("正在给<"+this.fileName+">杀毒");
    }
}
