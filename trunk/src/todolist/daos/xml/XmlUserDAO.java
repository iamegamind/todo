package todolist.daos.xml;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import todolist.User;
import todolist.daos.UserDAO;


public class XmlUserDAO
implements UserDAO {
	

	public static XmlUserDAO instance;
	private Document doc;
	private Node root;
	private File file;
	private XmlUserDAO(File f) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			file = f;
			doc = db.parse(file);
			root = doc.getFirstChild();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static XmlUserDAO getInstance(File f) {
		synchronized (XmlUserDAO.class) {
			 if (instance == null) 
				 instance = new XmlUserDAO(f);
			 return instance;
		 }
}
	
	public void close(){
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult();
	        result.setSystemId(file);
	        transformer.transform(source, result);	
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	
	private User makeUser (Element el) {
		return (new User(el.getAttribute("name"), el.getAttribute("login"), 
				el.getAttribute("password")));
			
	}

	@Override
	public void create(User newInstance) {
		Element n = doc.createElement("User");
		
		n.setAttribute("login", newInstance.getLogin());
		n.setAttribute("password", newInstance.getPassword());
		n.setAttribute("name", newInstance.getName());

		root.appendChild(n);
		
	}

	@Override
	public void delete(User object) {
		NodeList nl = root.getChildNodes();
		Element el;
		for (int i=0; nl.item(i)!=null; i++) {
			el=(Element) nl.item(i);
			if (object.getLogin().equals(el.getAttribute("login"))) {
					root.removeChild(el);
					return;
			}
		}
	}

	@Override
	public User get(String key) {
		NodeList nl;
		if (root != null)
			nl = root.getChildNodes();
		else
			nl = new NodeList() {
				
				@Override
				public Node item(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public int getLength() {
					// TODO Auto-generated method stub
					return 0;
				}
			};
		Element el;
		for (int i=0; nl.item(i)!=null; i++) {
			el=(Element) nl.item(i);
			if (key.equals(el.getAttribute("login"))) {
				return makeUser(el);			
			}
		}
		return null;
	}

	@Override
	public void update(User newInstance) {
		NodeList nl = root.getChildNodes();
		Element el;
		for (int i=0; nl.item(i)!=null; i++) {
			el=(Element) nl.item(i);
			if (newInstance.getLogin().equals(el.getAttribute("login"))) {
					el.setAttribute("name", newInstance.getName());
					el.setAttribute("password", newInstance.getPassword());
					return;
			}
		}
		
	}

}

