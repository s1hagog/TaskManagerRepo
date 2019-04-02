package taskManagerPro.db;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters; 
import com.mongodb.client.model.Updates;

import taskManagerPro.entities.Manager;
import taskManagerPro.entities.Project;
import taskManagerPro.entities.Task;
import taskManagerPro.entities.User;

public class MongoDBImpl extends MongoDB implements DBImplInterface{
	
	private MongoDatabase mongoDB = null;
	private MongoClient mongoClient = null;
	private String dbUser = "alex_user";
	private String dbPass = "123qwe";
	private String dbName = "Csis3275";
	//user and password are added directly in connection link
	private String connURI = "mongodb://"
								+ dbUser 
								+ ":" 
								+ dbPass 
								+ "@cluster0-shard-00-00-fc9jq.azure.mongodb.net:27017,cluster0-shard-00-01-fc9jq."
								+ "azure.mongodb.net:27017,cluster0-shard-00-02-fc9jq.azure.mongodb.net:27017/" 
								+ dbName 
								+ "?ssl=true&replicaSet=Cluster0-"
								+ "shard-0&authSource=admin&retryWrites=true";
	
	public void dbOpenConnection() {
		try {
			this.mongoClient = MongoClients.create(this.connURI);
			this.mongoDB = this.mongoClient.getDatabase(this.dbName);	
		} catch (MongoException mx) {
			System.out.println("Error Connecting to database");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
	}

	public void dbCloseConnection() {
		this.mongoClient.close();	
	}
	
	///////////////////////////
	//USERS
	///////////////////////////

	public String getUserPassword(String username) {
		this.dbOpenConnection();
		String userpass = "";
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			org.bson.Document query = (org.bson.Document) collection.find(eq("email",username)).first();
			userpass = query.getString("password");
			
		} catch(MongoException mx) {
			System.out.println("Error getting user password");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		return userpass;
	}

	public User getUser(String userLogin) {
		this.dbOpenConnection();
		User u = new User();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			org.bson.Document query = (org.bson.Document) collection.find(eq("email", userLogin)).first();
			org.bson.Document department = (org.bson.Document)query.get("department");
			u.first_name = query.getString("first_name");
			u.last_name = query.getString("last_name");
			u.email = query.getString("email");
			u.password = query.getString("password");
			u.dept_name = department.getString("name");
			u.dept_desc = department.getString("description");
			if(query.getBoolean("manager") != null) {
				u.isManager = true;
			} else
				u.isManager = false;
			
		} catch(MongoException mx) {
			System.out.println("Error getting user data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		this.dbCloseConnection();
		return u;
	}
	
	public void deleteUser(String username) {
		this.dbOpenConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			collection.deleteOne(eq("email", username));
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}	
		
		this.dbCloseConnection();
		
	}

	public void createUser(User u) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			Document doc = new Document()
					.append("first_name", u.first_name)
					.append("last_name", u.last_name)
					.append("email", u.email)
					.append("password", u.password)
					.append("department", new Document()
							.append("name", u.dept_name)
							.append("description", u.dept_desc));
			collection.insertOne(doc);
					
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}	
		
		
		this.dbCloseConnection();
		
	}

	public void updateUser(User u) {
		this.dbOpenConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			Document update = new Document("$set", new Document()
					.append("first_name", u.first_name)
					.append("last_name", u.last_name)
					.append("email", u.email)
					.append("password", u.password)
					.append("department.name", u.dept_name)
					.append("department.description", u.dept_desc));
			collection.updateOne(eq("email", u.email), update);
					
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}	
		
		
		this.dbCloseConnection();
		
	}
	
	///////////////////////////
	//TASKS
	///////////////////////////


	public List<Task> getTasks(String username) {
		this.dbOpenConnection();
		List<Task> tasks = new ArrayList<Task>();
		//Task instance to write into array
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			org.bson.Document query = (org.bson.Document) collection.find(eq("email",username)).first();
			List<Document> tasksData = (List<Document>)query.get("tasks");
			//tasksdata if null
			if(tasksData !=  null) {
				for(Document taskData : tasksData) {
					Task tempTask = new Task();
	//				tempTask._id = taskData.getInteger("_id");
					tempTask.name = taskData.getString("name");
					tempTask.description = taskData.getString("description");
					tempTask.end_date = taskData.getDate("end_date");
					tempTask.start_date = taskData.getDate("start_date");
					tempTask.status = taskData.getString("status");
					tasks.add(tempTask);
				}
			}
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		this.dbCloseConnection();
		return tasks;
	}

	public void setTaskStatus(String username, String name, String status) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			collection.updateOne(Filters.and(eq("email", username), eq("tasks.name", name)), Updates.set("tasks.$.status", status));
			
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		
	}

	public void deleteTask(String username, String name) {
		this.dbOpenConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			collection.updateOne(Filters.eq("email", username), Updates.pull("tasks", eq("name", name)));
			
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		
	}

	public void createTask(String username, Task task) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			Document doc = new Document("name", task.name)
					.append("description", task.description)
					.append("status", "To do")
					.append("start_date", task.start_date)
					.append("end_date", task.end_date);
			collection.updateOne(Filters.eq("email", username), Updates.push("tasks", doc));
			
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		
	}
	
	/////////////////////
	//PROJECTS
	////////////////////

	public List<User> getUsersFromProject(String projectName) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		List<User> users = new ArrayList<User>();
		//Task instance to write into array
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			FindIterable<Document> query = (FindIterable<Document>) collection.find(eq("project.name", projectName));
		
			for(Document doc : query) {
				org.bson.Document department = (org.bson.Document)doc.get("department");
				System.out.print(department);
				User tempUser = new User();
				tempUser.first_name = doc.getString("first_name");
				tempUser.last_name = doc.getString("last_name");
				tempUser.email = doc.getString("email");
				tempUser.password = doc.getString("password");
				if(department != null) {
					tempUser.dept_name = department.getString("name");
					tempUser.dept_desc = department.getString("description");
				}else {
					tempUser.dept_name = "no department";
					tempUser.dept_desc = "no department";
				}
				users.add(tempUser);
			}
			
		} catch(MongoException mx) {
			System.out.println("Error getting user data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		this.dbCloseConnection();
		return users;

	}

	public List<Project> getProjects(String userName) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		List<Project> projects = new ArrayList<Project>();
		//Task instance to write into array
		
		try {	
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			org.bson.Document query = (org.bson.Document) collection.find(eq("email",userName)).first();
			// null check
			if(query != null) {
				List<Document> projts = (List<Document>)query.get("project");
				for(Document proj : projts) {
					Project tempProject = new Project();
					tempProject.name = proj.getString("name");
					tempProject.description = proj.getString("description");
					//tempProject.phase = proj.getString("status");
					projects.add(tempProject);
				}
			}
			
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		this.dbCloseConnection();
		return projects;

	}

	public List<User> getAllUsers(Manager m) {
		// TODO Auto-generated method stub
		List<User> allUsers = new ArrayList<User>();
		this.dbOpenConnection();
		
		try {	
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			FindIterable<Document> query = (FindIterable<Document>) collection.find(eq("manager", null));
			for(Document doc : query) {
				org.bson.Document department = (org.bson.Document)doc.get("department");
				System.out.println(department);
				User tempUser = new User();
				tempUser.first_name = doc.getString("first_name");
				tempUser.last_name = doc.getString("last_name");
				tempUser.email = doc.getString("email");
				tempUser.password = doc.getString("password");
				if(department != null) {
					tempUser.dept_name = department.getString("name");
					tempUser.dept_desc = department.getString("description");
				}else {
					tempUser.dept_name = "no department";
					tempUser.dept_desc = "no department";
				}
				allUsers.add(tempUser);
			}
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		return allUsers;
	}

	public List<Project> getAllProjects(Manager m) {
		// TODO Auto-generated method stub
		List<Project> allProjects = new ArrayList<Project>();
		this.dbOpenConnection();
		
		try {	
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			FindIterable<Document> query = (FindIterable<Document>) collection.find(eq("manager", true));
			
			for(Document doc : query) {
				List<Document> projects = (List<Document>)doc.get("project");
				for (Document project: projects) {
					System.out.println(project.getString("name"));
					Project tempProject = new Project();
					tempProject.name = project.getString("name");
					allProjects.add(tempProject);
				}
			}
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		return allProjects;
	}

	public void assignUserToProject(User u, Project p) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			Document doc = new Document("name", p.name)
					.append("description", p.description)
					.append("phase", p.phase);
			collection.updateOne(Filters.eq("email", u.email), Updates.push("project", doc));
			
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
	}

	public void assignTaskToUser(User u, Task t) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		
		try {	
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			Document doc = new Document("name", t.name)
					.append("description", t.description)
					.append("status", "To do")
					.append("start_date", t.start_date)
					.append("end_date", t.end_date);
			collection.updateOne(Filters.eq("email", u.email), Updates.push("tasks", doc));
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
	}

	
	//NEVER USED//
	public void addTaskToProject(Task t, Project p) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		
		try {	
			
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
	}

	public List<Task> getTasks(String m_username, Project p) {
		// TODO Auto-generated method stub
		List<Task> tasks = new ArrayList<Task>();
		this.dbOpenConnection();
		
		try {	
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			org.bson.Document query = (org.bson.Document) collection.find(eq("email",m_username)).first();
			List<Document> projects = (List<Document>)query.get("project");
			for(Document project: projects) {
				if(project.getString("name").equals(p.name)) {
					List<Document> _tasks = (List<Document>)project.get("tasks");
					for(Document task: _tasks) {
						Task tempTask = new Task();
						tempTask.name = task.getString("name");
						tempTask.description = task.getString("description");
						tempTask.end_date = task.getDate("end_date");
						tempTask.start_date = task.getDate("start_date");
						tempTask.status = task.getString("status");
						tasks.add(tempTask);
					}
				}
			}
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		return tasks;
	}

	public void createTask(Manager m, Project p, Task task) {
		// TODO Auto-generated method stub
		this.dbOpenConnection();
		
		try {	
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			Document doc = new Document("name", task.name)
					.append("description", task.description)
					.append("status", "To do")
					.append("start_date", task.start_date)
					.append("end_date", task.end_date);
			collection.updateOne(Filters.and(eq("email", m.email), eq("project.name", p.name)), Updates.push("project.$.tasks", doc));
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		
	}

	public void unassignProject(String email, String name) {
		this.dbOpenConnection();
		
		try {
			
			//First unassign the project
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			collection.updateOne(Filters.eq("email", email), Updates.pull("project", eq("name", name)));
			
			//Find all task names related to the project
			List<String> t_names = new ArrayList<String>();
			org.bson.Document query = (org.bson.Document) collection.find(eq("manager",true)).first();
			List<Document> projects = (List<Document>)query.get("project");
			for(Document project: projects) {
				if(project.getString("name").equals(name)) {
					List<Document> _tasks = (List<Document>)project.get("tasks");
					for(Document task: _tasks) {
						String s;
						s = task.getString("name");
						t_names.add(s);
					}
				}
			}
			
			//unassign those tasks aswell
			
			for (String t_name: t_names) {
				collection.updateOne(Filters.eq("email", email), Updates.pull("tasks", eq("name", t_name)));
			}
			
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		
	}

	
	public void createProject(String email, Project p) {
		// TODO Auto-generated method stub
this.dbOpenConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			Document doc = new Document("name", p.name)
					.append("description", p.description)
					.append("phase", "Iteration 1");
			collection.updateOne(Filters.eq("email", email), Updates.push("project", doc));
			
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		
	}



	
	
	

}
