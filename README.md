# PoC-SpringBootServer

## JDBC
Java Database Connectivity

자바에서 DB를 다루기 위하여 필요한 API

플로우는 개인적으로 중요하다 생각하는 4단계로 나누었음.

### 1. Connection
사용하고 있는 JDBC와 DB를 연결하는 과정.
해당 프로젝트에는 Dao의 *Connection에 구현이 되어있다.

이 과정은 db 드라이버를 로드해오는 것과 Connection을 생성하는 것으로 나누어진다.

먼저 드라이버를 로드해보자.

드라이버를 로드하기 위하여 먼저 사용하고자 하는 DB의 드라이버의 Dependency를 가져와준다. 
이번 프로젝트는 postgres를 사용하고 있으므로 build.gradle에 다음과 같이 지정해준다.
`runtimeOnly 'org.postgresql:postgresql'`

그리고 해당하는 드라이버를 사용하기 위하여 다음과 같이 클래스로 로드해준다.
`Class.forName("org.postgresql.Driver");`

드라이버의 로드가 끝났으므로 Connection을 생성해보자.

Connection을 위하여는 흔히 생각하는 접근을 위한 정보가 필요하다.
URL, username, password

이를 위하여 다음과 같이 지정해준다.
```java
// 연결 정보 입력
String dburl = "jdbc:postgresql://localhost:5433/test_db";
String username = "user";
String password = "1234";
```

이 정보를 이용하여 connection을 만들어주면 된다.  
`Connection conn = DriverManager.getConnection(dburl, username, password);`

### 2. STMT
이제 연결을 하였으니 DB에 동작을 지정하기 위하여 stmt를 작성해야 한다.

디비의 동작이므로 쿼리로 작성을 할 수 있다.
```java
String sql = "INSERT INTO EXERCISE(TITLE, DIFFICULTY, CREATOR, VIDEO_LENGTH, DESCRIPTION) VALUES(?,?,?,?,?)";
PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

stmt.setString(1, exercise.getTitle());
stmt.setString(2, exercise.getDifficulty());
stmt.setString(3, exercise.getCreator());
stmt.setInt(4, exercise.getVideoLength());
stmt.setString(5, exercise.getDescription());
```
위와 같이 지정을 할 수 있는데, 위 sql문에서 ?부분을 set*를 이용하여 stmt를 채워준다 생각하면 된다.

이렇게 내릴 명령을 지정했다면 다음 코드를 통해 보낼 수 있다.

`stmt.executeUpdate();`

### 3. ResultSet
stmt의 결과로 ResultSet(rs)를 받았다.

이를 가공하여 원하는 형태로 만들 수 있다.
ExerciseDaoImpl에 구현되어있다.

이때 rs가 하나도 없을 때 예가 발생하므로 예외처리를 해주어야 한다.외

### 4. close
잘 사용했다면 사용한 connection / stmt / rs 등등의 인스턴스를 반환해주자.

이렇게 커넥션 풀에 잘 반환을 해주어야 오류가 나지 않고 사용할 수 있다.

반환을 제대로 안해주면 공용우산과도 같은 커넥션 풀을 볼 수 있을 것이다.

