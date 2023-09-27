public class Main {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.add(10);
        arvore.add(5);
        arvore.add(15);
        arvore.add(3);
        arvore.add(7);
        arvore.add(20);
        arvore.add(12);


        System.out.println("1 - Árvore Ordenada:");
        arvore.imprimirArvore();


        int valor = 2;
        boolean contemValor = arvore.contarNode(valor);
        System.out.println("2 - A árvore contém o valor " + valor + " ? " + contemValor);

        arvore.deletar(5);

        System.out.println("4 - Árvore após a remoção ou não, de um node.:");

        arvore.imprimirArvore();
    }
}