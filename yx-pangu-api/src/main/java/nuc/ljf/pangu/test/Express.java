/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.test;

import java.util.Stack;

/**
 * ClassName: Express <br/>
 * Function: <br/>
 * date: 2019年05月06日 10:50 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

public class Express {

    private static Stack<Integer> nums = new Stack<>();

    private static Stack<Character> operators = new Stack<>();

    private static String express = "3+5-9-(2*3)/3";

    public static void main(String[] args) {
        char[] charArr = express.toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            if(isOperator(charArr[i])) {
                if(isLowPriority(charArr[i])){
                   compute();
                }
                operators.push(charArr[i]);
            }else {
                nums.push(Integer.parseInt(Character.toString(charArr[i])));
            }
        }
        while(!operators.isEmpty()){
            compute();
        }
        System.out.println(nums.pop());
    }

    private static void compute() {
        char topOperator = operators.pop();
        if(topOperator == ')'){
            topOperator = operators.pop();
            while(topOperator != '('){
                compute(nums.pop(), nums.pop(), topOperator);
                topOperator = operators.pop();
            }
        }else{
            compute(nums.pop(), nums.pop(), topOperator);
        }
    }

    private static void compute(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                result = 0;
        }
        nums.push(result);
    }

    private static boolean isOperator(char c) {
        if(Character.isDigit(c)) {
            return false;
        }else{
            return true;
        }
    }

    private static boolean isLowPriority(char currentOperator) {
        if(operators.isEmpty()) {
            return false;
        }
        char topOperator = operators.peek();
        if(currentOperator == '('){
            return false;
        }else if(currentOperator == '+' || currentOperator == '-'){
            if(topOperator == '(')
                return false;
            else
                return true;
        }else if(currentOperator == '*' || currentOperator == '/'){
            if(topOperator == '+' || topOperator == '-' || topOperator == '(')
                return false;
            else
                return true;
        }else if(currentOperator == ')'){
            return false;
        }else{
            return false;
        }
    }

}
