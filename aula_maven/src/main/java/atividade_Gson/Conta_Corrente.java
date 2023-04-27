/* Após realizar os tutoriais sobre Gson, faça o que se pede
1. Implemente um classe conta_corrente{numero, tipo, saldo} com os métodos sacar e depositar
2. Implemente uma classe cliente {cpf, nome, email,conta}.
3. Implemente uma classe banco {id, nome_do_banco, clientes<lista de clientes>}
4. Serialize cada uma das classes para Json utilizando GSon e imprima no console
5. Monte uma string Json para cada classe e mapeie para os respectivos objetos. Imprima as propriedades dos objetos no console
*/

package atividade_Gson;

public class Conta_Corrente {
	public int numero;
	public String tipo;
	public double saldo;
	
	public Conta_Corrente(int numero, String tipo, double saldo) {
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = saldo;
	}
	
	public double depositar(double numero) {
		this.saldo+=numero;
		return this.saldo;
	
	}
	public boolean sacar(double numero) {
		
		if(this.saldo<numero) {
		
			return false;
		}
		else  {		
			
			return true;
		}
			
	}
	public double consultar() {
		System.out.println("Saldo da conta: " + numero + ": " + saldo);
		return saldo;
	}

}