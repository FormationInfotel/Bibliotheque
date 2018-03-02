import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Author;
import com.infotel.formation.interfaces.AuthorDAO;

@Repository
@Transactional
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Customer getCustomer(String customerName) {
		Query<Customer> query = sessionFactory.getCurrentSession()
				.createQuery("from Customer where name = :CustomerName");
		query.setParameter("name", customerName);
		return (Customer) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		List<Customer> result = (List<Customer>) sessionFactory.getCurrentSession().createQuery("from Customer").list();
		return result;
	}

	@Override
	public void insertAuthor(Author author) {
		sessionFactory.getCurrentSession().save(author);
	}

	@Override
	public Author getAuthorById(int authorId) {
		Author authorById = null;

		for (Author author : getAuthors()) {
			if (author != null && author.getAuthor_id() != null && author.getAuthor_id().equals(authorId)) {
				authorById = author;
				break;
			}
		}

		if (authorById == null) {
			throw new IllegalArgumentException("No product found with the product id : " + customerID);
		}
		return authorById;
	}

	@Override
	public Author getAuthor(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

}
