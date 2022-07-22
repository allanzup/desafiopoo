package src.desafioFinal.Menu

import src.desafioFinal.Itens.ItemPedido
import src.desafioFinal.Itens.Lanche
import src.desafioFinal.Itens.Produto
import src.desafioFinal.Pagamento.Pagamento
import kotlin.system.exitProcess

class MenuPrincipal {
    var carrinho = HashMap<Int, ItemPedido>()

    init {
        menuPrincipal()
    }

    private fun menuPrincipal() {
        while (true) {
            mostrarTotal()
            println("---------------- Sincity Ifood-----------------       ")
            println("> Menu principal")
            println("------- Escolha as opções abaixo do menu -------------")
            println("1- Adicionar Lanche")
            println("2- Adicionar Bebida")
            println("3- Finalizar Pedido")
            println("4- Sair do sistema\n")
            val opcao = lerNumero()
            if (opcao == null) {
                continue
            }

            when (opcao) {
                1 -> {
                    this.menuLanche()
                }
                2 -> {
                    this.menuBebidas()
                }
                3 -> {
                    this.menuCarrinho()
                }
                4 -> {
                    exitProcess(0)
                }

                else -> println("Opção invalida. Tente novamente!!!")
            }
        }


    }

    private fun menuLanche() {
        while (true) {
            mostrarTotal()
            println("---------------- SINCITY IFOOD-----------------       ")
            println("> Menu principal > Lanche")
            println("---------------- MENU LANCES -----------------       ")
            println("1- Xsalada")
            println("2- Hamburguer")
            println("3- Voltar\n")
            val opcao = lerNumero()
            if (opcao == null) {
                continue
            }
            when (opcao) {

                1 -> {
                    println("digite a quantidade")
                    var quant = lerNumero()
                    if (quant == null) {
                        continue
                    }
                    val xsalada = Lanche(1, "xsalada", 12.0)
                    adicionarPedido(quant, xsalada)

                }

                2 -> {
                    println("digite a quantidade")
                    var quant = lerNumero()
                    if (quant == null) {
                        continue
                    }
                    val hamburguer = Lanche(2, "hamburguer", 10.0)
                    adicionarPedido(quant, hamburguer)

                }

                3 -> {
                    break
                }
                else -> println("opção invalida")

            }
        }

    }

    private fun menuBebidas() {
        while (true) {
            mostrarTotal()
            println("---------------- SINCITY IFOOD-----------------       ")
            println("> Menu principal > Bebidas")
            println("---------------- MENU LANCES -----------------       ")
            println("1- suco")
            println("2- refrigerante")
            println("3- voltar\n")
            val opcao = lerNumero()
            if (opcao == null) {
                continue
            }
            when (opcao) {
                1 -> {
                    println("digite a quantidade")
                    var quant = lerNumero()
                    if (quant == null) {
                        continue
                    }
                    val suco = Lanche(3, "suco", 6.0)
                    adicionarPedido(quant, suco)

                }

                2 -> {
                    println("digite a quantidade")
                    var quant = lerNumero()
                    if (quant == null) {
                        continue
                    }
                    val refrigerante = Lanche(4, "refrigerante", 8.0)
                    adicionarPedido(quant, refrigerante)

                }
                3 -> {
                    break
                }
                else -> println("opção invalida")
            }
        }
    }

    fun mostrarTotal(): Double {

        println("---------------- CARRINHO -----------------       ")
        var total = 0.0
        for ((k, i) in carrinho) {
            var tot = i.quant * i.produto.valor
            total = total + tot
            println("$k - ${i.quant} ${i.produto.nome} ${i.produto.valor * i.quant}")
        }
        println("Valor total $total")
        return total
    }

    fun getvalortotal(): Double {


        var total = 0.0
        for ((k, i) in carrinho) {
            var tot = i.quant * i.produto.valor
            total = total + tot

        }

        return total
    }

    fun menuCarrinho() {
        while (true) {
            mostrarTotal()
            println("---------------- SINCITY IFOOD-----------------       ")
            println("> Menu principal > Carrinho")
            println("---------------- MENU LANCES -----------------       ")
            println("1- Incluir mais itens")
            println("2- remover item")
            println("3- Editar item")
            println("4- Pagar")
            println("5- Voltar")
            val opcao = lerNumero()
            if (opcao == null) {
                continue
            }
            when (opcao) {
                1 -> {
                    break
                }

                2 -> {
                    println("digite o codigo do produto a ser removido")
                    val produtoRemovido = lerNumero()
                    if (produtoRemovido == null) {
                        continue
                    }
                    if (produtoRemovido in carrinho) {
                        carrinho.remove(produtoRemovido)
                    } else (println("código nao encontrado!!! "))
                }
                3 -> {
                    println("digite o codigo do produto a ser alterado")
                    val produtoAlterado = lerNumero()
                    if (produtoAlterado == null) {
                        continue
                    }
                    if (produtoAlterado in carrinho) {
                        println("digite a nova quantidade do produto")
                        val novaQuantidade = lerNumero()
                        if (novaQuantidade == null) {
                            continue
                        }
                        val produtoencontrado = carrinho.get(produtoAlterado)
                        if (produtoencontrado != null) {
                            produtoencontrado.quant = novaQuantidade
                        }

                    } else (println("código nao encontrado!!! "))
                }
                4 -> {
                    println("redirecionando para pagamento")
                    if (Pagamento(this).escolherPagamento()) {
                        break
                    }
                }
                5 -> {
                    break
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


