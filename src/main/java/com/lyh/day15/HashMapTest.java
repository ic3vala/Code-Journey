package com.lyh.day15;

import java.util.Scanner;

public class HashMapTest {
    public static void main(String[] args) {

        // 创建一个容量为 10 的哈希表，键和值均为 String 类型
        HashTable<String, String> table = new HashTable<>(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 显示菜单
            System.out.println("\n请选择操作：");
            System.out.println("1. 增（添加键值对）");
            System.out.println("2. 删（删除键值对）");
            System.out.println("3. 改（更新键值对）");
            System.out.println("4. 查（查询键值对）");
            System.out.println("5. 退出");
            System.out.print("输入你的选择（1-5）：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            // 退出程序
            if (choice == 5) {
                System.out.println("退出程序。");
                break;
            }

            // 根据选择执行操作
            switch (choice) {
                case 1: // 增
                    System.out.print("输入键：");
                    String addKey = scanner.nextLine();
                    System.out.print("输入值：");
                    String addValue = scanner.nextLine();
                    table.put(addKey, addValue);
                    System.out.println("添加成功： " + addKey + " -> " + addValue);
                    break;

                case 2: // 删
                    System.out.print("输入要删除的键：");
                    String removeKey = scanner.nextLine();
                    if (table.get(removeKey) != null) {
                        table.remove(removeKey);
                        System.out.println("删除成功：键 " + removeKey + " 已移除");
                    } else {
                        System.out.println("删除失败：键 " + removeKey + " 不存在");
                    }
                    break;

                case 3: // 改
                    System.out.print("输入要更新的键：");
                    String updateKey = scanner.nextLine();
                    if (table.get(updateKey) != null) {
                        System.out.print("输入新的值：");
                        String newValue = scanner.nextLine();
                        table.put(updateKey, newValue);
                        System.out.println("更新成功： " + updateKey + " -> " + newValue);
                    } else {
                        System.out.println("更新失败：键 " + updateKey + " 不存在");
                    }
                    break;

                case 4: // 查
                    System.out.print("输入要查询的键：");
                    String getKey = scanner.nextLine();
                    String value = table.get(getKey);
                    if (value != null) {
                        System.out.println("查询结果： " + getKey + " -> " + value);
                    } else {
                        System.out.println("查询失败：键 " + getKey + " 不存在");
                    }
                    break;

                default:
                    System.out.println("无效的选择，请输入 1-5 之间的数字。");
            }
        }
        scanner.close();
    }
}
