package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
private final int maxSize;
private LinkedHashMap<String, Connection> connectionsMap;

public ConnectionPool(int size) {
    this.maxSize = size;
    connectionsMap = new LinkedHashMap<>(size * 2, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Connection> eldestEntry) {
            return size() > maxSize; 
        }
    };
}
public void addConnection(Connection connection) {
    String id = connection.connectionId();
    if (connectionsMap.containsKey(id)) {
        throw new IllegalStateException("Connection already exists with id: " + id);
    }
    connectionsMap.put(id, connection);
}

public Connection getConnection(String connectionId) {
    if (!connectionsMap.containsKey(connectionId)) {
        throw new NoSuchElementException("No connection found with id: " + connectionId);
    }
    return connectionsMap.get(connectionId); 
    }
}