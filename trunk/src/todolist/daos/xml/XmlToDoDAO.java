package todolist.daos.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

import todolist.ToDo;
import todolist.User;
import todolist.daos.ToDoDAO;


public class XmlToDoDAO implements ToDoDAO{
	
	private Document doc;
	private Node root;
	private File file;
	private static XmlToDoDAO instance;
	
	private XmlToDoDAO(File f) {
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
	
	public static XmlToDoDAO getInstance(File f){
		synchronized (XmlToDoDAO.class) {
			 if (instance == null) 
				 instance = new XmlToDoDAO(f);
			 return instance;
		 }
	}
	
	public void close() {
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
	
	private ToDo makeToDo (Element el) {
		ToDo todo = new ToDo(el.getAttribute("User"), el.getAttribute("Date"), 
				el.getAttribute("Name"), el.getAttribute("Priority"),
				el.getAttribute("Description"), Boolean.parseBoolean(el.getAttribute("Done")));
				
		return todo;
	}

	@Override
	public void update (ToDo newToDo) {
		NodeList nl = root.getChildNodes();
		Element el;
		for (int i=0; nl.item(i)!=null; i++) {
			el=(Element) nl.item(i);
			if ((newToDo.getUser().equals(el.getAttribute("User")) 
					&& newToDo.getName().equals(el.getAttribute("Name")))) {
				el.setAttribute("Date", newToDo.getDate());
				el.setAttribute("Priority", newToDo.getPriority());
				el.setAttribute("Description", newToDo.getDescription());
				el.setAttribute("Done", newToDo.isDone().toString());
				return;
			}
		}
	}

	@Override
	public void create(ToDo newInstance) {
		Element el = doc.createElement("ToDo");
		el.setAttribute("User", newInstance.getUser());
		el.setAttribute("Date", newInstance.getDate());
		el.setAttribute("Name", newInstance.getName());
		el.setAttribute("Priority", newInstance.getPriority());
		el.setAttribute("Description", newInstance.getDescription());
		el.setAttribute("Done", newInstance.isDone().toString());
		
		root.appendChild(el);
		
	}

	@Override
	public void delete(ToDo object) {
		NodeList nl = root.getChildNodes();
		Element el;
		for (int i=0; nl.item(i)!=null; i++) {
			el=(Element) nl.item(i);
			if ((object.getUser().equals(el.getAttribute("User")) 
					&& object.getName().equals(el.getAttribute("Name")))) {
				root.removeChild(el);
				return;
			}
		}
		
	}

	@Override
	public ArrayList<ToDo> get(User user) {
		ArrayList<ToDo> list = new ArrayList<ToDo>(); 
		NodeList nl = root.getChildNodes();
		Element el;
		for (int i=0; nl.item(i)!=null; i++) {
			el=(Element) nl.item(i);
			if (user.getLogin().equals(el.getAttribute("User"))) {
				ToDo toDo = makeToDo(el);
				list.add(toDo);				
			}
		}
		return list;
	}
}
