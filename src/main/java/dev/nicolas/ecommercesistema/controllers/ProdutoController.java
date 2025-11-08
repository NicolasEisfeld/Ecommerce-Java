package dev.nicolas.ecommercesistema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.nicolas.ecommercesistema.config.Routes;
import dev.nicolas.ecommercesistema.models.ProdutoModel;
import dev.nicolas.ecommercesistema.repositories.ProdutoRepository;

import java.util.Optional;

@Controller
@RequestMapping(Routes.ADMIN)
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastrarProduto(ProdutoModel produto) {
        ModelAndView mv = new ModelAndView("administrativo/produtos/cadastro");
        mv.addObject("produto", produto);
        return mv;
    }

    @PostMapping("/salvarProduto")
    public ModelAndView salvarProduto(ProdutoModel produto) {
        produtoRepository.save(produto);
        return new ModelAndView("redirect:" + Routes.ADMIN_LISTAR_PRODUTOS);
    }

    @GetMapping("/listarProdutos")
    public ModelAndView listarProdutos() {
        ModelAndView mv = new ModelAndView("administrativo/produtos/lista");
        mv.addObject("produtos", produtoRepository.findAll());
        mv.addObject("produto", new ProdutoModel());
        return mv;
    }

    @GetMapping("/editarProduto/{id}/")
    public ModelAndView editarProduto(@PathVariable("id") Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return cadastrarProduto(produto.get());
        }

        return listarProdutos();
    }

    @GetMapping("/removerProduto/{id}/")
    public ResponseEntity<Void> removerProduto(@PathVariable("id") Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        produto.ifPresent(produtoRepository::delete);
        return ResponseEntity.ok().build();
    }


    @GetMapping("")
    public String acessarPrincipal() {
        return "administrativo/painel";
    }
}