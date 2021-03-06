import java.util.*;

public class HashMap<K, V>  implements HashMapMethods<K, V>{

    public static void main(String[] args) {
        HashMap<String, String> strings = new HashMap<>();
        strings.put("a", "b");
        strings.put("c", "d");
        System.out.println(strings.get("a"));
        System.out.println(strings.size);
        //System.out.println(strings.remove("a"));
        //System.out.println(strings.get("a"));
        strings.clear();
        System.out.println(strings.size);
        strings.get("a");
    }

    private Node<K, V>[] hashTable;
    private int size = 0;
    private float threshold;

    public HashMap(){
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;
    }



    private int hash(Node<K, V> node){
        return node.hashCode() % hashTable.length;
    }

    private int hash(final  K key){
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    @Override
    public boolean put(K key, V value) {
        if(size + 1 >= threshold){
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);

        if(hashTable[index] == null){
            return simpleAdd(index, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for(Node<K, V> node : nodeList){
            if(keyExistButValueNew(node,newNode,value) ||
                    collisionProcessing(node, newNode, nodeList)){
                return true;
            }
        }
        return false;
    }

    private boolean simpleAdd(int index, Node<K, V> newNode){
        hashTable[index] = new Node<>(null,null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    private boolean keyExistButValueNew(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final V value){
        if(newNode.hashCode() == nodeFromList.hashCode() &&
                !newNode.getValue().equals(nodeFromList.getValue())){
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    private boolean collisionProcessing(
            final Node<K, V> nodeFromList,
            final Node<K,V> newNode,
            final List<Node<K, V>> nodes){
        if(newNode.hashCode() == nodeFromList.hashCode()&&
                !Objects.equals(newNode.key, nodeFromList.key)&&
                !Objects.equals(newNode.value, nodeFromList.value)){
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    public void arrayDoubling(){
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length *2];
        size = 0;
        for (Node<K, V> node : oldHashTable){
            if(node != null){
                for (Node<K, V> n :node.getNodes()){
                    put(n.key, n.value);
                }
            }
        }
    }

    @Override
    public boolean remove(K key) {
        int index = hash(key);
        if(hashTable[index] == null)
            return false;

        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index] = null ;
            return true;
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for(Node<K, V> node : nodeList){
            if(key.equals(node.getKey())){
                nodeList.remove(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < hashTable.length; i++){
            hashTable[i] = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if(index < hashTable.length &&
                hashTable[index] != null){

            if(hashTable[index].getNodes().size() == 1){
                return hashTable[index].getNodes().get(0).getValue();
            }

            List<Node<K, V>> list = hashTable[index].getNodes();
            for (Node<K, V> node : list){
                if(key.equals(node.getKey())){
                    return node.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int counterArray = 0;
            int valueCounter = 0;
            Iterator<Node<K,V>> subIterator = null;

            @Override
            public boolean hasNext() {
                if(valueCounter ==size)
                    return false;

                if (subIterator ==null || !subIterator.hasNext()){
                    if(moveToNextCell()){
                        subIterator = hashTable[counterArray].getNodes().iterator();
                    }else {
                        return false;
                    }
                }

                return subIterator.hasNext();
            }

            private boolean moveToNextCell(){
                counterArray++;
                while (hashTable[counterArray] == null){
                    counterArray++;
                }
                return hashTable[counterArray] != null;
            }

            @Override
            public V next() {
                valueCounter++;
                return subIterator.next().getValue();
            }
        };
    }

    private class Node<K, V>{
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        private Node(K key, V value){
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        private List<Node<K, V>> getNodes(){
            return nodes;
        }

        private int hash(){
            return hashCode() % hashTable.length;
        }

        private K getKey(){
            return key;
        }

        private V getValue(){
            return value;
        }

        private void setValue(V value){
            this.value = value;
        }

        @Override
        public int hashCode(){
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;

            if(obj instanceof Node){
                Node<K, V> node = (Node) obj ;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash,node.hashCode()));
            }
            return false;
        }
    }
}
