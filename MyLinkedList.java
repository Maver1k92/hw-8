public class MyLinkedList<E> implements Method<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public MyLinkedList() {
        lstNode = new Node<E>(null, fstNode, null);
        fstNode = new Node<E>(null, null, lstNode);
    }

    @Override
    public void add(E e) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(e);
        lstNode = new Node<>(null, prev, null);
        prev.setNextElement(lstNode);
        size++;
    }

    @Override
    public E remove(int index) {
        if (size > 0 && index - 1 < size) {
            Node<E> node = fstNode.nextElement;

            if (index == 0) {
                fstNode.nextElement = node.nextElement;
                node.nextElement.prevElement = fstNode;
            } else if (index > 0) {
                for (int i = 0; i < index; i++) {
                    node = node.nextElement;
                }
                if (size > 1){
                    node.prevElement.nextElement = node.nextElement;
                    node.nextElement.prevElement = node.prevElement;
                }
            }
            size--;
            return node.currentElement;
        }
        throw new NegativeArraySizeException("This list is empty");
    }

    @Override
    public void clear() {
        lstNode = null;
        fstNode = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElement(int index) {
        Node<E> target = fstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }

    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        public Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }
}
