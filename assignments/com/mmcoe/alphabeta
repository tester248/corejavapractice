class Alpha
{
    public Alpha(){
        System.out.println("Alpha Constructor");
    }
    public void demo()
    {
        System.out.println("Alpha Demo");
    }
}

class Beta extends Alpha
{
    public Beta()
    {
        System.out.println("Beta Constructor");
    }
    public void test()
    {
        System.out.println("Beta test");
    }
    public void demo()
    {
        System.out.println("Beta demo");
    }
}

public class alphabeta
{
    public static void main(String[] args)
    {
        Beta b = new Beta();
        b.demo();
        b.test();

        // Upcasting
        Alpha a = new Beta();
        a.demo();

        // Downcasting
        Beta down = (Beta) a;
        down.demo();
        down.test();

        // Downcasting with instanceof check (safe)
        Object obj = new Beta();
        if (obj instanceof Beta) {
            Beta safe = (Beta) obj;
            safe.demo();
        }
    }
}