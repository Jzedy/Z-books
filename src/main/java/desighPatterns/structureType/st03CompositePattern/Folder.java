package desighPatterns.structureType.st03CompositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public class Folder extends AbstractFile {

    private List<AbstractFile> childs = new ArrayList<>();

    public Folder(String fileName) {
        super(fileName);
    }

    public void add(AbstractFile child){
        childs.add(child);
    }

    public void remore(AbstractFile child){
        childs.remove(child);
    }

    @Override
    void killVirus() {
        System.out.println("正在给文件夹<"+this.fileName+">杀毒");
        for (AbstractFile child : childs) {
            child.killVirus();
        }
    }
}
