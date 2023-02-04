package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.ApiOperation;

import com.produtos.apirest.models.Produto;


@RestController
@RequestMapping("/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	
	@ApiOperation(value="Retorna uma lista de produtos")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}

	@PostMapping("/salvar")
	@ApiOperation(value="Cadastro  de um produto")
    @ResponseStatus(HttpStatus.CREATED)
	public Produto salvar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/atualizar")
	@ApiOperation(value="Atualiza dados de um produto")
    @ResponseStatus(HttpStatus.OK)
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/apagar")
	@ApiOperation(value="Deleta um produto da lista")
    @ResponseStatus(HttpStatus.OK)
	public void deletarProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	
}
