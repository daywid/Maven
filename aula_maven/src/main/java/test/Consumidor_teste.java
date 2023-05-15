package test;

public class Consumidor_teste {

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.var_publica = 1;
		t1.var_statica = 1;
		
		System.out.println("Publica:" + t1.var_publica);
		System.out.println("Estatica:" + t1.var_statica);
		
		Test t2 = new Test();
		t2.var_publica = 37;
		
	}

}
