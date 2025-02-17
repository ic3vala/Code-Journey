package com.lyh.day7;

import java.util.Scanner;

// 自定义异常类
class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super("Invalid input: " + message);
    }
}

class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException(String message) {
        super("Division by zero: " + message);
    }
}

// 计算器类
class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            throw new DivisionByZeroException("Divisor cannot be zero");
        }
        return a / b;
    }
}

// 控制台应用程序
public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("请输入算式（输入 exit 退出）→ ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("程序已退出。");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("输入格式错误，请输入 '数字1 操作符 数字2'，例如：5 + 3");
                continue;
            }

            double a, b;
            String operator = parts[1];
            String num1 = parts[0];
            String num2 = parts[2];

            try {
                a = Double.parseDouble(num1);
                b = Double.parseDouble(num2);
            } catch (NumberFormatException e) {
                System.out.println("输入的数字无效，请确保输入的是数字。");
                continue;
            }

            try {
                switch (operator) {
                    case "+":
                        System.out.println("结果: " + calc.add(a, b));
                        break;
                    case "-":
                        System.out.println("结果: " + calc.sub(a, b));
                        break;
                    case "*":
                        System.out.println("结果: " + calc.mul(a, b));
                        break;
                    case "/":
                        System.out.println("结果: " + calc.div(a, b));
                        break;
                    default:
                        System.out.println("不支持的操作符，请使用 + - * /");
                        continue;
                }
            } catch (DivisionByZeroException e) {
                System.out.println(e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("发生未知错误，请稍后再试。");
            }
        }
        scanner.close();
    }
}
