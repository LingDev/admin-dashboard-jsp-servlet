package data;

import java.sql.Connection;

public interface ConnectionPool {

	Connection getConnection();
	void shutdown();
}
