class add{
public static void main(String []args){
int a=10;
int b=20;
int c=a+b;
System.out.println(c);
System.out.println("Additon class:");
Addition  ad =new Addition();
ad.add(30, 40);
}
}
class Addition{
	
	public void add(int a,int b) {
		System.out.println(a+b);
	}
}
