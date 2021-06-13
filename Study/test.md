### Mock / Spy

**Test Double**  
스턴트맨 == 스턴트 더블  
비슷하게 어떠한 객체를 대신해주는 객체

비슷하게 동작하지만, 개인적인 생각으로 둘을 구분하는 큰 차이점은 정의되지 않은 동작에 대한 처리 방법이라 생각함.

- Mock  
정의되지 않은 동작에 대하여 아무것도 하지 않음. (NULL을 반환하거나 오류를 반환하기도 함.)
  
- Spy
정의되지 않은 동작에 대하여 원래 객체에 행동을 함.
  
### Mockito
단위테스트를 위한 Java Framework

1. JUnit과 연동
`@ExtendWith(MockitoExtension.class)`를 사용하여 연동할 수 있다.  
이렇게 사용하게 된다면, JUnit 내에서 Mockito의 편리한 로직들을 사용할 수 있다.
   
2. Mock 객체를 inject
```
@Mock
private ExerciseDao exerciseDao;

@InjectMocks
private ExerciseRouteService service;
```
위의 코드와 같이 Mocking할 객체를 @Mock 어노테이션을, inject할 객체를 @InjectMocks 어노테이션으로 감싸서 주입을 해준다.

3. Mock 행동 정의
```java
BDDMockito.given(exerciseDao.create(Mockito.any())).willReturn(expected);
```
행동을 정의해준다. given 내부에 들어간 행동에 대하여 willReturn으로 정의해주었는데, 
create의 매개변수를 any로 해주어 어떠한 값이 들어오던 expected를 반환하도록 해주었다.
