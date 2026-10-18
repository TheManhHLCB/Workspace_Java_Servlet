package com.codegym;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GIẢI PHƯƠNG TRÌNH BẬC 2 SỬ DỤNG THƯ VIỆN ---");
        
        System.out.println("\n1. Phương trình: x^2 - 3x + 2 = 0");
        QuadraticEquationSolver.solve(1, -3, 2);
        
        System.out.println("\n2. Phương trình: x^2 - 2x + 1 = 0");
        QuadraticEquationSolver.solve(1, -2, 1);
        
        System.out.println("\n3. Phương trình: x^2 + x + 1 = 0");
        QuadraticEquationSolver.solve(1, 1, 1);
    }
}
