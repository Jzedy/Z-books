package desighPatterns.structureType.st03CompositePattern;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class Client {


    public static void main(String[] args) {
        AbstractFile file1,file2;
        Folder folder;
        file1 = new File("小龙女.jps");
        file2 = new File("笑傲江湖.rmvb");
        folder = new Folder("文件夹");
        folder.add(file1);
        folder.add(file2);
        folder.killVirus();
    }
}
