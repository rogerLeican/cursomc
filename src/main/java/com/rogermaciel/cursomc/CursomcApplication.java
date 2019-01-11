package com.rogermaciel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rogermaciel.cursomc.domain.Categoria;
import com.rogermaciel.cursomc.domain.Cidade;
import com.rogermaciel.cursomc.domain.Cliente;
import com.rogermaciel.cursomc.domain.Endereco;
import com.rogermaciel.cursomc.domain.Estado;
import com.rogermaciel.cursomc.domain.Produto;
import com.rogermaciel.cursomc.domain.enums.TipoCliente;
import com.rogermaciel.cursomc.repositories.CategoriaRepository;
import com.rogermaciel.cursomc.repositories.CidadeRepository;
import com.rogermaciel.cursomc.repositories.ClienteRepository;
import com.rogermaciel.cursomc.repositories.EnderecoRepository;
import com.rogermaciel.cursomc.repositories.EstadoRepository;
import com.rogermaciel.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository  produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00 );
		Produto p3 = new Produto(null,"Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));	
		
		Estado est1 = new Estado(null,"Santa Catarina");
		Estado est2 = new Estado(null,"Rio Grande do Sul");		
		
		Cidade cid1 = new Cidade(null,"Imbituba", est1);
		Cidade cid2 = new Cidade(null, "Porto Alegre", est2);		
		Cidade cid3 = new Cidade(null,"Sapucaia do Sul", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente c1 = new Cliente(null,"Roger","roger.maciel@gmail.com","022.022.022-82", TipoCliente.PESSOAFISICA);   
		
		c1.getTelefones().addAll(Arrays.asList("3333-3333","2222-2222"));
		
		Endereco end1 = new  Endereco(null, "Av Assis Brasil", 1400,"casa", "Sarandi", "91140300", c1, cid1);
		Endereco end2 = new  Endereco(null, "Rua Pinheiro Machado", 145,"casa", "Dihel", "99809-030", c1, cid2);
		
		c1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(c1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

	}

}

