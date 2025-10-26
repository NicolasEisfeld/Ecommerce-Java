package dev.nicolas.ecommercesistema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.nicolas.ecommercesistema.models.ProdutoModel;
import dev.nicolas.ecommercesistema.repositories.ProdutoRepository;

import java.util.Optional;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastrarProduto(ProdutoModel produto) {
        ModelAndView mv = new ModelAndView("administrativo/produtos/cadastro");
        mv.addObject("produto", produto);
        return mv;
    }

    @PostMapping("/salvarProduto")
    public ModelAndView salvarProduto(ProdutoModel produto) {
        produtoRepository.save(produto);
        return cadastrarProduto(new ProdutoModel());
    }

    @GetMapping("/listarProdutos")
    public ModelAndView listarProdutos() {
        ModelAndView mv = new ModelAndView("administrativo/produtos/lista");
        mv.addObject("produtos", produtoRepository.findAll());
        return mv;
    }

    @GetMapping("editarProduto/{id}/")
    public ModelAndView editarProduto(Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        return cadastrarProduto(produto.get());
    }

    @GetMapping("removerProduto/{id}/")
    public ModelAndView removerProduto(Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        produtoRepository.delete(produto.get());
        return cadastrarProduto(produto.get());
    }
}