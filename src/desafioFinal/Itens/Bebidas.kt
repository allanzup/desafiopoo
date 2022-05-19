package src.desafioFinal.Itens

class Bebidas(cod: Int, nome: String, valor: Double) : Produto(cod, nome, valor) {
    fun adicionarrefrigerante() {
        var refrigerante: Bebidas = Bebidas(cod, nome, valor)
        refrigerante.nome = "refrigerante"
        refrigerante.valor = 12.0
        println("digite a quantidade")
        var quant = readln().toInt()

        var carrinho = arrayListOf<ItemPedido>()

        var itemPedido1: ItemPedido = ItemPedido(quant, refrigerante)
        carrinho.add(itemPedido1)



        for (i in carrinho) {
            println("${i.quant} ${i.produto.nome} ${i.produto.valor * i.quant}")
        }
    }
    fun adicionarsucos() {
        var sucos: Bebidas = Bebidas(cod, nome, valor)
        sucos.nome = "suco"
        sucos.valor = 12.0
        println("digite a quantidade")
        var quant = readln().toInt()

        var carrinho = arrayListOf<ItemPedido>()

        var itemPedido1: ItemPedido = ItemPedido(quant, sucos)
        carrinho.add(itemPedido1)



        for (i in carrinho) {
            println("${i.quant} ${i.produto.nome} ${i.produto.valor * i.quant}")
        }
    }
}