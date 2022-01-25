public interface HashMapMethods<K, V> extends Iterable<V> {
   boolean put(K key , V value);// добавляю пару ключ + значение
   boolean remove(K key);//удаляю пару по ключу
   void clear();//очищаю коллекцию
   int size();// размер коллекции
   V get(K key);// возвращаю значение (value)  по ключу key
}
