
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass<A> test1 = new TestClass<A>();
        TestClass<A> test2 = new TestClass<A>();
        TestClass<B> test3 = new TestClass<B>();
        
        // Box class declaration
        Box<A> test4 = new Box<A>();
        Box<B> test5 = new Box<B>();
        // 
        // Print results
        System.out.println("Test1: " + TestClass.countObject); // 2
        System.out.println("Test2: " + TestClass.countObject); // 1
        System.out.println("Test3: " + TestClass.countObject);
	
	}
}

// create new generic class BOX
// add some more description on T
// new description

class Box<T> {
	// T stands for "Type"
	private T t;
	
	public void set(T t) { this.t = t; }
	public T get() { return t; }
}

class TestClass<T> {
	private T t ;
	
	public static int countObject =  0;
	
	public TestClass()
	{
	    countObject++;
	}
}

class A {
	public static int countObject =  5;
	
	public void Display()
	{
		System.out.println("From A");
	}
}

class B extends A {
	public static int countObject =  10;
	
	@Override
	public void Display()
	{
		System.out.println("From B");
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