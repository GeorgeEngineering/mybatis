<h3>MyBatis Application</h3>

MyBatis Application for practicing purposes.

---

<h4>A few git commands</h4>

Download the commits, files, and refs from the remote repository into your local repository. 

`git fetch`

Show the working directory/tree status. 

`git status`

Show changes in the working directory/tree. 

`git diff`

Add file contents/changes from the working directory to the staging area.

`git add --all`

`git add README.md`

Record changes to the repository.

`git commit -m "Adding the initial project structure and mock data."`

Update remote refs along with associated objects. In other words, you push the content from local repository to the remote repository. 

`git push`

---

<h4>Common Errors</h4>
<h5>Invalid Username in the Application Properties</h5>
Error:

`java.sql.SQLException: Access denied for user 'engin'@'localhost' (using password: NO)`

Solution:
In the application.properties, set the datasource username property from:

`spring.datasource.username=`
to: 

`spring.datasource.username=root`

The default username in MySQL/XAMPP is root.

<h5>Wrong Casing in the Mapper</h5>
Error:

`org.apache.ibatis.reflection.ReflectionException: There is no getter for property named 'DESCRIPTION' in 'class com.george.engineering.myBatis.model.Task'`

Solution:
Change the casing from uppercase to lowercase (as defined in the modal object). 

`@Insert("INSERT INTO TASK(DESCRIPTION,PRIORITY) VALUE(#{DESCRIPTION},#{PRIORITY})")`

to:

`@Insert("INSERT INTO TASK(DESCRIPTION,PRIORITY) VALUE(#{description},#{priority})")`

<h5>Column Size is too Small</h5>
Error:

`Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column 'description' at row 1`

Solution:
The column size is too small and needs to be increased. Change: 

`description varchar(100) NOT NULL`

to:

`description varchar(255) NOT NULL`