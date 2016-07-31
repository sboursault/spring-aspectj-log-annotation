# spring-aspectj-log-annotation

This project demonstrates how to create a ```@LogInfo``` annotation which you can use as a kind of sensor over a method.

**Example :**

```java
@LogInfo("'Calling test method with ' + #input1 + ' and ' + #input2 ")
public void testMethodWithAnnotation(String input1, String input2) {
   // do stuff
}
```

The mechanism is based on spring and aspectj, so it can't be used on private methods.

The annotation value is in SpEL, so you can use computations, accessors, etc.

**Example :**

```java
@LogInfo("'Calling test method with ' + #entity.code ")

```