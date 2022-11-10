/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tspsolving;


/**
 *
 * @author ADMIN
 */

import java.util.Scanner;
 

class TSPSolving {

    static int[][] two_dim_cost_matrix = new int [100] [100];
    static boolean[] visited_copy_array = new boolean[100];
    static int no_of_vertices, current_vertex, total_min_cost = 0;
    public static void input()
    {
        Scanner scobj = new Scanner(System.in);
        System.out.print("Enter number of vertices/cities: ");
        no_of_vertices = scobj.nextInt();
        System.out.print("Enter starting vertex: ");
        current_vertex = scobj.nextInt();
        for(int i = 0; i < no_of_vertices; i++)
        {
            for(int j = 0; j < no_of_vertices; j++)
            {
                if(i == j)
                {
                    two_dim_cost_matrix[i][j] = 0;
                }
                else
                {
                    System.out.print("Enter the cost between the path: "+(i+1)+"----->"+ (j+1)+": ");
                    two_dim_cost_matrix[i][j] = scobj.nextInt();
                }
            }
        }
        System.out.println("\nCost matrix: ");
        for(int i = 0; i < no_of_vertices; i++)
        {
            for(int j = 0;j < no_of_vertices; j++)
            {
                System.out.print(two_dim_cost_matrix[i][j] + "  ");
            }
            System.out.println();
        }
        
    }
    
    public static int next_visit(int c_vertex)
    {
         
         int MIN = Integer.MAX_VALUE;
         int cost_spent = 0, next_vertex = Integer.MAX_VALUE;
         for(int i = 0; i < no_of_vertices; i++)
         {
             if(two_dim_cost_matrix [c_vertex - 1][i]!=0 && ! visited_copy_array[i])
             {
                 if(two_dim_cost_matrix[c_vertex - 1][i] + two_dim_cost_matrix[i][c_vertex-1] < MIN)
                 {
                     MIN = two_dim_cost_matrix[c_vertex-1][i]+two_dim_cost_matrix[i][c_vertex - 1];
                     cost_spent = two_dim_cost_matrix[c_vertex - 1][i];
                     next_vertex = i;
                 }
             }
         }
         if(MIN != Integer.MAX_VALUE)
         {
             total_min_cost += cost_spent ;
         }
         return next_vertex;
    }
    
    public static void shortest_distance(int c_vertex)
    {
        visited_copy_array[c_vertex-1] = true;
        //System.out.print(c_vertex+"--->");//line 83 an error lies here...check it
        int nxt_visit = next_visit(c_vertex);
        if(nxt_visit == Integer.MAX_VALUE + 1)
        {
            System.out.print(current_vertex);
            total_min_cost += two_dim_cost_matrix[c_vertex - 1][current_vertex - 1];
            return;
        }
        //shortest_distance(nxt_visit); //there is an error at line 91
    }
    
    
    public static void main(String[] args) 
    {
        input();
        //System.out.println("\nSalesman's path: ");
        shortest_distance(current_vertex);
        System.out.println();
        System.out.println("\nTour Cost: "+total_min_cost);
    }

  
}



