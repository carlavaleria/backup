package Testes;

import controle.ProdutoDAO;
import model.Produto;

public class TesteInserir {

	public static void main(String[] args) {
	   Produto produto = new Produto();
	   produto.setCategoria("Latic�nios");
	   produto.setDescricao("Preto");
	   produto.setNome("Feij�o");
	   produto.setValor(10.00);
	   
	   
	   ProdutoDAO dao = new ProdutoDAO();
	   dao.inserirProduto(produto);
	   
	}

}
