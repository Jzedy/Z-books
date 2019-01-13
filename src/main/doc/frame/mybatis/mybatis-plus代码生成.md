# mybatis-plus 代码生成

>之前采用maven-generator 生成代码，在配置文件上因为从单模块到多模块时出现问题，
改用mybatis-plus自动生成代码。

>码云地址：[https://gitee.com/baomidou/mybatis-plus](https://gitee.com/baomidou/mybatis-plus)

>githb地址：[https://github.com/baomidou/mybatis-plus](https://github.com/baomidou/mybatis-plus)
## 依赖

```
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>3.0.6</version>
</dependency>
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity</artifactId>
    <version>1.7</version>
</dependency>
```
## 单模块生成

```java
public class Generator {

    public static void main(String[] args) {
        String [] tableNames = new String[]{"表名1","表名2"};

        String location = "代码生成路径位置";//例如: com/cn/jzedy
        generator(location,tableNames);
    }

    private static void generator(String location,String [] tableNames){

        GlobalConfig globalConfig = new GlobalConfig();// 全局配置
                globalConfig.setOpen(false)//是否打开输出目录 默认true
                        .setOutputDir(location)//生成文件的输出目录
                        .setFileOverride(true)//是否覆盖已有文件 默认false
                        .setBaseResultMap(true)//开启 BaseResultMap 默认false
                        .setBaseColumnList(true)//开启 baseColumnList 默认false
                        .setActiveRecord(false)//开启 ActiveRecord 模式 默认false
                        .setAuthor("Jzedy")//开发人员
                        .setServiceName("%sService");//service 命名方式 例如：%sBusiness 生成 UserBusiness

        
        DataSourceConfig dataSourceConfig = new DataSourceConfig();// 数据源配置
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(Driver.class.getName())
                .setUsername("数据库连接名称")
                .setPassword("数据库连接密码")
                .setUrl("url地址");

        PackageConfig packageConfig = new PackageConfig();// 包配置
        packageConfig.setParent(location)
                .setEntity("entity")//Entity包名
                .setMapper("mapper")//mapper包名
                .setService("service")
                .setController("controller");

        StrategyConfig strategyConfig = new StrategyConfig();// 策略配置
                strategyConfig
                        .setCapitalMode(true)//驼峰命名
                        .setEntityLombokModel(false)//【实体】是否为lombok模型（默认 false）
                        .setRestControllerStyle(false)//生成 @RestController 控制器
                        .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略,该处下划线转驼峰命名
                        .setInclude(tableNames);//需要包含的表名，允许正则表达式（与exclude二选一配置）


        new AutoGenerator()//// 代码生成器
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig)
                .execute();

    }


}

```
> 具体配置查阅[https://mp.baomidou.com/](https://mp.baomidou.com/)

## 多模块配置
>因为项目分模块时候 想代码自动生成在对应位置，例如下面代码 将entity mapper service代码生成在
service模块中，controller生成在web模块中。可以自行模块进一步细分，只是对代码生成路径在但模块上
基础上调整而已。同时下述代码的代码生成模板是采用mybatis-plus自己的模板，若需自定义模板不再此论述，


```java
public class Generator {

    public static void main(String[] args) {
        String [] tableNames = new String[]{"users","roles"};

        String [] modules = new String[]{"service","web"};//项目模块名，需自定义
        for (String module : modules) {
            moduleGenerator(module,tableNames);
        }
    }

    private static void moduleGenerator(String module,String [] tableNames){

        GlobalConfig globalConfig = getGlobalConfig(module);// 全局配置

        DataSourceConfig dataSourceConfig = getDataSourceConfig();// 数据源配置

        PackageConfig packageConfig = getPackageConfig(module);// 包配置

        StrategyConfig strategyConfig = getStrategyConfig(tableNames);// 策略配置

        TemplateConfig templateConfig = getTemplateConfig(module);// 配置模板

        new AutoGenerator()
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig)
                .setTemplate(templateConfig)
                .execute();

    }

    private static TemplateConfig getTemplateConfig(String module) {
        TemplateConfig templateConfig = new TemplateConfig();
        if ("service".equals(module)){
            templateConfig.setEntity(new TemplateConfig().getEntity(false))
                    .setMapper(new TemplateConfig().getMapper())//mapper模板采用mybatis-plus自己模板
                    .setXml(new TemplateConfig().getXml())
                    .setService(new TemplateConfig().getService())
                    .setServiceImpl(new TemplateConfig().getServiceImpl())
                    .setController(null);//service模块不生成controller代码
        }else if ("web".equals(module)){//web模块只生成controller代码
            templateConfig.setEntity(null)
                    .setMapper(null)
                    .setXml(null)
                    .setService(null)
                    .setServiceImpl(null)
                    .setController(new TemplateConfig().getController());
        }else throw new IllegalArgumentException("参数匹配错误，请检查");
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig(String[] tableNames) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)//驼峰命名
                .setEntityLombokModel(false)
                .setRestControllerStyle(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);
        return strategyConfig;
    }

    private static PackageConfig getPackageConfig(String module) {
        PackageConfig packageConfig = new PackageConfig();
        String packageName = "com.cn.jzedy";//不同模块 代码生成具体路径自定义指定
        if ("service".equals(module)){
            packageName+=".web";
        }else if ("web".equals(module)){

        }
        packageConfig.setParent(packageName)
                .setEntity("entity")
                .setMapper("mapper")
                .setService("service")
                .setController("controller");
        return packageConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        String dbUrl = "jdbc:mysql://localhost:3306/z-blogs";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(Driver.class.getName())
                .setUsername("root")
                .setPassword("root")
                .setUrl(dbUrl);
        return dataSourceConfig;
    }

    private static GlobalConfig getGlobalConfig(String module) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOpen(false)//new File(module).getAbsolutePath()得到模块根目录路径，因事Maven项目，代码指定路径自定义调整
                .setOutputDir(new File(module).getAbsolutePath()+"/src/main/java")//生成文件的输出目录
                .setFileOverride(true)//是否覆盖已有文件
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setActiveRecord(false)
                .setAuthor("Jzedy")
                .setServiceName("%sService");
        return globalConfig;
    }

}
```
