package desighPatterns.behaviorType.bt03InterpreterPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 解释器模式：
 *  优点：
 *      (1) 易于改变和扩展文法。由于在解释器模式中使用类来表示语言的文法规则,因此可以通过
 *          继承等机制来改变或扩展文法。
 *      (2) 每一条文法规则都可以表示为一个类,因此可以方便地实现一个简单的语言。
 *      (3) 实现文法较为容易。在抽象语法树中每一个表达式节点类的实现方式都是相似的,这些类
 *          的代码编写都不会特别复杂,还可以通过一些工具自动生成节点类代码。
 *      (4) 增加新的解释表达式较为方便。如果用户需要增加新的解释表达式只需要对应增加一个新
 *          的终结符表达式或非终结符表达式类,原有表达式类代码无须修改,符合“开闭原则”。
 *  缺点：
 *      1）对于复杂文法难以维护
 *      2）执行效率低
 * @author Jzedy
 * @time 19-5-6
 * @description
 */
public class Calculator {

    private Node node;

    public void build(String expression){
        char[] chars = expression.toCharArray();
        List<String> list = new ArrayList<>();
        for (char c : chars) {
            if(c != ' '){
                list.add(String.valueOf(c));
            }
        }
        Stack<Node> stack = new Stack<>();
        Node left,right;
        for (int i = 0; i < list.size(); i++) {
            if ("+".equals(list.get(i))){
                left = stack.pop();
                right = new ValueNode(Integer.valueOf(list.get(++i)));
                stack.push(new AddNode(left,right));
            }else if ("-".equals(list.get(i))){
                left = stack.pop();
                right = new ValueNode(Integer.valueOf(list.get(++i)));
                stack.push(new SubNode(left,right));
            }else if ("*".equals(list.get(i))){
                left = stack.pop();
                right = new ValueNode(Integer.valueOf(list.get(++i)));
                stack.push(new MulNode(left,right));
            }else if ("/".equals(list.get(i))){
                left = stack.pop();
                right = new ValueNode(Integer.valueOf(list.get(++i)));
                stack.push(new DivNode(left,right));
            }else {
                stack.push(new ValueNode(Integer.valueOf(list.get(i))));
            }
        }
        this.node = stack.pop();
    }

    public int compute(){
        return node.interpret();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.build("1+2+2");
        int result = calculator.compute();
        System.out.println(result);
    }
}
