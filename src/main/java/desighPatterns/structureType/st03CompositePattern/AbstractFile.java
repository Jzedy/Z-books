package desighPatterns.structureType.st03CompositePattern;

/**
 * @author Jzedy
 * @time 19-4-21
 * @description
 */
public abstract class AbstractFile {

    protected String fileName;

    public AbstractFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    abstract void killVirus();
}
