import java.util.Scanner;

public class min_heap {
    public static void main(String[] args) {
        min_op mp=new min_op();
        int ch = 0, i = -1;
        Scanner sc = new Scanner(System.in);
        int[] heap = new int[100];
        do {
            System.out.println("enter data in to the heap");
            i++;
            heap[i] = sc.nextInt();
            System.out.println("do you wish to continue");
            ch = sc.nextInt();
        } while (ch == 1);
        //min_op mp=new min_op();
        int last_non_leaf=mp.find_last_non_leaf(i);
        heap=mp.print(heap,i);
        heap=mp.make_heap(heap,last_non_leaf);
        heap=mp.print(heap,i);
    }

}
class min_op
{
    public int[] print(int[] x,int len)
    {
        //System.out.println("hai");
        for(int i=0;i<=len;i++) {
            System.out.print(" "+x[i]);
        //    x[i]++;
        }
        System.out.println();
        return x;
    }
    public int[] make_heap(int[] x,int len)
    {
        min_op mp=new min_op();
        for(int i=0;i<=len;i++)
        x=mp.swap(x,len);
        return x;
    }
    public int[] swap(int[] x,int len)
    {
        min_op mp=new min_op();
        int tmp,data_left_kid=x[mp.find_left_kid(len)],data_right_kid=x[mp.find_right_kid(len)];
        if(data_left_kid<x[len])
        {
            tmp=x[mp.find_left_kid(len)];
            x[mp.find_left_kid(len)]=x[len];
            x[len]=tmp;
        }
        if(data_right_kid<x[len])
        {
            tmp=x[mp.find_right_kid(len)];
            x[mp.find_right_kid(len)]=x[len];
            x[len]=tmp;
        }
        if(len!=0)
        {
            len--;
            mp.swap(x,len);
        }
        return x;
    }
    public int find_left_kid(int par)
    {
        return ((2*par)+1);
    }
    public int find_right_kid(int par)
    {
        return ((2*par)+2);
    }
    public int find_parent(int kid)
    {
        return ((kid-1)/2);
    }
    public int find_last_non_leaf(int length)
    {
        min_op mp=new min_op();
        return mp.find_parent(length);
    }
}
