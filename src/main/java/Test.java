
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass<A> test1 = new TestClass<A>();
        TestClass<A> test2 = new TestClass<A>();
        TestClass<B> test3 = new TestClass<B>();
        // CountObject - static property in class TestClass 
        System.out.println("Test1: " + TestClass.CountObject); // 2
        System.out.println("Test2: " + TestClass.CountObject); // 1
        System.out.println("Test3: " + TestClass.CountObject);
	
	}
}

class TestClass<T> {
	public static int CountObject =  0;
	
	public TestClass()
	{
	    CountObject++;
	}
}

class A {
	public static int CountObject =  5;
	
	public void Display()
	{
		System.out.println("Class A description");
	}
}

class B extends A {
	public static int CountObject =  10;
	
	@Override
	public void Display()
	{
		System.out.println("Class B description");
	}
}









//namespace ConsoleApp2
//{
//    class Program
//    {
//        static void Main(string[] args)
//        {
//            TestClass<A> test1 = new TestClass<A>();
//            TestClass<A> test2 = new TestClass<A>();
//            TestClass<B> test3 = new TestClass<B>();
//            // CountObject - static property in class TestClass 
//            Console.WriteLine(TestClass<A>.CountObject); // 2
//            Console.WriteLine(TestClass<B>.CountObject); // 1
//
//            Console.ReadKey();
//        }
//    }

//    class TestClass<T> 
//        where T : A
//    {
//        public static int CountObject { get; set; }
//
//        public TestClass()
//        {
//            CountObject++;
//        }
//    }
//
//    public class A
//    {
//        public virtual void Display()
//        {
//            Console.WriteLine("From A");
//        }
//    }
//
//    public class B : A
//    {
//        public override void Display()
//        {
//            Console.WriteLine("From B");
//        }
//    }
//}