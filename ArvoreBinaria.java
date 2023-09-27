public class ArvoreBinaria {
        Node noRaiz;

    public ArvoreBinaria() {
        this.noRaiz = null;
    }

    public void imprimirArvore() {
        imprimirArvore(noRaiz, "", true);
    }

    private void imprimirArvore(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.valordoNo);
            imprimirArvore(node.noEsquerdo, prefix + (isLeft ? "│   " : "    "), true);
            imprimirArvore(node.noDireito, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    private Node addRecursivoNode(Node nodeAtual, int valordoNo) {
        if (nodeAtual == null) {
            return new Node(valordoNo);
        }

        if (valordoNo < nodeAtual.valordoNo) {
            nodeAtual.noEsquerdo = addRecursivoNode(nodeAtual.noEsquerdo, valordoNo);
        } else if (valordoNo > nodeAtual.valordoNo) {
            nodeAtual.noDireito = addRecursivoNode(nodeAtual.noDireito, valordoNo);
        } else {
            return nodeAtual;
        }

        return nodeAtual;
    }

    public void add(int valordoNo) {
        noRaiz = addRecursivoNode(noRaiz, valordoNo);
    }

    private boolean ContarRecursivoNode(Node nodeAtual, int valordoNo) {
        if (nodeAtual == null) {
            return false;
        }
        if (valordoNo == nodeAtual.valordoNo) {
            return true;
        }
        return valordoNo < nodeAtual.valordoNo
                ? ContarRecursivoNode(nodeAtual.noEsquerdo, valordoNo)
                : ContarRecursivoNode(nodeAtual.noDireito, valordoNo);
    }

    public boolean contarNode(int valordoNo) {
        return ContarRecursivoNode(noRaiz, valordoNo);
    }

    private Node deletarNode(Node nodeAtual, int valordoNo) {
        if (nodeAtual == null) {
            return null;
        }

        if (valordoNo == nodeAtual.valordoNo) {
            if (nodeAtual.noEsquerdo == null) {
                return nodeAtual.noDireito;
            } else if (nodeAtual.noDireito == null) {
                return nodeAtual.noEsquerdo;
            }

            int menorValorNo = encontrarMenorValor(nodeAtual.noDireito);
            nodeAtual.valordoNo = menorValorNo;
            nodeAtual.noDireito = deletarNode(nodeAtual.noDireito, menorValorNo);
        } else if (valordoNo < nodeAtual.valordoNo) {
            nodeAtual.noEsquerdo = deletarNode(nodeAtual.noEsquerdo, valordoNo);
        } else {
            nodeAtual.noDireito = deletarNode(nodeAtual.noDireito, valordoNo);
        }
        return nodeAtual;
    }

    private int encontrarMenorValor(Node noRaiz) {
        return noRaiz.noEsquerdo == null ? noRaiz.valordoNo : encontrarMenorValor(noRaiz.noEsquerdo);
    }

    public void deletar(int valordoNo) {
        System.out.println("3 - Escolha um node para deletar  "+ valordoNo);
        noRaiz = deletarNode(noRaiz, valordoNo);
    }

}
