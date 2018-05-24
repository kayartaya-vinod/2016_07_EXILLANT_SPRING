package training.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

public class ContactsDaoJdbcImpl implements ContactsDao {

	// fields (private member variables)
	private String driver;
	private String url;
	private String username;
	private String password;

	// a connection that spring can inject
	private Connection connection;
	// a connection pool
	private DataSource dataSource;

	public ContactsDaoJdbcImpl() {
		System.out.println("Inside constructor, dataSource = " + dataSource);
	}

	// @PostConstruct
	public void doSomethingInTheStart() {
		System.out.println("Inside the doSomethingInTheStart()..., dataSource = " + dataSource);
	}

	public ContactsDaoJdbcImpl(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	// spring never needs this
	// property (readable/accessor) called as "driver"
	public String getDriver() {
		return driver;
	}

	// spring uses this to set (inject) the values
	// property called "driver", writable aka mutator
	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		if (dataSource != null) {
			return dataSource.getConnection();
		}

		if (connection != null) {
			return connection;
		}

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	// this is only for spring to do DI (dependency injection)
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	// Purely for spring to do DI
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int getContactsCount() throws DaoException {
		System.out.println("getContactsCount() is inovked using an object of type: " + this.getClass().getName());
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "select count(*) from contacts";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			throw new DaoException("Something went wrong!");
		} catch (SQLException | ClassNotFoundException e) {
			throw new DaoException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
	}

	@Override
	public void createContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public void deleteContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public List<Contact> getAllContacts() throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public List<Contact> search(String token) throws DaoException {
		throw new DaoException("Not implemented!");
	}

}
