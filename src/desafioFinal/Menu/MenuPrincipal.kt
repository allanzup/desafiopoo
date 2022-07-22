package src.desafioFinal.Menu

import src.desafioFinal.Itens.ItemPedido
import src.desafioFinal.Itens.Lanche
import src.desafioFinal.Itens.Produto
import kotlin.math.absoluteValue
import kotlin.reflect.typeOf
import kotlin.test.assertIs

class MenuPrincipal {
    var carrinho = HashMap<Int, ItemPedido>()

    init {
        menuPrincipal()
        menuCarrinho()
    }

    private fun menuPrincipal() {
        while (true) {

            println("---------------- Sincity Ifood-----------------       ")
            println("")
            println("------- Escolha as opções abaixo do menu -------------")
            println("")
            println("1- Lanches")
            println("")
            println("2- Bebidas")
            val opcao = lerNumero()
            if (opcao==null){
                continue
            }

            when (opcao) {
                1 -> {
                    this.menuLanche()
                    return
                }
                2 -> {
                    this.menuBebidas()
                    return
                }

                else -> println("Opção invalida. Tente novamente!!!")
            }
        }


    }

    private fun menuLanche() {
        while (true) {
            println("---------------- SINCITY IFOOD-----------------       ")
            println("")
            println("---------------- MENU LANCES -----------------       ")
            println("1- Xsalada")
            println("2- Hamburguer")
            val opcao = lerNumero()
            if (opcao==null){continue}
            when (opcao) {

                1 -> {
                    println("digite a quantidade")
                    var quant = lerNumero()
                    if (quant==null){continue}
                    val xsalada = Lanche(1, "xsalada", 12.0)
                    adicionarPedido(quant, xsalada)
                    return
                }

                2 -> {
                    println("digite a quantidade")
                    var quant = lerNumero()
                    if (quant==null){continue}
                    val hamburguer = Lanche(2, "hamburguer", 10.0)
                    adicionarPedido(quant, hamburguer)
                    return
                }
                else -> println("opção invalida")

            }
        }

    }

    private fun menuBebidas() {
        while (true) {
            println("Sincity Ifood")
            println("1- suco")
            println("2- refrigerante")
            val opcao = lerNumero()
            if (opcao==null){continue}
            when (opcao) {
                1 -> {
                    println("digite a quantidade")
                    var quant = lerNumero()
                    if (quant==null){continue}
                    val suco = Lanche(3, "suco", 6.0)
                    adicionarPedido(quant, suco)
                    return
                }

                2 -> {
                    println("digite a quantidade")
                    var quant = lerNumero()
                    if (quant==null){continue}
                    val refrigerante = Lanche(4, "refrigerante", 8.0)
                    adicionarPedido(quant, refrigerante)
                    return
                }
                else -> println("opção invalida")
            }
        }
    }

    fun mostrarTotal(): Double {
        var total = 0.0
        for ((k, i) in carrinho) {
            var tot = i.quant * i.produto.valor
            total = total + tot
            println("$k - ${i.quant} ${i.produto.nome} ${i.produto.valor * i.quant}")
        }
        println("Valor total $total")
        return total
    }

    fun menuCarrinho() {
        while (true) {
            mostrarTotal()
            println("Sincity Ifood")
            println("1- Incluir mais itens")
            println("2- remover item")
            println("3- para pagar")
            println("4- Editar item")
            val opcao = lerNumero()
            if (opcao==null){continue}
            when (opcao) {
                1 -> {
                    this.menuPrincipal()
                }

                2 -> {
                    println("digite o codigo do produto a ser removido")
                    val produtoRemovido = lerNumero()
                    if (produtoRemovido==null){continue}
                    if (produtoRemovido in carrinho) {
                        carrinho.remove(produtoRemovido)
                    } else (println("código nao encontrado!!! "))
                    this.menuCarrinho()

                }
                3 -> return
                4 -> {
                    println("digite o codigo do produto a ser alterado")
                    val produtoAlterado = lerNumero()
                    if (produtoAlterado==null){continue}
                    if (produtoAlterado in carrinho) {
                        println("digite a nova quantidade do produto")
                        val novaQuantidade = lerNumero()
                        if (novaQuantidade==null){continue}
                        val produtoencontrado = carrinho.get(produtoAlterado)
                        if (produtoencontrado != null) {
                            produtoencontrado.quant = novaQuantidade
                        }

                    } else (println("código nao encontrado!!! "))
                    this.menuCarrinho()
                }
                else -> println("opção invalida tente novamente")
            }
        }

    }

    fun adicionarPedido(quant: Int, produto: Produto) {
        var itemPedido1: ItemPedido = ItemPedido(quant, produto)
        val itemPedidoanterior = carrinho.get(produto.cod)
        if (itemPedidoanterior != null) {
            itemPedido1.quant += itemPedidoanterior.quant
        }
        carrinho.put(produto.cod, itemPedido1)

//        this.menuCarrinho()
        return
    }

    fun fazerpagamento() {
        println("redirecionando para pagamento")

    }

    fun lerNumero(): Int? {
        var numero: Int?
        try {
            numero = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele")
            numero = null
        }

        return numero

    }
}


