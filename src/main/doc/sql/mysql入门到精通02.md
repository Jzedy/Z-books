#  mysql从入门到精通摘要

## 数据类型和运算符
>MySQL支持多种数据类型，主要有数值类型、日期/时间类型和字符串类型
>> 1. 数字数据类型：包括整数类型TINYINT、SMALLINT、MEDIUMINT、INT、
>>   BIGINT、浮点小数数据类型：FLOAT和DOUBLE,定点小数类型：DECIMAL 
>> 2. 日期/时间类型：YEAR、TIME、DATE、DATETIME、TIMESTAMP
 >> 3. 字符串数据类型：CHAR、VARCHAR、BINARY、VARBINARY、BLOG、TEXT、ENUM、SET
 
## MySQL函数
>包含：数学函数、字符串函数、日期和时间函数、条件判断函数、系统信息函数、加密函数等

- 数学函数
    - 绝对值函数ABS()和返回圆周率函数PI()
    - 平方根函数SQRT()和求余函数MOD(X,Y)
    - 获取整数CEIL(X)、CEILING(X)和FLOOR(X)、ROUND(X)和ROUND(X,Y)、TRUNCATE(X,Y)
        >CEIL(X)和CEILING(X)返回不小于x的最小整数值，floor(x)返回不大于x的最大整数值,
        ROUND(X)对X四舍五入,ROUND(X,Y)对X四舍五入，保留Y位小数,
        TRUNCATE(X,Y)舍去X小数点后Y位数字
    - 获取随机数RAND()和RAND(X)
    - 符号函数SIGN(X)
        >X为负数、0和正数时候返回-1、0和1
    - 幂运算函数POW(X,Y),POWER(X,Y)和EXP(X)
        >POW(X,Y),POWER(X,Y)返回x的y次方值；EXP(x)返回计算e的x次方值
    - 对数函数LOG(X)和LOG10(X)
        > LOG(X)返回x相对于基数e的对数，LOG10(X)返回x相对于10的对数
    - 正弦函数SIN(x)和反正弦函数ASIN(x)
    - 余弦函数COS(X)和反余弦函数ACOS(X)
    - 正切函数TAN(X)、反正切函数ATAN(X)和余切函数COT(X)
 
 - 字符串函数
    - CHAR_LENGTH(STR) 返回str包含的字符个数
    - CONCAT(S1,S2...)和CONCAT_WS(X,S1,S2,...)连接字符串函数
        >CONCAT()结果为连接参数的字符串，如果有有一个为null，结果为null，
        CONCAT_WS()代表CONCAT With separator,即第一个为分隔符连接其他字符串,
        如果分割符为null，结果为null，如果分隔符不为null，连接参数包含null，
        结果忽略这个连接参数
    - INSERT(S1,X,LEN,S2)替换字符串
        >返回S1从x位置后续LEN长度被S2替换
        
        | insert('jzedy',2,3,'hello') | insert('jzedy',2,2,'hh') | insert('jzedy',2,7,'hello') |
        | :------: | :------: | :------: |
        | jhelloy | jhhdy | jhello |
        
    - LOWER(S)和LCASE(S) 字符串变为小写,UPPER(S)和UCASE(S)字符串函数变为大写
    - 获取指定长度的字符串函数 LEFT(S,N)和RIGHT(S,N)
        >获取字符串S左/右开始的N长度的字符串
    - LPAD(S1,N,S2)和RPAD(S1,N,S2)
        >LPAND(S1,N,S2)返回长度为N，从S1截取，不足的由s2补足
        
        | LPAD('HELLO',4,'-?') | LPAD('HELLO',10,'-?') |
        | :------: | :------: |
        | HELL | -?-?-HELLO |
    - 删除空格函数LTRIM(S),RTRIM(S)和TRIM(S)
        >删除左边/右边/两边的空格
    - 删除指定字符串函数  TRIM(S FROM S2)
        删除s2两端s字符串得到结果
    - 生成重复字符串REPEAT(S,N)
        >生成重复n次s的字符串，如果n<= 0 ，返回空字符串，如果n或者s为null，返回null
    - SPACE(N)、REPLACE(S,S1,S2)
        >生成n个空格组成的字符串SPACE(N)、用s2替换s中所有的s1函数REPLACE(S,S1,S2)
    
    - STRCMP(S1,S2)
        >比较两个字符串大小，相等返回0，S1小于S2返回-1，S1大于S2返回1
        
        
 

