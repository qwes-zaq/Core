package task1;

import java.util.Date;

public class Main {
    public static void main(String[] args)
    {
        int[][] matrix= new int[10][10];
        fillMatrixWithRandomNumbers(matrix);
        System.out.println("Max:  " + findMax(matrix));
        System.out.println("Min: " + findMin(matrix));
        System.out.println("Average: " + findAverage(matrix));
    }

    public static void fillMatrixWithRandomNumbers(int[][] matrix)
    {
        for (int i=0; i< matrix.length;i++)
        {
            for (int j=0; j< matrix[i].length; j++)
            {
                matrix[i][j] = (int)random(i, j);
            }
        }
    }
    public static long random(int x, int y)
    {
        var answer = (new Date()).getTime();

        if(answer%2==0)
        {
            answer*=-1;
        }

        if (x%3 == 1)
        {
            answer*= Math.abs(x+y)+3;
        }
        else if (x%3 == 2)
        {
            answer*= Math.abs(x+y)+5;
            answer+= 12345678;
        }

        if (y%3 == 1)
        {
            answer*= Math.abs(x+y)+3;
        }
        else if (y%3 == 2)
        {
            answer*= Math.abs(x+y)+5;
            answer+= 876541213;
        }

        return answer;
    }
    public static int findMin(int[][] matrix)
    {
        int min = matrix[0][0];

        for (int i=0; i < matrix.length; i++)
        {
            for (int j=0; j < matrix[i].length; j++)
            {
                if (min > matrix[i][j])
                {
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }
    public static int findMax(int[][] matrix)
    {
        int max = matrix[0][0];

        for (int i=0; i < matrix.length; i++)
        {
            for (int j=0; j < matrix[i].length; j++)
            {
                if (max < matrix[i][j])
                {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }
    public static double findAverage(int[][] matrix)
    {
        int count = (matrix.length)*(matrix[0].length);
        int answer = 0;

        for (int i=0; i < matrix.length; i++)
        {
            for (int j=0; j < matrix[i].length; j++)
            {
                answer += matrix[i][j];
            }
        }

        return (double)answer/count;
    }
}
