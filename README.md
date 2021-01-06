# Mapping
<p>
<img src="https://user-images.githubusercontent.com/15355551/103802585-a96c0800-504f-11eb-9678-74d0e6c2f86a.png" width="50%" height=50%">
</p>

Mapping is a library to transform an object to another:
```java
@Map
@MapPartner(User.class)
public class Person {
  private String name;
  private int age;
  
  // getter/setter...
}

public class User {
  private String name;
  private int age;
  
  // getter/setter...
}

// The code to transform a Person to a User:
ToUser.map(new Person());

// The code to transform a User to a Person:
ToPerson.map(new User());
```
### How does it work?
Mapping generates two utility classes for each `MapPartner` annotation it finds. The generation happens with each build and results in something like this:
```java
public class ToPerson {
  private ToPerson() {}
  
  public static Person map(final User user) {
    final Person result = new Person();
    result.setName(user.getName());
    result.setAge(user.getAge());
    return result;
  }
}
```
After building your project, you can actually check your targets folder to see what classes got generated. They are quite simple to understand and there isn't that much magic involved here.  

### What about the other object mapping libraries?
There are different other object mapping libraries like [JMapper](https://github.com/jmapper-framework/jmapper-core), [MapStruct](https://github.com/mapstruct/mapstruct), [Dozer](https://github.com/DozerMapper/dozer), [Selma](https://github.com/xebia-france/selma), [Orika](https://github.com/orika-mapper/orika) or [ModelMapper](https://github.com/modelmapper/modelmapper).  
  
These libraries lack some characteristics:  
- some of them don't support mapping by using annotations in one of the classes that need to be mapped. MapStruct and Selma for example use interfaces instead:  
```java
public interface PersonUserMapper {
  @Mapping(source = "name", target = "firstName")
  Person toPerson(User user);
}
```
Personally, I prever to have the mapping information directly in the class, because this way I reduce the probability of forgetting a field. I don't want to have additional interfaces
- some of them don't support inheritance  
- some of them are dead or almost dead  
- some (at least JMapper) use bytecode manipulation to generate the mapping code. This works great until it doesn't  

### How to use it
TODO
