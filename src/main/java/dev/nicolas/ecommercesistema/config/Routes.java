package dev.nicolas.ecommercesistema.config;

public final class Routes {
    // Rotas base
    public static final String ADMIN = "/administrativo";

    // Rotas de produtos
    public static final String ADMIN_PRODUTOS = ADMIN + "/produtos";
    public static final String ADMIN_CADASTRO_PRODUTO = ADMIN + "/cadastroProduto";
    public static final String ADMIN_SALVAR_PRODUTO = ADMIN + "/salvarProduto";
    public static final String ADMIN_LISTAR_PRODUTOS = ADMIN + "/listarProdutos";
    public static final String ADMIN_EDITAR_PRODUTO = ADMIN + "/editarProduto";
    public static final String ADMIN_REMOVER_PRODUTO = ADMIN + "/removerProduto";

    // Rotas de usuários
    public static final String ADMIN_USUARIOS = ADMIN + "/usuarios";

    private Routes() {
        throw new AssertionError("Esta classe não deve ser instanciada");
    }
}