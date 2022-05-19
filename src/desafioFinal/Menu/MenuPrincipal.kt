package src.desafioFinal.Menu

import src.desafioFinal.Itens.ItemPedido
import src.desafioFinal.Itens.Lanche
import src.desafioFinal.Itens.Produto

class MenuPrincipal {
    var carrinho = HashMap<Int, ItemPedido>()

    init {
        menuPrincipal()
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
            val opcao = readln().toIntOrNull()
            when (opcao) {
                1 -> {
                    this.menuLanche()

                }
                2 -> {
                    this.menuBebidas()

                }
                else -> println("opção invalida")
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
            val opcao = readln().toIntOrNull()
            when (opcao) {

                1 -> {
                    println("digite a quantidade")
                    var quant = readln().toIntOrNull() ?: 0
                    val xsalada = Lanche(1, "xsalada", 12.0)
                    adicionarPedido(quant, xsalada)
                }

                2 -> {
                    println("digite a quantidade")
                    var quant = readln().toIntOrNull() ?: 0
                    val hamburguer = Lanche(2, "hamburguer", 10.0)
                    adicionarPedido(quant, hamburguer)

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
            val opcao = readln().toIntOrNull()
            when (opcao) {
                1 -> {
                    println("digite a quantidade")
                    var quant = readln().toIntOrNull() ?: 0
                    val suco = Lanche(3, "suco", 6.0)
                    adicionarPedido(quant, suco)

                }

                2 -> {
                    println("digite a quantidade")
                    var quant = readln().toIntOrNull() ?: 0
                    val refrigerante = Lanche(4, "refrigerante", 8.0)
                    adicionarPedido(quant, refrigerante)
                }
                else -> println("opção invalida")
            }
        }
    }

    fun menuCarrinho() {
        var total = 0.0
        for ((k, i) in carrinho) {
            var tot = i.quant * i.produto.valor
            total = total + tot
            println("$k - ${i.quant} ${i.produto.nome} ${i.produto.valor * i.quant}")
        }
        println("Valor total $total")
        println("Sincity Ifood")
        println("1- Incluir mais itens")
        println("2- remover item")
        val opcao = readln().toIntOrNull()
        when (opcao) {
            1 -> {
                this.menuPrincipal()
            }

            2 -> {
                println("digite o codigo do produto a ser removido")
                val produtoRemovido = readln().toIntOrNull()
                carrinho.remove(produtoRemovido)
                this.menuCarrinho()
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

        this.menuCarrinho()
    }
}


